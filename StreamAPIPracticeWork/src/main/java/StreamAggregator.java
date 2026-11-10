import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamAggregator {
    public static void  main(String[] args) {
        List<Order> orders = OrderListGenerator.generateOrdersList(25);
        Map<String,List<Order>> groupedOrders = orders.stream().collect(Collectors.groupingBy(Order::getProduct));
        Map<String, Double> sumOfPrices = groupedOrders.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,
                entry -> entry.getValue().stream().mapToDouble(Order::getCost).sum()));
        Map<String, Double> sortedOrders = sumOfPrices.entrySet().stream().sorted(Map.Entry.<String,Double>comparingByValue().reversed()).limit(3).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a,b) -> a, LinkedHashMap::new));
        double sum = sortedOrders.values().stream().mapToDouble(Double::doubleValue).sum();
        for(Map.Entry<String,Double> entry : sortedOrders.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("сумма покупок самых дорогих товаров: " + sum);
    }

    /* решение можно представить в виде единого последовательного стрима,
    без создания orders, groupedOrders, sumOfPrices:
     Map<String,Double> sortedThreeNames = OrderListGenerator.generateOrdersList(25)
                                          .stream().collect(Collectors.groupingBy(Order::getProduct))
                                          .entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,
                                            entry -> entry.getValue().stream().mapToDouble(Order::getCost).sum()))
                                          .entrySet().stream().sorted(Map.Entry.<String,Double>comparingByValue().reversed())
                                          .limit(3)
                                          .collect(Collectors.toMap(Map.Entry::getKey,
                                                                    Map.Entry::getValue,
                                                                    (a,b) -> a, LinkedHashMap::new))
     не стал так делать из-за проблемы с читаемостью и отладкой
     */

}
