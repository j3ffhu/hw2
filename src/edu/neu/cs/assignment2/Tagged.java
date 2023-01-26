
package edu.neu.cs.assignment2;

public class Tagged implements IXML {

	Tag tag;
	ILoXML content;

 
	public Tagged(Tag tag, ILoXML content  ) {
		this.tag = tag;
		this.content = content;
	}
	
	@Override
	public int contentLength() {
		return content.first().contentLength() + content.rest().first().contentLength();
	}

	@Override
	public boolean hasAttribute(String name) {

		if (tag.hasAttribute(name)) {
			return true;
		} else if (content.first() != null &&  content.first().hasAttribute(name)) {
			return true;

		} else  if (content.rest() != null)
			return content.rest().first().hasAttribute(name);
		else
			return false;
	}
	
 
		
	@Override
	public boolean hasTag(String name) {

		
		if (tag.name.equals(name)) {
			return true;
		} else if (content.first() != null && content.first().hasTag(name)) {
			return true;

		} else if (content.rest() != null)
			return content.rest().first().hasTag(name);
		else 
			return false;
	}

	@Override
	public String renderAsString() {
		return content.first().renderAsString() + " " + content.rest().first().renderAsString();
	}

	// tag name + atts + content end tag
	@Override
	public String renderAsXmlString() {
		return  "<"
	            + tag.name 
	            + tag.renderAttsAsString()
	            + " >"  
	            + content.first().renderAsXmlString() 
				+ content.rest().first().renderAsXmlString()
		        + "</" + tag.name + ">" ;
		
		
	}

}
