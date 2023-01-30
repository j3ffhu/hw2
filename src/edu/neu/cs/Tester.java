// CS 2510, Assignment 3

import tester.*;

// to represent a list of Strings
interface ILoString {
    // combine all Strings in this list into one
    String combine();
    
    // produces a new list, sorted in alphabetical order
    // strings are in lowercase
    ILoString sort();

    // to insert the given string into this sorted list of strings
    ILoString insert(String that);
    
    // returns true if the list is sorted
    boolean isSorted();
    
    // helper returns true if the list is sorted alphabetically and case-insensitive
    boolean isSortedHelper(String that);
    
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

// to represent an empty list of Strings
class MtLoString implements ILoString {
    MtLoString(){}
    
    /*
    TEMPLATE
    METHODS:
    ... this.combine() ...                 -- String
    ... this.sort() ...                    -- ILoString
    ... this.insert(String) ...            -- ILoString
    ... this.isSortedHelper(String) ...    -- boolean
    ... this.isSorted() ...                -- boolean
    ... this.interleave(ILoString) ...     -- ILoString
    ... this.merge(ILoString) ...          -- ILoString
    ... this.sortMergeHelper(String) ...   -- ILoString
    ... this.reverse() ...                 -- ILoString
    ... this.insertReverse(String) ...     -- ILoString
    */
    
    // combine all Strings in this list into one
    public String combine() {
       return "";
    }
    
    // produces a new list, sorted in alphabetical order
    // strings are in lowercase
    public ILoString sort() {
      return this;
    }
    
    // to insert the given string into this sorted list of strings
    public ILoString insert(String that) {
      return new ConsLoString(that, this);
    }
    
    // returns true if the list is sorted in alphabetical order, in a case-insensitive way
    public boolean isSorted() {
      return false;
    }
    
    // helper returns true if the list is sorted alphabetically and case-insensitive
    public boolean isSortedHelper(String that) {
      return false;
    }

    // produces a list where the first, third, fifth... elements are from this list, 
    // and the second, fourth, sixth... elements are from the given list
    public ILoString interleave(ILoString lost) {
      return this;
    }
    
    // produces a sorted list of Strings that has all items in both original lists
    public ILoString merge(ILoString lost) {
      return this;
    }
    
    public ILoString sortMergeHelper(String that) {
      return new ConsLoString(that, this);
    }
    
    // produces a new list of Strings in reverse order
    public ILoString reverse() {
      return this;
    }
    
    // to insert the given string into this sorted list of strings in reverse order
    public ILoString insertReverse(String that) {
      return new ConsLoString(that, this);
    }
    
    // returns true if this list contains pairs of identical strings
    public boolean isDoubledList() {
      return false;
    }
    
    // returns true if two strings in the list are equal
    public boolean isDoubledHelper(String that) {
      return false;
    }
}

// to represent a nonempty list of Strings
class ConsLoString implements ILoString {
    String first;
    ILoString rest;
    
    ConsLoString(String first, ILoString rest){
        this.first = first;
        this.rest = rest;  
    }
    
    /*
     TEMPLATE
     FIELDS:
     ... this.first ...                       -- String
     ... this.rest ...                        -- ILoString
     
     METHODS:
     ... this.combine() ...                   -- String
     ... this.sort() ...                      -- ILoString
     ... this.insert() ...                    -- ILoString
     ... this.isSortedHelper(String) ...      -- boolean
     ... this.isSorted() ...                  -- boolean
     ... this.interleave() ...                -- ILoString
     ... this.merge() ...                     -- ILoString
     ... this.sortMergeHelper(String) ...     -- ILoString
     ... this.reverse() ...                   -- ILoString
     ... this.insertReverse(String) ...       -- ILoString
     
     METHODS FOR FIELDS:
     ... this.first.concat(String) ...        -- String
     ... this.first.compareTo(String) ...     -- int
     ... this.rest.combine() ...              -- String
     ... this.rest.sort().insert(String) ...  -- ILoString
     ... this.first.toLowerCase() ...         -- String
     ... that.compareTo(String) ...           -- String    
     */
    
