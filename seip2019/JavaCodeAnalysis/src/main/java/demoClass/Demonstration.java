package demoClass;

import codeAnalyser.*;
/**
 * This class is written as a Demonstration class for the project.
 */
public class Demonstration {

	/**
	 * Main method
	 * 
	 * @param args[0] File source to be read
	 * @param args[1] Type of analysis (string or regex)
 	 * 
	 */
	public static void main(String[] args) {
		
		CodeAnalyser codeAnalyse = new CodeAnalyser();
		String source = args[0];
		String type_of_analysis = args[1];
		codeAnalyse.analyse_code(source, type_of_analysis);

	}

}