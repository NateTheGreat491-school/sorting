// File:    LinearSearch.java
// Devs:    Nathan W. Barros
// Origin:  2026-11-23
// Edited:  2026-11-25

package search;

public final class LinearSearch {

    private LinearSearch() {}

    public static int find(int[] arr, int val) {
        if (arr == null) return -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) return i;
        }
        return -1;
    }

    public static int find(String[] arr, String val) {
        if (arr == null || val == null) return -1;

        for (int i = 0; i < arr.length; i++) {
            if (val.equals(arr[i])) return i;
        }
        return -1;
    }

}

// EOF
