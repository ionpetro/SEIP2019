package Utilities;

public class Client {

	public static void main(String[] args) {
		
		Facade facade = new Facade();
		String source = args[0];
		String type_of_analysis = args[1];
		facade.analyze_code(source, type_of_analysis);

	}

}
 