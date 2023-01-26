package edu.neu.cs.assignment2;

public interface ILoXML {

     // a -> b -> ....
    // List<ExamplesXML> getXmlList();
    
    // first -> next
    // IXML first;
    // ILoXML rest;
	IXML first();
	ILoXML rest();
	
    
}
