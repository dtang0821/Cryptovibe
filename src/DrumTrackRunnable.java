import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DrumTrackRunnable implements Runnable
{
    private ArrayList<String> drumTrack;
    private static int currentIndex = 0;
    private static String currentSound = null;
    public DrumTrackRunnable(ArrayList<String> drumTrack)
    {
        this.drumTrack = drumTrack;
    }
    public void run()
    {
        for(int i = 0; i < Integer.MAX_VALUE; i++) {
            //makes the currentIndex reset
            if (currentIndex >= drumTrack.size()) {
                currentIndex = 0;
            }
            //sets currentSound to the current index variable, and then plays the sound effect
            currentSound = drumTrack.get(currentIndex);
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
        String basePath = "C:\\Users\\Dtang\\Downloads\\cryptovibe\\cryptovibeSound\\Sound Files\\Drum SFX\\"; // Replace with the base path to your sound files
        switch (currentSound) {
            case "Snare":
                playSound(basePath + "Snare.wav");
                break;
            case "ShortCymbal":
                playSound(basePath + "ShortCymbal.wav");
                break;
            case "LowTom":
                playSound(basePath + "LowTom.wav");
                break;
            case "LongCymbal":
                playSound(basePath + "LongCymbal.wav");
                break;
            case "Kick":
                playSound(basePath + "Kick.wav");
                break;
            case "Clap":
                playSound(basePath + "Clap.wav");
                break;
            default:
                System.out.println("Invalid sound: " + currentSound);
        }
    }
}