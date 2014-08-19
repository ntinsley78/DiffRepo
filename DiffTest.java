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
	public void testSameStrings()
	{
		//take two strings and return some kind of list,, 
		String stringOne = "I have a dog";
		String stringTwo = "I have a dog";
		
		Diff testDiff = new Diff(stringOne, stringTwo);
		
		List < DiffChange > changes = testDiff.getDifferences();
		
		assertEquals(0, changes.size());
		
	}
	
	@Test
	public void test()
	{
		//take two strings and return some kind of list,, 
		String stringOne = "123456789";
		String stringTwo = "0123mm89";
		
		Diff testDiff1 = new Diff(stringOne, stringTwo);
		
		List < DiffChange > changes = testDiff1.getDifferences();
		
		assertEquals(0, changes.size());

		String stringThree = "I have two wonderful dogs named Willy and Juan Pablo";
		String stringFour =  "I have two wonderful cats named Willy and Juan Pablo";
		
		Diff testDiff2 = new Diff(stringThree, stringFour);
		
		changes = testDiff2.getDifferences();
		
		assertEquals(0, changes.size());

	}
	

}
