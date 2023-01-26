
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

	@Override
	public String renderAsString() {
		return content.first().renderAsString() + " " + content.rest().first().renderAsString();
	}

	@Override
	public String renderAsXmlString() {
		return content.first().renderAsXmlString() + " " + content.rest().first().renderAsXmlString();
	}

}
