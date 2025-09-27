package Q1.AdventofCode;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class PrintQueue {
    public static void main(String[] args) throws IOException {
        String filename = "src/Q1/AdventofCode/day5.dat";
        List<String> lines = Files.readAllLines(Paths.get(filename));

        Map<Integer, Set<Integer>> rules = new HashMap<>();
        List<String> updates = new ArrayList<>();

        // Separate rules and updates
        boolean readingRules = true;
        for (String line : lines) {
            line = line.trim();
            if (line.isEmpty()) continue;
            if (line.contains("|") && readingRules) {
                String[] parts = line.split("\\|");
                int before = Integer.parseInt(parts[0]);
                int after = Integer.parseInt(parts[1]);
                rules.computeIfAbsent(before, k -> new HashSet<>()).add(after);
            } else {
                readingRules = false;
                updates.add(line);
            }
        }

        long middleSum = 0;

        for (String updateLine : updates) {
            String[] parts = updateLine.split(",");
            int n = parts.length;
            int[] update = new int[n];
            Map<Integer, Integer> indexMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                update[i] = Integer.parseInt(parts[i].trim());
                indexMap.put(update[i], i);
            }

            // Check if update is valid
            boolean valid = true;
            for (int x : update) {
                if (!rules.containsKey(x)) continue;
                for (int y : rules.get(x)) {
                    if (!indexMap.containsKey(y)) continue;
                    if (indexMap.get(x) >= indexMap.get(y)) {
                        valid = false;
                        break;
                    }
                }
                if (!valid) break;
            }

            if (!valid) {
                // Incorrect update → fix it using topological sort
                List<Integer> sorted = topologicalSort(update, rules);
                int middle = sorted.get((sorted.size() - 1) / 2);
                middleSum += middle;
            }
        }

        System.out.println("Sum of middle pages after fixing incorrect updates: " + middleSum);
    }

    private static List<Integer> topologicalSort(int[] update, Map<Integer, Set<Integer>> rules) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();

        // Initialize
        for (int page : update) {
            adj.put(page, new HashSet<>());
            indegree.put(page, 0);
        }

        // Add edges for rules where both pages are in this update
        for (int page : update) {
            if (!rules.containsKey(page)) continue;
            for (int after : rules.get(page)) {
                if (!adj.containsKey(after)) continue; // skip pages not in this update
                adj.get(page).add(after);
                indegree.put(after, indegree.get(after) + 1);
            }
        }

        // Kahn's algorithm
        Queue<Integer> queue = new LinkedList<>();
        for (int page : update) {
            if (indegree.get(page) == 0) queue.add(page);
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);
            for (int neighbor : adj.get(current)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) queue.add(neighbor);
            }
        }

        return result;
    }
}
