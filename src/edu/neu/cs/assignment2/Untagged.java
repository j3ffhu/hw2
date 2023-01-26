
package edu.neu.cs.assignment2;

public class Untagged implements IXML {

	ILoXML content;
	
	public Untagged(  ILoXML content  ) {
		this.content = content;
	}

	@Override
	public int contentLength() {
		return content.first().contentLength() + content.rest().first().contentLength();
	}

	@Override
	public boolean hasAttribute(String name) {

		if (content.first() !=null && content.first().hasAttribute(name)) {
			return true;

		} else   if (content.rest() != null)
			return content.rest().first().hasAttribute(name);
		else 
			return false;
	}

	@Override
	public String renderAsString() {
		return content.first().renderAsString() + " " + content.rest().first().renderAsString();
	}

	@Override
	public String renderAsXmlString() {
		return content.first().renderAsXmlString() + content.rest().first().renderAsXmlString();
	}

	@Override
	public boolean hasTag(String name) {
		if (content.first().hasTag(name)) {
			return true;

		} else
			return content.rest().first().hasTag(name);
	}

}
