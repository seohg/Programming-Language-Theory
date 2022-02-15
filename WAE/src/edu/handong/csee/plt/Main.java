package edu.handong.csee.plt;

import edu.handong.csee.plt.ast.AST;

public class Main {
	
	static boolean onlyParser = false; // for -p option
	
	public static void main(String[] args) {
		
		// This is just an example code. Use args to get -p option and actuall code from CLI
		//String exampleCode = "{+ {+ 2 {+ 3 4}} {+ 1 2}}";
		
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
			
			String result = interpreter.interp(ast);
			
			System.out.println(result);
		}
	}
}
