package edu.neu.cs.assignment2;

import java.util.ArrayList;
import java.util.List;

// nonempty list of att
public class ConsLoAtt implements ILoAtt {

	Att first;
	ILoAtt rest;

	@Override
	public Att first() {
		return first;
	}

	@Override
	public ILoAtt rest() {
		return rest;
	}

}
