package design_pattern.strategy;

public class GroupOrderProcessStrategy extends BaseOrderProcessStrategy {
    public GroupOrderProcessStrategy() {
    }

    public void doProcess(Order order) {
        System.out.println("团购订单处理逻辑...");
    }
}