
public class Item
{

	private String text;
	private int position;
	
	public Item(String t, int p)
	{
		setText(t);
		setPosition(p);
		
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public int getPosition()
	{
		return position;
	}

	public void setPosition(int position)
	{
		this.position = position;
	}

}
