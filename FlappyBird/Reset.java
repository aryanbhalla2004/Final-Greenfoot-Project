import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Reset here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Reset extends Actor
{
    /**
     * act is a method that is check if the mouse clicked is true on the reset button if it is true then it will reset the world...
     * to flappyWorld
     */
    public void act() 
    {
        if(Greenfoot.mousePressed(this) == true)
        {
            Greenfoot.setWorld(new FlappyWorld()); //starts a new world
        }
    }    

    /**
     * reset is a Constructor that scaling the image to 52 x 35
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public Reset()
    {
        getImage().scale(52,35);
    }
}
