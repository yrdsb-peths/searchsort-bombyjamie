package searchsort;

public class SelectionSort {
    /**
     * Sort the array arr using selection sort algorithm.
     */
    public void sort(int[] arr) {
        for(int curIndex = 0; curIndex < arr.length - 1; curIndex++)
        {
            // Find minimum in the rest of the list
            int minIndex = findMin(arr, curIndex);
            
            // Swap the minimum into the correct position
            exch(arr, curIndex, minIndex);
        }
    }
    private int findMin(int[] arr, int startingIndex)
    {
        int minIndex = startingIndex;
        
        for(int i = minIndex + 1; i < arr.length; i++)
        {
            if(arr[i] < arr[minIndex])
            {
                minIndex = i;
            }
        }
        
        return minIndex;
    }
    public void exch(int[] arr, int i, int j) {
        int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

    }
}
