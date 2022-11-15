package com.vtxlab.Quiz1;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Quiz3 {
  static int counter = 10; 
  public static void main(String[] args) {
    for(byte i = 0; i < 128; i-- ){
      counter++;
    }
    System.out.println(counter);
  }
  
}
//what is the result of this program?
// A:127
// B:137
// C:139
// D:infiinte loop
// F:126
