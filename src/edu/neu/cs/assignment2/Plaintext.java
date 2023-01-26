package edu.neu.cs.assignment2;

public class Plaintext implements IXML {

	String txt;
	
	public Plaintext(String txt) {
		this.txt = txt;
	}

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

	@Override
	public boolean hasTag(String name) {
		return false;
	}

}
