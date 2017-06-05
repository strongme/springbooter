package cn.strongme;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 阿水 on 2017/5/27 09:56.
 * 为了防止Idea提示bean not found 错误，添加注解@Repository，不会多次扫描到Bean
 */
@Mapper
@Repository
public interface UserMapper {

    List<User> listAll();

}
