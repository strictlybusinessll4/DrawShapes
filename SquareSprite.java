public class SquareSprite extends Sprite
{
	private int dimensionX;
	private int dimensionY;

	public SquareSprite(int x, int y, boolean Fill)
	{
		this.dimensionX = x;
	 	this.dimensionY = y;
		createSquare(Fill);
	}




	public void createSquare(boolean FILL)
	{
		if(FILL)
		{
			//do something here
		}
		
		for(int i = 0; i < dimensionY; i++ )
		{
			for(int k = 0; k < dimensionX; k++)
			{
				//something;
			}

		}



	}



}
