package operations;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Assert;
import org.junit.Rule;

//TODO change method names

public class IntegerOperationsTest {
	IntegerOperations io = new IntegerOperations();
	
	@Test
	public void test_reverseSign_positive() {
		Assert.assertEquals(-3, io.reverseSign(3));
		
	}
	
	@Test
	public void test_reverseSign_negative() {
		Assert.assertEquals(3, io.reverseSign(-3));
		
	}
	
	@Test
	public void test_reverseSign_Exception() {
		Assert.assertEquals(0, 0);

	} // should I include the 0 input test?
	
	@Test
	public void test_add_normalcase() {
		Assert.assertEquals(8, io.add(5, 3));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_add_negative() {
		io.add(-3, -5);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_add_overflow() {
		int x = Integer.MAX_VALUE;
		int y = 1;
		io.add(x, y);
	}
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void test_powerOfTwo_negative() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage(" is not a positive integer.");
		io.powerOfTwo(-3);
	}

	@Test
	public void test_powerOfTwo_overflow() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("^2 causes an integer overflow.");
		io.powerOfTwo(31);
	}
	
	
	
}
