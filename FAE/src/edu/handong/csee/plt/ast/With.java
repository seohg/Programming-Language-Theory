package edu.handong.csee.plt.ast;

public class With extends AST{
	String i;
	AST v = new AST();
	AST e = new AST();

	public With(String i, AST v, AST e) {
		this.i = i;
		this.v = v;
		this.e = e;
	}
	
	public String getI() {
		return i;
	}

	public AST getV() {
		return v;
	}

	public AST getE() {
		return e;
	}

	public String getASTCode() {
		return "(with '" + i + " " + v.getASTCode() + " " + e.getASTCode() + ")";
	}
}

