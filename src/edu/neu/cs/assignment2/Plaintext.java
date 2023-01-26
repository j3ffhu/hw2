package edu.neu.cs.assignment2;

public class Plaintext implements IXML {

	String txt;

	@Override
	public int contentLength() {
		return txt.length();
	}

	@Override
	public boolean hasAttribute(String name) {
		return false;
	}

	@Override
	public String renderAsString() {
		return txt;
	}

	@Override
	public String renderAsXmlString() {
		return null;
	}

}
