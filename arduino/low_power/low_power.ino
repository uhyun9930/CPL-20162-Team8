#include <ESP8266WiFi.h>
#include <WiFiUDP.h>

#include <DHT.h>
#include <BH1750.h>
#define ID 1
#define DHTPIN D4
#define DHTTYPE DHT11
#define LED_OFF D5
#define LED_OFF_2 LED_BUILTIN

unsigned int UDPPort = 3000;      // local port to listen on

char packetBuffer[80];

// sleep for this many seconds
const int sleepSeconds = 10;


WiFiUDP Udp;


DHT dht(DHTPIN, DHTTYPE);

BH1750 lightMeter;

int soilMoistureValue = 0;
float h ;
float t ;
uint16_t lux ;

const char* ssid = "DILAB_615";  //  your network SSID (name)
const char* pass = "dilab5541";       // your network password
char str_humidity[10], str_temperature[10], str_heatIndex[10], str_soilMoistureValue[10], str_lux[10];


void setup() {
  /*
    pinMode(LED_BUILTIN, OUTPUT);     // Initialize the LED_BUILTIN pin as an output
    pinMode(D5, OUTPUT);     // Initialize the LED_BUILTIN pin as an output
    digitalWrite(LED_BUILTIN,HIGH);
    digitalWrite(D5,  LOW);
  */
  Serial.begin(115200);
  WiFi.begin(ssid, pass);
  Serial.println();
  Serial.print("Wait for WiFi");

  // Connect D0 to RST to wake up
  pinMode(D0, WAKEUP_PULLUP);

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



}

void loop() {
  h = dht.readHumidity();
  t = dht.readTemperature();
  lux = lightMeter.readLightLevel();
  soilMoistureValue = analogRead(A0);

  if (isnan(h) || isnan(t))
  {
    Serial.println("Failed to read from DHT sensor!");
    return;
  }
  Udp.write(" degrees Celsius Humidity: ");
  Serial.print("Temperature: ");
  Serial.println(t);
  Serial.print(" degrees Celsius Humidity: ");
  Serial.println(h);
  Serial.print("Light: ");
  Serial.print(lux);
  Serial.println(" lx\nsoilMoisture: ");
  Serial.println(soilMoistureValue);

  /**dtostrf(h, 1, 0, str_humidity);
    dtostrf(t, 1, 0, str_temperature);
    dtostrf(lux, 1, 0, str_lux);
    dtostrf(soilMoistureValue, 1, 0, str_soilMoistureValue);
  **/

  //sprintf(packetBuffer,"%d %s %s %s %s\n",ID,str_temperature,str_lux,str_temperature,str_soilMoistureValue);
  //Serial.println(packetBuffer);

  //    WiFi.localIP().toString().toCharArray(ipBuffer, 255);
  char ipBuffer2[255];
  String(t).toCharArray(ipBuffer2, 255);
  Udp.write(ipBuffer2);
  /**
    sprintf(str_humidity,"Scale=%d",h);
    Udp.print(str_humidity);
    Udp.print(t);
    Udp.print(String(lux));
    Udp.print(soilMoistureValue);
    Udp.print(packetBuffer);
    Udp.print(12);
    Udp.print("asbc\n");
    Udp.write("soilMoistureValue");
    Udp.write(packetBuffer);
  **/
  Udp.endPacket();

  Serial.printf("Sleep for %d seconds\n\n", sleepSeconds);

 // ESP.deepSleep(sleepSeconds * 1000000);
delay(1000);

}
