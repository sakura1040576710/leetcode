package design_pattern.strategy;

public class OrderProcessService {
    public OrderProcessService() {
    }

    public static void main(String[] args) throws Exception {
        OrderProcessStrategyFactory factory = new OrderProcessStrategyFactory();
        OrderProcessStrategy strategy = factory.getStrategy("normal");
        strategy.process(new Order());
    }
}
