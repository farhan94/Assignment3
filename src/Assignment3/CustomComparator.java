package Assignment3;

import java.util.Comparator;
//this class is used in sorting the shoppingCart
public class CustomComparator implements Comparator<Item> 
{
   public int compare(Item o1, Item o2) //sorts based on alphabetical order and case
   {
       if(o1.getName().equalsIgnoreCase(o2.getName()) && !o1.getName().equals(o2.getName()))
       {
	   return o1.getName().compareTo(o2.getName());
       }
       return o1.getName().toUpperCase().compareTo(o2.getName().toUpperCase());
   }
}



