package com.vtxlab.Quiz2;

interface Codable{ // not understand 
  void code();
}

public class Quiz2Q6 implements Codable {
  public static void main(String[] args) {
    Codable vincent = () -> System.out.println("I love coding, Java");

    Codable alan = new Codable() { // new object 
      @Override
      public void code(){
        Quiz2Q6 tommy = createKiller();
        tommy.kill(vincent);
      }

      public static Quiz2Q6 createKiller(){
        return new Quiz2Q6();
      }
    };

    Quiz2Q6 tommy = new Quiz2Q6();
    tommy.kill(vincent); //excute 
    tommy.kill(alan); //  excute 
  }

  public void code(){
    System.out.println("I love coding, Python");
  }

  public void kill(Codable code){
    code.code(); // tommy.kill(vincent)
  }
  
}
