package com.example.demo.mapper;

import com.example.demo.model.TbUser;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author IT_donggua
 * @version V1.0
 * @create 2018-03-13 上午 11:11
 */
public interface TbUserMapper extends Mapper<TbUser> {

    List<TbUser> queryUserList(@Param("username") String username);

}
