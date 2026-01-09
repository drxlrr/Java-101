package m4.act3;


public class Main {

    static class ATMTransaction {
        public void checkBalance(String accountNumber, double balance) {
            try {
                System.out.println("Processing balance inquiry...");
                Integer.parseInt(accountNumber);
                char accountType = accountNumber.charAt(0);

                String typeName;
                if (accountType == '1') {
                    typeName = "Savings";
                } else if (accountType == '2') {
                    typeName = "Checking";
                } else {
                    typeName = "Unknown";
                }
                System.out.println("Account Type: " + typeName);
                System.out.println("Account Number: " + accountNumber);
                System.out.println("Current Balance: P" + String.format("%.2f", balance));
                System.out.println("Balance inquiry successful!");
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid account number format!");
                System.out.println("Account numbers must be numeric.");
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Error: Account number is empty or invalid!");
            } finally {
                System.out.println("\n============= RECEIPT =============");
                System.out.println("Transaction Date: December 3, 2025");
                System.out.println("Transaction Type: Balance Inquiry");
                System.out.println("ATM Location: Main Branch");
                System.out.println("Thank you for banking with us!");
                System.out.println("===================================\n");
            }
        }
    }

    public static void main(String[] args) {
    	
        ATMTransaction atm = new ATMTransaction();
        System.out.println("=== ATM Balance Check with Receipt ===\n");
        System.out.println("-- Test 1: Valid Savings account --");
        atm.checkBalance("100123456", 15000.00);
        System.out.println("-- Test 2: Valid Checking account --");
        atm.checkBalance("200987654", 25000.00);
        System.out.println("-- Test 3: Invalid format (NumberFormatException) --");
        atm.checkBalance("ABC12345", 15000.00);
        System.out.println("-- Test 4: Empty account (StringIndexOutOfBoundsException) --");
        atm.checkBalance("", 15000.00);
        System.out.println("=== All tests completed! ===");
    }
}

