import java.io.InputStream;
import java.io.PrintWriter;

public class BitTreeLeaf implements BitTreeNode {
// goal: for left and right nodes to be null

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The value in this node.
   */
  String value;

public BitTreeLeaf (String value) {
  //super(value, null, null);
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