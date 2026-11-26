// File:    BinarySearch.java
// Devs:    Nathan W. Barros
// Origin:  2026-11-23
// Edited:  2026-11-23

package search;

public final class BinarySearch {

    private BinarySearch() {}

    public static int find(int[] arr, int val) {
        if (arr == null) return -1;

        int startOfBlock = 0;
        int endOfBlock   = arr.length -1;

        while (startOfBlock <= endOfBlock) {
            int middleOfBlock = startOfBlock + (endOfBlock - startOfBlock) / 2;
            int currentValue  = arr[middleOfBlock];

            if (currentValue == val)  {
                return middleOfBlock;
            } else if (currentValue < val) {
                startOfBlock = middleOfBlock + 1;
            } else {
                endOfBlock = middleOfBlock - 1;
            }
        }

        return -1;
    }

    public static int find(String[] arr, String val) {
        if (arr == null || val == null) return -1;

        int startOfBlock = 0;
        int endOfBlock = arr.length - 1;

        while (startOfBlock <= endOfBlock) {
            int middleOfBlock = startOfBlock + (endOfBlock - startOfBlock) / 2;
            String currentValue = arr[middleOfBlock];

            if (currentValue == null) {
                endOfBlock = middleOfBlock - 1;
                continue;
            }

            int cmp = currentValue.compareTo(val);
            if (cmp == 0) {
                return middleOfBlock;
            } else if (cmp < 0) {
                startOfBlock = middleOfBlock + 1;
            } else {
                endOfBlock = middleOfBlock - 1;
            }
        }

        return -1;
    }

}

// EOF
