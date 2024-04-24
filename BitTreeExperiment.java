import java.io.PrintWriter;
public class BitTreeExperiment {
    public static void main(String[] args) {
      PrintWriter pen = new PrintWriter (System.out, true);
      //String[] arr = {"a", "b", "c", "d", "e"};
      BitTree tree = new BitTree (3);
      try {
      tree.set("100000", "A");
      pen.println("get" + tree.get("100000"));
      //tree.dump(pen);
  } catch (Exception e){
  }
  }
}
