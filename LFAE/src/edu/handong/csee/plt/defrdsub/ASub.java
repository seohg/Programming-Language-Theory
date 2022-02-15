package edu.handong.csee.plt.defrdsub;
import edu.handong.csee.plt.ast.*;
import edu.handong.csee.plt.value.*;

public class ASub extends DefrdSub{

	String name="";
	Value value = new Value();
	DefrdSub ds =  new DefrdSub();

	public ASub(String name, Value value, DefrdSub ds) {
		this.name = name;
		this.value = value;
		this.ds = ds;
	}
	public String getName() {
		return name;
	}
	public Value getValue() {
		return value;
	}
	public DefrdSub getDs() {
		return ds;
	}

	public String getSubCode() {
		return "(ASub " + name + " " + value.getValueCode() + " " + ds.getSubCode() +" )";
	}
}

