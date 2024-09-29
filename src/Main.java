import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.*;
import javafx.scene.Cursor;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static javafx.scene.text.Font.font;


//main uses javafx application
public class Main extends Application
{
    private static boolean isPlaying = false;
    private static int maxSize = 0;
    private static String tapSoundFile;
    private static String streakSoundFile;
    private static boolean isGetting = false;
    private static boolean tapChain = false;
    private static int chainCount = 1;
    private static Clip tapClip;
    private static Clip streakClip;
    private static final int SCENE_WIDTH = 1400;
    private static final int SCENE_HEIGHT = 800;
    private static String filename;
    private boolean sceneRunning = false;
    private static double totalTap=0;
    private static double sphereTap=0;
    private static double accuracyScore=100;
    private DecimalFormat df = new DecimalFormat("#.#");
    private String accuracyString;
    private static boolean timerStarted=false;
    private static double mainScore=0;
    private static double finalScore = mainScore*(1+(accuracyScore/100))*10;
    private static double eachPoint=100;
    private static boolean isMuted=false;
    private static long clipTime;
    private static boolean gameMode2Running=false;
    private static boolean gameMode3Running=false;
    private static double mainScoreFinal;
    private static double accuracyScoreFinal;
    private static double sphereTapScoreFinal;
    private static PhongMaterial material = new PhongMaterial();
    private static PhongMaterial boxmaterial1 = new PhongMaterial();
    private static PhongMaterial boxmaterial2 = new PhongMaterial();
    private static PhongMaterial playButtonmaterial = new PhongMaterial();
    private static PhongMaterial skipNextButtonmaterial = new PhongMaterial();
    private static PhongMaterial goBackButtonmaterial = new PhongMaterial();
    private static PhongMaterial loopButtonmaterial = new PhongMaterial();
    private static PhongMaterial shuffleButtonmaterial = new PhongMaterial();
    private static PhongMaterial defaultAlbummaterial = new PhongMaterial();
    private static PhongMaterial musicButtonmaterial = new PhongMaterial();
    private static PhongMaterial arrowUpmaterial = new PhongMaterial();
    private static PhongMaterial arrowDownmaterial = new PhongMaterial();
    private static PhongMaterial higlightedmusicbuttonmaterial = new PhongMaterial();
    private static PhongMaterial plusbuttonmaterial = new PhongMaterial();
    private static PhongMaterial subtractbuttonmaterial = new PhongMaterial();
    private static PhongMaterial chartScreenmaterial = new PhongMaterial();
    private static PhongMaterial scrollButtonmaterial = new PhongMaterial();
    private static PhongMaterial transactionScreenmaterial = new PhongMaterial();
    private static PhongMaterial buyButtonmaterial = new PhongMaterial();
    private static PhongMaterial sellButtonmaterial = new PhongMaterial();
    private static PhongMaterial playerscreenmaterial = new PhongMaterial();

    private double orgX = 0;
    private double orgY = 0;
    private static ArrayList<String>songStrings = new ArrayList<>();
    private static ArrayList<String>songStringsScroll = new ArrayList<>();
    private static ArrayList<String>albumPaths = new ArrayList<>();
    private static ArrayList<String>preSongsFile = new ArrayList<>();
    private static ArrayList<String>fullSongsFile = new ArrayList<>();
    private static ArrayList<String>albumNames = new ArrayList<>();
    private static ArrayList<String>alphabeticalSorted = new ArrayList<>();
    private static ArrayList<String>reversealphabeticalSorted = new ArrayList<>();
    private static ArrayList<String>popularitySorted = new ArrayList<>();
    private static ArrayList<String>reversepopularitySorted = new ArrayList<>();
    private static ArrayList<Box>sortButtons = new ArrayList<>();
    private static ArrayList<Text>sortText = new ArrayList<>();
    private static ArrayList<String>alphabeticalSortedAlbums = new ArrayList<>();
    private static ArrayList<String>reversealphabeticalSortedAlbums = new ArrayList<>();
    private static ArrayList<String>popularitySortedAlbums = new ArrayList<>();
    private static ArrayList<String>reversepopularitySortedAlbums = new ArrayList<>();
    private static ArrayList<String>alphabeticalSortedPRE = new ArrayList<>();
    private static ArrayList<String>reversealphabeticalSortedPRE = new ArrayList<>();
    private static ArrayList<String>popularitySortedPRE = new ArrayList<>();
    private static ArrayList<String>reversepopularitySortedPRE = new ArrayList<>();
    private static ArrayList<String>alphabeticalSortedAlbumsNames = new ArrayList<>();
    private static ArrayList<String>reversealphabeticalSortedAlbumsNames = new ArrayList<>();
    private static ArrayList<String>popularitySortedAlbumsNames = new ArrayList<>();
    private static ArrayList<String>reversepopularitySortedAlbumsNames = new ArrayList<>();
    private static ArrayList<String>playList = new ArrayList<>(15);
    private static ArrayList<String>queueList = new ArrayList<>();
    private static ArrayList<String>shuffled = new ArrayList<>();
    private static ArrayList<String>wavList = new ArrayList<>();
    private static ArrayList<String> pianoArr = new ArrayList<String>();
    private static ArrayList<String> guitarArr = new ArrayList<String>();
    private static ArrayList<String> drumArr = new ArrayList<String>();
    private static ArrayList<String> drumArrReference = new ArrayList<>();
    private static ArrayList<String> guitarArrReference = new ArrayList<>();
    private static ArrayList<String>guitarholderArr = new ArrayList<>();
    private static ArrayList<String>pianoholderArr = new ArrayList<>();
    private static ArrayList<String>drumholderArr = new ArrayList<>();

    private static ArrayList<Integer>musicholderArr = new ArrayList<>();



    private static int scrollCounter=0;
    private static int scrollCounter2=0;
    private static int musicHolder1 = 0;
    private static int musicHolder2 = 1;
    private static int musicHolder3 = 2;
    private static int musicHolder4 = 3;
    private static int musicHolder5 = 4;
    private static int musicHolder6 = 5;
    private static int musicHolder7 = 6;
    private static int musicHolder8 = 7;
    private static int musicHolder9 = 8;
    private static int musicHolder10 = 9;
    private static int musicHolder11 = 10;
    private static int musicHolder12 = 11;
    private static int pianoCount;
    private static int guitarCount;
    private static int drumCount;
    private static boolean omgPlaying=false;
    private static int scrollcountDeterminer=0;
    private static int scrollcountDeterminer2=0;
    private static Audio activeClip = null;
    private static boolean sortbuttonClicked=false;
    private static boolean isdefaultSorted=true;
    private static boolean isalphabeticalSorted=false;
    private static boolean isreversealphabeticalSorted=false;
    private static boolean ispopularitySorted=false;
    private static boolean isreversepopularitySorted=false;

    private static boolean isHighlighted1=false;
    private static boolean isHighlighted2=false;
    private static boolean isHighlighted3=false;
    private static boolean isHighlighted4=false;
    private static boolean isHighlighted5=false;
    private static boolean isHighlighted6=false;
    private static boolean isHighlighted7=false;
    private static boolean isHighlighted8=false;
    private static boolean isHighlighted9=false;
    private static boolean isHighlighted10=false;
    private static boolean isHighlighted11=false;
    private static boolean isHighlighted12=false;
    private static boolean inplayList=false;
    private static int indexCount=0;
    private static int totalSupply=100;
    private static double floorPrice=0.00001;
    private static String rarity = "Common";



    //3d rotating camera set up
    public static class RotateCamera extends Group {

        private final Camera camera;
        private final Rotate xRotate = new Rotate(-90, Rotate.X_AXIS);
        private final Rotate yRotate = new Rotate(0, Rotate.Y_AXIS);
        private final Rotate zRotate = new Rotate(0, Rotate.Z_AXIS);

        //initializes camera properties
        public RotateCamera() {
            buildObjects();
            camera = new PerspectiveCamera(true);
            camera.setFarClip(10000);
            camera.setNearClip(1);
            camera.setTranslateY(-2000);
            camera.getTransforms().addAll(xRotate, yRotate, zRotate);
        }

