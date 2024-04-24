import java.io.InputStream;
import java.io.PrintWriter;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * A bit tree that makes a bit tree with n levels
 * @author Alyssa Trapp
 */
public class BitTree {

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


  public BitTreeNode setHelper (BitTreeNode node, String bits, int i, String value){
    BitTreeInteriorNode innerNode = (BitTreeInteriorNode) node;
    if (bits.length() == i){
     return new BitTreeLeaf(value); 
    }
    else {
     if (bits.charAt(i) == '0'){
      innerNode.left = setHelper (innerNode.left, bits, i + 1, value);
    }
    else {
      innerNode.right = setHelper (innerNode.right, bits, i + 1, value);
    }
    return innerNode;
  }
}


   public void set (String bits, String value) throws Exception{
    if (((!bits.contains("0")) || (!bits.contains("1"))) &&  bits.length() != size){
      throw new Exception();
    } // if
    setHelper (root, bits, 0, value);
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
    if (bits.charAt(i) == '0'){
      return getHelper (innerNode.left, bits, i);
      }
    else if (bits.charAt(i) == '1'){  
        return getHelper (innerNode.right, bits, i);
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
   * Dump a portion of the tree to some output location.
  */
 

 
  void dumpHelper(PrintWriter pen, BitTreeNode node, String bits) {
    if (node == null) {
      pen.println("," + node.get(bits));
    } else {
      if (node.isLeaf()){
        // i don't think this should be indent but we'll see
        pen.println(node.get(bits));
        //dumpHelper(pen, node.right, indent + "");
      }
      dumpHelper(pen, node, bits);
      } // if
    } // if has children




  public void dump(PrintWriter pen) {
    dumpHelper (pen, root, "");
  } // dump(PrintWriter)
}




   /* Scanner scanner = new Scanner (source);
    try {
    while (scanner.hasNext()){
      String newline =  scanner.nextLine();
      String[] arr = newline.split("", 2);
      set (arr[0], arr[1]);
   } 
  } catch (Exception e){
  }
  scann


public void load (InputStream source){
    Buffered Reader scanner = new BufferedReader(new InputStreamReader(source));
    String newline = reader.readLine();
    while (scanner.hasNext){
        String[] arr = newline.split("", 2);
        set (arr[0], arr[1]);
        newline = reader.readLine();
    }
   }
   */














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
