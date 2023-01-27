package edu.neu.cs.assignment2;

public class ConsLoXML implements ILoXML {

	IXML first;
	ILoXML rest;

	public ConsLoXML(IXML first, ILoXML rest) {
		this.first = first;
		this.rest = rest;
	}

	public ConsLoXML(IXML first) {
		this.first = first;
		this.rest = new MtLoXML();
	}

	@Override
	public IXML first() {
		return first;
	}

	@Override
	public ILoXML rest() {
		return rest;
	}

	@Override
	public String renderAsXmlString() {
		if (first != null && rest() != null && rest() != null)
			return first().renderAsXmlString() + rest().renderAsXmlString();

		else if (first() != null)
			return first().renderAsXmlString();
		else
			return "";
	}

	@Override
	public Boolean hasTag(String name) {
		if (first.hasTag(name))
			return true;

		else  
			return rest.hasTag(name);
 
	}

}
