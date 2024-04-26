import java.io.PrintWriter;

/*
 * The main file running converting to braille, ascii, or unicode based on the command line parameters
 */

public class BrailleASCII {
  public static void main(String[] args) throws Exception {
  // create a new BrailleASCIITable object called table
  BrailleASCIITables table = new BrailleASCIITables();
  // creates a pen to print out values
   PrintWriter pen = new PrintWriter (System.out, true);
  // initializes str to be an empty string
   String str = "";
   // if args[0] is equal to braile, then loop over the character in the array and convert them to Braille
    if ((args[0]).equals("braille")){
      for (int i = 0; i < args[1].length(); i++){
        str += (table.toBraille(args[1].charAt(i)));
      } // for 
    } // if 
    // if args[0] is equal to ascii, then call table on to ASCII
    else if ((args[0]).equals("ascii")){
        pen.println (table.toASCII(args[1]));
      } // else if 
    // if args[0] is equal to unicode, then call table on to Unicode  
    else if ((args[0]).equals("unicode")){
      //convert it to braille instead of pass in hello
      // problem: thinks it is ascii, 
      for (int i = 0; i < args[i].length(); i++){
        pen.println (table.toUnicode(table.toBraille(args[1].charAt(i))));
      } // for
     } // else if  
    else {
      throw new Exception();
    } // else
    // prints the final string
    pen.println(str);
  } // main 
} // BrailleASCII class 
