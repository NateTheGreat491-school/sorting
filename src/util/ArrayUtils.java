// File:    ArrayUtils.java
// Devs:    Nathan W. Barros
// Origin:  2026-11-23
// Edited:  2026-11-23

package util;

import java.util.Arrays;
import java.util.Random;

public final class ArrayUtils {
    
    private ArrayUtils() {}

    public static int[] getRandomIntArray(int min, int max, int length) {
        if (length < 1) throw new IllegalArgumentException("["+length+"] cannot be less than 1.");
        if (min > max)  throw new IllegalArgumentException("min ["+min+"] cannot be less than max ["+max+"].");
        max = (Integer.MAX_VALUE == max) ? max : max+1;
        Random rng = new Random();

        int[] arr = new int[length];
        for (int i=0; i < length; i++) {
            arr[i] = rng.nextInt(min, max);
        }

        return arr;
    }

    public static String[] getRandomStringArray(int minChars, int maxChars, int length, String symbols) {
        if (length < 1) throw new IllegalArgumentException("["+length+"] cannot be less than 1.");
        if (minChars < 0 || minChars > maxChars) {
            throw new IllegalArgumentException("min ["+minChars+"] cannot be less than 0 or max ["+maxChars+"].");
        }
        if (symbols == null || symbols.isEmpty()) {
            throw new IllegalArgumentException("Symbols string must not be empty");
        }
        
        String[] result  = new String[length];
        int symbol_count = symbols.length();
        Random rng       = new Random();

        for (int i=0; i < length; i++) {
            int strlen = minChars + rng.nextInt(maxChars - minChars + 1);
            
            StringBuilder str = new StringBuilder(strlen);
            for (int j=0; j < strlen; j++) {
                str.append(symbols.charAt( rng.nextInt(symbol_count) ));
            }

            result[i] = str.toString();
        }

        return result;
    }

    public static String[] head(String[] arr, int count) {
        return Arrays.copyOfRange(arr, 0, Math.min(count, arr.length));
    }

}

// EOF
