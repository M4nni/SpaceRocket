# SpaceRocket-Projekt-Informatik-von-Finn-Westphal-und-Robin-Wagner
## Projekt von Robin Wagner und Finn Westphal

##Inhaltsverzeichnis

##Einleitung: Anforderungen und Elemente des Spiels
Space Rocket ist ein Highscore-Spiel auf Greenfoo-Basis, in dem man mit einer Rakete versuchen muss Asteroiden in einem Asteroidenfeld auszuweichen.

##Umsetzung
Wir programmieren unser Projekt "SpaceRocket" in der Programmierumgebung "Greenfoot", die auf der obejktorientierten Programmiersprache *Java* basiert. Zuerst haben wir uns überlegt, welche Größe, welches Format und welche Auflösung unsere Welt haben soll. Unser Spiel soll über eine klassische Auflösung und ein klassischen Seitenverhälnis verfügen, damit es auf jedem Computer spielbar ist. Wir haben uns deswegen für das Seitenverhältis von 16/9 und eine Auflösung von 960 * 540 Pixeln entschieden. Diese Bildeigenschaften sind von den meisten aktuellen Display umsetzbar. Wir haben in Greenfoot 
Greenfoot generiert beim erstellen eines Szenarios ein Zellen-Koordinatensystem, das deckungsgleich zur generierten Welt ist. Das Verhältnis zwischen Pixeln und Zellen ist variabel und durch einen Parameter definiert (In diesem Fall 1).

```javascript
public space_backround_1()
    {
        super(960, 540, 1, true);
        addObject(new rocket(), 150, 270);
        addObject(new counter(), 30, 510);
        addObject(new Asteroid(), 960, Greenfoot.getRandomNumber(540) - 0);
        addObject(new Asteroid(), Greenfoot.getRandomNumber(480) + 480, 1);
        addObject(new Asteroid(), Greenfoot.getRandomNumber(480) + 480, 960);
    }
```
