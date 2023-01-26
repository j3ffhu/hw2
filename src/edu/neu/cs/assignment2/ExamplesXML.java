package edu.neu.cs.assignment2;

import java.util.List;
import java.util.stream.Collectors;

public class ExamplesXML {

    // one of three

    // no tag at all
    String plaintext;

    //  mix of tagged and plaintext
    //// hello world <bar>xx</bar> !
    Untagged untagged;

    // all tags
    //// <bar>xx</bar>
    Tagged tagged;


    /// return plaintext, OR
    /// sum of untagged, OR
    /// sum of tag
    public int contentLength() {
        if (plaintext != null) {
            return plaintext.length();

        } else if (untagged != null) {
            int len = 0 ;
            for (ExamplesXML node: untagged.content.getXmlList()) {
               len += node.contentLength();
            }
            return len;
        } else {
            int len = 0 ;
            for (ExamplesXML node: tagged.content.getXmlList()) {
               len += node.contentLength();
            }
            return len;
        }
    }

    // hasTag: loop all tags  
    /// embedded: yell, italic
    /// <yell volume="30db"><italic>X</italic>ML</yell>
    public boolean hasTag(String name) {
    	
    	List<ExamplesXML> list ;
    	
        if (plaintext != null) {
            return false;

        } else if (untagged != null) {
        	list =  untagged.content.getXmlList();
 
         }  else {
         
        	if(tagged.tag.name.equals(name))
        		return true;
          	
        	else
        		list =  tagged.content.getXmlList();
 
       }
        
      // loop list
        for (ExamplesXML node: list) {
        	
        	if (node.hasTag(name))
        		return true;
        }
        
        return false;
           
    }  

 

    // hasAttribute

    // renderAsString

    // renderAsXmlString

}
