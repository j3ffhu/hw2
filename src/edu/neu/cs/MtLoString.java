package edu.neu.cs;

public class MtLoString implements ILoString {
	
	
	String first = null;
	
	ILoString rest = null;
	
	

	@Override
	public String first() {
		return null;
	}

	@Override
	public ILoString rest() {
		return null;
	}

	@Override
	public int size() {
		return 0;
	}

 
	@Override
	public ILoString insert(int location, String element) {
		
		// location has to be 0 - start with empty		
		return new ConsLoString(element, new MtLoString());
		
	}

}
