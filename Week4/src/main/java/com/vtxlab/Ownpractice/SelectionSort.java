package com.vtxlab.Ownpractice;

import com.vtxlab.infra.Foundation;

//[11,5,7,19,4,1,7] i = 0?
  public class SelectionSort 
  {
  public static void setlectionsort (int[] arr)
  {

    int n = arr.length;
    for( int i = 0; i < n-1; i++ )
    {

      int minmumIndex = i;
      for(int j = i+1 ; j < n; j++)
       if(arr[j] < arr[minmumIndex])
       minmumIndex = j;
     int temp = arr[minmumIndex];
     arr[minmumIndex] = arr[i];
     arr[i] = temp;
  }
  }

  public static void printArray( int[] arr)
  {
    int n = arr.length;
    for( int i = 0; i < n; ++i)
    System.out.print( arr[i] + " ");
  }

  
public static void main(String[] args) {

  int[] abc = {52, 24, 36, 78, 34};
  SelectionSort.setlectionsort(abc);
  System.out.println("Sort Array");
  SelectionSort.printArray(abc);

  }
}