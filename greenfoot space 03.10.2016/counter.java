import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class counter  extends Actor
{
    private int counter = 0;
    public counter()
    {
        setImage(new GreenfootImage("Score :", 40, Color.WHITE, Color.BLACK));
    }
    /**
     * Increase the total amount displayed on the counter, by a given amount.
     */
    public void bumpCount(int amount)
    {
        counter += amount;
        setImage(new GreenfootImage("Score :" + counter, 1, Color.WHITE, Color.BLACK));
    }
}
