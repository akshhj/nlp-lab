import java.io.*;
import java.util.*;
import java.util.regex.*;

class VariableInfo {
    String type;

    public VariableInfo(String type) {
        this.type = type;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter path to the source code file: ");
        String filePath = scanner.nextLine();

        Map<String, VariableInfo> symbolTable = new LinkedHashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            String regex = "\\b(int|float|double|char)\\s+([a-zA-Z_][a-zA-Z0-9_]*)\\s*;";
            Pattern pattern = Pattern.compile(regex);

            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    String type = matcher.group(1);
                    String name = matcher.group(2);
                    symbolTable.put(name, new VariableInfo(type));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n+----------------+--------------+");
        System.out.println("| Variable Name  | Data Type    |");
        System.out.println("+----------------+--------------+");
        for (Map.Entry<String, VariableInfo> entry : symbolTable.entrySet()) {
            System.out.printf("| %-14s | %-12s |\n", entry.getKey(), entry.getValue().type);
        }
        System.out.println("+----------------+--------------+");
    }
}
