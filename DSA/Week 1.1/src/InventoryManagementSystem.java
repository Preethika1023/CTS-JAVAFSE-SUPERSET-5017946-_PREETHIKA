import java.util.HashMap;
import java.util.Map;

public class InventoryManagementSystem {
    private Map<String, Product> inventory;

    public InventoryManagementSystem() {
        this.inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    public void updateProduct(String productId, Product updatedProduct) {
        if (inventory.containsKey(productId)) {
            inventory.put(productId, updatedProduct);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(String productId) {
        inventory.remove(productId);
    }

    public Product getProduct(String productId) {
        return inventory.get(productId);
    }

    public void printInventory() {
        for (Product product : inventory.values()) {
            System.out.println("ID: " + product.getProductId() +
                    ", Name: " + product.getProductName() +
                    ", Quantity: " + product.getQuantity() +
                    ", Price: " + product.getPrice());
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();

        Product p1 = new Product("101", "Laptop", 10, 999.99);
        Product p2 = new Product("102", "Smartphone", 20, 499.99);

        ims.addProduct(p1);
        ims.addProduct(p2);

        System.out.println("Inventory after adding products:");
        ims.printInventory();

        p2.setQuantity(15);
        ims.updateProduct("102", p2);

        System.out.println("Inventory after updating product 102:");
        ims.printInventory();

        ims.deleteProduct("101");

        System.out.println("Inventory after deleting product 101:");
        ims.printInventory();
    }
}

