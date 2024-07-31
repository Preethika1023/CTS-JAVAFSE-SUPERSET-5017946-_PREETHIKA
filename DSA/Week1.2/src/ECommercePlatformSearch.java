public class ECommercePlatformSearch {
    public static void main(String[] args) {
        Product[] products = {
                new Product("001", "Laptop", "Electronics"),
                new Product("002", "Smartphone", "Electronics"),
                new Product("003", "Tablet", "Electronics"),
                new Product("004", "Headphones", "Accessories"),
                new Product("005", "Charger", "Accessories"),
                new Product("006", "Camera", "Electronics"),
                new Product("007", "Monitor", "Electronics"),
                new Product("008", "Keyboard", "Accessories"),
                new Product("009", "Mouse", "Accessories"),
                new Product("010", "Printer", "Electronics")
        };

        String searchTerm = "Camera";


        Product linearResult = LinearSearch.linearSearch(products, searchTerm);
        if (linearResult != null) {
            System.out.println("Linear Search: Found " + linearResult.getProductName() + " in " + linearResult.getCategory() + " category.");
        } else {
            System.out.println("Linear Search: Product not found.");
        }


        Product binaryResult = BinarySearch.binarySearch(products, searchTerm);
        if (binaryResult != null) {
            System.out.println("Binary Search: Found " + binaryResult.getProductName() + " in " + binaryResult.getCategory() + " category.");
        } else {
            System.out.println("Binary Search: Product not found.");
        }
    }
}

