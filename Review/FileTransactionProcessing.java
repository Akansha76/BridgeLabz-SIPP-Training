import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

// Custom Exception
class InvalidTransactionException extends Exception {
    public InvalidTransactionException(String message) {
        super(message);
    }
}

public class FileTransactionProcessing {
    public static void main(String[] args) {
        Path filePath = Path.of("JavaPseudoCode.txt"); // file in project folder

        try {
            // Read and process lines
            List<Integer> transactions = Files.lines(filePath)
                    .map(line -> {
                        try {
                            return Integer.parseInt(line.trim());
                        } catch (NumberFormatException e) {
                            throw new RuntimeException(
                                    new InvalidTransactionException("Invalid transaction data: " + line));
                        }
                    })
                    .collect(Collectors.toList());

            int sum = transactions.stream().mapToInt(Integer::intValue).sum();
            int max = transactions.stream().mapToInt(Integer::intValue).max().orElse(0);

            System.out.println("Sum of Transactions: " + sum);
            System.out.println("Max Transaction: " + max);

        } catch (RuntimeException e) {
            if (e.getCause() instanceof InvalidTransactionException) {
                System.out.println(e.getCause().getMessage());
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

