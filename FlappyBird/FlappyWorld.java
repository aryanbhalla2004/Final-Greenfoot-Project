import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FlappyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class FlappyWorld extends World
{
    private int counter = 0;
    private int count = 0;
    private int i = 0;
    private int pipeCounter = 0;
    private Score score = new Score();
    /**
     * FlappyWorld is a Constructor that is adding ground, logo, rest button, score text on the top left, and flappy bird in the world.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public FlappyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        FlappyBird flappy = new FlappyBird();
        addObject(flappy, 170, 328);
        addObject(new Ground(), 300, 375);  
        addObject(new logo(), getWidth()/2, 130);
        addObject(new Reset(), 560, 21);      
        addObject(score, 50,25);
    }

    /**
     * act is a method that adding random cloud in the world and also checking if the flappy bird lost and if that is true it will...
     * change the world to game over screen
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void act()
    {
        counter++;
        if(counter == 100)
        {
            Pipe pippy = new Pipe();

            GreenfootImage image = pippy.getImage();

            addObject(pippy, getWidth(), getHeight()/2 + 120 );

            counter = Greenfoot.getRandomNumber(51);
        }

        if(i == 300){
            randomCloud();
            i =0;
        } 
        else {
            i++;
        }
        if(getObjects(FlappyBird.class).isEmpty())
        {
            Greenfoot.delay(100);
            Greenfoot.setWorld(new End(score.getScore()));
        }

    }

    /**
     * randomCloud is a method that is adding cloud in the world.
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void randomCloud()
    {           
        addObject(new Cloud(), 599 ,100);
    }
}
