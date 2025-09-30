package Q1.AdventofCode;


import java.io.*;
import java.nio.file.*;
import java.util.*;

public class RedNosedReports {
    public static void main(String[] args) {
        String filename = "src/Q1/AdventofCode/day2.dat";

        try {
            List<String> lines = Files.readAllLines(Paths.get(filename));
            int safeCount = 0;

            for (String line : lines) {
                int[] levels = Arrays.stream(line.trim().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                if (isSafeWithDampener(levels)) {
                    safeCount++;
                }
            }

            System.out.println("Number of safe reports with Problem Dampener: " + safeCount);

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    // Checks if a report is safe according to Part 1 rules
    private static boolean isSafe(int[] levels) {
        if (levels.length < 2) return true;

        boolean increasing = levels[1] > levels[0];
        for (int i = 1; i < levels.length; i++) {
            int diff = levels[i] - levels[i - 1];
            if (diff == 0 || Math.abs(diff) > 3) return false;

            if (increasing && diff < 0) return false;
            if (!increasing && diff > 0) return false;
        }
        return true;
    }

    // Checks if a report can be safe by removing at most one level
    private static boolean isSafeWithDampener(int[] levels) {
        if (isSafe(levels)) return true;

        // Try removing each level one at a time
        for (int i = 0; i < levels.length; i++) {
            int[] temp = new int[levels.length - 1];
            for (int j = 0, k = 0; j < levels.length; j++) {
                if (j != i) temp[k++] = levels[j];
            }
            if (isSafe(temp)) return true;
        }
        return false;
    }
}
