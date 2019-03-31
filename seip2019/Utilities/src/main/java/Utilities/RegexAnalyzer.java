package Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//RegexAnalyzer
public class RegexAnalyzer implements General_Analyzer {
	@Override
	public List<String> Analyze(List<String> input) {

		List<String> output = new ArrayList<>();
		// List formating
		for (int i = 0; i < input.size(); i++) {
			input.replaceAll(String::trim);
		}
		String pattern = "^ (?![ \\s]*\\r?\\n|import|package|[ \\s]*}\\r?\\n|[ \\s]*//|[ \\s]*/\\*|[ \\s]*\\*).*\\r?\\n";
		Pattern r = Pattern.compile(pattern);
		int count = 0;
		boolean matches;
		for (int i = 0; i < input.size(); i++) {
			Matcher m = r.matcher(input.get(i));
			matches = m.matches();
			if (matches == true) {
				count++;
			}
		}
		String c = Integer.toString(count);
		output.add(0, " ");
		output.add(1, "Lines of Code: " + c);
		return output;
	}
}
