import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProspectParser {
    public List<Prospect> parseProspects(String filename) {
        List<Prospect> prospects = new ArrayList<>();
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            // Skip the header line
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            // Read each line of the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = parseCSVLine(line); // Parse Comma-separated values line into parts
                if (parts.length == 4) {
                    // Extract and trim each part
                    String name = parts[0].trim();
                    //System.out.println(name);
                    double loanAmount = Double.parseDouble(parts[1].trim());
                    //System.out.println(loanAmount);
                    float interestRate = Float.parseFloat(parts[2].trim());
                    //System.out.println(interestRate);
                    int years = Integer.parseInt(parts[3].trim());
                    //System.out.println(years);

                    // Create a Prospect object and add it to the list
                    prospects.add(new Prospect(name, loanAmount, interestRate, years));
                }
            }
            scanner.close(); // Close the scanner
        } catch (FileNotFoundException e) {
            e.printStackTrace(); // Print error stack trace if file not found
        }
        return prospects; // Return the list of prospects
    }

    // Method to parse a CSV line into an array of strings
    private String[] parseCSVLine(String line) {
        List<String> parts = new ArrayList<>();
        StringBuilder currentPart = new StringBuilder();
        boolean inQuotes = false;

        // Iterate through each character in the line
        for (char c : line.toCharArray()) {
            if (c == '"') {
                inQuotes = !inQuotes; // Toggle inQuotes flag when encountering a double quote
            } else if (c == ',' && !inQuotes) {
                parts.add(currentPart.toString().replace(",", " ")); // Add part to list, replacing commas with spaces if not within quotes
                currentPart.setLength(0); // Clear the StringBuilder for the next part
            } else {
                currentPart.append(c); // Add character to the current part
            }
        }

        // Add the last part after the loop
        parts.add(currentPart.toString().replace(",", " ")); // Add last part to list, replacing commas with spaces if not within quotes


        return parts.toArray(new String[0]); // Convert list to array and return
    }
}