package codeAnalyser;

import java.util.ArrayList;
import java.util.List;

import analysers.General_Analyser;
import utilitiesClass.FileIOUtilities;

/*
 * This class operates as a facade
 */
public class CodeAnalyser {
	
	/*
	 * This method reads a file, analyses it and writes it to a .csv file.
	 */
	public void analyse_code(String source_file, String type_of_analysis) {

		List<String> list = new ArrayList<String>();
		Analyse_Factory analyze = new Analyse_Factory();

		list = FileIOUtilities.ReadFile(source_file);
		String out_path = "test.csv";

		General_Analyser content = analyze.choose_analyser(type_of_analysis);
		List<String> output_list = content.Analyse(list);
		FileIOUtilities.WriteFile(out_path, output_list);


	}

}