// File:    RadixSort.java
// Devs:    Nathan W. Barros
// Origin:  2026-11-23
// Edited:  2026-11-23

public final class RadixSort {

    private RadixSort() {}
    
    // INTEGER SORTING
    public static void sort(int[] arr) {
        sort(arr, true);
    }

    public static void sort(int[] arr, boolean ascending) {

    }

    public static int[] sortedCopy(int[] arr) {
        return sortedCopy(arr, true);
    }

    public static int[] sortedCopy(int[] arr, boolean ascending) {
        return SortUtils.sortedCopy(arr, ascending, RadixSort::sort);
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
        return SortUtils.sortedCopy(arr, ascending, RadixSort::sort);
    }
}

// EOF
