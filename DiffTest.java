import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class DiffTest
{

	@Before
	public void setUp() throws Exception
	{
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void test()
	{
		//take two strings and return some kind of list,, 
		String stringOne = "I have a dog";
		String stringTwo = "I have a dog";
		
		Diff testDiff = new Diff(stringOne, stringTwo);
		
		List < DiffChange > changes = testDiff.getDifferences();
		
		assertEquals(0, changes.size());
		
	}

}
