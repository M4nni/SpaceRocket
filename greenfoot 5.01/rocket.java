import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class rocket extends mover
{
    /**
     * Act - do whatever the rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */ 
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