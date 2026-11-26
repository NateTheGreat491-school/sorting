// File:    RadixSort.java
// Devs:    Nathan W. Barros
// Origin:  2026-11-23
// Edited:  2026-11-23

package sort;

public final class RadixSort {

    private static final int BYTE_BITS        = 8;
    private static final int BYTE_RADIX       = 256;
    private static final int BYTE_MASK        = 0xFF;
    private static final int INT_PASSES       = Integer.SIZE / BYTE_BITS;
    private static final int SIGN_FLIP        = 0x80000000;
    private static final int INSERTION_CUTOFF = 32;

    private RadixSort() {}

    
    // LSD RADIX INTEGER SORTING
    public static void sort(int[] arr) {
        sort(arr, true);
    }

    public static void sort(int[] arr, boolean ascending) {
        if (arr == null || arr.length < 2) return;
        radixLSD(arr);
        if (!ascending) reverse(arr);
    }

    public static int[] sortedCopy(int[] arr) {
        return sortedCopy(arr, true);
    }

    public static int[] sortedCopy(int[] arr, boolean ascending) {
        return SortUtils.sortedCopy(arr, ascending, RadixSort::sort);
    }

    // MSD RADIX STRING SORTING
    public static void sort(String[] arr) {
        sort(arr, true);
    }

    public static void sort(String[] arr, boolean ascending) {
        if (arr == null || arr.length < 2) return;
        int size = moveNullsToEnd(arr);
        if (size > 1) radixMSD(arr, new String[size], 0, size, 0);
        if (!ascending) reverse(arr);
    }

    public static String[] sortedCopy(String[] arr) {
        return sortedCopy(arr, true);
    }

    public static String[] sortedCopy(String[] arr, boolean ascending) {
        return SortUtils.sortedCopy(arr, ascending, RadixSort::sort);
    }

    // LSD RADIX FOR INTEGERS (AI INFLUENCED)
    private static void radixLSD(int[] arr) {
        int arrlen = arr.length;
        int[] src, dst, tmp;
        int[][] count = new int[INT_PASSES][BYTE_RADIX + 1];
        
        src = arr;
        dst = new int[arrlen];

        // single pass histogram (AI GENERATED)
        for (int value : arr) {
            for (int pass = 0; pass < INT_PASSES; pass++) {
                count[pass][ digit(value, pass * BYTE_BITS) + 1]++;
            }
        }

        for (int pass = 0; pass < INT_PASSES; pass++) {
            int shift = pass * BYTE_BITS;
            int[] bucket = count[pass];

            if ( bucket[ digit(arr[0], shift) + 1] == arrlen ) continue;

            for (int b=0; b < BYTE_RADIX; b++) {
                bucket[b+1] += bucket[b];
            }
            
            // AI GENERATED
            for (int value : src) {
                dst[ bucket[ digit(value, shift)]++ ] = value;
            }

            tmp = src;
            src = dst;
            dst = tmp;
        }
        
        if (src != arr) System.arraycopy(src, 0, arr, 0, arrlen);
    }
    
    // AI GENERATED
    // for handling negative numbers as unsinged bytes
    private static int digit(int value, int shift) {
        return ((value ^ SIGN_FLIP) >>> shift) & BYTE_MASK;
    }

    private static void reverse(int[] arr) {
        int j = arr.length -1;
        for (int i=0; i < j; i++, j--) {
            SortUtils.swap(arr, i, j);
        }
    }

    
    // MSD RADIX FOR STRINGS (MOSTLY AI GENERATED)
    private static void radixMSD(String[] arr, String[] aux, int start, int end, int depth) {
        while (true) {
            int minKey = Integer.MAX_VALUE;
            int maxKey = 0;

            for (int i = start; i < end; i++) {
                int key = key(arr[i], depth);
                if (key < minKey) minKey = key;
                if (key > maxKey) maxKey = key;
            }

            if (maxKey == 0) return;
            if (minKey == maxKey) { depth++; continue; }

            int range   = maxKey - minKey + 1;
            int[] count = new int[range + 1];

            for (int i = start; i < end; i++) {
                count[ key(arr[i], depth) - minKey + 1]++;
            }

            for (int b=0; b < range; b++) {
                count[b+1] += count[b];
            }

            for (int i = start; i < end; i++) {
                aux[ start + count[ key(arr[i], depth) - minKey]++ ] = arr[i];
            }

            System.arraycopy(aux, start, arr, start, end - start);

            int bucketStart = start;
            for (int b=0; b < range; b++) {
                int bucketEnd = start + count[b];
                boolean ended = (minKey + b == 0);
                if (!ended && bucketEnd - bucketStart > 1) {
                    radixMSD(arr, aux, bucketStart, bucketEnd, depth+1);
                }
                bucketStart = bucketEnd;
            }

            return;
        }
    }
    
    // cmp depth to strlen && \0
    private static int key(String str, int depth) {
        return depth < str.length() ? str.charAt(depth) + 1 : 0;
    }

    private static void reverse(String[] arr) {
        int j = arr.length - 1;
        for (int i=0; i < j; i++, j--) {
            SortUtils.swap(arr, i, j);
        }
    }

    // AI INFLUENCED
    private static int moveNullsToEnd(String[] arr) {
        int size = 0;

        for (String str : arr) {
            if (str != null) arr[size++] = str;
        }

        for (int i = size; i < arr.length; i++) {
            arr[i] = null;
        }

        return size;
    }

}

// EOF
