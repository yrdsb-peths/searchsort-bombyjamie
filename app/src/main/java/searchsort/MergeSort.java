package searchsort;

public class MergeSort extends Sort {
    /**
     * Sort the array arr using merge sort algorithm.
     */
    @Override
    public void sort(int[] arr) {
        int[] aux = new int[a.length];
        mergeSort(arr, aux, 0, arr.length - 1);

    }
    private void mergeSort(int[] a, int[] aux, int lo, int hi) {
        // Array is sorted if lo is greater than hi
        if (lo >= hi) return;
        int mid = (lo + hi) / 2;         //index of middle element
        mergeSort(a, aux, lo, mid);      //Sort left side of array
        mergeSort(a, aux, mid + 1, hi);  //Sort right side of array
        merge(a, aux, lo, mid, hi);      //Combine both halves
    
    } 
    
    public static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) // Copy elements to auxiliary array
            aux[k] = a[k];
        int i = lo;
        j = mid+1;
        for (int k = lo; k <= hi; k++) {  // Merge back to original array
            if (i > mid)		a[k] = aux[j++];               
            else if (j > hi)	a[k] = aux[i++];
            else if (aux[j] < aux[i])   a[k] = aux[j++];
            else                	a[k] = aux[i++];
        }
    }
    /*
     * Merge the two sorted arrays left and right into the array arr.
     */
    private void merge(int[] arr, int[] left, int[] right) {
        int i = 0; 
        int j = 0; 
        int k = 0; 

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}
