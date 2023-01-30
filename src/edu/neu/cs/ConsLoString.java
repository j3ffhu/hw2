package edu.neu.cs;

public class ConsLoString implements ILoString {

	String first;
	ILoString rest;

	ConsLoString(String first, ILoString rest) {
		this.first = first;
		this.rest = rest;
	}

	public String first() {
		return first;
	}

	public ILoString rest() {
		return rest;
	}

	/**
	 * combine all Strings in this list into one
	 */
	@Override
	public String combine() {
		if (first != null)
		  return this.first.concat(this.rest.combine());
		else
			return "";
	}

    // produces a new list, sorted in alphabetical order
    // strings are in lowercase
	@Override
	public ILoString sort() {
		
		// start with new ConsLoString with first element, keep insert all nodes		
		ILoString result = new ConsLoString(first.toLowerCase(), new MtLoString());
		
		
		// keep insert til end
		ILoString next  = this.rest;
		while (next != null ) { 
			result = result.insert(next.first());
			next = next.rest();
		}
		
		return result;
	}
	
  // produces a sorted list of Strings that has all items in both original lists
	@Override
	public ILoString merge(ILoString lost) {
		
		if (lost == null)
			return this.sort();
		 
	    // start with this	
		ILoString s1 = this.sort();
 		
		ILoString next  = lost;
		// keep insert til end
		while (next != null ) { 
			s1 = s1.insert(next.first());
			next = next.rest();
		}
		
		return s1;
		
	}
	
	
	public ILoString skip() {
		
		if (rest != null )
			return rest.rest();
		else 
			return null;
		
	}
	
	
	@Override
	public ILoString append(String elemnt) {
		return  new ConsLoString(first, rest.append(elemnt));
	}
	
 
	
    // pick odd current, pick even from lost (skp first - use odd
	// PICK ONE EACH until no more left form each list
	// ODD, first, EVEN second 
	@Override
	public ILoString interleave(ILoString lost) {
		
		// get first from this
		ILoString result =  new ConsLoString(first, new MtLoString());
		
		// odd: this
		ILoString odd = this.skip();

		// even lost
		ILoString even = lost.rest();
		
 		while (even !=null && odd != null  ) { 
			 result = result.append(even.first());		 
			 result = result.append(odd.first());
			 
			  odd  = odd.skip();
			  even = even.skip();
						 
		}		
		return result;		
		
	}

 

	  // to insert the given string into this sorted list of strings
	// you need find where to insert: first string greater than "that"
	@Override
	public ILoString insert(String that) {
		
		if (that == null)
			return this;
		
		  that = that.toLowerCase();
		
	      if (that.compareTo(this.first) <= 0) {
	          return new ConsLoString(that, this);
	      } else {
	          return new ConsLoString(this.first, this.rest.insert(that));
	      }
	}


    // returns true if the list is sorted
	// first less than rest.first, and rest is sorted
    public boolean isSorted() {
    
      if (rest.first() == null)
    	  return true;
      else 
    	  return (first.compareTo(rest.first()) <=0 && rest.isSorted());
 
    }
 
 

	@Override
	public ILoString sortMergeHelper(String that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ILoString reverse() {
		// TODO Auto-generated method stub
		// reverse next then append first
		//
		return rest.reverse().append(first);
	}

	@Override
	public ILoString insertReverse(String that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDoubledList() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDoubledHelper(String that) {
		// TODO Auto-generated method stub
		return false;
	}
 


//	public ILoString insert(int location, String element) {
//				
//		// location 0: add to head
//		if (location == 0 ) {
//			return new ConsLoString(element, new ConsLoString(first, rest ) );
//		} else {
//			return 	new ConsLoString( first, rest.insert(location - 1, element ) );	
//		}		
//		 
//	}

}
