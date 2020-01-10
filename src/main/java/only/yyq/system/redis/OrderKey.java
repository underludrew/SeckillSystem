package only.yyq.system.redis;

public class OrderKey extends BasePrefix {
    public OrderKey(String prefix, int expireSecond) {
        super(prefix, expireSecond);
    }
}
