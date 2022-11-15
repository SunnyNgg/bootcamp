package com.vtxlab.LessonWeekFour;

import java.util.Hashtable;
import java.util.Iterator;

public class HashTableExample {

  public static void main(String[] args) {
    
  

  Hashtable<Integer, String> hashtable = new Hashtable<>();

  hashtable.put( 1, "A");
  hashtable.put( 2, "B");
  hashtable.put( 3, "C");
  hashtable.put( 3, "D");

  System.out.println(hashtable);

  String value = hashtable.get(1);
  System.out.println(3); // 3 is deleted

  Iterator<Integer> itr = hashtable.keySet().iterator();

  while(itr.hasNext()){
    Integer key = itr.next();
    String mappedValue = hashtable.get(key);

    System.out.println("Key: " + key + "Value: " + mappedValue);
  }
/* 
  Output
  {3=D, 2=B, 1=A }
  A
  Key 2, Value: B
  Key 1, Value: A
*/

}
}