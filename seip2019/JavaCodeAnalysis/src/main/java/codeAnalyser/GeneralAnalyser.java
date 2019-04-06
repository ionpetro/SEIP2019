package codeAnalyser;
import java.util.List;

/**
 * This class represents the Strategy design pattern
 */
public interface GeneralAnalyser {
	
	/**
	 * Analyse method returns a list of strings including the numbers of methods 
	 * the numbers of classed and the lines of code.
	 * 
	 * @param List<String> input is a list of string to be analysed
	 */
	public List<String> Analyse(List<String> input);
}