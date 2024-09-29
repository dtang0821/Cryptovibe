import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import java.io.File;
import java.util.ArrayList;
import javax.sound.sampled.*;
import java.io.IOException;

public class PianoTrackRunnable implements Runnable
{
    private ArrayList<String> pianoTrack;
    private static int currentIndex = 0;
    private static String currentSound = null;
    public PianoTrackRunnable(ArrayList<String> pianoTrack)
    {
        this.pianoTrack = pianoTrack;
    }

    public void run()
    {
        for(int i = 0; i < Integer.MAX_VALUE; i++) {

            //makes the currentIndex reset
            if (currentIndex >= pianoTrack.size()) {
                currentIndex = 0;
            }
            //sets currentSound to the current index variable, and then plays the sound effect
            currentSound = pianoTrack.get(currentIndex);
            playSoundFX(currentSound);
            System.out.println(pianoTrack);
            System.out.println(currentIndex);
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
    public void playSoundFX(String currentSound)
    {
        String basePath = "C:\\Users\\Dtang\\Downloads\\cryptovibe\\cryptovibeSound\\Sound Files\\Piano Notes\\"; // Replace with the base path to your sound files
        switch (currentSound) {
            case "g5":
                playSound(basePath + "g5.wav");
                break;
            case "g4":
                playSound(basePath + "g4.wav");
                break;
            case "g#5":
                playSound(basePath + "g-5.wav");
                break;
            case "g#4":
                playSound(basePath + "g-4.wav");
                break;
            case "f5":
                playSound(basePath + "f5.wav");
                break;
            case "f4":
                playSound(basePath + "f4.wav");
                break;
            case "f#5":
                playSound(basePath + "f-5.wav");
                break;
            case "f#4":
                playSound(basePath + "f-4.wav");
                break;
            case "e5":
                playSound(basePath + "e5.wav");
                break;
            case "e4":
                playSound(basePath + "e4.wav");
                break;
            case "d5":
                playSound(basePath + "d5.wav");
                break;
            case "d4":
                playSound(basePath + "d4.wav");
                break;
            case "d#5":
                playSound(basePath + "d-5.wav");
                break;
            case "d#4":
                playSound(basePath + "d-4.wav");
                break;
            case "c5":
                playSound(basePath + "c5.wav");
                break;
            case "c4":
                playSound(basePath + "c4.wav");
                break;
            case "c#5":
                playSound(basePath + "c-5.wav");
                break;
            case "c#4":
                playSound(basePath + "c-4.wav");
                break;
            case "b5":
                playSound(basePath + "b5.wav");
                break;
            case "b4":
                playSound(basePath + "b4.wav");
                break;
            case "a5":
                playSound(basePath + "a5.wav");
                break;
            case "a4":
                playSound(basePath + "a4.wav");
                break;
            case "a#5":
                playSound(basePath + "a-5.wav");
                break;
            case "a#4":
                playSound(basePath + "a-4.wav");
                break;
            default:
                System.out.println("Invalid note: " + currentSound);
        }
    }
}