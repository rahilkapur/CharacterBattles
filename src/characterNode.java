// --== CS400 Project Two File Header ==--
// Name: Rahil Kapur
// Email: rkapur3@wisc.edu
// Team: Red
// Group: AE
// TA: Ilay Raz
// Lecturer: Gary Dahl
// Notes to Grader:
/*
 * This class is a simple characterNode class where it describes the name of the character, the
 * anime they're from and their power level. It has getter methods and a constructor setting all of
 * the nodes.
 */
public class characterNode implements CharacterInterface {

  private String animeName;
  private String characterName; // These fields are simply here to help directly store the name of
                                // the character, the anime they're from, and their power level.
  private int powerLevel;

  /*
   * This simple constructor sets all of the private fields.
   * 
   * @param animeTitle the name of the anime
   * 
   * @param characterName the name of the character
   * 
   * @param power the power level or the strength of the anime character.
   */
  public characterNode(String animeTitle, String characterName, int power) {
    this.animeName = animeTitle;
    this.characterName = characterName;
    this.powerLevel = power;
  }

  /*
   * This getter methdo simply returns the name of the character
   * 
   * @return the name of the character
   */
  @Override
  public String getName() {
    return this.characterName;
  }

  /*
   * This getter method simply returns the name of the anime the character is from.
   * 
   * @return the name of the anime the character is from.
   */
  @Override
  public String getAnime() {
    return this.animeName;
  }

  /*
   * This method simply returns the power level of the character.
   * 
   * @return the strength or power of the character.
   */
  @Override
  public int getPower() {
    return this.powerLevel;
  }

  /*
   * This compare to method just compares the powers of two characters used to implement the RBT so
   * each character is placed correctly based on their power
   * 
   * @param o the character we're comparing to.
   * 
   * @returns an int representing if the first character or the second character is bigger.
   */


  @Override
  public int compareTo(CharacterInterface o) {
    characterNode characterTwo = (characterNode) o;
    if (this.getPower() > characterTwo.getPower()) { // If the first character's power is higher
                                                     // than we return 1.
      return 1;
    } else if (this.getPower() < characterTwo.getPower()) { // If the second character's power is
                                                            // higher we return -1;
      return -1;
    }
    return 0; // Otherwise we return 0, indicating when they're equal.
  }



}
