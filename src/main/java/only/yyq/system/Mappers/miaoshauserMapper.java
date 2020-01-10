package only.yyq.system.Mappers;

import only.yyq.system.Entity.miaoshauser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface miaoshauserMapper {
    @Select("select * from miaoshauser where nickname = #{name}")
    miaoshauser getUserByName(String name);


}
