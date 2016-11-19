#include <ESP8266WiFi.h>
#include <WiFiUDP.h>

#include <DHT.h>
#include <BH1750.h>
#define DHTPIN D2
#define DHTTYPE DHT11 
#define LED_OFF D5
#define LED_OFF_2 LED_BUILTIN

unsigned int UDPPort = 3000;      // local port to listen on

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
 digitalWrite(LED_BUILTIN,LOW); 
  digitalWrite(D5,  LOW); 
  
    Serial.begin(115200);
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
//lightMeter.begin();

//Serial.println(F("BH1750 Test"));
Serial.println("Running...");
delay(10);

 
digitalWrite(BUILTIN_LED, LOW);
    }

void loop() {
char s[80];
int soilMoistureValue = 0;

float h = dht.readHumidity();
float t = dht.readTemperature();

//uint16_t lux = lightMeter.readLightLevel();
   
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
//Serial.print("Light: ");
//Serial.print(lux);
Serial.println("soilMoisture: ");
Serial.println(soilMoistureValue);

sprintf(s,"1 26.00 76 33.00 705");

    Udp.write(s);
    Udp.endPacket();

Serial.println("Waiting 5 secs");
// thingspeak needs at least a 15 sec delay between updates
// 20 seconds to be safe
delay(2000000);
}
