#include "WiFi.h"

void setup() {
  Serial.begin(115200);
  delay(1000);

  Serial.println("Starting WiFi scan...");
  
  WiFi.mode(WIFI_STA);
  WiFi.disconnect();
  delay(100);
  
  int numNetworks = WiFi.scanNetworks();
  Serial.println("Scan completed!");

  if (numNetworks == 0) {
    Serial.println("No networks found.");
  } else {
    Serial.printf("Number of networks found: %d\n", numNetworks);
    for (int i = 0; i < numNetworks; i++) {
      Serial.printf("Network %d: %s\n", i + 1, WiFi.SSID(i).c_str());
      Serial.printf("Signal strength (RSSI): %d dBm\n", WiFi.RSSI(i));
      Serial.printf("Encryption type: %s\n", getEncryptionType(WiFi.encryptionType(i)));
      Serial.println("-----------------------");
      delay(10);
    }
  }
}

void loop() {
}

String getEncryptionType(wifi_auth_mode_t encryptionType) {
  switch (encryptionType) {
    case WIFI_AUTH_OPEN: return "Open";
    case WIFI_AUTH_WEP: return "WEP";
    case WIFI_AUTH_WPA_PSK: return "WPA_PSK";
    case WIFI_AUTH_WPA2_PSK: return "WPA2_PSK";
    case WIFI_AUTH_WPA_WPA2_PSK: return "WPA_WPA2_PSK";
    case WIFI_AUTH_WPA2_ENTERPRISE: return "WPA2_ENTERPRISE";
    default: return "Unknown";
  }
}

