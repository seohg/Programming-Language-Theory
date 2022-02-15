package edu.handong.csee.plt.ast;

public class Dsfun extends AST{
	String p;
	AST b = new AST();

	public Dsfun(String p, AST b) {
		this.p = p;
		this.b = b;
	}
	
	public String getP() {
		return p;
	}

	public AST getB() {
		return b;
	}

	public String getASTCode() {
		return "(dsfun '" + p + " " + b.getASTCode() + ")";
	}
}

