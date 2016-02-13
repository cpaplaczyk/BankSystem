package Application;

import java.util.*;

//  Created by Clayton Paplaczyk	

//  Description:  Used to sort the customer list and the bank list. Sorts ArrayList 
//  			object, either bankList or customerList.

public class Sorts {
	
	public static void sort(ArrayList objects){
		quickSort(objects, 0, objects.size()-1);
	}

	public static void quickSort(ArrayList elements, int from, int to){
		{
		    if (from < to){
		       int p = partition(elements, from, to);
		       quickSort(elements, from, p);
		       quickSort(elements, p+1, to);
		    }}
		} //end of quickSort method

		public static int partition(ArrayList elements, int from, int to)
		{
		    Comparable pivot = (Comparable)elements.get(from);
		    int i = from -1;
		    int j = to + 1;

		    while (i < j ) // until i and j cross each other
		    {
		       i++;
		       //move i towards right until we find an element greater (or equals to) than pivot
		       while (((Comparable)(elements.get(i))).compareTo(pivot)<0)
		           i++;

		       j--;
		       //move j towards left until we find an element smaller (or equals to) than pivot
		       while (((Comparable)(elements.get(i))).compareTo(pivot)>0)
		            j--;

		      //we swap the two elements
		      if (i < j)
		      {
		           Comparable temp = (Comparable)elements.get(i);
		           elements.set(i,(Comparable)elements.get(j));
		           elements.set(j,  temp);
		      }
		    } //end of the while loop

		      //return the index where the array can be divided (partitioned)
		      return j;
	  } //end of partition method
	}