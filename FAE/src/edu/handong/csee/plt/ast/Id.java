package edu.handong.csee.plt.ast;

public class Id extends AST {
	String id = "x";
	
	public Id(String id){
		this.id = id;
	}
	
	public String getStrId() {
		return id;
	}
	
	public String getASTCode() {
		return "(id '" + id +")";
	}
}
