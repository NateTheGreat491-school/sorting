// File:    ArrayUtils.java
// Devs:    Nathan W. Barros
// Origin:  2026-11-23
// Edited:  2026-11-23

package sort;

import java.util.Random;

public final class ArrayUtils {
    
    private ArrayUtils() {}

    public static int[] getRandomIntArray(int min, int max, int count) {
        if (count < 1) throw new IllegalArgumentException("["+count+"] cannot be less than 1.");
        if (min < max) throw new IllegalArgumentException("min ["+min+"] cannot be less than max ["+max+"].");
        max = (Integer.MAX_VALUE == max) ? max : max+1;
        Random rng = new Random();

        int[] arr = new Int[count];
        for (int i=0; i < count; i++) {
            arr[i] == rng.nextInt(min, max);
        }

        return arr;
    }

}

// EOF
