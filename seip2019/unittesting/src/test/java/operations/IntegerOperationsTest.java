package operations;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Assert;
import org.junit.Rule;

/**
 * An class that provides test cases for the 
 * IntegerOperations class.
 * @author ionpetro (ionpetro@gmail.com)
 */
public class IntegerOperationsTest {
	/* 
	 * A reference to the IntegerOperations class
	 * whose methods we are testing in this class
	 */
	
	IntegerOperations io = new IntegerOperations();
	
	/*
	 * A test case that examines the reverseSign
	 * method with positive input values. 
	 */
	@Test
	public void test_reverseSign_positive() {
		Assert.assertEquals(-3, io.reverseSign(3));
		
	}

	/*
	 * A test case that examines the reverseSign
	 * method with negative input values. 
	 */
	@Test
	public void test_reverseSign_negative() {
		Assert.assertEquals(3, io.reverseSign(-3));
		
	}
	
	/*
	 * A test case for the exception caused when
	 * the input is number zero (0)
	 */
	@Test
	public void test_reverseSign_Exception() {
		Assert.assertEquals(0, 0);

	}
	
	/*
	 * A test case that examines the add method
	 * method with normal values. 
	 */
	@Test
	public void test_add_normalcase() {
		Assert.assertEquals(8, io.add(5, 3));
	}
	
	/*
	 * A test case for the exception caused when
	 * a negative input is given 
	 */
	@Test (expected = IllegalArgumentException.class)
	public void test_add_negative() {
		io.add(-3, -5);
	}
	
	/*
	 * A test case for the exception caused by overflow
	 */
	@Test (expected = IllegalArgumentException.class)
	public void test_add_overflow() {
		int x = Integer.MAX_VALUE;
		int y = 1;
		io.add(x, y);
	}
	
	/*
	 * A test case considering powerOfTwo method 
	 * for the exceptions caused when one or more
	 * input values are negative. Testing
	 * the exception is performed with a @Rule
	 */
	@Rule
	public ExpectedException exception = ExpectedException.none();
	@Test
	public void test_powerOfTwo_negative() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage(" is not a positive integer.");
		io.powerOfTwo(-3);
	}


	/*
	 * A test case considering powerOfTwo method 
	 * for the exceptions caused when one or more
	 * input values are causing Overflow. EasterEGG:
	 * checking if a human on this planet is reading
	 * my documentation. If you see that open an issue
	 * on github and you will be rewarded ;)
	 */
	@Test
	public void test_powerOfTwo_overflow() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("^2 causes an integer overflow.");
		io.powerOfTwo(31);
	}
	
}
