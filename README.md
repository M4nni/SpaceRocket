<!--
<head>
<style>
<h1> {color: green; TEXT-DECORATION: UNDERLINE;}</h1>
<h2> {color: green; TEXT-DECORATION: UNDERLINE;}</h2>
<h3> (color: green; TEXT-DECORATION: UNDERLINE;}</h3>
</style>
</head>

<body>
#<style>
h1 {color: green; TEXT-DECORATION: UNDERLINE;}
h2 {color: green; TEXT-DECORATION: UNDERLINE;}
h3 (color: green; TEXT-DECORATION: UNDERLINE;}
</style>
</body>
-->

```javascript
test
```

<h1>
SpaceRocket
</h1>

<h2>
Ein Informatik-Projekt von Robin Wagner und Finn Westphal
</h2>

<p><img src="Screenshot_Greenfoot_SpaceRocket_Szenario.png" alt="Projekt"></p>

<ul>
<li><a href= "#Einleitung"> 1. Einleitung: Anforderungen und Elemente des Spiels</a></li>
    <ul>
    <li><a href= "#Das Spiel und die Dokumentation"> 1.1 Das Spiel und die Dokumentation</a></li>
    <li><a href= "#Snytax und Funktionsweise von Java"> 1.2 Snytax und Funktionsweise von Java</a></li>
   </ul>
<li><a href= "#Umsetzung"> 2. Umsetzung</a></li>
    <ul>
    <li><a href= "#Das Szenario"> 2.1 Das Szenario</a></li>
        <ul>
        <li><a href= "#Erstellen einer Welt"> 2.1.1 Erstellen einer Welt</a></li>
        <li><a href= "#Objekte in der Welt"> 2.1.2 Objekte in der Welt</a></li>
	<li><a href= "#Der Counter"> 2.1.3 Der Counter</a></li>
        </ul>
    <li><a href= "#Die Rakete"> 2.2 Die Rakete</a></li>
        <ul>
        <li><a href= "#Die Rakete als Actor"> 2.2.1 Die Rakete als Actor</a></li>
        <li><a href= "#Bewegung und Rotation"> 2.2.2 Bewegung und Rotation</a></li>
        <li><a href= "#Steuerung Rakete"> 2.2.3 Steuerung</a></li>
        <li><a href= "#Code-Zusammenfassung Rakete"> 2.2.4 Code-Zusammenfassung</a></li>
	<li><a href= "#Das Spielende"> 2.2.5 Das Spielende</a></li>
	<li><a href= "#Objekte aus der Welt entfernen"> 2.2.6 Objekte aus der Welt entfernen</a></li>
        </ul>
    <li><a href= "#Die Asteroiden"> 2.3 Die Asteroiden</a></li>
        <ul>
        <li><a href= "#Anforderungen"> 2.3.1 Anforderungen</a></li>
        <li><a href= "#Variablen der Asteroiden-Klasse"> 2.3.2 Variablen der Asteroiden-Klasse</a></li>
        <li><a href= "#Zufällige Bewegung der Asteroiden"> 2.3.3 Zufällige Bewegung der Asteroiden</a></li>
        <li><a href= "#Am Rand der Welt"> 2.3.4 Am Rand der Welt</a></li>
        <li><a href= "#Code-Zusammenfassung Asteroiden"> 2.3.5 Code-Zusammenfassung</a></li>
        </ul>
    <li><a href= "#Der Score"> 2.4 Der Score</a></li>
    <li><a href= "#Game-Over"> 2.5 Game-Over</a></li>
    <li><a href= "#Der Goldball finn"> 2.6 Der Goldball finn</a></li>
    </ul>
<li><a href= "#Was noch zu tun ist"> 3. Was noch zu tun ist</a></li>
<li><a href= "#Quellen"> 4. Quellen</a></li>
</ul>

```javascript
test
```

<h2>
<a id="Einleitung">1. Einleitung</a>
</h2>

<h3>
<a id="Das Spiel und die Dokumentation"> 1.1 Das Spiel und die Dokumentation</a>
</h3>

<p>
"Space Rocket" ist ein Highscore-Spiel auf Greenfoot-Basis, in dem man mit einer Rakete versuchen muss, Asteroiden in einem Asteroidenfeld auszuweichen. Dabei befindet sich die Rakete am linken Bildschirmrand, während die Asteroiden von der rechten Bildschirmseite heranfliegen. Jeder Asteroid verschwindet aus der Welt, wenn er den Rand der Welt erreicht. Man verliert, wenn man mit einem Asteroiden zusammenstößt.
</p>		
		
<p>		
In in den folgenden Ausführungen werden wir schrittweise beschreiben, wie wir bei der Programmierung der Spiels vorgegangen sind. Es macht Sinn, sich in der angegeben Reihenfolge mit dem Dokument zu beschäftigen, um unsere Gedankengänge nachzuvollziehen. Dies gilt vor allem für die verwendeten Programmiermethode und Befehle, die wir nicht in jedem Kapitel neu erläutern, sondern nur beim ersten Auftreten detailliert beschreiben und als Wissensgrundlage für weitere Anwendungsfälle vorraussetzen.
</p>

<h3>
<a id="Snytax und Funktionsweise von Java"> 1.2 Snytax und Funktionsweise von Java</a>
</h3>

<p>
Die Programmierumgebung <i>Greenfoot</i> basiert auf der objektorientierten Blockprogrammiersprache <i>Java</i>. Ziel dieser Umgebung ist es, mit relativ einfachen Mitteln und ohne Vorkenntnissen objektorientierte Simulationskonzepte zu programmieren. Für das besser Verständnis erklären wir kurz den generellen Aufbau und die Snytax von <i>Java</i>.		
</p>		
 		
<p>		
Java ist aus Blöcken aufgebaut, die im Snytax durch geschweifte Klammern gekennzeichnet werden. Der Inhalt dieser Blöcke kann Anweisung und Befehle enthalten, aber auch weitere Blöcke enthalten. Auf diese Weise ist eine verschachtelte Blockstruktur mit mehreren Ebenen möglich. Der Vorteil einer Block-Programmierung ist, dass Snytax-Fehler leichter indentifiziert werden können, da nur einzelnen Blöcke nicht ordnungsgemäß funktionieren und nicht der gesamte Code defekt ist.		
</p>		
 		
```javascript
Anweisung
{
    Anweisung
    {
    	Anweisung
    }
}
```

<h2>
<a id="Umsetzung"> 2. Umsetzung</a>
</h2>

<h3>
<a id= "Das Szenario"> 2.1 Das Szenario</a>
</h3>

<p><img src="images/Szenario.png" alt="Szenario">

<p>
Wir programmieren unser Projekt "SpaceRocket" in der Programmierumgebung "Greenfoot", die auf der objektorientierten Programmiersprache <i>Java</i> basiert. Zunächst haben wir festgelegt, welche Größe, welches Format und welche Auflösung unsere Welt haben soll. Unser Spiel soll über eine klassische Auflösung und ein klassisches Seitenverhälnis verfügen, damit es auf jedem Computer spielbar ist. Wir haben uns deswegen für das Seitenverhältis von 16/9 und eine Auflösung von 960 * 540 Pixeln entschieden. Diese Bildeigenschaften sind von den meisten aktuellen Displays umsetzbar.
</p>

<h4>
<a id= "Erstellen einer Welt"> 2.1.1 Erstellen einer Welt</a>
</h4>

