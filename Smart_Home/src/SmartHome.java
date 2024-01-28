/**
 * Name: Naylene Rondon
 * 
 * Florida Tech CIS 2503
 * 1.7 Programming Assignment
 * 
 * Date Last Modified: 1/13/24
 * 
 * Purpose:
 * To accept user commands. Specific commands will allow user to control their smart homes devices.
 * Users will be able to adjust temperature, music, television, light, phone, and answer doorbell
 *
 */

import java.util.*;
import java.util.regex.*;
import java.io.*;

public class SmartHome 
{

	public static void main(String[] args) //main method allows input and creates instance variables
	{
		//Variables
		double temperature = 70.0;
		String acSetting = "Off"; 
		
		boolean musicPlaying;
		String track;
		
		boolean tvPlaying;
		String channel;
		
		String[] roomNames = new String[]{"Bedroom", "Kitchen", "Living room", "Bathroom", "Garage"};
		int roomIndex = -1;
		String roomInput;
		boolean [] lightTracking = new boolean [5]; //true light is on, false light is off
		
		boolean validNumber;
		
		Scanner console = new Scanner(System.in);
		String command;
		
		
		
		System.out.println("Welcome home! What would you like to do?" );
		System.out.println("Type \"Help\" for a list of options");
		//Allowing Inputs
		while (true)
		{
			command = console.nextLine();
			
			if(command.equalsIgnoreCase("Help")) //Triggers options for User
			{
				helpOptions();
			}
			
			if(command.equalsIgnoreCase("Change temperature")) //Adjusts the thermostat
			{
				System.out.println("What temperature would you like?");
				double updatedTemperature =  console.nextDouble();
				acSetting = assigningAcStatus (temperature, updatedTemperature);
				temperature = updatedTemperature;
				
				System.out.print("The temperature is now: ");
				System.out.println(temperature);
				System.out.print("A/C status: ");
				System.out.println(acSetting);
			}
			
			//Tracking Lights
			if(command.equalsIgnoreCase("Turn on light"))
			{
				System.out.println("Which room should I turn on?");
				roomInput =  console.nextLine();
				
				roomIndex = findRoomIndex(roomInput, roomNames);
				if (roomIndex == -1)
				{
					System.out.println("That's an invalid choice. Please put in a new command. What would you like to do?");
				}
				else
				{
					lightTracking[roomIndex] = true; //true means light is on
					System.out.print(roomNames[roomIndex]);
					System.out.println(" is currently on.");
				}
			}
			
			if(command.equalsIgnoreCase("Turn off light"))
			{
				System.out.println("Which room should I turn on?");
				roomInput =  console.nextLine();
				
				roomIndex = findRoomIndex(roomInput, roomNames);
				if (roomIndex == -1)
				{
					System.out.println("That's an invalid choice. Please put in a new command. What would you like to do?");
				}
				else
				{
					lightTracking[roomIndex] = false; //false means light is off
					System.out.print(roomNames[roomIndex]);
					System.out.println(" is currently off.");
				}
			}
			
			//Playing and stopping Music
			if(command.equalsIgnoreCase("Play music"))
			{
				System.out.println("What song would you like to play?");
				track =  console.nextLine();
				track = findSong(track);
				if (track != "")
				{
					System.out.println (track + " is now playing");
					musicPlaying = true;
				}
			}
			
			if(command.equalsIgnoreCase("Stop music"))
			{
					System.out.println ("Music is now off");
					musicPlaying = false;
			}
			
			//Turning on and off TV
			if(command.equalsIgnoreCase("Turn on television"))
			{
				System.out.println("What channel would you like to watch?");
				channel =  console.nextLine();
				channel = findChannel(channel);
				if (channel != "")
				{
					System.out.println (channel + " is now playing");
					tvPlaying = true;
					System.out.println("Would you like to dim the lights?");
					String dimLights = console.nextLine();
					if(dimLights.equalsIgnoreCase("yes"))
					{
						lightTracking[2] = false; //turning off living room lights
						System.out.println("Living room lights are now off");
					}
				}
			}
			
			if(command.equalsIgnoreCase("Turn off television"))
			{
					System.out.println ("Television is now off");
					tvPlaying = false;
			}
			
			//Answering the doorbell
			if(command.equalsIgnoreCase("Answer doorbell"))
			{
				musicPlaying = false;
				tvPlaying = false;
				System.out.println ("All audio devices were turned off. What message would you like to send?");
				String message =  console.nextLine(); //message to whoever is at the door
				System.out.println ("The following message was sent to your guest: ");
				System.out.println (message);
			}
			
			//Making a call
			if(command.equalsIgnoreCase("Make a call"))
			{
				musicPlaying = false;
				tvPlaying = false;
				System.out.println ("All audio devices were turned off. Please enter a number:");
				String phone =  console.nextLine();
				validNumber = validPhone(phone);
				
				if(validNumber == true)
				{
					System.out.println ("Calling " + phone);
				}
				
				else
				{
					System.out.println ("That's an invalid number");
				}
			}
			
			
			if(command.equalsIgnoreCase("Close system"))
			{
				System.out.println("Shutting down");
				console.close();
				break; // end the system and stop the loop
			}
		}
		
	}
	