        //used for making 3d objects
        public void buildObjects() {


            try
            {
                Audio a = new Audio("DefaultMusic");
            }
            catch (Exception e)
            {
                System.out.println("Audio Error");
            }

            //instantiates a Runnable to account for always updating the max of the array
            MaxUpdateRunnable maxUpdateRunnable = new MaxUpdateRunnable(pianoholderArr, guitarholderArr, drumholderArr);
            Thread maxUpdateThread = new Thread(maxUpdateRunnable);

            //instantiates a Runnable to account for playing the piano track
            PianoTrackRunnable pianoTrackRunnable = new PianoTrackRunnable(pianoholderArr);
            Thread pianoTrackThread = new Thread(pianoTrackRunnable);

            //instantiates a Runnable to account for playing the guitar track
            GuitarTrackRunnable guitarTrackRunnable = new GuitarTrackRunnable(guitarholderArr);
            Thread guitarTrackThread = new Thread(guitarTrackRunnable);

            //instantiates a Runnable to account for playing the drum track
            DrumTrackRunnable drumTrackRunnable = new DrumTrackRunnable(drumholderArr);
            Thread drumTrackThread = new Thread(drumTrackRunnable);

            pianoArr.add("/");
            pianoArr.add("g5");
            pianoArr.add("g4");
            pianoArr.add("g#5");
            pianoArr.add("g#4");
            pianoArr.add("f5");
            pianoArr.add("f4");
            pianoArr.add("f#5");
            pianoArr.add("f#4");
            pianoArr.add("e5");
            pianoArr.add("e4");
            pianoArr.add("d5");
            pianoArr.add("d4");
            pianoArr.add("d#5");
            pianoArr.add("d#4");
            pianoArr.add("c5");
            pianoArr.add("c4");
            pianoArr.add("c#5");
            pianoArr.add("c#4");
            pianoArr.add("b5");
            pianoArr.add("b4");
            pianoArr.add("a5");
            pianoArr.add("a4");
            pianoArr.add("a#5");
            pianoArr.add("a#4");

            //adds Strings representing each type of chord for the guitar
            guitarArr.add("/");
            guitarArr.add("GMajor");
            guitarArr.add("FMajor");
            guitarArr.add("EMinor");
            guitarArr.add("EMajor");
            guitarArr.add("GMajor");
            guitarArr.add("DMinor");
            guitarArr.add("CMajor");
            guitarArr.add("BMinor");
            guitarArr.add("BMajor");
            guitarArr.add("AMinor");
            guitarArr.add("AMajor");

            //adds Strings representing each type of chord for the guitar
            guitarArrReference.add("/");
            guitarArrReference.add("G");
            guitarArrReference.add("F");
            guitarArrReference.add("Em");
            guitarArrReference.add("E");
            guitarArrReference.add("G");
            guitarArrReference.add("Dm");
            guitarArrReference.add("C");
            guitarArrReference.add("Bm");
            guitarArrReference.add("B");
            guitarArrReference.add("Am");
            guitarArrReference.add("A");

            drumArrReference.add("/");
            drumArrReference.add("S");
            drumArrReference.add("SC");
            drumArrReference.add("LT");
            drumArrReference.add("LC");
            drumArrReference.add("KI");
            drumArrReference.add("CL");

            //adds Strings representing each SFX for the drum
            drumArr.add("/");
            drumArr.add("Snare");
            drumArr.add("ShortCymbal");
            drumArr.add("LowTom");
            drumArr.add("LongCymbal");
            drumArr.add("Kick");
            drumArr.add("Clap");

            guitarholderArr.add("");
            guitarholderArr.add("");
            guitarholderArr.add("");
            guitarholderArr.add("");
            guitarholderArr.add("");
            guitarholderArr.add("");
            guitarholderArr.add("");
            guitarholderArr.add("");
            guitarholderArr.add("");
            guitarholderArr.add("");



            pianoholderArr.add("");
            pianoholderArr.add("");
            pianoholderArr.add("");
            pianoholderArr.add("");
            pianoholderArr.add("");
            pianoholderArr.add("");
            pianoholderArr.add("");
            pianoholderArr.add("");
            pianoholderArr.add("");
            pianoholderArr.add("");






            drumholderArr.add("");
            drumholderArr.add("");
            drumholderArr.add("");
            drumholderArr.add("");
            drumholderArr.add("");
            drumholderArr.add("");
            drumholderArr.add("");
            drumholderArr.add("");
            drumholderArr.add("");
            drumholderArr.add("");

            musicholderArr.add(musicHolder1);
            musicholderArr.add(musicHolder2);
            musicholderArr.add(musicHolder3);
            musicholderArr.add(musicHolder4);
            musicholderArr.add(musicHolder5);
            musicholderArr.add(musicHolder6);
            musicholderArr.add(musicHolder7);
            musicholderArr.add(musicHolder8);
            musicholderArr.add(musicHolder9);
            musicholderArr.add(musicHolder10);
            musicholderArr.add(musicHolder11);
            musicholderArr.add(musicHolder12);














            boxmaterial1.setSpecularColor(Color.valueOf("#424242"));
            boxmaterial2.setSpecularColor(Color.valueOf("#424242"));
            boxmaterial1.setDiffuseColor(Color.WHITE);
//            boxmaterial.setSpecularColor(Color.LIGHTGRAY);
            boxmaterial2.setDiffuseColor(Color.SKYBLUE);
            playButtonmaterial.setSpecularColor(Color.valueOf("#424242"));
            skipNextButtonmaterial.setSpecularColor(Color.valueOf("#424242"));
            goBackButtonmaterial.setSpecularColor(Color.valueOf("#424242"));
            loopButtonmaterial.setSpecularColor(Color.valueOf("#424242"));
            shuffleButtonmaterial.setSpecularColor(Color.valueOf("#424242"));
            defaultAlbummaterial.setSpecularColor(Color.valueOf("#424242"));
            musicButtonmaterial.setSpecularColor(Color.valueOf("#424242"));
            arrowDownmaterial.setSpecularColor(Color.valueOf("#424242"));
            arrowUpmaterial.setSpecularColor(Color.valueOf("#424242"));
            chartScreenmaterial.setSpecularColor(Color.valueOf("#424242"));
            scrollButtonmaterial.setSpecularColor(Color.valueOf("#424242"));
            transactionScreenmaterial.setSpecularColor(Color.valueOf("#424242"));


            playButtonmaterial.setDiffuseColor(Color.WHITE);
            skipNextButtonmaterial.setDiffuseColor(Color.WHITE);
            goBackButtonmaterial.setDiffuseColor(Color.WHITE);
            loopButtonmaterial.setDiffuseColor(Color.WHITE);
            shuffleButtonmaterial.setDiffuseColor(Color.WHITE);
            defaultAlbummaterial.setDiffuseColor(Color.WHITE);
            musicButtonmaterial.setDiffuseColor(Color.WHITE);
            arrowDownmaterial.setDiffuseColor(Color.WHITE);
            arrowUpmaterial.setDiffuseColor(Color.WHITE);

//            Slider musicSlider = new Slider(10,100,50);
//            musicSlider.setTranslateX(-1500);
//            musicSlider.setTranslateY(-200);
//            musicSlider.setTranslateZ(-2000);

//            VBox musicGrid = new VBox();
//            musicGrid.setAlignment(Pos.CENTER_RIGHT);
//            musicGrid.setTranslateX(0);
//            musicGrid.setTranslateZ(0);
//            musicGrid.setTranslateY(-3500);
//            musicGrid.getChildren().addAll();

            try
            {
                Image screen1Image = new Image(new FileInputStream("C:\\Users\\Dtang\\CS Projects\\cryptovibe\\cryptovibelogo.png"));
                boxmaterial1.setDiffuseMap(screen1Image);
                Image screen2Image = new Image(new FileInputStream("C:\\Users\\Dtang\\CS Projects\\cryptovibe\\screenBorder.png"));
                boxmaterial2.setDiffuseMap(screen2Image);
                Image musicButtonImage = new Image(new FileInputStream("C:\\Users\\Dtang\\CS Projects\\cryptovibe\\button.png"));
                musicButtonmaterial.setDiffuseMap(musicButtonImage);
                Image chartScreenImage = new Image(new FileInputStream("C:\\Users\\Dtang\\CS Projects\\cryptovibe\\chartScreen.png"));
                chartScreenmaterial.setDiffuseMap(chartScreenImage);
                Image scrollButtonImage = new Image(new FileInputStream("C:\\Users\\Dtang\\CS Projects\\cryptovibe\\scrollButton.png"));
                scrollButtonmaterial.setDiffuseMap(scrollButtonImage);
                Image transactionScreenImage = new Image(new FileInputStream("C:\\Users\\Dtang\\CS Projects\\cryptovibe\\transactionScreen.png"));
                transactionScreenmaterial.setDiffuseMap(transactionScreenImage);
                Image playButtonImage = new Image(new FileInputStream("C:\\Users\\Dtang\\CS Projects\\cryptovibe\\playButton.png"));
                playButtonmaterial.setDiffuseMap(playButtonImage);
                Image plusButtonImage = new Image(new FileInputStream("C:\\Users\\Dtang\\CS Projects\\cryptovibe\\plusButton.png"));
                plusbuttonmaterial.setDiffuseMap(plusButtonImage);
                Image subtractButtonImage = new Image(new FileInputStream("C:\\Users\\Dtang\\CS Projects\\cryptovibe\\minusButton.png"));
                subtractbuttonmaterial.setDiffuseMap(subtractButtonImage);
                Image gobackButtonImage = new Image(new FileInputStream("C:\\Users\\Dtang\\CS Projects\\cryptovibe\\gobackButton.png"));
                goBackButtonmaterial.setDiffuseMap(gobackButtonImage);
                Image skipnextButtonImage = new Image(new FileInputStream("C:\\Users\\Dtang\\CS Projects\\cryptovibe\\skipnextButton.png"));
                skipNextButtonmaterial.setDiffuseMap(skipnextButtonImage);
                Image loopButtonImage = new Image(new FileInputStream("C:\\Users\\Dtang\\CS Projects\\cryptovibe\\loopButton.png"));
                loopButtonmaterial.setDiffuseMap(loopButtonImage);
                Image shuffleButtonImage = new Image(new FileInputStream("C:\\Users\\Dtang\\CS Projects\\cryptovibe\\shuffleButton.png"));
                shuffleButtonmaterial.setDiffuseMap(shuffleButtonImage);
                Image buyButtonImage = new Image(new FileInputStream("C:\\Users\\Dtang\\CS Projects\\cryptovibe\\buyButton.png"));
                buyButtonmaterial.setDiffuseMap(buyButtonImage);
                Image sellButtonImage = new Image(new FileInputStream("C:\\Users\\Dtang\\CS Projects\\cryptovibe\\sellButton.png"));
                sellButtonmaterial.setDiffuseMap(sellButtonImage);
                sellButtonmaterial.setDiffuseMap(sellButtonImage);
                Image playerscreenImage = new Image(new FileInputStream("C:\\Users\\Dtang\\CS Projects\\cryptovibe\\nftplayerScreen.png"));
                playerscreenmaterial.setDiffuseMap(playerscreenImage);
                Image nftexampleImage = new Image(new FileInputStream("C:\\Users\\Dtang\\CS Projects\\cryptovibe\\nftExample.png"));
                defaultAlbummaterial.setDiffuseMap(nftexampleImage);


            }
            catch (Exception E)
            {
                System.out.println("File Not Found");
            }









            Box screen1 = new Box(700,700,20);
            screen1.setTranslateX(0);
            screen1.setTranslateZ(0);
            screen1.setTranslateY(-500);
            screen1.setMaterial(boxmaterial1);

            Box screen2 = new Box(700,700,20);
            screen2.setTranslateX(0);
            screen2.setTranslateZ(0);
            screen2.setTranslateY(-3500);
            screen2.setMaterial(boxmaterial2);

            //this is the playing music screen where you can pause and play
            Box screen3 = new Box(700,700,20);
            screen3.setTranslateX(-1500);
            screen3.setTranslateZ(0);
            screen3.setTranslateY(-2000);
            screen3.setMaterial(chartScreenmaterial);

            Box screen4 = new Box(700,700,20);
            screen4.setTranslateX(1500);
            screen4.setTranslateZ(0);
            screen4.setTranslateY(-2000);
            screen4.setMaterial(boxmaterial2);

            Box screen5 = new Box(700,700,20);
            screen5.setTranslateX(-1200);
            screen5.setTranslateZ(0);
            screen5.setTranslateY(-1000);
            screen5.setMaterial(transactionScreenmaterial);

            Box screen6 = new Box(700,700,20);
            screen6.setTranslateX(1000);
            screen6.setTranslateZ(0);
            screen6.setTranslateY(-800);
            screen6.setMaterial(playerscreenmaterial);

            Box screen7 = new Box(700,700,20);
            screen7.setTranslateX(1500);
            screen7.setTranslateZ(0);
            screen7.setTranslateY(-2800);
            screen7.setMaterial(boxmaterial2);

            Box screen8 = new Box(700,700,20);
            screen8.setTranslateX(-1500);
            screen8.setTranslateZ(0);
            screen8.setTranslateY(-2800);
            screen8.setMaterial(boxmaterial2);









            Box playButton = new Box(130,130,20);
            playButton.setTranslateX(-1490);
            playButton.setTranslateZ(-150);
            playButton.setTranslateY(-2000);
            playButton.setMaterial(playButtonmaterial);

            Box skipnextButton = new Box(100,100,20);
            skipnextButton.setTranslateX(-1490);
            skipnextButton.setTranslateZ(-150);
            skipnextButton.setTranslateY(-1877.5);
            skipnextButton.setMaterial(skipNextButtonmaterial);

            Box gobackButton = new Box(100,100,20);
            gobackButton.setTranslateX(-1490);
            gobackButton.setTranslateZ(-150);
            gobackButton.setTranslateY(-2122.5);
            gobackButton.setMaterial(goBackButtonmaterial);

            Box loopButton = new Box(100,100,20);
            loopButton.setTranslateX(-1490);
            loopButton.setTranslateZ(-150);
            loopButton.setTranslateY(-1770);
            loopButton.setMaterial(loopButtonmaterial);

            Box shuffleButton = new Box(100,100,20);
            shuffleButton.setTranslateX(-1490);
            shuffleButton.setTranslateZ(-150);
            shuffleButton.setTranslateY(-2230);
            shuffleButton.setMaterial(shuffleButtonmaterial);

            Box defaultPicture = new Box(400,400,20);
            defaultPicture.setTranslateX(-1450);
            defaultPicture.setTranslateZ(130);
            defaultPicture.setTranslateY(-2000);
            defaultPicture.setMaterial(defaultAlbummaterial);

            Box musicButton1 = new Box(280,120,20);
            musicButton1.setTranslateX(-195);
            musicButton1.setTranslateZ(230);
            musicButton1.setTranslateY(-3490);
            musicButton1.setMaterial(musicButtonmaterial);

            Box musicButton2 = new Box(280,120,20);
            musicButton2.setTranslateX(-195);
            musicButton2.setTranslateZ(110);
            musicButton2.setTranslateY(-3490);
            musicButton2.setMaterial(musicButtonmaterial);

            Box musicButton3 = new Box(280,120,20);
            musicButton3.setTranslateX(-195);
            musicButton3.setTranslateZ(-10);
            musicButton3.setTranslateY(-3490);
            musicButton3.setMaterial(musicButtonmaterial);

            Box musicButton4 = new Box(280,100,20);
            musicButton4.setTranslateX(-195);
            musicButton4.setTranslateZ(-135);
            musicButton4.setTranslateY(-3490);
            musicButton4.setMaterial(buyButtonmaterial);

            Box musicButton5 = new Box(280,100,20);
            musicButton5.setTranslateX(-195);
            musicButton5.setTranslateZ(-235);
            musicButton5.setTranslateY(-3490);
            musicButton5.setMaterial(sellButtonmaterial);


            Box musicButton6 = new Box(300,50,20);
            musicButton6.setTranslateX(-195);
            musicButton6.setTranslateZ(10);
            musicButton6.setTranslateY(-3490);
            musicButton6.setMaterial(musicButtonmaterial);

            Box musicButton7 = new Box(300,50,20);
            musicButton7.setTranslateX(-195);
            musicButton7.setTranslateZ(-40);
            musicButton7.setTranslateY(-3490);
            musicButton7.setMaterial(musicButtonmaterial);

            Box musicButton8 = new Box(300,50,20);
            musicButton8.setTranslateX(-195);
            musicButton8.setTranslateZ(-90);
            musicButton8.setTranslateY(-3490);
            musicButton8.setMaterial(musicButtonmaterial);

            Box musicButton9 = new Box(300,50,20);
            musicButton9.setTranslateX(-195);
            musicButton9.setTranslateZ(-140);
            musicButton9.setTranslateY(-3490);
            musicButton9.setMaterial(musicButtonmaterial);

            Box musicButton10 = new Box(300,50,20);
            musicButton10.setTranslateX(-195);
            musicButton10.setTranslateZ(-190);
            musicButton10.setTranslateY(-3490);
            musicButton10.setMaterial(musicButtonmaterial);

            Box musicButton11 = new Box(300,50,20);
            musicButton11.setTranslateX(-195);
            musicButton11.setTranslateZ(-240);
            musicButton11.setTranslateY(-3490);
            musicButton11.setMaterial(musicButtonmaterial);

            Box musicButton12 = new Box(300,50,20);
            musicButton12.setTranslateX(-195);
            musicButton12.setTranslateZ(-290);
            musicButton12.setTranslateY(-3490);
            musicButton12.setMaterial(musicButtonmaterial);

            Box albumPreview = new Box(350,350,20);
            albumPreview.setTranslateX(135);
            albumPreview.setTranslateZ(100);
            albumPreview.setTranslateY(-3410);
            albumPreview.setMaterial(defaultAlbummaterial);

            Box goUpArrow = new Box(30,30,20);
            goUpArrow.setTranslateX(-230);
            goUpArrow.setTranslateZ(250);
            goUpArrow.setTranslateY(-3490);
            goUpArrow.setMaterial(arrowUpmaterial);


            Box goDownArrow = new Box(30,30,20);
            goDownArrow.setTranslateX(-310);
            goDownArrow.setTranslateZ(250);
            goDownArrow.setTranslateY(-3490);
            goDownArrow.setMaterial(arrowDownmaterial);

            Box plusButton = new Box(60,50,20);
            plusButton.setTranslateX(-1490);
            plusButton.setTranslateZ(-45);
            plusButton.setTranslateY(-1755);
            plusButton.setMaterial(plusbuttonmaterial);

            Box subtractButton = new Box(60,50,20);
            subtractButton.setTranslateX(-1490);
            subtractButton.setTranslateZ(-45);
            subtractButton.setTranslateY(-1695);
            subtractButton.setMaterial(subtractbuttonmaterial);


            //FOR THE PLAYLIST
            Box goUpArrow2 = new Box(43,32,20);
            goUpArrow2.setTranslateX(1400);
            goUpArrow2.setTranslateZ(300);
            goUpArrow2.setTranslateY(-1815);
            goUpArrow2.setMaterial(scrollButtonmaterial);

            Box goDownArrow2 = new Box(43,32,20);
            goDownArrow2.setTranslateX(1400);
            goDownArrow2.setTranslateZ(300);
            goDownArrow2.setTranslateY(-1860);
            goDownArrow2.setMaterial(scrollButtonmaterial);

            Box sortDropButton = new Box(300,50,20);
            sortDropButton.setTranslateX(183);
            sortDropButton.setTranslateZ(-115);
            sortDropButton.setTranslateY(-3490);
            sortDropButton.setMaterial(musicButtonmaterial);

            Box alphabeticalSortButton = new Box(300,50,20);
            alphabeticalSortButton.setTranslateX(183);
            alphabeticalSortButton.setTranslateZ(-115);
            alphabeticalSortButton.setTranslateY(-3490);
            alphabeticalSortButton.setMaterial(musicButtonmaterial);

            Box reversealphabeticalSortButton = new Box(300,50,20);
            reversealphabeticalSortButton.setTranslateX(183);
            reversealphabeticalSortButton.setTranslateZ(-165);
            reversealphabeticalSortButton.setTranslateY(-3490);
            reversealphabeticalSortButton.setMaterial(musicButtonmaterial);

            Box popularitySortButton = new Box(300,50,20);
            popularitySortButton.setTranslateX(183);
            popularitySortButton.setTranslateZ(-215);
            popularitySortButton.setTranslateY(-3490);
            popularitySortButton.setMaterial(musicButtonmaterial);

            Box reversepopularitySortButton = new Box(300,50,20);
            reversepopularitySortButton.setTranslateX(183);
            reversepopularitySortButton.setTranslateZ(-265);
            reversepopularitySortButton.setTranslateY(-3490);
            reversepopularitySortButton.setMaterial(musicButtonmaterial);


            Box playlistButton1 = new Box(200,50,20);
            playlistButton1.setTranslateX(1400);
            playlistButton1.setTranslateZ(260);
            playlistButton1.setTranslateY(-1990);
            playlistButton1.setMaterial(musicButtonmaterial);

            Box playlistButton2 = new Box(200,50,20);
            playlistButton2.setTranslateX(1400);
            playlistButton2.setTranslateZ(210);
            playlistButton2.setTranslateY(-1990);
            playlistButton2.setMaterial(musicButtonmaterial);

            Box playlistButton3 = new Box(200,50,20);
            playlistButton3.setTranslateX(1400);
            playlistButton3.setTranslateZ(160);
            playlistButton3.setTranslateY(-1990);
            playlistButton3.setMaterial(musicButtonmaterial);

            Box playlistButton4 = new Box(200,50,20);
            playlistButton4.setTranslateX(1400);
            playlistButton4.setTranslateZ(110);
            playlistButton4.setTranslateY(-1990);
            playlistButton4.setMaterial(musicButtonmaterial);

            Box playlistButton5 = new Box(200,50,20);
            playlistButton5.setTranslateX(1400);
            playlistButton5.setTranslateZ(60);
            playlistButton5.setTranslateY(-1990);
            playlistButton5.setMaterial(musicButtonmaterial);

            Box playlistButton6 = new Box(200,50,20);
            playlistButton6.setTranslateX(1400);
            playlistButton6.setTranslateZ(10);
            playlistButton6.setTranslateY(-1990);
            playlistButton6.setMaterial(musicButtonmaterial);

            Box playlistButton7 = new Box(200,50,20);
            playlistButton7.setTranslateX(1400);
            playlistButton7.setTranslateZ(-40);
            playlistButton7.setTranslateY(-1990);
            playlistButton7.setMaterial(musicButtonmaterial);

            Box playlistButton8 = new Box(200,50,20);
            playlistButton8.setTranslateX(1400);
            playlistButton8.setTranslateZ(-90);
            playlistButton8.setTranslateY(-1990);
            playlistButton8.setMaterial(musicButtonmaterial);

            Box playlistButton9 = new Box(200,50,20);
            playlistButton9.setTranslateX(1400);
            playlistButton9.setTranslateZ(-140);
            playlistButton9.setTranslateY(-1990);
            playlistButton9.setMaterial(musicButtonmaterial);

            Box playlistButton10 = new Box(200,50,20);
            playlistButton10.setTranslateX(1400);
            playlistButton10.setTranslateZ(-190);
            playlistButton10.setTranslateY(-1990);
            playlistButton10.setMaterial(musicButtonmaterial);

            Box playlistButton11 = new Box(200,50,20);
            playlistButton11.setTranslateX(1400);
            playlistButton11.setTranslateZ(-240);
            playlistButton11.setTranslateY(-1990);
            playlistButton11.setMaterial(musicButtonmaterial);

            Box playlistButton12 = new Box(200,50,20);
            playlistButton12.setTranslateX(1400);
            playlistButton12.setTranslateZ(-290);
            playlistButton12.setTranslateY(-1990);
            playlistButton12.setMaterial(musicButtonmaterial);

            Box queueButton1 = new Box(200,50,20);
            queueButton1.setTranslateX(1400);
            queueButton1.setTranslateZ(260);
            queueButton1.setTranslateY(-1790);
            queueButton1.setMaterial(musicButtonmaterial);

            Box queueButton2 = new Box(200,50,20);
            queueButton2.setTranslateX(1400);
            queueButton2.setTranslateZ(210);
            queueButton2.setTranslateY(-1790);
            queueButton2.setMaterial(musicButtonmaterial);

            Box queueButton3 = new Box(200,50,20);
            queueButton3.setTranslateX(1400);
            queueButton3.setTranslateZ(160);
            queueButton3.setTranslateY(-1790);
            queueButton3.setMaterial(musicButtonmaterial);

            Box queueButton4 = new Box(200,50,20);
            queueButton4.setTranslateX(1400);
            queueButton4.setTranslateZ(110);
            queueButton4.setTranslateY(-1790);
            queueButton4.setMaterial(musicButtonmaterial);

            Box queueButton5 = new Box(200,50,20);
            queueButton5.setTranslateX(1400);
            queueButton5.setTranslateZ(60);
            queueButton5.setTranslateY(-1790);
            queueButton5.setMaterial(musicButtonmaterial);

            Box queueButton6 = new Box(200,50,20);
            queueButton6.setTranslateX(1400);
            queueButton6.setTranslateZ(10);
            queueButton6.setTranslateY(-1790);
            queueButton6.setMaterial(musicButtonmaterial);

            Box queueButton7 = new Box(200,50,20);
            queueButton7.setTranslateX(1400);
            queueButton7.setTranslateZ(-40);
            queueButton7.setTranslateY(-1790);
            queueButton7.setMaterial(musicButtonmaterial);

            Box queueButton8 = new Box(200,50,20);
            queueButton8.setTranslateX(1400);
            queueButton8.setTranslateZ(-90);
            queueButton8.setTranslateY(-1790);
            queueButton8.setMaterial(musicButtonmaterial);

            Box queueButton9 = new Box(200,50,20);
            queueButton9.setTranslateX(1400);
            queueButton9.setTranslateZ(-140);
            queueButton9.setTranslateY(-1790);
            queueButton9.setMaterial(musicButtonmaterial);

            Box queueButton10 = new Box(200,50,20);
            queueButton10.setTranslateX(1400);
            queueButton10.setTranslateZ(-190);
            queueButton10.setTranslateY(-1790);
            queueButton10.setMaterial(musicButtonmaterial);

            Box queueButton11 = new Box(200,50,20);
            queueButton11.setTranslateX(1400);
            queueButton11.setTranslateZ(-240);
            queueButton11.setTranslateY(-1790);
            queueButton11.setMaterial(musicButtonmaterial);

            Box queueButton12 = new Box(200,50,20);
            queueButton12.setTranslateX(1400);
            queueButton12.setTranslateZ(-290);
            queueButton12.setTranslateY(-1790);
            queueButton12.setMaterial(musicButtonmaterial);

            Box drumButton1 = new Box(200,50,20);
            drumButton1.setTranslateX(1400);
            drumButton1.setTranslateZ(260);
            drumButton1.setTranslateY(-2190);
            drumButton1.setMaterial(musicButtonmaterial);

            Box drumButton2 = new Box(200,50,20);
            drumButton2.setTranslateX(1400);
            drumButton2.setTranslateZ(210);
            drumButton2.setTranslateY(-2190);
            drumButton2.setMaterial(musicButtonmaterial);

            Box drumButton3 = new Box(200,50,20);
            drumButton3.setTranslateX(1400);
            drumButton3.setTranslateZ(160);
            drumButton3.setTranslateY(-2190);
            drumButton3.setMaterial(musicButtonmaterial);

            Box drumButton4 = new Box(200,50,20);
            drumButton4.setTranslateX(1400);
            drumButton4.setTranslateZ(110);
            drumButton4.setTranslateY(-2190);
            drumButton4.setMaterial(musicButtonmaterial);

            Box drumButton5 = new Box(200,50,20);
            drumButton5.setTranslateX(1400);
            drumButton5.setTranslateZ(60);
            drumButton5.setTranslateY(-2190);
            drumButton5.setMaterial(musicButtonmaterial);

            Box drumButton6 = new Box(200,50,20);
            drumButton6.setTranslateX(1400);
            drumButton6.setTranslateZ(10);
            drumButton6.setTranslateY(-2190);
            drumButton6.setMaterial(musicButtonmaterial);

            Box drumButton7 = new Box(200,50,20);
            drumButton7.setTranslateX(1400);
            drumButton7.setTranslateZ(-40);
            drumButton7.setTranslateY(-2190);
            drumButton7.setMaterial(musicButtonmaterial);

            /*
            playButton.setTranslateX(-1490);
            playButton.setTranslateZ(-150);
            playButton.setTranslateY(-2000);
             */

            Box scrollLeftButton = new Box(50,50,20);
            scrollLeftButton.setTranslateX(-1490);
            scrollLeftButton.setTranslateZ(290);
            scrollLeftButton.setTranslateY(-1760);
            scrollLeftButton.setMaterial(scrollButtonmaterial);

            Box scrollRightbutton = new Box(50,50,20);
            scrollRightbutton.setTranslateX(-1490);
            scrollRightbutton.setTranslateZ(290);
            scrollRightbutton.setTranslateY(-1710);
            scrollRightbutton.setMaterial(scrollButtonmaterial);












            //Button Text

            Text guitarHolderText1 = new Text("");
            guitarHolderText1.setFill(Color.WHITE);
            guitarHolderText1.setTranslateX(-1490);
            guitarHolderText1.setTranslateZ(190);
            guitarHolderText1.setTranslateY(-2170);
            guitarHolderText1.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text guitarHolderText2 = new Text("");
            guitarHolderText2.setFill(Color.WHITE);
            guitarHolderText2.setTranslateX(-1490);
            guitarHolderText2.setTranslateZ(190);
            guitarHolderText2.setTranslateY(-2120);
            guitarHolderText2.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text guitarHolderText3 = new Text("");
            guitarHolderText3.setFill(Color.WHITE);
            guitarHolderText3.setTranslateX(-1490);
            guitarHolderText3.setTranslateZ(190);
            guitarHolderText3.setTranslateY(-2070);
            guitarHolderText3.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text guitarHolderText4 = new Text("");
            guitarHolderText4.setFill(Color.WHITE);
            guitarHolderText4.setTranslateX(-1490);
            guitarHolderText4.setTranslateZ(190);
            guitarHolderText4.setTranslateY(-2020);
            guitarHolderText4.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text guitarHolderText5 = new Text("");
            guitarHolderText5.setFill(Color.WHITE);
            guitarHolderText5.setTranslateX(-1490);
            guitarHolderText5.setTranslateZ(190);
            guitarHolderText5.setTranslateY(-1970);
            guitarHolderText5.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text guitarHolderText6 = new Text("");
            guitarHolderText6.setFill(Color.WHITE);
            guitarHolderText6.setTranslateX(-1490);
            guitarHolderText6.setTranslateZ(190);
            guitarHolderText6.setTranslateY(-1920);
            guitarHolderText6.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text guitarHolderText7 = new Text("");
            guitarHolderText7.setFill(Color.WHITE);
            guitarHolderText7.setTranslateX(-1490);
            guitarHolderText7.setTranslateZ(190);
            guitarHolderText7.setTranslateY(-1870);
            guitarHolderText7.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text guitarHolderText8 = new Text("");
            guitarHolderText8.setFill(Color.WHITE);
            guitarHolderText8.setTranslateX(-1490);
            guitarHolderText8.setTranslateZ(190);
            guitarHolderText8.setTranslateY(-1820);
            guitarHolderText8.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text guitarHolderText9 = new Text("");
            guitarHolderText9.setFill(Color.WHITE);
            guitarHolderText9.setTranslateX(-1490);
            guitarHolderText9.setTranslateZ(190);
            guitarHolderText9.setTranslateY(-1770);
            guitarHolderText9.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text guitarHolderText10 = new Text("");
            guitarHolderText10.setFill(Color.WHITE);
            guitarHolderText10.setTranslateX(-1490);
            guitarHolderText10.setTranslateZ(190);
            guitarHolderText10.setTranslateY(-1720);
            guitarHolderText10.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text pianoHolderText1 = new Text("");
            pianoHolderText1.setFill(Color.WHITE);
            pianoHolderText1.setTranslateX(-1490);
            pianoHolderText1.setTranslateZ(-5);
            pianoHolderText1.setTranslateY(-2170);
            pianoHolderText1.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text pianoHolderText2 = new Text("");
            pianoHolderText2.setFill(Color.WHITE);
            pianoHolderText2.setTranslateX(-1490);
            pianoHolderText2.setTranslateZ(-5);
            pianoHolderText2.setTranslateY(-2120);
            pianoHolderText2.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text pianoHolderText3 = new Text("");
            pianoHolderText3.setFill(Color.WHITE);
            pianoHolderText3.setTranslateX(-1490);
            pianoHolderText3.setTranslateZ(-5);
            pianoHolderText3.setTranslateY(-2070);
            pianoHolderText3.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text pianoHolderText4 = new Text("");
            pianoHolderText4.setFill(Color.WHITE);
            pianoHolderText4.setTranslateX(-1490);
            pianoHolderText4.setTranslateZ(-5);
            pianoHolderText4.setTranslateY(-2020);
            pianoHolderText4.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text pianoHolderText5 = new Text("");
            pianoHolderText5.setFill(Color.WHITE);
            pianoHolderText5.setTranslateX(-1490);
            pianoHolderText5.setTranslateZ(-5);
            pianoHolderText5.setTranslateY(-1970);
            pianoHolderText5.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text pianoHolderText6 = new Text("");
            pianoHolderText6.setFill(Color.WHITE);
            pianoHolderText6.setTranslateX(-1490);
            pianoHolderText6.setTranslateZ(-5);
            pianoHolderText6.setTranslateY(-1920);
            pianoHolderText6.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text pianoHolderText7 = new Text("");
            pianoHolderText7.setFill(Color.WHITE);
            pianoHolderText7.setTranslateX(-1490);
            pianoHolderText7.setTranslateZ(-5);
            pianoHolderText7.setTranslateY(-1870);
            pianoHolderText7.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text pianoHolderText8 = new Text("");
            pianoHolderText8.setFill(Color.WHITE);
            pianoHolderText8.setTranslateX(-1490);
            pianoHolderText8.setTranslateZ(-5);
            pianoHolderText8.setTranslateY(-1820);
            pianoHolderText8.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text pianoHolderText9 = new Text("");
            pianoHolderText9.setFill(Color.WHITE);
            pianoHolderText9.setTranslateX(-1490);
            pianoHolderText9.setTranslateZ(-5);
            pianoHolderText9.setTranslateY(-1770);
            pianoHolderText9.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text pianoHolderText10 = new Text("");
            pianoHolderText10.setFill(Color.WHITE);
            pianoHolderText10.setTranslateX(-1490);
            pianoHolderText10.setTranslateZ(-5);
            pianoHolderText10.setTranslateY(-1720);
            pianoHolderText10.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));



