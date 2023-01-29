package edu.neu.cs;

public class ConsLoString implements ILoString {
	
	String first;
	
	
	// could be empty: MtLoString
	ILoString rest;
	
	public ConsLoString(String first,ILoString rest ) {
		
		this.first = first;
		this.rest = rest;
		
	}
	

	@Override
	public String first() {
 		return first;
	}

	@Override
	public ILoString rest() {
 		return rest;
	}

	@Override
	public int size() {	 
		return 1 + rest().size();
	}



	@Override
	public ILoString insert(int location, String element) {
				
		// location 0: add to head
		if (location == 0 ) {
			return new ConsLoString(element, new ConsLoString(first, rest ) );
		} else {
			return 	new ConsLoString( first, rest.insert(location - 1,element ) );	
		}
		
		 
	}

}
