# JavaProjects
This will have all my exercises and projects from my CIS 1502 class. This will also incluse all my java tests. I'll expand upon this ReadMe as new changes occur.

Current Projects in this repository:

SixDays
This is a Java and class file that prints out a shortened version of the song 12 days of christmas. It was an experiment with methods. The goal was to minimze redundancies whereever possible while also having a unique method for each verse. 
I chose to use the main method to create for loop that called a single method 6 times. This was the firstLine method what would print a custom beginning line for each verse and trigger the method what would print out the rest of the verse. 
However since that song repeated many of the lines after the first verse, I needed a way to call the previous verse as well. 
In the method that called the verse, if calso called all the verses prior to it. 
The best example would be verse six.
Main called firstLine with the int 6. This printed the first line in verse 6 and called the sixthVerse Method. 
The sixthVerse method printed the unique line for the 6th verse and called the fifthVerse method. 
The fifthVerse method called it's unique line and called the fourthVerse method. This continues until it ends back at the firstVerse method where it finally ends. 
