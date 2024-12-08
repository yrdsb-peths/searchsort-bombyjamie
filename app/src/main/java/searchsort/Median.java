package searchsort;

/**
 * The median is the middle value in an ordered integer list.
 * If the size of thelist is even,the median is the mean of the two
 * middle values.
 */
public class Median {
    /**
     * Find the median of the array arr using QuickSort algorithm.
     */
    public double findQuick(int[] arr) {
        quickSort(arr, 0, arr.length - 1);

        int n = arr.length;
        if (n % 2 == 1) {
            return arr[n / 2];
        } else {
            return (arr[(n - 1) / 2] + arr[n / 2]) / 2.0;
        }

    }
    private void quickSort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int p = partition(a, lo, hi); 
        quickSort(a, lo, p - 1); 
        quickSort(a, p + 1, hi); 
    }
   
    public int partition(int[] a, int lo, int hi) {
        int i = lo; 
        int j = hi + 1;
        while (true) {
            while (a[++i] < a[lo])  // Find item on left to swap  
                if (i == hi) break; 
            while (a[--j] > a[lo]) 
                if (j == lo) break;
            
            if (i >= j) break;  // Check if pointers cross 
            exch(a, i, j);  // Swap
        } 
        exch(a, lo, j);  // Swap partitioning element  
        return j;  // Return index of item now know to be in place
    }
    public void exch(int[] arr, int i, int j) {
        int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

    }
       
    /**
     * Find the median of the array arr using MergeSort algorithm.
     */
    public double findMerge(int[] arr) {
        return 0;
    }

    /**
     * Find the median of the array arr using InsertionSort algorithm.
     */
    public double findInsertion(int[] arr) {
        return 0;
    }

}
