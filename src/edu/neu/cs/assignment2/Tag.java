
package edu.neu.cs.assignment2;

public class Tag {

	String name;
	ILoAtt atts;
	
	public String  renderAttsAsString() {	
		  return atts.renderAsString();

	}
	
	public boolean hasAttribute(String name) {
		
		return atts.hasAttribute(name);
 
	}
	
}
