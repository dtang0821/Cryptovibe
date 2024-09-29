import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import java.io.File;
import java.util.ArrayList;
import javax.sound.sampled.*;
import java.io.IOException;

public class MaxUpdateRunnable implements Runnable
{
    private ArrayList<String> pianoTrack;
    private ArrayList<String> guitarTrack;
    private ArrayList<String> drumTrack;
    public MaxUpdateRunnable(ArrayList<String> pianoTrack, ArrayList<String> guitarTrack, ArrayList<String> drumTrack)
    {
        this.pianoTrack = pianoTrack;
        this.guitarTrack = guitarTrack;
        this.drumTrack = drumTrack;
    }
    public void run()
    {
        //every 100 milliseconds, the maxSize variable of the main class is set to the biggest size of the 3 arrays
        for(int i = 0; i < Integer.MAX_VALUE; i++)
        {
            Main.setMaxSize(max(pianoTrack, guitarTrack, drumTrack));
            try
            {
                Thread.sleep(100);
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }

    public static int max(ArrayList<String> arr1, ArrayList<String> arr2, ArrayList<String> arr3)
    {
        int max = 0;
        int a = arr1.size();
        int b = arr2.size();
        int c = arr3.size();
        if (a > b)
        {
            max = a;
        }
        else
        {
            max = b;
        }
        if (c > max)
        {
            max = c;
        }
        return max;
    }
}