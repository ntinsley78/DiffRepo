
public class WordIndex
{
	private String word;
	private int index;
	
	public WordIndex(String w, int i)
	{
		setWord(w);
		setIndex(i);
	}

	public String getWord()
	{
		return word;
	}

	public void setWord(String word)
	{
		this.word = word;
	}

	public int getIndex()
	{
		return index;
	}

	public void setIndex(int index)
	{
		this.index = index;
	}

}
