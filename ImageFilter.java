import org.code.theater.*;
import org.code.media.*;

public class ImageFilter extends ImagePlus {

  public ImageFilter(String filename) {
    super(filename);
  }

  /*
  * Adjusts the contrast of an image with a parameter based on how intense the filter is. 
  It adjusts the contrast with a multiplier
  */
  public void adjustContrast(int multiplier) {
    Pixel[][] pixels = getPixelsFromImage();
    
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        Pixel currentPixel = pixels[row][col];

        int currentRed = currentPixel.getRed();
        int currentGreen = currentPixel.getGreen();
        int currentBlue = currentPixel.getBlue();

         int newRed = (multiplier * currentRed);
        int newGreen = (multiplier * currentGreen);
        int newBlue = (multiplier * currentBlue);

        if (newRed > 255) {
          newRed = 255;
        }

      if (newGreen > 255) {
        newGreen = 255;
      }

        if (newBlue > 255) {
          newBlue = 255;
        }
        currentPixel.setRed(newRed);
        currentPixel.setGreen(newGreen);
        currentPixel.setBlue(newBlue);
  }
    }
  }
    /*
    *Applies a gaussian blur to the image
    */
  public void applyBlur() {
    
      Pixel[][] pixels = getPixelsFromImage();

    for (int row = 1; row < pixels.length - 1; row++) { 
      for (int col = 1; col < pixels[0].length - 1; col++) {
        Pixel currentPixel = pixels[row][col];

        int newRed = calcWeightedRed(pixels, row, col);
        int newGreen = calcWeightedGreen(pixels, row, col);
        int newBlue = calcWeightedBlue(pixels, row, col);

        /*
        *keep color values to a maximum of 255
        */
        if (newRed > 255) {
          newRed = 255;
        }
        if (newGreen > 255) {
          newGreen = 255;
        }
        if (newBlue > 255) {
          newBlue = 255;
        }

        currentPixel.setRed(newRed);
        currentPixel.setGreen(newGreen);
        currentPixel.setBlue(newBlue);
      }
    }
  }

  /*
   * Returns a weighted red average of the pixels around the specified row and col
   */
  public int calcWeightedRed(Pixel[][] pixels, int row, int col) {
    int avgRed = (pixels[row - 1][col - 1].getRed() + pixels[row - 1][col].getRed() + pixels[row - 1][col + 1].getRed() +
                  pixels[row][col - 1].getRed() + pixels[row][col].getRed() + pixels[row][col + 1].getRed() +
                  pixels[row + 1][col - 1].getRed() + pixels[row + 1][col].getRed() + pixels[row + 1][col + 1].getRed()) / 9;
    return avgRed;
  }

  /*
   * Returns a weighted green average of the pixels around the specified row and col 
   */
  public int calcWeightedGreen(Pixel[][] pixels, int row, int col) {
    int avgGreen = (pixels[row - 1][col - 1].getGreen() + pixels[row - 1][col].getGreen() + pixels[row - 1][col + 1].getGreen() +
                    pixels[row][col - 1].getGreen() + pixels[row][col].getGreen() + pixels[row][col + 1].getGreen() +
                    pixels[row + 1][col - 1].getGreen() + pixels[row + 1][col].getGreen() + pixels[row + 1][col + 1].getGreen()) / 9;
    return avgGreen;
  }

  /*
   * Returns a weighted blue average of the pixels around the specified row and col
   */
  public int calcWeightedBlue(Pixel[][] pixels, int row, int col) {
    int avgBlue = (pixels[row - 1][col - 1].getBlue() + pixels[row - 1][col].getBlue() + pixels[row - 1][col + 1].getBlue() +
                   pixels[row][col - 1].getBlue() + pixels[row][col].getBlue() + pixels[row][col + 1].getBlue() +
                   pixels[row + 1][col - 1].getBlue() + pixels[row + 1][col].getBlue() + pixels[row + 1][col + 1].getBlue()) / 9;
    return avgBlue;
  }

 /*
  * Applies a gray scale to the image by averaging the red, green, and blue values of each pixel
  */
  public void applyGray() {
    Pixel[][] pixels = getPixelsFromImage();
    
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        Pixel currentPixel = pixels[row][col];

        int avg = (currentPixel.getRed() + currentPixel.getGreen() + currentPixel.getBlue()) / 3;
        
        currentPixel.setRed(avg);
        currentPixel.setGreen(avg);
        currentPixel.setBlue(avg);
      }
    }
  }
}