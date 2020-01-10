package only.yyq.system.Result;

import java.io.Serializable;

public class ReturnResult<T> implements Serializable {


    //状态码
    private CodeMsg code;
    //提示信息
    private String message;
    //返回数据
    private T data;

    public CodeMsg getCode() {
        return code;
    }

    public void setCode(CodeMsg code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
