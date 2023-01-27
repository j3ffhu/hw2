package edu.neu.cs.assignment2;

import java.util.List;
import java.util.stream.Collectors;

public class ExamplesXML {

	//	Define Java classes that represent XML as defined above. 
	//	Translate all of the above examples using your representation. 
	//	Name your examples class ExamplesXML. 
	//	Name your examples xml1, xml2, etc. 
	//	Note that the Untagged constructor should only be called when absolutely necessary.
	//     
	

	
	public static void main(String[] args) {
		
		// plaint text: xml1 
		IXML xml1 = new Plaintext("I am XML!");
		
		System.out.println("xml1 contentLength " + xml1.contentLength());
		
		System.out.println("xml1 has tag abc " + xml1.hasTag("abc"));
		
		System.out.println("xml1 has hasAttribute abc " + xml1.hasAttribute("abc"));

		
		// more complicated to contrust untagged tagged
		
		// tagged: one IXML
		/// <yell volume="30db"><italic>X</italic>ML</yell>
		
		
		// untagged: plaintext + tagged + plaintext
		/// I am <yell><italic>X</italic>ML</yell>!
		
		///////////////////////////////////////////////////////////
		
		Untagged yell = new  Untagged();

		IXML xml21  =  new Plaintext("I am ");
		IXML xml22  = new Plaintext("!");
		
		
		// tagged <yell><italic>X</italic>ML</yell>:  
			 /// first: tagged, rest:MtLoXML
		 	// rest: <italic>X</italic>ML
			        /// first: 
		
		/// @TODO incomplete
		
      /// construct backward
		ILoXML  node3 = new ConsLoXML(xml22);
		
		ILoXML  node2 = new ConsLoXML(yell, node3);

		
		
		
	}
	
}
