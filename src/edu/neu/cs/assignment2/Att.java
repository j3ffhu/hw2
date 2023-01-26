package edu.neu.cs.assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Att {

    String name;
    String value;
    
    public static void main(String[] args)
    {
        // creating an Empty Integer List
        List<Integer> arr = new ArrayList<Integer>(4);
  
        // using add() to initialize values
        // [10, 20, 30, 40]
        arr.add(10);
        arr.add(20);
        arr.add(30);
        arr.add(40);
  
        System.out.println("List: " + arr);
  
        List<Integer> dup = arr; 
        
      
        
        List<Integer> copy = arr.stream()
        		  .skip(1)
        		  .collect(Collectors.toList());
      
        // element at index 2
        int element =   arr.remove(0);
  
        System.out.println("The element at index 2 is " + element);
    }
}

 
