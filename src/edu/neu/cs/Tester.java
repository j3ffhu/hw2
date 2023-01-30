package edu.neu.cs;

// https://course.ccs.neu.edu/cs2510sp23/lab1.html
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ConsLoString s1 =	new ConsLoString("1", 
                new ConsLoString("2", 
                    new ConsLoString("3", 
                        new ConsLoString("4",  
                        		   new ConsLoString("5",  
                                           new MtLoString())))));
		
		
		
		ConsLoString s2 =	new ConsLoString("a", 
                new ConsLoString("b", 
                    new ConsLoString("c", 
                        new ConsLoString("d",  
                                new MtLoString()))));
		
		
		ILoString interleave = s1.interleave(s2);
		
		// check result: 135bd !!
		
 
		
		
	    ILoString empty = new MtLoString();
	    
	    ILoString mary = new ConsLoString("Mary ",
                new ConsLoString("had ",
                    new ConsLoString("a ",
                        new ConsLoString("little ",
                            new ConsLoString("lamb.", new MtLoString())))));
	    
	    ILoString maryRandom = new ConsLoString("Mary ",
                new ConsLoString("a ",
                    new ConsLoString("had ",
                          new ConsLoString("lamb.",
                                new ConsLoString("little ", new MtLoString())))));
	    
	    ILoString abc = new ConsLoString("a", new ConsLoString("b", 
	                    new ConsLoString("c", new MtLoString())));
	    ILoString de = new ConsLoString("d", 
	                   new ConsLoString("e", new MtLoString()));
	    ILoString ace = new ConsLoString("a", new ConsLoString("c", 
	                    new ConsLoString("e", new MtLoString())));
	    ILoString bd = new ConsLoString("b", 
	                   new ConsLoString("d", new MtLoString()));
	    ILoString abe = new ConsLoString("a", new ConsLoString("b", 
	                    new ConsLoString("e", new MtLoString())));
	    ILoString cd = new ConsLoString("c", 
	                   new ConsLoString("d", new MtLoString()));
	    ILoString ab = new ConsLoString("a", new ConsLoString("b",
	                    new MtLoString()));
	    ILoString cde = new ConsLoString("c", new ConsLoString("d", 
	                     new ConsLoString("e", new MtLoString())));
	    ILoString aabb = new ConsLoString("a", new ConsLoString("a",
	                      new ConsLoString("b", new ConsLoString("b", 
	                          new MtLoString()))));
	    
	    ILoString aabbdef = new ConsLoString("a", new ConsLoString("a",
	                    new ConsLoString("b", new ConsLoString("b", 
	                        new ConsLoString("d", new ConsLoString("e", 
	                            new ConsLoString("f", new MtLoString())))))));
	    
	    

	  //  ILoString m1 =  empty.merge(mary);
		
	    String maryCombined = mary.combine();
	    
	    System.out.println("maryCombined: " +  maryCombined);
	    
	    String marySorted = mary.sort().combine();
	    
	    System.out.println("marySorted: " +  marySorted);
	    
	    
	    // interleave
	    System.out.println("mary.interleave(this.maryRandom): " +  mary.interleave(maryRandom).combine());
	    System.out.println("mary.interleave(emty): " +  mary.interleave(empty).combine());
	    
	    // rest reverse
	    System.out.println("abc.reverse(): " +  abc.reverse().combine());
	    
	    // sorted
	    System.out.println("abc.isSorted(): " +  abc.isSorted() );
	    System.out.println("marySorted.isSorted(): "  +  mary.isSorted() );	    
	    System.out.println("marySorted.sort().isSorted(): "  +  mary.sort().isSorted() );
	    
	    // merge
	    System.out.println("abc de: "  +  abc.merge(de).combine());	    
	    System.out.println("abc aabb: "  +  abc.merge(aabb).combine());
	    System.out.println("empty cde: "  +  empty.merge(cde).combine());
	    
	    int i = 10;
	}

}
