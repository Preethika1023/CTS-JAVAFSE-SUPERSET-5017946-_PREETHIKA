import java.util.Arrays;

public class ECommercePlatformSort {
    public static void main(String[] args) {
        Order[] orders = {
                new Order("001", "Alice", 250.0),
                new Order("002", "Bob", 150.0),
                new Order("003", "Charlie", 300.0),
                new Order("004", "David", 100.0),
                new Order("005", "Eve", 200.0)
        };


        Order[] bubbleSortedOrders = Arrays.copyOf(orders, orders.length);
        BubbleSort.bubbleSort(bubbleSortedOrders);
        System.out.println("Orders sorted by Bubble Sort:");
        for (Order order : bubbleSortedOrders) {
            System.out.println(order.getOrderId() + ": " + order.getCustomerName() + " - $" + order.getTotalPrice());
        }


        Order[] quickSortedOrders = Arrays.copyOf(orders, orders.length);
        QuickSort.quickSort(quickSortedOrders, 0, quickSortedOrders.length - 1);
        System.out.println("Orders sorted by Quick Sort:");
        for (Order order : quickSortedOrders) {
            System.out.println(order.getOrderId() + ": " + order.getCustomerName() + " - $" + order.getTotalPrice());
        }
    }
}
