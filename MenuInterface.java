import java.util.Scanner;
public class MenuInterface
{
	private final Scanner s;
	private ISpriteFactory spriteFactory;
	private String shapeType;
	private ScreenInit sharedBuff;
	private int maxDimensionX;
	private int maxDimensionY;


	public MenuInterface(ScreenInit sharedBuff)
	{
		this.sharedBuff = sharedBuff;
		this.spriteFactory = new SpriteFactory();
		this.s = new Scanner(System.in);
		this.maxDimensionX = sharedBuff.getMaxX();
		this.maxDimensionY = sharedBuff.getMaxY();
		
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
		System.out.print("Shape: ");
		String type = s.next();
		print("");
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
			case "clean":
		 	     sharedBuff.clear();
			      print("Board has been cleared");
			      return;

			case "draw":
			      sharedBuff.drawSprites();
			      return;
			
			default:
			      print("Not a valid option");
                              return;
			


		}    
			     int[] Coordposition = getPosition();
			     fill = getFill();
			     this.spriteFactory.clear();
			     this.spriteFactory.setWidth(XX);
			     this.spriteFactory.setHeight(YY);
			     this.spriteFactory.setRadius(RR);

			     this.sharedBuff.addSprite(spriteFactory.produceSprite(type.toLowerCase(), fill, Coordposition));
			     print("Sprite added");
			     print("---------------------------");
	}


        private int[] getPosition()
	{
		print("Where would like to draw it on the map? (Max: "+ maxDimensionX +", " + maxDimensionY+ ")");
		System.out.print("xCoord: ");
		int valueX = s.nextInt();
		print("");
		System.out.print("yCoord: ");
		int valueY = s.nextInt();

		int[] coords = {valueX, valueY};

		return coords;

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
		print("Welcome to the Drawing Shapes Interface \n \t" +
		"Currently the Size of buffer is set to X: " + maxDimensionX + " and Y: " + maxDimensionY +
		"\n \t Choose between the three shape options and type DRAW to draw" +
		"\n \t all the shapes on screen at once. " +
		"\n \tYou can also clean the board by typing CLEAN (type character C to quit)");
		print("\t\t 1. Square");
		print("\t\t 2. Circle");
		print("\t\t 3. Triangle");

	}

	private void print(String text)
	{
		System.out.println(text);
	}
}
