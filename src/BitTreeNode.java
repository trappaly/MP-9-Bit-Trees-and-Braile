import java.io.InputStream;
import java.io.PrintWriter;

/**
 * Nodes in a bit tree.
 * @author Alyssa Trapp
 */
public interface BitTreeNode {
  /*
   * Follows the path through the tree given by bits that adds/replaces the value in the tree
   */
  public void set (String bits, String value) throws Exception;
  /*
   * Follows the path through the tree given by bits returning the value at the end
   */
  public String get (String bits);
  /*
   * Prints out the contents of the tree in CSV format
   */
  public void dump (PrintWriter pen);
  /*
   * 
   */
  public void load (InputStream source);
  public boolean isLeaf();
  
} // class BinaryTreeNode<T>