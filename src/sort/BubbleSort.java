// File:    BubbleSort.java
// Devs:    Nathan W. Barros
// Origin:  2026-11-23
// Edited:  2026-11-23

package sort;

public final class BubbleSort {

    private BubbleSort() {} 

    public static void sort(int[] arr) {
        sort(arr, true);
    }

    public static void sort(int[] arr, boolean ascending) {
        if (arr == null || arr.length < 2) return;
        int arrlen, lastIndex, temp;
        boolean swapped, canSwap;

        arrlen = arr.length;
        for (int pass=0; pass < arrlen-1; pass++) {
            swapped = false;
            lastIndex = arrlen - 1 - pass;

            for (int i=0; i < lastIndex; i++) {
                canSwap = SortUtils.shouldSwap(arr[i], arr[i+1], ascending);
                if (canSwap) {
                    temp    = arr[i];
                    arr[i]  = arr[i+1];
                    arr[i+1]  = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
    }

    public static int[] sortedCopy(int[] arr) {
        return sortedCopy(arr, true);
    }

    public static int[] sortedcopy(int[] arr, boolean ascending) {
        return SortUtils.sortedCopy(arr, ascending, BubbleSort::sort);
    }
}

// EOF
