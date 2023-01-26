package edu.neu.cs.assignment2;

import java.util.ArrayList;
import java.util.List;

public class ConsLoXML implements ILoXML {

    List<ExamplesXML> loxml;
	
	@Override
	public List<ExamplesXML> getXmlList() {
		return loxml;
	}

 

    public ConsLoXML() {
        this.loxml = new ArrayList<>();
    }

 

	
}
