import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
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

}