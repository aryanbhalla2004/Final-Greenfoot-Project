import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class End here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class End extends World
{   
    /**
     * End constructor is adding ground, logo, HighScore, reset button objects to the world and setting the world speed back to normal
     * 
     * @param There is only one param that is int score it is casting score amount in HighScore class.
     * @return Nothing is returned    
     */
    public End(int score)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        addObject(new Ground(), 300, 375);  
        addObject(new logo(), getWidth()/2, 80);
        addObject(new HighScore(score), getWidth()/2, 500);  
        addObject(new Reset(), 560, 21);
        Greenfoot.setSpeed(50);
    }
}
