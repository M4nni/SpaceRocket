# SpaceRocket

## Ein Informatik-Projekt von Robin Wagner und Finn Westphal

##Einleitung: Anforderungen und Elemente des Spiels
Space Rocket ist ein Highscore-Spiel auf Greenfoot-Basis, in dem man mit einer Rakete, die sich am linken Bildschirmrand befindet und sich nur nach oben oder unten bewegen kann, versucht, Asteroiden, die nur von der rechten Bildschirmseite heranfliegen, in einem Asteroidenfeld auszuweichen. Jeder Asteroid verschwindet aus der Welt, wenn er den Rand der Welt erreicht. Man verliert, wenn man mit einem Asteroiden zusammenstößt.
 
###Umsetzung
Wir programmieren unser Projekt "SpaceRocket" in der Programmierumgebung "Greenfoot", die auf der obejktorientierten Programmiersprache *Java* basiert. Zunächst haben wir festgelegt, welche Größe, welches Format und welche Auflösung unsere Welt haben soll. Unser Spiel soll über eine klassische Auflösung und ein klassischen Seitenverhälnis verfügen, damit es auf jedem Computer spielbar ist. Wir haben uns deswegen für das Seitenverhältis von 16/9 und eine Auflösung von 960 * 540 Pixeln entschieden.
Diese Bildeigenschaften sind von den meisten aktuellen Displays umsetzbar. Mit dem Konstruktor *public* erstellen wir eine Welt-Klasse names *space_backround_1*, die in der Lage ist alle nötigen Methoden auszuführen und durch die Methode *import greenfoot.[Multiplikationszeichen]*; geben wir an, dass diese Klasse in das Szenario implementiert werden soll. Würde nach dem *import greenfoot.* kein "[Multiplikationszeichen]" stehen, so würde diese Klasse beim Start des Programmes nicht geladen werden. Hinter Jeder Klasse stehen mindestens eine geöffnete und eine geschlossene Klammer, die zusetzliche Parameter enthalten können. Zur Ausführung unserer verwendeten Methoden sind keine weiteren Parameter notwendig, weswegen bei uns nichts zwischen den Klammern steht. Die Referenz *super* sorgt dafür, dass alle Eigenschaften der Super- oder Hauptklasse auf alle anderen Klassen übertragen werden. In diesem Fall ist die Super-Klasse die generierte Welt. Diese Anweisung benötigt weiter Parameter für ihre Funktionalität und zwar die Auflösung der generierten Welt und das Verhältnis zwischen Pixeln und Zellen des Zellen-Koordinatensystems, das deckungsgleich zur generierten Welt erstellt wird. Wir wollen diese Verhältnis auf 1:1 festlegen, sodass eine Zelle einem Pixel entspricht. Um diese Parameter dem Konstruktor zur Verfügung zu stellen schreiben wir nach *super* in Klammern (960, 540, 1, true). Der erste Parameter definert die Anzahl der Pixel entlang der x-Achse, der zweite nach dem Komma die Pixelanzahl in y-Richtung und der dritte Parameter *1* sagt aus das eine Zelle die Größe von einem Pixel in x- und y- Richtung besitzt. Durch das true erreichen wir, dass die Asteroiden und auch die Rakete zunächst nicht aus der Welt verschwinden können, sondern nicht in der Laage sind die Welt an ihrem Rand zu verlassen. Am Ende dieser Zeile steht ein Symikolon, die das Ende einer Methode festlegt. Danach haben wir in Greenfoot einen Hintergrund unserer Welt gesucht, der möglichst zum Spiel passen sollte. Wir haben uns schließlich für den vorgefertigten Greenfoot-Hintergrund *space1* entschieden.

```javascript
import greenfoot.*;
public space_backround_1()
    {
        super(960, 540, 1, true);
    }
```