<p>
Mit dem Konstruktor <i>public</i> erstellen wir eine Welt-Klasse namens <i>space_backround_1</i> und durch die Methode <i>import greenfoot.*;</i> geben wir an, dass diese Klasse in das Szenario implementiert werden soll. Fehlt diese Methode oder wird sie verändert, so würde diese Klasse beim Start des Programmes nicht geladen werden. Hinter jeder Klasse stehen mindestens eine geöffnete und eine geschlossene Klammer, die zusätzliche Parameter enthalten können. Zur Ausführung der Methoden, die wir verwenden, sind keine weiteren Parameter notwendig, weswegen bei uns nichts zwischen den Klammern steht. Die Referenz <i>super</i> sorgt dafür, dass alle Eigenschaften der Super- oder Hauptklasse auf alle anderen Klassen übertragen werden. In diesem Fall ist die Super-Klasse die generierte Welt. Diese Anweisung benötigt weitere Parameter für ihre Funktionalität und zwar die Auflösung der generierten Welt und das Verhältnis zwischen Pixeln und Zellen des Zellen-Koordinatensystems, das deckungsgleich zur generierten Welt erstellt wird. Wir wollen dieses Verhältnis auf 1:1 festlegen, sodass eine Zelle einem Pixel entspricht. Um diese Parameter dem Konstruktor zur Verfügung zu stellen, schreiben wir nach <i>super</i> in Klammern (960, 540, 1, true). Der erste Parameter definiert die Anzahl der Pixel entlang der x-Achse, der zweite nach dem Komma die Pixelanzahl in y-Richtung und der dritte Parameter "1" sagt aus, dass eine Zelle die Größe von einem Pixel in x- und y- Richtung besitzt. Das Größenverhältnis zwischen Zellen und Pixeln beträgt also 1:1. Durch den Parameter <i>true</i> erreichen wir, dass die Asteroiden und auch die Rakete zunächst nicht aus der Welt verschwinden können, da die Grenzen der Welt für sie eine Barriere darstellen. Am Ende dieser Zeile steht ein Semikolon, das verschiedene Methoden voneinander trennt. Danach haben wir in Greenfoot einen Hintergrund unserer Welt gesucht, der möglichst zum Spiel passen soll. Wir haben uns schließlich für den vorgefertigten Greenfoot-Hintergrund <i>space1</i> entschieden. Dieser lässt sich per Recht-Klick auf die Klasse unter der Option "Set image..." auswählen.
</p>

<pre><code><strong>Code-Script 1.1</strong>

import greenfoot.*;
public space_backround_1()
    {
        super(960, 540, 1, true);
    }
</code>
</pre>

<h4>
<a id="Objekte in der Welt"> 2.1.2 Objekte in der Welt</a>
</h4>

<p>
Bisher enthält unsere Welt noch keine Objekte, die agieren können und für unser Spiel relevant sind. Wir benötigen in jedem Fall zunächst eine Raketen- und eine Asteroiden-Klasse. Zunächst wollten wir, dass jeweils vor Spielbeginn eine Rakete an einem festen Ort startet. Ebensfall sollen verschiedene Asteroiden an immer anderen Punkten der Welt, allerdings nur an den Rändern der rechten Welthälfte, spawnen. Dazu haben wir, wie in dem folgenden Befehl zu sehen (siehe Code-Script 1.2), mithilfe der Methode <i>addObject</i> eine Rakete hinzugefügt, die jedes Mal, wenn man das Spiel startet, an der Position x = 150 und y = 270 startet. Die Methode <i>addObject</i> benötigt bestimmte Parameter für ihre Funktionalität. Zu diesen zählt zum einen die Bezeichnung des zu generierenden Objektes einer Klasse und seine Position in der Welt. Hierzu wird nach <i>addObject</i> in Klammern die jeweilige Klasse mit dem Aufdruck <i>new</i> davor genannt, welcher als Referenz festlegt, dass ein Objekt dieser Klasse hinzugefügt werden soll. Schließlich geben zwei Parameter, durch Kommata getrennt, die Koordinaten des jeweiligen Objektes an. Diese Koordinaten haben wir so gewählt, dass die Rakete ziemlich weit links, aber nicht am Rand startet und genau die Hälfte der Höhe besitzt.
</p>

<pre><code><strong>Code-Script 1.2</strong>

import greenfoot.*;
public space_backround_1()
{
    super(960, 540, 1, true);
    addObject(new rocket(), 150, 270);
}
</code></pre>

<p>
Weiterhin lassen wir Asteroiden spawnen, die sich an immer anderen Positionen befinden können. Der erste Asteroid hat die x-Koordinate 960 und befindet sich genau am rechten Rand der Welt mit einer y-Koordinate die von 0 bis 540, also von ganz unten bis ganz oben entlang der y-Achse variieren kann. Dies erreichen wir durch die Methode <i>Greenfoot.getRandomNumber</i>, die eine zufällige, natürliche Zahl zwischen 0 und dem jeweiligen in Klammern stehenden Grenzwert generiert. Der Grenzwert (hier: 541) ist dabei ausgeschlossen. Der 2. Asteroid kann zwischen den x-Koordinaten 480 und 480 + 480, also maximal 960 entstehen. Das bedeutet, dass er immer zufällig zwischen der Hälfte der Welt und dem rechten Rand spawnt. Die y-Koordinate beträgt 0, weshalb der Asteroid nur am oberen Rand der Welt spawnen kann. Dem 3. Asteroid sind die gleichen x-Koordinaten zugewiesen, er spawnt aber durch die festgelegte y-Koordinate von 540 immer am unteren Rand. Seine x-Koordinate ist ebenfalls variabel, sodass er entlang der y-Achse zufällig erscheinen kann. 
</p>

<pre><code><strong>Code-Script 1.3</strong>

addObject(new rocket(), 150, 270);
addObject(new counter(), 30, 510);
addObject(new Asteroid(), 960, Greenfoot.getRandomNumber(541) - 0);
addObject(new Asteroid(), Greenfoot.getRandomNumber(480) + 480, 0);
addObject(new Asteroid(), Greenfoot.getRandomNumber(480) + 480, 540);
</code></pre>

<h3>
<a id="Der Counter"> 2.1.3 Der Counter</a>
</h3>

Die Asteroiden erscheinen bisher nur einmalig beim Start in der Welt. Aus diesen Grund haben wir eine weitere Variable hinzugefügt, die ihren Wert ständig in gleichmäßigen Schritten erhöht. Wir haben diese Variable <i>counter</i> genannt und sie gleich 0 gesetzt (siehe Code Script 1.4).

```javascript
Code-Script 1.4

int counter = 0;
```

<p>
Die Referenz "++" sorgt dafür, dass einer Variable natürliche Zahlenwerte wie "1" bei jeder Ausführung addiert werden. Auf diese Weise erhöht sich der Betrag der Variable in natürlichen Zahlenabschnitten. Wir können nun festlegen, was passieren soll, wenn die Variable einen bestimmten Wert angenommen hat. Unser Ziel ist es, weitere Asteroiden in regelmäßigen Abständen erscheinen zu lassen. Da der <i>counter</i> eine gewisse Zeit braucht, um bestimmte Werte zu erreichen ergibt sich daraus eine Verzögerung. Diese Zeitspanne können wir als Zeitperoide zwischen zwei nacheinander hinzugefügten Asteroiden festlegen und somit die Frequenz der Asteroiden festlegen. Dadurch erscheinen in regelmäßigen Abständen immer neue Asteroiden in der Welt.
</p>

