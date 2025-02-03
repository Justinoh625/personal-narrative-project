import org.code.theater.*;
import org.code.media.*;

public class MyStory extends Scene {

  /*
  * Instance Variables
  */
  private String[] homeScreenText;
  private String[][] playerName;
  private String[][] nicknames;
  private ImageFilter[][] images;
  private ImageFilter[] logo;
  
  /*
  * Constructor
  */
  public MyStory(String[] homeScreenText, ImageFilter[] logo, String[][] playerName, String[][] nicknames, ImageFilter[][] images) {
    this.homeScreenText = homeScreenText;
    this.logo = logo;
    this.playerName = playerName;
    this.nicknames = nicknames;
    this.images = images;
  }

  /*
  * Draws the scene by drawing the home screen first and then drawing the player scene and adding filters, also plays a ding sound in between each player
  */
   public void drawScene() {
    drawHomeScreen();
    playSound("Ding-Sound-Effect.wav");
    pause(4);
    for (int row = 0; row < playerName.length; row++) {
      for (int col = 0; col < playerName[row].length; col++) {
        drawPlayerScene(row, col);
        applyFilters(images[row][col], 50, 105, 300);
        playSound("Ding-Sound-Effect.wav");
        pause(2.5);
      }
    }
  }

  /*
  * Applies the filters back to back on each image after 0.5 seconds
  */
  public void applyFilters(ImageFilter image, int x, int y, int size) {
    pause(0.5);
    image.adjustContrast(2);
    drawImage(image, x, y, size);
    pause(0.5);
    image.applyBlur();
    drawImage(image, x, y, size);
    pause(0.5);
    image.applyGray();
    drawImage(image, x, y, size);
  }

  /*
  * Draws the home screen with a gold background and blue text with the warriors logo
  */
  public void drawHomeScreen() {
    clear("gold");
    setTextColor("blue");
    setTextStyle(Font.SANS, FontStyle.BOLD);
    drawText(homeScreenText[0], 35, 70);
    drawImage(logo[0], 85, 100, 235);
  }

  /*
  * Method to draw all of the players as well as their name and nickname
  */
  public void drawPlayerScene(int row, int col) {
    String[] colors = {"turquoise", "silver", "tan", "aqua"};
    clear(colors[(row * 2 + col) % colors.length]);
    setTextColor("black");
    setTextStyle(Font.SANS, FontStyle.BOLD);
    setTextHeight(45);
    drawText(playerName[row][col], 60, 75);
    drawImage(images[row][col], 50, 105, 300);
    setTextColor("red");
    setTextStyle(Font.SANS, FontStyle.ITALIC);
    setTextHeight(30);
    drawText(nicknames[row][col], 110, 350);
  }
}