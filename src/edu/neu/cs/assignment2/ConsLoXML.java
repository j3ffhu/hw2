package edu.neu.cs.assignment2;

public class ConsLoXML implements ILoXML {

	IXML first;
	ILoXML rest;
	
	public ConsLoXML(IXML first, ILoXML rest) {
		this.first = first;
		this.rest = rest;
	}
	
	public ConsLoXML(IXML first ) {
		this.first = first;
		this.rest =   new MtLoXML();
	}

	@Override
	public IXML first() {
		return first;
	}

	@Override
	public ILoXML rest() {
		return rest;
	}

}
