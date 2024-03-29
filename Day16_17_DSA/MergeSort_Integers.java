package Day16_17_DSA;

public class MergeSort_Integers {

	// Merges two subarrays of arr[].
	// First subarray is arr[l..m]
	// Second subarray is arr[m+1..r]

	void merge(int arr[], int l, int m, int r) 
	{
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/* Copy data to temp arrays */
		for (int i = 0; i < n1; ++i)
		{
			L[i] = arr[l + i];
			
		    for (int j = 0; j < n2; ++j)
		    {
		    	R[j] = arr[m + 1 + j];
		    }
		}
		/* Merge the temp arrays */
		// Initial indexes of first and second subarrays
		// Initial index of merged subarray array
		int i = 0;
		int j = 0;
		int k = l;
		
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) 
			{
				arr[k] = L[i];
				i++;
			} 
			else 
			{
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) 
		{
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) 
		{
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	// Main function that sorts arr[l..r] using
	// merge()
	void sort(int arr[], int l, int r) 
	{
		if (l < r) 
		{
			// Find the middle point
			int m = l + (r - l) / 2;

			// Sort first and second halves
			sort(arr, l, m);
			sort(arr, m + 1, r);

			// Merge the sorted halves
			merge(arr, l, m, r);
		}
	}

	/* A utility function to print array of size n */
	static void printArray(int arr[]) 
	{
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	// Driver code
	public static void main(String args[]) 
	{
		int arr[] = { 48, 11, 73, 15, 26, 17, 30, 14 };

		System.out.println("Before Sorted Array");
		printArray(arr);

		MergeSort_Integers ob = new MergeSort_Integers();
		ob.sort(arr, 0, arr.length - 1);

		System.out.println("\nSorted array");
		printArray(arr);
	}

}



/*

       step 1: start

       step 2: declare array and left, right, mid variable

		step 3: perform merge function.
    	if left > right
        return
    	mid= (left+right)/2
    	mergesort(array, left, mid)
    	mergesort(array, mid+1, right)
    	merge(array, left, mid, right)

		step 4: Stop

		Follow the steps below to solve the problem:

		MergeSort(arr[], l,  r)
		If r > l

		Find the middle point to divide the array into two halves: 
		middle m = l + (r – l)/2
		Call mergeSort for first half:   
		Call mergeSort(arr, l, m)
		Call mergeSort for second half:
		Call mergeSort(arr, m + 1, r)
		Merge the two halves sorted in steps 2 and 3:
		Call merge(arr, l, m, r)


*/