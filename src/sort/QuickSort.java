// File:    QuickSort.java
// Devs:    Nathan W. Barros
// Origin:  2026-11-23
// Edited:  2026-11-23

package sort;

public final class QuickSort {

    private QuickSort() {}

    // INTEGER SORTING
    public static void sort(int[] arr) {
        sort(arr, true);
    }

    public static void sort(int[] arr, boolean ascending) {
        if (arr == null || arr.length < 2) return;
        quickSort(arr, 0, arr.length-1, ascending);
    }
    
    public static int[] sortedCopy(int[] arr) {
        return sortedCopy(arr, true);
    }

    public static int[] sortedCopy(int[] arr, boolean ascending) {
        return SortUtils.sortedCopy(arr, ascending, QuickSort::sort);
    }
    
    // STRING SORTING
    public static void sort(String[] arr) {
        sort(arr, true);
    }

    public static void sort(String[] arr, boolean ascending) {
        if (arr == null || arr.length < 2) return;
        quickSort(arr, 0, arr.length-1, ascending);
    }

    public static String[] sortedCopy(String[] arr) {
        return sortedCopy(arr, true);
    }

    public static String[] sortedCopy(String[] arr, boolean ascending) {
        return SortUtils.sortedCopy(arr, ascending, QuickSort::sort);
    }
    
    // QUICKSORT UTILITY FOR INTEGERS
    private static void quickSort(int[] arr, int startOfBlock, int endOfBlock, boolean ascending) {
        if (startOfBlock >= endOfBlock) return;
        
        int middleOfBlock  = startOfBlock + (endOfBlock - startOfBlock) / 2;
        int pivotIndex     = startOfBlock;
        int pivot          = arr[middleOfBlock];
        boolean canSwap;

        // partition
        SortUtils.swap(arr, middleOfBlock, endOfBlock);
        for (int i = startOfBlock; i < endOfBlock; i++) {
            canSwap = SortUtils.shouldSwap(pivot, arr[i], ascending);
            if (canSwap) {
                SortUtils.swap(arr, i, pivotIndex);
                pivotIndex++;
            }
        }
        SortUtils.swap(arr, pivotIndex, endOfBlock);

        quickSort(arr, startOfBlock, pivotIndex-1, ascending);
        quickSort(arr, pivotIndex+1, endOfBlock, ascending);
    }

    // QUICKSORT UTILITY FOR STRINGS
    private static void quickSort(String[] arr, int startOfBlock, int endOfBlock, boolean ascending) {
        if (startOfBlock >= endOfBlock) return;
        
        int middleOfBlock  = startOfBlock + (endOfBlock - startOfBlock) / 2;
        int pivotIndex     = startOfBlock;
        String pivot       = arr[middleOfBlock];
        boolean canSwap;

        // partition
        SortUtils.swap(arr, middleOfBlock, endOfBlock);
        for (int i = startOfBlock; i < endOfBlock; i++) {
            canSwap = SortUtils.shouldSwap(pivot, arr[i], ascending);
            if (canSwap) {
                SortUtils.swap(arr, i, pivotIndex);
                pivotIndex++;
            }
        }
        SortUtils.swap(arr, pivotIndex, endOfBlock);

        quickSort(arr, startOfBlock, pivotIndex-1, ascending);
        quickSort(arr, pivotIndex+1, endOfBlock, ascending);
    }
}

// EOF
