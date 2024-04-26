import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Object;
import java.io.Reader;
//import java.io.Reader;

/**
 * A bit tree that makes a bit tree with n levels
 * 
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
  public BitTree(int n) {
    this.size = n;
    this.root = new BitTreeInteriorNode(null, null);
  } // BitTree (int)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  public BitTreeNode setHelper(BitTreeNode node, String bits, int i, String value) {
    if (i == bits.length()) {
      return new BitTreeLeaf(value);
    } else {
      BitTreeInteriorNode innerNode = (BitTreeInteriorNode) node;
      if (node == null) {
        innerNode = new BitTreeInteriorNode(null, null);
      }
      if (bits.charAt(i) == '0') {
        if (innerNode.left == null) {
          innerNode.left = setHelper(innerNode.left, bits, i + 1, value);
        }
        else {
        setHelper(innerNode.left, bits, i + 1, value);
      }
    } 
      else if (bits.charAt(i) == '1') {
        if (innerNode.right == null) {
        // innerNode.right = new BitTreeInteriorNode(null);
        innerNode.right = setHelper(innerNode.right, bits, i + 1, value);
        // }
      }
      else{
          setHelper(innerNode.right, bits, i + 1, value);
      }
    }
      // System.out.println("innerNode" + innerNode);
      return innerNode;
  }
}

  public void set(String bits, String value) throws Exception {
    if (((!bits.contains("0")) || (!bits.contains("1"))) && bits.length() != size) {
      throw new Exception();
    } // if
    setHelper(root, bits, 0, value);
  } // set (String, String)

  // node

  public String getHelper(BitTreeNode node, String bits, int i) throws Exception {
     if (node == null){
      throw new Exception();
      //return "boo";
     }
    // throw new Exception();
    // }
    if (node instanceof BitTreeLeaf) {
      BitTreeLeaf leaf = (BitTreeLeaf) node;
      return leaf.value + getHelper(root, bits, i);
    }
    else if (bits.length() == i){
      return "";
    }
    else {
      BitTreeInteriorNode innerNode = (BitTreeInteriorNode) node;
      if (bits.charAt(i) == '0') {
        return getHelper(innerNode.left, bits, i + 1);
      } else if (bits.charAt(i) == '1') {
        return getHelper(innerNode.right, bits, i + 1);
      }
    }
    throw new Exception();
  }
  /*
   * public String getHelper(BitTreeNode node, String bits, int i) throws
   * Exception {
   * BitTreeLeaf leaf = (BitTreeLeaf) node;
   * if (node instanceof BitTreeInteriorNode) {
   * // use instanceOf
   * BitTreeInteriorNode innerNode = (BitTreeInteriorNode) node;
   * //if (node == null) {
   * //throw new Exception("ran out of bits");
   * //} else {
   * if ((innerNode.left == null) && (innerNode.right == null)) {
   * //BitTreeLeaf leaf = (BitTreeLeaf) node;
   * return leaf.getLeaf();
   * } else if (bits.charAt(i) == '0') {
   * return getHelper(innerNode.left, bits, i++);
   * } else {
   * return getHelper(innerNode.right, bits, i++);
   * }
   * }
   * else if (node instanceof BitTreeLeaf){
   * return leaf.value;
   * }
   * return "I don't know what to return here";
   * }
   */

  public String get(String bits) throws Exception {
    if (((!bits.contains("0")) || (!bits.contains("1"))) && bits.length() != size) {
      throw new Exception();
    } // if
    return getHelper(root, bits, 0);
    }
    //for (int i = 0; i < ; i += 6){
      //if (i + 6 > bits.length()){

      //}
      //bits.substring(i, i + 6);
    //}
    // get (String)

  /*
   * BitTreeInteriorNode innerNode = (BitTreeInteriorNode) node;
   * BitTreeLeaf leaf = (BitTreeLeaf) node;
   * if (node != null) {
   * if (bits.length() == i) {
   * return leaf.value;
   * }
   * else {
   * i++;
   * if (bits.charAt(i) == '0'){
   * return getHelper (innerNode.left, bits, i);
   * }
   * else if (bits.charAt(i) == '1'){
   * return getHelper (innerNode.right, bits, i);
   * }
   * }
   * }
   * return leaf.value;
   * //throw new Exception();
   * }
   */

  /**
   * Dump a portion of the tree to some output location.
   */

  // had string ""

  /*
   * void dumpHelper(PrintWriter pen, BitTreeNode node, String bits, int i) {
   * // pen.println(bits + "," + node.get(bits));
   * if (node instanceof BitTreeLeaf) {
   * try {
   * pen.println(get(bits));
   * // "," + get(bits));
   * return;
   * } catch (Exception e) {
   * e.printStackTrace();
   * }
   * }
   * else {
   * pen.println((bits.charAt(i)));
   * if (bits.charAt(i) == '0') {
   * dumpHelper(pen, innerNode.left, bits, i++);
   * } else if (bits.charAt(i) == '1') {
   * dumpHelper(pen, innerNode.right, bits, i++);
   * }
   * }
   * } // if
   * // if has children
   */
  public void dumpHelper(PrintWriter pen, BitTreeNode node, String bits) throws Exception {
    if (node == null) {
      return;
    } else if (node instanceof BitTreeLeaf) {
      pen.println(bits + "," + get(bits));
    } else {
      BitTreeInteriorNode innerNode = (BitTreeInteriorNode) node;
        dumpHelper(pen, innerNode.left, bits + "0");
        dumpHelper(pen, innerNode.right, bits + "1");
      }
    }

  public void dump(PrintWriter pen) {
    BitTreeInteriorNode temproot = (BitTreeInteriorNode) root;
    try {
      dumpHelper(pen, root, "");
    } catch (Exception e) {

    }
  } // dump(PrintWriter)



