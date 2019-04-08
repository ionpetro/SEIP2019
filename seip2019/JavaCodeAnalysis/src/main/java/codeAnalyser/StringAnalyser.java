package codeAnalyser;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used in order to analyse a list of strings, using string configuration 
 */
public class StringAnalyser implements GeneralAnalyser {

	/**
	 * Analyse method implements the General_Analyser interface. This method takes
	 * as an input a List of Strings and returns a List of Strings containing number
	 * of classes, number of methods and lines of code.
	 * 
	 * @param List<String> input this is a list of lines of a file
	 */
	public List<String> Analyse(List<String> input) {
		List<String> output = new ArrayList<String>();

		// Initialize metric variablesd
		int class_count = 0;
		int methods_count = 0;
		int lines_count = 0;
		for (int i = 0; i < input.size(); i++) {
			// List formating
			String line = input.get(i);
			line = line.trim();
			System.out.println("This is the trimmed string: " + line);
			if (line.equals("")) {
				// Do nothing - comment
			} else if (line.startsWith("*") || line.startsWith("/*") || line.startsWith("*/")
					|| line.startsWith("//")) {
				// Do nothing - comment
			} else if (line.contains("class")) {
				class_count += 1;
				lines_count += 1;
			} else if (line.contains("public") && line.contains("{")) {
				methods_count += 1;
				lines_count += 1;
			} else if ((line.contains("private") && line.contains("{"))) {
				methods_count += 1;
				lines_count += 1;
			} else {
				lines_count += 1;
			}
		}

		// Create a list of the elements which will be joined with commas
		List<String> all = new ArrayList<String>();
		all.add(Integer.toString(class_count));
		all.add(Integer.toString(methods_count));
		all.add(Integer.toString(lines_count));

		String allCommaSeparated = String.join(",", all);
		output.add(0, "");
		output.add(1, "noc,nom,loc");
		output.add(2, allCommaSeparated);
		return output;
	}
}
