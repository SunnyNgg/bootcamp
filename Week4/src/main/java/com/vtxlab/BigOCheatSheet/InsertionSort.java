package com.vtxlab.BigOCheatSheet;


public class InsertionSort {

  public static void main(String[] args) {

    int array[] ={ 9, 1, 2, 3, 6, 8, 4};
  
    for (int i : array){
      System.out.println(i + " ");
      
      
    }
    
  }

private static void InsertionSort(int[] array){

  for( int i = 1; i < array.length; i ++){
    int temp = array[i];
    int j = i-1;

    while(j >= 0 && array[j] > temp ){
      array[j+1] = array[j];
      j--;
    }
    array[j+1] =temp; 
  }



}
}