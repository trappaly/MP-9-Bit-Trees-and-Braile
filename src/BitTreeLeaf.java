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

public BitTreeLeaf (String value) {
  this.value = value;
}
 // +--------------+------------------------------------------------
  // | Methods |
  // +--------------+

public String getLeaf(){
  return this.value;
}

public boolean isLeaf(){
  return true;
}




@Override
public void set(String bits, String value) {

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
}