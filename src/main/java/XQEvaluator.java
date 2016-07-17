import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.io.*;

import javax.xml.parsers.DocumentBuilderFactory;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;



public class XQEvaluator extends XQBuilder {
 private XQObj xq;
 private XqsObj xqs;
 private Stack<Ctx> stackContext=new Stack<Ctx>();
 private Document doctree;
 private HashMap<String,Nodes> graph = new HashMap<String,Nodes>();
 private HashMap<Integer,NodeTable> info = new HashMap<Integer,NodeTable>();
 private int tablecount=0;
 private String curr_var="";
 
 // Stores a list of the final results
 ArrayList<Node> answer = new ArrayList<Node>();
 
 private Stack<ArrayList<Node>> stack = new Stack<ArrayList<Node>>();
 private Stack<ArrayList<Ctx>> ctxList=new Stack<ArrayList<Ctx>>();
	
    // Method that gets the Object created through XQBuilder
	XQEvaluator(XQParser.XqsContext expSentenceContext){
		this.xqs =  (XqsObj) BuilderMap.get(expSentenceContext);
		this.xq = this.xqs.x;
	}

	XQEvaluator(XQParser.XqContext expSentenceContext){
		this.xq =  (XQObj) BuilderMap.get(expSentenceContext);
	}
	// Run method that evaluates the XQ object
	public ArrayList<Node> run() {
		this.answer = EvalXq(this.xq);
		return this.answer;
	}

