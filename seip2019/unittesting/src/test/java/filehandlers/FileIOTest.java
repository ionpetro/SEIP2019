package filehandlers;

import org.junit.Test;
import org.junit.Assert;

public class FileIOTest {
	FileIO fi = new FileIO();
	String validFile = "src/test/resources/FileIo_ValidTestFile.txt";
	String invalidFile = "src/test/resources/FileIo_InvalidTestFile.txt";
	String nonExistFile = "src/test/resources/FileIo_NonExistFile.txt";
	
	@Test
	public void test_readFile_valid() {
		int[] validArray = {1,2,3,5,6,5,8,7,4,3,4,1,1,1};
		Assert.assertArrayEquals(validArray, fi.readFile(validFile));
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void test_readFile_nonExist() {
		fi.readFile(nonExistFile);
	}
	
	@Test (expected=NumberFormatException.class)
	public void test_readFile_invalid() {
		fi.readFile(invalidFile);
	}
}
