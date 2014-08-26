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
			WordIndex removed = originalTextToBeRemoved.get(indexOforiginalTextToBeRemoved);
			WordIndex added = endingTextToAdd.get(indexOfendingTextToAdd);
			
			if(removed.getIndex() < added.getIndex())
			{
				adjustmentValue = adjustmentValue - removed.getWord().length();
				//delete item
				items.add(new DeleteItem(removed.getWord(), removed.getIndex() + adjustmentValue));
				indexOforiginalTextToBeRemoved++;
				count++;
			}
			else if(added.getIndex() < removed.getIndex())
			{
				adjustmentValue = adjustmentValue + added.getWord().length();
				//add item
				items.add(new AddItem(added.getWord(), added.getIndex() + adjustmentValue));
				indexOfendingTextToAdd++;
				count++;
			}
			else
			{
				//delete item first
				adjustmentValue = adjustmentValue - removed.getWord().length();
				items.add(new DeleteItem(removed.getWord(), removed.getIndex()/* + adjustmentValue*/));
				indexOforiginalTextToBeRemoved++;
				count++;
				
				//add item
				adjustmentValue = adjustmentValue + added.getWord().length();
				items.add(new AddItem(added.getWord(), added.getIndex() + adjustmentValue));
				indexOfendingTextToAdd++;
				count++;
			}
			
			
		}
		
		return items;
	}
}









