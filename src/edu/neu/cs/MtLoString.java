package edu.neu.cs;

public class MtLoString implements ILoString {
	
	String first = null;
	ILoString rest = null;

	
	public String first() {
		return first;
	}

	public ILoString rest() {
		return rest;
	}


// 
//	@Override
//	public ILoString insert(int location, String element) {
//		
//		// location has to be 0 - start with empty		
//		return new ConsLoString(element, new MtLoString());
//		
//	}

    // combine all Strings in this list into one
    public String combine() {
       return "";
    }
    
    // produces a new list, sorted in alphabetical order
    // strings are in lowercase
    public ILoString sort() {
      return this;
    }
    
    // to insert the given string into this sorted list of strings
    public ILoString insert(String that) {
      return new ConsLoString(that, this);
    }
    
    // returns true if the list is sorted in alphabetical order, in a case-insensitive way
    public boolean isSorted() {
      return false;
    }
    
    // helper returns true if the list is sorted alphabetically and case-insensitive
    public boolean isSortedHelper(String that) {
      return false;
    }

    // produces a list where the first, third, fifth... elements are from this list, 
    // and the second, fourth, sixth... elements are from the given list
    public ILoString interleave(ILoString lost) {
      return this;
    }
    
    // produces a sorted list of Strings that has all items in both original lists
    public ILoString merge(ILoString lost) {
      return lost.sort();
    }
    
    public ILoString sortMergeHelper(String that) {
      return new ConsLoString(that, this);
    }
    
    // produces a new list of Strings in reverse order
    public ILoString reverse() {
      return this;
    }
    
    // to insert the given string into this sorted list of strings in reverse order
    public ILoString insertReverse(String that) {
      return new ConsLoString(that, this);
    }
    
    // returns true if this list contains pairs of identical strings
    public boolean isDoubledList() {
      return false;
    }
    
    // returns true if two strings in the list are equal
    public boolean isDoubledHelper(String that) {
      return false;
    }

	@Override
	public ILoString skip() {
		return null;
	}

	// MtLoString.java
	@Override
	public ILoString append(String elemnt) {
		 return new ConsLoString(elemnt, this);
	}

}