            Text drumsHolderText1 = new Text("");
            drumsHolderText1.setFill(Color.WHITE);
            drumsHolderText1.setTranslateX(-1490);
            drumsHolderText1.setTranslateZ(-195);
            drumsHolderText1.setTranslateY(-2170);
            drumsHolderText1.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text drumsHolderText2 = new Text("");
            drumsHolderText2.setFill(Color.WHITE);
            drumsHolderText2.setTranslateX(-1490);
            drumsHolderText2.setTranslateZ(-195);
            drumsHolderText2.setTranslateY(-2120);
            drumsHolderText2.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text drumsHolderText3 = new Text("");
            drumsHolderText3.setFill(Color.WHITE);
            drumsHolderText3.setTranslateX(-1490);
            drumsHolderText3.setTranslateZ(-195);
            drumsHolderText3.setTranslateY(-2070);
            drumsHolderText3.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text drumsHolderText4 = new Text("");
            drumsHolderText4.setFill(Color.WHITE);
            drumsHolderText4.setTranslateX(-1490);
            drumsHolderText4.setTranslateZ(-195);
            drumsHolderText4.setTranslateY(-2020);
            drumsHolderText4.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text drumsHolderText5 = new Text("");
            drumsHolderText5.setFill(Color.WHITE);
            drumsHolderText5.setTranslateX(-1490);
            drumsHolderText5.setTranslateZ(-195);
            drumsHolderText5.setTranslateY(-1970);
            drumsHolderText5.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text drumsHolderText6 = new Text("");
            drumsHolderText6.setFill(Color.WHITE);
            drumsHolderText6.setTranslateX(-1490);
            drumsHolderText6.setTranslateZ(-195);
            drumsHolderText6.setTranslateY(-1920);
            drumsHolderText6.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text drumsHolderText7 = new Text("");
            drumsHolderText7.setFill(Color.WHITE);
            drumsHolderText7.setTranslateX(-1490);
            drumsHolderText7.setTranslateZ(-195);
            drumsHolderText7.setTranslateY(-1870);
            drumsHolderText7.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text drumsHolderText8 = new Text("");
            drumsHolderText8.setFill(Color.WHITE);
            drumsHolderText8.setTranslateX(-1490);
            drumsHolderText8.setTranslateZ(-195);
            drumsHolderText8.setTranslateY(-1820);
            drumsHolderText8.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text drumsHolderText9 = new Text("");
            drumsHolderText9.setFill(Color.WHITE);
            drumsHolderText9.setTranslateX(-1490);
            drumsHolderText9.setTranslateZ(-195);
            drumsHolderText9.setTranslateY(-1770);
            drumsHolderText9.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text drumsHolderText10 = new Text("");
            drumsHolderText10.setFill(Color.WHITE);
            drumsHolderText10.setTranslateX(-1490);
            drumsHolderText10.setTranslateZ(-195);
            drumsHolderText10.setTranslateY(-1720);
            drumsHolderText10.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));

            Text[] pianoTextArr = {pianoHolderText1, pianoHolderText2, pianoHolderText3, pianoHolderText4, pianoHolderText5, pianoHolderText6, pianoHolderText7, pianoHolderText8, pianoHolderText9, pianoHolderText10};
            //piano queues
            Text queueListText1 = new Text(pianoArr.get(musicHolder1+scrollCounter));
            queueListText1.setFill(Color.WHITE);
            queueListText1.setTranslateX(1380);
            queueListText1.setTranslateZ(250);
            queueListText1.setTranslateY(-1700);
            queueListText1.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
            queueListText1.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
            queueListText1.setOnMouseClicked(event -> {
                for(int i = 0; i < pianoTextArr.length; i++)
                {
                    if(pianoCount >= 10)
                    {
                        break;
                    }
                    if(pianoTextArr[i].getText().equals(""))
                    {
                        pianoTextArr[i].setText(pianoArr.get(0+scrollCounter));
                        pianoholderArr.set(pianoCount, pianoArr.get(0+scrollCounter));
                        pianoCount++;
                        break;
                    }
                }
            });

            Text queueListText2 = new Text(pianoArr.get(musicHolder2+scrollCounter));
            queueListText2.setFill(Color.WHITE);
            queueListText2.setTranslateX(1380);
            queueListText2.setTranslateZ(200);
            queueListText2.setTranslateY(-1700);
            queueListText2.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
            queueListText2.setOnMouseClicked(event -> {
                for(int i = 0; i < pianoTextArr.length; i++)
                {
                    if(pianoCount >= 10)
                    {
                        break;
                    }
                    if(pianoTextArr[i].getText().equals(""))
                    {
                        pianoTextArr[i].setText(pianoArr.get(1+scrollCounter));
                        pianoholderArr.set(pianoCount, pianoArr.get(1+scrollCounter));
                        pianoCount++;
                        break;
                    }
                }
            });

            Text queueListText3 = new Text(pianoArr.get(musicHolder3+scrollCounter));
            queueListText3.setFill(Color.WHITE);
            queueListText3.setTranslateX(1380);
            queueListText3.setTranslateZ(150);
            queueListText3.setTranslateY(-1700);
            queueListText3.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
            queueListText3.setOnMouseClicked(event -> {
                for(int i = 0; i < pianoTextArr.length; i++)
                {
                    if(pianoCount >= 10)
                    {
                        break;
                    }
                    if(pianoTextArr[i].getText().equals(""))
                    {
                        pianoTextArr[i].setText(pianoArr.get(2+scrollCounter));
                        pianoholderArr.set(pianoCount, pianoArr.get(2+scrollCounter));
                        pianoCount++;
                        break;
                    }
                }
            });

            Text queueListText4 = new Text(pianoArr.get(musicHolder4+scrollCounter));
            queueListText4.setFill(Color.WHITE);
            queueListText4.setTranslateX(1380);
            queueListText4.setTranslateZ(100);
            queueListText4.setTranslateY(-1700);
            queueListText4.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
            queueListText4.setOnMouseClicked(event -> {
                for(int i = 0; i < pianoTextArr.length; i++)
                {
                    if(pianoCount >= 10)
                    {
                        break;
                    }
                    if(pianoTextArr[i].getText().equals(""))
                    {
                        pianoTextArr[i].setText(pianoArr.get(3+scrollCounter));
                        pianoholderArr.set(pianoCount, pianoArr.get(3+scrollCounter));
                        pianoCount++;
                        break;
                    }
                }
            });

            Text queueListText5 = new Text(pianoArr.get(musicHolder5+scrollCounter));
            queueListText5.setFill(Color.WHITE);
            queueListText5.setTranslateX(1380);
            queueListText5.setTranslateZ(50);
            queueListText5.setTranslateY(-1700);
            queueListText5.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
            queueListText5.setOnMouseClicked(event -> {
                for(int i = 0; i < pianoTextArr.length; i++)
                {
                    if(pianoCount >= 10)
                    {
                        break;
                    }
                    if(pianoTextArr[i].getText().equals(""))
                    {
                        pianoTextArr[i].setText(pianoArr.get(4+scrollCounter));
                        pianoholderArr.set(pianoCount, pianoArr.get(4+scrollCounter));
                        pianoCount++;
                        break;
                    }
                }
            });

            Text queueListText6 = new Text(pianoArr.get(musicHolder6+scrollCounter));
            queueListText6.setFill(Color.WHITE);
            queueListText6.setTranslateX(1380);
            queueListText6.setTranslateZ(0);
            queueListText6.setTranslateY(-1700);
            queueListText6.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
            queueListText6.setOnMouseClicked(event -> {
                for(int i = 0; i < pianoTextArr.length; i++)
                {
                    if(pianoCount >= 10)
                    {
                        break;
                    }
                    if(pianoTextArr[i].getText().equals(""))
                    {
                        pianoTextArr[i].setText(pianoArr.get(5+scrollCounter));
                        pianoholderArr.set(pianoCount, pianoArr.get(5+scrollCounter));
                        pianoCount++;
                        break;
                    }
                }
            });

            Text queueListText7 = new Text(pianoArr.get(musicHolder7+scrollCounter));
            queueListText7.setFill(Color.WHITE);
            queueListText7.setTranslateX(1380);
            queueListText7.setTranslateZ(-50);
            queueListText7.setTranslateY(-1700);
            queueListText7.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
            queueListText7.setOnMouseClicked(event -> {
                for(int i = 0; i < pianoTextArr.length; i++)
                {
                    if(pianoCount >= 10)
                    {
                        break;
                    }
                    if(pianoTextArr[i].getText().equals(""))
                    {
                        pianoTextArr[i].setText(pianoArr.get(6+scrollCounter));
                        pianoholderArr.set(pianoCount, pianoArr.get(6+scrollCounter));
                        pianoCount++;
                        break;
                    }
                }
            });

            Text queueListText8 = new Text(pianoArr.get(musicHolder8+scrollCounter));
            queueListText8.setFill(Color.WHITE);
            queueListText8.setTranslateX(1380);
            queueListText8.setTranslateZ(-100);
            queueListText8.setTranslateY(-1700);
            queueListText8.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
            queueListText8.setOnMouseClicked(event -> {
                for(int i = 0; i < pianoTextArr.length; i++)
                {
                    if(pianoCount >= 10)
                    {
                        break;
                    }
                    if(pianoTextArr[i].getText().equals(""))
                    {
                        pianoTextArr[i].setText(pianoArr.get(7+scrollCounter));
                        pianoholderArr.set(pianoCount, pianoArr.get(7+scrollCounter));
                        pianoCount++;
                        break;
                    }
                }
            });

            Text queueListText9 = new Text(pianoArr.get(musicHolder9+scrollCounter));
            queueListText9.setFill(Color.WHITE);
            queueListText9.setTranslateX(1380);
            queueListText9.setTranslateZ(-150);
            queueListText9.setTranslateY(-1700);
            queueListText9.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
            queueListText9.setOnMouseClicked(event -> {
                for(int i = 0; i < pianoTextArr.length; i++)
                {
                    if(pianoCount >= 10)
                    {
                        break;
                    }
                    if(pianoTextArr[i].getText().equals(""))
                    {
                        pianoTextArr[i].setText(pianoArr.get(8+scrollCounter));
                        pianoholderArr.set(pianoCount, pianoArr.get(8+scrollCounter));
                        pianoCount++;
                        break;
                    }
                }
            });

            Text queueListText10 = new Text(pianoArr.get(musicHolder10+scrollCounter));
            queueListText10.setFill(Color.WHITE);
            queueListText10.setTranslateX(1380);
            queueListText10.setTranslateZ(-200);
            queueListText10.setTranslateY(-1700);
            queueListText10.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
            queueListText10.setOnMouseClicked(event -> {
                for(int i = 0; i < pianoTextArr.length; i++)
                {
                    if(pianoCount >= 10)
                    {
                        break;
                    }
                    if(pianoTextArr[i].getText().equals(""))
                    {
                        pianoTextArr[i].setText(pianoArr.get(9+scrollCounter));
                        pianoholderArr.set(pianoCount, pianoArr.get(9+scrollCounter));
                        pianoCount++;
                        break;
                    }
                }
            });

            Text queueListText11 = new Text(pianoArr.get(musicHolder11+scrollCounter));
            queueListText11.setFill(Color.WHITE);
            queueListText11.setTranslateX(1380);
            queueListText11.setTranslateZ(-250);
            queueListText11.setTranslateY(-1700);
            queueListText11.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
            queueListText11.setOnMouseClicked(event -> {
                for(int i = 0; i < pianoTextArr.length; i++)
                {
                    if(pianoCount >= 10)
                    {
                        break;
                    }
                    if(pianoTextArr[i].getText().equals(""))
                    {
                        pianoTextArr[i].setText(pianoArr.get(10+scrollCounter));
                        pianoholderArr.set(pianoCount, pianoArr.get(10+scrollCounter));
                        pianoCount++;
                        break;
                    }
                }
            });

            Text queueListText12 = new Text(pianoArr.get(musicHolder12+scrollCounter));
            queueListText12.setFill(Color.WHITE);
            queueListText12.setTranslateX(1380);
            queueListText12.setTranslateZ(-300);
            queueListText12.setTranslateY(-1700);
            queueListText12.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
            queueListText12.setOnMouseClicked(event -> {
                for(int i = 0; i < pianoTextArr.length; i++)
                {
                    if(pianoCount >= 10)
                    {
                        break;
                    }
                    if(pianoTextArr[i].getText().equals(""))
                    {
                        pianoTextArr[i].setText(pianoArr.get(11+scrollCounter));
                        pianoholderArr.set(pianoCount, pianoArr.get(11+scrollCounter));
                        pianoCount++;
                        break;
                    }
                }
            });

            Text[] guitarTextArr = {guitarHolderText1, guitarHolderText2, guitarHolderText3, guitarHolderText4, guitarHolderText5, guitarHolderText6, guitarHolderText7, guitarHolderText8, guitarHolderText9, guitarHolderText10};
            //piano queues
            Text playListText1 = new Text(guitarArr.get(0));
            playListText1.setFill(Color.WHITE);
            playListText1.setTranslateX(1380);
            playListText1.setTranslateZ(250);
            playListText1.setTranslateY(-1900);
            playListText1.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
            playListText1.setOnMouseClicked(event -> {
                for(int i = 0; i < guitarTextArr.length; i++)
                {
                    if(guitarCount >= 10)
                    {
                        break;
                    }
                    if(guitarTextArr[i].getText().equals(""))
                    {
                        guitarTextArr[i].setText(guitarArrReference.get(0));
                        guitarholderArr.set(guitarCount, guitarArr.get(0));
                        guitarCount++;
                        break;
                    }
                }
            });

            Text playListText2 = new Text(guitarArr.get(1));
            playListText2.setFill(Color.WHITE);
            playListText2.setTranslateX(1380);
            playListText2.setTranslateZ(200);
            playListText2.setTranslateY(-1900);
            playListText2.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
            playListText2.setOnMouseClicked(event -> {
                for(int i = 0; i < guitarTextArr.length; i++)
                {
                    if(guitarCount >= 10)
                    {
                        break;
                    }
                    if(guitarTextArr[i].getText().equals(""))
                    {
                        guitarTextArr[i].setText(guitarArrReference.get(1));
                        guitarholderArr.set(guitarCount, guitarArr.get(1));
                        guitarCount++;
                        break;
                    }
                }
            });

            Text playListText3 = new Text(guitarArr.get(2));
            playListText3.setFill(Color.WHITE);
            playListText3.setTranslateX(1380);
            playListText3.setTranslateZ(150);
            playListText3.setTranslateY(-1900);
            playListText3.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
            playListText3.setOnMouseClicked(event -> {
                for(int i = 0; i < guitarTextArr.length; i++)
                {
                    if(guitarCount >= 10)
                    {
                        break;
                    }
                    if(guitarTextArr[i].getText().equals(""))
                    {
                        guitarTextArr[i].setText(guitarArrReference.get(2));
                        guitarholderArr.set(guitarCount, guitarArr.get(2));
                        guitarCount++;
                        break;
                    }
                }
            });

            Text playListText4 = new Text(guitarArr.get(3));
            playListText4.setFill(Color.WHITE);
            playListText4.setTranslateX(1380);
            playListText4.setTranslateZ(100);
            playListText4.setTranslateY(-1900);
            playListText4.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
            playListText4.setOnMouseClicked(event -> {
                for(int i = 0; i < guitarTextArr.length; i++)
                {
                    if(guitarCount >= 10)
                    {
                        break;
                    }
                    if(guitarTextArr[i].getText().equals(""))
                    {
                        guitarTextArr[i].setText(guitarArrReference.get(3));
                        guitarholderArr.set(guitarCount, guitarArr.get(3));
                        guitarCount++;
                        break;
                    }
                }
            });

            Text playListText5 = new Text(guitarArr.get(4));
            playListText5.setFill(Color.WHITE);
            playListText5.setTranslateX(1380);
            playListText5.setTranslateZ(50);
            playListText5.setTranslateY(-1900);
            playListText5.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
            playListText5.setOnMouseClicked(event -> {
                for(int i = 0; i < guitarTextArr.length; i++)
                {
                    if(guitarCount >= 10)
                    {
                        break;
                    }
                    if(guitarTextArr[i].getText().equals(""))
                    {
                        guitarTextArr[i].setText(guitarArrReference.get(4));
                        guitarholderArr.set(guitarCount, guitarArr.get(4));
                        guitarCount++;
                        break;
                    }
                }
            });

            Text playListText6 = new Text(guitarArr.get(5));
            playListText6.setFill(Color.WHITE);
            playListText6.setTranslateX(1380);
            playListText6.setTranslateZ(0);
            playListText6.setTranslateY(-1900);
            playListText6.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
            playListText6.setOnMouseClicked(event -> {
                for(int i = 0; i < guitarTextArr.length; i++)
                {
                    if(guitarCount >= 10)
                    {
                        break;
                    }
                    if(guitarTextArr[i].getText().equals(""))
                    {
                        guitarTextArr[i].setText(guitarArrReference.get(5));
                        guitarholderArr.set(guitarCount, guitarArr.get(5));
                        guitarCount++;
                        break;
                    }
                }
            });

            Text playListText7 = new Text(guitarArr.get(6));
            playListText7.setFill(Color.WHITE);
            playListText7.setTranslateX(1380);
            playListText7.setTranslateZ(-50);
            playListText7.setTranslateY(-1900);
            playListText7.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
            playListText7.setOnMouseClicked(event -> {
                for(int i = 0; i < guitarTextArr.length; i++)
                {
                    if(guitarCount >= 10)
                    {
                        break;
                    }
                    if(guitarTextArr[i].getText().equals(""))
                    {
                        guitarTextArr[i].setText(guitarArrReference.get(6));
                        guitarholderArr.set(guitarCount, guitarArr.get(6));
                        guitarCount++;
                        break;
                    }
                }
            });

            Text playListText8 = new Text(guitarArr.get(7));
            playListText8.setFill(Color.WHITE);
            playListText8.setTranslateX(1380);
            playListText8.setTranslateZ(-100);
            playListText8.setTranslateY(-1900);
            playListText8.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
            playListText8.setOnMouseClicked(event -> {
                for(int i = 0; i < guitarTextArr.length; i++)
                {
                    if(guitarCount >= 10)
                    {
                        break;
                    }
                    if(guitarTextArr[i].getText().equals(""))
                    {
                        guitarTextArr[i].setText(guitarArrReference.get(7));
                        guitarholderArr.set(guitarCount, guitarArr.get(7));
                        guitarCount++;
                        break;
                    }
                }
            });

            Text playListText9 = new Text(guitarArr.get(8));
            playListText9.setFill(Color.WHITE);
            playListText9.setTranslateX(1380);
            playListText9.setTranslateZ(-150);
            playListText9.setTranslateY(-1900);
            playListText9.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
            playListText9.setOnMouseClicked(event -> {
                for(int i = 0; i < guitarTextArr.length; i++)
                {
                    if(guitarCount >= 10)
                    {
                        break;
                    }
                    if(guitarTextArr[i].getText().equals(""))
                    {
                        guitarTextArr[i].setText(guitarArrReference.get(8));
                        guitarholderArr.set(guitarCount, guitarArr.get(8));
                        guitarCount++;
                        break;
                    }
                }
            });

            Text playListText10 = new Text(guitarArr.get(9));
            playListText10.setFill(Color.WHITE);
            playListText10.setTranslateX(1380);
            playListText10.setTranslateZ(-200);
            playListText10.setTranslateY(-1900);
            playListText10.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
            playListText10.setOnMouseClicked(event -> {
                for(int i = 0; i < guitarTextArr.length; i++)
                {
                    if(guitarCount >= 10)
                    {
                        break;
                    }
                    if(guitarTextArr[i].getText().equals(""))
                    {
                        guitarTextArr[i].setText(guitarArrReference.get(9));
                        guitarholderArr.set(guitarCount, guitarArr.get(9));
                        guitarCount++;
                        break;
                    }
                }
            });

            Text playListText11 = new Text(guitarArr.get(10));
            playListText11.setFill(Color.WHITE);
            playListText11.setTranslateX(1380);
            playListText11.setTranslateZ(-250);
            playListText11.setTranslateY(-1900);
            playListText11.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
            playListText11.setOnMouseClicked(event -> {
                for(int i = 0; i < guitarTextArr.length; i++)
                {
                    if(guitarCount >= 10)
                    {
                        break;
                    }
                    if(guitarTextArr[i].getText().equals(""))
                    {
                        guitarTextArr[i].setText(guitarArrReference.get(10));
                        guitarholderArr.set(guitarCount, guitarArr.get(10));
                        guitarCount++;
                        break;
                    }
                }
            });

            Text playListText12 = new Text(guitarArr.get(11));
            playListText12.setFill(Color.WHITE);
            playListText12.setTranslateX(1380);
            playListText12.setTranslateZ(-300);
            playListText12.setTranslateY(-1900);
            playListText12.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
            playListText12.setOnMouseClicked(event -> {
                for(int i = 0; i < guitarTextArr.length; i++)
                {
                    if(guitarCount >= 10)
                    {
                        break;
                    }
                    if(guitarTextArr[i].getText().equals(""))
                    {
                        guitarTextArr[i].setText(guitarArrReference.get(11));
                        guitarholderArr.set(guitarCount, guitarArr.get(11));
                        guitarCount++;
                        break;
                    }
                }
            });


            Text[] drumTextArr = {drumsHolderText1, drumsHolderText2, drumsHolderText3, drumsHolderText4, drumsHolderText5, drumsHolderText6, drumsHolderText7, drumsHolderText8, drumsHolderText9, drumsHolderText10};
            Text drumText1 = new Text(drumArr.get(0));
            drumText1.setFill(Color.WHITE);
            drumText1.setTranslateX(1380);
            drumText1.setTranslateZ(250);
            drumText1.setTranslateY(-2100);
            drumText1.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
            drumText1.setOnMouseClicked(event -> {
                for(int i = 0; i < drumTextArr.length; i++)
                {
                    if(drumCount >= 10)
                    {
                        break;
                    }
                    if(drumTextArr[i].getText().equals(""))
                    {
                        drumTextArr[i].setText(drumArrReference.get(0));
                        drumholderArr.set(drumCount, drumArr.get(0));
                        drumCount++;
                        break;
                    }
                }
            });


            Text drumText2 = new Text(drumArr.get(1));
            drumText2.setFill(Color.WHITE);
            drumText2.setTranslateX(1380);
            drumText2.setTranslateZ(200);
            drumText2.setTranslateY(-2100);
            drumText2.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
            drumText2.setOnMouseClicked(event -> {
                for(int i = 0; i < drumTextArr.length; i++)
                {
                    if(drumCount >= 10)
                    {
                        break;
                    }
                    if(drumTextArr[i].getText().equals(""))
                    {
                        drumTextArr[i].setText(drumArrReference.get(1));
                        drumholderArr.set(drumCount, drumArr.get(1));
                        drumCount++;
                        break;
                    }
                }
            });

            Text drumText3 = new Text(drumArr.get(2));
            drumText3.setFill(Color.WHITE);
            drumText3.setTranslateX(1380);
            drumText3.setTranslateZ(150);
            drumText3.setTranslateY(-2100);
            drumText3.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
            drumText3.setOnMouseClicked(event -> {
                for(int i = 0; i < drumTextArr.length; i++)
                {
                    if(drumCount >= 10)
                    {
                        break;
                    }
                    if(drumTextArr[i].getText().equals(""))
                    {
                        drumTextArr[i].setText(drumArrReference.get(2));
                        drumholderArr.set(drumCount, drumArr.get(2));
                        drumCount++;
                        break;
                    }
                }
            });

            Text drumText4 = new Text(drumArr.get(3));
            drumText4.setFill(Color.WHITE);
            drumText4.setTranslateX(1380);
            drumText4.setTranslateZ(100);
            drumText4.setTranslateY(-2100);
            drumText4.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
            drumText4.setOnMouseClicked(event -> {
                for(int i = 0; i < drumTextArr.length; i++)
                {
                    if(drumCount >= 10)
                    {
                        break;
                    }
                    if(drumTextArr[i].getText().equals(""))
                    {
                        drumTextArr[i].setText(drumArrReference.get(3));
                        drumholderArr.set(drumCount, drumArr.get(3));
                        drumCount++;
                        break;
                    }
                }
            });

            Text drumText5 = new Text(drumArr.get(4));
            drumText5.setFill(Color.WHITE);
            drumText5.setTranslateX(1380);
            drumText5.setTranslateZ(50);
            drumText5.setTranslateY(-2100);
            drumText5.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
            drumText5.setOnMouseClicked(event -> {
                for(int i = 0; i < drumTextArr.length; i++)
                {
                    if(drumCount >= 10)
                    {
                        break;
                    }
                    if(drumTextArr[i].getText().equals(""))
                    {
                        drumTextArr[i].setText(drumArrReference.get(4));
                        drumholderArr.set(drumCount, drumArr.get(4));
                        drumCount++;
                        break;
                    }
                }
            });

            Text drumText6 = new Text(drumArr.get(5));
            drumText6.setFill(Color.WHITE);
            drumText6.setTranslateX(1380);
            drumText6.setTranslateZ(0);
            drumText6.setTranslateY(-2100);
            drumText6.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
            drumText6.setOnMouseClicked(event -> {
                for(int i = 0; i < drumTextArr.length; i++)
                {
                    if(drumCount >= 10)
                    {
                        break;
                    }
                    if(drumTextArr[i].getText().equals(""))
                    {
                        drumTextArr[i].setText(drumArrReference.get(5));
                        drumholderArr.set(drumCount, drumArr.get(5));
                        drumCount++;
                        break;
                    }
                }
            });

            Text drumText7 = new Text(drumArr.get(6));
            drumText7.setFill(Color.WHITE);
            drumText7.setTranslateX(1380);
            drumText7.setTranslateZ(-50);
            drumText7.setTranslateY(-2100);
            drumText7.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 16));
            drumText7.setOnMouseClicked(event -> {
                for(int i = 0; i < drumTextArr.length; i++)
                {
                    if(drumCount >= 10)
                    {
                        break;
                    }
                    if(drumTextArr[i].getText().equals(""))
                    {
                        drumTextArr[i].setText(drumArrReference.get(6));
                        drumholderArr.set(drumCount, drumArr.get(6));
                        drumCount++;
                        break;
                    }
                }
            });





            Text songsTitleText = new Text("Statistics");
            songsTitleText.setFill(Color.WHITE);
            songsTitleText.setTranslateX(-60);
            songsTitleText.setTranslateZ(300);
            songsTitleText.setTranslateY(-3490);
            songsTitleText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));

            Text totalsupplyText = new Text("Total Supply: ");
            totalsupplyText.setFill(Color.WHITE);
            totalsupplyText.setTranslateX(-60);
            totalsupplyText.setTranslateZ(250);
            totalsupplyText.setTranslateY(-3450);
            totalsupplyText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));

            Text totalsupplycontentsText = new Text(totalSupply + "");
            totalsupplycontentsText.setFill(Color.WHITE);
            totalsupplycontentsText.setTranslateX(-60);
            totalsupplycontentsText.setTranslateZ(190);
            totalsupplycontentsText.setTranslateY(-3450);
            totalsupplycontentsText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));

            Text rarityText = new Text("Rarity Text: ");
            rarityText.setFill(Color.WHITE);
            rarityText.setTranslateX(-60);
            rarityText.setTranslateZ(130);
            rarityText.setTranslateY(-3450);
            rarityText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));

            Text raritycontentsText = new Text(rarity);
            raritycontentsText.setFill(Color.WHITE);
            raritycontentsText.setTranslateX(-60);
            raritycontentsText.setTranslateZ(70);
            raritycontentsText.setTranslateY(-3450);
            raritycontentsText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));

            Text floorpriceText = new Text("Price: ");
            floorpriceText.setFill(Color.WHITE);
            floorpriceText.setTranslateX(-60);
            floorpriceText.setTranslateZ(10);
            floorpriceText.setTranslateY(-3450);
            floorpriceText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));

            Text floorpricecontentsText = new Text(floorPrice+"ETH");
            floorpricecontentsText.setFill(Color.WHITE);
            floorpricecontentsText.setTranslateX(-60);
            floorpricecontentsText.setTranslateZ(-50);
            floorpricecontentsText.setTranslateY(-3450);
            floorpricecontentsText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));

            Text albumNameText = new Text("NFT Name: ");
            albumNameText.setFill(Color.WHITE);
            albumNameText.setTranslateX(330);
            albumNameText.setTranslateZ(300);
            albumNameText.setTranslateY(-3490);
            albumNameText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));

            Text albumContentsText = new Text("Blender Dummy");
            albumContentsText.setFill(Color.WHITE);
            albumContentsText.setTranslateX(135);
            albumContentsText.setTranslateZ(300);
            albumContentsText.setTranslateY(-3490);
            albumContentsText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));







            Text sortingText = new Text("ID: ");
            sortingText.setFill(Color.WHITE);
            sortingText.setTranslateX(290);
            sortingText.setTranslateZ(-115);
            sortingText.setTranslateY(-3480);
            sortingText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

            Text IDText = new Text("ID TEXT");
            IDText.setFill(Color.WHITE);
            IDText.setTranslateX(210);
            IDText.setTranslateZ(-115);
            IDText.setTranslateY(-3480);
            IDText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

            Text alphabeticalSortText = new Text("PID: ");
            alphabeticalSortText.setFill(Color.WHITE);
            alphabeticalSortText.setTranslateX(290);
            alphabeticalSortText.setTranslateZ(-165);
            alphabeticalSortText.setTranslateY(-3480);
            alphabeticalSortText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

            Text PIDText = new Text("PID TEXT");
            PIDText.setFill(Color.WHITE);
            PIDText.setTranslateX(210);
            PIDText.setTranslateZ(-165);
            PIDText.setTranslateY(-3480);
            PIDText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

            Text reversealphabeticalSortText = new Text("GID: ");
            reversealphabeticalSortText.setFill(Color.WHITE);
            reversealphabeticalSortText.setTranslateX(290);
            reversealphabeticalSortText.setTranslateZ(-215);
            reversealphabeticalSortText.setTranslateY(-3480);
            reversealphabeticalSortText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 19));

            Text GIDText = new Text("GID TEXT");
            GIDText.setFill(Color.WHITE);
            GIDText.setTranslateX(210);
            GIDText.setTranslateZ(-215);
            GIDText.setTranslateY(-3480);
            GIDText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 19));

            Text popularitySortText = new Text("DID: ");
            popularitySortText.setFill(Color.WHITE);
            popularitySortText.setTranslateX(290);
            popularitySortText.setTranslateZ(-265);
            popularitySortText.setTranslateY(-3480);
            popularitySortText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

            Text DIDText = new Text("DID TEXT");
            DIDText.setFill(Color.WHITE);
            DIDText.setTranslateX(210);
            DIDText.setTranslateZ(-265);
            DIDText.setTranslateY(-3480);
            DIDText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

            Text reversepopularitySortText = new Text("Text");
            reversepopularitySortText.setFill(Color.WHITE);
            reversepopularitySortText.setTranslateX(290);
            reversepopularitySortText.setTranslateZ(-315);
            reversepopularitySortText.setTranslateY(-3480);
            reversepopularitySortText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

            Text notesTitleText = new Text("Piano");
            notesTitleText.setFill(Color.WHITE);
            notesTitleText.setTranslateX(1400);
            notesTitleText.setTranslateZ(290);
            notesTitleText.setTranslateY(-1690);
            notesTitleText.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 30));

            Text playlistText = new Text("Guitar");
            playlistText.setFill(Color.WHITE);
            playlistText.setTranslateX(1400);
            playlistText.setTranslateZ(290);
            playlistText.setTranslateY(-1890);
            playlistText.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 30));

            Text drumsTitleText = new Text("Drums");
            drumsTitleText.setFill(Color.WHITE);
            drumsTitleText.setTranslateX(1400);
            drumsTitleText.setTranslateZ(290);
            drumsTitleText.setTranslateY(-2090);
            drumsTitleText.setFont(Font.font("verdana", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 30));





