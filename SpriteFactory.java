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

	public Sprite produceSprite(String Type, boolean Fill, int[] Coords)
	{
		switch (Type)
		{
			case "square":
				
				Sprite square = new SquareSprite(width, height, Fill);
				square.setPosition(Coords[0], Coords[1]);
				return square;

			

			case "circle":

				Sprite circle = new CircleSprite(radius, Fill);
				circle.setPosition(Coords[0], Coords[1]);
				return circle;
			

			case "triangle":
			
				Sprite triangle = new TriangleSprite(height, Fill);
				triangle.setPosition(Coords[0], Coords[1]);
				return triangle;

		}
		return new SquareSprite(0,0,Fill);
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

	public void clear()
	{
		this.height = 0;
		this.width = 0;
		this.radius = 0;
	}



}
