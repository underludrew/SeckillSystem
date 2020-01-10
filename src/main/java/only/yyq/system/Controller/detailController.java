package only.yyq.system.Controller;

import com.alibaba.fastjson.JSON;
import only.yyq.system.Entity.Goods;
import only.yyq.system.Entity.GoodsVo;
import only.yyq.system.Entity.miaoshauser;
import only.yyq.system.Result.CodeMsg;
import only.yyq.system.Result.Result;
import only.yyq.system.Result.ReturnResult;
import only.yyq.system.Service.GoodsListService;
import only.yyq.system.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
public class detailController {
    @Autowired
    RedisService redisService;
    @Autowired
    GoodsListService goodsListService;

    @RequestMapping(value = "detail",method = RequestMethod.GET)
    public String getDetail(Model model,@RequestParam(value = "goods_id") String Goods_id, HttpServletRequest request){
        System.out.println("id = "+Goods_id);
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("token")){
                miaoshauser user = redisService.get(cookie.getValue(),miaoshauser.class);
                System.out.println("to here");
                if(user==null){
                    return "login/login";
                }else{
                    GoodsVo goods = goodsListService.getGoodById(Integer.valueOf(Goods_id));
                    model.addAttribute("goods_name",goods.getGoods_Name());
                    model.addAttribute("price",goods.getMiaosha_price());
                    model.addAttribute("imgpath",goods.getImgpath());
                    model.addAttribute("store",goods.getStock_count());
                    model.addAttribute("goods",goods);
                    long startAt = goods.getStart_date().getTime();
                    long end_At = goods.getEnd_date().getTime();
                    long now_date = System.currentTimeMillis();
                    System.out.println("startAt= "+startAt);
                    System.out.println("now is"+now_date);
                    System.out.println("endAt= "+end_At);
                    System.out.println("remain= "+(startAt-now_date));
                    int statusCode = 0;
                    int remainSeconds = 0;
                    if(now_date<startAt){
                        statusCode = 0;
                        remainSeconds = (int)(startAt-now_date)/1000;
                        System.out.println("remain= "+remainSeconds);
                    }else if(now_date>end_At){
                        System.out.println("秒杀结束");
                        statusCode = 2;
                        remainSeconds = -1;
                    }else{
                        statusCode = 1;
                        remainSeconds = 0;
                    }
                    model.addAttribute("statusCode",statusCode);
                    model.addAttribute("remainSeconds",remainSeconds);
                    return "Detail/Detail";
                }
            }
        }
        return "login/login";
    }

    @RequestMapping(value = "detailpage")
    @ResponseBody
    public String getDetailpage(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("token")){
                miaoshauser user = redisService.get(cookie.getValue(),miaoshauser.class);
                System.out.println("to here");
                if(user==null){
                    return "tologin";
                }else{
                    return "success";
                }
            }
        }
        return "tologin";
    }
}
