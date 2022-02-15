package edu.handong.csee.plt.defrdsub;

public class DefrdSub {
	
	public String getSubCode() {
		String subCode="";
		if(this instanceof MtSub)
			subCode = ((MtSub)this).getSubCode();
			
		if(this instanceof ASub)
			subCode = ((ASub)this).getSubCode();

		return subCode;
	}
}

