package operations;

import org.junit.Test;
import org.junit.Assert;

import filehandlers.FileIO;
import static org.mockito.Mockito.*;

public class ArrayOperationsTest {

	ArrayOperations arop;

	//TODO failed test
	@Test
	public void test_reverseArray_Mocking() {

		FileIO fi = mock(FileIO.class);
		IntegerOperations io = mock(IntegerOperations.class);

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

	//TODO failed test
	@Test
	public void test_findMaxInFile_Mocking() {

		FileIO fi = mock(FileIO.class);

		String filepath = "src/test/resources/ArrayTest.txt";

		int[] fileInput = { 1, 2, 3, 4 };
		when(fi.readFile(filepath)).thenReturn(fileInput);

		Assert.assertEquals(4, arop.findMaxInFile(filepath));

	}

}
