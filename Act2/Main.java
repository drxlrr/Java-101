package m4.act2;


public class Main {

    static class ATMSystem {
        private final double[] accounts = {10000, 15000, 20000};
        public void processWithdrawal(String accountIndex, String amountInput) {
            try {
                int index = Integer.parseInt(accountIndex);
                double currentBalance = accounts[index];
                double amount = Double.parseDouble(amountInput);
                System.out.println("Current balance: P" + String.format("%.2f", currentBalance));
                System.out.println("Withdrawal: P" + String.format("%.2f", amount));


                if (amount > currentBalance) {
                    System.out.println("Insufficient funds! Cannot withdraw P" + String.format("%.2f", amount));
                } else {

                    double newBalance = currentBalance - amount;
                    System.out.println("New balance: P" + String.format("%.2f", newBalance));
                    System.out.println("Withdrawal successful!");

                    accounts[index] = newBalance;
                }

            } catch (NumberFormatException e) {

                System.out.println("Error: Invalid input!");
                System.out.println("Please enter valid numbers.");
            } catch (ArrayIndexOutOfBoundsException e) {

                System.out.println("Error: Account not found!");
                System.out.println("Invalid account index.");
            } catch (Exception e) {

                System.out.println("Error: Transaction failed!");
            }
        }
    }


    private static void spacer() {
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("=== ATM Withdrawal System ===");

        ATMSystem atm = new ATMSystem();

        spacer();
        System.out.println("--- Test 1: Valid Withdrawal ---");
        System.out.println("Account=1, Amount=5000");
        atm.processWithdrawal("1", "5000");

        spacer();
        System.out.println("--- Test 2: Invalid Account Index ---");
        System.out.println("Account=abc, Amount=5000");
        atm.processWithdrawal("abc", "5000");


        spacer();
        System.out.println("--- Test 3: Account Not Found ---");
        System.out.println("Account=10, Amount=5000");
        atm.processWithdrawal("10", "5000");

        spacer();
        System.out.println("--- Test 4: Insufficient Funds ---");
        System.out.println("Account=1, Amount=20000");
        atm.processWithdrawal("1", "20000");

        spacer();
        System.out.println("=== All tests completed! ===");
    }
}
