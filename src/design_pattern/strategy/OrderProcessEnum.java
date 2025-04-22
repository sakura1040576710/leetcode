package design_pattern.strategy;

public enum OrderProcessEnum {
    NORMAL("normal", "design_pattern.strategy.NormalOrderProcessStrategy"),
    GROUP("group", "design_pattern.strategy.GroupOrderProcessStrategy"),
    SECKILL("seckill", "design_pattern.strategy.SeckillOrderProcessStrategy");

    private String type;
    private String strategy;

    private OrderProcessEnum(String type, String strategy) {
        this.type = type;
        this.strategy = strategy;
    }

    public static String getStrategy(String type) {

        for(OrderProcessEnum e : values()) {
            if (e.type.equals(type)) {
                return e.strategy;
            }
        }
        return null;
    }
}
