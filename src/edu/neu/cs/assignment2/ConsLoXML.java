package edu.neu.cs.assignment2;

public class ConsLoXML implements ILoXML {

	IXML first;
	ILoXML rest;

	@Override
	public IXML first() {
		return first;
	}

	@Override
	public ILoXML rest() {
		return rest;
	}

}
