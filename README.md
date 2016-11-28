# SpaceRocket
## Ein Informatik-Projekt von Robin Wagner und Finn Westphal

##Einleitung: Anforderungen und Elemente des Spiels
Space Rocket ist ein Highscore-Spiel auf Greenfoot-Basis, in dem man mit einer Rakete, die sich am linken Bildschirmrand befindet und sich nur nach oben oder unten bewegen kann, versucht, Asteroiden, die nur von der rechten Bildschirmseite heranfliegen, in einem Asteroidenfeld auszuweichen. Jeder Asteroid verschwindet aus der Welt, wenn er den Rand der Welt erreicht. Man verliert, wenn man mit einem Asteroiden zusammenstößt.
 
###Umsetzung
Wir programmieren unser Projekt "SpaceRocket" in der Programmierumgebung "Greenfoot", die auf der obejktorientierten Programmiersprache *Java* basiert. Zunächst haben wir festgelegt, welche Größe, welches Format und welche Auflösung unsere Welt haben soll. Unser Spiel soll über eine klassische Auflösung und ein klassischen Seitenverhälnis verfügen, damit es auf jedem Computer spielbar ist. Wir haben uns deswegen für das Seitenverhältis von 16/9 und eine Auflösung von 960 * 540 Pixeln entschieden. Diese Bildeigenschaften sind von den meisten aktuellen Displays umsetzbar. Mit dem Konstruktor *public* erstellen wir eine Welt-Klasse names *space_backround_1*, die in der Lage ist alle nötigen Methoden auszuführen und durch die Methode *import greenfoot.[Multiplikationszeichen]*; geben wir an, dass diese Klasse in das Szenario implementiert werden soll. Würde nach dem *import greenfoot.* kein "[Multiplikationszeichen]" stehen, so würde diese Klasse beim Start des Programmes nicht geladen werden. Hinter Jeder Klasse stehen mindestens eine geöffnete und eine geschlossene Klammer, die zusetzliche Parameter enthalten können. Zur Ausführung unserer verwendeten Methoden sind keine weiteren Parameter notwendig, weswegen bei uns nichts zwischen den Klammern steht. Die Referenz *super* sorgt dafür, dass alle Eigenschaften der Super- oder Hauptklasse auf alle anderen Klassen übertragen werden. In diesem Fall ist die Super-Klasse die generierte Welt. Diese Anweisung benötigt weiter Parameter für ihre Funktionalität und zwar die Auflösung der generierten Welt und das Verhältnis zwischen Pixeln und Zellen des Zellen-Koordinatensystems, das deckungsgleich zur generierten Welt erstellt wird. Wir wollen diese Verhältnis auf 1:1 festlegen, sodass eine Zelle einem Pixel entspricht. Um diese Parameter dem Konstruktor zur Verfügung zu stellen, schreiben wir nach *super* in Klammern (960, 540, 1, true). Der erste Parameter definert die Anzahl der Pixel entlang der x-Achse, der zweite nach dem Komma die Pixelanzahl in y-Richtung und der dritte Parameter *1* sagt aus das eine Zelle die Größe von einem Pixel in x- und y- Richtung besitzt. Durch das true erreichen wir, dass die Asteroiden und auch die Rakete zunächst nicht aus der Welt verschwinden können, sondern nicht in der Lage sind die Welt an ihrem Rand zu verlassen. Am Ende dieser Zeile steht ein Semikolon, die das Ende einer Methode festlegt. Danach haben wir in Greenfoot einen Hintergrund unserer Welt gesucht, der möglichst zum Spiel passen sollte. Wir haben uns schließlich für den vorgefertigten Greenfoot-Hintergrund *space1* entschieden.

```javascript
import greenfoot.*;
public space_backround_1()
    {
        super(960, 540, 1, true);
    }
```

