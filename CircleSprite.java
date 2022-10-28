public class CircleSprite extends Sprite
{
	private int radius;

	public CircleSprite(int r, boolean Fill)
	{
		this.radius = r;
        	this.rows = new String[this.radius*2];
		createCircle(Fill);
	}


	public void createCircle(boolean FILL)
	{
		for(int i = 0; i < 2*this.radius; i++)
		{
			char[] row = new char[this.radius*2];
			for(int j =0; j < 2*this.radius;j++)
			{
				double distance = Math.sqrt((i - this.radius) * (i-this.radius) + (j-this.radius)*(j-this.radius));
				if(distance > this.radius-0.5 && distance < this.radius + 0.5)
				{
					row[j] = '*';
				}
				else if(FILL)
				{
					if(distance <= this.radius*this.radius +1)
					{
						row[j] = '*';
					}

				}
				

			}
			this.rows[i] = String.valueOf(row);




		}


	}




}
