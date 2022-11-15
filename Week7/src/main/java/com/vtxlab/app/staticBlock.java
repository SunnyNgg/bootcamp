package com.vtxlab.app;

import javax.swing.plaf.basic.BasicDesktopIconUI;

public class staticBlock {
  
  int bcd ;
  static int abc =12 ;
  String c ;

  staticBlock(int bcd, String c ){
    this.bcd = bcd; 
    this.c = c; 
  }

  public int getbcd(){
    return this.bcd;
  }

  public void setbcd(int bcd){
    this.bcd =bcd;
  }


  
  static{
    System.out.println(12+abc);
  }
  
  public static void main(String[] args) {
    staticBlock a = new staticBlock(15, "To");
   // a.setbcd(22);
   // a.setbcd(1000);
    System.out.println( "bcd");
    System.out.println(a.bcd);
    
  }

  static{
    System.out.println(123);
    

    
  }
}