//            Text musicText13 = new Text(songStrings.get(12));
//            musicText13.setTranslateX(-60);
//            musicText13.setTranslateZ(-350);
//            musicText13.setTranslateY(-3490);
//            musicText13.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));
//
//            Text musicText14 = new Text(songStrings.get(13));
//            musicText14.setTranslateX(-60);
//            musicText14.setTranslateZ(-400);
//            musicText14.setTranslateY(-3490);
//            musicText14.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));
//
//            Text musicText15 = new Text(songStrings.get(14));
//            musicText15.setTranslateX(-60);
//            musicText15.setTranslateZ(-450);
//            musicText15.setTranslateY(-3490);
//            musicText15.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));




            //box Transformation
            Transform boxTransform1 = new Rotate(90, new Point3D(1,0,0));
            Transform boxTransform2 = new Rotate(90, new Point3D(0,1,0));
            Transform boxTransform3 = new Rotate (180, new Point3D(0,0,1));
            Transform boxTransform4 = new Rotate (-90, new Point3D(0,0,1));
            Transform boxTransform5 = new Rotate (180, new Point3D(0,0,1));
            Transform boxTransform6 = new Rotate (40, new Point3D(0,1,0));
            Transform boxTransform7 = new Rotate (130, new Point3D(0,1,0));
            Transform boxTransform8 = new Rotate (-5, new Point3D(0,1,0));
            Transform boxTransform9 = new Rotate (180, new Point3D(0,1,0));
            Transform boxTransform10 = new Rotate(-90, new Point3D(0,0,1));
            Transform boxTransform11 = new Rotate(90, new Point3D(0,0,1));

            screen1.getTransforms().addAll(boxTransform1,boxTransform3);
            screen2.getTransforms().add(boxTransform1);
            screen3.getTransforms().addAll(boxTransform2,boxTransform10);
            screen4.getTransforms().add(boxTransform2);
            screen5.getTransforms().addAll(boxTransform1,boxTransform3,boxTransform7);
            screen6.getTransforms().addAll(boxTransform1,boxTransform3,boxTransform6);
            screen7.getTransforms().addAll(boxTransform1,boxTransform3,boxTransform7,boxTransform8);
            screen8.getTransforms().addAll(boxTransform1,boxTransform3,boxTransform6);


            scrollRightbutton.getTransforms().addAll(boxTransform2,boxTransform4,boxTransform10);
            scrollLeftButton.getTransforms().addAll(boxTransform2,boxTransform4,boxTransform11);

            playButton.getTransforms().addAll(boxTransform2,boxTransform4);
            plusButton.getTransforms().addAll(boxTransform2,boxTransform4);
            subtractButton.getTransforms().addAll(boxTransform2,boxTransform4);
            skipnextButton.getTransforms().addAll(boxTransform2,boxTransform4);
            gobackButton.getTransforms().addAll(boxTransform2,boxTransform4);
            loopButton.getTransforms().addAll(boxTransform2,boxTransform4);
            shuffleButton.getTransforms().addAll(boxTransform2,boxTransform4);
            defaultPicture.getTransforms().addAll(boxTransform2,boxTransform4);
            musicButton1.getTransforms().addAll(boxTransform1);
            musicButton2.getTransforms().addAll(boxTransform1);
            musicButton3.getTransforms().addAll(boxTransform1);
            musicButton4.getTransforms().addAll(boxTransform1,boxTransform3);
            musicButton5.getTransforms().addAll(boxTransform1,boxTransform3);
            musicButton6.getTransforms().addAll(boxTransform1);
            musicButton7.getTransforms().addAll(boxTransform1);
            musicButton8.getTransforms().addAll(boxTransform1);
            musicButton9.getTransforms().addAll(boxTransform1);
            musicButton10.getTransforms().addAll(boxTransform1);
            musicButton11.getTransforms().addAll(boxTransform1);
            musicButton12.getTransforms().addAll(boxTransform1);

            queueButton1.getTransforms().addAll(boxTransform2,boxTransform4);
            queueButton2.getTransforms().addAll(boxTransform2,boxTransform4);
            queueButton3.getTransforms().addAll(boxTransform2,boxTransform4);
            queueButton4.getTransforms().addAll(boxTransform2,boxTransform4);
            queueButton5.getTransforms().addAll(boxTransform2,boxTransform4);
            queueButton6.getTransforms().addAll(boxTransform2,boxTransform4);
            queueButton7.getTransforms().addAll(boxTransform2,boxTransform4);
            queueButton8.getTransforms().addAll(boxTransform2,boxTransform4);
            queueButton9.getTransforms().addAll(boxTransform2,boxTransform4);
            queueButton10.getTransforms().addAll(boxTransform2,boxTransform4);
            queueButton11.getTransforms().addAll(boxTransform2,boxTransform4);
            queueButton12.getTransforms().addAll(boxTransform2,boxTransform4);

            playlistButton1.getTransforms().addAll(boxTransform2,boxTransform4);
            playlistButton2.getTransforms().addAll(boxTransform2,boxTransform4);
            playlistButton3.getTransforms().addAll(boxTransform2,boxTransform4);
            playlistButton4.getTransforms().addAll(boxTransform2,boxTransform4);
            playlistButton5.getTransforms().addAll(boxTransform2,boxTransform4);
            playlistButton6.getTransforms().addAll(boxTransform2,boxTransform4);
            playlistButton7.getTransforms().addAll(boxTransform2,boxTransform4);
            playlistButton8.getTransforms().addAll(boxTransform2,boxTransform4);
            playlistButton9.getTransforms().addAll(boxTransform2,boxTransform4);
            playlistButton10.getTransforms().addAll(boxTransform2,boxTransform4);
            playlistButton11.getTransforms().addAll(boxTransform2,boxTransform4);
            playlistButton12.getTransforms().addAll(boxTransform2,boxTransform4);

            drumButton1.getTransforms().addAll(boxTransform2,boxTransform4);
            drumButton2.getTransforms().addAll(boxTransform2,boxTransform4);
            drumButton3.getTransforms().addAll(boxTransform2,boxTransform4);
            drumButton4.getTransforms().addAll(boxTransform2,boxTransform4);
            drumButton5.getTransforms().addAll(boxTransform2,boxTransform4);
            drumButton6.getTransforms().addAll(boxTransform2,boxTransform4);
            drumButton7.getTransforms().addAll(boxTransform2,boxTransform4);

            pianoHolderText1.getTransforms().addAll(xRotate, yRotate, zRotate);
            pianoHolderText2.getTransforms().addAll(xRotate, yRotate, zRotate);
            pianoHolderText3.getTransforms().addAll(xRotate, yRotate, zRotate);
            pianoHolderText4.getTransforms().addAll(xRotate, yRotate, zRotate);
            pianoHolderText5.getTransforms().addAll(xRotate, yRotate, zRotate);
            pianoHolderText6.getTransforms().addAll(xRotate, yRotate, zRotate);
            pianoHolderText7.getTransforms().addAll(xRotate, yRotate, zRotate);
            pianoHolderText8.getTransforms().addAll(xRotate, yRotate, zRotate);
            pianoHolderText9.getTransforms().addAll(xRotate, yRotate, zRotate);
            pianoHolderText10.getTransforms().addAll(xRotate, yRotate, zRotate);


            guitarHolderText1.getTransforms().addAll(xRotate, yRotate, zRotate);
            guitarHolderText2.getTransforms().addAll(xRotate, yRotate, zRotate);
            guitarHolderText3.getTransforms().addAll(xRotate, yRotate, zRotate);
            guitarHolderText4.getTransforms().addAll(xRotate, yRotate, zRotate);
            guitarHolderText5.getTransforms().addAll(xRotate, yRotate, zRotate);
            guitarHolderText6.getTransforms().addAll(xRotate, yRotate, zRotate);
            guitarHolderText7.getTransforms().addAll(xRotate, yRotate, zRotate);
            guitarHolderText8.getTransforms().addAll(xRotate, yRotate, zRotate);
            guitarHolderText9.getTransforms().addAll(xRotate, yRotate, zRotate);
            guitarHolderText10.getTransforms().addAll(xRotate, yRotate, zRotate);


            drumsHolderText1.getTransforms().addAll(xRotate, yRotate, zRotate);
            drumsHolderText2.getTransforms().addAll(xRotate, yRotate, zRotate);
            drumsHolderText3.getTransforms().addAll(xRotate, yRotate, zRotate);
            drumsHolderText4.getTransforms().addAll(xRotate, yRotate, zRotate);
            drumsHolderText5.getTransforms().addAll(xRotate, yRotate, zRotate);
            drumsHolderText6.getTransforms().addAll(xRotate, yRotate, zRotate);
            drumsHolderText7.getTransforms().addAll(xRotate, yRotate, zRotate);
            drumsHolderText8.getTransforms().addAll(xRotate, yRotate, zRotate);
            drumsHolderText9.getTransforms().addAll(xRotate, yRotate, zRotate);
            drumsHolderText10.getTransforms().addAll(xRotate, yRotate, zRotate);





            goDownArrow2.getTransforms().addAll(boxTransform9);






            sortDropButton.getTransforms().addAll(boxTransform1);
            alphabeticalSortButton.getTransforms().addAll(boxTransform1);
            reversealphabeticalSortButton.getTransforms().addAll(boxTransform1);
            reversepopularitySortButton.getTransforms().addAll(boxTransform1);
            popularitySortButton.getTransforms().addAll(boxTransform1);


            alphabeticalSortText.getTransforms().addAll(boxTransform1,boxTransform5);
            reversealphabeticalSortText.getTransforms().addAll(boxTransform1,boxTransform5);
            popularitySortText.getTransforms().addAll(boxTransform1,boxTransform5);
            reversepopularitySortText.getTransforms().addAll(boxTransform1,boxTransform5);
            sortingText.getTransforms().addAll(boxTransform1,boxTransform5);
            IDText.getTransforms().addAll(boxTransform1,boxTransform5);
            GIDText.getTransforms().addAll(boxTransform1,boxTransform5);
            PIDText.getTransforms().addAll(boxTransform1,boxTransform5);
            DIDText.getTransforms().addAll(boxTransform1,boxTransform5);




            goUpArrow.getTransforms().addAll(boxTransform1,boxTransform5);
            goDownArrow.getTransforms().addAll(boxTransform1,boxTransform5);
            goUpArrow2.getTransforms().addAll(boxTransform2,boxTransform4);
            goDownArrow2.getTransforms().addAll(boxTransform2,boxTransform4);


            albumPreview.getTransforms().addAll(boxTransform1,boxTransform5);
