import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {

    /*
    * Title of the Program
    */
    String[] title = {"2017 Prime Warriors BEST Players"};
    
    
    /*
    * 2D Array of the names of the players
    */
    String[][] players = {
      {"Steph Curry", "Klay Thompson"},
      {"Kevin Durant", "Draymond G"}
    };

    /*
    * 2D Array of the nicknames of the players
    */
    String[][] playerNicknames = {
      {"The Chef", "The Sharpshooter"},
      {"Slim Reaper", "Defensive Demon"}
    };

    /*
    * The images of each of the players
    */
    ImageFilter[][] imagePlayers = {
      { new ImageFilter("StephCurry.jpg"), new ImageFilter("KlayThompson.jpg") },
      { new ImageFilter("KevinDurant.jpg"), new ImageFilter("DraymondGreen.jpg") },
    };


    /*
    * Logo of the GS Warriors
    */
    ImageFilter[] warriorsLogo = { new ImageFilter("GoldenStateWarriorslogo.png")};


    /*
    * Creates a new MyStory object with parameters of the title, logo, players and their names and nicknames
    */
    MyStory scene = new MyStory(title, warriorsLogo, players, playerNicknames, imagePlayers);

    
   /*
    * Draws the scene
    */
    scene.drawScene();
    

    /*
    * Plays the scene through the theater
    */
    Theater.playScenes(scene);
  }
}