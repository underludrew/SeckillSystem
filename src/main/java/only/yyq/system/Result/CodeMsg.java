package only.yyq.system.Result;


public class CodeMsg {

    //通用
    public static CodeMsg SUCCESS = new CodeMsg(10000,"success");
    public static CodeMsg ERROR = new CodeMsg(40000,"error");
    public static CodeMsg LOGINTIMEOUT = new CodeMsg(40000,"登录超时，请重新登录");
    //用户登录模块
    public static CodeMsg LOGIN_EMPTYUSER = new CodeMsg(40001,"用户不存在");
    public static CodeMsg LOGIN_ERRORPASS = new CodeMsg(40001,"密码错误");
    public static CodeMsg LOGIN_NULLUSER = new CodeMsg(40001,"用户名为空");
    public static CodeMsg LOGIN_NULLPASS = new CodeMsg(40001,"密码为空");
    public static CodeMsg LOGIN_TIMEOUT = new CodeMsg(40001,"登录超时");

    private int statusCode;
    private String msg;

    CodeMsg(int statusCode,String msg){
        this.statusCode=statusCode;
        this.msg=msg;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
