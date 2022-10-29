public class CircleSprite extends Sprite
{
	private int radius;

	public CircleSprite(int r, boolean Fill)
	{
		this.radius = r/2;
        	this.rows = new String[this.radius*2 + 1];
		createCircle(Fill);
	}


	public void createCircle(boolean FILL)
	{
		for(int i = 0; i < 2*this.radius+1; i++)
		{
			char[] row = new char[this.radius*2+1];
			for(int j =0; j < 2*this.radius+1;j++)
			{

				
				double distance = Math.sqrt((i - this.radius) * (i-this.radius) + (j-this.radius)*(j-this.radius));
				if(distance > this.radius-0.5 && distance < this.radius+0.5)
				{
					row[j] = '*';
				}
				else if(FILL)
				{	//removed the one
					
					if(distance < this.radius)
					{
						row[j] = '*';
					}

				}
				



			}
			this.rows[i] = String.valueOf(row);




		}


	}




}
