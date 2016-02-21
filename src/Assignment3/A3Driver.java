package Assignment3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import Assignment1.Translator;

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
		String filename = args[0];
		FileReader freader = new FileReader(filename);
		BufferedReader reader = new BufferedReader(freader);
		
		for (String s = reader.readLine(); s != null; s = reader.readLine()) 
		{
			String pigLatin = translator.translate(s);
			System.out.println(pigLatin);
		}
		
		//Parse input, take appropriate actions.
		
		//Stub for arraylist.
		ArrayList<Item> shoppingCart = new ArrayList<Item>();
		
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
	  
	  public static void processLinesInFile (String filename) 
		{ 
			try 
			{
				FileReader freader = new FileReader(filename);
				BufferedReader reader = new BufferedReader(freader);
				
				for (String s = reader.readLine(); s != null; s = reader.readLine()) 
				{
					String pigLatin = translator.translate(s);
					System.out.println(pigLatin);
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

}
