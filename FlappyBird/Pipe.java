import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Pipe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Pipe extends Actor
{
    boolean initialized = false;
    private boolean detected = false;

    /**
     * pipe is Constructor that is scaling the image smaller randomley
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public Pipe()
    {
        getImage().scale(60,60); 
        if(Greenfoot.getRandomNumber(3) == 0)
        {
            getImage().scale(30,30);

        }
    }
    int TRAP_SPEED = -3;
    /**
     * Act - do whatever the Pipe wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX() + TRAP_SPEED, getY() );

        if(initialized == true)
        {
            hitTrap();
        }
        else{
            initialized = true;
            if(getImage().getWidth() == 30)
            {
                setLocation(getX(), getY() + 20);
            }
        }
        atEdge();
    }    

    /**
     * atEdge is a method that is checking if the pipe is at the edge if it is then it will remove it
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void atEdge()
    {
        if(isAtEdge() == true)
        {
            getWorld().removeObject(this);
        }
    }

    /**
     * hitTrap is a method that is checking if the flappy bird is touching the pipe. if it is it will play a sound over and show the game over..
     * logo and set delay (200) and remove the bird from the world
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void hitTrap()
    {
        List<FlappyBird> bird = getObjectsInRange(getImage().getWidth()/2, FlappyBird.class);
        if(!bird.isEmpty()) 
        {
            GameOver gameover = new GameOver();            
            getWorld().addObject(gameover, getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.playSound("over.mp3");
            Greenfoot.delay(200);
            getWorld().removeObjects(bird);
        }
    }

    /**
     * updateScore is a method that is detecting the score if it is true then it will add 1 into to score 
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void updateScore()
    {
        if(detected == false)
        {
            detected = true;
            getWorld().getObjects(Score.class).get(0).addScore(1);
        }   
    } 

}
