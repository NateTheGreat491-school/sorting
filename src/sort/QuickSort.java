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
        
    }
    
    public int[] sortedCopy(int[] arr) {
        return sortedCopy(int[] arr, true);
    }

    public int[] sortedCopy(int[] arr, boolean ascending) {
        return SortUtils.sortedCopy(arr, ascending, QuickSort::sort);
    }
    
    // STRING SORTING
    public static void sort(String[] arr) {
        sort(arr, true);
    }

    public static void sort(String[] arr, boolean ascending) {

    }

    public static String[] sortedCopy(String[] arr) {
        return sortedCopy(arr, true);
    }

    public static String[] sortedCopy(String[] arr, boolean ascending) {
        return SortUtils.sortedCopy(arr, ascending, QuickSort::sort);
    }
}

// EOF
