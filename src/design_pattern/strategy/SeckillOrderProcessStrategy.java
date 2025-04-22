package design_pattern.strategy;

public class SeckillOrderProcessStrategy extends BaseOrderProcessStrategy {
    public SeckillOrderProcessStrategy() {
    }

    public void doProcess(Order order) {
        System.out.println("秒杀订单处理逻辑...");
    }
}
