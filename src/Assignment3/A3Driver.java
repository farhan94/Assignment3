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
		
		//Parse input, take appropriate actions.
		
		if (checkErrors(input))
		{
			return; //checkErrors will print whatever error there was in the input, so all we need to do is end the program
		}
		
		Iterator<String> s = input.iterator();
		ArrayList<Item> shoppingCart = new ArrayList<Item>();
		
		while (s.hasNext()){
			String temp = s.next();
			String[] splitString = temp.split(" ");
			
			//maybe check for errors in the split string, instead of before splitting????
			
			if (splitString[1].toLowerCase().equals("grocery"))
			{
				Grocery.evaluateInput(splitString, shoppingCart);
			}
		
			else if (splitString[1].toLowerCase().equals("electronics"))
			{
				Electronics.evaluateInput(splitString, shoppingCart);
			}
			
			else if (splitString[1].toLowerCase().equals("clothing"))
			{
				Clothing.evaluateInput(splitString, shoppingCart);
			}
		}
		
		//Stub for arraylist.
		
		
		// General code example for how to iterate an array list. You will have to modify this heavily, to suit your needs.
		Iterator<Item> i = shoppingCart.iterator();
		while (i.hasNext()) 
		{
			Item temp = i.next();
			temp.calculatePrice(); 
			temp.printItemAttributes();
			//This (above) works because of polymorphism: a determination is made at runtime, 
			//based on the inherited class type, as to which method is to be invoked. Eg: If it is an instance
			// of Grocery, it will invoke the calculatePrice () method defined in Grocery.
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
	  public static boolean checkErrors(ArrayList<String> input){
		  //will add various error checks here
		  return false; //false if no errors
	  }
}
	  