package m4.act5;

class InvalidAccountNumberException extends Exception {

	private static final long serialVersionUID = 1L;

 public InvalidAccountNumberException(String message) {
     super(message);
 }
}

class InvalidAccountFormatException extends RuntimeException {

	private static final long serialVersionUID = 1L;

 public InvalidAccountFormatException(String message) {
     super(message);
 }
}

public class Main {

 public static void validateAccountNumber(String accountNumber)
         throws InvalidAccountNumberException {


     if (accountNumber == null) {
         throw new NullPointerException("Account number cannot be null");
     }

     for (char ch : accountNumber.toCharArray()) {
         if (!Character.isDigit(ch)) {
             throw new InvalidAccountFormatException("Account number must contain only digits");
         }
     }

     if (accountNumber.length() != 10) {
         throw new InvalidAccountNumberException("Account number must be exactly 10 digits");
     }
 }

 private static void testValidation(String testName, String accountNumber) {
     System.out.println(testName + ": " + (accountNumber == null ? "null" : accountNumber));
     try {
         validateAccountNumber(accountNumber);
         System.out.println("Valid account number: " + accountNumber);
     } catch (InvalidAccountNumberException e) {
         System.out.println("Error: " + e.getMessage());
     } catch (InvalidAccountFormatException e) {

         System.out.println("Warning: " + e.getMessage());
     } catch (NullPointerException e) {
         System.out.println("Warning: " + e.getMessage());
     }
     System.out.println();
 }

 public static void main(String[] args) {
     System.out.println("== Account Number Validation Test ==");

     testValidation("Test 1: Valid account (1234567890)", "1234567890");

     testValidation("Test 2: Too short (123)", "123");

     testValidation("Test 3: Contains letters (123A456890)", "123A456890");

     testValidation("Test 4: Contains space (1234 567890)", "1234 567890");

     testValidation("Test 5: Null value", null);
 }
}

