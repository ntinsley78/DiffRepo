import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class RecipeTest
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
		Recipe testRecipe = new Recipe(stringOne, stringTwo);
		List < Item > items = testRecipe.getRecipe();

		assertEquals(0, items.size());
		
	}
	
//	@Test
//	public void testRecipe1()
//	{
//		//take two strings and return some kind of list,, 
//		String stringOne = "123456789";
//		String stringTwo = "0123mm89";
//		
//		Recipe testRecipe = new Recipe(stringOne, stringTwo);
//		List <Item> items = testRecipe.getRecipe();
//						
//		assertEquals(3, items.size());
//
//	}
//	
	@Test
	public void testRecipe2()
	{
		String stringThree = "I have two wonderful dogs named Willy and Juan Pablo";
		String stringFour =  "I have two wonderful cats named Willy and Juan Pablo";
		
		Recipe testRecipe = new Recipe(stringThree, stringFour);
		List <Item> items = testRecipe.getRecipe();
		
		assertEquals(2, items.size());
		assertEquals("dogs ", items.get(0).getText());
		assertEquals(21, items.get(0).getPosition());
		assertTrue(items.get(0) instanceof DeleteItem);
	}
	
	@Test
	public void testRecipe3()
	{
		String stringOne ="I have two cats named Willy and Juan Pablo";
		String stringTwo = "Oh my, I have one fat dog named Juan Pablo";
		
		Recipe testRecipe = new Recipe(stringOne, stringTwo);
		List <Item> items = testRecipe.getRecipe();
		
		assertEquals(9, items.size());
		
		assertEquals("Oh ", items.get(0).getText());
		assertEquals(0, items.get(0).getPosition());
		assertTrue(items.get(0) instanceof AddItem);
		
		assertEquals("my, ", items.get(1).getText());
		assertEquals(3, items.get(1).getPosition());
		assertTrue(items.get(1) instanceof AddItem);
		
		assertEquals("two ", items.get(2).getText());
		assertEquals(14, items.get(2).getPosition());
		assertTrue(items.get(2) instanceof DeleteItem);
		
		assertEquals("cats ", items.get(3).getText());
		assertEquals(14, items.get(3).getPosition());
		assertTrue(items.get(3) instanceof DeleteItem);
				
		assertEquals("one ", items.get(4).getText());
		assertEquals(14, items.get(4).getPosition());
		assertTrue(items.get(4) instanceof AddItem);
		
		assertEquals("fat ", items.get(5).getText());
		assertEquals(18, items.get(5).getPosition());
		assertTrue(items.get(5) instanceof AddItem);
		
		assertEquals("Willy ", items.get(6).getText());
		assertEquals(22, items.get(6).getPosition());
		assertTrue(items.get(6) instanceof DeleteItem);

		assertEquals("dog ", items.get(7).getText());
		assertEquals(22, items.get(7).getPosition());
		assertTrue(items.get(7) instanceof AddItem);
		
		assertEquals("and ", items.get(8).getText());
		assertEquals(32, items.get(8).getPosition());
		assertTrue(items.get(8) instanceof DeleteItem);
		
	}

	@Test
	public void testRecipe4()
	{
		String stringThree = "I have a bug";
		String stringFour =  "I have    a bug";
		
		Recipe testRecipe = new Recipe(stringThree, stringFour);
		List <Item> items = testRecipe.getRecipe();
		
		assertEquals(3, items.size());
		
		assertEquals(" ", items.get(0).getText());
		assertEquals(7, items.get(0).getPosition());
		assertTrue(items.get(0) instanceof AddItem);
		
		assertEquals(" ", items.get(1).getText());
		assertEquals(8, items.get(1).getPosition());
		assertTrue(items.get(1) instanceof AddItem);
		
		assertEquals(" ", items.get(2).getText());
		assertEquals(9, items.get(2).getPosition());
		assertTrue(items.get(2) instanceof AddItem);

	}

	@Test
	public void testRecipe5()
	{
		String stringThree = "I have a bug";
		String stringFour =  "I ";
		
		Recipe testRecipe = new Recipe(stringThree, stringFour);
		List <Item> items = testRecipe.getRecipe();
		
		assertEquals(3, items.size());
		
		assertEquals("have ", items.get(0).getText());
		assertEquals(2, items.get(0).getPosition());
		assertTrue(items.get(0) instanceof DeleteItem);
		
		assertEquals("a ", items.get(1).getText());
		assertEquals(2, items.get(1).getPosition());
		assertTrue(items.get(1) instanceof DeleteItem);
		
		assertEquals("bug ", items.get(2).getText());
		assertEquals(2, items.get(2).getPosition());
		assertTrue(items.get(2) instanceof DeleteItem);

	}
	
	@Test
	public void testRecipe6()
	{
		String stringThree = "I have a bug";
		String stringFour =  "I have ";
		
		Recipe testRecipe = new Recipe(stringThree, stringFour);
		List <Item> items = testRecipe.getRecipe();
		
		assertEquals(2, items.size());
		
		assertEquals("a ", items.get(0).getText());
		assertEquals(7, items.get(0).getPosition());
		assertTrue(items.get(0) instanceof DeleteItem);
		
		assertEquals("bug ", items.get(1).getText());
		assertEquals(7, items.get(1).getPosition());
		assertTrue(items.get(1) instanceof DeleteItem);
	}
	
	@Test
	public void testRecipe7()
	{
		String stringThree = "I ";
		String stringFour =  "I have a bug";
		
		Recipe testRecipe = new Recipe(stringThree, stringFour);
		List <Item> items = testRecipe.getRecipe();
		
		assertEquals(3, items.size());
		
		assertEquals("have ", items.get(0).getText());
		assertEquals(2, items.get(0).getPosition());
		assertTrue(items.get(0) instanceof AddItem);
		
		assertEquals("a ", items.get(1).getText());
		assertEquals(7, items.get(1).getPosition());
		assertTrue(items.get(1) instanceof AddItem);
		
		assertEquals("bug ", items.get(2).getText());
		assertEquals(9, items.get(2).getPosition());
		assertTrue(items.get(2) instanceof AddItem);

	}
	
	@Test
	public void testRecipe8()
	{
		String stringThree = "I have ";
		String stringFour =  "I have a bug";
		
		Recipe testRecipe = new Recipe(stringThree, stringFour);
		List <Item> items = testRecipe.getRecipe();
		
		assertEquals(2, items.size());
		
		assertEquals("a ", items.get(0).getText());
		assertEquals(7, items.get(0).getPosition());
		assertTrue(items.get(0) instanceof AddItem);
		
		assertEquals("bug ", items.get(1).getText());
		assertEquals(9, items.get(1).getPosition());
		assertTrue(items.get(1) instanceof AddItem);

	}
}
