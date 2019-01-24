import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    private int score = 0;
    /**
     * act is a method that is changing the speed if the flappy bird hit the check point
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void act() 
    {
        if(score >= 25)
        {
            Greenfoot.setSpeed(51);
        }
        if(score >= 50)
        {
            Greenfoot.setSpeed(52);
        }
        if(score >= 75)
        {
            Greenfoot.setSpeed(54);
        }
        if(score >= 100)
        {
            // Greenfoot.setSpeed(55);
        }
    }   

    /**
     * Score is Constructor that is adding text to the world that says score and it changed the score eveytime when flappy jumo over.. 
     * the obstical
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public Score()
    {
        GreenfootImage newImage = new GreenfootImage(150, 60);
        newImage.clear();
        newImage.setFont(new Font("Helvetica", 20));
        newImage.drawString("Score: " + score ,30,30);
        setImage(newImage);
    }

    /**
     * addScore is adding the score to the world 
     * 
     * @param There is one param that is int s 
     * @return Nothing is returned
     */
    public void addScore(int s)
    {
        score += s;
        GreenfootImage newImage = getImage();
        newImage.clear();
        newImage.drawString("Score: " + score ,30,30);
        setImage(newImage);
    }

    /**
     * getScore is a method that is checking the score is return
     * 
     * @param There are no parameters
     * @return score is return to update the score in the highScore class.
     */
    public int getScore()
    {
        return score;
    }
}
