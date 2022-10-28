public class SquareSprite extends Sprite
{
	private int dimensionX;
	private int dimensionY;

	public SquareSprite(int x, int y, boolean Fill)
	{
		this.dimensionX = x;
	 	this.dimensionY = y;
		this.rows = new String[y];
		createSquare(Fill);
	}




	public void createSquare(boolean FILL)
	{	
		for(int i = 0; i < dimensionY; i++ )
		{
		char[] row = new char[this.dimensionX];
		
			for(int k = 0; k < dimensionX; k++)
			{
				if(i==0 || i==dimensionY-1 || k == 0 || k == dimensionX-1)
				{
				   row[k] = '*';
				} 
				else if(FILL)
				{
				if(i >= 0 && i <= dimensionY && k>=0 && k<= dimensionX)
				   row[k] = '*';
				} else {
				   row[k] = ' ';
				}

			}
		this.rows[i] = String.valueOf(row);

		}



	}



}