Bisher enthält unsere Welt noch keine Objekte, die agieren können und für unser Spiel relevant sind. Wir benötigen in jedem Fall zunächst eine Raketen- und eine Asteroiden-Klasse. Andere Klassen, die wir für unser Spiel später auch brauchen, z.B. eine Score- oder gamve-over Klasse, haben wir vorerst vernachlässigt. Zunächst wollten wir, dass jeweils vor Spielbeginn eine Rakete an einem festen Ort startet und verschiedene Asteroiden an immer anderen Punkten der Welt, allerdings nur an den Rändern der rechten Welthälfte, spawnen. Dazu haben wir, wie in dem folgenden Befehl zu sehen, mithilfe der Methode *addObject* eine Rakete hinzugefügt, die jedes Mal, wenn man das Spiel startet, an der Position x = 150 und y = 270 startet. Die Methode *addObject* benötigt bestimmte Parameter. Zu diesen zählt zum einen die Bezeichnung des zu generierenden Objektes einer Klasse und seine Position in der Welt. Hierzu wird nach *addObject* in Klammern die jeweilige Klasse mit dem Aufdruck *new* davor genannt, welcher als Referenz festlegt, dass ein Objekt dieser Klasse hinzugefügt werden soll und, durch Kommata getrennt, die Koordinaten des jeweiligen Objektes. Diese Koordinaten haben wir so gewählt, dass die Rakete ziemlich weit links, aber nicht am Rand, startet und genau die Hälfte der Höhe besitzt. Weiterhin lassen wir Asteroiden spawnen, die sich an immer anderen Positionen befinden können. Der erste Asteroid hat die x-Koordinate 960 und befindet sich genau am rechten Rand der Welt mit einer y-Koordinate die von 0 bis 540, also von ganz unten bis ganz oben variieren kann. Dies erreichen wir durch die Methode *Greenfoot.getRandomNumber*, die eine zufällige, natürliche Zahl zwischen 0 und dem jeweiligen in Klammern stehenden Grenzwert generiert. Der Grenzwert (hier: 541) ist dabei ausgeschlossen. Der 2. Asteroid kann zwischen den x-Koordinaten 480 und 480 + 480, also maximal 960 entstehen. Das bedeutet, dass er immer zufällig zwischen der Hälfte der Welt und dem rechten Rand spawnt. Die y-Koordinate beträgt 1, weshalb der Asteroid nur am oberen Rand der spawnen kann. Dem 3. Asteroid sind die gleichen x-Koordinaten zugewiesen, er spawnt aber durch die festgelegte y-Koordinate von 540 immer am unteren Rand. Der Counter hat in unserer Welt noch keine Bedeutung, da wir noch keine Counter-Klasse erstellt haben.

```javascript
        addObject(new rocket(), 150, 270);
        addObject(new counter(), 30, 510);
        addObject(new Asteroid(), 960, Greenfoot.getRandomNumber(541) - 0);
        addObject(new Asteroid(), Greenfoot.getRandomNumber(480) + 480, 1);
        addObject(new Asteroid(), Greenfoot.getRandomNumber(480) + 480, 540);
```

Danach haben wir uns um die Rakete gekümmert. Diese soll sich zwar nicht nach links und rechts bewegen, da die Asteroiden auf die Rakete zufliegen sollen, aber sie soll sich nach oben und unten bewegen können. Zuerst haben wir ein Bild einer Rakete zur Actor-Klasse Rocket hinzugefügt und uns dann mit dem Code beschäftigt. Mithilfe des Konstruktors *public* erstellten wir eine Klasse, die in der Lage ist, mit anderen Klassen Informationen austauschen. Wir verwenden die Methode *void act()*. Der Rückgabetyp *void* gibt an, ob und wenn ja, welche Informationen zuzückgegeben werden. In diesen Fall bedeutet *void* so viel wie "nichts", wir erhalten dementsprechend keine Informationen über die Ausführung der Methode. *void act()* ist ausschließlich eine ausführende Methode, die keine weiteren Parameter für ihre Ausführung benötigt, weswegen in den Klammern von *act()* kein Inhalt vorhanden ist. Sie wird beim starten des Szenarios, z. B. durch betätigen des *Act-Buttons*, kontinuierlich ausgeführt, bis das Szenario beendet wird. Dabei werden die einzelnen Methoden innerhalb von *act()* der Reihe nach ausgeführt. Wir legen mit dieser Methode das Verhalten der Rakete fest. Hier haben wir mit den Befehlen *setRotation()* und *setLocation()* gearbeitet. Mithilfe von *setRotation* können wir die Neigung der Rakete bestimmen. Zur Steuerung der Rakete verwenden wir "w" für "nach oben" und "s" für "nach unten" oder alternativ die Pfeiltasten "up" und "down". Solange eine der Tasten gedrückt wird soll sich die Rakete mit einer bestimmten, konstanten Geschwindigkeit in die jeweilige Richtung bewegen. Damit dies visuell verdeutlicht wird, soll gleichzeitig während des Tastendrucks die Rakete durch *setRotation* in einer bestimmte Neigung ausgerichtet werden.
Um diese Steuerung in Greenfoot umzusetzen, haben wir unnächst festgelegt, dass die Rakete horizontal ausgerichtet ist, weswegen wir zuerst in der Methode *setRotation* den Parameter für den Rotationswinkel gleich null gesetzt haben.

```javascript
   {
      setRotation(0);
   }
```

