package only.yyq.system.Service;

import only.yyq.system.Entity.Goods;
import only.yyq.system.Entity.GoodsVo;
import only.yyq.system.Mappers.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class GoodsListService {
    @Autowired
    GoodsMapper goodsMapper;
    public List<GoodsVo> getGoodsList(){
        System.out.println("goods count = "+goodsMapper.getGoodsList().size());
        return goodsMapper.getGoodsList();
    }

    public GoodsVo getGoodById(int id){
        return goodsMapper.getGoodsById(id);
    }

    public int getStockcount(int goods_id){return  goodsMapper.getStock(goods_id);}
    public boolean domiaosha(int goods_id){
        int nowstock = getStockcount(goods_id);
        nowstock--;
        return goodsMapper.domiaosha(goods_id,nowstock);
    }
}
