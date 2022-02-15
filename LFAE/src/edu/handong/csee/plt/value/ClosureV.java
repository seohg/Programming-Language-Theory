package edu.handong.csee.plt.value;
import edu.handong.csee.plt.ast.*;
import edu.handong.csee.plt.defrdsub.*;


public class ClosureV extends Value{

	String param = "";
	AST body = new AST();
	DefrdSub ds = new DefrdSub();

	public ClosureV(String param, AST body, DefrdSub ds) {
		this.param = param;
		this.body = body;
		this.ds = ds;
	}
	public String getParam(){
		return param;
	}
	public AST getBody(){
		return body;
	}
	public DefrdSub getDs(){
		return ds;
	}
	public String getValueCode() {
		return "(closureV '" + param + " " + body.getASTCode()+ " " + ds.getSubCode()+ ")";
	}
}