Damit sich die Rakete beim Tastendruck mit konstanter Geschwindigkeit nach unten bewegt, verwenden wir die Methode *setLocation*, die mindestens drei weitere Parameter für ihre Funktion benötigt, welche die aktuelle Position des Objektes in der Welt und die Bewegungsrichtung relativ zu dieser Position ist. Die Rückgabetypen *getX* und *getY* geben die aktuellen Koordinaten des klassenspezifischen Objektes an. Sie werden durch ein Komma getrennt und in den Klammern der Methode *setLocation* integriert. Damit nun bei Tastendruck eine Bewegung vollzogen wird, kann man hinter jedem Rückgabetypen eine natürliche Zahlen addiert bzw. subtrahiert werden. So wird bei jeder Ausführung dieses frames oder Blocks das Objekt um die jeweiligen Koordinaten bewegt. Durch das mehrfache Ausführen dieser Methode resultiert daraus eine lineare Fortbewegungsrichtung. Für unsere Anwendung soll sich unser Objekt, die Rakete, lediglich entlang der y-Achse bewegen, weswegen die x-Koordinate unverändert bleibt. Zur visuellen Verdeutlichung verwenden wir außerdem die Methode *setRoation*, die das Objekt, in diesem Fall unsere Rakete, im einem bestimmten Winkel ausrichtet. Dieser Winkel wird in Klammer an die Methode ergänzt. Durch ausprobieren haben wir herausgefunden, dass eine Rotation von 20° bzw. -20° geeignet für die simulierte Bewegung unser Rakete ist. Die Rakete soll außerdem nur beim Tastdruck ihre Position verändern und nicht in der Lage sein die Welt über ihre Grenzen zu verlassen. Um diese Bedingungen mit der Bewegung der Rakete in Verbindung zu bringen verwenden wir eine *if-Methode*, die die Ausführung einer oder mehrerer Methoden nur zulässt, wenn alle ihre Bedingungsparameter erfüllt werden. Werden die Bedingungen erfüllt so werden die in geschweiften Klammern stehende Methode oder Methoden im Anschluss an die if-Methode ausgeführt. In unserem Fall bestehen unsere Bedinungsparameter aus zwei *Greenfoot.isKeyDown*-Methoden und dem Rückgabetyp *getY()*. Die Methode *Greenfoot.isKeyDown* prüft ständig, ob eine bestimmte Taste auf der Tastatur gedrückt wird. Dabei wird der jeweilige Tastenname in Anführungszeichen in Klammern an die Methode ergänzt. Da die Steuerung optional über die Pfeiltasten "oben" und "unten", sowie über die Tasten "w" und "s" erfolgen soll, verwenden wir *Greenfoot.isKeyDown* zweimal pro if-Methode. Für die Abwärtsbewegung bespielsweise verwenden wir *Greenfoot.isKeyDown("down")* und *Greenfoot.isKeyDown("s")*, die durch zwei senkrechte Striche "||" voneinander getrennt werden. Diese bilden einen Operator, der soviel wie "oder" bedeutet. Damit die Rakete die Welt nicht verlassen kann haben wir den Rückgabetyp *getY()* als kleiner als 540 festgelegt, was der maximalen y-Koordianten unserer Welt entspricht. Er wird mit zwei Et-Zeichen "&&" an die beiden *Greenfoot.isKeyDown* ergänzt. Die beiden Et-Zeichen ergeben ebenfalls einen Operator mit der Bedeutung "und". Daraus folgt, dass die Bedingung der if-Methode nur erfüllt ist, wenn mindestens einer der Tasten "down" oder "s" gedrückt wird und die aktulle Position der Rakete eine kleinere y-Koordinate als 540 aufweist. Werden die Bedingungen erfüllt, bewegt sich die Rakete mit einer Geschwindigkeit von 12 Pixeln pro frame-Ausführung entlang der y-Achse in Richtung der unterm Kante der Welt. 

```javascript
   if (Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s") && getY() <= 540)
   {
      setRotation(20);
      setLocation(getX(), getY()+12);
   }
```

Äquivalent dazu ergibt sich für die Aufwärtsbewegung:

```javascript
   if (Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w") && getY() >= 0)
   {
   setRotation(-20);
   setLocation(getX(), getY()-12);
   }
```

Hier wurden "down" und "s" durch "up" und "w" ersetzt und der der Rückgabewert *getY* größer gleich 0 gesetzt. Dadurch ist die Bedingung der if-Methode nur erfüllt, wenn die "up"- oder "w"-Taste gedrückt und die aktuelle y-Koordinaten der Rakete größer als 0 ist. Somit kann die Rakete die Welt nicht an der oberen Kante verlassen. Die Neigung der Aufwärtsbewegung ist betragsgleich der Neigung der Abwärtsbewegung, jedoch ist sie negativ, sodass die Rakete gegen dem Uhrzeigersinn sich mit 20° um die eigene Achse rotiert. In der Methode *setLocation* wird der Rückgabetyp *getY* mit 12 subtrahiert, sodass sich die Rakete nach oben anstatt nach unten bewegt.

