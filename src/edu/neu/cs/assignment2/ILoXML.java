package edu.neu.cs.assignment2;

public interface ILoXML {

    // first -> next
    // IXML first;
    // ILoXML rest;
	IXML first();
	ILoXML rest();
	
	String renderAsXmlString() ;
	Boolean hasTag(String name) ;
    
}
