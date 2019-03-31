package Utilities;

import java.util.ArrayList;
import java.util.List;

public class Facade {
		
	public void analyze_code(String source_file, String type_of_analysis) {
		
		List<String> list = new ArrayList<>();
		FileIOUtilities util = new FileIOUtilities();
		Analyze_Factory analyze = new Analyze_Factory();
		
		list = util.ReadFile(source_file);
		String out_path = "test.csv";
		
		General_Analyzer content = analyze.choose_analyzer(type_of_analysis);
		List<String> output_list = content.Analyze(list);
		util.WriteFile(out_path, output_list);
		
		
	}
	
}
