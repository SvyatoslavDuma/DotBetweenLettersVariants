package org.example;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.IntStream;

public class SecondSolution {
    public static void secondSolution(String str) {
        String filePath = "output.txt";
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
            generateAndWriteCombinations(str, writer);
            System.out.println("Results have been written to " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    private static void generateAndWriteCombinations(String str, BufferedWriter writer) throws IOException {
        int n = str.length();
        int combinationsCount = (1 << (n - 1));

        IntStream.range(0, combinationsCount).parallel().forEach(i -> {

            try {
                String resultString = getResultString(i, str);
                synchronized (writer) {
                    writer.write(resultString);
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private static String getResultString(int combination, String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length() - 1; i++) {
            sb.append(str.charAt(i));
            if ((combination & (1 << i)) != 0) {
                sb.append('.');
            }
        }
        sb.append(str.charAt(str.length() - 1));

        return sb.toString();
    }
}
