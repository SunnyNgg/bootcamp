package com.vtxlab.Quiz1;

public class Quiz11 {
  public int normalMethod(int n ){
    int[] arr = new int[]{1,3,5,7,9,11,13};
    int total = 0;
    for(int i = 0; i<n; i++){
      total +=arr[i];
    }
    return total;
  }
  public static void main(String[] args) {
    System.out.println(Quiz11.normalMethod(4));
  }
}

// complie error becasue it can't use the class.method
// it is not a static method!!!