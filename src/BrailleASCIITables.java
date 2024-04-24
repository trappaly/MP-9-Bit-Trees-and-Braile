public class BrailleASCIITables {




  static String toBraille(char letter){

    Scanner scanner = new Scanner (new filename ("ASCIIBraile.txt"));


    while (scanner.hasNext()){
      String newline = scanner.nextLine();
      String[] arr = newline.split("", 2);
      //Char input = letter.substring(7, 8);
      Char input = arr[1];
      if ((letter.compareTo(input)) == 0){
        return arr[1];
        //substring 0 6
      }
      // throw new exception
    }
  } // toBraile (char)

  static String toASCII (String bits){


    return ""; // STUB
  }

  static String toUnicode (String bits){
    return ""; // STUB.
  }
  
}
