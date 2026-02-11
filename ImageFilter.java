import org.code.theater.*;
import org.code.media.*;

public class ImageFilter extends ImagePlus{


  
  public ImageFilter(String filename){
    
    super(filename);
    
  }

  public void makeNegative() {

Pixel[][] pixels = getImagePixels();
    
for(int row = 0; row < pixels.length; row++){
    for(int col = 0; col < pixels[0].length; col++){
    Pixel current = pixels[row][col];
        current.setRed(255 - current.getRed());
        current.setGreen(255 - current.getGreen());
        current.setBlue(255 - current.getBlue());
        }
      }
    
  }

  public void colorShift(int value) {
    
Pixel[][] pixels = getImagePixels();
    
for(int row = 0; row < pixels.length; row++){
    for(int col = 0; col < pixels[0].length; col++){
      Pixel current = pixels[row][col];
          current.setRed(current.getRed() + value);
            current.setGreen(current.getGreen() + value);
          current.setBlue(current.getBlue() + value);

        if(current.getRed() > 255){
          current.setRed(255);
        }
        if(current.getGreen() > 255){
          current.setGreen(255);
        }
        if(current.getBlue() > 255){
        current.setBlue(255);
      }
      }
    }

    
  }


public void adjustContrast(int multiplier) {
    Pixel[][] pixels = getImagePixels();
    
for(int row = 0; row < pixels.length; row++){
    for(int col = 0; col < pixels[0].length; col++){
      Pixel current = pixels[row][col];
          current.setRed(current.getRed() * multiplier);
            current.setGreen(current.getGreen() * multiplier);
          current.setBlue(current.getBlue() * multiplier);

        if(current.getRed() > 255){
          current.setRed(255);
        }
        if(current.getGreen() > 255){
          current.setGreen(255);
        }
        if(current.getBlue() > 255){
        current.setBlue(255);
      }
      }
    }

    
  }


public void saturate(int factor) {

Pixel[][] pixels = getImagePixels();
    
for(int row = 0; row < pixels.length; row++){
    for(int col = 0; col < pixels[0].length; col++){
      Pixel current = pixels[row][col];
      int avg = (current.getRed() + current.getGreen() + current.getBlue()) / 3;
      int grayScale = avg + (avg - 255) * factor;
          current.setRed(2 * grayScale - current.getRed());
          current.setGreen(2 * grayScale - current.getGreen());
          current.setBlue(2 * grayScale - current.getBlue());
      }
    }

    
  }


public void threshold(int value) {

Pixel[][] pixels = getImagePixels();
    
for(int row = 0; row < pixels.length; row++){
    for(int col = 0; col < pixels[0].length; col++){
      Pixel current = pixels[row][col];
      int avg = (current.getRed() + current.getGreen() + current.getBlue()) / 3;
          if(avg < value){
        current.setColor(Color.BLACK);
          }else{
        current.setColor(Color.WHITE);
          }
      }
    }
  }

  public void applyBlur() {
    Pixel[][] pixels = getImagePixels();
    
    for(int row = 1; row < pixels.length - 1; row++){
        for(int col = 1; col < pixels[0].length - 1; col++){
          
           Pixel current = pixels[row][col];
          
            current.setRed(calcWeightedRed(pixels, row, col));
            current.setGreen(calcWeightedGreen(pixels, row, col));
            current.setBlue(calcWeightedBlue(pixels, row, col));
          
        }
    }
}
  
public int calcWeightedRed(Pixel[][] pixels, int row, int col) {
    int avgRed = (pixels[row-1][col-1].getRed() + pixels[row-1][col].getRed() + pixels[row-1][col+1].getRed() +
                    pixels[row][col-1].getRed() + pixels[row][col].getRed() + pixels[row][col+1].getRed() +
                    pixels[row+1][col-1].getRed() + pixels[row+1][col].getRed() + pixels[row+1][col+1].getRed()) / 9;
    return avgRed;
  }

  /*
   * Returns a weighted green average of the pixels around the specified row and col 
   */
  public int calcWeightedGreen(Pixel[][] pixels, int row, int col) {
    int avgGreen = (pixels[row-1][col-1].getGreen() + pixels[row-1][col].getGreen() + pixels[row-1][col+1].getGreen() +
                    pixels[row][col-1].getGreen() + pixels[row][col].getGreen() + pixels[row][col+1].getGreen() +
                    pixels[row+1][col-1].getGreen() + pixels[row+1][col].getGreen() + pixels[row+1][col+1].getGreen()) / 9;
    return avgGreen;
  }

  /*
   * Returns a weighted blue average of the pixels around the specified row and col
   */
  public int calcWeightedBlue(Pixel[][] pixels, int row, int col) {
    int avgBlue = (pixels[row-1][col-1].getBlue() + pixels[row-1][col].getBlue() + pixels[row-1][col+1].getBlue() +
                   pixels[row][col-1].getBlue() + pixels[row][col].getBlue() + pixels[row][col+1].getBlue() +
                   pixels[row+1][col-1].getBlue() + pixels[row+1][col].getBlue() + pixels[row+1][col+1].getBlue()) / 9;
    return avgBlue;
  }


public void filter(){
      Pixel[][] pixels = getImagePixels();
    
    for(int row = 0; row < pixels.length; row++){
        for(int col = 0; col < pixels[0].length; col++){
          Pixel current = pixels[row][col];

          int newRed = (int)(Math.random() * 255) + 0;
          int newGreen = (int)(Math.random() * 255) + 0;
          int newBlue = (int)(Math.random() * 255) + 0;

          current.setRed(newRed);
          current.setGreen(newGreen);
          current.setBlue(newBlue);
          
        }
      }
    }

    public void keepColor(String color){
    Pixel[][] pix = getImagePixels();

  for(int row = 0; row < pix.length; row++){
    for(int col = 0; col < pix[0].length; col++){
      Pixel current = pix[row][col];
        if (color == "red") {
                current.setGreen(0);
                current.setBlue(0);
            } 
            else if (color == "green") {
                current.setRed(0);
                current.setBlue(0);
            } 
            else if (color == "blue") {
                current.setRed(0);
                current.setGreen(0);
            }
    }
  }
  }
  
  
  
}