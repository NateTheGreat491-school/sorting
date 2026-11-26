// File:    BinarySearch.java
// Devs:    Nathan W. Barros
// Origin:  2026-11-23
// Edited:  2026-11-23

package search;

public final class BinarySearch {

    private BinarySearch() {}

    public static int find(int[] arr, int val) {
        int startI = 0;
        int endI = arr.length - 1;

        while (true) {
            int middleIndex = (endI - startI) / 2 + startI;

            if (endI - startI == 0) {
                return arr[middleIndex] == val ? middleIndex : -1;
            }

            if (arr[middleIndex] == val) {
                return middleIndex;
            } else if (val < arr[middleIndex]) {
                endI = middleIndex - 1;
            } else {
                startI = middleIndex + 1;
            }
        }
    }

    public static int find(int[] arr, int val) {
        int start = 0;
        int end = arr.length - 1;

        while (true) {
            int index = (end - start) / 2 + start;
            if (arr[index] == val) break;
            if (end - start == 0)  index = -1; break;

            if (val < arr[index]) {
                index = 
            } else {

            }
        }
        if (index == -1) index = (arr[index] == val) ? index : -1;
        return index;
    }

    public static int find(String[] arr, String val) {

    }

}

// EOF
