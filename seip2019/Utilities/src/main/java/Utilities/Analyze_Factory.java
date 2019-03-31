package Utilities;

//Factory
public class Analyze_Factory {
	
	public General_Analyzer choose_analyzer(String type_of_analysis) {
		if(type_of_analysis.equals("regex")) {
			return new RegexAnalyzer();
		} else if(type_of_analysis.equals("string")) {
			return new StringAnalyzer();
		} else {
			return null;
		}
		
	}
}
