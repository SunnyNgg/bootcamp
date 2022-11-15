package com.vtxlab.model;

public class InsertionSert{

  static void swap (int[] arr, int i , int j ){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

 static void insertionSert (int[] arr){

  for ( int i = 1; i <= arr.length; i++){
    int oldValue = arr[i]; //new =11
    int newValue = arr[i+1];  // old = 5

    while( newValue < oldValue ){
      int temp = arr[i]; //11
      arr[i] =arr[i+1];
      arr[i+1] = temp;
    
    }


    }
  }
}