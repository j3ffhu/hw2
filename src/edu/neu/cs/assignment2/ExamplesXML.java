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
		
	
		
		

		
		///////////////////////////////////////////////////////////
		
		// untagged: plaintext + tagged + plaintext
		
		/// I am <yell><italic>X</italic>ML</yell>  !
		//// 
		
		// <yell><italic>X</italic>ML</yell>
		// node2: yell -> italic -> plaintext x
		// Tagged yell = null;
		 

		IXML xml21  =  new Plaintext("I am ");
		IXML xml23  = new Plaintext("!");
		
		
		// tagged <yell><italic>X</italic>ML</yell>:  
			 /// first: tagged, rest:MtLoXML
		 	// rest: <italic>X</italic>ML
			        /// first: 
		
		/// @TODO incomplete
		
      /// construct backward
		ILoXML  node3 = new ConsLoXML(xml23);
		
	//	ILoXML  node2 = new ConsLoXML(yell, node3);

	//	ILoXML  node1 = new ConsLoXML(xml21, node2);
		
	//	Untagged xml2 = new Untagged(node1);
		
		////////////////////////
		// tagged: one IXML
		/// <yell volume="30db"><italic>X</italic>ML</yell>
		// yell: italic -> plaintext/ML
		// xml3
		
		IXML xml3_ml = new Plaintext("ML");
		IXML xml3_X = new Plaintext("X");
		
		Tag italic = new Tag();
		italic.name = "italic";
		
		Tagged xml3_italic =  new Tagged(italic, new ConsLoXML(xml3_X));
		ILoXML node_italic =  new ConsLoXML(xml3_italic, new ConsLoXML(xml3_ml)  );
		
		// yell: add attibutes next
		Tag yell = new Tag();
		yell.name = "yell";
		
		
	  	Tagged node_yell= new Tagged(yell, node_italic);
 

		// System.out.println("node_yell renderAsXmlString: " + node_yell.renderAsXmlString());
	  	System.out.println("node_yell renderAsString: " + node_yell.renderAsString());
		System.out.println("node_yell has hasTag yell " + node_yell.hasTag("italic"));

	  	 
 
	}
	
}
