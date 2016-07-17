import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Node;

public class NodeWrapper {
  private ArrayList<Node> nodeList;

  public NodeWrapper (ArrayList<Node> _nodeList) {
    this.nodeList = _nodeList;
  }
  @Override
  public boolean equals (Object _nodeWrapperObj) {

    assert (_nodeWrapperObj instanceof NodeWrapper);
    List<Node> _nodeList = ((NodeWrapper) _nodeWrapperObj).nodeList;
    assert _nodeList.size() == this.nodeList.size();

    
    for (int i = 0; i < this.nodeList.size(); i++) {

      Node aNode = this.nodeList.get(i);
      
      Node anotherNode = _nodeList.get(i);
      
      if (!aNode.isEqualNode(anotherNode)) {
        return false;
      }
    }
    
    return true;
  }
  
  @Override
  public int hashCode () {
    int hashCode = 31;
    for (Node node : this.nodeList) {
      String con=node.getTextContent();
      if(con!=null){
        hashCode += con.hashCode();
      }
    }
    return 1;
  }
 

}