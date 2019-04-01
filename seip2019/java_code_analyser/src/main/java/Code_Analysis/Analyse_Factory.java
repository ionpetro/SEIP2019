package Code_Analysis;

import Analysers.*;
//Factory
public class Analyse_Factory {
	
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
