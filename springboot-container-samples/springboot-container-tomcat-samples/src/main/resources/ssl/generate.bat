@echo off

@rem keytool -genkey -alias tomcat -keystore tomcat.keystore

keytool -genkey -alias tomcat -storetype JKS -keyalg RSA -keysize 2048 -keystore tomcat.keystore -validity 3650