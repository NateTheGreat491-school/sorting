// File:    QuickSort.java
// Devs:    Nathan W. Barros
// Origin:  2026-11-23
// Edited:  2026-11-23

package sort;

public final class QuickSort {

    private QuickSort() {}

    public static void sort(int[] arr) {
        sort(arr, true);
    }

    public static void sort(int[] arr, boolean ascending) {
        
    }
    
    public int[] sortedCopy(int[] arr) {
        return sortedCopy(int[] arr, true);
    }

    public int[] sortedCopy(int[] arr, boolean ascending) {
        return SortUtils.sortedCopy(arr, ascending, QuickSort::sort);
    }
}

// EOF
