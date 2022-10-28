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
		       

		       selectType(shapeType); 

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
            int XX = 0;
	    int YY = 0;
	    int RR = 0;
	    char reply;
	    boolean fill;
            
	    print("---------------------------");

		switch(type.toLowerCase())
		{
			case "square":
			     XX = getDimension("length");
			     YY = getDimension("height");
			break;
			case "triangle":
			     YY = getDimension("height");			
			break;
			case "circle":
			     RR = getDimension("radius"); 						
			break;
			case "done":
			      sharedBuff.drawSprites();
			      return;
			
			default:
			      print("Not a valid option");
                              return;
			


		}     
			     fill = getFill();
			     this.spriteFactory.clear();
			     this.spriteFactory.setWidth(XX);
			     this.spriteFactory.setHeight(YY);
			     this.spriteFactory.setRadius(RR);

			     this.sharedBuff.addSprite(spriteFactory.produceSprite(type.toLowerCase(), fill));
	}




 	private boolean getFill()
	{
		print("Would you like to fill in the shape? type y/n");

	        boolean decision = false;
		char yesNo = s.next().charAt(0);
		if(yesNo == 'y')
		{
			decision = true;
		}
		return decision;
	}

	private int getDimension(String type)
	{
		char wordType = 'N';
		if(type.equals("radius"))
		{
			wordType = 'R';
		} else if(type.equals("height"))
		{
			wordType = 'Y';
		} else if(type.equals("length"))
		{
			wordType = 'X';
		}
		
          	print("Please provide a " + type);
		System.out.print(wordType +": ");
		int value = s.nextInt();

		return value;
		
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
