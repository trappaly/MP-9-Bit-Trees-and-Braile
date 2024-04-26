import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;
/*
 * Performs conversion for ASCII, Braille, and Unicode
 * @author: Alyssa Trapp
 */

public class BrailleASCIITables {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /*
   * Stores ASCII to Braille tree
   */
  BitTree ASCIIBraille;

  /*
   * Stores Braille to ASCII tree
   */
  BitTree BrailleASCII;

  /*
   * Stores Braille to Unicode tree
   */
  BitTree BrailleUnicode;

  /*
   * BrailleASCIITables constructor
   */
  BrailleASCIITables() {
    // try/catch
    try {
      // initializes ASCIIBraille tree to a size of 8
      ASCIIBraille = new BitTree(8);
      // loads the ASCIIBraille.txt file
      ASCIIBraille.load(new FileInputStream(new File("../ASCIIBraile.txt")));
      // initializes ASCIIBraille tree to a size of 6
      BrailleASCII = new BitTree(6);
      // loads the BrailleASCII.txt file
      BrailleASCII.load(new FileInputStream(new File("../BrailleASCII.txt")));
      // initializes ASCIIBraille tree to a size of 6
      BrailleUnicode = new BitTree(6);
      // loads the BrailleUnicode.txt file
      BrailleUnicode.load((new FileInputStream(new File("../BrailleUnicode.txt"))));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      ;
    } // catch
  } // BrailleASCIITables()

  /*
   * Converts a character from ASCII to Braille
   */
  String toBraille(char letter) {
    return Integer.toBinaryString(Character.valueOf(letter));
  } // toBraille (letter)

  /*
   * Converts a character from Braille to ASCII
   */

  String toASCII(String bits) throws Exception {
    return BrailleASCII.get(bits);
  } // toASCII (bits)

  /*
   * Converts a character from Braille to Unicode
   */

  String toUnicode(String bits) throws Exception {
    return BrailleUnicode.get(bits);
  } // toUnicode (String)
} // class BrailleASCIITables
