package only.yyq.system.Controller;

import only.yyq.system.Service.GoodsListService;
import only.yyq.system.redis.RedisService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class miaoshaController {
    @Autowired
    RedisService redisService;
    @Autowired
    GoodsListService goodsListService;


    @RequestMapping(value = "doMiaosha",method = RequestMethod.POST)
    @ResponseBody
    public String domiaosha(@Param("goods_id") String goods_id){
        System.out.println("id = "+goods_id);
        if(goodsListService.domiaosha(Integer.valueOf(goods_id))){
            return "success";
        }else{
            return "-1";
        }
    }
}
