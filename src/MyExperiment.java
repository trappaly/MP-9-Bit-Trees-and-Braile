import java.io.PrintWriter;
public class MyExperiment {
    public static void main(String[] args) throws Exception {
      PrintWriter pen = new PrintWriter (System.out, true);
      //String[] arr = {"a", "b", "c", "d", "e"};
      BitTree tree = new BitTree (3);
      pen.println("before");
      tree.set("100000", "A");
      pen.println("get   " + tree.get("100000"));
      //tree.get("100000");
      //tree.dump(pen);
      //pen.println("dump: ");
      //tree.dump(pen);
      //pen.println("get   " + tree.get("100000"));
      //pen.println("after");
     // pen.println("get   " + tree.get("100000"));
      //tree.dump(pen);
  //} catch (Exception e){
  }
}
