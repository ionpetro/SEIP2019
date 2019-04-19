package operations;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith (Parameterized.class)
public class IntegerOperationsTest_PowerOfTwo_Parameterized {
	
	@Parameter (value = 0)
	public int power;
	@Parameter (value = 1)
	public int result;
	
	IntegerOperations io = new IntegerOperations();
	
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][]{{0,1},{1,2},{2,4},{3,8},{4,16},{5,32},{6,64}};
		
		return Arrays.asList(data);
	}
	
	@Test
	public void test_powerofTwo() {
		Assert.assertEquals(result, io.powerOfTwo(power));
		
	}

}
