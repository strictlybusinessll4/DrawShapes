public class Sprite 
{
	protected String[] rows;
	protected int y;
	protected int x;
	
	
	
	//Taken from class material
	public char getPositionAt(int x, int y)
	{
		try
		{
			return rows[y - this.y].charAt(x - this.x);

		} catch (Exception e) {
			/* 
			return a conditional variable so that we do not 
			overwrite other drawings on the
			ScreenBuffa
			*/
			return '0';
		}

	}

	//do not forget about this
	public void setPosition(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

}
