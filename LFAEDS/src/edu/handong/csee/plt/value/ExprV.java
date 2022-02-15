package edu.handong.csee.plt.value;
import edu.handong.csee.plt.ast.*;
import edu.handong.csee.plt.defrdsub.*;
import java.util.Vector;

public class ExprV extends Value{

	AST expr = new AST();
	DefrdSub ds = new DefrdSub();
	Vector<Value> value = new Vector<Value>();

	public ExprV(AST expr, DefrdSub ds, Vector<Value> value) {
		this.expr = expr;
		this.ds = ds;
		this.value = value;
	}

	public AST getExpr(){
		return expr;
	}
	public DefrdSub getDs(){
		return ds;
	}
	public Vector<Value> getValue(){
		return value;
	}
	public void setValue(int idx, Value val){
		if (value.isEmpty()){
			value.add(val);
		}else{
			value.set(idx,val);
		}
	}
	public String getValueCode() {
		return "(exprV " + expr.getASTCode() + " " + ds.getSubCode()+ " " + value.get(0).getValueCode()+ ")";
	}
}