    // combine all Strings in this list into one
    public String combine() {
        return this.first.concat(this.rest.combine());
    }
    
    // produces a new list, sorted in alphabetical order
    // strings are in lowercase
    public ILoString sort() {
      return this.rest.sort().insert(this.first.toLowerCase());
  }

  
    // to insert the given string into this sorted list of strings
    public ILoString insert(String that) {
      if (that.compareTo(this.first) <= 0) {
          return new ConsLoString(that, this);
      } else {
          return new ConsLoString(this.first, this.rest.insert(that));
      }
  }

    // returns true if the list is sorted
    public boolean isSorted() {
      return this.rest.isSortedHelper(this.first.toLowerCase());
    }
    
    // helper returns true if the list is sorted alphabetically and case-insensitive
    public boolean isSortedHelper(String that) {
      if (that.compareToIgnoreCase(this.first) >= 0) {
        return false;
 
      } else if (that.compareToIgnoreCase(this.first) <= 0) {
        return true;
        
      } else {
      return this.rest.isSortedHelper(this.first);
      }
    }

    // produces a list where the first, third, fifth... elements are from this list, 
    // and the second, fourth, sixth... elements are from the given list
    public ILoString interleave(ILoString lost) {
      return new ConsLoString(this.first, lost.interleave(this.rest));
    }

    // produces a sorted list of Strings that has all items in both original lists
    public ILoString merge(ILoString lost) {
        return lost.merge(this.rest).sortMergeHelper(this.first);
    }
    
    public ILoString sortMergeHelper(String that) {
        return new ConsLoString(this.first, this.rest.sortMergeHelper(that));
    }

    // produces a new list of Strings in reverse order
    public ILoString reverse() {
      return this.rest.reverse().insertReverse(this.first);
    }
    
    // to insert the given string into this sorted list of strings in reverse order
    public ILoString insertReverse(String that) {
          return new ConsLoString(this.first, this.rest.insertReverse(that));
    }
    
    // returns true if this list contains pairs of identical strings
    public boolean isDoubledList() {
      return this.rest.isDoubledHelper(this.first);
    }
    
    // returns true if two strings in the list are equal
    public boolean isDoubledHelper(String that) {
      return that.equals(this.first);
    }
}

// to represent examples for lists of Strings
class ExamplesStrings{
    ExamplesStrings() {}
    
    ILoString mary = new ConsLoString("Mary ",
                    new ConsLoString("had ",
                        new ConsLoString("a ",
                            new ConsLoString("little ",
                                new ConsLoString("lamb.", new MtLoString())))));
    
    ILoString maryRandom = new ConsLoString("Mary ",
                             new ConsLoString("a ",
                                 new ConsLoString("had ",
                                       new ConsLoString("lamb.",
                                             new ConsLoString("little ", new MtLoString())))));
    
    ILoString marySorted = new ConsLoString("a ", 
                             new ConsLoString("had ", 
                                 new ConsLoString("lamb.", 
                                     new ConsLoString("little ", 
                                         new ConsLoString("mary ", new MtLoString())))));
    
    ILoString empty = new MtLoString();
    
    ILoString abc = new ConsLoString("a", new ConsLoString("b", 
                    new ConsLoString("c", new MtLoString())));
    ILoString de = new ConsLoString("d", 
                   new ConsLoString("e", new MtLoString()));
    ILoString ace = new ConsLoString("a", new ConsLoString("c", 
                    new ConsLoString("e", new MtLoString())));
    ILoString bd = new ConsLoString("b", 
                   new ConsLoString("d", new MtLoString()));
    ILoString abe = new ConsLoString("a", new ConsLoString("b", 
                    new ConsLoString("e", new MtLoString())));
    ILoString cd = new ConsLoString("c", 
                   new ConsLoString("d", new MtLoString()));
    ILoString ab = new ConsLoString("a", new ConsLoString("b",
                    new MtLoString()));
    ILoString cde = new ConsLoString("c", new ConsLoString("d", 
                     new ConsLoString("e", new MtLoString())));
    ILoString aabb = new ConsLoString("a", new ConsLoString("a",
                      new ConsLoString("b", new ConsLoString("b", 
                          new MtLoString()))));
    ILoString aabbdef = new ConsLoString("a", new ConsLoString("a",
                    new ConsLoString("b", new ConsLoString("b", 
                        new ConsLoString("d", new ConsLoString("e", 
                            new ConsLoString("f", new MtLoString())))))));

    
    
