// --== CS400 Project Two File Header ==--
// Name: Rahil Kapur
// Email: rkapur3@wisc.edu
// Team: Red
// Group: AE
// TA: Ilay Raz
// Lecturer: Gary Dahl
// Notes to Grader:
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
 * This class essentially loads the data from a csv file into a list containing all the data needed
 * to use the red black tree.
 */
public class loadData implements characterLoaderInterface {

  /*
   * This method essentially converts the path to a file to a file where we read the contents using
   * a scanner and store it in a list. Then we sort the data in a 2D array, based on if the string
   * in the list is a character, anime, or power level. Then finally we get all of the data from the
   * array and create character nodes and put those nodes inside a final list containing all the
   * characters.
   * 
   * @param path the path to the csv file we're getting the data from.
   * 
   * @throws FileNotFoundException if the path is null, empty, or if the file doesn't exist.
   */
  @Override
  public List<CharacterInterface> getFile(String path) throws FileNotFoundException {

    if (path == null || path.equals("")) { // If the path is null or empty we throw the exception.
      throw new FileNotFoundException();
    }

    File animeFile = new File(path);
    if (animeFile.exists() == false) { // If the file does not exist we throw the exception.
      throw new FileNotFoundException();
    }
    Scanner scnr = new Scanner(animeFile);
    ArrayList<String> animeList = new ArrayList<String>();

    while (scnr.hasNextLine()) { // This loop essentially copies all of the data from the file to an
                                 // Arraylist.
      String l = scnr.nextLine();
      String[] values = l.split(","); // First we store each line from the file in an array by
                                      // splitting it by commas.
      for (int i = 0; i < values.length; i++) { // Then we copy each value into the list itself and
                                                // repeat for every line in the file
        animeList.add(values[i]);
      }
    }
    scnr.close();



    String[][] arr = new String[animeList.size() - 1][3]; // There will be 3 columns in the csv file
    // because the file will only contain the
    // names of the characters, the anime they're
    // from, and their power level.



    int characterCounter = 0; // These ints are used to keep track of the number of characters,
                              // animes, powers, added to the 2d array to make sure we don't get any
                              // null values inside the array.
    int animeCounter = 0;
    int powerCounter = 0;

    boolean isAnime = false; // These booleans are used to add inside the 2d array.
    boolean isPower = false;
    for (int a = 0; a < animeList.size(); a++) { // This loop essentially sorts the data into the 2d
                                                 // array correctly based on if it is a
                                                 // characterName, animeName, or powerLevel.
      if ((a == 0) || (a == 1) || (a == 2)) { // The first three entries will be the header so we
                                              // simply skip those.
        continue;
      } else if (a % 3 == 0) { // All characters are stored in the first column which will always be
                               // divisible by 3.
        // System.out.println(animeList.get(a));
        arr[characterCounter][0] = animeList.get(a); // Here we store all of the character names
        ++characterCounter;
        isAnime = true; // After the character name, the following value will always be the name of
                        // the anime, so we set this to true.
      } else if (isAnime == true) {
        arr[animeCounter][1] = animeList.get(a);
        ++animeCounter;
        isAnime = false; // We set the isAnime variable to false since we have just added the anime
                         // and the isPower to true since the following value will always be the
                         // power.
        isPower = true;
      } else if (isPower == true) {
        arr[powerCounter][2] = animeList.get(a);
        ++powerCounter;
        isPower = false; // We set isPower to false since we have just added it.
      }
    }


    ArrayList<CharacterInterface> completeList = new ArrayList<CharacterInterface>();


    for (int r = 0; r < arr.length; r++) { // Finally we add all the values into a list containing
                                           // all character nodes by creating the nodes then adding
                                           // them to the list.
      if (arr[r][2] == null) { // If we reach a point where we are getting null values, we escape
                               // since we have gone through all the values.
        break;
      }
      int power = Integer.parseInt(arr[r][2]);
      characterNode character = new characterNode(arr[r][1], arr[r][0], power); // Here we create
                                                                                // characters using
                                                                                // values from the
                                                                                // 2d array then add
                                                                                // them to the list.
      completeList.add(character);
    }


    return completeList; // Finally we return the list.
  }

  public static void main(String[] args) throws FileNotFoundException {
    loadData anime = new loadData();
    ArrayList<CharacterInterface> completeList =
        (ArrayList<CharacterInterface>) anime.getFile("finalanimeCharacter.csv");
    System.out.print(completeList.get(0).getName());

  }

}
