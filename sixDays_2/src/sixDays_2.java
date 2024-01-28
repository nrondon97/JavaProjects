//Naylene Rondon
//FIT 1502 Section 3.4
//Programming Exercise #1 Part 2
//Printing the song Six days of Christmas
public class sixDays_2
{

	public static void main (String [] args) //Calls all the verses in order
	{
		firstLine (1);
		firstLine (2);
		firstLine (3);
		firstLine (4);
		firstLine (5);
		firstLine (6);
		
	}
	
	
	public static void firstLine (int verse) //Call a custom first line for each day and verse needed per day
	{
		
		if (verse == 1)
		{
			System.out.println("On the 1st day of Christmas, my true love sent to me "); //Day 1
			firstVerse ();
		}
		else if (verse == 2)
		{
			System.out.println("On the 2nd day of Christmas, my true love sent to me"); //Day 2
			secondVerse ();
		}
		else if (verse == 3)
		{
			System.out.println("On the 3rd day of Christmas, my true love sent to me "); // Day 3
			thirdVerse ();
		}
		else if (verse == 4)
		{
			System.out.println("On the 4th day of Christmas, my true love sent to me"); // Day 4
			fourthVerse ();
		}
		else if (verse == 5)
		{
			System.out.println("On the 5th day of Christmas, my true love sent to me "); // Day 5
			fifthVerse ();
		}
		else if (verse == 6)
		{
			System.out.println("On the 6th day of Christmas, my true love sent to me "); // Day 6
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
