package edu.handong.csee.plt.ast;

public class DsApp extends AST{
	AST f = new AST();
	AST a = new AST();

	public DsApp(AST f, AST a) {
		this.f = f;
		this.a = a;
	}

	public AST getF() {
		return f;
	}

	public AST getA() {
		return a;
	}

	public String getASTCode() {
		return "(dsapp " + f.getASTCode() + " " + a.getASTCode() + ")";
	}
}

