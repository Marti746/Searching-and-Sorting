/**
 * Implement sorting algorithms:
 * - Selection sort
 * - Insertion sort
 * - Quick sort
 * - Merge sort
 */
import java.util.Arrays;

public class Sorting {

	/**
	 * To do: Implement selection sort.
	 * @param array the array to sort
	 */
	public static void selectionSort(int[] array) {
		//throw new UnsupportedOperationException();
		for (int i = 0; i < array.length - 1; i++) {
			// sets minimum element
			int min_index = i;
			for (int j = i+1; j < array.length; j++) {
				if (array[j] < array[min_index]) {
					min_index = j;
				}
			}
			// Swap last element with the first element in unsorted array
//			int temp = array[min_index];
//			array[min_index] = array[i];
//			array[i] = temp;
			swap(array, min_index, i);
		}
		
	}

	/**
	 * To do: Implement insertion sort.
	 * @param array the array to sort
	 */
	public static void insertionSort(int[] array) {
		//throw new UnsupportedOperationException();
		for (int i = 1; i < array.length; i++) {
			// current value in the array
			int current = array[i];
			int j = i - 1;
			// goes through the array comparing if it's greater or less then the current
			while ((j > -1) && (array[j] > current)) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = current;
		}
	}

	/**
	 * To do: Implement quick sort.
	 * @param array the array to sort
	 */
	public static void quickSort(int[] array) {
		// call quickSort(int[], int, int) to initiate sorting
		//throw new UnsupportedOperationException();
		quickSort(array, 0, array.length-1);
	}

	/**
	 * To do: Implement overloaded quick sort method.
	 * @param array the array to sort
	 * @param begin the starting index of the array to be sorted
	 * @param end the last index of the array to be sorted
	 */
	private static void quickSort(int[] array, int begin, int end) {
		// you need to write the quick sort algorithm here
		// use this method quickSort(int [], int, int) and partition(int [], int int) to complete it
		//throw new UnsupportedOperationException();
        if (begin >= end) {
            return;
        }
		//int piv;
        if (begin < end) {
        	//int middle = begin + (end - begin) / 2;
        	//int piv = array[middle];
        	int piv = partition(array, begin, end);
        	quickSort(array, begin, piv - 1);
        	quickSort(array, piv + 1, end);
        }
	}

	/**
	 * To do: Partition an array following quick sort algorithm and
	 * return the location of the pivot element.
	 * Note: You can select any element to be the pivot.
	 * @param array the array to partition
	 * @param begin the starting index of the array to be partitioned
	 * @param end the last index of the array to be partitioned
	 * @return the index of the pivot element
	 */
	private static int partition(int[] array, int begin, int end) {
		// You can use the swap method defined below to swap two elements in an array
		//throw new UnsupportedOperationException();
		// gets the pivot and the beginning position
	    int piv = array[begin];
		//int piv = array[(begin - end) / 2];
	    //int i = (begin - 1);
		int i = begin + 1;
	   
	    for(int j = begin + 1; j <= end; j++) {
	        // If the element is smaller then swap and move position
	        if (array[j] < piv) {
	            swap(array, i, j);
	            i++;
	        }
	    }
	    //if not smaller then switch to the beginning and continue with the next element of the array
	    //swap(array, i + 1, end);
	    swap(array, begin, i - 1);
	    // sorted: [-9, 45, -2, 11, 0] -> swap(array, i, end);
	    return (i - 1);
	    // if remove all +1 from section -> sorted: [-9, 11, 0, -2, 45]
	}

	/**
	 * Swap two elements in an array
	 * @param array the array
	 * @param i the index of the first element
	 * @param j the index of the second element
	 */
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	/**
	 * To do: Implement merge sort.
	 * @param array the array to sort
	 * @return the sorted array
	 */
	public static int[] mergeSort(int[] array) {
		// call mergeSort(int [], int, int) to initiate sorting

		//int[] newArr = mergeSort(array, 0, array.length-1);
		int[] arr;
		arr = mergeSort(array, 0, array.length-1);
		//return mergeSort(array, 0, array.length-1);
		return arr;
	}

