package design_pattern.strategy;

public class OrderProcessStrategyFactory {
    public OrderProcessStrategyFactory() {
    }

    public OrderProcessStrategy getStrategy(String type) throws Exception {
        String strategy = OrderProcessEnum.getStrategy(type);
        return (OrderProcessStrategy)Class.forName(strategy).getDeclaredConstructor().newInstance();
    }
}
