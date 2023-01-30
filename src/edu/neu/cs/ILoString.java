package edu.neu.cs;

public interface ILoString {

//	String first;
//	
//	ILoString rest;
	
	String first();
	ILoString rest() ;
	ILoString skip();
	ILoString append(String elemnt);

	// combine all Strings in this list into one
	String combine();

	// produces a new list, sorted in alphabetical order
	// strings are in lowercase
	ILoString sort();

	// to insert the given string into this sorted list of strings
	ILoString insert(String that);

	// returns true if the list is sorted
	boolean isSorted();

 
	// produces a list where the first, third, fifth... elements are from this list,
	// and the second, fourth, sixth... elements are from the given list
	ILoString interleave(ILoString lost);

	// produces a sorted list of Strings that has all items in both original lists
	ILoString merge(ILoString lost);

	ILoString sortMergeHelper(String that);

	// produces a new list of Strings in reverse order
	ILoString reverse();

	// to insert the given string into this sorted list of strings in reverse order
	ILoString insertReverse(String that);

	// returns true if this list contains pairs of identical strings
	boolean isDoubledList();

	// returns true if two strings in the list are equal
	boolean isDoubledHelper(String that);

}
