package Code_Analysis;

import java.util.ArrayList;
import java.util.List;
import Analysers.*;

public class Facade {
		
	public void analyse_code(String source_file, String type_of_analysis) {
		
		List<String> list = new ArrayList<>();
		Analyse_Factory analyse = new Analyse_Factory();
		
		list = MyUtilities.ReadFile(source_file);
		String out_path = "test.csv";
		
		General_Analyser content = analyse.choose_analyser(type_of_analysis);
		List<String> output_list = content.Analyse(list);
		MyUtilities.WriteFile(out_path, output_list);
		
		
	}
	
}