<p>
Diese Ansätze lassen sich mithilfe einer if-Methode in Greenfoot umsetzen. Der counter fängt bei 0 an, zu zählen. Wir können festlegen, dass Asteroiden hinzugefügt werden sollen, wenn der counter einen bestimmten Zahlenwert erreicht hat. Je größer die Differenz zwischen dem Startwert 0 und dem Bedingungswert in der if-Methode ist, desto größer ist die Verzögerung zwischen zwei Asteroiden. Wir legen in Code-Script 1.5 fest, dass die Bedingen der if-Methode erfüllt ist, wenn der counter Werte von mehr als 10 annimmt
</p>

```javascript
if(counter >= 10)
```

<p>
Um neue Asteroiden hinzuzufügen, verwenden wir die bekannte Methode <i>addObject</i>, die wir in die if-Methode implementieren. Diese benötigt die Ortskoordinaten der Asteroiden als Parameter, um festlegen, wo die Asteroiden erscheinen sollen. Hierfür haben wir die breits oben genannten, zufälligen Koordinaten verwendet. Wir haben die Koordianten innerhalb der if-Methoden als Variablen definiert, damit der Code übersichtlich bleibt.
</p>

```javascript
Asteroiden rechter Rand:

int x = 960;
int y = Greenfoot.getRandomNumber(541) - 0;

Asteroiden oberer Rand:
int x = Greenfoot.getRandomNumber(480) + 480;
int y = 1;

Asteroiden unterer Rand:

int x = Greenfoot.getRandomNumber(480) + 480;
int y = 540;
```

<p>
Für alle drei Ränder der Welt stellen wir jeweils eine if-Methode mit den entsprechenden Koordinaten auf. In den <i>addObject</i>-Methoden geben wir durch Asteroiden-Klasse <i>Asteroid()</i> und der Referenz <i>new</i> an, dass ein neuer Asteroid hinzugefügt werden soll. Als Orts-Parameter verwenden wir die Variablen <i>x</i> und <i>y</i>, die die jeweiligen definierten Werte annehmen. Essentiell ist außerdem, dass der <i>counter</i>, sobald die if-Methode ausgeführt wurde, auf 0 den Startwert zurückgesetzt, damit der <i>counter</i> wieder bei 0 anfängt zu zählen. Ansonsten würden die Anweisungen innerhalb der if-Methode nur einmal ausgeführt werden, weil ohne Zurücksetzen der Bedingungswert erreicht und weiter überschritten wird. Erst das erneute Erreichen des Bedingungswertes sorgt für ein erneutes Ausführen der if-Methode und somit für neue Asteroiden.
</p>

<p>
Wenn die oben beschriebenen Objekte nun zur Welt hinzugefügt wurden, soll die Welt mit public void act den Counter aktivieren und dieser soll nicht mehr den inaktiven Wert von 0 annehmen können. Wenn der Counter nun zufällige Zahlen annimmt, die größer als 10 sind, spawnen neue Asteroiden, unzwar genau an den zufälligen Orten, wo sie auch zu Beginn in der Welt erscheinen, also etwa am oberen rechten Bildrand, am unteren rechten Bildrand oder an der rechten Seite des Bildes. Dazu legen wir die Koordinaten fest und fügen es mithilfe von addObject() und den bestimmten Koordinaten neu in die Welt hinzu. Grundvorraussetzung dafür ist, dass wir einem Asteroiden einen bestimmten Namen geben (Asteroid robin) und als neuen Asteroiden definieren und das hinzugefügte Object auch diesen Namen besitzt. Wichtig ist, dass der counter danach wieder auf 0 zurückgesetzt wird, weil sonst nicht immer wieder neue Asteroiden spawnen könnten. Je kleiner die benötigte Zahl des Counters ist (in unserem Fall mindestens 10), desto schwieriger wird das Spiel, denn je kleiner die Zahl, desto öfter wird die Zahl überschritten und es spawnen mehr Asteroiden. Für Profis kann die Zahl bis auf 5 reduziert werden, ansonsten ist fast die ganze Welt voller Asteroiden und man hat keine Chance, zu überleben. Ohne diesen counter und das ständige Neuerscheinen der Asteroiden wäre das Spiel auch nicht spielbar.
</p>

Nachfolgend der Code des Counters in der Welt space_background_1:

```javascipt
Code-Script 1.6

public void act()
{
    counter++;
    if(counter >= 10)
    {
        int x = 960;
        int y = Greenfoot.getRandomNumber(541) - 0;
        addObject(new Asteriod(), x, y);
        counter = 0;   
    }
    if(counter >= 10)
    {
        int x = Greenfoot.getRandomNumber(480) + 480;
        int y = 1;
        addObject(new Asteriod(), x, y);
        counter = 0;
    }
    if(counter >= 10)
    {
        int x = Greenfoot.getRandomNumber(480) + 480;
        int y = 540;
        addObject(new Asteriod(), x, y);
        counter = 0;     
    }
```
    
<p>
Zusammengefasst ergibt sich für die World-Klasse:
</p>

<pre><code><strong>Code-Script 1.6</strong>
import greenfoot.*;
int counter =0;
public space_backround_1()
    {
        super(960, 540, 1, true);
        addObject(new rocket(), 150, 270);
        addObject(new counter(), 30, 510);
        addObject(new Asteroid(), 960, Greenfoot.getRandomNumber(541) - 0);
        addObject(new Asteroid(), Greenfoot.getRandomNumber(480) + 480, 1);
        addObject(new Asteroid(), Greenfoot.getRandomNumber(480) + 480, 540);
	
	   public void act() {
    counter++;
    if(counter >= 10 ) {
        Asteroid robin = new Asteroid();
        int x = 960;
        int y = Greenfoot.getRandomNumber(541) - 0;
        addObject(robin, x, y);
        counter = 0;
        
    }
     if(counter >= 10 ) {
        Asteroid robin = new Asteroid();
        int x = Greenfoot.getRandomNumber(480) + 480;
        int y = 1;
        addObject(robin, x, y);
        counter = 0;
        
    }
     if(counter >= 10)
    {
        Asteroid robin = new Asteroid();
        int x = Greenfoot.getRandomNumber(480) + 480;
        int y = 540;
        addObject(robin, x, y);
        counter = 0;
        
    }
    
    }
}
</code></pre>

<h3>
<a id= "Die Rakete"> 2.2 Die Rakete</a>
</h3>

<p><img src="images/rocket.png" alt="Rocket"></p>

<h4>
<a id="Die Rakete als Actor"> 2.2.1 Die Rakete als Actor</a>
</h4>

