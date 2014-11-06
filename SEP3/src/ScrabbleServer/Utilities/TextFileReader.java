//*****************************************************************************
//File name  : FileReader.java
//Start date : Mar 24, 2012
//Programmer : Hans So.
//Java       : Java 1.6.0 
//Description: 
//
//Revision history:
//date     init  comment
//
//			MODIFIED TO ONLY ADD WORD ONCE!!!!!
//*****************************************************************************

package ScrabbleServer.Utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TextFileReader
{ 
public static ArrayList<String> readFile(String fileName)
{
 ArrayList<String> wordList = new ArrayList<String>();
 BufferedReader input;
 try
 {
   input = new BufferedReader(new FileReader(fileName));
   
   // delimeter is "space"
   char [] parse = {' '};
   String delims = new String(parse);

   // read first line
   String line = input.readLine();

   // read line while end of file
   while(line != null)
   {
     String [] lineWords = line.split(delims);

     // add the words to the list
     for (int i = 0; i < lineWords.length; i++) 
     {
    	   wordList.add(lineWords[i]);
     }
     // read next line
     line = input.readLine();
   }

   
 }
 catch (FileNotFoundException e)
 {      
   e.printStackTrace();
 }
 catch (IOException e)
 {
   e.printStackTrace();
 }
 
 return wordList;
}

public static ArrayList<String> readFileNoDoubles(String fileName)
{
 ArrayList<String> wordList = new ArrayList<String>();
 BufferedReader input;
 try
 {
   input = new BufferedReader(new FileReader(fileName));
   
   // delimeter is "space"
   char [] parse = {' '};
   String delims = new String(parse);

   // read first line
   String line = input.readLine();

   // read line while end of file
   while(line != null)
   {
     String [] lineWords = line.split(delims);

     // add the words to the list
     for (int i = 0; i < lineWords.length; i++) 
     {
    	 boolean doubleGanger = false;
       for(int j = 0; j < wordList.size(); j++) //Implement better search
    	   {
    	   		if(lineWords[i].equalsIgnoreCase(wordList.get(j)))
    	   			{
    	   				doubleGanger = true;
    	   				break;
    	   			}
    	   }
       if(!doubleGanger)
       {
    	   wordList.add(lineWords[i]);
       }
     }
     // read next line
     line = input.readLine();
   }
   
 }
 catch (FileNotFoundException e)
 {      
   e.printStackTrace();
 }
 catch (IOException e)
 {
   e.printStackTrace();
 }
 
 return wordList;
}
public static String[] readFileToArray(String fileName)
{
  ArrayList<String> wordList = new ArrayList<String>();
  String[] result = null;
  BufferedReader input;
  try
  {
    input = new BufferedReader(new FileReader(fileName));
    
    // delimeter is "space"
    char [] parse = {' '};
    String delims = new String(parse);
 
    // read first line
    String line = input.readLine();
 
    // read line while end of file
    while(line != null)
    {
      String [] lineWords = line.split(delims);
 
      // add the words to the list
      for (int i = 0; i < lineWords.length; i++) 
      {
        wordList.add(lineWords[i]);                                
      }
      // read next line
      line = input.readLine();
    }
    result = new String[wordList.size()];
    wordList.toArray(result);
    
  }
  catch (FileNotFoundException e)
  {      
    e.printStackTrace();
  }
  catch (IOException e)
  {
    e.printStackTrace();
  }
  
  return result;
}

}

