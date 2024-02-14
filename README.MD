# Mortgage Plan Calculator

## Description

This project implements a mortgage plan calculator that reads prospect information from a file and calculates their monthly payments.

## Features

- Calculates monthly payments based on loan amount, interest rate, and loan term.
- Implements a custom power function for exponentiation (required due to restriction on using `java.math`).
- Displays detailed information for each prospect in a user-friendly format.

## Getting Started

1. Make sure you have Maven installed and configured on your system.
2. Clone or download the project repository.
3. Open a terminal window and navigate to the project directory.
4. Run the following command to build the project and execute the main program:

```bash
mvn clean package
```

This will compile the code, read prospect information from `prospects.txt`, calculate monthly payments, and display the details for each prospect.

## File Format

The `prospects.txt` file should contain information about each prospect in the following format:


`Name,LoanAmount,InterestRate,Years`


Each line represents a single prospect, with values separated by commas.

## Building and Testing

To build the project and run tests, use the following command:

```bash
mvn clean test
```

This will compile the code, run unit tests, and report the results.

## Dependencies

This project uses the following dependencies:

- JUnit Jupiter (for unit testing)

## Additional Notes

- You can modify the `prospects.txt` file to add or remove prospect information.
- The project uses a custom power function instead of `java.math` due to a requirement not to use external libraries.
