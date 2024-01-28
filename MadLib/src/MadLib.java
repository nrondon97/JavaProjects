/**
 * Name: Naylene Rondon
 * 
 * Florida Tech CIS 2503
 * 3.5 Programming Assignment
 * 
 * Date Last Modified: 1/28/24
 * 
 * Purpose:
 * To randomly fill in a Madlib about a beach day
 *
 */
//Imports
import java.util.*;
import java.io.*;

public class MadLib
{
    public static void main (String [] args)
    {
        story(); //Calls the madlib story
    }

    public static void story () //This is the story for the mad lib, it also calls for the random words needed
    {
        
        System.out.print(" I went to the beach in ");
        randomWord("places");
        System.out.print(" today with ");
        randomWord("names");
        System.out.print(".\n We had a ");
        randomWord("adjective");
        System.out.print(" time.\n We first built a ");
        randomWord("nouns");
        System.out.print(" and then we ran around in the ");
        randomWord("nouns");
        System.out.print(" for a little while.\n The water was a bit ");
        randomWord("adjective");
        System.out.print(".\n The sun was very ");
        randomWord("adjective");
        System.out.print(" so we made sure to wear a lot of ");
        randomWord("nouns");
        System.out.print(".\n We spent ");
        randomWord("numbers");
        System.out.print(" hours there.\n At the end of the day, we treated ourselves to a ");
        randomWord("nouns");
        System.out.print(" and had ");
        randomWord("food");
        System.out.print(" for dinner.\n I definitely want to go to the beach again, but next time I want to ");
        randomWord("verbs");
        System.out.print(".");
    }

    public static void randomWord (String type) //This generates a random word from the correct file
    {
        String fillWord = "";
        String fileName = type + ".txt";
        int randomNum;
        ArrayList <String> wordList = new ArrayList <String> ();
        File fileReader = new File("src/"+fileName);
        try(Scanner sc = new Scanner(fileReader);)
        {
	        Random randomSelect = new Random();
	        while(sc.hasNextLine())
	            {
	                wordList.add(sc.nextLine());//Adds to an arraylist
	            }
	        randomNum = randomSelect.nextInt(wordList.size()); //Generates a random number to select a word from the list
	        fillWord = wordList.get(randomNum);
	        printWord(fillWord, type);
        }
        catch (FileNotFoundException e) 
	    {
	        System.err.println("Error reading channels.txt: " + e.getMessage()); //error
	    }
    }
    
    public static void printWord(String fillWord, String type) //checks to see if repeat. If not it gets printed
    {
    	ArrayList <String> wordTracker = new ArrayList <String> ();
    	
    	if (wordTracker.contains(fillWord)== true)
    	{
    		randomWord(type); //Generates a new word if it's a repeat
    	}
    	else
    	{
    		wordTracker.add(fillWord);
    		System.out.print(fillWord);
    	}
    }
    


}