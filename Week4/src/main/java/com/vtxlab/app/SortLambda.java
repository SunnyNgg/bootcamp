package com.vtxlab.app;
import static com.vtxlab.utility.SortUtil.sort;
import com.vtxlab.infra.Foundation;
import com.vtxlab.utility.InsortHolder;
import com.vtxlab.utility.SortHelper;
import com.vtxlab.utility.SortUtil;

public class SortLambda {
  public static void main(String[] args) {
    

      // selection sort
      SortHelper selectionSort = (int[] arr) -> {
        SortUtil.selectionSort(arr);
      };
  
      // insertion sort
      SortHelper insertionSort = (int[] arr) -> {
        SortUtil.insertionSort(arr);
      };
  
      int[] arr1 = { 1, 3, 5, 11 };
      int[] arr2 = { 1, 3, 5, 11 };
      int[] arr3 = { 1, 3, 5, 11 };
      int[] arr4 = { 1, 3, 5, 11 };
  
      sort(arr1, selectionSort); // [1, 2, 3, 4]
      sort(arr2, insertionSort); // [1, 2, 3, 4]
      sort(arr3, selectionSort); // [1, 2, 3, 4]
      sort(arr4, insertionSort); // [1, 2, 3, 4]

      int[] arr5 = {11, 8, 10, 4};
      InsortHolder insortHolder = new InsortHolder(arr5);
      InsortHolder.sortBy(ser.print();
      System.out.println(insortHolder.toString());

    }
  }
