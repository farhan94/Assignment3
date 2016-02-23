package Assignment3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class A3Driver 
{
	  public static void main(String[] args) 
	  {
		//Open file; file name specified in args (command line)
		
		if (args.length != 1) 
		{
			System.err.println ("Error: Incorrect number of command line arguments");
			System.exit(-1);
		}
		
		ArrayList<String> input = new ArrayList<String>();
		processLinesInFile (args[0], input);
		
		Iterator<String> s = input.iterator();
		ArrayList<Item> shoppingCart = new ArrayList<Item>();
		
		while (s.hasNext()){
			String temp = s.next();
			String[] splitString = temp.split(" ");
			
			//maybe check for errors in the split string, instead of before splitting????
			if (checkErrors(splitString))
			{
				continue; //checkErrors will print whatever error there was in the input, so all we need to do is end the program
			}
			
			if (splitString[0].toLowerCase().equals("insert"))
			{
				Item.evaluateInput(splitString, shoppingCart);
			}
			else if (splitString[0].toLowerCase().equals("search"))
			{
				Item.search(splitString[1], shoppingCart);
			}
			else if (splitString[0].toLowerCase().equals("delete"))
			{
				Item.delete(splitString[1], shoppingCart);
			}
			else if (splitString[0].toLowerCase().equals("update"))
			{
				Item.update(splitString[1], splitString[2], shoppingCart);
			} else if (splitString[0].toLowerCase().equals("print"))
			{
				Item.print(shoppingCart);
			}
		}		
	  }
	  
	  public static void processLinesInFile (String filename, ArrayList<String> input) 
		{ 

			try 
			{
				FileReader freader = new FileReader(filename);
				BufferedReader reader = new BufferedReader(freader);
				
				for (String s = reader.readLine(); s != null; s = reader.readLine()) 
				{
					input.add(s);
				}
				
			} 
			catch (FileNotFoundException e) 
			{
				System.err.println ("Error: File not found. Exiting...");
				e.printStackTrace();
				System.exit(-1);
			} catch (IOException e) 
			{
				System.err.println ("Error: IO exception. Exiting...");
				e.printStackTrace();
				System.exit(-1);
			}
		}
	  
	  public static boolean checkErrors(String[] splitString)
	  {
		  if(splitString.length < 1)
		  {
			  return true;
		  }
		  if (splitString[0].toLowerCase().equals("insert"))
		  {
			  
		  }
		  else if (splitString[0].toLowerCase().equals("search"))
		  {
			  
		  }
		  else if (splitString[0].toLowerCase().equals("delete"))
		  {
			  
		  }
		  else if (splitString[0].toLowerCase().equals("update"))
		  {
			  
		  }
		  else if (splitString[0].toLowerCase().equals("print"))
		  {
				
		  }
		  return false; //false if no errors
	  }
}
	  