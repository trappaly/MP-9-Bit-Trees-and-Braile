public class BrailleASCII {
  public static void main(String[] args) {
    // converts to unicode 
    for (String str: args){
      int i = Integer.decode("0x" + str);
      System.err.println(i);
    } // for 
  }
  
}
