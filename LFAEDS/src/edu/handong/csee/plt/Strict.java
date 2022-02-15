package edu.handong.csee.plt;

import edu.handong.csee.plt.value.*;
import edu.handong.csee.plt.ast.*;
import edu.handong.csee.plt.defrdsub.*;

public class Strict {

	public Value strict(Value v) {
        
		if(v instanceof ExprV) {
			ExprV exprV = (ExprV)v;
            Interpreter interp = new Interpreter();

            if((exprV.getValue()).isEmpty()){
                Value val = strict(interp.interp(exprV.getExpr(), exprV.getDs()));
                exprV.setValue(0,v);
                return val;
            }else{
                return exprV.getValue().get(0);
            }
		}
		
		
		return v;
	}
}
