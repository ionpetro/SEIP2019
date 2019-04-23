package operations;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 * A test class that implements a Parameterized test
 * for the IntegerOperations powerOfTwo method.
 * @author ionpetro (ionpetro@gmail.com)
 */
@RunWith (Parameterized.class)
public class IntegerOperations_PowerOfTwo_ParameterizedTest {
	
	// the value is the id of each parameter
	@Parameter (value = 0)
	public int power;
	@Parameter (value = 1)
	public int result;
	
	IntegerOperations io = new IntegerOperations();
	
	/*
	 * The following method generates the input values 
	 * for the tests. 
	 */
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][]{{0,1},{1,2},{2,4},{3,8},{4,16},{5,32},{6,64}};
		
		return Arrays.asList(data);
	}
	
	/*
	 * A unit test that is executed for each pair of 
	 * parameters. 
	 */
	@Test
	public void test_powerofTwoWithNormalCases() {
		Assert.assertEquals(result, io.powerOfTwo(power));
		
	}

}
