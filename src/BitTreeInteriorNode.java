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
   * The value in this node.
   */


   // get rid of value parameter
  String value;
  
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

  public BitTreeInteriorNode (BitTreeNode left, BitTreeNode right) {
    this.left = left;
    this.right = right;
  } // BitTreeNode(T, BinaryTreeNode, BinaryTreeNode)



 // +--------------+------------------------------------------------
  // | Methods |
  // +--------------+

  @Override
public void set(String bits, String value) {
  //if ((bits.substring(bits.length() - 2), (bits.length() - 1)) == 0){
    
  //}
  // TODO Auto-generated method stub
  //throw new UnsupportedOperationException("Unimplemented method 'set'");
}

@Override
public String get(String bits) {
  // TODO Auto-generated method stub
  throw new UnsupportedOperationException("Unimplemented method 'get'");
}

@Override
public void dump(PrintWriter pen) {
  // TODO Auto-generated method stub
  throw new UnsupportedOperationException("Unimplemented method 'dump'");
}

@Override
public void load(InputStream source) {
  // TODO Auto-generated method stub
  throw new UnsupportedOperationException("Unimplemented method 'load'");
}
@Override
public boolean isLeaf(){
  return false;
}


}
