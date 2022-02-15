package edu.handong.csee.plt;
import edu.handong.csee.plt.ast.*;

public class Subst {

	public AST subst(AST ast, String idtf, String val) {
		
		if(ast instanceof Num) {
			return ast;
		}
		
		if(ast instanceof Add) {
			Add add = (Add)ast;
			return new Add(subst(add.getLhs(),idtf,val),subst(add.getRhs(),idtf,val));
		}

		if(ast instanceof Sub) {
			Sub sub = (Sub)ast;
			return new Sub(subst(sub.getLhs(),idtf,val),subst(sub.getRhs(),idtf,val));
		}

		if(ast instanceof With) {
			With with = (With)ast;
			if((with.getI()).equals(idtf))
				return new With(with.getI(),subst(with.getV(),idtf,val),with.getE());
			else 
				return new With(with.getI(),subst(with.getV(),idtf,val),subst(with.getE(),idtf,val));

		}
		if(ast instanceof Id) {
			Id id = (Id)ast;
			if((id.getStrId()).equals(idtf))
				return new Num(val);
			else
				return ast;
		}

		
		return ast;
	}
}
