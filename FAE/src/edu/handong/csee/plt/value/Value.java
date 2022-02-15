package edu.handong.csee.plt.value;
import edu.handong.csee.plt.ast.*;
import edu.handong.csee.plt.defrdsub.*;


public class Value {
	
	public String getValueCode() {
		String valueCode="";
		if(this instanceof NumV)
            valueCode = ((NumV)this).getValueCode();

		if(this instanceof ClosureV)
            valueCode = ((ClosureV)this).getValueCode();

		return valueCode;
	}
}

