
import java.io.*;
import java.util.*;

public class Pass1 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("input.asm"));
            Map<String, Integer> symbolTable = new HashMap<>();
            int lineCount = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                lineCount++;

                if (!line.isEmpty() && line.contains(" ")) {
                    String label = line.split("\\s+")[0];
                    if (!label.isEmpty()) {
                        symbolTable.put(label, lineCount);
                    }
                }
            }
            scanner.close();

            // Print the symbol table
            symbolTable.forEach((key, value) -> System.out.println(key + ": " + value));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
