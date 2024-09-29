import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import java.io.File;
import java.util.ArrayList;
import javax.sound.sampled.*;
import java.io.IOException;



public class GuitarTrackRunnable implements Runnable
{
    private ArrayList<String> guitarTrack;
    private static int currentIndex = 0;
    private static String currentSound = null;
    public GuitarTrackRunnable(ArrayList<String> guitarTrack)
    {
        this.guitarTrack = guitarTrack;
    }
    public void run()
    {
        for(int i = 0; i < Integer.MAX_VALUE; i++) {
            //makes the currentIndex reset
            if (currentIndex >= guitarTrack.size()) {
                currentIndex = 0;
            }
            //sets currentSound to the current index variable, and then plays the sound effect
            currentSound = guitarTrack.get(currentIndex);
            playSoundFX(currentSound);
            currentIndex++;
            //wait 500 milliseconds
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
    //helps playSound play the sound
    public void playSound(String currentSound) {
        Thread soundThread = new Thread(() -> {
            try {
                //creates an AudioInputStream from the currentSound
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(currentSound));
                //gets the audio format from the audio input stream
                AudioFormat audioFormat = audioInputStream.getFormat();
                //creates a DataLine.Info object with the audio format
                DataLine.Info info = new DataLine.Info(Clip.class, audioFormat);
                //checks if the specified line is supported
                if (!AudioSystem.isLineSupported(info)) {
                    System.out.println("Audio line is not supported.");
                    return;
                }
                System.out.println(currentSound);
                //creates a Clip
                Clip audioClip = (Clip) AudioSystem.getLine(info);
                //open clip with audioInputStream
                audioClip.open(audioInputStream);
                //playClip
                audioClip.start();
                //wait for clip to stop playing
            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
                e.printStackTrace();
            }
        });
        soundThread.start();
    }

    //plays the sound based on the currentSound
    public void playSoundFX(String currentSound) {
        String basePath = "C:\\Users\\Dtang\\Downloads\\cryptovibe\\cryptovibeSound\\Sound Files\\Guitar Chords\\"; // Replace with the base path to your sound files
        switch (currentSound) {
            case "GMajor":
                playSound(basePath + "GMajor.wav");
                break;
            case "FMajor":
                playSound(basePath + "FMajor.wav");
                break;
            case "EMinor":
                playSound(basePath + "EMinor.wav");
                break;
            case "EMajor":
                playSound(basePath + "EMajor.wav");
                break;
            case "DMinor":
                playSound(basePath + "DMinor.wav");
                break;
            case "CMajor":
                playSound(basePath + "CMajor.wav");
                break;
            case "BMinor":
                playSound(basePath + "BMinor.wav");
                break;
            case "BMajor":
                playSound(basePath + "BMajor.wav");
                break;
            case "AMinor":
                playSound(basePath + "AMinor.wav");
                break;
            case "AMajor":
                playSound(basePath + "AMajor.wav");
                break;
            default:
                System.out.println("Invalid sound: " + currentSound);
        }
    }
}