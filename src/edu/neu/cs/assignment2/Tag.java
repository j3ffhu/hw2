
package edu.neu.cs.assignment2;

public class Tag {

	String name;
	ILoAtt atts;
	
	public String  renderAttsAsString() {	
		if (atts != null)
		  return atts.first().renderAsString() + " " + atts.rest().first().renderAsString() ;
		else 
			return "";
	}
	
	public boolean hasAttribute(String name) {
		if (atts.first().name.equals(name))
			return true;
		else 
			return	atts.rest().first().name.equals(name);
		
	}
	
}
