public class SpriteFactory implements ISpriteFactory
{
	private int height;
	private int width;
	private int radius;

	public SpriteFactory()
	{
		this.height = 0;
		this.width = 0;
		this.radius = 0;
	}

	public Sprite produceSprite(String Type, boolean Fill)
	{
		switch (Type)
		{
			case "square":
			
				return new SquareSprite(width, height, Fill);

			break;

			case "circle":

				return new CircleSprite(radius, Fill);

			break;

			case "triangle":
			
				return new TriangleSprite(height, Fill);

			break;

			default:
			//DefaultParameters
				return new SquareSprite(0,0,Fill);

		}
	}

	public void setHeight(int y)
	{
		this.height = y;
	}
	public void setWidth(int x)
	{
		this.width = x;
	}
	public void setRadius(int r)
	{
		this.radius = r;
	}

	public void clearSet()
	{
		this.height = 0;
		this.width = 0;
		this.radius = 0;
	}



}
