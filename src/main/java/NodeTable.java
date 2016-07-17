import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class NodeTable {
    public LinkedHashMap<String,String> fors;
    public HashMap<String,ArrayList<String>> where;
    public HashMap<Integer,ArrayList<String>> join;

    public NodeTable(){
        fors=new LinkedHashMap<String,String>();
        where=new HashMap<String,ArrayList<String>>();
        join=new HashMap<Integer,ArrayList<String>>();
    }
}