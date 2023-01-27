
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
		return content.contentLength();
	}

	@Override
	public boolean hasAttribute(String name) {
		
		return content.hasAttribute(name);
	}
	
	@Override
	public boolean hasTag(String name) {

		return 	tag.name.equals(name);
	}
		


	@Override
	public String renderAsString() {
		return content.renderAsString() ;
	}

	// tag name + atts + content end tag
	@Override
	public String renderAsXmlString() {
				
			return  "<"
            + tag.name 
            + " >"  
            + content.renderAsXmlString() 
	        + "</" + tag.name + ">" ;
 
 
		
	}

}
