import java.util.Scanner;
public class MenuInterface
{
	private final Scanner s;
	private ISpriteFactory spriteFactory;
	private String shapeType;
	private ScreenInit sharedBuff;


	public MenuInterface(ScreenInit sharedBuff)
	{
		this.sharedBuff = sharedBuff;
		this.spriteFactory = new SpriteFactory();
		this.s = new Scanner(System.in);

		printIntro();

		while(true)
		{
		       shapeType = getOption();
		       

		       if(shapeType.equals("c"))
		       {

				break;
		       }
		       //might be completely unnecessary 
		       try {
		            String test = shapeType + "2";
		       } catch (Exception e) {
			    print("Please type a String");
			    continue;
		       }

		       selectType(shapeType); 

		       sharedBuff.drawSprites();
		}

		print("Thank you!");
		


	}
        
	private String getOption()
	{
		String type = s.next();
		return type;
	}


	
	private void selectType(String type)
	{
	    Scanner XYReciever = new Scanner(System.in);

		switch(type.toLowerCase())
		{
			case "square":
			     print("------------------------");
			     print("Provide the Length");
		             
			     System.out.print("X: ");
			     int x = XYReciever.nextInt();
			     print("Provide the Height");
			     System.out.print("Y: ");
			     int y = XYReciever.nextInt();

			     print("Would you like to fill in the shape? type y/n");
			     
			     char reply = XYReciever.nextChar();
			     boolean fill = false;
			     if(reply == 'y')
			     {
			     	fill = true;
			     }
				
		             spriteFactory.clear();
			     spriteFactory.setWidth(x);
			     spriteFactory.setHeight(y);

			     sharedBuff.addSprite(spriteFactory.produceSprite(type.toLowerCase(), fill));



			break;
			case "triangle":
			     
			     print("Provide the Height");
			     System.out.print("Y: ");
			     int y = XYReciever.nextInt();

			     print("Would you like to fill in the shape? type y/n");
			     
			     char reply = XYReciever.nextChar();
			     boolean fill = false;
			     if(reply == 'y')
			     {
			     	fill = true;
			     }
				
		             spriteFactory.clear();
			   
			     spriteFactory.setHeight(y);

			     sharedBuff.addSprite(spriteFactory.produceSprite(type.toLowerCase(), fill));

			break;
			case "circle":
			     print("Provide the Radius");
			     System.out.print("R: ");
			     int r = XYReciever.nextInt();

			     print("Would you like to fill in the shape? type y/n");
			     
			     char reply = XYReciever.nextChar();
			     boolean fill = false;
			     if(reply == 'y')
			     {
			     	fill = true;
			     }
				
		             spriteFactory.clear();
			   
			     spriteFactory.setRadius(r);

			     sharedBuff.addSprite(spriteFactory.produceSprite(type.toLowerCase(), fill));
			
			break;
			
			case "done":
				return;
			break;

			default:
			      print("Not a valid option");

			break;


		}

	}
	
	private void printIntro()
	{
		print("Welcome to the Drawing Shapes Interface \n \t Choose between the three shape options and type DONE to draw all on screen at once (type character C to quit");
		print("\t\t Square");
		print("\t\t Circle");
		print("\t\t Triangle");

	}

	private void print(String text)
	{
		System.out.println(text);
	}
}
