package only.yyq.system.Result;

public class Result {
    /***
     * 成功 不带数据
     * @return  返回状态码与状态信息
     */
    public static ReturnResult Success(){
        ReturnResult returnResult=new ReturnResult();
        returnResult.setCode(CodeMsg.SUCCESS);
        returnResult.setMessage("success");
        return returnResult;
    }
    /***
     * 成功 带数据
     * @return  返回状态码,状态信息与数据
     */
    public static ReturnResult Success(Object data){
        ReturnResult returnResult=new ReturnResult();
        returnResult.setCode(CodeMsg.SUCCESS);
        returnResult.setMessage("success");
        returnResult.setData(data);
        return returnResult;
    }
    /***
     * 失败
     * @return  返回状态码与状态信息
     */
    public static ReturnResult Failure(CodeMsg code, String message){
        ReturnResult returnResult=new ReturnResult();
        returnResult.setCode(code);
        returnResult.setMessage(message);
        return returnResult;
    }

    /***
     * 失败
     * @return  返回状态码
     */
    public static ReturnResult Failure(CodeMsg code){
        ReturnResult returnResult=new ReturnResult();
        returnResult.setCode(code);
        return returnResult;
    }
}
