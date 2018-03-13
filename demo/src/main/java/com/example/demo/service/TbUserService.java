package com.example.demo.service;


import com.example.demo.mapper.TbUserMapper;
import com.example.demo.model.TbUser;
import com.example.demo.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author IT_donggua
 * @version V1.0
 * @create 2018-03-13 上午 10:35
 */
@Service
public class TbUserService extends BaseService<TbUser> {

    @Autowired
    private TbUserMapper tbUserMapper;

    public List<TbUser> queryUserList(String username) {
        return tbUserMapper.queryUserList(username);
    }

}
