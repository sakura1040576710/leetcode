package design_pattern.strategy;

public class NormalOrderProcessStrategy extends BaseOrderProcessStrategy {
    public NormalOrderProcessStrategy() {
    }

    public void doProcess(Order order) {
        System.out.println("普通订单处理逻辑...");
    }
}
