package edu.handong.csee.plt;

import edu.handong.csee.plt.ast.*;
import edu.handong.csee.plt.value.*;
import edu.handong.csee.plt.defrdsub.*;
import java.util.Vector;

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
			Strict strict = new Strict();
			ClosureV fval= (ClosureV)strict.strict(interp(app.getF(),ds));
			ExprV aval = new ExprV(app.getA(),ds,new Vector<Value>());
			ASub asub = new ASub(fval.getParam(),(Value)interp(app.getA(),ds),fval.getDs());
			return interp(fval.getBody(), asub);
		}
		return null;
	}
}
