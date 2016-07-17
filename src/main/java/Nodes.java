import java.util.ArrayList;

public class Nodes {
    public ArrayList<String> children;
    public String parent;
    public int table;

    public Nodes(int no){
        children=new ArrayList<String>();
        parent=null;
        table=no;
    }
}