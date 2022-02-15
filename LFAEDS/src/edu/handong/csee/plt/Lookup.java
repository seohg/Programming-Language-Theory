package edu.handong.csee.plt;
import edu.handong.csee.plt.ast.*;
import edu.handong.csee.plt.defrdsub.*;
import edu.handong.csee.plt.value.*;

public class Lookup {

	public Value lookup(String name, DefrdSub ds) {
		
		if(ds instanceof MtSub) {
			System.out.println("no binding for identifier");
			System.exit(0);
		}
		
		if(ds instanceof ASub) {
            ASub ads = (ASub)ds;
			Strict strict = new Strict();
            if ((ads.getName()).equals(name)){
                return strict.strict(ads.getValue());
            }else{
                return lookup(name, ads.getDs());
            }
		}

		return null;
	}
}
