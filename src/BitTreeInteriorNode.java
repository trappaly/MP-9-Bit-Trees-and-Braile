import java.io.InputStream;
import java.io.PrintWriter;

/*
 * A subclass of BitTreeNode which represents the node pointers to a certain pathway within the tree 
 *  @author Alyssa Trapp
 */

public class BitTreeInteriorNode implements BitTreeNode {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The left subtree.
   */
  BitTreeNode left;

  /**
   * The right subtree.
   */
  BitTreeNode right;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /*
   * Constructor for BitTreeInteriorNode
   */

  public BitTreeInteriorNode(BitTreeNode left, BitTreeNode right) {
    this.left = left;
    this.right = right;
  } // BitTreeNode(T, BinaryTreeNode, BinaryTreeNode)

  // +--------------+------------------------------------------------
  // | Methods |
  // +--------------+

  @Override
  public void set(String bits, String value) {
    throw new UnsupportedOperationException("Unimplemented method 'set'");
  } // set (String, String)

  @Override
  public String get(String bits) {
    throw new UnsupportedOperationException("Unimplemented method 'get'");
  } // get (String)

  @Override
  public void dump(PrintWriter pen) {
    throw new UnsupportedOperationException("Unimplemented method 'dump'");
  } // dump (pen)

  @Override
  public void load(InputStream source) {
    throw new UnsupportedOperationException("Unimplemented method 'load'");
  } // load (source)
} // class BitTreeInteriorNode
