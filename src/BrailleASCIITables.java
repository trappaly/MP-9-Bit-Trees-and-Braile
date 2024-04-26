import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;

public class BrailleASCIITables {

// pathway to load


BitTree ASCIIBraille;
BitTree BrailleASCII;
BitTree BrailleUnicode;


// put pathway inside of load 

  BrailleASCIITables() {
    ASCIIBraille = new BitTree(8);
    try {
    ASCIIBraille.load(new FileInputStream(new File ("../ASCIIBraile.txt")));
    //csc207/mps/mp9/MP9-Bits-Trees-and_Braille/ASCIIBraile.txt")));
    BrailleASCII = new BitTree(6);
    BrailleASCII.load(new FileInputStream(new File ("../BrailleASCII.txt")));
    //"csc207/mps/mp9/MP9-Bits-Trees-and_Braille/BrailleASCII.txt"
    BrailleUnicode = new BitTree(6);
    // csc207/mps/mp9/MP9-Bits-Trees-and_Braille/BrailleUnicode.txt
    BrailleUnicode.load((new FileInputStream(new File ("../BrailleUnicode.txt")))); 
    } catch (FileNotFoundException e){
      System.out.println("error");
    }
  }

  // check if tree is null, then load 

  PrintWriter pen = new PrintWriter (System.out, true);



  String toBraille(char letter){
    return Integer.toBinaryString(Character.valueOf(letter));
  }

  String toASCII (String bits) throws Exception{
    return BrailleASCII.get(bits);
  }

// maybe 

  String toUnicode (String bits) throws Exception {
    return BrailleUnicode.get(bits); 
  }
  
}
