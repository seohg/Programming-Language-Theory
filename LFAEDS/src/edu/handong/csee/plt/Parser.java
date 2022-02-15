package edu.handong.csee.plt;

import java.util.ArrayList;

import edu.handong.csee.plt.ast.*;

public class Parser {
	boolean dynamic = false;

	AST parse(String exampleCode) {
		if (exampleCode.contains("dsfun")){
			dynamic = true;
		}

		ArrayList<String> subExpressions = splitExpressionAsSubExpressions(exampleCode);

		// num
		if(subExpressions.size() == 1 && isNumeric(subExpressions.get(0))) {

			return new Num(subExpressions.get(0));
		}

		// add
		if(subExpressions.get(0).equals("+")) {
			
			return new Add(parse(subExpressions.get(1)),parse(subExpressions.get(2)));
		}
		
		// sub
		if(subExpressions.get(0).equals("-")) {
			
			return new Sub(parse(subExpressions.get(1)),parse(subExpressions.get(2)));
		}

		// with
		if(subExpressions.get(0).equals("with")&& !dynamic) {
			ArrayList<String> tlist = splitExpressionAsSubExpressions(subExpressions.get(1));
			Fun fun = new Fun(tlist.get(0), parse(subExpressions.get(2)));
			return new App(fun, parse(tlist.get(1)));
		}
		// dswith
		if(subExpressions.get(0).equals("with")&& dynamic) {
			ArrayList<String> tlist = splitExpressionAsSubExpressions(subExpressions.get(1));
			Dsfun dsfun = new Dsfun(tlist.get(0), parse(subExpressions.get(2)));
			return new DsApp(dsfun, parse(tlist.get(1)));
		}

		// id
		if(subExpressions.size() == 1 && isAlphabet(subExpressions.get(0))) {

			return new Id(subExpressions.get(0));
		}
		// fun
		if(subExpressions.get(0).equals("fun")) {
			ArrayList<String> tlist = splitExpressionAsSubExpressions(subExpressions.get(1));
			return new Fun(tlist.get(0), parse(subExpressions.get(2)));
		}
		// dsfun
		if(subExpressions.get(0).equals("dsfun")) {
			dynamic = true;
			ArrayList<String> tlist = splitExpressionAsSubExpressions(subExpressions.get(1));
			return new Dsfun(tlist.get(0), parse(subExpressions.get(2)));
		}
		// app
		if(subExpressions.size() == 2 && !dynamic) {
			
			return new App(parse(subExpressions.get(0)),parse(subExpressions.get(1)));
		}
		//dsApp
		if(subExpressions.size() == 2 && dynamic) {
			
			return new DsApp(parse(subExpressions.get(0)),parse(subExpressions.get(1)));
		}
				
		return null;

	}

	private ArrayList<String> splitExpressionAsSubExpressions(String exampleCode) {

		// deal with brackets first.
		if((exampleCode.startsWith("{") && !exampleCode.endsWith("}"))
				|| (!exampleCode.startsWith("{") && exampleCode.endsWith("}"))) {
			System.out.println("Syntax error");
			System.exit(0);
		}

		if(exampleCode.startsWith("{"))
			exampleCode = exampleCode.substring(1, exampleCode.length()-1);


		return getSubExpressions(exampleCode);
	}



	/**
	 * This method return a list of sub-expression from the given expression.
	 * For example, {+ 3 {+ 3 4}  -> +, 2, {+ 3 4}
	 * TODO JC was sleepy while implementing this method...it has complex logic and might be buggy...
	 * You can do better or find an external library.
	 * @param exampleCode
	 * @return list of sub expressions 
	 */
	private ArrayList<String> getSubExpressions(String exampleCode) {

		ArrayList<String> sexpressions = new ArrayList<String>();
		int openingParenthesisCount = 0;
		String strBuffer = "";
		for(int i=0; i < exampleCode.length()  ;i++) {
			if(i==0 || (i==0 && exampleCode.charAt(i) == '{')) { //opening Parenthesis
				strBuffer = strBuffer + exampleCode.charAt(i);
				if(exampleCode.charAt(i)=='{'){
					openingParenthesisCount++;
				}
				continue;
			} else if(exampleCode.charAt(i)==' ' && openingParenthesisCount==0){ // if it is space
				// buffer is ready to be a subexpression
				if(!strBuffer.isEmpty()) {
					sexpressions.add(strBuffer);
					strBuffer = ""; // Ready to start a new buffer
				}
				continue;
			} else {
				if(exampleCode.charAt(i)=='{' && openingParenthesisCount==0){
					openingParenthesisCount++;
					// Ready to start a new buffer
					strBuffer = "" + exampleCode.charAt(i);
					continue;
				} else if(exampleCode.charAt(i)=='{') {
					openingParenthesisCount++;
					strBuffer = strBuffer + exampleCode.charAt(i);
					continue;
				} else if(exampleCode.charAt(i)=='}' && openingParenthesisCount>0) {
					openingParenthesisCount--;
					strBuffer = strBuffer + exampleCode.charAt(i);
					continue;
				} else if(exampleCode.charAt(i)=='}') {
					// buffer is ready to be a subexpression
					sexpressions.add(strBuffer);
					continue;
				}
			}
			strBuffer = strBuffer + exampleCode.charAt(i);
		}
		
		sexpressions.add(strBuffer);

		return sexpressions;
	}

	public static boolean isNumeric(String str)
	{
		return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
	}

	public static boolean isAlphabet(String str)
	{
		return str.matches("[a-zA-Z]");  //match a number with optional '-' and decimal.
	}

}
