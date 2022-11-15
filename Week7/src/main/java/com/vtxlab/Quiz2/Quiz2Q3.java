package com.vtxlab.Quiz2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Readable { //Funtional interface 
  void read();
}

interface Writable<T> {
  void write(T t );
}

class Pig {
  String name;

  public String getname(){
    return this.name; 
  }
}

class Database<T> implements Readable, Writable<T>{
  public List<T> list; //atributes 

  Database(List<T> list){ //constuctor 
    this.list = list;
  }

  @Override
  public void read(){
    this.list.forEach(e -> {
      Pig pig = (Pig) e; // if (e instanceOf Pig) 
      System.out.println(pig.getname());
    });
  }
    @Override
    public void write(T t){
      this.list.add(t);
    }

    public void remove(int index){
      this.list.remove(index);
    }

}

public class Quiz2Q3 { // No understand
  public static void main(String[] args) {
    Pig[] pigArray = {new Pig(), new Pig(), new Pig()};
    List<Pig> pigs = new ArrayList<>(Arrays.asList(pigArray));
    Database<Pig> pigDb = new Database<>(pigs);
    pigDb.write(new Pig()); //total 4 pig 
    pigDb.remove(0); // remove 1 pig 
    pigDb.read(); //  have the object, but inside no value , so get the 3 null pig;
  }

  // nullnullnull

  
}
