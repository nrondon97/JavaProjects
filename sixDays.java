//Naylene Rondon
//FIT 1502 Section 3.4
//Programming Exercise #1
//Printing the song Six says of Christmas
public class sixDays
{

	public static void main (String [] args) 
	{
		int i; //initializing counter
		
		for (i= 1; i<= 6; i++) //loop for each of the verses
		{
			firstLine (i);
		}
	}
	
	public static void firstLine (int verse) //Call a custom first line for each day and verse needed per day
	{
		
		if (verse == 1)
		{
			System.out.println("On the 1st day of Christmas, my true love sent to me ");
			firstVerse ();
		}
		else if (verse == 2)
		{
			System.out.println("On the 2nd day of Christmas, my true love sent to me");
			secondVerse ();
		}
		else if (verse == 3)
		{
			System.out.println("On the 3rd day of Christmas, my true love sent to me ");
			thirdVerse ();
		}
		else if (verse == 4)
		{
			System.out.println("On the 4th day of Christmas, my true love sent to me");
			fourthVerse ();
		}
		else if (verse == 5)
		{
			System.out.println("On the 5th day of Christmas, my true love sent to me ");
			fifthVerse ();
		}
		else if (verse == 6)
		{
			System.out.println("On the 6th day of Christmas, my true love sent to me ");
			sixthVerse ();
		}
	}
	
	public static void firstVerse () //first verse
	{
		System.out.println("a partridge in a pear tree.");
	}

	public static void secondVerse () //second verse and calls first verse
	{
		System.out.println("two turtle doves, and");
		firstVerse ();
	}

	public static void thirdVerse () // third verse and calls previous verse
	{
		System.out.println("three French hens,");
		secondVerse ();
	}

	public static void fourthVerse () //fourth verse and calls previous verse
	{
		System.out.println("four calling birds,");
		thirdVerse ();
	}

	public static void fifthVerse () //fifth verse and calls previous verse
	{
		System.out.println("five golden rings,");
		fourthVerse ();
	}

	public static void sixthVerse () //sixth verse and calls previous verse
	{
		System.out.println("six geese a-laying,");
		fifthVerse ();
	}
}
