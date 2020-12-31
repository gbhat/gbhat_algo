package algo;

import java.util.Arrays;

public class KnuthMorrisPratt {
    public static void main(String[] args) {
        String string = "ABCABAB ABABABAABAC";
        String pattern = "ABABAABA";

        int[] lookupTable = buildLookupTable(pattern);
        System.out.println("Lookup Table: " + Arrays.toString(lookupTable));

        stringSearch(string, pattern, lookupTable);
    }

    // Method to build lookup table using pattern
    private static int[] buildLookupTable(String pattern) {
        int[] lookupTable = new int[pattern.length()];
        Arrays.setAll(lookupTable, x -> 0);
        int idx = 0;
        int j = 1;
        while (j < pattern.length()) {
            if (pattern.charAt(idx) == pattern.charAt(j)) {
                idx++;
                lookupTable[j] = idx;
                j++;
            } else if (idx > 0) {
                idx = lookupTable[idx - 1];
            } else {
                j++;
            }
        }
        return lookupTable;
    }

    // KMP string search method
    private static void stringSearch(String string, String pattern, int[] lookupTable) {
        int i = 0, j = 0;
        while(i < string.length() && j < pattern.length()) {
            if (string.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else if (j != 0) {
                j = lookupTable[j - 1];
            } else {
                i++;
            }
        }
        if (j == pattern.length()) {
            System.out.println("Found pattern at index: " + (i - j));
        } else {
            System.out.println("Could not find pattern");
        }
    }
}
