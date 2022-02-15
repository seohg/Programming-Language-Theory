package edu.handong.csee.plt.value;
import edu.handong.csee.plt.ast.*;
import edu.handong.csee.plt.defrdsub.*;

public class NumV extends Value{
	
	String numV = "0";
	
	public NumV(String numV){
		this.numV = numV;
	}
	
	public String getStrNum() {
		return numV;
	}
	
	public String getValueCode() {
		return "(numV " + numV+")";
	}
}

