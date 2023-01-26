
package edu.neu.cs.assignment2;

public class Tag {

	Tag name;
	ILoAtt atts;
	
	public String  renderAttsAsString() {	
		
		return atts.first().renderAsString() + " " + atts.rest().first().renderAsString() ;
	}
	
	public boolean hasAttribute(String name) {
		if (atts.first().name.equals(name))
			return true;
		else 
			return	atts.rest().first().name.equals(name);
		
	}
	
}
