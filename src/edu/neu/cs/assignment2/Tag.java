
package edu.neu.cs.assignment2;

public class Tag {

	Tag name;
	ILoAtt atts;
	
	public String  renderAttsAsString() {	
		
		return atts.first().renderAsString() + " " + atts.rest().first().renderAsString() ;
	}

}
