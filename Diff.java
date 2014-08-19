import java.util.ArrayList;
import java.util.List;


public class Diff
{

	private String sourceString;
	private String destinationString;
	
		
	public Diff(String first, String second)
	{
		setSourceString(first);
		setDestinationString(second);
	}

	public String getSourceString()
	{
		return sourceString;
	}


	public void setSourceString(String sourceString)
	{
		this.sourceString = sourceString;
	}


	public String getDestinationString()
	{
		return destinationString;
	}


	public void setDestinationString(String destinationString)
	{
		this.destinationString = destinationString;
	}

	public List<DiffChange> getDifferences()
	{
		//a list of changes that will turn the source file into the destination file
		List < DiffChange > retVal = new ArrayList < DiffChange >();
		
		//if the two strings have at least one difference
		if(!getSourceString().equals(getDestinationString()))
		{
			//create the differences... how???
			for(int numCharactersInGroup = getSourceString().length(); numCharactersInGroup > 1;numCharactersInGroup--)
			{
				for(int pos = 0;pos <= (getSourceString().length() - numCharactersInGroup);pos++)
				{
					String searchString = getSourceString().substring(pos, pos + numCharactersInGroup);
					if(getDestinationString().indexOf(searchString) >= 0)
					{
						System.out.println(searchString);
					}
					
				}
				System.out.println();
			}
		}
		//else- the two strings are exactly the same, no diff changes
		
		//return the differences
		return retVal;
	}
	
	

}
