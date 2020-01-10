package only.yyq.system.redis;

public abstract class BasePrefix implements KeyPrefix {
    private int expireSecond = 0;
    private String prefix;

    public BasePrefix(String prefix,int expireSecond){
        this.expireSecond = expireSecond;
        this.prefix = prefix;
    }



    @Override
    public int expireSecond() {
        return expireSecond;
    }

    @Override
    public String getPrefix() {
        String classname = getClass().getSimpleName();

        return classname+":"+prefix;
    }
}
