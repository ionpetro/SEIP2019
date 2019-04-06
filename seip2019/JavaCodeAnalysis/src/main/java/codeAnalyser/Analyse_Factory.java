package codeAnalyser;

import analysers.*;
/**
 * This class represents the design pattern Factory. 
 * We use the Analyse_Factory to get the object of concrete class 
 * by passing an information such as type.
 * @author Ion
 *
 */
public class Analyse_Factory {
	
	/**
	 * This method chechs whether the type of analysis is a string or
	 * a regex and returns the object corresponding to it.
	 * @param type_of_analysis
	 * @return General_Analyser
	 */
	public General_Analyser choose_analyser(String type_of_analysis) {
		if(type_of_analysis.equals("regex")) {
			return new RegexAnalyser();
		} else if(type_of_analysis.equals("string")) {
			return new StringAnalyser();
		} else {
			return null;
		}
		
	}
}
