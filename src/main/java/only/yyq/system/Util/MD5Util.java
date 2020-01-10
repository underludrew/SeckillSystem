package only.yyq.system.Util;



import java.net.URLEncoder;


public class MD5Util {

    private static final String salt = "1a2s3d4f";

    public static String inputPassToFormPass(String inputpass) throws Exception{
        //加盐
        String str=""+salt.charAt(0)+salt.charAt(3)+inputpass+salt.charAt(5)+salt.charAt(6); //1s123456d4

        System.out.println("第一次加盐后："+str);
        System.out.println("inputpass to formpass result :"+MD5.getMD5Code(URLEncoder.encode(str, "utf-8")));
        return MD5.getMD5Code(URLEncoder.encode(str, "utf-8"));
    }

    public static String inputPassToDBPass (String inputpassm,String saltDB) throws Exception {
        String formpass = inputPassToFormPass(inputpassm);
        String dbpass = formPassToDBPass(formpass,saltDB);
        return dbpass;
    }

    public static String formPassToDBPass(String formpass,String salt)throws Exception{
        //加盐
        String str=""+salt.charAt(0)+salt.charAt(3)+formpass+salt.charAt(5)+salt.charAt(6);
        System.out.println("formpass to dbpass result :"+MD5.getMD5Code(URLEncoder.encode(str, "utf-8")));

        return MD5.getMD5Code(URLEncoder.encode(str, "utf-8")) ;
    }

//    public static void main(String[] args) throws Exception{  //f46b19adf74043a7e8245552980ad308 d4541250b586296fcce5dea4463ae17f
////        System.out.println(md5("123456"));
////        System.out.println(formPassToDBPass(inputPassToFormPass("123456"),"1a2s3d4f"));
////        System.out.println("input to form :"+inputPassToFormPass("1s123456d4"));
//        System.out.println(inputPassToDBPass("123456","1a2s3d4f"));
//    }

}

