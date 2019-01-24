import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
/**
 * Write a description of class HighScore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HighScore extends Actor
{
    private int score = 0;
    private int highScore = 0;
    /**
     * Act - do whatever the HighScore wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    /**
     * act is a method that is setting the text in the box that says "Your Score: ", "High Score: " and also making the box move up
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void act() 
    {
        setLocation(getX(), getY() - 2);
        if(getY() <= 250)
        {
            setLocation(getX(), 250);
        } 
        GreenfootImage newImage = getImage();
        newImage.setFont(new Font("Helvetica", 30));
        newImage.drawString("Your Score: " + score ,70,150);
        newImage.drawString("High Score: " + highScore ,60,110);
        setImage(newImage);

    }   

    /**
     * HighScore is a method that is scaling the box to 330x220 and it get the high score to display and also saying the high in the text file..
     * also playing a sound
     * 
     * @param there is 1 paramter that is int inputScore that the inputing the score at beside the high score
     * @return Nothing is returned
     */
    public HighScore(int inputScore)
    {
        getImage().scale(330,220);
        score = inputScore;
        getHighScore();
        saveHighScore();
        Greenfoot.playSound("gameover.mp3");
    }

    /**
     * getHighScore is a method that is reading the high score for the file score.txt and displaying it beside high score
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void getHighScore()
    {
        FileInputStream fis;
        BufferedReader r = null;
        try{
            fis = new FileInputStream("score.txt");
            r = new BufferedReader(new InputStreamReader(fis));
            highScore = (int) Long.parseLong(r.readLine());
        }
        catch(FileNotFoundException e1)
        {
            e1.printStackTrace();
        }
        catch(IOException e2)
        {
            e2.printStackTrace();
        }
    }

    /**
     * saveHighScore is a method that is saving the high score in the text called "score.txt" in as integer
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void saveHighScore()
    {
        if(score > highScore)
        {
            highScore = score;
        }
        try{
            FileWriter writer = null;
            writer = new FileWriter("score.txt");
            writer.write(Integer.toString(highScore));
            writer.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
