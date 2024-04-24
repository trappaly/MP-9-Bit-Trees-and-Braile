import java.io.PrintWriter;
public class MyExperiment {
    public static void main(String[] args) throws Exception {
      PrintWriter pen = new PrintWriter (System.out, true);
      //String[] arr = {"a", "b", "c", "d", "e"};
      BitTree tree = new BitTree (3);
      tree.set("100000", "A");
      //pen.println("tree" + tree);      
      //"get" + tree.get("100000"));
      //tree.dump(pen);
  //} catch (Exception e){
  }
}
