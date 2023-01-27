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

		return first().renderAsXmlString() + rest().renderAsXmlString();

	}

	@Override
	public boolean hasTag(String name) {

		return first.hasTag(name) || rest.hasTag(name);

	}

	@Override
	public int contentLength() {
		return first.contentLength() + rest.contentLength();
	}

	@Override
	public String renderAsString() {
		return first.renderAsString() + rest.renderAsString();
	}

	@Override
	public boolean hasAttribute(String name) {
		return first.hasAttribute(name) || first.hasAttribute(name);
	}

}
