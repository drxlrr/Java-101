package m3.act2;


import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Main {

    static class Product {
        private final String name;
        private final double price;

        public Product(String name, double price) {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Product name cannot be empty.");
            }
            this.name = name.trim();
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Product)) return false;
            Product product = (Product) o;
            // Case-insensitive name equality
            return name.equalsIgnoreCase(product.name);
        }

        @Override
        public int hashCode() {
            // Case-insensitive hash
            return Objects.hash(name.toLowerCase());
        }

        @Override
        public String toString() {
            return String.format("%s (₱%.2f)", name, price);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Product> products = new HashSet<>();

        // 1) Add 5 initial data
        products.add(new Product("Laptop", 39999.00));
        products.add(new Product("Smartphone", 24999.00));
        products.add(new Product("Headphones", 1999.00));
        products.add(new Product("Keyboard", 1499.00));
        products.add(new Product("Mouse", 899.00));

        while (true) {
            printMenu();
            System.out.print("Enter choice (1-4): ");
            String choiceInput = scanner.nextLine().trim();

            int choice;
            try {
                choice = Integer.parseInt(choiceInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number from 1 to 4.\n");
                continue;
            }

            switch (choice) {
                case 1:
                    // Search a product
                    System.out.print("Enter product name to search: ");
                    String searchName = scanner.nextLine().trim();
                    if (searchName.isEmpty()) {
                        System.out.println("Product name cannot be empty.\n");
                        break;
                    }
                    Product found = findByName(products, searchName);
                    if (found != null) {
                        System.out.println("Found: " + found + "\n");
                    } else {
                        System.out.println("Product not found.\n");
                    }
                    break;

                case 2:
                    // Add a product
                    System.out.print("Enter product name to add: ");
                    String name = scanner.nextLine().trim();
                    if (name.isEmpty()) {
                        System.out.println("Product name cannot be empty.\n");
                        break;
                    }
                    System.out.print("Enter price (e.g., 1999.50): ");
                    String priceInput = scanner.nextLine().trim();
                    double price;
                    try {
                        price = Double.parseDouble(priceInput);
                        if (price < 0) {
                            System.out.println("Price cannot be negative.\n");
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid price format.\n");
                        break;
                    }

                    Product newProduct = new Product(name, price);
                    boolean added = products.add(newProduct);
                    if (added) {
                        System.out.println("Product added: " + newProduct + "\n");
                    } else {
                        System.out.println("Product already exists (by name). Not added.\n");
                    }
                    break;

                case 3:
                    // Print all products and count
                    System.out.println("\n=== Products ===");
                    if (products.isEmpty()) {
                        System.out.println("(none)");
                    } else {
                        // Print in arbitrary set order
                        for (Product p : products) {
                            System.out.println("• " + p);
                        }
                    }
                    System.out.println("Total count: " + products.size() + "\n");
                    break;

                case 4:
                    // Exit
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please select 1-4.\n");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Select an option:");
        System.out.println("1. Search a product");
        System.out.println("2. Add a product");
        System.out.println("3. Print all products and count");
        System.out.println("4. Exit");
    }

    private static Product findByName(Set<Product> products, String name) {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }
}
