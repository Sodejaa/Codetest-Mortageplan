import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;

public class MortgagePlanTest {

    @Test
    void testPowerFunction() {
        // Test with positive exponent
        assertEquals(8, MortagePlan.power(2, 3));

        // Test with zero exponent
        assertEquals(1, MortagePlan.power(5, 0));

        // Test with negative exponent
        assertEquals(0.25, MortagePlan.power(2, -2));
    }

    @Test
    void testCalculateMonthlyPayments() {

        MortagePlan mortagePlan = new MortagePlan("prospects.txt");

        List<Prospect> prospects = mortagePlan.prospects;
        // Create a sample prospect
        Prospect prospect = new Prospect("Test Prospect", 100000, 5.0f, 20);

        // Calculate monthly payments for the prospect
        double monthlyPayments = MortagePlan.calculateMonthlyPayments(prospect);

        // Expected monthly payment calculated using external calculation
        double expectedMonthlyPayment = 659.96;

        // Check if the calculated monthly payment matches the expected value. 0.01 tolerance added because cannot be exactly represented as a float or double due to the limitations of binary floating-point representation.
        assertEquals(expectedMonthlyPayment, monthlyPayments, 0.01);
    }

    @Test
    public void testPrintProspectDetails() {
        // Create test data
        Prospect prospect = new Prospect("Test Prospect", 100000, 5.0f, 20);
        double expectedMonthlyPayment = 659.96; // Replace with actual calculation if available

        // Capture original output stream
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Call the method
        MortagePlan.printProspectDetails(prospect, 0);

        // Restore original output stream
        System.setOut(originalOut);

        // Assert output matches expectations
        String actualOutput = outContent.toString().trim(); // Trim added to remove any leading or trailing whitespace and same for the expectedOutput
        String expectedOutput = String.format(
                "****************************************************************************************************\n" +
                        "Prospect 1: Test Prospect wants to borrow 100000.0 € for a period of 20 years and pay 659.96 € each month\n" +
                        "****************************************************************************************************\n").trim();

        assertEquals(expectedOutput, actualOutput);
    }
}
