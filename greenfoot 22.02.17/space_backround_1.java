import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class space_backround_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class space_backround_1 extends World
{
   int counter =0;
   Score Score;
/**
     * Constructor for objects of class space_backround_1.
     * 
     */
    public space_backround_1()
    {
        super(960, 540, 1, true);
        addObject(new rocket(), 150, 270);
        addObject(new counter(), 30, 30);
        addObject(new Asteroid(), 960, Greenfoot.getRandomNumber(541) - 0);
        addObject(new Asteroid(), Greenfoot.getRandomNumber(480) + 480, 1);
        addObject(new Asteroid(), Greenfoot.getRandomNumber(480) + 480, 540);
        Score = new Score();
        addObject(new robin(), 30, 510); 
        addObject(new finn(), 960, Greenfoot.getRandomNumber(541) - 0);
        
    }
    
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