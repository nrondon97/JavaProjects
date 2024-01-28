/**
 * Name: Naylene Rondon
 * Florida Tech 1502
 * Programming Exercise #3
 * 
 * This program is designed for a guessing game. It will prompt how many games you like between 3 and 5 and allow you to pick the range. 
 * From there you try to guess the random numbers. It will give you scores for each round and a final score at the end.
 * 
 * This code is mine alone and I adhered to the academic integrity as outlined in the student handbook.
 */

import java.util.*; //import util tools such as scanner and random
public class Guess //Class
{
	//Variables
	private int numGames = 0; //number of games to play
	private int numRange = 0; //maximum value for range
	private int roundTracker = 1; //tracking which round the player is at
	private int [] guessTracker; //Track the amount of guesses for each game
	private double [] averageTracker; //Track the average scores for each game
	private boolean firstTime = true; //This is for the range, allows different prompts depending if the first attempt was incorrect
	//Scanner
	Scanner input = new Scanner(System.in);
	
	
	
	public void setGames ()// Setup the number of games to play
	{
		int tempNum = 0; //To hold value until it's been verified
		System.out.println("How many games do you want to play?"); //question
		tempNum = input.nextInt(); //accept input
		
		if ((tempNum >= 3 ) && (tempNum <= 5)) //Ensuring value is within 3-5 games
		{
			numGames = tempNum; //Accept value if correct
			guessTracker = new int [numGames];
			averageTracker = new double [numGames];
		}
		else //If values are not between 3 and 5
		{
			System.out.println("I’m sorry.  We must play between 3 and 5 games."); // Apologize
			setGames(); //Recall method to attempt to get a correct value
		}
		
	}
	
	public void setRange ()// Setup the range of numbers
	{
		int tempNum = 0; //To hold value until it's been verified
		
		if (firstTime == true)
		{
			System.out.println("For these " + numGames + " games, what is the range of numbers we are going to use?  1 to __?"); //question
			tempNum = input.nextInt(); //accept input
			firstTime = false;
		}
		
		else
		{
			System.out.println("Acceptable answers are 50, 100, 200 or 500.  Please respond:"); //question
			tempNum = input.nextInt(); //accept input
		}
		
		if ((tempNum == 50) || (tempNum == 100) ||(tempNum == 200) ||(tempNum == 500))//Ensuring value is accepted
		{
			numRange = tempNum; //Accept value if correct
			System.out.println("\n\nGood luck!"); //A goodbye phrase
			
		}
		else //If values are not between 3 and 5
		{
			setRange(); //Recall method to attempt to get a correct value
		}
		
	}
	
	public int randomNum ()// Get the random number
	{
        Random ranNum = new Random(); //Call random Class
		int secretNum = ranNum.nextInt(numRange); //generate the number the user is trying to get
		secretNum = secretNum + 1; //Make sure it's not 0;
		return secretNum; //return value
	}
	
	public void directions() //Directions I didn't following the formatting exactly since it look like it was designed for a narrow window
	{
		System.out.println("This program allows you to play a game.");
		System.out.println("I will think of a number between 1 and "+ numRange + " and will allow you to try to determine it.");
		System.out.println("\nFor each try, I will tell you whether the right answer is higher or lower than your try.");
	}
	
	public void Gameplay() //this is the gameplay of each round
	{
		int tracker = roundTracker; //Finding out which round is happening
		int attempts = 0; //the number of attempts
		int sumResults =0; //adding the results together for future value
		int difference = 0; //intialize the difference holder
		int secretNum = randomNum();// Trigger the random number for this round
		int guesses = 0; //Storing the guess value to compare to if statements
		if (tracker == 1) //See if this is the first game
		{
			directions();//Trigger directions
		}
		else
		{
			System.out.println("\nGame "+ tracker +" begins now:"); //Little introduction to game 2 and more
		}
		
		System.out.println("I'm thinking of a number...");//Cute little message to start the round
		
		do //loop
		{
			System.out.print("Your Try?"); //prompt
			guesses = input.nextInt(); //user guess
			attempts++;
			difference = Math.abs( secretNum - guesses);
			sumResults += difference;
			
			if (guesses > secretNum) //if they need to guess lower
			{
				System.out.println("lower"); //output
			}
			else if (guesses < secretNum) //if they need to guess higher
			{
				System.out.println("higher"); //output
			}
		}
		while (guesses != secretNum); //continue loop until guessed correctly
		
		roundEnd(sumResults, attempts);	
		
	}
	
	public void roundEnd(int sum, int attempts) //this is the conclusion of each round
	{
		double average = sum/attempts; //get the avaerage for this round
		
		System.out.println("Game " + roundTracker + ":"); //output
		System.out.println("You got it right "+ attempts +" guesses."); //output
		System.out.println("You were off by an average of "+ average +" per guess."); //output
		guessTracker[roundTracker - 1] = attempts; //add value into array
		averageTracker[roundTracker - 1] = average; //add value into array
		roundTracker++; //increase the tracker
		
		if (roundTracker > numGames)//Trigger Conclusion 
		{
			gameEnd();//trigger end of game
		}
		
		else
		{
			Gameplay();//trigger next round
		}

	}
	
	public void gameEnd() //this is the conclusion of the game
	{
		//lowest guesses
		int lowestGuess = guessTracker[0];//Initializing variable
		int guessIndex = 0;//Initializing variable
		
		for(int i=0; i < guessTracker.length; i++) //For loop to find lowest amount of guesses
		{ 
			if(lowestGuess > guessTracker[i]) //if statement to identify lowest
	        {
				lowestGuess = guessTracker[i];//assign to variable
				guessIndex = i;//assign to variable
	        }
		}
		System.out.println("Your best game in terms of lowest guesses was Game # " + (guessIndex + 1) +" when you solved the game in " + lowestGuess +" guesses."); //Lowest # Guesses
		
		//closest guesses
		double closestGuess = averageTracker[0];//Initializing variable
		int averageIndex = 0;//Initializing variable
		
		for(int i=0; i < averageTracker.length; i++) //For loop to find closest amount of guesses
		{ 
			if(closestGuess > averageTracker[i]) //if statement to identify best average
	        {
				closestGuess = averageTracker[i]; //assign to variable
				averageIndex = i; //assign to variable
	        }
		}
		System.out.println("Your best game in terms of closest guesses was Game # " + (averageIndex + 1) +" when you were off by an average of " + closestGuess +"."); //Closest Guesses
		
		if(guessIndex == averageIndex) // if the rounds were the same give a special message
		{
			System.out.println("You did amazing on Game # " + (averageIndex + 1) +"! Not only did you have the lowest guesses in that round, but they were also the closest. You did amazing!"); //special message for a good game
		}
	}
	
	public static void main(String[] args) //main
	{
		System.out.println("Let’s play a number guessing game."); //Quick introduction
		Guess guessingGame = new Guess();//Call the class
		guessingGame.setGames(); //Calling first method to set the number of games
		guessingGame.setRange(); //Setup the range of numbers
		guessingGame.Gameplay(); //begin the game

	}

}
