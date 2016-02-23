package Assignment3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class A3Driver 
{
	public static String[] states = {"AL", "AK", "AS", "AZ", "AR", "CA", "CO", "CT", "DE", "DC", "FM", "FL", "GA", "GU", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MH", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "MP", "OH", "OK", "OR", "PW", "PA", "PR", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VI", "VA", "WA", "WV", "WI", "WY", "AE", "AA", "AP"};
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
				System.err.println("Invalid Input");
				continue; //checkErrors will print whatever error there was in the input
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
			} 
			else if (splitString[0].toLowerCase().equals("print"))
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
			  if(splitString[1].toLowerCase().equals("groceries")){
				  if(splitString.length < 7 || splitString.length > 7) //i am guessing that more than standard amount of inputs is wrong
				  {
					  return true;
				  }
				  else if((splitString[3].matches("\\d*\\.?\\d{0,2}$") || splitString[3].matches("\\d+\\.?$")) && !splitString[3].equals(".")){
					  if((splitString[4].matches("\\d*")))
					  {
						  if((splitString[5].matches("\\d*")))
						  {
							  if(splitString[6].toLowerCase().equals("np") || splitString[6].toLowerCase().equals("p")){
								  return false;
							  }
						  }
					  }
				  }
			  }
			  else if(splitString[1].toLowerCase().equals("electronics")){
				  if(splitString.length < 8 || splitString.length > 8) //i am guessing that more than standard amount of inputs is wrong
				  {
					  return true;
				  }
				  else if((splitString[3].matches("\\d*\\.?\\d{0,2}$") || splitString[3].matches("\\d+\\.?$")) && !splitString[3].equals(".")){
					  if((splitString[4].matches("\\d*")))
					  {
						  if((splitString[5].matches("\\d*")))
						  {
							  if(splitString[6].toLowerCase().equals("f") || splitString[6].toLowerCase().equals("nf")){
								  if(Arrays.asList(states).contains(splitString[7].toUpperCase())){
									  return false;
								  }
							  }
						  }
					  }
				  }
				  
			  }
			  else if(splitString[1].toLowerCase().equals("clothing")){
				  if(splitString.length < 6 || splitString.length > 6) //i am guessing that more than standard amount of inputs is wrong
				  {
					  return true;
				  }
				  else if((splitString[3].matches("\\d*\\.?\\d{0,2}$") || splitString[3].matches("\\d+\\.?$")) && !splitString[3].equals(".")){
					  if((splitString[4].matches("\\d*")))
					  {
						  if((splitString[5].matches("\\d*")))
						  {
							  return false;
						  }
					  }
				  }
			  }
		  }
		  else if (splitString[0].toLowerCase().equals("search"))
		  {
			  
		  }
		  else if (splitString[0].toLowerCase().equals("delete"))
		  {
			  return false;
		  }
		  else if (splitString[0].toLowerCase().equals("update"))
		  {
			  
		  }
		  else if (splitString[0].toLowerCase().equals("print"))
		  {
				return false;
		  }
		  return true; //false if no errors
	  }
}
	  