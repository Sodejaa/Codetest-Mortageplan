import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProspectParserTest {

    @Test
    public void testParseProspects_ValidFile() throws IOException {
        // Create a temporary file with valid prospect data
        File tempFile = File.createTempFile("testProspects", ".txt");
        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write("Name,LoanAmount,InterestRate,Years\n");
            writer.write("Test Prospect1,10000,5.5,3\n");
            writer.write("Test Prospect2,15000,4.0,2\n");
        }

        // Parse prospects from the temporary file
        ProspectParser prospectParser = new ProspectParser();
        List<Prospect> prospects = prospectParser.parseProspects(tempFile.getAbsolutePath());

        // Verify the number of prospects parsed
        assertEquals(2, prospects.size());

        // Verify the details of the first prospect
        Prospect firstProspect = prospects.get(0);
        assertEquals("Test Prospect1", firstProspect.getName());
        assertEquals(10000.0, firstProspect.getLoanAmount());
        assertEquals(5.5f, firstProspect.getInterestRate());
        assertEquals(3, firstProspect.getYears());

        // Verify the details of the second prospect
        Prospect secondProspect = prospects.get(1);
        assertEquals("Test Prospect2", secondProspect.getName());
        assertEquals(15000.0, secondProspect.getLoanAmount());
        assertEquals(4.0f, secondProspect.getInterestRate());
        assertEquals(2, secondProspect.getYears());
    }

    @Test
    public void testParseProspects_EmptyFile() throws IOException {
        // Create a temporary empty file
        File tempFile = File.createTempFile("emptyTestProspects", ".txt");

        // Parse prospects from the empty file
        ProspectParser prospectParser = new ProspectParser();
        List<Prospect> prospects = prospectParser.parseProspects(tempFile.getAbsolutePath());

        // Verify that no prospects are parsed
        assertTrue(prospects.isEmpty());
    }

    @Test
    public void testParseProspects_InvalidFile() {
        // Attempt to parse prospects from a non-existent file
        ProspectParser prospectParser = new ProspectParser();
        List<Prospect> prospects = prospectParser.parseProspects("nonexistent_file.txt");

        // Verify that no prospects are parsed
        assertTrue(prospects.isEmpty());
    }

    @Test
    public void testParseTXTLine_Simple() {
        ProspectParser parser = new ProspectParser();
        String line = "John,Doe,10000,5.5";
        String[] expected = {"John", "Doe", "10000", "5.5"};
        assertArrayEquals(expected, parser.parseTXTLine(line));
    }

    @Test
    public void testParseTXTLine_WithQuotes() {
        ProspectParser parser = new ProspectParser();
        String line = "\"John\",\"Doe\",\"10000\",\"5.5\"";
        String[] expected = {"John", "Doe", "10000", "5.5"};
        assertArrayEquals(expected, parser.parseTXTLine(line));
    }

}
