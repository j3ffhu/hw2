package edu.neu.cs;

import java.util.List;

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	 // List<String> list = Arrays.asList("1", "2", "3", "4", "5", "6", "7");
	  
    //  System.out.print("interleave  1 2 3 4 5 6 7:  " +  interleave(list));

	//  System.out.println("interleave   7:  " + interleave( Arrays.asList( "7")));
		
//	 
//	 List<String> test =  new LinkedList<String>(Arrays.asList( "3", "4", "5", "6", "7"));
//	 test.add(2, "2");
//	 
//	 System.out.println( test);
//	 
//	 System.out.println("substring 3 4  5 6 7:  " + Arrays.asList( "3", "4", "5", "6", "7").subList(2,  5));

	  
//	  System.out.println("interleave  5 6 7:  " +  interleave( Arrays.asList( "5", "6", "7")));
	  
//  System.out.println("interleave 1 2 3 4  5 6 7:  " +  interleave(  new LinkedList<String>(Arrays.asList("1", "2",  "3", "4", "5", "6", "7"))));
//	
//  System.out.println("interleave 1 2 3 4  5 6:  " +  interleave(  new LinkedList<String>(Arrays.asList("1", "2",  "3", "4", "5", "6"))));

	//  System.out.println("interleave  5 6 7:  " +  interleave(  new LinkedList<String>(Arrays.asList(  "5", "6", "7"))));

		ILoString test = new MtLoString();
		
		test = test.insert(0, "7");
		test = test.insert(0, "6");
		test = test.insert(0, "5");
		test = test.insert(0, "4");
		test = test.insert(0, "3");
		test = test.insert(0, "2");
		test = test.insert(0, "1");
		
		
		ILoString result = interleave(test);
				
	   System.out.println("interleave 1 2 3 4  5 6 7" + result);		
		
		
		
	}

	
//	public static List<String> interleave( List<String>  input) {
//		
//		if ( input == null || input.size() <= 2 )
//			return input;
//		else {
//		    // take first two out
//			
//			String first = input.get(0);
//			String second = input.get(1);
//			
//			
//	
//			List<String> result =  interleave(input.subList(2, input.size()));			
//			
//			// merge: second to  middle
//		    result.add(result.size()/2   , second);
//			
//			// first to head
//			result.add(0, first);
//			
//			return result;
//						
//		}
//		
//	 
//	}
	

	public static ILoString interleave(ILoString input) {
	 
		// length 0/1/2 - return
		// else: recursion		
		if ( input.size() < 3)
			return input;
		else {
			
			String first = input.first();
			String second = input.rest().first();
					
					
			ILoString temp = input.rest().rest();
			
			ILoString result =  interleave(temp);
			
			int loc = input.size() / 2;
						
		    return new ConsLoString(first,  result.insert(loc, second) );	
			
		}
						
	}
	
}