    // test the method combine for the lists of Strings
    boolean testCombine(Tester t) {
      return t.checkExpect(this.mary.combine(), "Mary had a little lamb.")
          && t.checkExpect(this.empty.combine(), "")
          && t.checkExpect(this.maryRandom.combine(), "Mary a had lamb.little ")
          && t.checkExpect(this.marySorted.combine(), "a had lamb.little mary ")
          && t.checkExpect(this.ace.combine(), "ace")
          && t.checkExpect(this.bd.combine(), "bd")
          && t.checkExpect(this.abe.combine(), "abe")
          && t.checkExpect(this.cd.combine(), "cd");
    }

    // test the method sort for the lists of Strings
    boolean testSort(Tester t) {
      return t.checkExpect(this.mary.sort(), new ConsLoString("a ", 
                                              new ConsLoString("had ", 
                                                 new ConsLoString("lamb.", 
                                                     new ConsLoString("little ", 
                                                         new ConsLoString("mary ", new MtLoString()))))))
          && t.checkExpect(this.maryRandom.sort(), new ConsLoString("a ", 
                                                      new ConsLoString("had ", 
                                                            new ConsLoString("lamb.", 
                                                                new ConsLoString("little ", 
                                                                    new ConsLoString("mary ", new MtLoString()))))))
          && t.checkExpect(this.marySorted.sort(), new ConsLoString("a ", 
                                                      new ConsLoString("had ", 
                                                            new ConsLoString("lamb.", 
                                                                new ConsLoString("little ", 
                                                                    new ConsLoString("mary ", new MtLoString()))))))
          && t.checkExpect(this.empty.sort(), new MtLoString());
    }

    // test the method isSorted for the lists of Strings
    boolean testIsSorted(Tester t) {
      return t.checkExpect(this.mary.isSorted(), false)
          && t.checkExpect(this.marySorted.isSorted(), true)
          && t.checkExpect(this.empty.isSorted(), false)
          && t.checkExpect(this.maryRandom.isSorted(), false); 
    }
    
    // test the method isSortedHelper for the lists of Strings
    boolean testIsSortedHelper(Tester t) {
      return t.checkExpect(this.empty.isSortedHelper(""), false)
          && t.checkExpect(this.mary.isSortedHelper("Mary "), false)
          && t.checkExpect(this.mary.isSortedHelper("had "), true)
          && t.checkExpect(this.mary.isSortedHelper("a "), true)
          && t.checkExpect(this.mary.isSortedHelper("little "), true)
          && t.checkExpect(this.marySorted.isSortedHelper("a "), false)
          && t.checkExpect(this.marySorted.isSortedHelper("had "), false)
          && t.checkExpect(this.marySorted.isSortedHelper("little "), false);
    }
    
    // test the method interleave for the lists of Strings
    boolean testInterleave(Tester t) {
      return t.checkExpect(this.empty.interleave(this.empty), new MtLoString())
          && t.checkExpect(this.mary.interleave(this.empty), new ConsLoString("Mary ", 
                                                                      new MtLoString()))
          && t.checkExpect(this.marySorted.interleave(this.abc), 
                                        new ConsLoString("a ", 
                                              new ConsLoString("a", 
                                                  new ConsLoString("had ", 
                                                      new ConsLoString("b", 
                                                          new ConsLoString("lamb.", 
                                                              new ConsLoString("c", 
                                                                  new ConsLoString("little ", 
                                                                      new MtLoString()))))))))
          && t.checkExpect(this.mary.interleave(this.maryRandom), 
                                        new ConsLoString("Mary ", 
                                              new ConsLoString("Mary ", 
                                                new ConsLoString("had ", 
                                                     new ConsLoString("a ", 
                                                       new ConsLoString("a ", 
                                                          new ConsLoString("had ", 
                                                             new ConsLoString("little ", 
                                                               new ConsLoString("lamb.", 
                                                                 new ConsLoString("lamb.", 
                                                                  new ConsLoString("little ", 
                                                                     new MtLoString())))))))))))
          && t.checkExpect(this.ace.interleave(this.bd), new ConsLoString("a", 
                                                      new ConsLoString("b", 
                                                          new ConsLoString("c", 
                                                              new ConsLoString("d", 
                                                                  new ConsLoString("e", 
                                                                      new MtLoString()))))))
          && t.checkExpect(this.abe.interleave(this.cd), new ConsLoString("a", 
                                                      new ConsLoString("c", 
                                                          new ConsLoString("b", 
                                                              new ConsLoString("d", 
                                                                  new ConsLoString("e", 
                                                                      new MtLoString()))))))
          && t.checkExpect(this.ab.interleave(this.cde), new ConsLoString("a", 
                                                          new ConsLoString("c", 
                                                              new ConsLoString("b", 
                                                                  new ConsLoString("d", 
                                                                      new ConsLoString("e", 
                                                                          new MtLoString()))))));
    }

