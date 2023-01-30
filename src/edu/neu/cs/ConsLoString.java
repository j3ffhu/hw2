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
		return this.first.concat(this.rest.combine());
	}

    // produces a new list, sorted in alphabetical order
    // strings are in lowercase
	@Override
	public ILoString sort() {
		
		// start with new ConsLoString with first element, keep insert all nodes		
		ILoString result = new ConsLoString(first, new MtLoString());
		
		
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
		 
	    // start with this	
		ILoString result = this.sort();
		
		ILoString next  = lost;
		// keep insert til end
		while (next != null ) { 
			result = result.insert(next.first());
			next = next.rest();
		}
		
		return result;
		
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
	
	// pick odd ONLY
	public ILoString interleaveHelper() {
		 
		ILoString result = new ConsLoString(first, new MtLoString());
		
		ILoString skip = this.skip();
		
 		while (skip != null ) { 
			result = result.append(skip.first());
			
		      skip = skip.skip();
						 
		}		
		return result;		
	}
	
	
     // pick odd current, pick even from lost (skp first - use odd
	// cant user merge - it sorts
	@Override
	public ILoString interleave(ILoString lost) {
		// get odd from this
		ILoString result = this.interleaveHelper();
		
		// now lost: skip first, then skip
		ILoString skip = lost.rest();
		
 		while (skip != null ) { 
			result = result.append(skip.first());
			
		      skip = skip.skip();
						 
		}		
		return result;		
		
	}


	
	
	
	
	
	

	  // to insert the given string into this sorted list of strings
	// you need find where to insert: first string greater than "that"
	@Override
	public ILoString insert(String that) {
	      if (that.compareTo(this.first) <= 0) {
	          return new ConsLoString(that, this);
	      } else {
	          return new ConsLoString(this.first, this.rest.insert(that));
	      }
	}

	@Override
	public boolean isSorted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSortedHelper(String that) {
		// TODO Auto-generated method stub
		return false;
	}

//	@Override
//	public ILoString interleave(ILoString lost) {
//		// TODO Auto-generated method stub
//		return null;
//	}



	@Override
	public ILoString sortMergeHelper(String that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ILoString reverse() {
		// TODO Auto-generated method stub
		return null;
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
