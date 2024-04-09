//File Name: WavPlayer.java
//Name: Isaac Hu
//Email: ihu21@bu.edu
//Date: 4/1/24
//Description: A class for playing sounds and music during the game
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class WavPlayer
{

    Clip clip;

    // current status of clip 
    String status;

    AudioInputStream audioInputStream;
    String filePath;

    // constructor to initialize streams and clip 
    public WavPlayer(String filePath)
            throws UnsupportedAudioFileException,
            IOException, LineUnavailableException
    {
        this.filePath = filePath;
        // create AudioInputStream object 
        audioInputStream =
                AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());

        // create clip reference 
        clip = AudioSystem.getClip();

        // open audioInputStream to the clip 
        clip.open(audioInputStream);
        clip.start();
        status = "play";
    }

    // Method to play the clip on repeat
    public void playOnRepeat() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        status = "playOnRepeat";
    }

    // Method to stop playing the clip
    public void stop() {
        clip.stop();
        status = "stop";
    }

    // Method to close the clip and release resources
    public void close() {
        clip.close();
        status = "close";
    }


} 
