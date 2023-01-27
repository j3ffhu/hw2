package edu.neu.cs.assignment2;

import java.util.List;

// MtLo  empty lists of Att
public class MtLoAtt implements ILoAtt {

	@Override
	public Att first() {
		return null;
	}

	@Override
	public ILoAtt rest() {
		return null;
	}

	@Override
	public String renderAsString() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public boolean hasAttribute(String name) {
		// TODO Auto-generated method stub
		return false;
	}

}
