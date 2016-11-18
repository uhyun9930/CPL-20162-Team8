#include <DHT.h>
#include <ESP8266WiFi.h>
 
#include <Wire.h>
#include <BH1750.h>

#define DHTPIN D3
#define DHTTYPE DHT11 


// replace with your channel’s thingspeak API key and your SSID and password
String apiKey = "1V4RPTI017VCYSDJ";
const char* ssid = "5541";
const char* password = "dilab5541";
const char* server = "155.230.86.89";
 
 
DHT dht(DHTPIN, DHTTYPE);
WiFiClient client;
 
BH1750 lightMeter;

void setup() 
{
 
Serial.begin(115200);
WiFi.begin(ssid, password);
 
Serial.println();
Serial.println();
Serial.print("Connecting to ");
Serial.println(ssid);
 
WiFi.begin(ssid, password);
 
while (WiFi.status() != WL_CONNECTED) 
{
delay(500);
Serial.print(".");
}
Serial.println("");
Serial.println("WiFi connected");
 
dht.begin();
lightMeter.begin();

Serial.println(F("BH1750 Test"));
Serial.println("Running...");
delay(10);
 
}
void loop() 
{

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

String postStr ;
postStr += String(t);
postStr +=" ";
postStr += String(lux);
postStr +=" ";
postStr += String(h);
postStr +=" ";
postStr += String(soilMoistureValue);
postStr += "\r\n\r\n";


if (client.connect(server,3000)) {
String postStr ;
postStr += String(t);
postStr +=" ";
postStr += String(lux);
postStr +=" ";
postStr += String(h);
postStr +=" ";
postStr += String(soilMoistureValue);
postStr += "\r\n\r\n";
 
Serial.println(postStr);
//client.print("POST /update HTTP/1.1\n");
//client.print("Host: api.thingspeak.com\n");
//client.print("Connection: close\n");
//client.print("X-THINGSPEAKAPIKEY: "+apiKey+"\n");
//client.print("Content-Type: application/x-www-form-urlencoded\n");
//client.print("Content-Length: ");
//client.print(postStr.length());
//client.print("\n\n");
client.print(postStr);
 

Serial.println("Sending data");
}

client.stop();
 
Serial.println("Waiting 2 secs");
// thingspeak needs at least a 15 sec delay between updates
// 20 seconds to be safe
delay(2000);
}
