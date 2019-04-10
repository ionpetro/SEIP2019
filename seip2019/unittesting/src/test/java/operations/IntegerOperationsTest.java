package operations;

import org.junit.Test;
import org.junit.Assert;

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
		int y = Integer.MAX_VALUE;
		io.add(x, y);
	}
	
}