    // test the method merge for the lists of Strings
    boolean testMerge(Tester t) {
      return t.checkExpect(this.empty.merge(this.empty), new MtLoString())
          && t.checkExpect(this.bd.merge(this.cd), new ConsLoString("b", 
                                                    new ConsLoString("c", 
                                                        new ConsLoString("d", 
                                                            new ConsLoString("d",  
                                                                    new MtLoString())))))
          && t.checkExpect(this.mary.merge(this.empty), new ConsLoString("Mary ", 
                                                         new MtLoString()))
          && t.checkExpect(this.ace.merge(this.bd), new ConsLoString("a", 
                                                      new ConsLoString("b", 
                                                          new ConsLoString("c", 
                                                              new ConsLoString("d", 
                                                                  new ConsLoString("e", 
                                                                      new MtLoString()))))))
          && t.checkExpect(this.abe.merge(this.cd), new ConsLoString("a", 
                                                        new ConsLoString("b", 
                                                            new ConsLoString("c", 
                                                                new ConsLoString("d", 
                                                                    new ConsLoString("e", 
                                                                        new MtLoString()))))))
          && t.checkExpect(this.abc.merge(this.de), new ConsLoString("a", 
                                                      new ConsLoString("b", 
                                                          new ConsLoString("c", 
                                                              new ConsLoString("d", 
                                                                  new ConsLoString("e", 
                                                                      new MtLoString()))))))
          && t.checkExpect(this.cd.merge(this.abe), new ConsLoString("a", 
                                                        new ConsLoString("b", 
                                                            new ConsLoString("c", 
                                                                new ConsLoString("d", 
                                                                    new ConsLoString("e", 
                                                                        new MtLoString()))))))
          && t.checkExpect(this.ab.merge(this.cde), new ConsLoString("a", 
                                                        new ConsLoString("b", 
                                                            new ConsLoString("c", 
                                                                new ConsLoString("d", 
                                                                    new ConsLoString("e", 
                                                                        new MtLoString()))))));
    }
   
    // test the method reverse for the lists of Strings
    boolean testReverse(Tester t) {
      return t.checkExpect(this.empty.reverse(), new MtLoString())
          && t.checkExpect(this.abc.reverse(), new ConsLoString("c", 
                                                  new ConsLoString("b", 
                                                      new ConsLoString("a", 
                                                          new MtLoString()))))
          && t.checkExpect(this.mary.reverse(), new ConsLoString("lamb.",
                                                  new ConsLoString("little ",
                                                      new ConsLoString("a ",
                                                          new ConsLoString("had ",
                                                              new ConsLoString("Mary ", 
                                                                  new MtLoString()))))));
    }
  /*  
    // test the method isDoubledList for the list of Strings
    boolean testisDoubledList(Tester t) {
      return t.checkExpect(this.abc.isDoubledList(), false) 
          && t.checkExpect(this.aabb.isDoubledList(), true)
          && t.checkExpect(this.abbc.isDoubledList(), false)
          && t.checkExpect(this.aabbdef.isDoubledList(), false);
    } */
}
