import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedReader;

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

  /*
   * Does recursion for set
   */

  public BitTreeNode setHelper(BitTreeNode node, String bits, int i, String value) {
    // If the index is equal to the length of the string, this means we're at a leaf, so return the value at the leaf
    if (i == bits.length()) {
      return new BitTreeLeaf(value);
    }
  // Otherwise we know we are at an inner node, so we want to cast it to be an inner node 
  else {
      BitTreeInteriorNode innerNode = (BitTreeInteriorNode) node;
      // If node is null, we want to create a new interior node
      if (node == null) {
        innerNode = new BitTreeInteriorNode(null, null);
      }
      // If the character at the current index value is equal to 0 
      if (bits.charAt(i) == '0') {
        // If the left inner node is equal to null, we want to set innerNode.left to setHelper and recursively call the function 
        if (innerNode.left == null) {
          innerNode.left = setHelper(innerNode.left, bits, i + 1, value);
        } // if  
        // Otherwise we just want to recursively call setHelper
        else {
          setHelper(innerNode.left, bits, i + 1, value);
        } // else
      } // if  
      // If the character at the current index value is equal to 1
      else if (bits.charAt(i) == '1') {
        // If the right inner node is equal to null, want to set innerNode.right to setHelper and recursively call the function
          if (innerNode.right == null) {
          innerNode.right = setHelper(innerNode.right, bits, i + 1, value);
          } // if
        // Otherwise we want to recursively call the function   
         else {
          setHelper(innerNode.right, bits, i + 1, value);
        } // else
      } // else if
      // returns innerNode
      return innerNode;
    } // else 
  } // setHelper(BitTreeNode, String, int, String)

  /*
   * Sets the bits value to the string value
   */
  
  public void set(String bits, String value) throws Exception {
    // if the length of the bits doesn't contain 0 or 1 and length of the bits isn't equal to size, then throw exception
    if (((!bits.contains("0")) || (!bits.contains("1"))) && bits.length() != size) {
      throw new Exception();
    } // if
    setHelper(root, bits, 0, value);
  } // set (String, String)

  /*
   * Does recursion for get
   */
  public String getHelper(BitTreeNode node, String bits, int i) throws Exception {
    // if node is equal to null, throw an exception 
    if (node == null) {
      throw new Exception();
    } // if
    else {
    // if node is a leaf, cast it as a leaf
    if (node instanceof BitTreeLeaf) {
      BitTreeLeaf leaf = (BitTreeLeaf) node;
    // return the value at the leaf and recursively call getHelper again  
      return leaf.value + getHelper(root, bits, i);
    } // if  
    // if the length of the bits is equal to i, this means it's at the end and there's no value, so we return empty string
    else if (bits.length() == i) {
      return "";
    } // else if 
     else {
      // if node is not a leaf, cast it as an interior node 
      BitTreeInteriorNode innerNode = (BitTreeInteriorNode) node;
      // if the character at the index is equal to 0, recursively call getHelper on the left node
      if (bits.charAt(i) == '0') {
        return getHelper(innerNode.left, bits, i + 1);
      } // if 
      else if (bits.charAt(i) == '1') {
        // if the character at the index is equal to 1, recursively call getHelper on the right node
        return getHelper(innerNode.right, bits, i + 1);
      } // else if 
    } // else 
  }
    throw new Exception();
  } // getHelper(BitTreeNode, String, int)


  /*
   * Gets the current value at the string 
   */
  public String get(String bits) throws Exception {
    // if the bit string doesn't contain 0 or 1 and the length isn't equal to the size, then it's invalid, so throw an exception
    //if (((!bits.contains("0")) || (!bits.contains("1"))) && bits.length() != size) {
      //throw new Exception();
    //} // if
    return getHelper(root, bits, 0);
  } // get (String)



  /*
   * Does recursion for dump 
   */
  public void dumpHelper(PrintWriter pen, BitTreeNode node, String bits) throws Exception {
    // if node is equal to null, we want to return 
    if (node == null) {
      return;
    } // if
    // if node is a BitTreeLeaf type, print the bits and the value at the bits  
    else if (node instanceof BitTreeLeaf) {
      pen.println(bits + "," + get(bits));
    } // else if  
    else {
      // if it is not a leaf, we can cast the node to an interior node
      BitTreeInteriorNode innerNode = (BitTreeInteriorNode) node;
      // recursively calls dumpHelper on the left node and adds 0 to the string
      dumpHelper(pen, innerNode.left, bits + "0");
      // recursively calls dumpHelper on the right node and adds 1 to the string 
      dumpHelper(pen, innerNode.right, bits + "1");
    } // else 
  } // dumpHelper (pen, node, bits)



  /*
   * Prints out the bit string with the value at the bit string as well 
   */
  public void dump(PrintWriter pen) {
  // has a try/catch to handle exceptions and calls dumpHelper  
  try {
      dumpHelper(pen, root, "");
    } catch (Exception e) {
      e.printStackTrace();
    } // catch 
  } // dump(PrintWriter)

  /*
   * Loads a file based on the source given into it
   */
  public void load(InputStream source) {
    // reads in the file
    BufferedReader reader = new BufferedReader(new InputStreamReader(source));
    try {
      // stores a line in newline when reading a file 
      String newline = reader.readLine();
      // loops over each line of the file while newline is not equal to null
      while (newline != null) {
        // splits the array on the newline by the comma
        String[] arr = newline.split(",", 2);
        // sets arr[0] which represents everything that comes before the comma to arr[1] which represents everything that comes after the comma
        this.set(arr[0], arr[1]);
        // reads each newline by each line
        newline = reader.readLine();
      } // while 
    } catch (Exception e) {
      e.printStackTrace();
    } // catch 
  } // load (InputStream)
} // class BitTree