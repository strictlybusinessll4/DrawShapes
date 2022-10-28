import java.util.Deque;
import java.util.LinkedList;
public class ScreenInit
{
	private Deque<Sprite> spriteQueue = new LinkedList<Sprite>();
	private String[] rows;
	int height, width;

	public ScreenInit(int w, int h)
	{
		this.height = h;
		this.width = w;

		rows = new String[height];

		for(int i = 0; i < height; i++)
		{
			for(int j = 0; j < width; j++)
			{
				rows[i] += ' ';
			}
		}

	}

	public void addSprite(Sprite sprite)
	{
		spriteQueue.add(sprite);

	}

	//using the class exercise example as reference for this function

	public void drawSprites()
	{
		for(Sprite sprite: spriteQueue)
		{
			updateSpriteSheet(sprite);
		}

		//What gets fed into the IO stream ( fancy way of saying what gets printed
		for(int i =0; i < height;i++)
		{
			System.out.println(rows[i]);
		}
	}


	private void updateSpriteSheet(Sprite sprite)
	{
		//keep in mind if we get a '0' from getSymbol or the getPosition thing
		//do definitely ignore drawing on there ok bud?
		for(int y = 0; y < height; y++)
		{
			char[] row = rows[y].toCharArray();

			for(int x =0; x< width; x++)
			{
				char symbol = sprite.getPositionAt(x,y);
				if(symbol == '*')
				{
					row[x]=symbol;
				}
			}

			rows[y] = String.valueOf(row);

		}

	}



	

}
