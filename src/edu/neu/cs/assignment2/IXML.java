package edu.neu.cs.assignment2;

public interface IXML {
	
	int contentLength() ;
		
    // renderAsString
    String renderAsString();

    // renderAsXmlString
    String renderAsXmlString();


	boolean hasAttribute(String name);
}

//;; An XML is one of:
//;; - (make-plaintext String)
//;; - (make-untagged [Listof XML])
//;; - (make-tagged Tag [Listof XML])