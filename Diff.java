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
		List < DiffChange > retVal = new ArrayList < DiffChange >();
		
		if(!getSourceString().equals(getDestinationString()))
		{
			
		}
		
		return retVal;
	}
	
	

}
