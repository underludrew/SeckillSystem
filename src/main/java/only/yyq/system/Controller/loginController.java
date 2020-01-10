package only.yyq.system.Controller;


import com.alibaba.fastjson.JSON;
import only.yyq.system.Entity.loginUserVo;
import only.yyq.system.Entity.miaoshauser;
import only.yyq.system.Result.ReturnResult;
import only.yyq.system.Service.loginService;
import only.yyq.system.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "login")
public class loginController {

    @Autowired
    RedisService redisservice;
    @Autowired
    loginService loginservice;
    @RequestMapping(value = "login")
    public String loginPage(){return "login/login";}

    @RequestMapping(value = "/do_login",method = RequestMethod.POST)
    @ResponseBody
    public ReturnResult do_login(loginUserVo user, HttpServletResponse response){
        return loginservice.doLogin(user,response);
    }


//    @RequestMapping(value = "/redis/get")
//    @ResponseBody
//    public String redisGet(miaoshauser user){
//        boolean ret = redisservice.set("key2",123123)
//                ;
//        Integer i1 = redisservice.get("key2",Integer.class);
//        return JSON.toJSONString(i1);
//    }
}
