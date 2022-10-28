
public interface ISpriteFactory
{
	public Sprite produceSprite(String Type, boolean fill);


	public void setHeight(int y);
	public void setWidth(int x);
	public void setRadius(int r);
	public void clear();
	
}
