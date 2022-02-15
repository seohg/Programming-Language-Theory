package edu.handong.csee.plt;

import edu.handong.csee.plt.ast.*;
import edu.handong.csee.plt.value.*;
import edu.handong.csee.plt.defrdsub.*;

public class Interpreter {

	public Value interp(AST ast, DefrdSub ds) {
		if(ast instanceof Num) {
			Num num = (Num)ast;
			return new NumV(num.getStrNum());
		}
		
		if(ast instanceof Add) {
			Add add = (Add)ast;
			NumP nump = new NumP();
			return new NumV(nump.nump(interp(add.getLhs(), ds).getValueCode(),interp(add.getRhs(), ds).getValueCode()));
		}

		if(ast instanceof Sub) {
			Sub sub = (Sub)ast;
			NumM numm = new NumM();

			return new NumV(numm.numm(interp(sub.getLhs(), ds).getValueCode(),interp(sub.getRhs(), ds).getValueCode()));
		
		}

		if(ast instanceof Id) {
			Id id = (Id)ast;
			Lookup lookup = new Lookup();
			return lookup.lookup(id.getStrId(), ds);
		}

		if(ast instanceof Fun) {
			Fun fun = (Fun)ast;
			return new ClosureV(fun.getP(),fun.getB(),ds);
		}

		if(ast instanceof App) {
			App app = (App)ast;
			ClosureV funval= (ClosureV)interp(app.getF(),ds);
			ASub asub = new ASub(funval.getParam(),(Value)interp(app.getA(),ds),funval.getDs());
			return interp(funval.getBody(), asub);
		}
		return null;
	}
}