Bisher enthält unsere Welt noch keine Objekte, die agieren können und für unser Spiel relevant sind. Wir benötigen in jedem Fall zunächst eine Raketen- und eine Asteroiden-Klasse. Andere Klassen, die wir für unser Spiel später auch brauchen, z.B. eine Score- oder gamve-over Klasse, haben wir zunächst vernachlässigt. Erst einmal wollten wir, dass jeweils vor Spielbeginn eine Rakete an einem festen Ort startet und verschiedene Asteroiden an immer anderen Punkten der Welt, allerdings nur in der rechten Hälfte der Welt, spawnen. Dazu haben wir, wie in dem obigen Befehl zu sehen, mithilfe der Methode *addObject* eine Rakete hinzugefügt, die jedes Mal, wenn man das Spiel startet, an der Position X= 150 und Y= 270 startet. 

Die Methode *addObject* benötigt bestimmte Parameter. Zu diesen zählt zum einen die Bezeichnung des zu generierenden Objektes einer Klasse und seine Position in der Welt. Hierzu wird nach *addObject* in Klammern die jeweilige Klasse genannt mit dem Aufdruck *new* davor, welcher als Referenz festlegt, dass ein Objekt dieser Klasse hinzugefügt werden soll und, durch Kommata getrennt, die Koordinaten des jeweiligen Objektes.

Diese Koordinaten haben wir so gewählt, dass die Rakete ziemlich weit links, aber nicht am Rand, startet und genau die Hälfte der Höhe besitzt. Weiterhin lassen wir Asteroiden spawnen, die sich an immer anderen Positionen befinden können. Der erste Asteroid hat die X-Koordinate 960 und befindet sich genau am rechten Rand der Welt mit einer Y-Koordinate die von 0 bis 540, also von ganz unten bis ganz oben variieren kann. Weiterhin lassen wir Asteroiden spawnen, die sich an immer anderen Positionen befinden können. Der erste Asteroid hat die X-Koordinate 960 und befindet sich genau am rechten Rand der Welt mit einer Y-Koordinate die von 0 bis 540, also von ganz unten bis ganz oben variieren kann. Dies erreichen wir durch die Methode *Greenfoot.getRandomNumber*, die eine zufällige Zahl zwischen 0 und dem jeweiligen in Klammern stehenden Grenzwert generiert. Der Grenzwert ist dabei ausgeschlossen. Der 2. Asteroid kann zwischen den X-Koordinaten 480 und 480+480, also maximal 960 entstehen. Das Bedeutet, dass er immer zufällig zwischen der Hälfte der Welt und dem rechten Ende spawnt. Die y-Koordinate beträgt 1, weshalb der Asteroid bei den genannten x- Koordinaten immer ganz oben entsteht. Der 3.Asteroid hat die gleichen X-Koordinaten, spawnt aber durch die festgelegte y-Koordinate immer ganz unten. Hinzuzufügen ist außerdem, dass Greenfoot bei einer zufälligen Zahl, also dem Befehl Greenfoot.getRandomNumber nur Zahlen aus dem Bereich von 0 bis zur natürlichen Zahl vor der gewollten Zahl nimmt, also bei z.B. 1 liegt diese "zufällige" Zahl immer bei 0. Der Counter hat in unserer Welt noch keine Bedeutung, da wir noch keine Counter-Klasse erstellt haben. 

```javascript
        addObject(new rocket(), 150, 270);
        addObject(new counter(), 30, 510);
        addObject(new Asteroid(), 960, Greenfoot.getRandomNumber(541) - 0);
        addObject(new Asteroid(), Greenfoot.getRandomNumber(480) + 480, 1);
        addObject(new Asteroid(), Greenfoot.getRandomNumber(480) + 480, 960);
```