//            musicSlider.getTransforms().addAll(xRotate, yRotate, zRotate);

//            musicText13.getTransforms().addAll(xRotate, yRotate, zRotate);
//            musicText14.getTransforms().addAll(xRotate, yRotate, zRotate);
//            musicText15.getTransforms().addAll(xRotate, yRotate, zRotate);

            songsTitleText.getTransforms().addAll(xRotate, yRotate, zRotate);
            totalsupplyText.getTransforms().addAll(xRotate, yRotate, zRotate);
            totalsupplycontentsText.getTransforms().addAll(xRotate, yRotate, zRotate);
            raritycontentsText.getTransforms().addAll(xRotate, yRotate, zRotate);
            rarityText.getTransforms().addAll(xRotate, yRotate, zRotate);
            floorpriceText.getTransforms().addAll(xRotate, yRotate, zRotate);
            floorpricecontentsText.getTransforms().addAll(xRotate, yRotate, zRotate);

            albumNameText.getTransforms().addAll(xRotate,yRotate,zRotate);
            albumContentsText.getTransforms().addAll(xRotate,yRotate,zRotate);

            notesTitleText.getTransforms().addAll(xRotate,yRotate,zRotate);
            playlistText.getTransforms().addAll(xRotate,yRotate,zRotate);
            drumsTitleText.getTransforms().addAll(xRotate,yRotate,zRotate);

            queueListText1.getTransforms().addAll(xRotate,yRotate,zRotate);
            queueListText2.getTransforms().addAll(xRotate,yRotate,zRotate);
            queueListText3.getTransforms().addAll(xRotate,yRotate,zRotate);
            queueListText4.getTransforms().addAll(xRotate,yRotate,zRotate);
            queueListText5.getTransforms().addAll(xRotate,yRotate,zRotate);
            queueListText6.getTransforms().addAll(xRotate,yRotate,zRotate);
            queueListText7.getTransforms().addAll(xRotate,yRotate,zRotate);
            queueListText8.getTransforms().addAll(xRotate,yRotate,zRotate);
            queueListText9.getTransforms().addAll(xRotate,yRotate,zRotate);
            queueListText10.getTransforms().addAll(xRotate,yRotate,zRotate);
            queueListText11.getTransforms().addAll(xRotate,yRotate,zRotate);
            queueListText12.getTransforms().addAll(xRotate,yRotate,zRotate);

            playListText1.getTransforms().addAll(xRotate,yRotate,zRotate);
            playListText2.getTransforms().addAll(xRotate,yRotate,zRotate);
            playListText3.getTransforms().addAll(xRotate,yRotate,zRotate);
            playListText4.getTransforms().addAll(xRotate,yRotate,zRotate);
            playListText5.getTransforms().addAll(xRotate,yRotate,zRotate);
            playListText6.getTransforms().addAll(xRotate,yRotate,zRotate);
            playListText7.getTransforms().addAll(xRotate,yRotate,zRotate);
            playListText8.getTransforms().addAll(xRotate,yRotate,zRotate);
            playListText9.getTransforms().addAll(xRotate,yRotate,zRotate);
            playListText10.getTransforms().addAll(xRotate,yRotate,zRotate);
            playListText11.getTransforms().addAll(xRotate,yRotate,zRotate);
            playListText12.getTransforms().addAll(xRotate,yRotate,zRotate);

            drumText1.getTransforms().addAll(xRotate,yRotate,zRotate);
            drumText2.getTransforms().addAll(xRotate,yRotate,zRotate);
            drumText3.getTransforms().addAll(xRotate,yRotate,zRotate);
            drumText4.getTransforms().addAll(xRotate,yRotate,zRotate);
            drumText5.getTransforms().addAll(xRotate,yRotate,zRotate);
            drumText6.getTransforms().addAll(xRotate,yRotate,zRotate);
            drumText7.getTransforms().addAll(xRotate,yRotate,zRotate);








