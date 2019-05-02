package operations;

import org.junit.Test;
import org.junit.Assert;

import filehandlers.FileIO;
import static org.mockito.Mockito.*;

/**
 * An class that provides test cases for the reverseArray method of
 * ArrayOperations class.
 * 
 * @author ionpetro (ionpetro@gmail.com)
 */
public class ArrayOperationsTest {

	/*
	 * The following test aims to fix the problem described in the previous
	 * test_reverseArray test case. In order to isolate the external (to this class)
	 * dependencies (FileIO) we have to mock them and predefine the results of all
	 * calls that we plan to execute on the FileIO methods.
	 */
	FileIO fi = mock(FileIO.class);
	IntegerOperations io = mock(IntegerOperations.class);
	ArrayOperations arop = new ArrayOperations(fi, io);

	@Test
	public void test_reverseArray_Mocking() {

		String filepath = "src/test/resources/FileIo_ValidTestFile.txt";

		when(io.reverseSign(1)).thenReturn(-1);
		when(io.reverseSign(2)).thenReturn(-2);
		when(io.reverseSign(-3)).thenReturn(3);
		when(io.reverseSign(-4)).thenReturn(4);

		int[] fileInput = { 1, 2, -3, -4 };
		when(fi.readFile(filepath)).thenReturn(fileInput);

		int[] testValues = { -1, -2, 3, 4 };
		Assert.assertArrayEquals(testValues, arop.reverseArray(filepath));

	}

	/*
	 * This test case examines the exception caused when the file is empty, thus
	 * there is anothing to be revered. Mocking is again used predefining the FileIo
	 * use.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test_reverseArray_Exception() {

		String filepath = "src/test/resources/Empty.txt";
		
		int[] fileInput = {};
		when(fi.readFile(filepath)).thenReturn(fileInput);

		arop.reverseArray(filepath);
	}

	/*
	 * The following test aims to fix the problem described in the previous
	 * test_reverseArray test case. In order to isolate the external (to this class)
	 * dependencies (FileIO and IntegerOperations) we have to mock them and
	 * predefine the results of all calls that we plan to execute on the FileIO and
	 * IntegerOperations methods.
	 */
	@Test
	public void test_findMaxInFile_Mocking() {

		String filepath = "src/test/resources/ArrayTest.txt";

		int[] fileInput = { 1, 2, 3, 4 };
		when(fi.readFile(filepath)).thenReturn(fileInput);

		Assert.assertEquals(4, arop.findMaxInFile(filepath));

	}

	/*
	 * This test case examines the exception caused when the file is empty, thus
	 * there is anothing to be revered. Mocking is again used predefining the FileIo
	 * and Integer- Operations use.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test_findMaxInFile_Exception() {
		FileIO fi = mock(FileIO.class);
		IntegerOperations io = mock(IntegerOperations.class);

		String filepath = "src/test/resources/Empty.txt";
		ArrayOperations arop = new ArrayOperations(fi, io);

		int[] fileInput = {};
		when(fi.readFile(filepath)).thenReturn(fileInput);

		arop.findMaxInFile(filepath);
	}

}
