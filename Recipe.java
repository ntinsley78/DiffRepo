import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Recipe
{
	private String originalString;
	private String endString;
	
	private List <WordIndex> originalTextToBeRemoved;
	private List <WordIndex> endingTextToAdd;
	
	public Recipe(String o, String e)
	{
		setOriginalString(o);
		setEndString(e);
		
		originalTextToBeRemoved = new ArrayList<WordIndex>() ;
		endingTextToAdd = new ArrayList<WordIndex>();
		
		populateArrays();
	}


	public String getOriginalString()
	{
		return originalString;
	}


	public void setOriginalString(String originalString)
	{
		this.originalString = originalString;
	}


	public String getEndString()
	{
		return endString;
	}


	public void setEndString(String endString)
	{
		this.endString = endString;
	}
	
	//build arrays
	private void populateArrays()
	{
		int pos = 0;
	
		for(String word : getOriginalString().split(" "))
		{
			String wordToAdd = word + " ";
			originalTextToBeRemoved.add(new WordIndex(wordToAdd, pos));
			pos = pos + wordToAdd.length();
		}
		
		pos = 0;
		
		for(String word : getEndString().split(" "))
		{
			String wordToAdd = word + " ";
			endingTextToAdd.add(new WordIndex(wordToAdd, pos));
			pos = pos + wordToAdd.length();
		}
		
		Iterator < WordIndex > originalIter = originalTextToBeRemoved.iterator();
		while(originalIter.hasNext())
		{
			WordIndex originalWordIndex = originalIter.next();
			
			Iterator < WordIndex > endingIter = endingTextToAdd.iterator();
			
			while(endingIter.hasNext())
			{
				WordIndex endWordIndex = endingIter.next();
				if(originalWordIndex.getWord().equals(endWordIndex.getWord()))
				{
					//remove originalTextToBeRemoved at i
					originalIter.remove();
					
					//remove endingTextToAdd at j
					endingIter.remove();
					
					break;
				}
			}
		}
	}

	public List < Item > getRecipe()
	{
		List < Item > items = new ArrayList < Item >();
		
		int indexOforiginalTextToBeRemoved = 0;
		int indexOfendingTextToAdd = 0;
		int numProcessed = endingTextToAdd.size() + originalTextToBeRemoved.size();
		int adjustmentValue = 0;
		int count = 0;
		while(count < numProcessed)
		{
			WordIndex removed = null;
			if(indexOforiginalTextToBeRemoved < originalTextToBeRemoved.size())
			{
				removed = originalTextToBeRemoved.get(indexOforiginalTextToBeRemoved);
			}
			
			WordIndex added = null;
			if(indexOfendingTextToAdd < endingTextToAdd.size())
			{
				added = endingTextToAdd.get(indexOfendingTextToAdd);
			}
			
			if(removed != null && added != null && removed.getIndex() < added.getIndex())
			{
				System.out.println("Delete item: " + removed.getWord());
				
				//delete item
				items.add(new DeleteItem(removed.getWord(), removed.getIndex() + adjustmentValue));
				adjustmentValue = adjustmentValue - removed.getWord().length();
				indexOforiginalTextToBeRemoved++;
				count++;
			}
			else if(added != null && removed != null && added.getIndex() < removed.getIndex())
			{
				System.out.println("Added item: " + added.getWord());
				
				//add item
				items.add(new AddItem(added.getWord(), added.getIndex()/* + adjustmentValue*/));
				adjustmentValue = adjustmentValue + added.getWord().length();
				indexOfendingTextToAdd++;
				count++;
			}
			else  if(added != null && removed != null)
			{
				System.out.println("Delete/Add item: " + removed.getWord() + ":" + added.getWord());
				
				//delete item first
				items.add(new DeleteItem(removed.getWord(), removed.getIndex()/* + adjustmentValue*/));
				adjustmentValue = adjustmentValue - removed.getWord().length();
				indexOforiginalTextToBeRemoved++;
				count++;
				
				//add item
				items.add(new AddItem(added.getWord(), added.getIndex() + adjustmentValue));
				adjustmentValue = adjustmentValue + added.getWord().length();
				indexOfendingTextToAdd++;
				count++;
			}
			else  if(added == null && removed != null)
			{
				//there is a removed but no added
				System.out.println("Delete item: " + removed.getWord());
				
				//delete item
				items.add(new DeleteItem(removed.getWord(), removed.getIndex() + adjustmentValue));
				adjustmentValue = adjustmentValue - removed.getWord().length();
				indexOforiginalTextToBeRemoved++;
				count++;
			}
			else  if(added != null && removed == null)
			{
				System.out.println("Added item: " + added.getWord());
				
				//there is an added but not a removed
				//add item
				items.add(new AddItem(added.getWord(), added.getIndex()/* + adjustmentValue*/));
				adjustmentValue = adjustmentValue + added.getWord().length();
				indexOfendingTextToAdd++;
				count++;
			}
		}
		
		return items;
	}
}









