package codeAnalyser;

import java.util.ArrayList;
import java.util.List;
import utilitiesClass.FileIOUtilities;

/**
 * This class operates as a facade
 * Its main purpose is to encapsulate the system behind a simple interface
 */
public class CodeAnalyser {
	
	/**
	 * This method reads a file, analyses it and writes it to a .csv file.
	 * 
	 * @param source_file
	 * @param type_of_analysis
	 */
	public void analyse_code(String source_file, String type_of_analysis) {

		List<String> list = new ArrayList<String>();
		AnalyseFactory analyze = new AnalyseFactory();

		list = FileIOUtilities.ReadFile(source_file);
		String out_path = "test.csv";

		GeneralAnalyser content = analyze.choose_analyser(type_of_analysis);
		List<String> output_list = content.Analyse(list);
		FileIOUtilities.WriteFile(out_path, output_list);


	}

}