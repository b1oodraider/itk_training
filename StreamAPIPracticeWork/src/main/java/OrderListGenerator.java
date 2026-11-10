import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OrderListGenerator {
    static String[] productTypes = {"Laptop", "Mobile", "Tablet", "PC", "Notebook"};
    public static List<Order> generateOrdersList(int size) {
        Random rand = new Random();
        ArrayList<Order> orders = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            orders.add(new Order(productTypes[rand.nextInt(0,5)], rand.nextDouble()));
        }
        return orders;
    }
}
