// File:    SortUtils.java
// Devs:    Nathan W. Barros
// Origin:  2026-11-23
// Edited:  2026-11-23

package sort;

@FunctionalInterface
interface ArraySorter<T> {
    void sort(T arr, boolean ascending);
}

final class SortUtils {

    private SortUtils() {}

    static boolean shouldSwap(int left, int right, boolean ascending) {
        return ascending ? left > right : left < right;
    }

    static boolean shouldSwap(String left, String right, boolean ascending) {
        if (left  == null && right == null) return false;
        if (left  == null)                  return ascending;
        if (right == null)                  return !ascending;
        
        int cmp = left.compareTo(right);
        return ascending ? cmp > 0 : cmp < 0;
    }

    static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    static void swap(String[] arr, int left, int right) {
        String temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    static int[] sortedCopy(int[] arr, boolean ascending, ArraySorter<int[]> sorter) {
        if (arr == null) return null;

        int[] copy = arr.clone();
        sorter.sort(copy, ascending);
        return copy;
    }

    static String[] sortedCopy(String[] arr, boolean ascending, ArraySorter<String[]> sorter) {
        if (arr == null) return null;
        
        String[] copy = arr.clone();
        sorter.sort(copy, ascending);
        return copy;
    }
}

// EOF
