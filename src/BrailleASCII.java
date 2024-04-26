import java.io.PrintWriter;

public class BrailleASCII {
  public static void main(String[] args) throws Exception {
   BrailleASCIITables table = new BrailleASCIITables();
   PrintWriter pen = new PrintWriter (System.out, true);
   String str = "";



    if ((args[0]).equals("braille")){
      for (int i = 0; i < args[1].length(); i++){
        str += (table.toBraille(args[1].charAt(i)));
      }
    }
    else if ((args[0]).equals("ascii")){
        pen.println (table.toASCII(args[1]));
      }

    else if ((args[0]).equals("unicode")){
        pen.println (table.toUnicode(args[1]));
      }
    else {
      throw new Exception();
    }
    pen.println(str);
    // converts to unicode  
  }
}
