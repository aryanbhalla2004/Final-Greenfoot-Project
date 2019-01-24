import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class FlappyBird here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlappyBird extends Actor
{
    private double Force = 2;
    private double Gravity = 0.5;
    private double Boost_Speed = -10;
    private int jump = 10;
    private GreenfootImage[] images = {new GreenfootImage("flappy1.png"), new GreenfootImage("flappy2.png")};
    private int animationNumber = 0;
    private int loopCount = 0;
    /**
     * act is a method that is checking to detectScore, checkkey and also using and array you switch between images to make that charater..
     * look like it is walking
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void act() 
    {
        detectScore();
        checkKey();
        if(isTouching(Ground.class) == false)
        {
            setLocation( getX(), (int)(getY() + Force )); 
        }
        setImage(images[animationNumber]);
        loopCount++;
        if(loopCount > 10)
        {
            animationNumber++;
            loopCount = 0;
        }
        if(animationNumber == 2)
        {
            animationNumber = 0;
        }
    }    

    /**
     * checkKey is a method that is checking if the spacebar or mouseclick if it is it will making the charater jump and also play a jumo sound
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void checkKey()
    {
        if(Greenfoot.mousePressed(null) == true && isTouching(Ground.class))
        {
            Greenfoot.playSound("jump.mp3");
            Force = Boost_Speed;  
            setLocation( getX(), (int)(getY() - jump) );

        }
        if(Greenfoot.isKeyDown("space") == true && isTouching(Ground.class))
        {
            Force = Boost_Speed;  
            setLocation( getX(), (int)(getY() - jump) );
            Greenfoot.playSound("jump.mp3");
        }
        Force = Force + Gravity;
    }

    /**
     * Flappy Bird is a Constructor that is scaling the img of the array to 45 x 45
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public FlappyBird()
    {
        images[0].scale(45, 45);
        images[1].scale(45, 45);
        getImage().scale(45,45);
    }

    /**
     * detectScore is a method that is detecting score by check around the flappy bird. 
     * if the flappy is above the pipe it will give flappy bird 1 score
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void detectScore()
    {
        List<Pipe> updateScore = getObjectsInRange(125, Pipe.class);
        for(int i = 0; i < updateScore.size(); i++)
        {
            if(updateScore.get(i).getX() > getX() - 5 && getX() + 5 > updateScore.get(i).getX())
            {
                updateScore.get(i).updateScore();
            }
        }
    }
}
