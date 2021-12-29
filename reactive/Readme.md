# Das Reaktive Manifest
Beschrieben unter: https://www.reactivemanifesto.org/de 

Reaktive Systeme sind:
* Responsive
* Resilient
* Elastic
* Message Driven
![Reactive Manifesto](reactive-traits-de.svg)

Die Bedeutungen sind auf der Seite beschrieben.
Nicht-reaktive Beispiele hierzu:
* Responsive: Tomcat Jetty hat eine fixe Anzahl an Threads. Bei jeder Anfrage wird ein Thread genutzt. Sind zu viele parallele Anfragen und somit Threads aktiv, und kein weiterer mehr verfügbar, gibt der Server einen Response 500 - Server Error.
* Resilient: Eine Aktion geht über mehrere Services, die untereinander mit synchronen RPCs erbeiten. Ein System restartet, die Antwort bleibt ein Fehler. Die ganze Aktion ist fehlgeschlagen.
* Elastic: Unter Last schwanken die Antwortzeiten. Es wird nicht anhand vom Ressourcenverbrauch bemerkt. Antwortzeiten sind unregelmässig zwischendurch gut und der Auto-Scaler kann nicht eindeutig bestimmen, ob weitere Ressourcen benötigt werden.
* Message Driven: Threads blockieren, während sie auf RPC/IO Antworten warten.


