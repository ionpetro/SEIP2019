package Code_Analysis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Ion Petropoulos
 * @version 1.0
 * @purpose Created this Utilities Class in order to have a personal library
 *          which contains many every-day methods, achieving re-usable code.
 *
 */
public final class FileIOUtilities {

	/*
	 * This method Writes content to a file. You can call this method giving the
	 * path of the file you want to write and the content.
	 * 
	 * @parameter content
	 * 
	 * @parameter path of the File
	 */
	
	private MyUtiliites() {
		// private Constructor to prevent class instantiation
		return null; 
	}
	
	public void WriteFile(String path, List<String> content) {

		BufferedWriter bw = null;
		
		try {

			File file = new File(path);

			/*
			 * This logic will make sure that the file gets created if it is not present at
			 * the specified location
			 */
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			
			for (int i = 1; i< content.size(); i++) {
				bw.write(content.get(i));
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				// In case of not exiting the BufferedWriter
				System.out.println("Error in closing the BufferedWriter" + ex);
			}
		}
	}

	/*
	 * This method reads a file. You only give the name of the method and the path
	 * of the file that you want to read, and it prints all the file.
	 */
	public static List<String> ReadFile(String path) {

		BufferedReader reader = null;
		List<String> list = new ArrayList<>();
		try {
			File file = new File(path);
			reader = new BufferedReader(new FileReader(file));

			String line;
			while ((line = reader.readLine()) != null) {
				list.add(line);
			}
			return list;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}