	public static void helpOptions() //Provides a list of options to input when user requests "Help"
	{
		System.out.println("Here are a list of options to choose from:");
		System.out.println("Change temperature");
		System.out.println("Play music");
		System.out.println("Stop music");
		System.out.println("Turn on television");
		System.out.println("Turn off televsion");
		System.out.println("Turn on light");
		System.out.println("Turn off light");
		System.out.println("Make a call");
		System.out.println("Answer doorbell");
		System.out.println("Close system");
	}
	
	public static String assigningAcStatus (double original, double updated) //Determines if AC should be on heat or cool
	{
		if (original > updated)
		{
			return "Cool";
		}
		else if (updated > original)
		{
			return "Heat";
		}
		else
		{
			return "Off";
		}
	}
	
	public static int findRoomIndex (String input, String [] roomName) //find the room index to ensure it's in the list of rooms
	{
		for (int i = 0; i < roomName.length; i++)
		{
			if (roomName[i].equalsIgnoreCase(input))
			{
				return i;
			}
		}
		
		return -1; //returns -1 if invalid
	}
	
	public static String findSong(String inputSong) //Reads song list from txt files and confirms inputed song is listed
	{
	    try (Scanner songList = new Scanner(new FileReader("src/songs.txt"))) 
	    {
	        List<String> availableSongs = new ArrayList<>();
	        while (songList.hasNextLine()) 
	        {
	            availableSongs.add(songList.nextLine());
	        }

	        for (String song : availableSongs) 
	        {
	            if (song.equalsIgnoreCase(inputSong)) 
	            { 
	                return song;
	            }
	        }

	        System.out.println("That song is not in the list. Songs available are: ");
	        System.out.println(availableSongs);
	        return ""; //returns an empty string if invalid
	    } 
	    catch (FileNotFoundException e) 
	    {
	        System.err.println("Error reading songs.txt: " + e.getMessage());
	        return "";
	    }
	}
	
	public static String findChannel(String inputChannel) //Reads channel list from txt files and confirms inputed channel is listed
	{
	    try (Scanner channelList = new Scanner(new FileReader("src/channels.txt"))) 
	    {
	        List<String> availableChannels = new ArrayList<>();
	        while (channelList.hasNextLine()) 
	        {
	        	availableChannels.add(channelList.nextLine());
	        }

	        for (String channel : availableChannels) 
	        {
	            if (channel.equalsIgnoreCase(inputChannel)) 
	            { 
	                return channel;
	            }
	        }

	        System.out.println("That channel is not in the list. Channels available are: ");
	        System.out.println(availableChannels);
	        return "";   //returns an empty string if invalid
	    } 
	    catch (FileNotFoundException e) 
	    {
	        System.err.println("Error reading channels.txt: " + e.getMessage());
	        return ""; 
	    }
	}
	
	public static boolean validPhone (String phoneNumber) // Makes sure the string has 10 numerical digits
	{
		Pattern pattern = Pattern.compile("^\\d{10}$");
		
		Matcher match = pattern.matcher(phoneNumber);
		
		return (match.matches());
		
	}
}

