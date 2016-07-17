import java.util.ArrayList;

public class XQObj{
    public String text;
    public String tag;
    
    public RPObj rp;
    public XQObj xqLeft;
    public XQObj xqRight;
    public APObj ap;
    public ForObj f;
    public LObj l;
    public WObj w;
    public RObj r;
    public ArrayList<String> leftList;
    public ArrayList<String> rightList;
    public ForJObj fj;
    public CJObj cj;
    public RJObj rj;
    public XQObj(String text, String opentag, XQParser.RpContext rp,XQParser.XqContext xqLeft,XQParser.XqContext xqRight, XQParser.ApContext ap,XQParser.ForClauseContext f,XQParser.LetClauseContext l, XQParser.WhereClauseContext w, XQParser.ReturnClauseContext r, ArrayList<String> leftList, ArrayList<String> rightList, XQParser.ForJContext fj,XQParser.CondJContext cj,XQParser.ReturnJContext rj){
        this.text = text;
        this.tag = opentag;       
        this.rp = (RPObj)XQBuilder.BuilderMap.get(rp);
        this.xqLeft = (XQObj)XQBuilder.BuilderMap.get(xqLeft);
        this.xqRight = (XQObj)XQBuilder.BuilderMap.get(xqRight);
        this.ap = (APObj) XQBuilder.BuilderMap.get(ap);
        this.f = (ForObj) XQBuilder.BuilderMap.get(f);
        this.l = (LObj) XQBuilder.BuilderMap.get(l);
        this.w = (WObj) XQBuilder.BuilderMap.get(w);
        this.r = (RObj) XQBuilder.BuilderMap.get(r);
        this.leftList = leftList;
        this.rightList = rightList;
        this.fj = (ForJObj) XQBuilder.BuilderMap.get(fj);
        this.cj = (CJObj) XQBuilder.BuilderMap.get(cj);
        this.rj = (RJObj) XQBuilder.BuilderMap.get(rj);
     }
}
