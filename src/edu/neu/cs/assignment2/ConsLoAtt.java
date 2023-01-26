package edu.neu.cs.assignment2;

// nonempty list of att
public class ConsLoAtt implements ILoAtt {

	Att first;
	ILoAtt rest;
	
	public ConsLoAtt(Att first, ILoAtt rest) {
		this.first = first;
		this.rest = rest;
	}
	
	public ConsLoAtt(Att first ) {
		this.first = first;
		this.rest =   new MtLoAtt();
	}

	@Override
	public Att first() {
		return first;
	}

	@Override
	public ILoAtt rest() {
		return rest;
	}

}
