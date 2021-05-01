package Sorting;

import java.util.Arrays;

public class SelectionSort {

	public static void selcSort(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			
			for (int j = i; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			// Swap the found minimum element with the first element
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;	
		} // outer for loop
	} // method selcSort
	
	
	public static void main(String[] args) {
		int[] arr = {2, 15, 4, 37, 3, 9, 29, 30, 43, 12};
		
		System.out.println("Before Selection Sort");  
        for(int i:arr){  
            System.out.print(i+" ");  
        }  
        System.out.println();  
        
      //sorting array using selection sort    
        selcSort(arr);
         
        System.out.println("After Selection Sort");  
        for(int i:arr){  
            System.out.print(i+" ");  
        }  
        
        System.out.println("\n");
        
        SelectionSort sorting = new SelectionSort();
        sorting.generateRandomArray(10);
        System.out.println("Unsorted array");
        System.out.println(Arrays.toString(sorting.data));
        // call selection sort
        long startTime = System.currentTimeMillis();
        sorting.selectionSort();
        long endTime = System.currentTimeMillis();
        System.out.println("Sorted array");
        System.out.println(Arrays.toString(sorting.data));
        System.out.println("Sorting time: " + (endTime - startTime) + " ms");
        
	}
	
	int[] data;
	public void generateRandomArray(int n) {
		data = new int[n];
		for (int i = 0; i < n; i++) {
			data[i] = (int)(Math.random()*100);
		}
	}
	
	public void selectionSort() {
		for (int i = 0; i < data.length - 1; i++) {
			// sets minimum element
			int min_index = i;
			for (int j = i+1; j < data.length; j++) {
				if (data[j] < data[min_index]) {
					min_index = j;
				}
			}
			// Swap last element with the first element in unsorted array
			int temp = data[min_index];
			data[min_index] = data[i];
			data[i] = temp;
		}
	}
	
}
