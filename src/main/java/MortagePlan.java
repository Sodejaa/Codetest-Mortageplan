import java.util.List;

public class MortagePlan {
    List<Prospect> prospects; //List to store all prospects

    // Constructor to initialize MortgagePlan with prospects from a file
    public MortagePlan(String filename) {
        ProspectParser parser = new ProspectParser();
        prospects = parser.parseProspects(filename);
    }

    // Custom power function to calculate exponentiation because java.Math was not allowed to use
    static double power(double base, int exponent) {
        if (exponent == 0) {
            return 1; // Any number to the power of 0 is 1
        } else if (exponent > 0) {
            // Calculate power using repeated multiplication for positive exponent
            double result = 1;
            for (int i = 0; i < exponent; i++) {
                result *= base;
            }
            return result;
        } else {
            // For negative exponent, calculate the reciprocal of the result with positive exponent
            return 1 / power(base, -exponent);
        }
    }

    // Function to calculate monthly payments for a given prospect
    public static double calculateMonthlyPayments(Prospect prospect) {
        int months = 12;
        // Extract necessary details from the prospect
        double totalLoan = prospect.getLoanAmount();
        int years = prospect.getYears();
        float interest = prospect.getInterestRate() / 100;
        int payments = years * months;

        // Calculate monthly interest rate and power factor
        double monthlyInterest = interest / months;
        double powFactor = power(1 + monthlyInterest, payments);

        // Calculate monthly payments using the formula for an annuity
        return totalLoan * (monthlyInterest * powFactor) / (powFactor - 1);
    }

    // Method to print details of a prospect
    static void printProspectDetails(Prospect prospect, int index) {
        // Calculate monthly payments for the prospect
        double monthlyPayments = calculateMonthlyPayments(prospect);

        // Print details of the prospect
        System.out.println("****************************************************************************************************\n" +
                "Prospect " + (index + 1) + ": " + prospect.getName() +
                " wants to borrow " + prospect.getLoanAmount() + " € " +
                "for a period of " + prospect.getYears() + " years and pay " +
                String.format("%.2f", monthlyPayments) + " € each month\n" +
                "****************************************************************************************************");
    }

    // Method to display details of all prospect
    public void displayProspects() {
        for (int i = 0; i < prospects.size(); i++) {
            // Print details of each prospect
            printProspectDetails(prospects.get(i), i);
        }
    }

    // Main method to execute the program
    public static void main(String[] args) {
        // Create a new MortagePlan object with prospects from a file
        MortagePlan mortagePlan = new MortagePlan("prospects.txt");
        // Display details of all prospects
        mortagePlan.displayProspects();
    }
}
