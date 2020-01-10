package only.yyq.system.Mappers;

import only.yyq.system.Entity.Goods;
import only.yyq.system.Entity.GoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface GoodsMapper {

    @Select("select g.*,mg.* from miaosha_goods mg left join goods g on mg.goods_id = g.id")
    List<GoodsVo> getGoodsList();

    @Select("select g.*,mg.stock_count,mg.start_date,mg.miaosha_price,mg.end_date from miaosha_goods mg left join goods g on mg.goods_id = g.id where g.id =#{id}")
    GoodsVo getGoodsById(int id);
    @Select("select * from goods")
    GoodsVo getMiaoshaGoodsByid(int id);

    @Update("update miaosha_goods set stock_count =#{stockcount} where goods_id = #{goods_id} ")
    boolean domiaosha(int goods_id,int stockcount);
    @Select("select stock_count from miaosha_goods where goods_id = #{goods_id}")
    int getStock(int goods_id);
}
