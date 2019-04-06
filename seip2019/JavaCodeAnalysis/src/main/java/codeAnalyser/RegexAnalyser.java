package codeAnalyser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is used in order to analyse a list of strings, using regular expressions.
 */
public class RegexAnalyser implements GeneralAnalyser {

	/**
	 * Analyse method implements the General_Analyser interface. This method takes as an input a List of Strings and 
	 * returns a List of Strings containing number of classes, number of methods and lines of code.
	 * 
	 * @param List<String> input this is a list of lines of a file
	 */
	public List<String> Analyse(List<String> input) {

		List<String> output = new ArrayList<String>();
		
		// Initialize metric variablesd
		int class_count = 0;
		int methods_count = 0;
		int comments_count = 0;
		
		// Initialize the regular expression patterns
		Pattern m = Pattern.compile(
				"(public|protected|private|static|\\s) +[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;])");
		Pattern c = Pattern.compile(
				"\\s*(public|private)\\s+class\\s+(\\w+)\\s+((extends\\s+\\w+)|(implements\\s+\\w+( ,\\w+)*))?\\s*\\{");
		String commentsregex = "//.*|(\"(?:\\\\[^\"]|\\\\\"|.)*?\")|(?s)/\\*.*?\\*/";
		Pattern comments = Pattern.compile(commentsregex);
		for (int i = 0; i < input.size(); i++) {
			// List formating
			String line = input.get(i);
			line = line.trim();
			
			Matcher co = comments.matcher(line);
			if (co.find()) {
				comments_count += 1;
			}
			Matcher methodpat = m.matcher(line);
			Matcher classpat = c.matcher(line);
			if (methodpat.find()) {
				methods_count += 1;
			}
			if (classpat.find()) {
				class_count += 1;
			}
		}

		// Create a list of the elements which will be joined with commas
		System.out.print("Comments: " + comments_count);
		int lines_count = input.size() - comments_count;
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
