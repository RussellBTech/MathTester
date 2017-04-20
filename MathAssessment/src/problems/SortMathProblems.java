package problems;

public class SortMathProblems {
	
	private static MathProblem[] problems;
	private static int length;
	
	/**
	 * Sorts an array of problems
	 * @param toSort
	 */
	public static void sort(MathProblem[] toSort) {
		if(toSort == null || toSort.length == 0) {
			return;
		}
		problems = toSort;
		length = toSort.length;
		quickSort(0, length - 1);
	}
	
	public static void quickSort(int low, int high) {
		int lowTemp = low;
		int highTemp = high;
		
		MathProblem pivot = problems[low + (high - low) / 2];
		
	}
}

/*
public class RussellsQuickSort {

	private static int[] array;
	private static int value;
	
	/**
	 * Sorts the array passed as a parameter
	 * @param values The array to be sorted
	
	public static void sort(int[] values) {
		if(values == null || values.length == 0){
			return;
		}
		array = values;
		value = values.length;
		quickSort(0, value - 1);
	}
	
	/**
	 * Recursively sorts the array by splitting the array
	 * around a pivot.
	 * @param low Starting point for low value, should usually be 0
	 * @param high Starting high value, should usually be length - 1
	 
	private static void quickSort(int low, int high) {
		int lowTemp = low, highTemp = high;
		
		int pivot = array[low + (high - low) / 2];
		
		while(lowTemp <= highTemp) {
			
			while(array[lowTemp] < pivot) {
				lowTemp++;
			}
			
			while(array[highTemp] > pivot) {
				highTemp++;
			}
			
			if(lowTemp <= highTemp) {
				swap(lowTemp, highTemp);
				lowTemp++;
				highTemp--;
			}
		}
		
		/*
		 * I love recursion!!!
		 * This splits from the low half until
		 * the low >= highTemp
		 
		if(low < highTemp) {
			quickSort(low, highTemp);
		}
		if(lowTemp < high) {
			quickSort(lowTemp, high);
		}
	}
	
	/**
	 * Swaps two indexes in an array
	 * @param index1 The first index to be swapped
	 * @param index2 The second index to be swapped
	 
	private static void swap(int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
}
*/
