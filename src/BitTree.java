import java.io.InputStream;
import java.io.PrintWriter;
import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * Simple binary trees.
 */
public class BitTree <T> {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The root of the tree
   */
  BitTreeNode root;

  /**
   * The number of values in the tree.
   */
  int size;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new bit tree based on the number of elements.
   */
  public BitTree(int n){
    this.size = n;
    this.root = new BitTreeInteriorNode(null); 
  } // BitTree (int)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+


   public void set (String bits, String value) throws Exception{
    if (((!bits.contains("0")) || (!bits.contains("1"))) &&  bits.length() != size){
      throw new Exception();
    } // if
    root.set(bits, value);
   } // set (String, String)


   public String getHelper (BitTreeNode node, String bits, int i) throws Exception{
    if (node != null) {
    if (node.isLeaf()) {
      BitTreeLeaf leaf = (BitTreeLeaf) node;
      return leaf.value;
    }
    else {
      BitTreeInteriorNode innerNode = (BitTreeInteriorNode) node;
      i++;
      if (bits.charAt(i) == '1'){  
      return getHelper (innerNode.right, bits, i);
      }
      else if (bits.charAt(i) == '0'){
      return getHelper (innerNode.left, bits, i);
      }
    }
  }
  throw new Exception();
}

   public String get (String bits) throws Exception {
    if (bits.length() != 6){
      throw new Exception();
    }
    return getHelper(root, bits, -1);
   } // get (String)

   
  /**
   * Dump the tree to some output location.
   */
  /*public void dump(PrintWriter pen) {
    dump(pen, root, "");
  } // dump(PrintWriter)


    /**
   * Dump a portion of the tree to some output location.
   */

   /* 
  void dumpHelper(PrintWriter pen, BitTreeNode node, String indent) {
    if (node == null) {
      pen.println(indent + "<>");
    } else {
      pen.println(indent + node.value);
      if ((node.left != null) || (node.right != null)) {
        dump(pen, node.left, indent + "  ");
        dump(pen, node.right, indent + "  ");
      } // if has children
    } // else
  } // dump
*/





   public void load (InputStream source){
    
   } // load (InputStream)














  // +---------+-----------------------------------------------------
  // | Helpers |
  // +---------+

  /**
   * Dump a portion of the tree to some output location.
   */
 /*  void dump(PrintWriter pen, BitTreeNode<T> node, String indent) {
    if (node == null) {
      pen.println(indent + "<>");
    } else {
      pen.println(indent + node.value);
      if ((node.left != null) || (node.right != null)) {
        dump(pen, node.left, indent + "  ");
        dump(pen, node.right, indent + "  ");
      } // if has children
    } // else
  } // dump
*/

} // class BinaryTree