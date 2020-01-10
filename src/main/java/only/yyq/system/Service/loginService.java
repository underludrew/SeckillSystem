package only.yyq.system.Service;

import com.sun.org.apache.bcel.internal.classfile.Code;
import only.yyq.system.Entity.loginUserVo;
import only.yyq.system.Entity.miaoshauser;
import only.yyq.system.Mappers.miaoshauserMapper;
import only.yyq.system.Result.CodeMsg;
import only.yyq.system.Result.Result;
import only.yyq.system.Result.ReturnResult;
import only.yyq.system.Util.MD5Util;
import only.yyq.system.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Service
public class loginService {
    private final String COOKEI_NAME_TOKEN="token";
    @Autowired
    miaoshauserMapper miaoshausermapper;
    @Autowired
    RedisService redisService;


    public ReturnResult doLogin(loginUserVo user, HttpServletResponse response){
        miaoshauser muser = miaoshausermapper.getUserByName(user.getNickname());

        if(user==null)return Result.Failure(CodeMsg.LOGIN_NULLUSER);
        if (muser==null)return Result.Failure(CodeMsg.LOGIN_EMPTYUSER);

        String dbpass = null;
        try {
            dbpass = MD5Util.formPassToDBPass(user.getFormedpass(),muser.getSalt());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(" now dbpass ： "+dbpass);
        System.out.println(" get dbpass ： "+muser.getPassword());

        if(dbpass.equals(muser.getPassword())){
            String token = UUID.randomUUID().toString().replace("-","");
            try {
                if (redisService.set(token,muser,3600)){
                    Cookie cookie = new Cookie("token",token );
                    cookie.setMaxAge(3600);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    return Result.Success(muser);
                }else {
                    return Result.Failure(CodeMsg.LOGIN_TIMEOUT);
                }
            }catch (Exception e){
                return Result.Failure(CodeMsg.LOGIN_TIMEOUT);
            }
        }
        return Result.Failure(CodeMsg.LOGIN_ERRORPASS);
    }
}
