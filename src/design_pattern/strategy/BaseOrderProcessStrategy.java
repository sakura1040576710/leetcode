package design_pattern.strategy;

public abstract class BaseOrderProcessStrategy implements OrderProcessStrategy {
    public BaseOrderProcessStrategy() {
    }

    public void process(Order order) {
        this.checkOrder(order);
        this.doProcess(order);
        this.doLog(order);
    }

    public abstract void doProcess(Order var1);

    public void checkOrder(Order order) {
        System.out.println("订单检查业务逻辑....");
    }

    public void doLog(Order order) {
        System.out.println("记录相关日志....");
    }
}