<p>
Danach haben wir uns um die Rakete gekümmert. Diese soll sich zwar nicht nach links und rechts bewegen, da die Asteroiden auf die Rakete zufliegen sollen, aber sie soll sich nach oben und unten bewegen können. Zuerst haben wir ein Bild einer Rakete zur Actor-Klasse Rocket per Rechts-Klick auf die Rocket-Klasse unter der Option "Set image..." hinzugefügt. Mithilfe des Konstruktors *public* erstellten wir eine Klasse, die in der Lage ist, mit anderen Klassen Informationen austauschen. Auf diese Weise ist sie in der Lage, mit anderen Klassen zu interagieren. Wir verwenden für die Rakete die Methode <i>void act()</i>. Der Rückgabetyp <i>void</i> gibt an, ob und wenn ja, welche Informationen zurückgegeben werden. In diesen Fall bedeutet <i>void</i> so viel wie "nichts", wir erhalten dementsprechend keine Informationen über die Ausführung der Methode. <i>void act()</i> ist ausschließlich eine ausführende Methode, die keine weiteren Parameter für ihre Ausführung benötigt, weswegen in den Klammern von <i>act()</i> kein Inhalt vorhanden ist. Sie wird beim starten des Szenarios, z. B. durch betätigen des <i>Act-Buttons</i>, kontinuierlich ausgeführt, bis das Szenario beendet wird. Dabei werden die einzelnen Methoden innerhalb von <i>act()</i> der Reihe nach ausgeführt. Wir legen mit dieser Methode das Verhalten der Rakete fest.
</p>

```javascript
Code-Script 2.1

import greenfoot.*;
public class rocket extends mover
{
public void act()
{
}
```

<h4>
<a id="Bewegung und Rotation"> 2.2.2 Bewegung und Rotation</a>
</h4>

<p>
Hier haben wir mit den Befehlen <i>setRotation()</i> und <i>setLocation()</i> gearbeitet. Mithilfe von <i>setRotation</i> können wir die Neigung der Rakete bestimmen. Zur Steuerung der Rakete verwenden wir "w" für "nach oben" und "s" für "nach unten" oder alternativ die Pfeiltasten "up" und "down". Solange eine der Tasten gedrückt wird, soll sich die Rakete mit einer bestimmten, konstanten Geschwindigkeit in die jeweilige Richtung bewegen. Damit dies visuell verdeutlicht wird, soll gleichzeitig während des Tastendrucks die Rakete durch <i>setRotation</i> in einer bestimmten Neigung ausgerichtet werden.
Um diese Steuerung in Greenfoot umzusetzen, haben wir zunächst festgelegt, dass die Rakete horizontal ausgerichtet ist, weswegen wir zuerst in der Methode <i>setRotation</i> den Parameter für den Rotationswinkel gleich null gesetzt haben.
</p>

<pre>
<code><strong>Code-Script 2.2</strong>
   {
      setRotation(0);
   }
</code></pre>

<p>
Damit sich die Rakete beim Tastendruck mit konstanter Geschwindigkeit nach unten bewegt, verwenden wir die Methode <i>setLocation</i>, die mindestens drei weitere Parameter für ihre Funktion benötigt, welche die aktuelle Position des Objektes in der Welt und die Bewegungsrichtung relativ zu dieser Position sind. Die Rückgabetypen <i>getX</i> und <i>getY</i> geben die aktuellen Koordinaten des klassenspezifischen Objektes an. Sie werden durch ein Komma getrennt und in den Klammern der Methode <i>setLocation</i> integriert. Damit nun beim Tastendruck eine Bewegung vollzogen wird, kann hinter jedem Rückgabetypen eine natürliche Zahlen addiert bzw. subtrahiert werden. So wird bei jeder Ausführung dieses frames oder Blocks das Objekt um die jeweiligen addierten bzw. subtrahierten Koordinaten bewegt. Durch das mehrfache Ausführen dieser Methode resultiert daraus eine lineare Fortbewegungsrichtung. Für unsere Anwendung soll sich unser Objekt, die Rakete, lediglich entlang der y-Achse bewegen, weswegen die x-Koordinate unverändert bleibt.
</p>

<pre><code>Code-Script 2.3
setLocation(getX(), getY()+12);
</code></pre>

<p>
Zur visuellen Verdeutlichung der Bewegung verwenden wir außerdem die Methode <i>setRoation</i>, die das Objekt, in diesem Fall unsere Rakete, in einem bestimmten Winkel ausrichtet. Dieser Winkel wird in Klammern an die Methode ergänzt. Durch ausprobieren haben wir herausgefunden, dass eine Rotation von 20° bzw. -20° geeignet für die simulierte Bewegung unser Rakete ist.
</p>

<h4>
<a id="Steuerung Rakete"> 2.2.3 Steuerung</a>
</h4>

<p>
Die Rakete soll außerdem nur beim Tastdruck ihre Position verändern und nicht in der Lage sein, die Welt über ihre Grenzen zu verlassen. Um diese Bedingungen mit der Bewegung der Rakete in Verbindung zu bringen, verwenden wir eine <i>if-Methode</i>, die die Ausführung einer oder mehrerer Methoden nur zulässt, wenn alle ihre Bedingungsparameter erfüllt werden. Werden die in runden Klammern stehenden Bedingungen erfüllt, so werden die in geschweiften Klammern stehende Methoden im Anschluss an die if-Methode ausgeführt. In unserem Fall bestehen unsere Bedinungsparameter aus zwei <i>Greenfoot.isKeyDown</i>-Methoden und dem Rückgabetyp <i>getY()</i>. Die Methode <i>Greenfoot.isKeyDown</i> prüft ständig, ob eine bestimmte Taste auf der Tastatur gedrückt wird. Dabei wird der jeweilige Tastenname in Anführungszeichen in Klammern an die Methode ergänzt. Da die Steuerung optional über die Pfeiltasten "oben" und "unten", sowie über die Tasten "w" und "s" erfolgen soll, verwenden wir <i>Greenfoot.isKeyDown</i> zweimal pro if-Methode. Für die Abwärtsbewegung bespielsweise verwenden wir <i>Greenfoot.isKeyDown("down")</i> und <i>Greenfoot.isKeyDown("s")</i>, die durch zwei senkrechte Striche "||" voneinander getrennt werden. Diese bilden einen Operator, in diesem Fall einen arithmetischen Ausdruck, der soviel wie "oder" bedeutet. Damit die Rakete die Welt nicht verlassen kann, haben wir den Rückgabetyp <i>getY()</i> als kleiner 540 festgelegt, was der maximalen y-Koordiante unserer Welt entspricht. Er wird mit zwei Et-Zeichen "<span>&amp;&amp;</span>" an die beiden <i>Greenfoot.isKeyDown</i> ergänzt. Die beiden Et-Zeichen ergeben ebenfalls einen Operator mit der Bedeutung "und". Daraus folgt, dass die Bedingung der if-Methode nur erfüllt ist, wenn mindestens einer der Tasten "down" oder "s" gedrückt wird und die aktulle Position der Rakete eine kleinere y-Koordinate als 540 aufweist. Werden die Bedingungen erfüllt, bewegt sich die Rakete mit einer Geschwindigkeit von 12 Pixeln pro frame-Ausführung entlang der y-Achse in Richtung der unteren Kante der Welt.
</p>

