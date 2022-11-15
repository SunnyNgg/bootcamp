package com.vtxlab.BigOCheatSheet;

import java.time.Year;
import com.vtxlab.LessonWeekFour.SortHelper;

public final class SelectionSort {
  // 64,25,12,22,11

  public static final void sort(int[] arr, SortHelper sortHelper) {
    sortHelper.sort(arr);

  }

  public static final void sort(int arr[]) {
    // only campare the value of the index
    int n = arr.length; // lenght = 5
    for (int i = 0; i < n - 1; i++) // i = 0; 0 < 4; i = // i = 0
    {
      int minIndex = i; // minIndex = 1
      for (int j = i + 1; j < n; j++) {// j = i＋1; j < 5; j + 1 // j = 2 // i-1 i = 0
        if (arr[j] < arr[minIndex]) {
          minIndex = j;
        }
    }
      // minIndex = 1
      // minIndex = 1 // j =1;
      // swap
      int temp = arr[minIndex]; // 0 = 25
      arr[minIndex] = arr[i]; // 25 = 64
      arr[i] = temp; // 64 = 25
      System.out.println("\nAfter Swap : " + minIndex);
    }
  }

  public static final void printArray(int arr[]) // method for print the Array;
  {
    int n = arr.length;
    for (int i = 0; i < n; ++i)
      System.out.print(arr[i] + " ");
  }

  public static final void main(String args[]) {
    SelectionSort ob = new SelectionSort();
    int arr[] = {64, 25, 12, 22, 11};
    ob.sort(arr);
    System.out.println("Sorted array");
    ob.printArray(arr);

  }
}
