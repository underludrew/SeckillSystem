package only.yyq.system.redis;

public interface KeyPrefix {
    int expireSecond();
    String getPrefix();

}
