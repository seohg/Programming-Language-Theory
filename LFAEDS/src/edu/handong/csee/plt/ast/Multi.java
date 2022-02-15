package edu.handong.csee.plt.ast;

public class Multi extends AST{
	AST lhs = new AST();
	AST rhs = new AST();
	
	public Multi(AST lhs, AST rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	public AST getLhs() {
		return lhs;
	}

	public AST getRhs() {
		return rhs;
	}

	public String getASTCode() {
		return "(mul " + lhs.getASTCode() + " " + rhs.getASTCode() + ")";
	}
}

