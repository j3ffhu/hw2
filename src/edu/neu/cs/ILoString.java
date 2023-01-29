package edu.neu.cs;

public interface ILoString {

//	String first;
//	
//	ILoString rest;

	String first();

	ILoString rest();
	
	int size();
		
	ILoString insert(int location, String element);

}
