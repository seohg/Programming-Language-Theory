package edu.handong.csee.plt;

import edu.handong.csee.plt.ast.*;
import edu.handong.csee.plt.defrdsub.*;
import edu.handong.csee.plt.value.*;


public class Main {
	
	static boolean onlyParser = false; // for -p option
	
	public static void main(String[] args) {
		
		String arg="";
		
		if (args.length == 2){
			if (args[0].equals("-p")){
				arg = args[1];
				onlyParser = true;
			}
			if (args[1].equals("-p")){
				arg = args[0];
				onlyParser = true;
			}
		}else{
			arg = args[0];
		}

		// Parser
		Parser parser = new Parser();
		AST ast = parser.parse(arg);
		
		if(ast == null)
			System.out.println("Syntax Error!");
		
		if(onlyParser){
			System.out.println(ast.getASTCode());
		}else{
			// interpreter
			Interpreter interpreter = new Interpreter();
			DefrdSub ds = new DefrdSub();
			
			Value result = interpreter.interp(ast,ds);
			
			System.out.println(result.getValueCode());
		}
	}
}
