// --== CS400 Project Two File Header ==--
// Name: Rahil Kapur
// Email: rkapur3@wisc.edu
// Team: Red
// Group: AE
// TA: Ilay Raz
// Lecturer: Gary Dahl
// Notes to Grader:
import java.lang.invoke.MethodHandles;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;


/*
 * This class makes sure that the data wrangler code works correctly.
 */
public class dataWranglerTests {

  /*
   * This test simply makes sure that when an invalid file path is passed in a fileNotFound
   * exception is thrown. It makes sure when the path does not exist or is null then the
   * fileNotFound exception is thrown.
   * 
   * @author Rahil Kapur
   */
  @Test
  public void dataWrangler_testFileNotFound() {
    loadData data = new loadData();
    String invalidPath = "NOT VALID"; // This is the path we will use which is invalid.
    boolean ifThrown = false;
    try {
      data.getFile(invalidPath);
    } catch (FileNotFoundException e) { // If the excpetion is thrown and caught, then the code is
                                        // working correctly and being thrown correctly so we set
                                        // ifThrown to true.
      ifThrown = true;
    }
    assertEquals(true, ifThrown); // we make sure assertEquals returns true since a fileNotFound
                                  // should be thrown.
    ifThrown = false;
    invalidPath = null; // we set the path to be null so an exception should be thrown.
    try {
      data.getFile(invalidPath);
    } catch (FileNotFoundException e) { // again, if thrown and caught we set ifThrown to true since
                                        // fileNotFound was thrown correctly.s
      ifThrown = true;
    }
    assertEquals(true, ifThrown); // Again we test making sure that the exception was thrown.
  }

  /*
   * This method ensures that the loadData method return the correct list where the characters are
   * all in order and we use the finalanimeCharacter.csv as the path for this test, testing the
   * characters in the file in the order they're suppsoed to be and make sure that the actual
   * matches with the expected.
   * 
   * @author Rahil Kapur
   */
  @Test
  public void dataWrangler_testCorrectCharacters() throws FileNotFoundException {
    loadData data = new loadData();
    ArrayList<CharacterInterface> list =
        (ArrayList<CharacterInterface>) data.getFile("finalanimeCharacter.csv");
    characterNode actual = (characterNode) list.get(0);
    characterNode expected = new characterNode("One Punch Man", "Blast", 901); // this is the
                                                                               // expected because
                                                                               // at index 0, this
                                                                               // is the first entry
                                                                               // in the
                                                                               // finalanimeCharacter.csv
                                                                               // so it should match
                                                                               // with this.
    assertEquals(true, actual.getName().equals(expected.getName())); // We make sure that the
                                                                     // expected name matches with
                                                                     // the actual if not, then
                                                                     // assertEquals fails.
    actual = (characterNode) list.get(10);
    expected = new characterNode("One Punch Man", "Saitama", 1000);
    assertEquals(true, actual.getName().equals(expected.getName())); // Again we make sure that the
                                                                     // name of the expected matches
                                                                     // with the actual name.
    actual = (characterNode) list.get(16);
    expected = new characterNode("My Hero Academia", "Edgeshot", 510);
    assertEquals(true, actual.getName().equals(expected.getName())); // We do the same thing here,
                                                                     // except going farther down
                                                                     // the file to make sure it
                                                                     // still works as we go down
                                                                     // the csv file a bit further.
    actual = (characterNode) list.get(22);
    expected = new characterNode("Demon Slayer: Kimetsu no YaibaÊ", "Kyojuro Rengoku", 860);
    assertEquals(true, actual.getName().equals(expected.getName())); // This does the same thing
                                                                     // making sure that the name of
                                                                     // the expected matches the
                                                                     // actual.
  }

  /*
   * This test is similar to the last one, but also tests the anime name to make sure that the
   * actual anime output matches with the expected.
   * 
   * @author Rahil Kapur
   */
  @Test
  public void dataWrangler_testCorrectAnime() throws FileNotFoundException {
    loadData data = new loadData();
    ArrayList<CharacterInterface> list =
        (ArrayList<CharacterInterface>) data.getFile("finalanimeCharacter.csv");
    characterNode actual = (characterNode) list.get(4);
    characterNode expected = new characterNode("One Punch man", "5.ÊChild Emperor", 801);
    assertEquals(true, actual.getAnime().equals(expected.getAnime())); // Here we just make sure
                                                                       // that the exepcted and
                                                                       // actual output anime name
                                                                       // matches. the expected is
                                                                       // One Punch man because in
                                                                       // the fourth entry in the
                                                                       // csv file that's what it
                                                                       // should be.
    actual = (characterNode) list.get(7);
    expected = new characterNode("One Punch man", "Drive Knight", 681);
    assertEquals(true, actual.getAnime().equals(expected.getAnime())); // Again we just compare the
                                                                       // names of the anime names.
    actual = (characterNode) list.get(19);
    expected = new characterNode("My Hero Academia", "Wash", 982);
    assertEquals(true, actual.getAnime().equals(expected.getAnime())); // Again we just compare
                                                                       // the names of the anime
                                                                       // names.
    actual = (characterNode) list.get(26);
    expected = new characterNode("Demon Slayer: Kimetsu no YaibaÊ", "Obanai Iguro", 888);
    assertEquals(true, actual.getAnime().equals(expected.getAnime())); // Again we compare the names
                                                                       // of the animes to make sure
                                                                       // they match.
    actual = (characterNode) list.get(34);
    expected = new characterNode("Jujutsu KaisenÊ", "Toji Fushiguro", 920);
    assertEquals(true, actual.getAnime().equals(expected.getAnime()));
  }
}