Zusammengefasst ergibt sich für den Code der Rakete:

```javascript
import greenfoot.*;
public class rocket extends mover
{
public void act()
{
   setRotation(0);
    
   if (Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s") && getY() < 540)
   {
      setRotation(20);
      setLocation(getX(), getY()+12);
   }
   if (Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w") && getY() > 0)
   {
   setRotation(-20);
   setLocation(getX(), getY()-12);
   }
}
}
```

Anschließend haben wir uns um die Programmierung der Asteroiden gekümmert, in die wir bisher am meisten Zeit hineingesteckt haben. Zu Beginn haben wir uns ein Asteroiden Bild in einer angemessenen Größe heruntergeladen und als Bild unserer Asteroiden in Greenfoot verwendet. Die Asteroiden sollen während das der Ausführung des Szenarios zufällig spawnen und sich von rechts nach links mit einem zufälligen Winkel in Richtung der Rakete bewegen und sobald sie auf den Rand der Welt zufliegen, sollen sie aus dem Szenario entfernt werden. Um diese Anforderungen zu erfüllen benöigen wir eine Methode die in der Lage ist einen Asteroiden zu entfernen, wenn er sich am Rand der Welt befindet. Außerdem brauchen wir eine weitere Methoden, die den Asteroiden eine feste Geschwindigkeit und einen zufälligen Winkel zuweist.

Bei der Programmierung der Asteroiden haben wir zunächst zwei Variablen definiert, um den Code übersichtilicher zu gestalten. Diese Variablen legen die Richtung fest in die sich die Asteroiden bewegen. 

1. den Winkel, der eine zufällige Zahl von 0 bis 49 annimmt, damit die Asteroiden sich auch auf die Rakete hin bewegen und nicht in eine völlig andere Richtung und 2. die Art der Drehung, die eine zufällige Zahl von 0-1 erhält. Befasst haben wir uns dann mit dem "Crashen" der Asteroiden gegen den Rand der Welt. Dazu haben wir public boolean atWorldEdge() benutzt. Das boolean beschreibt zwei Fälle, die vorkommen können. Entweder richtig(true) und falsch (false). Wenn die X-Koordinate = 0 ist, also die Asteroiden sich am linken Bildschirmrand befindet, werden diese entfernt (return). Wenn die y-Koordinate = 0 ist oder die Asteroiden sich am unteren Bildrand befinden, werden sie ebenfalls entfernt, egal ob sie richtig oder falsch waren. Dann haben wir wieder mit public void act, wie wir es bei der Rakete auch getan haben, den Asteroiden befohlen, sich mit einer Geschwindigkeit von -12, also nur nach links (zur Rakete hin) zu bewegen. Jetzt kommen die beiden Variablen ins Spiel: Mithilfe erneuter if-Befehler konnten wir festlegen, dass die Asteroiden, wenn die TypeofRotation 0 beträgt, einen oben festgelegten positiven Winkel erhalten und wenn die TypeofRotation 1 beträgt, einen festgelegten negativen Winkel bekommen. Schließlich entfernen die Asteroiden durch den Befehl atWorldEdge sich quasi selbst, wenn sie eben einen Rand in der Welt erreichen.

```javascript
import greenfoot.*;
int Angle = Greenfoot.getRandomNumber(50);
int TypeOfRotation = Greenfoot.getRandomNumber(2);
public boolean atWorldEdge()    
{
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
   }
}
```

Dies ist unser derzeitiger Stand zu unserem Spiel SpaceRocket, dennoch haben wir das Projekt noch längst nicht fertiggestellt da uns noch viele Dinge fehlen, die wir geplant haben:
1. Es sollen während des Spiel neue Asteroiden spawnen, die aber nur auf der rechten Hälfte entstehen können.
2. Wenn die Rakete einen Asteroiden berührt, soll es eine Explosion geben und der Spieler soll verlieren (game-over).
3. Das game-over, das erscheint, wenn man verliert, fehlt noch.
4. Das Einfügen und Programmieren eines Scores, der den Punktestand abhängig von der überlebten Zeit zählt und beim game-over angezeigt wird.
5. Das Hinzufügen anderer Objekte, wie z.B. Bomben, die explodieren können und sich ähnlich wie die Asteroiden verhalten
6. Das Einfügen einer Bullet-Klasse (und Programmieren), denn die Rakete soll später in bestimmten Abständen und mit bestimmter Munition schießen können.
7. Das Einfügen und Programmieren einer Counter-Klasse.
8. Das Einfügen von Sternen in den Hintergrund, die den Eindruck erwecken sollen, dass man mit der Rakete wirklich durch den Weltraum fliegt.
9. Das Einfügen von Sounds, z.B. bei der Explosion oder beim game-over. 

#ENDE