	// Evaluate XQObj
	private ArrayList<Node> EvalXq(XQObj xq) {
		if(xq.ap != null) return EvalAp(xq.ap);
		if(xq.tag!=null){
			return xqTag(xq);
			}
		if(xq.f==null && xq.l!=null){
			return EvalLet(xq);
		}
		if(xq.f!=null || xq.l!=null){
				return EvalFLWR(xq);
		}
		if(xq.fj!=null){
			return RewriteXq(xq);
		}
		switch(xq.text){
		case "/": return xqSlash(xq);
		case "//": return xqDSlash(xq);
		case ",": return xqComma(xq);
		case "()": return EvalXq(xq.xqLeft);
		case "JOIN": return EvalXqJoin(xq);
		default:if(xq.text.startsWith("$")){
			return xqVar(xq);}
			else return xqStr(xq);
		}
		
		
	
	}
    private ArrayList<Node> RewriteXq(XQObj xq2) {
    	EvalForJ(xq.fj);
        EvalCondJ(xq.cj);
        String returns=xq.rj.text;
        String strJoin=null;
        LinkedList<Integer> st= new LinkedList<Integer>();
        st.addAll(info.keySet());
       
        while(st.size()>1){

            int curr=st.pop();
            int ele;

                Set<Integer> setc=info.get(curr).join.keySet();
                 if(!setc.isEmpty()){
                    ele=setc.iterator().next();
                    st.remove(new Integer(ele));
                 }
                 else{
                    ele=st.pop();
                 }

                if(strJoin==null){
                    strJoin=constructJoin(info, curr, ele,null);
                }
                else{
                    strJoin=constructJoin(info,curr, ele,strJoin);
                }
                if(info.get(curr).join.get(ele)!=null)
                    info.get(curr).join.remove(ele);
                if(info.get(ele).join.get(curr)!=null)
                    info.get(ele).join.remove(curr);
                info=createNode(info,curr,ele);


                int news=(-1*curr*10)+ele;
                Integer[] keys=Arrays.asList(setc.toArray()).toArray(new Integer[setc.toArray().length]);
                for (int k:keys){
                    info.get(k).join.put(news,info.get(k).join.get(curr));
                    info.get(k).join.remove(curr);
                }

                Set<Integer> setw=info.get(ele).join.keySet();
                keys=Arrays.asList(setw.toArray()).toArray(new Integer[setw.toArray().length]);
                for (int k:keys){
                    if(info.get(k).join.containsKey(news)){
                        info.get(k).join.get(news).addAll(info.get(k).join.get(ele));
                    }
                    else{
                        info.get(k).join.put(news,info.get(k).join.get(ele));
                    }
                    info.get(k).join.remove(ele);
                }

                info.remove(curr);
                info.remove(ele);
                st.addFirst(news);

        }
        String query;
        if((st.size()==1) && strJoin!=null){
            int n=st.pop();
           
            String rem = returns.replaceAll ("\\$([_A-Za-z0-9]*)", "\\$$1/\\*");
            String returnStatement=rem.replaceAll("\\$","\\$tuple/");
            query="for $tuple in "+strJoin+'\n'+makeWhere(n,info)+" return "+returnStatement;

        }
        else{
           
            int n=st.pop();
            query="let $testing:=\"n\" "+makeFor(info,n)+makeWhere(n,info)+" return "+returns;
        }

      
    Writer writer = null;

    try {
        writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("newquery.txt"), "utf-8"));
        writer.write(query);
    } catch (IOException ex) {
      ex.printStackTrace();
    } finally {
       try {writer.close();} catch (Exception ex) {}
    }
    ANTLRInputStream inputq = new ANTLRInputStream(query); //"document(\"j_caesar.xml\")/TITLE");

    XQLexer lexerq = new XQLexer(inputq);

    CommonTokenStream tokensq = new CommonTokenStream(lexerq);

    XQParser parserq=new XQParser(tokensq);
    XQParser.XqContext expSentenceContextq = parserq.xq();
    ParseTreeWalker walkerq = new ParseTreeWalker();
    XQBuilder listenerq = new XQBuilder();
    
    walkerq.walk(listenerq, expSentenceContextq);
    XQEvaluator evaluator = new XQEvaluator(expSentenceContextq);
    ArrayList<Node> resultq= evaluator.run();

    
    if (resultq==null){
        resultq=new ArrayList<Node>();
    }
    return resultq;
	}

	private StringBuffer makeFor(HashMap<Integer, NodeTable> info, int n) {
		if(info.get(n).fors.isEmpty()){
		      return null;
		    }
		    else{
		      String[] forstats=Arrays.asList(info.get(n).fors.keySet().toArray()).toArray(new String[info.get(n).fors.keySet().toArray().length]);
		      StringBuffer fo=new StringBuffer("for ");
		      
		      fo.append(forstats[0]);
		      fo.append(" in ");
		      fo.append(info.get(n).fors.get(forstats[0]));
		      for(int i=1;i<forstats.length;i++){
		        fo.append(" , ");
		        fo.append('\n'+"            ");
		        fo.append(forstats[i]);
		        fo.append(" in ");
		        fo.append(info.get(n).fors.get(forstats[i]));
		      }
		      fo.append('\n');
		      return fo;
		    }
	}

	private String makeWhere(int n, HashMap<Integer, NodeTable> info) {
		if (info.get(n).where.isEmpty())
		      return "       ";
	    else{

	      StringBuffer where=new StringBuffer("        where ");
	      String[] condStr=Arrays.asList(info.get(n).where.keySet().toArray()).toArray(new String[info.get(n).where.keySet().toArray().length]);
	      where.append(condStr[0]);
	      where.append(" = ");
	      where.append(info.get(n).where.get(condStr[0]).get(0));
	      where.append('\n'+"        ");
	      
	      for(int j=1;j<info.get(n).where.get(condStr[0]).size();j++){
	          where.append(" and ");
	          where.append(condStr[0]);
	          
	          where.append(" = ");
	          where.append(info.get(n).where.get(condStr[0]).get(j));
	        }
	      for(int i=1;i<condStr.length;i++){
	        where.append(" and ");
	        where.append(condStr[i]);
	        where.append(" = ");
	        where.append(info.get(n).where.get(condStr[i]).get(0));
	        for(int j=1;j<info.get(n).where.get(condStr[i]).size();j++){
	          where.append(" and ");
	          where.append(condStr[i]);
	          where.append(" = ");
	          where.append(info.get(n).where.get(condStr[i]).get(j));
	        }
	      }
	      return where.toString();
	    }
	}

	private HashMap<Integer, NodeTable> createNode(HashMap<Integer, NodeTable> info, int curr, int ele) {
		int news=(-1*curr*10)+ele;
	    info.put(news,new NodeTable());
	    
	    info.get(news).join.putAll(info.get(curr).join);
	    Set<Integer> skey=info.get(ele).join.keySet();
	    Integer[] keys=Arrays.asList(skey.toArray()).toArray(new Integer[skey.toArray().length]);
	    for(int k:keys){
	      if(info.get(news).join.containsKey(k)){
	          info.get(news).join.get(k).addAll(info.get(ele).join.get(k));
	      }
	      else{
	          info.get(news).join.put(k,info.get(ele).join.get(k));
	      }
	    }
	    return info;

	  }
	

	private String constructJoin(HashMap<Integer, NodeTable> info, int curr, int ele, String strJoin) {
		StringBuffer j=new StringBuffer("join( ");
	    String q1=makefQuery(info, curr);
	    String q2=makefQuery(info,ele);
	    if (strJoin!=null){
	      j.append('\n'+"    "); // First join
	      j.append(strJoin);
	      j.append(", ");
	      j.append('\n');
	      if(q1!=null)
	        j.append(q1);
	      else
	        j.append(q2);
	    }
	    else{
	      j.append(q1);
	      j.append(", ");
	      j.append('\n'+"        "); // for $b
	      j.append(q2);
	    }
	    j.append(", ");
	    j.append('\n'+"        ");
	    String l1=makeList(info.get(curr).join.get(ele));
	    String l2=makeList(info.get(ele).join.get(curr));
	    j.append(l1);
	    j.append(", ");
	    j.append(l2);
	    j.append(" )");
	    return j.toString();
	}

	private String makeList(ArrayList<String> vars) {
		StringBuffer l=new StringBuffer("[ ");
	    if((vars!=null) && (vars.size()>0)){
	      l.append(vars.get(0).substring(1));
	      
	      for(int i=1;i<vars.size();i++){
	        l.append(", ");
	        l.append(vars.get(i).substring(1));
	      }
	    }
	    l.append(" ]");
	    return l.toString();
	}

	private String makefQuery(HashMap<Integer, NodeTable> info, int n) {
		String[] forstats=Arrays.asList(info.get(n).fors.keySet().toArray()).toArray(new String[info.get(n).fors.keySet().toArray().length]);
	      StringBuffer fo=makeFor(info,n);
	      if(fo==null)
	        return null;
	      fo.append(makeWhere(n,info));
	      fo.append(makeReturn(forstats));
	      return fo.toString();
	}

	private Object makeReturn(String[] forstats) {
		StringBuffer ret=new StringBuffer(" return ");
	    ret.append("<tuple>{ ");
	    ret.append(makeElem(forstats[0]));
	    for (int i=1;i<forstats.length;i++){
	      ret.append(", ");
	      ret.append('\n'+"        ");
	      ret.append(makeElem(forstats[i]));
	    }
	    ret.append('\n'+"            "+" }</tuple>");
	    return ret.toString();
	}

	private Object makeElem(String s) {
		StringBuffer e=new StringBuffer();
	    String var=s.replaceAll("\\$","");
	    e.append("<"+var+">{ ");
	    e.append("$"+var);
	    e.append(" }</"+var+">");
	    return e.toString();
	}

	private Object EvalCondJ(CJObj cj) {
		switch(cj.text){
		case "jAnd": return EvalJAnd(cj);
		case "jEq" : return EvalJEq(cj);
		case "jEqS": return EvalJEqS(cj);
		}
		return null;
	}

	private Object EvalJEqS(CJObj cj) {
		String var1=cj.varLeft;
        ArrayList<String> as=new ArrayList<String>();
        if(info.get(graph.get(var1).table).where.get(var1)==null){
            as.add(cj.strConst);
            info.get(graph.get(var1).table).where.put(var1,as);
        }
        else{
            info.get(graph.get(var1).table).where.get(var1).add(cj.strConst);
        }
        return null;
	}

	private Object EvalJEq(CJObj cj) {
		String var1=cj.varLeft;
        String var2=cj.varRight;
        
        int tableLeft=graph.get(var1).table;
        int tableRight=graph.get(var2).table;
        if (tableLeft==tableRight){
            ArrayList<String> as=new ArrayList<String>();
            if(info.get(tableLeft).where.get(var1)==null){
                as.add(var2);
                info.get(tableLeft).where.put(var1,as);}
            else
                info.get(tableLeft).where.get(var1).add(var2);
        }
        else{
            ArrayList<String> j=info.get(tableLeft).join.get(tableRight);
            if (j!=null){
                j.add(var1);
                info.get(tableRight).join.get(tableLeft).add(var2);
            }
            else{
                info.get(tableLeft).join.put(new Integer(tableRight),new ArrayList<String>());
                info.get(tableLeft).join.get(tableRight).add(var1);
                info.get(tableRight).join.put(new Integer(tableLeft),new ArrayList<String>());
                info.get(tableRight).join.get(tableLeft).add(var2);
            }
        }
        return null;
	}

	private Object EvalJAnd(CJObj cj) {
		EvalCondJ(cj.cjLeft);
		EvalCondJ(cj.cjRight);
		return null;
	}

	private Object EvalForJ(ForJObj fj) {
	   ArrayList<String> variables = fj.var;
       ArrayList<PathObj> paths = fj.x;

        for(int i=0;i<variables.size();i++){
            curr_var=variables.get(i);
            
            EvalPath(paths.get(i));
        }
        return null;
		
	}

	private Object EvalPath(PathObj pathObj) {
		switch(pathObj.text){
		case "pathAp": return EvalPathAp(pathObj);
		case "pathSlash" : return EvalPathSlash(pathObj);
		
		}
		return null;
		
	}

	

	private Object EvalPathSlash(PathObj pathObj) {
		String parent=pathObj.var;
        int number=graph.get(parent).table;
        Nodes g=new Nodes(number);
        g.parent=parent;
        graph.put(curr_var,g);
        graph.get(parent).children.add(curr_var);
        NodeTable t=info.get(number);
        t.fors.put(curr_var,pathObj.str);
        return null;
	}

	private Object EvalPathAp(PathObj pathObj) {
		tablecount++;
		
        graph.put(curr_var,new Nodes(tablecount));
        NodeTable t=new NodeTable();
        t.fors.put(curr_var,pathObj.str);
        info.put(tablecount,t);
        return null;
	}

	private ArrayList<Node> EvalXqJoin(XQObj xq2) {
    	   ArrayList<Node> tableLeft=EvalXq(xq2.xqLeft);
           ArrayList<Node> tableRight=EvalXq(xq2.xqRight);
           ArrayList<String> joinLeft = xq2.leftList;
           
           ArrayList<String> joinRight = xq2.rightList;
           
           HashMap<NodeWrapper,ArrayList<Node>> joinTable=new HashMap<NodeWrapper,ArrayList<Node>>();
           ArrayList<Node> result=new ArrayList<Node>();
           
           if(joinLeft.size()>0){       	   
               for(Node n:tableLeft){          	   
                ArrayList<Node> key=new ArrayList<Node>();
                Element e=(Element)n;
                for(String s:joinLeft){
                    Node x=e.getElementsByTagName(s).item(0);                   
                    if (x.getChildNodes().getLength()>0){
                        key.add(x.getChildNodes().item(0));                                              
                }}

                NodeWrapper nodewrapper=new NodeWrapper(key);
                if (!joinTable.containsKey(nodewrapper)){
                    ArrayList<Node> val=new ArrayList<Node>();
                    val.add(n);
                    joinTable.put(nodewrapper,val);
                   
                }
                else{
                    joinTable.get(nodewrapper).add(n);
                }

               }

               for(Node n:tableRight){
                    ArrayList<Node> key=new ArrayList<Node>();
                    Element e=(Element)n;
                    for(String s:joinRight){
                        
                        Node child=e.getElementsByTagName(s).item(0);
                        if (child.getChildNodes().getLength()>0)
                            key.add(child.getChildNodes().item(0));
                    }
                    NodeWrapper nodewrapper=new NodeWrapper(key);
                    if(joinTable.containsKey(nodewrapper)){
                        
                        ArrayList<Node> vals=joinTable.get(nodewrapper);
                        for(Node value:vals){
                            Node clonenode=n.cloneNode(true);
                            result.add(makeNode("tuple",value,clonenode));
                        }
                    }
                }
            }
            else{               
                for(Node a:tableLeft){
                    for(Node b:tableRight){
                        Node c=b.cloneNode(true);
                        result.add(makeNode("tuple",a,b));
                    }
                }
            }

            return result;
	}

	private ArrayList<Node> EvalLet(XQObj xq2) {
    	Ctx c;
        if(stackContext.empty()){
            c=new Ctx();
        }
        else{
            c=new Ctx(stackContext.peek());
        }

        stackContext.push(c);
        EvalLet(xq2.l);
        ArrayList<Node> answer=EvalXq(xq2.xqLeft);
        stackContext.pop();

        return answer;
	}

    // Evaluate FLWR
	private ArrayList<Node> EvalFLWR(XQObj xq1) {
		
		// Evaluate for clause
		EvalFor(xq1.f);
        ArrayList<Ctx> ac= ctxList.pop();
        ArrayList<Node> answer=new ArrayList<Node>();
        for (Ctx c: ac){
            stackContext.push(c);
            
            if (xq1.l!=null){       
            	EvalLet(xq1.l);          	
            
            ArrayList<Ctx> ac1= ctxList.pop();
            for (Ctx c1: ac1){
            	stackContext.push(c1);
            if (xq1.w!=null){            	
                		if(EvalWhere(xq1.w).size()>0){                    	
                answer.addAll(EvalReturn(xq1.r));            	
            }
                		}
            else if(xq1.w==null){
                answer.addAll(EvalReturn(xq1.r));
            }
            stackContext.pop();}
            }
            else{
            	if (xq1.w!=null){
            		if(EvalWhere(xq1.w).size()>0){
                	
            answer.addAll(EvalReturn(xq1.r));
        	
        }
            		}
        else if(xq1.w==null){
            answer.addAll(EvalReturn(xq1.r));
        }
            }
            
            stackContext.pop();
            
        }
        
        return answer;
	}

	// Evaluate where clause
	private ArrayList<Node> EvalWhere(WObj w) {
		return EvalCond(w.c);
	}

	// Evaluate let clause
	private void EvalLet(LObj l) {
		Ctx ctxlet;
        if(stackContext.empty()){
        	ctxlet=new Ctx();
        }
        else{
        	ctxlet=new Ctx(stackContext.peek());
        }

        ArrayList<Ctx> letlist= new ArrayList<Ctx>();
        letlist.add(ctxlet);

		for(int i=0;i<l.var.size();i++){
            ArrayList<Ctx> store=new ArrayList<Ctx>();
            for (Ctx x:letlist){
                stackContext.push(x);
                ArrayList<Node> rarray=EvalXq(l.x.get(i));
                if (rarray.size()>0){
                    for (Node n:rarray){
                        Ctx ctx=new Ctx(x);
                        ArrayList<Node> rarrayStore= new ArrayList<Node>();
                        rarrayStore.add(n);
                        ctx.set(l.var.get(i),rarrayStore);
                        store.add(ctx);
                    }
                }
                else{
                    Ctx ctx=new Ctx(x);
                    ArrayList<Node> rarrayStore= new ArrayList<Node>();
                    ctx.set(l.var.get(i),rarrayStore);
                    store.add(ctx);
                }
                stackContext.pop();
            }
            letlist=store;
        }

        ctxList.push(letlist);
	}
	
	//Evaluate return clause
	private ArrayList<Node> EvalReturn(RObj r) {
		return EvalXq(r.x);
	}

	//Evaluate For clause
	private void EvalFor(ForObj f) {
		Ctx ctxFor;
        if(stackContext.empty()){
        	ctxFor=new Ctx();
        }
        else{
        	ctxFor =new Ctx(stackContext.peek());
        }

        ArrayList<Ctx> rarray= new ArrayList<Ctx>();
        rarray.add(ctxFor);

        for(int i=0;i<f.var.size();i++){
            ArrayList<Ctx> temp=new ArrayList<Ctx>();
            for (Ctx x:rarray){
                stackContext.push(x);
                ArrayList<Node> rarrayStore=EvalXq(f.x.get(i));
                if (rarrayStore.size()>0){
                    for (Node j:rarrayStore){
                        Ctx ctx=new Ctx(x);
                        ArrayList<Node> store= new ArrayList<Node>();
                        store.add(j);
                        ctx.set(f.var.get(i),store);
                        temp.add(ctx);
                    }
                }
                else{
                    Ctx ctx=new Ctx(x);
                    ArrayList<Node> c= new ArrayList<Node>();
                    ctx.set(f.var.get(i),c);
                    temp.add(ctx);
                }
                stackContext.pop();
            }
            rarray=temp;
        }

	
        ctxList.push(rarray);
       
		
	}

	private ArrayList<Node> xqTag(XQObj xq) {
		ArrayList<Node> answer=new ArrayList<Node>();
        Document newdoc;
        try{
        	DocumentBuilderFactory docInstance = DocumentBuilderFactory.newInstance();
        	newdoc = docInstance.newDocumentBuilder().newDocument();
            Element node = newdoc.createElement(xq.tag);
            newdoc.appendChild(node);
            doctree=newdoc;
        ArrayList<Node> children=EvalXq(xq.xqLeft);
        for(int i=0;i<children.size();i++){
       		if(children.get(i) instanceof Attr){
                Node x=newdoc.importNode(children.get(i),true);
			    node.setAttribute(x.getNodeName(),x.getNodeValue());
            }
		else
			node.appendChild(newdoc.importNode(children.get(i),true));
        }
        answer.add(node);
        }catch (Exception ex) {
        ex.printStackTrace();
    }
        return answer;
	}

	private ArrayList<Node> xqStr(XQObj xq) {
		String s=xq.text.trim();
        
        ArrayList<Node> answer=new ArrayList<Node>();
        try{
        	DocumentBuilderFactory docInstance =  DocumentBuilderFactory.newInstance();
            Document doctree = docInstance.newDocumentBuilder().newDocument();
            Text t= doctree.createTextNode(s.substring(1,s.length()-1));
            answer.add(t);
        }catch (Exception ex) {
        ex.printStackTrace();
        }
        return answer;
	}

	private ArrayList<Node> xqVar(XQObj xq) {
		Ctx c;
        if (!stackContext.empty()){
            c= stackContext.peek();
        }
        else{
            return (new ArrayList<Node>());
        }
        String s= xq.text;
        ArrayList<Node> answer=c.get(s);
        if (answer!=null)
            return answer;
        else
            return (new ArrayList<Node>());
	}

	private ArrayList<Node> xqComma(XQObj xq) {
		Ctx c;
        if(!stackContext.empty()){
            c= stackContext.peek();
        }
        else{
            c=null;
        }
        ArrayList<Node> answer=new ArrayList<Node>();
        ArrayList<Node> xnode;
        if(!stack.empty()){
            xnode=stack.peek();
        }
        else{
            xnode=null;
        }
        ArrayList<Node> temp=EvalXq(xq.xqLeft);
        answer.addAll(temp);
        if (xnode!=null){
            if (stack.empty() || !stack.peek().equals(xnode))
                stack.push(xnode);
        }
        else{
            if (!stack.empty())
                stack.pop();
        }
        if (c!=null){
            if (stackContext.empty() ||!stackContext.peek().equals(c))
                stackContext.push(c);
        }
        else{
            if (!stackContext.empty())
                stackContext.pop();
        }
        temp=EvalXq(xq.xqRight);
        answer.addAll(temp);
        return answer;
	}

	private ArrayList<Node> xqDSlash(XQObj xq) {
        ArrayList<Node> answer=new ArrayList<Node>();
        ArrayList<Node> xnode=EvalXq(xq.xqLeft);
        for(int i=0;i<xnode.size();i++){
            ArrayList<Node> nodes = selfSlashChild(xnode.get(i));
            stack.push(nodes);
            answer.addAll(EvalRp(xq.rp));
        }
        return compareNode(answer);
	}

	private ArrayList<Node> xqSlash(XQObj xq) {
		ArrayList<Node> xnode=EvalXq(xq.xqLeft);
        stack.push(xnode);
        return compareNode(EvalRp(xq.rp));
	}

	private ArrayList<Node> EvalAp(APObj ap) {
    	try{
    		DocumentBuilderFactory docBuilder = DocumentBuilderFactory.newInstance();
    		
    	Document doc = docBuilder.newDocumentBuilder().parse(new FileInputStream(ap.filename));
        doctree=doc;
        
    	}catch (Exception e){
                e.printStackTrace();
        }
        if(ap.text.equalsIgnoreCase("/")){
        	ArrayList<Node> root=new ArrayList<Node>();
            root.add(doctree.getDocumentElement().getParentNode());
            stack.push(root);
        }
        if(ap.text.equalsIgnoreCase("//")){
        	ArrayList<Node> nodes = selfSlashChild(doctree.getDocumentElement().getParentNode());
            stack.push(nodes);
        }
        
        ArrayList<Node> rpRes = EvalRp(ap.rp);
        return compareNode(rpRes);
		
	}
	
    private ArrayList<Node> EvalRp(RPObj rp) {
    	switch(rp.text){
		case "*": return rpStar(rp);
		case ".": return rpDot(rp);
		case "..": return rpDDot(rp);
		case "text()": return rpTxt(rp);
		case "/": return rpSlash(rp);
		case "//": return rpDSlash(rp);
		case ",": return rpComma(rp);
		case "()": return EvalRp(rp.rpLeft);
		case "[]": return rpF(rp);
		default:if(rp.text.startsWith("@")){
			return rpAtt(rp);
		}
		else return rpTag(rp);
		}
		
	}

    // Evaluate rp tag
    private ArrayList<Node> rpTag(RPObj rp) {
    	ArrayList<Node> rpNode;
    	ArrayList<Node> answer=new ArrayList<Node>();
        if(!stack.empty())
        	rpNode=stack.pop();
        else{
        	rpNode=new ArrayList<Node>();
            rpNode.add(doctree.getDocumentElement());
        }

        for(int i=0;i<rpNode.size();i++){   
            NodeList rplist=rpNode.get(i).getChildNodes();
            for(int j=0; j<rplist.getLength(); j++){
                Node node = rplist.item(j);
                if(node instanceof Element){              	
                    Element child=(Element)node;
                    if (child.getNodeName().equalsIgnoreCase(rp.text))
                    {    answer.add(node);
                    }
                }
            }
        }
        return answer;
	}

    // Evaluate rp attribute
	private ArrayList<Node> rpAtt(RPObj rp) {
		ArrayList<Node> rpNode=stack.pop();
        ArrayList<Node> answer=new ArrayList<Node>();
        for(int i=0;i<rpNode.size();i++){
            if (rpNode.get(i).hasAttributes()){
                NamedNodeMap n=rpNode.get(i).getAttributes();
                Node r = n.getNamedItem(rp.text.substring(1));
                if (n!=null){
                    answer.add(r);
                }
            }
        }
        return answer;
    }
	
    // Evaluate Filter
	private ArrayList<Node> rpF(RPObj rp) {
        ArrayList<Node> answer=new ArrayList<Node>();
    	ArrayList<Node> rpNode=EvalRp(rp.rpLeft);

        for(int i=0;i<rpNode.size();i++){

            ArrayList<Node> temp=new ArrayList<Node>();
            temp.add(rpNode.get(i));
            stack.push(temp);
            if(EvalF(rp.fObj).size()>0){
                answer.add(rpNode.get(i));
            }
            if(stack.isEmpty() == false)
            stack.pop();

        }
        return answer;
	}

	// Evaluate rp comma
	private ArrayList<Node> rpComma(RPObj rp) {
    	ArrayList<Node> answer=new ArrayList<Node>();
        ArrayList<Node> rpNode;
        if(!stack.empty()){
        	rpNode=stack.peek();
        }
        else{
        	rpNode=null;
        }
        ArrayList<Node> commaArray=EvalRp(rp.rpLeft);
        answer.addAll(commaArray);
        if (rpNode!=null){
            if (stack.empty() || !stack.peek().equals(rpNode))
                stack.push(rpNode);
        }
        else{
            if (!stack.empty())
                stack.pop();
        }
        commaArray=EvalRp(rp.rpRight);
        answer.addAll(commaArray);
        return answer;
	}

	private ArrayList<Node> rpDSlash(RPObj rp) {
        ArrayList<Node> answer=new ArrayList<Node>();
    	ArrayList<Node> rpNode=EvalRp(rp.rpLeft);
        for(int i=0;i<rpNode.size();i++){
            ArrayList<Node> nodes = selfSlashChild(rpNode.get(i));
            stack.push(nodes);
            answer.addAll(EvalRp(rp.rpRight));
        }

        return compareNode(answer);
	}

	private ArrayList<Node> rpSlash(RPObj rp) {
		ArrayList<Node> rpNode=EvalRp(rp.rpLeft);
        stack.push(rpNode);
        return compareNode(EvalRp(rp.rpRight));
	}

	private ArrayList<Node> rpTxt(RPObj rp) {
    	ArrayList<Node> rpNode=stack.pop();
        ArrayList<Node> answer=new ArrayList<Node>();
        for(int i=0;i<rpNode.size();i++){
            NodeList rpArray=rpNode.get(i).getChildNodes();
            for(int j=0; j<rpArray.getLength(); j++){
                Node node = rpArray.item(j);
                if((node instanceof Text)){
                    answer.add(node);
                }
            }
        }
        return answer;
	}

	// Evaluate rp parent
	private ArrayList<Node> rpDDot(RPObj rp) {
    	ArrayList<Node> rpNode=stack.pop();
    	ArrayList<Node> answer=new ArrayList<Node>();
        for(int i=0;i<rpNode.size();i++){
            answer.add(rpNode.get(i).getParentNode());
        }
        return answer;
	}

	// Evaluate rp current
	private ArrayList<Node> rpDot(RPObj rp) {
		ArrayList<Node> rpNode=stack.pop();
        return rpNode;
	}

	// Evaluate rp star
	private ArrayList<Node> rpStar(RPObj rp){
        ArrayList<Node> answer=new ArrayList<Node>();
		ArrayList<Node> rpNode=stack.pop();
        for(int i=0;i<rpNode.size();i++){
            NodeList rpArray=rpNode.get(i).getChildNodes();
            for(int j=0; j<rpArray.getLength(); j++){
                Node node = rpArray.item(j);
                if(node instanceof Element){
                    answer.add(node);
                }
            }
        }
        return answer;
    	
    }
	
    private ArrayList<Node> EvalF(FObj f) {
    	if(f.text!=null){
    	switch(f.text){
		case "AND": return fAnd(f);
		case "OR": return fOr(f);
		case "NOT": return fNot(f);
		case "EQUAL": return fEqual(f);
		case "IS": return fIs(f);
		case "()": return EvalF(f.fLeft);
		}
    	}
    	else
    		return EvalRp(f.rpLeft);
		return null;
    	
	}
    
    private ArrayList<Node> fIs(FObj f) {
    	ArrayList<Node> rpNode;
        if(!stack.empty()){
        	rpNode=stack.peek();
        }
        else{
        	rpNode=null;
        }
        ArrayList<Node> outer=EvalF(f.fLeft);
        if (rpNode!=null){
            if (stack.empty() || !stack.peek().equals(rpNode))
                stack.push(rpNode);
        }
        else{
            if (!stack.empty())
                stack.pop();
        }
        ArrayList<Node> inner=EvalF(f.fRight);
        for(Node n:outer){
            for (Node t:inner){
                if(n.isSameNode(t)){
                    ArrayList<Node> answer=new ArrayList<Node>();
                    answer.add(t);
                    return answer;
                }
            }
        }
        return (new ArrayList<Node>());
	}

	private ArrayList<Node> fEqual(FObj f) {
		ArrayList<Node> fNode;
        if(!stack.empty()){
        	fNode=stack.peek();
        }
        else{
            fNode=null;
        }
        ArrayList<Node> outer=EvalF(f.fLeft);
        if (fNode!=null){
            if (stack.empty() || !stack.peek().equals(fNode))
                stack.push(fNode);
        }
        else{
            if (!stack.empty())
                stack.pop();
        }
        ArrayList<Node> inner=EvalF(f.fRight);
        for(Node i:outer){
            for (Node j:inner){
                if(i.isEqualNode(j)){
                    ArrayList<Node> answer=new ArrayList<Node>();
                    answer.add(j);
                    return answer;
                }
            }
        }
        return (new ArrayList<Node>());
	}

	private ArrayList<Node> fNot(FObj f) {
		ArrayList<Node> list=EvalF(f);
        if(list.size()>0){
            return (new ArrayList<Node>());
        }
        list.add(doctree.getDocumentElement());
        return list;
	}

	private ArrayList<Node> fOr(FObj f) {
		ArrayList<Node> fNode;
        if(!stack.empty()){
            fNode=stack.peek();
        }
        else{
            fNode=null;
        }
        ArrayList<Node> comp1=EvalF(f.fLeft);
        if (fNode!=null){
            if (stack.empty() || !stack.peek().equals(fNode))
                stack.push(fNode);
        }
        else{
            if (!stack.empty())
                stack.pop();
        }
        ArrayList<Node> comp2=EvalF(f.fRight);
       
        if(comp1.size()>0 || comp2.size()>0){
            comp1.add(doctree.getDocumentElement());
            return comp1;
        }
        return (new ArrayList<Node>());
	}

	private ArrayList<Node> fAnd(FObj f) {
		ArrayList<Node> fNode;
        if(!stack.empty()){
        	fNode=stack.peek();
        }
        else{
        	fNode=null;
        }
        ArrayList<Node> comp1=EvalF(f.fLeft);
        if (fNode!=null){
            if (stack.empty() || !stack.peek().equals(fNode))
                stack.push(fNode);
        }
        else{
            if (!stack.empty())
                stack.pop();
        }
        ArrayList<Node> comp2=EvalF(f.fRight);
        if(comp1.size()>0 && comp2.size()>0){
            comp1.add(doctree.getDocumentElement());
            return comp1;
        }
        return (new ArrayList<Node>());
	}

	private ArrayList<Node> EvalCond(CObj c) {
		if(c.text!=null){
		switch(c.text){
		case "AND": return cAnd(c);
		case "OR": return cOr(c);
		case "NOT": return cNot(c);
		case "EQUAL": return cEqual(c);
		case "IS": return cIs(c);
		case "()": return EvalCond(c.condLeft);
		case "EMPTY" : return EvalECond(c);
		case "SOME":if(c.s!=null){
			return EvalSCond(c);
		}
    	}}
		
		return null;
	}
	
	//Evaluate some condition
    private ArrayList<Node> EvalSCond(CObj co) {
        List<SObj> s=(List<SObj>) co.s;
    	Ctx c;
        if(stackContext.empty()){
            c=new Ctx();
        }
        else{
            c=new Ctx(stackContext.peek());
        }
        
        stackContext.push(c);  
        
        for(int i=0;i<s.size();i++){
            ArrayList<Node> list=EvalXq(s.get(i).x);
            c=stackContext.pop();
            c.set(s.get(i).var,list);
            stackContext.push(c);
        }
        
        ArrayList<Node> answer=EvalCond(co.condLeft);
        stackContext.pop();
        
        return answer;
	}

	private ArrayList<Node> EvalECond(CObj co) {
		
        ArrayList<Node> list=EvalXq(co.xqLeft);
        if(list.size()>0){
                return (new ArrayList<Node>());
        }
        list.add(doctree.getDocumentElement());
        return list;
	}

	private ArrayList<Node> cIs(CObj co) {
		Ctx c;
        if(!stackContext.empty()){
            c= stackContext.peek();
        }
        else{
            c=null;
        }
        ArrayList<Node> answer=new ArrayList<Node>();
        ArrayList<Node> cond1=EvalXq(co.xqLeft);
        if (c!=null){
            if (stackContext.empty() ||!stackContext.peek().equals(c))
                stackContext.push(c);
        }
        else{
            if (!stackContext.empty())
                stackContext.pop();
        }
        ArrayList<Node> cond2=EvalXq(co.xqRight);
        for(Node n:cond1){
            for (Node t:cond2){
                if(n.isSameNode(t)){
                    answer.add(t);
                    return answer;
                }
            }
        }
        return (new ArrayList<Node>());
	}

	private ArrayList<Node> cEqual(CObj co) {
		Ctx c;
        if(!stackContext.empty()){
            c= stackContext.peek();
        }
        else{
            c=null;
        }
        ArrayList<Node> answer=new ArrayList<Node>();
        ArrayList<Node> cond1=EvalXq(co.xqLeft);
        if (c!=null){
            if (stackContext.empty() ||!stackContext.peek().equals(c))
                stackContext.push(c);
        }
        else{
            if (!stackContext.empty())
                stackContext.pop();
        }
        ArrayList<Node> cond2=EvalXq(co.xqRight);
        
        for(Node n:cond1){
            for (Node t:cond2){
                if(n.isEqualNode(t)){
                    answer.add(t);
           
                    return answer;
                }
            }
        }
        
        return (new ArrayList<Node>());
	}

	private ArrayList<Node> cNot(CObj co) {
        ArrayList<Node> list=EvalCond(co.condLeft);
        if(list.size()>0){
                return (new ArrayList<Node>());
        }
        list.add(doctree.getDocumentElement());
        return list;
	}

	private ArrayList<Node> cOr(CObj co) {
		Ctx c;
        if(!stackContext.empty()){
            c= stackContext.peek();
        }
        else{
            c=null;
        }
        ArrayList<Node> cond1=EvalCond(co.condLeft);
        if (c!=null){
            if (stackContext.empty() ||!stackContext.peek().equals(c))
                stackContext.push(c);
        }
        else{
            if (!stackContext.empty())
                stackContext.pop();
        }
        ArrayList<Node> cond2=EvalCond(co.condRight);
        if(cond1.size()>0 || cond2.size()>0){
                cond1.add(doctree.getDocumentElement());
                return cond1;
        }
        return (new ArrayList<Node>());
	}

	private ArrayList<Node> cAnd(CObj co) {
		Ctx c;
        if(!stackContext.empty()){
            c= stackContext.peek();
        }
        else{
            c=null;
        }
        ArrayList<Node> cond1=EvalCond(co.condLeft);
        if (c!=null){
            if (stackContext.empty() ||!stackContext.peek().equals(c))
                stackContext.push(c);
        }
        else{
            if (!stackContext.empty())
                stackContext.pop();
        }
        ArrayList<Node> cond2=EvalCond(co.condRight);
        if(cond1.size()>0 && cond2.size()>0){
                cond1.add(doctree.getDocumentElement());
                return cond1;
        }
        return (new ArrayList<Node>());
	}

	private ArrayList<Node> selfSlashChild(Node n){
        ArrayList<Node> nodes = new ArrayList<Node>();
        Stack <Node> sc = new Stack <Node>();
        sc.push(n);
        while (!sc.isEmpty()) {
          Node node = sc.pop();
          nodes.add(node);
          NodeList children = node.getChildNodes();
          for (int i = children.getLength() - 1; i >=0 ; i--) {
            sc.push(children.item(i));
          }
        }

        return nodes;
    }
    public static ArrayList<Node> compareNode(ArrayList<Node> nodes) {
        return new ArrayList<Node>(new LinkedHashSet<Node>(nodes));
        }
    public Node makeNode(String name,Node a, Node b){
    	try{
    		NodeList children1=a.getChildNodes();
            for(int i=0;i<children1.getLength();i++){
            	 b.appendChild(b.getOwnerDocument().importNode(children1.item(i),true));
            }
    	}catch (Exception ex) {
            ex.printStackTrace();
        }
        return b;
      }
    	
    
}