/*
 * Assignment 3
 * Section: TH: 2:00
 *Farhan Ali FA7674
 * Thomas Leahy TPL335
 */

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
		
		if (args.length != 1) //checking if any file name was passed through, if it wasn't print error and end
		{
			System.err.println ("Error: Incorrect number of command line arguments");
			
			System.exit(-1);
		}
		
		ArrayList<String> input = new ArrayList<String>();	//will store the transaction inputs, line by line
		processLinesInFile (args[0], input); 				// putting the transaction inputs in input
		
		Iterator<String> s = input.iterator();		//iterating through input
		ArrayList<Item> shoppingCart = new ArrayList<Item>();	// will store items (shopping cart)
		
		while (s.hasNext())
		{	
			Collections.sort(shoppingCart, new CustomComparator()); //alphabetizing shopping cart
			String temp = s.next();
			String[] splitString = temp.split(" ");	//spliting an element of input by the spaces
			
			if (checkErrors(splitString)) //checking for input errors
			{
				System.out.println("Invalid Input");
				System.out.println ("");
				continue; //checkErrors will print whatever error there was in the input and go to next element in iterator
			}
			
			if (splitString[0].toLowerCase().equals("insert"))
			{
				//this will add the proper object to the shoppingCart.
				Item.evaluateInput(splitString, shoppingCart);
			}
			else if (splitString[0].toLowerCase().equals("search"))
			{
				//this will search for the item with the name specified in the splitString that is in the shoppingCart, and it will print the item’s info.
				Item.search(splitString[1], shoppingCart); 
			}
			else if (splitString[0].toLowerCase().equals("delete"))
			{
				//this method will search for all items matching the name in splitString and delete all values
				// with the  same name from the shopping cart
				Item.delete(splitString[1], shoppingCart);
			}
			else if (splitString[0].toLowerCase().equals("update"))
			{
				//this will search for the first occurrence of the item with the name specified in splitString
				//and it will change its quantity to the one specified in splitString
				Item.update(splitString[1], splitString[2], shoppingCart);
			} 
			else if (splitString[0].toLowerCase().equals("print"))
			{
				//this will print information of items in shoppingCart and then print the final price
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
				  else if((splitString[3].matches("\\d*\\.?\\d{0,2}$") || splitString[3].matches("\\d+\\.?$")) && !splitString[3].equals("."))
				  {
					  if((splitString[4].matches("\\d*\\.?\\d[0]*$") && !splitString[4].matches("\\d*\\.+")))
					  {
						  if((splitString[5].matches("\\d*\\.?\\d[0]*$") && !splitString[5].matches("\\d*\\.+")))
						  {
							  if(splitString[6].toLowerCase().equals("np") || splitString[6].toLowerCase().equals("p"))
							  {
								  return false;
							  }
						  }
					  }
				  }
			  }
			  else if(splitString[1].toLowerCase().equals("electronics"))
			  {
				  if(splitString.length < 8 || splitString.length > 8) //i am guessing that more than standard amount of inputs is wrong
				  {
					  return true;
				  }
				  else if((splitString[3].matches("\\d*\\.?\\d{0,2}$") || splitString[3].matches("\\d+\\.?$")) && !splitString[3].equals("."))
				  {
					  if((splitString[4].matches("\\d*\\.?\\d[0]*$") && !splitString[4].matches("\\d*\\.+")))
					  {
						  if((splitString[5].matches("\\d*\\.?\\d[0]*$") && !splitString[5].matches("\\d*\\.+")))
						  {
							  if(splitString[6].toLowerCase().equals("f") || splitString[6].toLowerCase().equals("nf"))
							  {
								  if(Arrays.asList(states).contains(splitString[7].toUpperCase()))
								  {
									  return false;
								  }
							  }
						  }
					  }
				  }
				  
			  }
			  else if(splitString[1].toLowerCase().equals("clothing"))
			  {
				  if(splitString.length < 6 || splitString.length > 6) //i am guessing that more than standard amount of inputs is wrong
				  {
					  return true;
				  }
				  else if((splitString[3].matches("\\d*\\.?\\d{0,2}$") || splitString[3].matches("\\d+\\.?$")) && !splitString[3].equals("."))
				  {
					  if((splitString[4].matches("\\d*\\.?\\d[0]*$") && !splitString[4].matches("\\d*\\.+")))
					  {
						  if((splitString[5].matches("\\d*\\.?\\d[0]*$") && !splitString[5].matches("\\d*\\.+")))
						  {
							  return false;
						  }
					  }
				  }
			  }
		  }
		  else if (splitString[0].toLowerCase().equals("search"))
		  {
			  if(splitString.length < 2 || splitString.length > 2) //i am guessing that more than standard amount of inputs is wrong
			  {
				  return true;
			  }
			  return false;
		  }
		  else if (splitString[0].toLowerCase().equals("delete"))
		  {
			  if(splitString.length < 2 || splitString.length > 2) //i am guessing that more than standard amount of inputs is wrong
			  {
				  return true;
			  }
			  return false;
		  }
		  else if (splitString[0].toLowerCase().equals("update"))
		  {
			  if(splitString.length < 3 || splitString.length > 3) //i am guessing that more than standard amount of inputs is wrong
			  {
				  return true;
			  }
			  if((splitString[2].matches("\\d*")))
			  {
				  return false;
			  }
		  }
		  else if (splitString[0].toLowerCase().equals("print"))
		  {
			  if(splitString.length < 1 || splitString.length > 1) //i am guessing that more than standard amount of inputs is wrong
			  {
				  return true;
			  }
			  return false;
		  }
		  return true; //false if no errors
	  }
}
	  