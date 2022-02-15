package edu.handong.csee.plt;

import edu.handong.csee.plt.ast.*;
import edu.handong.csee.plt.value.*;
import edu.handong.csee.plt.defrdsub.*;

public class NumP {

	public String nump(String n1, String n2) {
        
        String num1 = n1.replaceAll("[^\\d]", "");
        String num2 = n2.replaceAll("[^\\d]", "");
        
		return Integer.toString(Integer.parseInt(num1)+Integer.parseInt(num2));
	}
}
