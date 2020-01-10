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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "goods")
public class goodsListController {
    @Autowired
    GoodsListService goodslistservice;
    @Autowired
    RedisService redisService;
    @RequestMapping(value = "home")
    public String getGoodsListPage(Model model, HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("token")){
                System.out.println("has token");
                miaoshauser user = redisService.get(cookie.getValue(), miaoshauser.class);
                System.out.println("get redis user :" + JSON.toJSONString(user));
                if(user != null){
                    List<GoodsVo> list = goodslistservice.getGoodsList();
                    List<Map<String,String>> goodslist = new ArrayList<>();
                    for (int i = 0;i<list.size();i++){
                        goodslist.add(trans(list.get(i)));
                    }
                    model.addAttribute("goodslist",goodslist);
                    return "home/home";
                }else {
                    return "login/login";
                }
            }
        }
        return "login/login";

    }



    private Map<String,String> trans(Goods goods){
        HashMap<String,String> m = new HashMap<>();
        m.put("id",""+goods.getId());
        m.put("Goods_Name",goods.getGoods_Name());
        m.put("imgpath",goods.getImgpath());
        return m;
    }



}


