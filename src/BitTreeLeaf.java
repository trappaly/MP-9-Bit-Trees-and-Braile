import java.io.InputStream;
import java.io.PrintWriter;

/*
 * A subclass of BitTreeNode which stores a value within the leaf
 * @author Alyssa Trapp 
 */

public class BitTreeLeaf implements BitTreeNode {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The value in this node.
   */
  String value;

  /*
   * Constructor for BitTreeLeaf
   */

  public BitTreeLeaf(String value) {
    this.value = value;
  } // BitTreeLeaf (String)
  // +--------------+------------------------------------------------
  // | Methods |
  // +--------------+

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
} // class BitTreeLeaf
