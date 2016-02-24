package Assignment3;

import java.util.Comparator;

public class CustomComparator implements Comparator<Item> 
{
   public int compare(Item o1, Item o2) 
   {
        return o1.getName().compareTo(o2.getName());
   }
}