//            musicSlider.getTransforms().addAll(boxTransform2,boxTransform4);

            sortButtons.add(alphabeticalSortButton);
            sortButtons.add(reversealphabeticalSortButton);
            sortButtons.add(popularitySortButton);
            sortButtons.add(reversepopularitySortButton);


            sortText.add(sortingText);
            sortText.add(alphabeticalSortText);
            sortText.add(reversealphabeticalSortText);
            sortText.add(popularitySortText);
            sortText.add(IDText);
            sortText.add(DIDText);
            sortText.add(GIDText);
            sortText.add(PIDText);
//            sortText.add(reversepopularitySortText);






            Group boxes = new Group();
            //can add more boxes here

//            boxes.getChildren().addAll(plusButton,subtractButton);
            boxes.getChildren().addAll(playlistButton1,playlistButton2,playlistButton3,playlistButton4,playlistButton5,playlistButton6,playlistButton7,playlistButton8,playlistButton9,playlistButton10,playlistButton11,playlistButton12);
            boxes.getChildren().addAll(goUpArrow2,goDownArrow2);
            boxes.getChildren().addAll(notesTitleText,playlistText,drumsTitleText);
            boxes.getChildren().addAll(queueButton1,queueButton2,queueButton3,queueButton4,queueButton5,queueButton6,queueButton7,queueButton8,queueButton9,queueButton10,queueButton11,queueButton12);
            boxes.getChildren().addAll(sortButtons);
            boxes.getChildren().addAll(sortText);
            boxes.getChildren().addAll(drumButton1,drumButton2,drumButton3,drumButton4,drumButton5,drumButton6,drumButton7);
            boxes.getChildren().addAll(queueListText1,queueListText2,queueListText3,queueListText4,queueListText5,queueListText6,queueListText7,queueListText8,queueListText9,queueListText10,queueListText11,queueListText12,playListText1,playListText2,playListText3,playListText4,playListText5,playListText6,playListText7,playListText8,playListText9,playListText10,playListText11,playListText12,drumText1,drumText2,drumText3,drumText4,drumText5,drumText6,drumText7);
            boxes.getChildren().addAll(screen1,screen2,screen3,screen4,screen5,screen6,musicButton1,songsTitleText,albumPreview,albumNameText, albumContentsText,musicButton2,musicButton3,musicButton4,musicButton5,totalsupplyText,totalsupplycontentsText,rarityText,raritycontentsText,floorpricecontentsText,floorpriceText);
            boxes.getChildren().addAll(guitarHolderText1,guitarHolderText2,guitarHolderText3,guitarHolderText4,guitarHolderText5,guitarHolderText6,guitarHolderText7,guitarHolderText8,guitarHolderText9,guitarHolderText10,pianoHolderText1,pianoHolderText2,pianoHolderText3,pianoHolderText4,pianoHolderText5,pianoHolderText6,pianoHolderText7,pianoHolderText8,pianoHolderText9,pianoHolderText10,drumsHolderText1,drumsHolderText2,drumsHolderText3,drumsHolderText4,drumsHolderText5,drumsHolderText6,drumsHolderText7,drumsHolderText8,drumsHolderText9,drumsHolderText10);
            boxes.getChildren().addAll(scrollRightbutton,scrollLeftButton);
            this.getChildren().add(boxes);


            //dummy audio is default
            try
            {
                Audio a = new Audio("DefaultMusic");

            }
            catch(Exception e)
            {
                System.out.println("File Not Found");
            }

            goUpArrow2.setOnMouseClicked(event -> {
                if (musicHolder1 + scrollCounter > 0)
                {
                    scrollCounter--;
                    queueListText1.setText(pianoArr.get(musicHolder1 + scrollCounter));
                    queueListText2.setText(pianoArr.get(musicHolder2 + scrollCounter));
                    queueListText3.setText(pianoArr.get(musicHolder3 + scrollCounter));
                    queueListText4.setText(pianoArr.get(musicHolder4 + scrollCounter));
                    queueListText5.setText(pianoArr.get(musicHolder5 + scrollCounter));
                    queueListText6.setText(pianoArr.get(musicHolder6 + scrollCounter));
                    queueListText7.setText(pianoArr.get(musicHolder7 + scrollCounter));
                    queueListText8.setText(pianoArr.get(musicHolder8 + scrollCounter));
                    queueListText9.setText(pianoArr.get(musicHolder9 + scrollCounter));
                    queueListText10.setText(pianoArr.get(musicHolder10 + scrollCounter));
                    queueListText11.setText(pianoArr.get(musicHolder11 + scrollCounter));
                    queueListText12.setText(pianoArr.get(musicHolder12 + scrollCounter));

                }
            });
            goDownArrow2.setOnMouseClicked(event -> {
                if(musicHolder12+scrollCounter<24) {
                    scrollCounter++;
                    queueListText1.setText(pianoArr.get(musicHolder1 + scrollCounter));
                    queueListText2.setText(pianoArr.get(musicHolder2 + scrollCounter));
                    queueListText3.setText(pianoArr.get(musicHolder3 + scrollCounter));
                    queueListText4.setText(pianoArr.get(musicHolder4 + scrollCounter));
                    queueListText5.setText(pianoArr.get(musicHolder5 + scrollCounter));
                    queueListText6.setText(pianoArr.get(musicHolder6 + scrollCounter));
                    queueListText7.setText(pianoArr.get(musicHolder7 + scrollCounter));
                    queueListText8.setText(pianoArr.get(musicHolder8 + scrollCounter));
                    queueListText9.setText(pianoArr.get(musicHolder9 + scrollCounter));
                    queueListText10.setText(pianoArr.get(musicHolder10 + scrollCounter));
                    queueListText11.setText(pianoArr.get(musicHolder11 + scrollCounter));
                    queueListText12.setText(pianoArr.get(musicHolder12 + scrollCounter));
                }

            });

            scrollLeftButton.setOnMouseClicked(event -> {
                if (musicHolder1 + scrollCounter2 > 0)
                {
                    scrollCounter2--;
                    pianoHolderText1.setText(pianoholderArr.get(musicHolder1 + scrollCounter2));
                    pianoHolderText2.setText(pianoholderArr.get(musicHolder2 + scrollCounter2));
                    pianoHolderText3.setText(pianoholderArr.get(musicHolder3 + scrollCounter2));
                    pianoHolderText4.setText(pianoholderArr.get(musicHolder4 + scrollCounter2));
                    pianoHolderText5.setText(pianoholderArr.get(musicHolder5 + scrollCounter2));
                    pianoHolderText6.setText(pianoholderArr.get(musicHolder6 + scrollCounter2));
                    pianoHolderText7.setText(pianoholderArr.get(musicHolder7 + scrollCounter2));
                    pianoHolderText8.setText(pianoholderArr.get(musicHolder8 + scrollCounter2));
                    pianoHolderText9.setText(pianoholderArr.get(musicHolder9 + scrollCounter2));
                    pianoHolderText10.setText(pianoholderArr.get(musicHolder10 + scrollCounter2));

                    guitarHolderText1.setText(guitarholderArr.get(musicHolder1 + scrollCounter2));
                    guitarHolderText2.setText(guitarholderArr.get(musicHolder2 + scrollCounter2));
                    guitarHolderText3.setText(guitarholderArr.get(musicHolder3 + scrollCounter2));
                    guitarHolderText4.setText(guitarholderArr.get(musicHolder4 + scrollCounter2));
                    guitarHolderText5.setText(guitarholderArr.get(musicHolder5 + scrollCounter2));
                    guitarHolderText6.setText(guitarholderArr.get(musicHolder6 + scrollCounter2));
                    guitarHolderText7.setText(guitarholderArr.get(musicHolder7 + scrollCounter2));
                    guitarHolderText8.setText(guitarholderArr.get(musicHolder8 + scrollCounter2));
                    guitarHolderText9.setText(guitarholderArr.get(musicHolder9 + scrollCounter2));
                    guitarHolderText10.setText(guitarholderArr.get(musicHolder10 + scrollCounter2));

                    drumsHolderText1.setText(drumholderArr.get(musicHolder1 + scrollCounter2));
                    drumsHolderText1.setText(drumholderArr.get(musicHolder2 + scrollCounter2));
                    drumsHolderText1.setText(drumholderArr.get(musicHolder3 + scrollCounter2));
                    drumsHolderText1.setText(drumholderArr.get(musicHolder4 + scrollCounter2));
                    drumsHolderText1.setText(drumholderArr.get(musicHolder5 + scrollCounter2));
                    drumsHolderText1.setText(drumholderArr.get(musicHolder6 + scrollCounter2));
                    drumsHolderText1.setText(drumholderArr.get(musicHolder7 + scrollCounter2));
                    drumsHolderText1.setText(drumholderArr.get(musicHolder8 + scrollCounter2));
                    drumsHolderText1.setText(drumholderArr.get(musicHolder9 + scrollCounter2));
                    drumsHolderText1.setText(drumholderArr.get(musicHolder10 + scrollCounter2));

                }
            });

            scrollRightbutton.setOnMouseClicked(event -> {
                if(musicHolder12+scrollCounter<102) {
                    scrollCounter++;
                    pianoHolderText1.setText(pianoholderArr.get(musicHolder1 + scrollCounter2));
                    pianoHolderText2.setText(pianoholderArr.get(musicHolder2 + scrollCounter2));
                    pianoHolderText3.setText(pianoholderArr.get(musicHolder3 + scrollCounter2));
                    pianoHolderText4.setText(pianoholderArr.get(musicHolder4 + scrollCounter2));
                    pianoHolderText5.setText(pianoholderArr.get(musicHolder5 + scrollCounter2));
                    pianoHolderText6.setText(pianoholderArr.get(musicHolder6 + scrollCounter2));
                    pianoHolderText7.setText(pianoholderArr.get(musicHolder7 + scrollCounter2));
                    pianoHolderText8.setText(pianoholderArr.get(musicHolder8 + scrollCounter2));
                    pianoHolderText9.setText(pianoholderArr.get(musicHolder9 + scrollCounter2));
                    pianoHolderText10.setText(pianoholderArr.get(musicHolder10 + scrollCounter2));

                    guitarHolderText1.setText(guitarholderArr.get(musicHolder1 + scrollCounter2));
                    guitarHolderText2.setText(guitarholderArr.get(musicHolder2 + scrollCounter2));
                    guitarHolderText3.setText(guitarholderArr.get(musicHolder3 + scrollCounter2));
                    guitarHolderText4.setText(guitarholderArr.get(musicHolder4 + scrollCounter2));
                    guitarHolderText5.setText(guitarholderArr.get(musicHolder5 + scrollCounter2));
                    guitarHolderText6.setText(guitarholderArr.get(musicHolder6 + scrollCounter2));
                    guitarHolderText7.setText(guitarholderArr.get(musicHolder7 + scrollCounter2));
                    guitarHolderText8.setText(guitarholderArr.get(musicHolder8 + scrollCounter2));
                    guitarHolderText9.setText(guitarholderArr.get(musicHolder9 + scrollCounter2));
                    guitarHolderText10.setText(guitarholderArr.get(musicHolder10 + scrollCounter2));

                    drumsHolderText1.setText(drumholderArr.get(musicHolder1 + scrollCounter2));
                    drumsHolderText1.setText(drumholderArr.get(musicHolder2 + scrollCounter2));
                    drumsHolderText1.setText(drumholderArr.get(musicHolder3 + scrollCounter2));
                    drumsHolderText1.setText(drumholderArr.get(musicHolder4 + scrollCounter2));
                    drumsHolderText1.setText(drumholderArr.get(musicHolder5 + scrollCounter2));
                    drumsHolderText1.setText(drumholderArr.get(musicHolder6 + scrollCounter2));
                    drumsHolderText1.setText(drumholderArr.get(musicHolder7 + scrollCounter2));
                    drumsHolderText1.setText(drumholderArr.get(musicHolder8 + scrollCounter2));
                    drumsHolderText1.setText(drumholderArr.get(musicHolder9 + scrollCounter2));
                    drumsHolderText1.setText(drumholderArr.get(musicHolder10 + scrollCounter2));
                }

            });

            //buy button

            musicButton4.setOnMouseClicked(event->
            {
                if(totalSupply>50)
                {
                    rarity="COMMON";
                    raritycontentsText.setText(rarity);
                    totalsupplycontentsText.setText(totalSupply+"");
                    floorpricecontentsText.setText(floorPrice/Integer.MAX_VALUE*Integer.MAX_VALUE+"ETH");
                }
                if(totalSupply<50 && totalSupply>25)
                {
                    rarity="UNCOMMON";
                    raritycontentsText.setText(rarity);
                    totalsupplycontentsText.setText(totalSupply+"");
                    floorpricecontentsText.setText(floorPrice/Integer.MAX_VALUE*Integer.MAX_VALUE+"ETH");

                }
                if(totalSupply<25 && totalSupply>10)
                {
                    rarity="RARE";
                    raritycontentsText.setText(rarity);
                    totalsupplycontentsText.setText(totalSupply+"");
                    floorpricecontentsText.setText(floorPrice/Integer.MAX_VALUE*Integer.MAX_VALUE+"ETH");

                }
                if(totalSupply<10)
                {
                    rarity="SUPERSTAR";
                    raritycontentsText.setText(rarity);
                    totalsupplycontentsText.setText(totalSupply+"");
                    floorpricecontentsText.setText(floorPrice/Integer.MAX_VALUE*Integer.MAX_VALUE+"ETH");

                }
                if(totalSupply>0)
                {
                    totalSupply--;
                    floorPrice*=1.05;
                    raritycontentsText.setText(rarity);
                    totalsupplycontentsText.setText(totalSupply+"");
                    floorpricecontentsText.setText(floorPrice/Integer.MAX_VALUE*Integer.MAX_VALUE+"ETH");
                }
            });

            //sell button

            musicButton5.setOnMouseClicked(event->
            {
                if(totalSupply>50)
                {
                    rarity="COMMON";
                    raritycontentsText.setText(rarity);
                    totalsupplycontentsText.setText(totalSupply+"");
                    floorpricecontentsText.setText(floorPrice/Integer.MAX_VALUE*Integer.MAX_VALUE+"ETH");

                }
                if(totalSupply<50 && totalSupply>25)
                {
                    rarity="UNCOMMON";
                    raritycontentsText.setText(rarity);
                    totalsupplycontentsText.setText(totalSupply+"");
                    floorpricecontentsText.setText(floorPrice/Integer.MAX_VALUE*Integer.MAX_VALUE+"ETH");

                }
                if(totalSupply<25 && totalSupply>10)
                {
                    rarity="RARE";
                    raritycontentsText.setText(rarity);
                    totalsupplycontentsText.setText(totalSupply+"");
                    floorpricecontentsText.setText(floorPrice/Integer.MAX_VALUE*Integer.MAX_VALUE+"ETH");

                }
                if(totalSupply<10)
                {
                    rarity="SUPERSTAR";
                    raritycontentsText.setText(rarity);
                    totalsupplycontentsText.setText(totalSupply+"");
                    floorpricecontentsText.setText(floorPrice/Integer.MAX_VALUE*Integer.MAX_VALUE+"ETH");

                }
                if(totalSupply<100)
                {
                    totalSupply++;
                    floorPrice/=1.05;
                    raritycontentsText.setText(rarity);
                    totalsupplycontentsText.setText(totalSupply+"");
                    floorpricecontentsText.setText(floorPrice/Integer.MAX_VALUE*Integer.MAX_VALUE+"ETH");

                }
            });











            albumPreview.setOnMouseClicked(event-> {
                if(isPlaying)
                {
                    //makes everything stop playing
                    pianoTrackThread.interrupt();
                    guitarTrackThread.interrupt();
                    drumTrackThread.interrupt();
                    isPlaying = false;
                }
                else
                {
                    //makes everything start playing
                    pianoTrackThread.start();
                    guitarTrackThread.start();
                    drumTrackThread.start();
                    isPlaying = true;
                }

            });

            screen1.setOnMouseClicked(event->
                    {
                        try {
                            if (activeClip != null) {
                                activeClip.stop();
                            }
                            activeClip = new Audio("PRE_OMG-NewJeans.wav");
                            activeClip.play();
                        } catch (Exception E) {
                            System.out.println("ERROR: Audio");
                        }
                    }
            );

            screen5.setOnMouseClicked(event->
                    {
                        try {
                            if (activeClip != null) {
                                activeClip.stop();
                            }
                            activeClip = new Audio("PRE_Still_With_You-Jungkook.wav");
                            activeClip.play();
                        } catch (Exception E) {
                            System.out.println("ERROR: Audio");
                        }
                    }
            );

            screen6.setOnMouseClicked(event->
                    {
                        try {
                            if (activeClip != null) {
                                activeClip.stop();
                            }
                            activeClip = new Audio("PRE_Cupid-FIFTY_FIFTY.wav");
                            activeClip.play();
                        } catch (Exception E) {
                            System.out.println("ERROR: Audio");
                        }
                    }
            );







        }
    }


    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
        //MAIN STUFF
        launch(args);
        int[]arr={0,1,2,3,4,5,6,7,8,9,10,11};
        Algorithms.mergeSort(arr);
        Algorithms.recursiveBinarySearch(arr,1,2,3);






    }

    //stage properties go here
    @Override
    public void start(Stage primaryStage) throws Exception {

        final Rotate xRotate = new Rotate(-90, Rotate.X_AXIS);
        final Rotate yRotate = new Rotate(0, Rotate.Y_AXIS);
        final Rotate zRotate = new Rotate(0, Rotate.Z_AXIS);

        Robot r = new Robot();





        RotateCamera rotateCamera = new RotateCamera();


        //light
//        PointLight pointLight = new PointLight();
//        pointLight.getTransforms().add(new Translate(0,0,0));
//        rotateCamera.getTransforms().setAll(pointLight.getTransforms());

        //image
        Image soliImage = new Image(new FileInputStream("C:\\Users\\Dtang\\CS Projects\\zer0\\soli.png"));
        ImageView imageView = new ImageView(soliImage);
        Group imageRoot = new Group(imageView);
        imageView.setFocusTraversable(true);

        //background Image
        Image spaceBackgroundImage = new Image(new FileInputStream("C:\\Users\\Dtang\\CS Projects\\zer0\\spaceBackground.webp"));
        ImageView spaceBackgroundImageView = new ImageView(spaceBackgroundImage);
        Group spaceBackgroundImageRoot = new Group(spaceBackgroundImageView);
        spaceBackgroundImageView.setFocusTraversable(true);
        spaceBackgroundImageView.getTransforms().add(new Translate(-spaceBackgroundImage.getWidth()/2,-spaceBackgroundImage.getHeight(),800));


        //weird group thing used to take group elements and add them
        Group root= new Group();
        Group game1Group = new Group();
        game1Group.getChildren().addAll(rotateCamera,imageRoot,spaceBackgroundImageRoot);
        root.getChildren().add(game1Group);




        Scene scene = new Scene(root,SCENE_WIDTH, SCENE_HEIGHT,true, SceneAntialiasing.BALANCED);
        scene.setFill(Color.BLACK);

        //stage holds scene
        primaryStage.setFullScreen(true);
        scene.setCamera(rotateCamera.camera);
        primaryStage.setScene(scene);
        scene.getCursor();
        scene.setCursor(Cursor.CROSSHAIR);
        primaryStage.show();








        //rotating options
        scene.setOnKeyPressed((KeyEvent e) -> {
            System.out.println(rotateCamera.getTranslateY());
            KeyCode code = e.getCode();
            switch (code) {
                case W:
                    rotateCamera.translateZProperty().set(rotateCamera.getTranslateZ() + 10);
                    break;
                case S:
                    rotateCamera.translateZProperty().set(rotateCamera.getTranslateZ() - 10);
                    break;
                case A:
                    rotateCamera.translateXProperty().set(rotateCamera.getTranslateX() + 10);
                    break;
                case D:
                    rotateCamera.translateXProperty().set(rotateCamera.getTranslateX() - 10);
                    break;
                case LEFT:
                    rotateCamera.yRotate.setAngle(rotateCamera.yRotate.getAngle() - 10);
                    break;
                case RIGHT:
                    rotateCamera.yRotate.setAngle(rotateCamera.yRotate.getAngle() + 10);
                    break;
                case UP:
                    rotateCamera.xRotate.setAngle(rotateCamera.xRotate.getAngle() + 10);
                    break;
                case DOWN:
                    rotateCamera.xRotate.setAngle(rotateCamera.xRotate.getAngle() - 10);
                    break;
                case Q:
                    rotateCamera.xRotate.setAngle(-90);
                    rotateCamera.yRotate.setAngle(0);
                    rotateCamera.zRotate.setAngle(0);
                    rotateCamera.setTranslateX(0);
                    rotateCamera.setTranslateY(0);
                    rotateCamera.setTranslateZ(0);
                    break;
                case R:
                    r.mouseMove(800,400);
                    break;
                case M:
                    try
                    {
                        activeClip.stop();
                    }
                    catch(Exception M)
                    {
                        System.out.println("Muting Error");
                    }

                    break;
            }
        });

    }
    public static int getMaxSize()
    {
        return maxSize;
    }
    public static void setMaxSize(int x)
    {
        maxSize = x;
    }



}
