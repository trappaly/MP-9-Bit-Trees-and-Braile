import java.io.InputStream;
import java.io.PrintWriter;

/**
 * Nodes in a binary tree.
 */
public interface BitTreeNode {
  public void set (String bits, String value) throws Exception;
  public String get (String bits);
  public void dump (PrintWriter pen);
  public void load (InputStream source);
  public boolean isLeaf();
  
} // class BinaryTreeNode<T>