package Analysers;

import java.util.ArrayList;
import java.util.List;

//StringAnalyser
public class StringAnalyser implements General_Analyser {

	public List<String> Analyse(List<String> input) {
		List<String> output = new ArrayList<>();
		// List formating
		System.out.print(input);
		int class_count = 0;
		int methods_count = 0;
		int lines_count = 0;
		for (int i = 0; i < input.size(); i++) {
			String line = input.get(i);//fix
			line = line.trim();
			if (input.get(i).startsWith("/*") || input.get(i).startsWith("*") || input.get(i).startsWith("//")) { 
				input.remove(i);
				if (input.get(i).equals(" ")) {
					input.remove(i);
				}			
			} else if (input.get(i).contains("class")) {
				class_count += 1;
				lines_count += 1;
			} else if (input.get(i).contains("public") && input.get(i).contains("{")) {
				methods_count += 1;
				lines_count += 1;
			} else if ((input.get(i).contains("private") && input.get(i).contains("{"))) {
				methods_count += 1;
				lines_count += 1;
			} else {
				lines_count += 1;
			}
		}
		String cc = Integer.toString(class_count);
		String mm = Integer.toString(methods_count);
		String cod = Integer.toString(lines_count);
		output.add(0, " ");
		output.add(1, "Number of Classes: " + cc);
		output.add(2, "Number of Methods: " + mm);
		output.add(3, ", Lines of Code: " + cod);
		return output;
	}
}
