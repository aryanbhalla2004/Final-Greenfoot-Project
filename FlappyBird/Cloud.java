import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cloud here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Cloud extends Actor
{
    //int speed is the speed for making the cloud move
    private int Speed = 1;
    /**
     * Act - do whatever the Cloud wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */    
    /**
     * act is a method that is calling the moveleft , isEdge and scaleing the image.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void act() 
    {
        moveleft();
        isEdge();
        getImage().scale(50,50);
    }    

    /**
     * moveleft is a method that is making the cloud move left by setting the speed
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void moveleft()
    {
        setLocation(getX() - Speed, getY());
    }

    /**
     * isEdge is a method that is making cloud remove them self when they touch the edge.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void isEdge()
    {
        if(isAtEdge() == true)
        {
            getWorld().removeObject(this);
        }
    }
}
