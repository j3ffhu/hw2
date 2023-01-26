package edu.neu.cs.assignment2;

import java.util.ArrayList;
import java.util.List;

public class ConsLoExamplesXML implements ILoExamplesXML {

    List<ExamplesXML> loxml;
	
	@Override
	public List<ExamplesXML> getXmlList() {
		return loxml;
	}

 

    public ConsLoExamplesXML() {
        this.loxml = new ArrayList<>();
    }

 

	
}
