package Q1.AdventofCode;

import java.io.*;
import java.nio.file.*;
import java.util.regex.*;

public class MullItOver {
    public static void main(String[] args) throws IOException {

        String memory = new String(Files.readAllBytes(Paths.get("src/Q1/AdventofCode/day3.dat")));

        // Strict regex patterns
        String mulPattern   = "mul\\(\\s*(\\d{1,3})\\s*,\\s*(\\d{1,3})\\s*\\)";
        String doPattern    = "do\\(\\)";
        String dontPattern  = "don't\\(\\)";
        String combinedPattern = "(?i)" + mulPattern + "|" + doPattern + "|" + dontPattern;

        Pattern pattern = Pattern.compile(combinedPattern);
        Matcher matcher = pattern.matcher(memory);

        boolean enabled = true;
        long total = 0;

        while (matcher.find()) {
            String match = matcher.group();

            // Check for do() / don't()
            if (match.equalsIgnoreCase("do()")) {
                enabled = true;
            } else if (match.equalsIgnoreCase("don't()")) {
                enabled = false;
            }
            // Check for strict mul
            else if (matcher.group(1) != null && matcher.group(2) != null) {
                if (enabled) {
                    int x = Integer.parseInt(matcher.group(1));
                    int y = Integer.parseInt(matcher.group(2));
                    total += (long) x * y;
                }
            }
            // All other sequences (invalid mul or random chars) are ignored
        }

        System.out.println("Sum of enabled multiplications: " + total);
    }
}
                            
