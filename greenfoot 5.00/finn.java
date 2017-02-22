import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class finn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class finn extends Actor
{
    /**
     * Act - do whatever the finn wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     int Angle = Greenfoot.getRandomNumber(10);
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
