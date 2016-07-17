
public class XqsObj{
	public XQObj x;
	public XqsObj( XQParser.XqContext x){
    	
    	this.x = (XQObj)XQBuilder.BuilderMap.get(x);
    }
	public XqsObj(XQParser.OxqContext x) {
		this.x = (XQObj)XQBuilder.BuilderMap.get(x);
	}
}