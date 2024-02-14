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
4. Run the following command to build the project:

```bash
mvn clean package
```

This will compile the code, read prospect information from `prospects.txt`, calculate monthly payments, and display the details for each prospect.

## Testing

Run tests, use the following command:

```bash
mvn clean test
```

This will compile the code, run unit tests, and report the results.

## Docker setup and usage

#### Building the Docker image:

Ensure that Docker is installed and configured on your system.

Navigate to the root directory of the project where the Dockerfile is located.

Execute the following command to build the Docker image:

```bash
docker build -t mortage-plan .
```

This command will build a Docker image named mortgage-plan based on the specifications in the Dockerfile.

#### Running the Docker Container:

Once the Docker image is built successfully, you can run it using the following command:

```bash
docker run mortage-plan
```
This command will start a Docker container based on the mortgage-plan image, executing
the mortgage plan calculator application within the container.

## Running in IDE

In IDE build and Run `MortagePlan.java` located in: `src/main/java/MortagePlan.java`

## Dependencies

This project uses the following dependencies:

- JUnit Jupiter (for unit testing)

## File Format

The `prospects.txt` file should contain information about each prospect in the following format:

`Name,LoanAmount,InterestRate,Years`

Each line represents a single prospect, with values separated by commas.

## Additional Notes

- You can modify the `prospects.txt` file to add or remove prospect information.
- The project uses a custom power function instead of `java.math` due to a requirement not to use external libraries.