<pre><code>Code-Script 2.4
if (Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s") <span>&amp;&amp;</span> getY() <span>&gt;=</span> 540)
   {
      setRotation(20);
      setLocation(getX(), getY()+12);
   }
</code></pre>

Äquivalent dazu ergibt sich für die Aufwärtsbewegung:

<pre><code><strong>Code-Script 2.5</strong>
if (Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w") <span>&amp;&amp;</span> getY() <span class="sy0">&gt;=</span> 0)
   {
   setRotation(-20);
   setLocation(getX(), getY()-12);
   }
</code></pre>

<p>
Hier wurden "down" und "s" durch "up" und "w" ersetzt und der der Rückgabewert <i>getY</i> größer gleich 0 gesetzt. Dadurch ist die Bedingung der if-Methode nur erfüllt, wenn die "up"- oder "w"-Taste gedrückt und die aktuelle y-Koordinaten der Rakete größer als 0 ist. Somit kann die Rakete die Welt nicht an der oberen Kante verlassen. Die Neigung der Aufwärtsbewegung ist betragsgleich der Neigung der Abwärtsbewegung, jedoch ist sie negativ, sodass die Rakete gegen dem Uhrzeigersinn sich mit 20° um die eigene Achse rotiert. In der Methode <i>setLocation</i> wird der Rückgabetyp <i>getY</i> mit 12 subtrahiert, sodass sich die Rakete nach oben anstatt nach unten bewegt.
</p>

<h4>
<a id="Das Spielende"> 2.2.5 Das Spielende</a>
</h4>

<p>
Desweiteren lassen wir die Rakete einen Klassen-Test durchführen. Wir wollen damit erreichen, dass das Spiel zuende ist, wenn die Rakete einen Asteroiden berührt und die beiden Objekte schließlich auch aus der Welt entfernt werden. Dazu führen wir einen Test durch, der überprüft, ob die Rakete ein Object einer Klasse berührt (getOneIntersectingObject). In unserem Fall handelt es sich um die Asteroiden, da man nur verlieren soll, wenn man mit ihnen zusammenkracht. Wenn der Test den Rückgabetyp "null" zurückgibt, die Rakete also keinen Asteroiden berührt, läuft das Spiel ganz normal weiter. Wenn die Rakete allerdings einen Asteroiden berührt, der Test also nicht null ist (!= bedeutet ungleich), fügen wir ein neues GameOver mit dem Namen <i>robin</i> hinzu, wofür wir vorher eine neue Klasse erstellt haben, die unten beschrieben wird. Der Schriftzug "Game Over" erscheint, indem das Bild für das GameOver() robin mit den Koordinaten der halben länge und halben Breite eingefügt wird. Auf diese Weise erscheint der Schriftzug genau in der Mitte des Szenarios. Außerdem gibt es einen einfachen Befehl, um das Spiel zu stoppen: Man sagt Greenfoot.stop();
Der Code sieht dann folgendermaßen aus:
</p>

```javascript
Actor test = getOneIntersectingObject(Asteroid.class);

if (test != null) {
    GameOver robin = new GameOver();

getWorld().addObject(robin, getWorld(). getWidth()/2, getWorld().getHeight()/2);
    Greenfoot.stop();
    
}
```

<h3>
<a id="Objekte aus der Welt entfernen"> 2.2.6 Objekte aus der Welt entfernen</a>
</h3>

<p>
Wenn das Spiel stoppt, sollen gleichzeitig die Rakete und der betreffende Asteroid aus der Welt entfernt werden. Dies geschieht zunächst daduch, dass wir die Klasse <i>Robin</i> als das betroffende Objekt der Asteroiden-Klasse identifizieren. Wenn dieses, wie es oben annähernd schon aufgeführt ist, nicht gleich 0 ist, also existiert, dann sucht greenfoot in dieser Welt und entfernt dieses spezielle Objekt Robin. Es funktioniert nicht, zu sagen, dass das Objekt Asteroid entfernt wird, da Greenfoot nicht eine komplette Klasse während des Spiels aus der Welt entfernen kann. Dafür lässt sich das betroffene Objekt einer Klasse mit dem Rückgabetyp <i>this</i> identifizieren, was in unserem Fall die Rakete ist, entfernen. Somit wird nur ein spezielles Objekt einer Klasse und nicht die gesamte Klasse entfernt.
</p>

```javascript
Actor robin = getOneIntersectingObject(Asteroid.class);

if (robin != null)
{ 
    getWorld().removeObject(robin);
    getWorld().removeObject(this);
}
```


<h4>
<a id="Code-Zusammenfassung Rakete"> 2.2.4 Code-Zusammenfassung</a>
</h4>

<p>
Zusammengefasst ergibt sich für den Code der Rakete:
</p>

```javascript
Code-Script 2.6

import greenfoot.*;
public class rocket extends mover
{
public void act()
{
   setRotation(0);
    
   if (Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s") <span>&amp;&amp;</span> getY() < 540)
   {
      setRotation(20);
      setLocation(getX(), getY()+12);
   }
   if (Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w") && getY() > 0)
   {
   setRotation(-20);
   setLocation(getX(), getY()-12);
   }

Actor test = getOneIntersectingObject(Asteroid.class);

if (test != null) {
    GameOver robin = new GameOver();
    getWorld().addObject(robin, getWorld(). getWidth()/2, getWorld().getHeight()/2);
    Greenfoot.stop();
    
}

Actor robin = getOneIntersectingObject(Asteroid.class);

if (robin != null) { 
    getWorld().removeObject(robin);
    getWorld().removeObject(this);
}
}
}
```

<h3>
<a id= "Die Asteroiden"> 2.3 Die Asteroiden</a>
</h3>

<p><img src="images/rock.png" alt="Asteroid"></p>

<h4>
<a id="Anforderungen"> 2.3.1 Anforderungen</a>
</h4>

<p>
Anschließend haben wir uns um die Programmierung der Asteroiden gekümmert. Zu Beginn haben wir eine Asteroiden-Klasse namens "Asteroid" erstellt und ihr die Bilddatei rock.png zugeordnet, die Greenfoot standardmäßig zur Verfügung stellt. Die Asteroiden sollen während der Ausführung des Szenarios zufällig spawnen und sich von rechts nach links mit einem zufälligen Winkel in Richtung der Rakete bewegen. Sobald sie auf den Rand der Welt zufliegen, sollen sie aus dem Szenario entfernt werden. Um diese Anforderungen zu erfüllen, benötigen wir eine Methode, die in der Lage ist, einen Asteroiden zu entfernen, wenn er sich am Rand der Welt befindet. Außerdem brauchen wie weitere Methoden, die den Asteroiden eine feste Geschwindigkeit und einen zufälligen Winkel zuweisen.
</p>

<h4>
<a id="Variablen der Asteroiden-Klasse"> 2.3.2 Variablen der Asteroiden-Klasse</a>
</h4>

<p>
Bei der Programmierung der Asteroiden haben wir zunächst zwei Variablen definiert, um den Code übersichtlicher zu gestalten. Diese Variablen legen die Richtung fest, in die sich die Asteroiden bewegen. Hierfür verwenden wir den primitiven Datentyp <i>Integer</i>, kurz <i>int</i>, welcher eine 32-Bit-Codierung aufweist. Das Zahlenspektrum dieses Datentyps umfasst 2³² ganze Zahlen von -2.147.483.648 bis 2.147.483.647. Da für die Winkeldefinition in Greenfoot das Winkelmaß Grad verwendet wird, ist dieser Zahlenbereich mehr als ausreichend. Die Snytax für Variablen setzt sich aus der Art des Datentyps und dem Namen der Variablen zusammen, die dem zugeordneten Zahlenwert durch ein Gleichheitszeichen gleichgesetzt werden.
</p>

```javascript
Code-Scipt 3.01

int [Name der Variablen] = ...
```

<p>
Da sich die Asteroiden mit einem zufälligen Winkel fortbewegen sollen, verwenden wir die bekannte Methode <i>Greenfoot.getRandomNumber</i> für die Winkelvariable names <i>Angle</i> (engl. Winkel). Diese Methode generiert jedoch nur natürliche Zahlen. Ohne Weiteres lassen sich also nur Winkel im Uhrzeigersinn erzeugen. Somit sind  die Asteroiden lediglich in der Lage, eine Aufwärtsbewegung zu erfahren. Aus diesem Grund haben wir eine weitere Variable mit der Bezeichnung <i>TypeOfRotation</i> festgelegt, deren Funktion später noch genauer erläutert wird. Wir haben die Variable für den Winkel (Angle) gleich <i>Greenfoot.getRandomNumber(10)</i> gesetzt, wodurch die zufällige Zahl von 0 bis 9 generiert wird. Die Variable <i>TypeOfRotation</i> erstellt durch den Grenzwert <i>(2)</i> zufällig eine 0 oder eine 1. Der Wert dieser Variable kann also nur zwei Zustände annehmen.
</p>

```javascript
Code-Script 3.02

import greenfoot.*;
int Angle = Greenfoot.getRandomNumber(10);
int TypeOfRotation = Greenfoot.getRandomNumber(2);
```

<h4>
<a id="Zufällige Bewegung der Asteroiden"> 2.3.3 Zufällige Bewegung der Asteroiden</a>
</h4>

<p>
Da sich die Asteroiden mit einer konstanten Geschwindikeit bewegen sollen, können wir die Methode <i>move()</i> verwenden. Sie funktioniert in Verbindung mit <i>act()</i>. Mit dieser Methode lassen sich Objekte entlang der x-Achse bewegen. Sie benötigt einen Parameter, eine Zahl, in ihrem Klammerausdruck. Dabei definiert das Vorzeichen die Richtung, in die sich das Objekt bewegt (positiv: von links nach rechts, negativ: von rechts nach links) und der Betrag des Zahlenwertes das Tempo, mit der sich das Objekt vorbewegt. Durch Ausprobieren haben wir herrausgefunden, dass ein Tempo von 12 geeignet für unser Spiel ist. Das Vorzeichen der Geschwindikeit ist negativ, weil sich die Asteroiden von rechts nach links bewegen sollen.
</p>

```javascript
Code-Script 3.03

public void act()
{
   move(-12)
}
```

<p>
Bisher sind die Asteroiden nur in Lage, sich horizontal fortzubewegen. Wir haben bereits eine zufällige Variable für die Winkeleinstellung der Asteroiden. Mithilfe von <i>setRotation()</i> können wir diese nutzen, um die Neigung der Asteroiden festzulegen. Um die Werte von der Variable "Angle" abzurufen, müssen wir die Variablenbezeichnung als Parameter in die Klammern in <i>setRotation</i> implementieren.
</p>

```javascript
Code-Script 3.04

setRotation(Angle)
```

<p>
Jetzt können die Asteroiden nur eine horizontale Bewegung oder eine Aufwärtsbewegung erfahren, weil nur Winkeleinstellungen gegen den Uhrzeigersinn möglich sind. Hier kommt die Variable <i>TypeOfRotation</i> ins Spiel. Sie kann nur zwei Zustände (0 und 1) annehmen. Dies können wir uns zu nutzen machen, indem wir über diese Variable das Vorzeichen des Winkels bestimmen. Auf diese Weise lässt sich eine Winkeleinstellung mit und gegen den Uhrzeigersinn vornehmen, indem wir die beiden Zustände von <i>TypeOfRotation</i> mit Bedingungen verknüpfen. Wir können z. B. festlegen, dass der Winkel positiv (mit dem Uhrzeigersinn ausgrichtet) ist, wenn <i>TypeOfRotation</i> den Wert 0 annimmt. Äquivalent wäre der Winkel mit einem negativen Vorzeichen versehen, wenn <i>TypeOfRotation</i> 1 ist. Der Winkel würde sie dadurch gegen den Uhrzeigersinn ausrichten. Diese Bedingungen lassen sich mit der bekannten if-Methode definieren. Dabei sind die Bedingungen, dass <i>TypeOfRotation</i> 0 bzw. 1 ist. Die Werte 0 und 1 werden durch den aritmetischer Ausdruck "==" gleichgesetzt, welcher so viel wie "ist gleich" bedeutet. Die ausgeführten Anweisungen sind dementsprechend die Methoden <i>setRotation</i> mit positivem bzw. nagativem Vorzeichen. Da eine der Bedingungen (0 oder 1) immer erfüllt ist, bewegen sich die Asteroiden immmer mit einem zufälligen Winkel. Somit haben wir die Bewegung der Asteroiden charakterisiert.
</p>

```javascript
Code-Script 3.05

public void act()
{
    move(-12);
    if (TypeOfRotation == 0);
    {
        setRotation(Angle);
    }
    if (TypeOfRotation == 1)
    {
        setRotation(-Angle);
    }
}
```

<h4>
<a id="Am Rand der Welt"> 2.3.4 Am Rand der Welt</a>
</h4>

<p>
Die Asteroiden sollen entfernt werden, sobald sie die Ränder der Welt erreichen. Es muss also ständig geprüft werden, ob sich ein Asteroid am Rand der Welt befindet. Dies ist ein sehr spezieller Aufgabentyp für den keine vorfertigte Methode vorhanden ist, weshalb wir eine eigene Methode definieren müssen. Wir haben diese Methode <i>atWorldEdge()</i> genannt, was so viel wie "am Rand der Welt bedeutet". Im Gegensatz zu der bisher verwendeten Mehtode <i>act()</i> muss <i>atWorldEdge()</i> über Rückgabetypen verfügen, damit die Methode in Lage ist Informationen zurückzugeben. In diesem soll die Methode angeben, ob sich ein Asteroid am Rand der Welt befindet oder nicht. Da dies binäre Aussagen sind, sind boolesche Rückgabetypen sinnvoll. Boolesche Aussagen (Literale) können nur zwei Züstände annehmen und zwar <i>true</i> und <i>false</i>, welche auf deutsch so viel wie <i>richtig</i> und <i>falsch</i> bedeuten.
</p>

```javascript
Code-Script 3.06

public boolean atWorldEdge()
{
}
```

<p>
Damit <i>atWorldEdge</i> funktionieren kann, müssen ihre Rückgabetypen definiert werden. Diese werden als Teil der Methode in dessem Block implementiert. Hierfür benötigen wir die Anweisung <i>return</i>, die verschiedene Ausdrücke wie z. B. "wahr" oder "falsch" als Rückgabetypen zurückgeben kann. Dabei wird der Inhalt zwischen <i>return</i> und dem Semikolon als Rückgabetyp festgelegt.
</p>

```javascript
Code-Script 3.07

return [Rückgabetyp] ;
```

<p>
In unserem Fall verwenden wir als Rückgabetypen <i>true</i> und <i>false</i>, die Aufschluss darüber geben sollen, ob sich ein Asteroid am Rand der Welt befindet oder nicht.
</p>

```javascript
Code-Script 3.08

public boolean atWorldEdge()
{
   return true;
}
```

<p>
Würde man die obige Programmierzeilen verwenden, so würde die Methode ständig den Rückgabetyp <i>true</i> zurückgeben. Die Rückgabetypen "wahr" und "falsch" müssen an Bedingungen verknüpft werden, damit sie sinnvoll eingesetzt werden können. Um herrauszufinden, ob sich ein Asteroid am Rand der Welt befindet, müssen die Positionskoordinaten der Asteroiden bekannt sein. Diese lassen sich mit den Methoden <i>getX()</i> und <i>getY()</i> abrufen. Erreicht ein Asteroid z. B. den linken Rand der Welt, so soll <i>atWorldEdge()</i> den Rückgabetyp <i>true</i> zurückgeben. Um den linken Rand zu erreichen muss die x-Koordinate gleich null sein. Der Rückgabetyp der Methode <i>getX()</i> muss also gleich null sein. Im Javascript (siehe Code ) verwenden wir hierfür den Operator "==", der als aritmetischer Ausdruck "ist gleich" bedeutet.
</p>

<pre><code>Code-Script 3.09
getX() == 0
</code></pre>

<p>
Diesen Ausdruck können wir als Bedingung für eine if-Methode verwenden. In den geschweiftern Klammern der if-Methode legen wir fest durch <i>return true</i> fest, dass, wenn ein Asteroid eine Ortkoordinate von x = 0 aufweist, die Methode <i>atWorldEdge()</i> den Ausdruck <i>true</i> zurückschickt.
</p>

```javascript
Code-Script 3.10

public boolean atWorldEdge()
{
   if(getX() == 0)
   {
      return true;
   }
}
```   

<p>
Die Asteroiden sind bisher in Lage, die Welt über den linken Rand zu verlassen, der obere und untere stellen jedoch immer noch eine Barriere für die Asteroiden dar. Äquivalent zum linken Rand wäre es naheliegend, wenn weitere if-Methoden mit den maximalen y-Koordianten (0 und 540) aufgestellt werden und so die Ränder passierbar gemacht werden. Hier taucht jedoch ein Problem auf: Erscheinen die Asteroiden beim Start des Szenarios in der Welt würden sie direkt als "am Rand der Welt" gekennzeichnet werden, was sie aus der Welt entfernen würde. Das liegt daran, dass die Asteroiden die Welt an den gleichen y-Koordinaten betreten und verlassen.
</p>

```javascript
Code-Script 3.11

public boolean atWorldEdge()
{
   if(getY() == 0 || getY() == 539)
   {
      return true;
   }
}
```

<p>
Wir müssen also zwischen den Asteroiden unterscheiden, die das Szenario betreten und denen, die es verlassen. Zur Unterscheidung könnte beispielsweise die Richtung dienen in der sich die Asteroiden relativ zu den Rändern bewegen. Wir können also zwischen den Asteroiden unterscheiden, die sich auf die Grenzen der Welt zubewegen und denen, die im Begriff sind, sich durch das Szenario zu bewegen. Hier kommt wieder Variable <i>TypeOfRotation</i> ins Spiel. Sie legt fest, ob sich die Asteroiden in einer Aufwärtsbewegung oder einer Abwärtsbewegung befinden. Ihr Wert gibt damit auch Aufschluss darüber, auf welchen Rand sich die Asteroiden zubewegen. Ein Asteroid, der eine Aufwärtsbewegung erfährt, bewegt sich auf den oberen Rand zu. Für eine Aufwärtsbewegung muss die Variable <i>TypeOfRotation</i> positiv sein (siehe Code-Script 3.05). Bewegt sich ein Asteroide auf den oberen Rand zu, so erreicht er irgendwann die Koordinaten (x|0). Wenn beide Bedinunngen erfüllt sind, soll der Asteroid entfernt werden. Wir formulieren also als Bedingung in einer if-Methode, dass, wenn die y-Ortskoordinate gleich 0 ist und die Variable <i>TypeOfRotation</i> gleich 0 ist, der Rückgabetyp <i>true</i> von <i>atWorldEdge</i> zurückgegeben wird. Hierfür verwenden wir arithmetischen Ausdruck "<span>&amp;&amp;</span>", der so viel wie "und" bedeutet. Es müssen beide Bedingungen erfüllt sein, um den Rückgabetyp <i>true</i> zurückzugeben. 
</p>

```javascript
Code-Script 3.12

public boolean atWorldEdge()
{
    if(getX() == 0)
    {
        return true;
    }
    if(getY() == 0 && TypeOfRotation == 0)
    {
        return true;
    }
}
```

<p>
Äquivalent zur Aufwärtsbewegung gilt für den unteren Rand, dass die Variable <i>TypeOfRotation</i> gleich 1 sein muss und dass die y-Koordinate der maximalen y-Koordiante des Szenarios entsprechen muss. Unser Szenrio hat eine Abmessungen von 960*540 Pixeln. Sowohl die x- als auch die y-Koordiantenachsen fangen bei 0 an. Das Pixel in der linken oberen Ecke weist die Koordinaten (0|0) auf. Da die Welt nur über 960*540 Pixel verfügt, hat das Pixel in der gegenüberliegenden, rechten unteren Ecke die Koordnaten (959|539). Dies sind gleichzeitig auch die betragsmaximalen Koordinaten der Welt. Daraus folgt, dass die Asteroiden entlang der y-Achse maximal die Ortskoordinaten (x|539) erreichen können. Deshalb muss die Methode <i>getY()</i> in der if-Bedingung gleich 539 gesetzt werden. Mithilfe des arithmetischen Ausdrucks "||" können wir die Bedinugnen für die Aufwärtsbewegung (<i>TypeOfRotation</i> ist gleich 0, <i>getY()</i> ist gleich 0 und die Abwärtsbewegung (<i>TypeOfRotation</i> ist gleich 1, <i>getY()</i> ist gleich 539) verbinden und in einer Bedingung zusammenfassen. Daraus ergibt sich:
</p>

```javascript
Code-Script 3.13

public boolean atWorldEdge()
{
    if(getX() == 0)
    {
        return true;
    }
    if(getY() == 0 && TypeOfRotation == 0 || getY() == 539 && TypeOfRotation == 1)
    {
     return true;
    }
}
```

<p>
Befinden sich die Asterioden nicht am Rand der Welt soll der Rückgabetyp <i>false</i> zugeschickt werden. Die lässt sich mit einer else-Anweisung um umsetzen. Sind die if-Bedingungen innerhalb einer Methoden nicht erfüllt, so werden stattdessen die Anweisungen der else-Methode umgesetzt.
</p>

```javascript
Code-Script 3.14

import greenfoot.*;
int Angle = Greenfoot.getRandomNumber(50);
int TypeOfRotation = Greenfoot.getRandomNumber(2);
public boolean atWorldEdge()
{
    if(getX() == 0)
    {
        return true;
    }
    if(getY() == 0 && TypeOfRotation == 0 || getY() == 539 && TypeOfRotation == 1)
    {
                      return true;
    }
    else
    {
        return false;
    }
}
```

 Wenn ein Objekt der Asteroiden-Klasse nun den Rand der Welt berührt, wird aus dieser Welt genau das Objekt entfernt, welches den Rand gerade berührt. Das Objekt, das sich in der Welt bewegt hat kann sich durch den Ausdruck this sozusagen selbst beim Kollidieren mit dem Rand der Welt entfernen:


```javascript
if (atWorldEdge())
{
    getWorld().removeObject(this);
}
```


<h4>
<a id="Code-Zusammenfassung Asteroiden"> 2.3.5 Code-Zusammenfassung</a>
</h4>

 Fasst man Code-Script 3.05 und 3.14 zusammen, so ergibt sich für den Code der Asteroiden:


```javascript
Code-Script 3.15

import greenfoot.*;
public class Asteroid extends mover
{
   int Angle = Greenfoot.getRandomNumber(50);
   int TypeOfRotation = Greenfoot.getRandomNumber(2);
   public void act()   {
       move(-12);
       if (TypeOfRotation == 0)
       {
           setRotation(Angle);
        }
       if (TypeOfRotation == 1)
       {
           setRotation(-Angle);
       }
       if (atWorldEdge())
       {
           getWorld().removeObject(this);
       }
   }
   public boolean atWorldEdge()
   {
      if(getX() == 0)
      {
          return true;
      }

if(getY() == 0 && TypeOfRotation == 0 || getY() == getWorld().getHeight() - 1 && TypeOfRotation == 1)
      {
          return true;
      }
      else
      {
          return false;
      }
   }
}
```


<h4>
<a id="Der Score"> 2.4 Der Score</a>
</h4>

Anschließend benötigen wir eine Score-Klasse, damit das Spiel auch reizend wird und Spaß macht, da es sonst, wenn man eh keine Punkte einsammeln kann, schnell langweilig wird. Zunächst haben wir die Score Klasse ohne ein Bild als eine neue Klasse zur Welt hinzufegügt.
Dann haben wir mithilfe von int unseren Score auf 0 festgelegt, das heißt bevor unser Spiel beginnt, zeigt der Score immer einen Punktestand von 0 an. Damit Greenfoot diesen in der Welt überhaupt anzeigt, haben wir zu unserem Score 0 Punkte erst einmal hinzugefügt. Zu diesem Score soll dann mit der Zeit die Punktemenge (amount) hinzugefügt werden, sodass der alte score dann = der neue score und die hinzugefügte Punktemenge ist. Das Bild des Scores, dem wir den Namen robin gegeben haben, ist ein neues Greenfoot Bild mit zunächst der Länge 10 und der Breite 10. Dieses neue Bild wird dann mit dem Befehl .drawString in die Welt mit den Koordinaten x=200 und y=500 in die Welt eingefügt/eingezeichnet mit der Schrift Score: und dann dahinter der entsprechenden Punktezahl. Mithilfe von setImage() lässt sich dieses neu erstellte Objekt robin dann auch in der Welt wiederfinden.

Bei uns jedoch funktioniert der score noch nicht wie gewollt, da Greenfoot noch keine Punkte für ein bestimmtes Objekt zum Score hinzufügt. Dazu haben wir schon eine neue Klasse erstellt, die Goldball Klasse,die wir finn genannt haben. Die Goldbälle sollen sich ähnlich wie die Asteroiden verhalten, allerdings viel seltener spawnen, damit das Spiel nicht zu leicht ist. Für jeden Goldball soll dann eine bestimmte Punktemenge z.B. 20 zum Score hinzugefügt werden. Das versuchen wir in der nächsten Zeit zu programmieren. Hier erst einmal der Code für die Score-Klasse: 

```javascript
int score = 0;
   
public Score() {
      add(0);
    }
  public void add(int amount) {
  
      score = score + amount;
      
      GreenfootImage robin = new GreenfootImage(10, 10);
      robin.drawString("Score: " + score, 200, 500);
      setImage(robin);    
      
}
```

<h4>
<a id="Game-Over"> 2.5 Game-Over</a>
</h4>
 

Beim Programmieren des Game-Overs sind wir ähnlich vorgegangen wie bei der Programmierung des Scores. Zuerst haben wir die neue Klasse mit dem Namen game-Over mit einem bei Paint selbst erstellten Bild zur Welt hinzugefügt. Das Bild hat einen Weißen Game-Over-Schriftzug mit einem schwarzen Hintergrund und passt somit zum Hintergrund der Welt. Wir haben auch hier das Bild robin genannt und als neues Bild mit der Länge 300 und der Breite 200 identifiziert. Mithilfe von .drawString fügen wir auch dieses neu erstellte Bild in die Welt hinzu und lassen es beim vorher definierten Game-Over, nämlich wenn die Rakete einen Asteroiden crasht, mit den Koordinaten x=100 und y=200 in der Welt erscheinen. Es befindet sich somit recht mittig auf dem Bildschirm. Der Code sieht dann folgendermaßen aus:

```javascript
public GameOver()  {
     GreenfootImage robin = new GreenfootImage(300,200);
     robin.drawString ("Game Over", 100, 200);
```


<h4>
<a id="Der Goldball finn">2.6 Der Goldball finn</a>
</h4>

Wie schon erwähnt, haben wir uns dazu entschlossen, eine Goldball-Klasse zu erstellen, um das Asteroiden Spiel spannender zu machen und einen unterschiedlich hohen Score erreichen zu können, da die einzelnen Goldbälle Punkte geben sollen.
Zu Beginn haben wir eine neue Klasse namens finn hinzugefügt und dieser das fertige Bild eines Goldballs zugeordnet. 
Der Programmiercode des Goldballs sieht zwar lang und kompliziert aus, ist im Endeffekt jedoch fast der gleiche wie der der Asteroiden, da diese mit fast den gleichen Eigenschaften durch die Welt fliegen sollen. Die Goldbälle sollen lediglich viel seltener spawnen, als die Asteroiden. Der einzige Unterschied besteht darin, dass der Goldball beim Kollidieren mit der Rakete nicht aus der Welt entfernt wird, sondern weiterhin in der Welt existiert. Der Goldball hat jedoch noch keine große Funktion, da er noch nicht, wie die Asteroiden, ständig neu spawnt und Punkte einbringen. Dies versuchen wir in der nächsten Zeit zum Laufen zu bringen.

```javascript
int Angle = Greenfoot.getRandomNumber(10);
    int TypeOfRotation = Greenfoot.getRandomNumber(2);
  
    
    public boolean atWorldEdge()    {
        if(getX() == 0)
        {
            return true;
        }
        if(getY() == 0 || getY() > getWorld().getHeight() - 2 && TypeOfRotation == 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
public void act()
{
    move(-12);
  
    if (TypeOfRotation == 0)
{
    setRotation(Angle);
}
    if (TypeOfRotation == 1)
{
    setRotation(-Angle);
}

    if (atWorldEdge())
{
    getWorld().removeObject(this);
}
```

<p>
Dies ist unser derzeitiger Stand zu unserem Spiel SpaceRocket, dennoch haben wir das Projekt noch nicht fertiggestellt da uns noch viele Dinge fehlen, die wir geplant haben:
</p>

<h3>
<a id= "Was noch zu tun ist"> 3. Was noch zu tun ist</a>
</h3>

1. Das Einfügen und Programmieren eines Scores, der den Punktestand abhängig von den eingesammelten Goldbällen zählt und beim game-over angezeigt wird.
2. Das Hinzufügen von Bomben, die explodieren können und sich ähnlich wie die Asteroiden verhalten
3. Das Einfügen einer Bullet-Klasse (und Programmieren), denn die Rakete soll später in bestimmten Abständen und mit bestimmter Munition schießen können.
4. Das Einfügen von Sternen in den Hintergrund, die den Eindruck erwecken sollen, dass man mit der Rakete wirklich durch den Weltraum fliegt.
5. Das Einfügen von Sounds, z.B. bei der Explosion oder beim Game-Over.
6. Goldbälle sollen während des Spiels genau wie die Asteroiden neu spawnen und Punkte einbringen.

<h3>
<a id="Quellen"> 4. Quellen</a>
</h3>
<ul>
<li>Michael Kölling: *Einführung in Java mit Greenfoot*. Pearson Education Deutschland GmbH, 2010</li>
</ul>
