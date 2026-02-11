import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {

    // Create any 2D arrays & variables to be passed as parameters to constructor
    ImageFilter hanbok = new ImageFilter("hanbok.jpg");
    ImageFilter fam2 = new ImageFilter("fam2.jpg");
    ImageFilter fam3 = new ImageFilter("fam3.jpg");
    
    ImageFilter[][] images = {
      {new ImageFilter("volleyball1.png.jpg"),new ImageFilter("volleyball2.JPEG"), null},
      {new ImageFilter("friends1.jpg"),new ImageFilter("friends2.jpg"),new ImageFilter("friends4.JPG")},
      {new ImageFilter("travel1.jpg"),new ImageFilter("travel3.jpg"), null},
    };

  
    // Instantiate Scene subclass objects
    SceneOne scene1 = new SceneOne(hanbok,fam2,fam3,"flagg.png");
    SceneTwo scene2 = new SceneTwo("volleyball.png", images);
    
    // Call drawScene methods in each subclass
    scene1.drawScene();
    scene2.drawScene();
    
    // Play scenes in Theater, in order of arguments
    Theater.playScenes(scene1, scene2);
    
  }
}