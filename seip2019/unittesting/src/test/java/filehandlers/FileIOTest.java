package filehandlers;

import org.junit.Test;
import org.junit.Assert;

/**
 * An class that provides test cases for the 
 * FileIO class.
 * @author ionpetro (ionpetro@gmail.com)
 */
public class FileIOTest {
	FileIO fi = new FileIO();
	//This is a valid File
	String validFile = "src/test/resources/FileIo_ValidTestFile.txt";
	//This is an invalid File
	String invalidFile = "src/test/resources/FileIo_InvalidTestFile.txt";
	//This is a file that does not exist in the resources folder
	String nonExistFile = "src/test/resources/FileIo_NonExistFile.txt";
	
	/*
	 * A test case that examines the readFile method
	 * with valid input values. 
	 */
	@Test
	public void test_readFile_valid() {
		int[] validArray = {1,2,3,5,6,5,8,7,4,3,4,1,1,1};
		Assert.assertArrayEquals(validArray, fi.readFile(validFile));
	}
	
	/*
	 * A test case for the exceptions caused when
	 * the file does not exist.
	 */
	@Test (expected=IllegalArgumentException.class)
	public void test_readFile_nonExist() {
		fi.readFile(nonExistFile);
	}
	
	/*
	 * A test case for the exceptions caused when
	 * the file has invalid format.
	 */
	@Test (expected=NumberFormatException.class)
	public void test_readFile_invalid() {
		fi.readFile(invalidFile);
	}
}
