# Automatisiertes Testprojekt für Amazon

Dieses Projekt wurde entwickelt, um Test-Szenarien zur Überprüfung der Funktionalität  der Amazon-Website zu automatisieren. Es werden Selenium und Java 11 verwendet und das Page Object Model (POM) folgt für eine effiziente Organisation der Testskripte. Die Testergebnisse werden sorgfältig mit sowohl Allure Reports als auch HTML Reports dokumentiert.

## Voraussetzungen

Stellen Sie sicher, dass Java 11 JDK auf Ihrem System installiert ist.

Abhängigkeiten:

- Selenium WebDriver.
- WebDriverManager
- TestNG
- Allure TestNG

## Installation

1. Überprüfen Sie die Installation von Java 11 JDK auf Ihrem System.
2. Verwenden Sie die Datei "pom.xml" im Hauptverzeichnis, um automatisch die erforderlichen Abhängigkeiten herunterzuladen.

## Testausführung

Führen Sie die Tests mit folgendem Befehl aus:

```bash
mvn test
```

Dieser Befehl führt automatisch die Test-Szenarien aus und zeigt die Ergebnisse auf dem Bildschirm an.

## Testberichte

Dieses Projekt verwendet sowohl Allure Report als auch HTML Report zur Dokumentation der Testergebnisse.

### Allure Report

Der Allure Report bietet eine detaillierte Darstellung der Testergebnisse, einschließlich Teststatus, Fehlermeldungen, Screenshots und einer Zeitleiste. Öffnen Sie den Allure Report mit folgenden Befehlen:

```bash
mvn clean test
allure serve allure-results
```

Nach Ausführung öffnet sich der Allure Report in Ihrem Standardwebbrowser.

### HTML Report

Der HTML Report wird automatisch generiert und befindet sich im Verzeichnis "target\surefire-reports". Öffnen Sie die HTML-Berichte, indem Sie die entsprechenden Dateien in einem Webbrowser öffnen.

## Hinweise

- Stellen Sie sicher, dass Ihre Internetverbindung und der Chrome-Browser aktuell sind, um die Tests erfolgreich auszuführen.
- Testergebnisse können in der Konsole und/oder in den generierten Testberichten angezeigt werden, abhängig von der Konfiguration im Test.

## Kontakt

Für Fragen, Probleme oder Feedback kontaktieren Sie mich bitte unter [fethiye0623@gmail.com].

**Hinweis:** Dies ist eine Beispiel-README-Datei für ein automatisiertes Testprojekt für Amazon, das Java 11 und Maven verwendet und sowohl Allure Report als auch HTML Report für die Testergebnisse nutzt. Passen Sie den Inhalt entsprechend den spezifischen Anforderungen und Test-Szenarien Ihres Projekts an.