Danach haben wir uns um die Rakete gekümmert. Diese soll sich zwar nicht nach links und rechts bewegen, da die Asteroiden auf die Rakete hingeflogen kommen sollen, aber sie soll sich nach oben und unten bewegen können. Zuerst haben wir ein Bild einer Rakete zur Actor-Klasse Rocket hinzugefügt und uns dann mit dem Code beschäftigt. Mithilfe von public void act konnten wir erstmal festlegen, dass die Rakete alles das tut, was wir ihr befehlen. Hier haben wir mit den Befehlen setRotation und setLocation gearbeitet. Mithilfe von setRotation können wir festlegen, ob die Rakete sich in einem bestimmten Winkel dreht oder eben nicht. Mit setLocation können wir der Rakete einen neuen Ort, also neue Koordinaten zuordnen. Da sich die Rakete in der Ausgangsposition nicht bewegen soll, haben wir erstmal setRotation=0 gesetzt. Und weil wir die Rakete steuern wollen, haben wir festgelegt, dass, wenn s oder alternativ die Pfeiltaste nach unten bewegt wird, die Rakete um 20 Grad nach unten rotiert und einen neuen Platz erhält. Dieser ist durch die  X-Koordinate, die gleich bleibt und die Y-Koordinate, die immer um 12 vergrößert wird, damit die Rakete sich auch bewegt, festgelegt.
Gleichzeitig soll die Rakete aber nie den unteren Bildschirmrand erreichen, weshalb wir gesagt haben, dass die Y-Koordinate immer noch kleiner sein soll als 540. Genau andersherum funktioniert es, wenn man die w Taste oder alternativ die Pfeiltaste nach oben drückt. Die Rakete bewegt sich um 20 Grad nach oben, erhält eine um 12 verringerte y- Koordinate (die X-Koordinate bleibt gleich), damit die Rakete nach oben rotiert und gleichzeitig durch den Befehl getY() > 0) aber nie den oberen Rand der Welt erreicht. Somit war die Programmierung der Rakete abgeschlossen, da das alles ist, was die Rakete können soll.

```javascript
import greenfoot.*;
public class rocket extends mover
{
public void act()
{
{
    setRotation(0);
}
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

Anschließend haben wir uns um die Programmierung der Asteroiden gekümmert, in die wir bisher am meisten Zeit hineingesteckt haben. Zu Beginn haben wir uns ein Asteroiden Bild in einer angemessenen Größe heruntergeladen und als Bild unserer Asteroiden in Greenfoot verwendet. Bei der Programmierung der Asteroiden haben wir zunächst zwei Variablen mithilfe von int festgelegt: 1. den Winkel, der eine zufällige Zahl von 0 bis 49 annimmt, damit die Asteroiden sich auch auf die Rakete hin bewegen und nicht in eine völlig andere Richtung und 2. die Art der Drehung, die eine zufällige Zahl von 0-1 erhält. Dies bedeutet, dasss die Asteroiden sich jeweils nach links unten oder nach links oben drehen können. Befasst haben wir uns dann mit dem "Crashen" der Asteroiden gegen den Rand der Welt. Dazu haben wir public boolean atWorldEdge() benutzt. Das boolean beschreibt zwei Fälle, die vorkommen können. Entweder richtig(true) und falsch (false). Wenn die X-Koordinate = 0 ist, also die Asteroiden sich am linken Bildschirmrand befindet, werden diese entfernt (return). Wenn die y-Koordinate = 0 ist oder die Asteroiden sich am unteren Bildrand befinden, werden sie ebenfalls entfernt, egal ob sie richtig oder falsch waren. Dann haben wir wieder mit public void act, wie wir es bei der Rakete auch getan haben, den Asteroiden befohlen, sich mit einer Geschwindigkeit von -12, also nur nach links (zur Rakete hin) zu bewegen. Jetzt kommen die beiden Variablen ins Spiel: Mithilfe erneuter if-Befehler konnten wir festlegen, dass die Asteroiden, wenn die TypeofRotation 0 beträgt, einen oben festgelegten positiven Winkel erhalten und wenn die TypeofRotation 1 beträgt, einen festgelegten negativen Winkel bekommen. Schließlich entfernen die Asteroiden durch den Befehl atWorldEdge sich quasi selbst, wenn sie eben einen Rand in der Welt erreichen.  

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
