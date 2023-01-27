package edu.neu.cs.assignment2;

import java.util.List;

// inteface list of Att
public interface ILoAtt {

	Att first();

	ILoAtt rest();
	
    String  renderAsString();
    
    boolean hasAttribute(String name);

}
