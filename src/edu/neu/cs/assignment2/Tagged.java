
package edu.neu.cs.assignment2;

public class Tagged implements IXML {

	Tag tag;
	ILoXML content;

//	IXML first();
//	ILoXML rest();

	@Override
	public int contentLength() {
		return content.first().contentLength() + content.rest().first().contentLength();
	}

	@Override
	public boolean hasAttribute(String name) {

		if (tag.name.equals(name)) {
			return true;
		} else if (content.first().hasAttribute(name)) {
			return true;

		} else
			return content.rest().first().hasAttribute(name);
	}

	// <a>ab</ab> -> ab
	// strip off tag, keep plaint text only
	
	@Override
	public String renderAsString() {
		return content.first().renderAsString() + " " + content.rest().first().renderAsString();
	}

	// tag name  + content 
	// how about attribute? 
	@Override
	public String renderAsXmlString() {
		return  "<" + tag.name + "attibutes list" + ">"  
	            + content.first().renderAsXmlString() 
				+ content.rest().first().renderAsXmlString()
		        + "</" + tag.name + ">" ;
		
		
	}

}
