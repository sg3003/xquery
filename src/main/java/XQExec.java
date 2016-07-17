import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class XQExec{

	public static ArrayList<Node> executeFromFile(String string) throws IOException {
		return execute(new ANTLRFileStream(string));
		
	}
	private static ArrayList<Node> execute(ANTLRInputStream input) {
		XQLexer lexer = new XQLexer(input);
		 
	    // Get a list of matched tokens
	    CommonTokenStream tokens = new CommonTokenStream(lexer);
	 
	    // Pass the tokens to the parser
	    XQParser parser = new XQParser(tokens);
	 
	    // Specify our entry point
	    XQParser.XqsContext expSentenceContext = parser.xqs();
	 
	    // Walk it and attach our listener
	    ParseTreeWalker walker = new ParseTreeWalker();
	    XQBuilder listener = new XQBuilder();
	    //XPathEval listener = new XPathEval();
	    walker.walk(listener, expSentenceContext);
	    XQEvaluator evaluator = new XQEvaluator(expSentenceContext);
	    ArrayList<Node> result= evaluator.run();
		 
		printOutputFile(result);
        return result;
        
    }
	
	 // Print result nodes
	 public static void checkResult(Node root, ArrayList<String> order,int tabs, int wsLimit)
	  {
		String ws = "";
		String attStr = "";
		for (int k=0;k <tabs; k++)
			ws = ws+"\t";
		String resultNode = "";
	        if(root==null)
			return;
		if (root instanceof Element)
		{
			resultNode = root.getNodeName();
			order.add("\n");
			NamedNodeMap attrs = root.getAttributes();
	        	for (int i = 0; i < attrs.getLength(); i++)
			{
	            		Attr attribute = (Attr) attrs.item(i);
	            		attStr = attStr+" "+attribute.getName()+"=\""+attribute.getValue()+"\"";
	        	}
	        	order.add(ws+"<"+resultNode+attStr+">");
			NodeList children = root.getChildNodes();
	        	for (int i = 0; i < children.getLength(); i++)
			{
				if (children.item(i) instanceof Text && children.item(i).getTextContent().length()!=0)
					order.add(children.item(i).getTextContent());
				else
				{
		 			wsLimit = tabs+1;
		 			checkResult(children.item(i), order, tabs+1, wsLimit);
				}
			}
			if (tabs < wsLimit)
	        	{
				order.add("\n"+ws);
			}
			order.add("</"+resultNode+">");
	        	return;
	   	}
		else if (root instanceof Text && root.getTextContent().length() != 0)
		{
			order.add(root.getTextContent());
		}
	        return;
	  }
	  public static void printOutputFile(ArrayList<Node> result)
	  {
		ArrayList<String> order = new ArrayList<String>();
		PrintWriter output;
		try {
			output = new PrintWriter("output.xml", "UTF-8");
			output.printf("<?xml version=\"1.0\"?>");
			
		for(int i=0;i<result.size();i++)
		{
			checkResult(result.get(i), order, 0,0);
			if (order.isEmpty() == false)
			{
				//System.out.println(i);
				for(int j=0;j<order.size();j++)
				{ 
				String temp = order.get(j);
				
					output.printf("%s",temp);
				}  
				order.clear();
			}
			
		}
		output.close();
		return;
        } catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}        
        
	  }
	

	
}