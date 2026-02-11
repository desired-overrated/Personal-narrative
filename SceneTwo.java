import org.code.theater.*;
import org.code.media.*;

public class SceneTwo extends Scene {

  /** Instance Variables */
  private String volleyball;
  private ImageFilter[][] images;

  
  /** Constructor */
  public SceneTwo(String volleyball, ImageFilter[][] images) {
      this.volleyball = volleyball;
    this.images = images;
  }
  /*
  information to display in the first scen of the secne2
  */

public String[][] setUpData2(){
  String[][] hobby = {
    {"My hobbies include: "},
    {"volleyball,"},
    {"traveling,"},
    {"and hanging out!"},
  };
  return hobby;
}
  

  /**
   * Top-level drawScene method which will draw the whole animation
   */
  public void drawScene() {
    clear("white");
    font();
    drawText("My Interests!",140, 50);
    drawImage(volleyball, 110, 40, 200, 0);
    pause(1);
    font2();
    String[][] info2 = setUpData2();
    drawText(introText(info2), 20, 240);
    pause(3);
    clear("white");
    drawImagesVolley();
    drawImagesFriends();
    drawImagesTravel();
    pause(1);
    clear("pink");
    font();
    drawText("The End!",140, 200);
  }

  /*
  chnages the font for the text in the begining of SceneTwo and end of SceneTwo
  */

  public void font(){
    setTextStyle(Font.SERIF, FontStyle.BOLD);
    setTextColor("black");
    int fontSize = 25;
    setTextHeight(fontSize);
  }

  public void font2(){
    setTextStyle(Font.SERIF, FontStyle.BOLD);
    setTextColor("black");
    int fontSize = 15;
    setTextHeight(fontSize);
  }

  /*
  goes through the intro 2D array and displays the text
  */

  public String introText(String[][] intro){
String text = "";
  //iterates through each element of the 2D array
    for(int r = 0; r < intro.length; r++){
      for(int c = 0; c < intro[0].length; c++){
        text += intro[r][c];
      }
    }
    return text;
  }

/*
  goes throuhg row 0 of the images 2D array and draws them with a blue filter
  */
  
  public void drawImagesVolley() {
    for (ImageFilter img : images[0]) {
      /*
      checks if the selected column is null, if not, then it will draw it
        */
      if (img != null) {
        drawImage(img, 50, 50, 300, 300, 0);
        pause(1);
        img.keepColor("blue");
        
        drawImage(img, 50, 50, 300, 300, 0);
        pause(1);
        clear("white");
      } 
    }
  }

  /*
  draws row 1 of images 2D and applies a blur filter
  */

  public void drawImagesFriends() {
    for (ImageFilter img : images[1]) {
      /*
      checks if the selected column is null, if not, then it will draw it
        */
      if (img != null) {
        drawImage(img, 50, 50, 300, 300, 0);
        pause(1);
        img.applyBlur();
        
        drawImage(img, 50, 50, 300, 300, 0);
        pause(1);
        clear("white");
      } 
    }
  }

  /*
  traverse and draws row 2 of the images 2D and applies a contrast filter
  */

  public void drawImagesTravel() {
    for (ImageFilter img : images[2]) {

      /*
      checks if the selected column is null, if not, then it will draw it
        */
      if (img != null) {
        drawImage(img, 50, 50, 300, 300, 0);
        pause(1);
        img.adjustContrast(2);
        
        drawImage(img, 50, 50, 300, 300, 0);
        pause(1);
        clear("white");
      } 
    }
    drawImage("travel2.jpg", 50, 50, 300, 300, 0);
     pause(1);
  clear("white");
  }
  
  
}