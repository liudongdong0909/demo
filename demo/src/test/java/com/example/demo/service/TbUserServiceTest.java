package com.example.demo.service;

import com.example.demo.DemoApplicationTests;
import com.example.demo.model.TbUser;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 测试service方法
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2018-03-14
 */
public class TbUserServiceTest extends DemoApplicationTests {

    @Autowired
    private TbUserService tbUserService;

    @Test
    public void queryUserList() throws Exception {

        List<TbUser> userList = tbUserService.queryUserList("zhangsan");
        Assert.assertEquals(userList.size(), 5);
    }

    @Test
    public void testTransactional() {

        TbUser tbUser = new TbUser();
        tbUser.setUsername("test44");
        tbUser.setPassword("123456");
        tbUser.setEmail("test@yeah.net");
        tbUser.setPhone("17682313306");
        tbUserService.saveTbUser(tbUser);

        int i = 1/0;
    }


}