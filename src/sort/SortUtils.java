// File:    SortUtils.java
// Devs:    Nathan W. Barros
// Origin:  2026-11-23
// Edited:  2026-11-23

package sort;

@FunctionalInterface
interface IntArraySorter {
    void sort(int[] arr, boolean ascending)
}

final class SortUtils {

    private SortUtils() {}

    static boolean shouldSwap(int left, int right, boolean ascending) {
        return ascending ? left > right : left < right
    }

    static int[] sortedCopy(int[] arr, boolean ascending, IntArraySorter sorter) {
        if (arr == null) return null;

        int[] copy = arr.clone();
        sorter.sort(copy, ascending);
        return copy;
    }
}

// EOF
