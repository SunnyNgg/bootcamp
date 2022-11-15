package com.vtxlab.Quiz1;




  class Secret{
    int level =1 ;
  }

  class Password extends Secret {
    int level =2; 

  }
  public class Quiz14 {
    public static void main(String[] args) {
      int age = Password.level; //not a static contect
      System.out.println(this.level); // do not new the object
    }
}
