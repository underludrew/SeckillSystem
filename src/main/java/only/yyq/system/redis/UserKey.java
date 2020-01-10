package only.yyq.system.redis;

public class UserKey extends BasePrefix {

    private UserKey(String prefix, int expireSecond) {
        super(prefix, expireSecond);
    }
    public static UserKey getByid = new UserKey("id",0);
}
