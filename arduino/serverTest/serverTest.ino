#include <SPI.h>  
#include <Ethernet.h>  
#include <EthernetUdp.h>  
  
IPAddress server(220,67,128,18);  
unsigned int localPort = 8887;  
IPAddress local_IP(172,16,10,120);  
  
byte mac[] = { 0xDE, 0xAD, 0xBE, 0xEF, 0xFE, 0xED };  
  
EthernetUDP Udp;  
  
void setup(){  
  Ethernet.begin(mac);  
  Udp.begin(localPort);  
  Serial.begin(9600);  
}  
  
void loop(){  
  Udp.beginPacket(server,9876);  
  //Udp.print("test");  
  Udp.write("test123");  
  Udp.endPacket();  
  delay(1000);  
}  
