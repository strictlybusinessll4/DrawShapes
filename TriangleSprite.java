public class TriangleSprite extends Sprite
{
	private int dimensionY;

	public TriangleSprite(int y, boolean Fill)
	{
		this.dimensionY = y;
		this.rows = new String[y];
		createTriangle(Fill);
	}


	public void createTriangle(boolean FILL)
	{
		int base = this.dimensionY*2;
		int Spread = 0;
		Spread++;
		for(int i = 0; i < this.dimensionY; i++)
		{
			char[] row = new char[base+1];
			int j = this.dimensionY-i;
			
			for(int times=0; times<2; times++)
			{
				for(int k=i; k>=0; k--)
				{
					if(!FILL)
					{
						
						if(j == this.dimensionY-i || i==this.dimensionY-1)
						{
						        row[j] = '*';
						} else 
						{
							row[j] = '-';
						}
						j++;

					} else {
					row[j] = '*';
					j++;
					}
				}
				j--;
				
				if(!FILL)
				{
				     row[j] = '*';
				}

							
			}

			
			this.rows[i] = String.valueOf(row);
		}

		//plus 2 left shift plus 2 left shift

	}




}
