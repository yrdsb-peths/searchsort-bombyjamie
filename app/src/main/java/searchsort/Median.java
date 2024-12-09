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
        int n = arr.length;
        int[] aux = new int[n]; 
       
        mergeSort(arr, aux, 0, n - 1);

        if (n % 2 == 1) {
            return arr[n / 2]; 
        } else {
            return (arr[(n - 1) / 2] + arr[n / 2]) / 2.0; 
        }
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
    
    /**
     * Find the median of the array arr using InsertionSort algorithm.
     */
    public double findInsertion(int[] arr) {
        insertionSort(arr);

        int n = arr.length;
        if (n % 2 == 1) {
            return arr[n / 2];
        } else {
            return (arr[(n - 1) / 2] + arr[n / 2]) / 2.0;
        }
    }
    public void insertionSort(int[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++){
           for (int j = i; j > 0; j--){
              if (a[j-1] > a[j]){
                 exch(a, j, j-1);  //exchange
              } else {
                 break;
              }
           }
        }
     } 
     
}
