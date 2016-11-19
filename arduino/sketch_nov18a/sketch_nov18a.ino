#include <ESP8266WiFi.h>
#include <WiFiUDP.h>
#include <DHT.h>
#include <BH1750.h>

#define DHTPIN D4
#define DHTTYPE DHT11 
#define LED_OFF D5
#define LED_OFF_2 LED_BUILTIN
#define ID "002"
unsigned int UDPPort = 3000;      // local port to listen on

// sleep for this many seconds
const int sleepSeconds = 10;

char packetBuffer[255]; //buffer to hold incoming packet
char  replyBuffer[255] = "acknowledged";       // a string to send back

WiFiUDP Udp;


DHT dht(DHTPIN, DHTTYPE);

BH1750 lightMeter;

const char* ssid = "DILAB_615";  //  your network SSID (name)
const char* pass = "dilab5541";       // your network password


void setup() {

pinMode(LED_BUILTIN, OUTPUT);     // Initialize the LED_BUILTIN pin as an output
pinMode(D5, OUTPUT);     // Initialize the LED_BUILTIN pin as an output
digitalWrite(LED_BUILTIN,HIGH); 
digitalWrite(D5,  LOW); 

// Connect D0 to RST to wake up
pinMode(0, OUTPUT);
digitalWrite(0, 0);

Serial.begin(9600);
WiFi.begin(ssid, pass);
Serial.println();
Serial.print("Wait for WiFi");

while (WiFi.status() != WL_CONNECTED) {
delay(500);
Serial.print(".");
}
Serial.println("");
Serial.println("WiFi connected");
Serial.println("IP address: " + WiFi.localIP().toString());

Udp.begin(UDPPort);

Udp.beginPacket("155.230.16.138", UDPPort);//send ip to server
char ipBuffer[255];
WiFi.localIP().toString().toCharArray(ipBuffer, 255);
Udp.write(ipBuffer);
Udp.endPacket();
Serial.println("Sent ip adress to server");

dht.begin();
lightMeter.begin();

Serial.println(F("BH1750 Test"));
Serial.println("Running...");
delay(10);


digitalWrite(BUILTIN_LED, LOW);
}


void loop() {
char s[80];
int soilMoistureValue = 0;

float h = dht.readHumidity();
float t = dht.readTemperature();

uint16_t lux = lightMeter.readLightLevel();

soilMoistureValue = analogRead(A0);

if (isnan(h) || isnan(t)) 
{
//Serial.println("Failed to read from DHT sensor!");
return;
}

Serial.print("Temperature: ");
Serial.println(t);
Serial.print(" degrees Celsius Humidity: ");
Serial.println(h);
Serial.print("Light: ");
Serial.print(lux);
Serial.println(" lx\nsoilMoisture: ");
Serial.println(soilMoistureValue);
char ipBuffer1[255];
String(t).toCharArray(ipBuffer1, 255);
char ipBuffer2[255];
String(lux).toCharArray(ipBuffer2, 255);
char ipBuffer3[255];
String(h).toCharArray(ipBuffer3, 255);
char ipBuffer4[255];
String(soilMoistureValue).toCharArray(ipBuffer4, 255);
strcat(s,ID);
strcat(s," ");
strcat(s,ipBuffer1);
strcat(s," ");
strcat(s,ipBuffer2);
strcat(s," ");
strcat(s,ipBuffer3);
strcat(s," ");
strcat(s,ipBuffer4);

Udp.write(s);
Udp.endPacket();

Serial.println("Waiting 5 secs");
// thingspeak needs at least a 15 sec delay between updates
// 20 seconds to be safe
digitalWrite(D5,  LOW); 
delay(5000);
ESP.deepSleep(sleepSeconds * 1000000);
}
