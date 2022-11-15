package com.vtxlab.Quiz1;



  interface Secret {
    void show();


    void hide();
  }

  class Password4 implements Secret{ // only implement the show method 
    private String password; // also need to implement the hide method 
                             // because the class of Password4 implement the Secret so need to implement all abstact method

  
  @Override
  public void show(){
    System.out.println(("123"));
  }

  Password4(String x){
    this.password =x; 
  }

}
  public class Quiz8 {
    public static void main(String[] args) {
      Password4 p1 = new Password4("Start");
      p1.show();
    }
}
// Compile Error, Class Password must implment the method Secret.hide()