	/**
	 * To do: Implement overloaded merge sort method.
	 * @param array the array to sort
	 * @param begin the starting index of the array to be sorted
	 * @param end the last index of the array to be sorted
	 */
	private static int[] mergeSort(int[] array, int begin, int end) {
		// you need to write the merge sort algorithm here
		// use this method mergeSort(int [], int, int) and merge(int [], int[]) to complete it
//		if (begin >= end) {
//			return array;
//		}
		if (array.length == 1) {
			return array;
		}
		
		int mid = array.length / 2;
		int[] newArr = null;
		if (array.length > 1) {
		int[] left = new int[mid], right = new int[array.length - left.length];
		//copy into left array
		for (int i = 0; i < left.length; i++) {
			left[i] = array[i];
		}
		//copy into right array
		for (int i = 0; i < right.length; i++) {
			right[i] = array[left.length + i];
		}
		//mergeSort(array, begin, mid);
		//mergeSort(array, mid + 1, end);
		
		left = mergeSort(left, begin, mid); // left 
		left = mergeSort(left, mid + 1, end);
		newArr = merge(left,right);
		
		right = mergeSort(right, mid + 1, end); // right
		right = mergeSort(right, begin, mid);
		newArr = merge(left,right);
		//int[] newArr;
		return newArr = merge(left,right);
		}
		//mergeSort(newArr, begin, mid);
		//mergeSort(newArr, mid + 1, end);

		return newArr;
	}

	/**
	 * To do: Merge two sorted arrays into one and return it
	 * @param left the first array
	 * @param right the second array
	 * @return the sorted merged array
	 */
	private static int[] merge(int[] left, int[] right) {
		// merge two sorted array such way that it remains sorted
		//throw new UnsupportedOperationException();
		int[] result = new int[left.length + right.length];

			// Initial indexes of right and left arrays
	        int leftp = 0; 
    		int rightp = 0;
	 
	        // start index of merged array
	        int k = 0;
	        while (leftp < left.length && rightp < right.length) {
	            if (left[leftp] <= right[rightp]) {
	            	//result[k] = 0;
	                result[k] = left[leftp];
	                leftp++;
	            }
	            else {
	            	//result[k] = 0;
	                result[k] = right[rightp];
	                rightp++;
	            }
	            k++;
	        }
	 
	        /* Copy remaining elements of L[] if any */
	        while (leftp < left.length) {
	            result[k] = left[leftp];
	            leftp++;
	            k++;
	        }
	 
	        /* Copy remaining elements of R[] if any */
	        while (rightp < right.length) {
	            result[k] = right[rightp];
	            rightp++;
	            k++;
	        }
		return result;
		
		//int leftp = 0;
		//int rightp = 0;
		
		//for (int i = 0; i < result.length; i++) {
//			if (rightp >= right.length || leftp <= left.length && left[leftp] <= right[rightp]) { 
//			/*if (left[leftp] < right[rightp] || right[rightp] > left[leftp]) {*/
//			result[i] = left[leftp];
//			//result[i] = 0;
//			leftp++;
//			} else {
//			result[i] = right[rightp];
//			//result[i] = 0;
//			rightp++;
//			}
//	}
	}

	/**
	 * To do: Test the sorting methods defined above
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		// use this main method to sort a simple array
		// it will help you to test your sorting methods you defined above
		int[] data = { -2, 45, 0, 11, -9 };
		System.out.println("Unsorted: " + Arrays.toString(data));

		// sort the array using your implemented algorithm.
		// call the sorting method here:
		//selectionSort(data);
		//insertionSort(data);
		//quickSort(data);
		int[] newArr;
		newArr = mergeSort(data);
		System.out.println("sorted: " + Arrays.toString(newArr));
		//System.out.println("sorted: " + Arrays.toString(data));
	
	}
}
