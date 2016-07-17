/* Condition Join Object */
public class CJObj{
	public String text;
	public String varLeft;
	public String varRight;
	public String strConst;
    public CJObj cjLeft;
    public CJObj cjRight;

    
    public CJObj(String text,String varLeft, String varRight, String strConst, XQParser.CondJContext cjLeft, XQParser.CondJContext cjRight){
        this.text = text;
        this.varLeft = varLeft;
        this.varRight = varRight;
        this.strConst = strConst;
        this.cjLeft = (CJObj)XQBuilder.BuilderMap.get(cjLeft);
        this.cjRight = (CJObj)XQBuilder.BuilderMap.get(cjRight);       
     }
}