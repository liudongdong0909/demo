package com.example.demo.service;

import com.example.demo.DemoApplicationTests;
import com.example.demo.model.TbUser;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * ${DESCRIPTION}
 *
 * @author donggua
 * @version 1.0
 * @create 2018/3/13
 */
public class TbUserServiceTest extends DemoApplicationTests {

    @Autowired
    private TbUserService tbUserService;

    @Test
    public void queryUserList() throws Exception {
        TbUser tbUser = new TbUser();
        tbUser.setUsername("zhangsan");
        List<TbUser> tbUserList = tbUserService.queryListByWhere(tbUser);

        Assert.assertEquals(tbUserList.size(), 1);
    }

    @Test
    public void saveSelective(){
        TbUser tbUser = new TbUser();
        tbUser.setUsername("test555");
        tbUser.setEmail("test@yeah.net");
        tbUser.setPassword("123456");
        tbUser.setPhone("17682313306");
        tbUserService.saveSelective(tbUser);

        throw new RuntimeException();
    }


}