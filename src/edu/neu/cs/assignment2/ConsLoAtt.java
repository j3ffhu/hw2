package edu.neu.cs.assignment2;

import java.util.ArrayList;
import java.util.List;

// nonempty list of att
public class ConsLoAtt  implements ILoAtt {

    List<Att> loa;

    public ConsLoAtt() {
        this.loa = new ArrayList<>();
    }

	@Override
	public List<Att> getAttList() {
		return loa;
	}

}
