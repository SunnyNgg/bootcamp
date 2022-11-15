package com.vtxlab.Quiz2;


 class CustomExeption extends Exception{

  public CustomExeption(){ // consturtor

  }

  public CustomExeption(String msg, Throwable e){
    super (msg, e);
  }

  public static void test() throws CustomExeption{
    throw new Exception(); // Exception is parentClass , you can't use the ChildClass(CustomExeption) to catch the Animals 
  }



  public static void main(String[] args) throws Exception{
    test();
  }
  
}
