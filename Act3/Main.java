package m3.act3;


import java.util.*;

public class Main {

    private static final Scanner scan = new Scanner(System.in);
    // LinkedHashMap to keep insertion order when printing
    private static final Map<String, Integer> products = new LinkedHashMap<>();

    public static void main(String[] args) {
        seedInitialProducts();

        while (true) {
            printMenu();
            int option = readInt("> ", 1, 5);

            switch (option) {
                case 1 -> searchProduct();
                case 2 -> addProduct();
                case 3 -> printAllProducts();
                case 4 -> findCheapestProduct();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    /* ------------------------- Menu ------------------------- */

    private static void printMenu() {
        System.out.println();
        System.out.println("Select an option:");
        System.out.println("1. Search a product");
        System.out.println("2. Add a product");
        System.out.println("3. Print all products and prices");
        System.out.println("4. Find the cheapest product");
        System.out.println("5. Exit");
    }

    /* ---------------------- Operations ---------------------- */

    private static void searchProduct() {
        String name = readNonEmpty("Enter product name to search: ");

        // Find actual key ignoring case
        String actualKey = findKeyIgnoreCase(name);
        if (actualKey != null) {
            int price = products.get(actualKey);
            System.out.println("Product found! Price: " + price);
        } else {
            System.out.println("Product not found!");
        }
    }

    private static void addProduct() {
        String name = readNonEmpty("Enter product name to add: ");
        int price = readPositiveInt("Enter price: ");

        // If a product exists with same name (case-insensitive), overwrite its price
        String existing = findKeyIgnoreCase(name);
        if (existing != null) {
            products.put(existing, price);
            System.out.println("Product updated: " + existing);
        } else {
            products.put(name, price);
            System.out.println("Product added: " + name);
        }
    }

    private static void printAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        System.out.println("All products and prices:");
        for (Map.Entry<String, Integer> e : products.entrySet()) {
            System.out.println(e.getKey() + " - " + e.getValue());
        }
        System.out.println("Total products: " + products.size());
    }

    private static void findCheapestProduct() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        int minPrice = Integer.MAX_VALUE;
        List<String> cheapest = new ArrayList<>();

        for (Map.Entry<String, Integer> e : products.entrySet()) {
            int p = e.getValue();
            if (p < minPrice) {
                minPrice = p;
                cheapest.clear();
                cheapest.add(e.getKey());
            } else if (p == minPrice) {
                cheapest.add(e.getKey());
            }
        }

        System.out.println("Cheapest product: " + cheapest.get(0) + " - " + minPrice);
        // If multiple products share the same cheapest price, list the rest
        for (int i = 1; i < cheapest.size(); i++) {
            System.out.println("Also cheapest: " + cheapest.get(i) + " - " + minPrice);
        }
    }

    /* ------------------------ Helpers ------------------------ */

    private static void seedInitialProducts() {
        products.put("Laptop", 20000);
        products.put("Monitor", 7000);
        products.put("Mouse", 500);
        products.put("Keyboard", 1000);
        products.put("Printer", 6000);
    }

    private static String readNonEmpty(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = scan.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Input cannot be empty. Try again.");
        }
    }

    private static int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String s = scan.nextLine().trim();
            try {
                int v = Integer.parseInt(s);
                if (v >= min && v <= max) return v;
                System.out.printf("Please enter a number between %d and %d.%n", min, max);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    private static int readPositiveInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = scan.nextLine().trim();
            try {
                int v = Integer.parseInt(s);
                if (v >= 0) return v;
                System.out.println("Price cannot be negative.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid price. Enter an integer (e.g., 200).");
            }
        }
    }

    /**
     * Finds the actual key in the map matching the provided name, ignoring case.
     * Returns null if not found.
     */
    private static String findKeyIgnoreCase(String name) {
        for (String key : products.keySet()) {
            if (key.equalsIgnoreCase(name)) return key;
        }
        return null;
    }
}
