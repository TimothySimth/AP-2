package Q1.AdventofCode;

import java.io.*;
import java.util.*;

public class CeresSearch {
    static final String TARGET = "MAS";

    public static void main(String[] args) {

        List<String> rowsList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/Q1/AdventofCode/day4.dat"))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) rowsList.add(line.toUpperCase());
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        if (rowsList.isEmpty()) {
            System.out.println("Grid file is empty.");
            return;
        }

        // Validate rectangular grid
        int rows = rowsList.size();
        int cols = rowsList.get(0).length();
        for (String r : rowsList) {
            if (r.length() != cols) {
                System.err.println("All rows must have the same length.");
                return;
            }
        }

        String[] grid = rowsList.toArray(new String[0]);
        List<XMatch> found = new ArrayList<>();

        // Check candidate centers (must have neighbors on both diagonals -> skip borders)
        for (int r = 1; r < rows - 1; r++) {
            for (int c = 1; c < cols - 1; c++) {
                if (grid[r].charAt(c) != 'A') continue; // center must be 'A'

                // NW -> center -> SE
                char nw = grid[r - 1].charAt(c - 1);
                char center = grid[r].charAt(c);
                char se = grid[r + 1].charAt(c + 1);
                String diag1_fwd = "" + nw + center + se; // NW->SE
                String diag1_rev = "" + se + center + nw; // SE->NW

                // NE -> center -> SW
                char ne = grid[r - 1].charAt(c + 1);
                char sw = grid[r + 1].charAt(c - 1);
                String diag2_fwd = "" + ne + center + sw; // NE->SW
                String diag2_rev = "" + sw + center + ne; // SW->NE

                DiagMatch d1 = null, d2 = null;
                if (diag1_fwd.equals(TARGET)) {
                    d1 = new DiagMatch("NW->SE", Arrays.asList(pos(r - 1, c - 1), pos(r, c), pos(r + 1, c + 1)));
                } else if (diag1_rev.equals(TARGET)) {
                    d1 = new DiagMatch("SE->NW", Arrays.asList(pos(r + 1, c + 1), pos(r, c), pos(r - 1, c - 1)));
                }

                if (diag2_fwd.equals(TARGET)) {
                    d2 = new DiagMatch("NE->SW", Arrays.asList(pos(r - 1, c + 1), pos(r, c), pos(r + 1, c - 1)));
                } else if (diag2_rev.equals(TARGET)) {
                    d2 = new DiagMatch("SW->NE", Arrays.asList(pos(r + 1, c - 1), pos(r, c), pos(r - 1, c + 1)));
                }

                if (d1 != null && d2 != null) {
                    found.add(new XMatch(pos(r, c), d1, d2));
                }
            }
        }

        // Output results
        System.out.println("Total X-MAS patterns found: " + found.size() + "\n");
        int i = 1;
        for (XMatch xm : found) {
            System.out.println("X-MAS #" + (i++) + "  center=" + xm.center);
            System.out.println("  diag1: " + xm.d1.orientation + " positions=" + xm.d1.positions);
            System.out.println("  diag2: " + xm.d2.orientation + " positions=" + xm.d2.positions);
            System.out.println();
        }
    }

    // helper to create 1-based Pos from 0-based indices
    static Pos pos(int r0, int c0) { return new Pos(r0 + 1, c0 + 1); }

    // small data classes
    static class Pos {
        final int row, col;
        Pos(int r, int c) { row = r; col = c; }
        public String toString() { return "(" + row + "," + col + ")"; }
    }

    static class DiagMatch {
        final String orientation;
        final List<Pos> positions; // in reading order M -> A -> S
        DiagMatch(String orientation, List<Pos> positions) {
            this.orientation = orientation;
            this.positions = positions;
        }
    }

    static class XMatch {
        final Pos center;
        final DiagMatch d1; // NW-SE diagonal match
        final DiagMatch d2; // NE-SW diagonal match
        XMatch(Pos center, DiagMatch d1, DiagMatch d2) {
            this.center = center; this.d1 = d1; this.d2 = d2;
        }
    }
}
