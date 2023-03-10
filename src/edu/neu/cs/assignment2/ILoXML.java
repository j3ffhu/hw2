package edu.neu.cs.assignment2;

public interface ILoXML {

    // first -> next
    // IXML first;
    // ILoXML rest;
	IXML first();
	ILoXML rest();
	
	int contentLength();

	String renderAsString();

	String renderAsXmlString();

	boolean hasAttribute(String name);
	
	boolean hasTag(String name);
	
}
