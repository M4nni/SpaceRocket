import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class robin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class robin extends Actor
{
    private int totalCount = 0;
    public robin()
    {
        setImage(new GreenfootImage("0", 40, Color.WHITE, Color.BLACK));
    }
    /**
     * Increase the total amount displayed on the counter, by a given amount.
     */
    public void bumpCount(int amount)
    {
        totalCount += amount;
        setImage(new GreenfootImage("" + totalCount, 1, Color.WHITE, Color.BLACK));
    } 
}