public void load (InputStream source){
   BufferedReader reader = new BufferedReader(new InputStreamReader(source));
   try {
    String newline = reader.readLine();
    while (newline != null){
    String[] arr = newline.split(",", 2);
    this.set (arr[0], arr[1]);
     newline = reader.readLine();
    }
  } catch (Exception e){
  }
}
}



// I want to think this is rt, not entirely sure 
  /* public void load(InputStream source){
    Scanner scanner = new Scanner(new InputStreamReader (source));
    while (scanner.hasNext()){
      String newline = scanner.nextLine();
      String[] arr = newline.split("", 2);
      try {
      set(arr[0], arr[1]);
    } catch(Exception e){

    }
  }
  scanner.close();
}
}
*/
  /*public void load(InputStream source) {
    BufferedReader scanner = new BufferedReader(new InputStreamReader(source));
    String newline = reader.readLine();
    while (newline != null) {
      String[] arr = newline.split("", 2);
      this.set(arr[0], arr[1]);
      newline = reader.readLine();
    }
  }
}*/

/*
 * Scanner scanner = new Scanner (source);
 * try {
 * while (scanner.hasNext()){
 * String newline = scanner.nextLine();
 * String[] arr = newline.split("", 2);
 * set (arr[0], arr[1]);
 * }
 * } catch (Exception e){
 * }
 * scan
 */

/*
 * public void load (InputStream source){
 * BufferedReader scanner = new BufferedReader(new InputStreamReader(source));
 * String newline = reader.readLine();
 * while (newline != null){
 * String[] arr = newline.split("", 2);
 * this.set (arr[0], arr[1]);
 * newline = reader.readLine();
 * }
 */

// +---------+-----------------------------------------------------
// | Helpers |
// +---------+

/**
 * Dump a portion of the tree to some output location.
 */
/*
 * void dump(PrintWriter pen, BitTreeNode<T> node, String indent) {
 * if (node == null) {
 * pen.println(indent + "<>");
 * } else {
 * pen.println(indent + node.value);
 * if ((node.left != null) || (node.right != null)) {
 * dump(pen, node.left, indent + "  ");
 * dump(pen, node.right, indent + "  ");
 * } // if has children
 * } // else
 * } // dump
 */
