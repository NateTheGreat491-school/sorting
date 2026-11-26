// File:    Main.java
// Devs:    Nathan W. Barros
// Origin:  2026-11-25
// Edited:  2026-11-25

package main;

import java.util.Arrays;
import java.util.Scanner;

import sort.BubbleSort;
import sort.QuickSort;
import sort.RadixSort;
import search.LinearSearch;
import search.BinarySearch;
import util.ArrayUtils;
import util.TimeUtils;
import util.TerminalUtils;

public final class Main {

    private static Scanner userin = new Scanner(System.in);
    
    public static void main(String[] args) {
        TerminalUtils.enterAltScreen();
        try {
            solveProblems();
        } catch (Exception e) {
            System.out.print(e);
        } finally {
            TerminalUtils.leaveAltScreen();
        }
    }

    private static void solveProblems() {
        
        // SORTING PROBLEMS
        // ===========================================
        //  --> BubbleSort
        //  --> QuickSort
        
        // PROBLEM 1
        int[] arr30_int = ArrayUtils.getRandomIntArray(0, 100, 30);
        
        var bubbleRun   = TimeUtils.measure(() -> BubbleSort.sortedCopy(arr30_int));
        var quickRun    = TimeUtils.measure(() -> QuickSort.sortedCopy(arr30_int));

        System.out.print(
            "PROBLEM 1\n"+
            "-------------------------------------------------------------------------------\n"+
            "Random Array:\n"+
             Arrays.toString(arr30_int) +"\n\n"+

            "BubbleSort: "+ TimeUtils.getStrTime(bubbleRun.nanos()) +"\n"+
             Arrays.toString(bubbleRun.value()) +"\n\n"+

            "QuickSort: "+ TimeUtils.getStrTime(quickRun.nanos()) +"\n"+
             Arrays.toString(quickRun.value())  +"\n\n"
        );

        // PROBLEM 2
        int[] arr3000_int = ArrayUtils.getRandomIntArray(0, 5000, 3000);

        bubbleRun   = TimeUtils.measure(() -> BubbleSort.sortedCopy(arr3000_int));
        quickRun    = TimeUtils.measure(() -> QuickSort.sortedCopy(arr3000_int));
        
        Arrays.sort(arr3000_int);
        String bubbleResult = ( Arrays.equals(arr3000_int, bubbleRun.value()) ) ? "Success" : "Failure";
        String quickResult  = ( Arrays.equals(arr3000_int, quickRun.value()) )  ? "Success" : "Failure";

        System.out.print(
            "PROBLEM 2\n"+
            "-------------------------------------------------------------------------------\n"+
            "BubbleSort: "+ TimeUtils.getStrTime(bubbleRun.nanos()) +" @ "+ bubbleResult +"\n"+
            "QuickSort: "+ TimeUtils.getStrTime(quickRun.nanos()) +" @ "+ quickResult +"\n\n"
        );

        // SEARCHING PROBLEMS
        // ===========================================
        //  --> LinearSearch
        //  --> BinarySearch
        //  --> RadixSort

        // PROBLEM 3, 4
        int[] arr3000_int_sorted = quickRun.value();
        
        final int value = readInt(0, 5000);

        var linearRun   = TimeUtils.measure(() -> LinearSearch.find(arr3000_int_sorted, value));
        var binaryRun   = TimeUtils.measure(() -> BinarySearch.find(arr3000_int_sorted, value));

        System.out.print(
            "\nPROBLEM 3, 4\n"+
            "-------------------------------------------------------------------------------\n"+
            "Value: "+ value +"\n"+
            "Linear: "+ TimeUtils.getStrTime(linearRun.nanos()) +" @ index ["+ linearRun.value() +"]\n"+
            "Binary: "+ TimeUtils.getStrTime(binaryRun.nanos()) +" @ index ["+ binaryRun.value() +"]\n\n"
        );

        // PROBLEM 5
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String[] arr50_str = ArrayUtils.getRandomStringArray(5, 20, 50, alphabet);

        var radixRun = TimeUtils.measure(() -> RadixSort.sortedCopy(arr50_str));

        System.out.print(
            "PROBLEM 5\n"+
            "-------------------------------------------------------------------------------\n"+
            "Random Array:\n"+
             Arrays.toString(ArrayUtils.head(arr50_str, 10)) +"\n\n"+

            "RadixSort: "+ TimeUtils.getStrTime(radixRun.nanos()) +"\n"+
             Arrays.toString(ArrayUtils.head(radixRun.value(), 10)) +"\n\n"
        );
        
        System.out.print("[press enter to exit]");
        userin.nextLine();
    }

    private static int readInt(int min, int max) {
        while (true) {
            System.out.print("Enter an integer from "+ min +"-"+ max +": ");
            String strValue = userin.nextLine();

            try {
                int value = Integer.parseInt(strValue.trim());
                if (value >= min && value <= max) return value;
                System.out.print("----- integer out of bounds -----\n\n");
            } catch (NumberFormatException e) {
                System.out.print("----- invalid integer -----\n\n");
            }
        }
    }

}

// EOF
