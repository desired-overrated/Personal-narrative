import org.code.theater.*;
import org.code.media.*;

public class SceneOne extends Scene {

  /** 
  Instance Variables 
  */
  private String koreanImage;
  private ImageFilter hanbok;
  private ImageFilter fam2;
  private ImageFilter fam3;
  private String soundFile;

  
  /**
  Constructor 
  */
  public SceneOne(ImageFilter hanbok, ImageFilter fam2, ImageFilter fam3, String koreanImage, String soundFile) {
    this.hanbok = hanbok;
    this.fam2 = fam2;
    this.fam3 = fam3;
    this.koreanImage = koreanImage;
    this.soundFile = soundFile;
  }

  

  /*
  creates the 2D array to be used int the frist screen
  */
public String[][] setUpData(){
  String[][] intro = {
    {"Hello!", "I'm Korean!"},
    {"I love being korean! ", null},
  };
  return intro;
}

  /**
   * Top-level drawScene method which will draw the whole animation
   */
  public void drawScene() {
    clear("white");
    font();
    drawText("My Personal Narrative", 85, 50);
    pause(1);
    drawImage(koreanImage, 65, 60, 270, 0);
    pause(1);
    playSound(soundFile);
    //sets the 2D array into one used to draw the text
    String[][] info = setUpData();
    drawText(introText(info), 15, 270);
    pause(1);
    drawText("Let's see photos of my family!!" , 55, 310);
    pause(2);
    clear("white");
    //draws the images with filters
    drawImages1();
  }

  /* 
  sets the text size, bold, and color
  */
  public void font(){
    setTextStyle(Font.SERIF, FontStyle.BOLD);
    setTextColor("black");
    int fontSize = 23;
    setTextHeight(fontSize);
  }

  /* 
  goes through the intro 2D array and adds each element to the text varibale to be drawn
  */
  public String introText(String[][] intro){
String text = "";
  //iterates through each element of the 2D array
    for(int r = 0; r < intro.length; r++){
      for(int c = 0; c < intro[0].length; c++){
        //return all the elements of the 2D array intro
        text += intro[r][c];
      }
    }
    return text;
  }


  /*
  draws all the images corresponding to family
  */
    public void drawImages1(){
      //first image
      drawImage(hanbok, 350, 10, 400, 90);
      pause(1);
      //applies blur filter
      hanbok.applyBlur();
      drawImage(hanbok, 350, 10, 400, 90);
      pause(1);
      clear("white");
      //second image
      drawImage("fam1.jpg", 50, 30, 300, 0);
      pause(1);
      clear("white");
      //third image
      drawImage(fam2, 60, 10, 300, 0);
      pause(1);
      //shifts the pixels
      fam2.colorShift(100);
      drawImage(fam2, 60, 10, 300, 0);
      pause(1);
      clear("white");
      //fourth image
      drawImage(fam3, 60, 10, 300, 0);
      pause(1);
      //randomizes the colors of the pixels
      fam3.filter();
      drawImage(fam3, 60, 10, 300, 0);
      pause(1);
    }


  
  
}