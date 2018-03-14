package com.example.demo.page;

import com.example.demo.DemoApplicationTests;
import com.example.demo.model.TbUser;
import com.example.demo.service.TbUserService;
import com.github.pagehelper.PageHelper;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * PageHelper分页测试
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2018-03-14 上午 10:31
 */
public class PageHelperTest extends DemoApplicationTests {

    @Autowired
    private TbUserService tbUserService;

    @Test
    public void queryPage(){
        PageHelper.startPage(1, 10);
        List<TbUser> userList = tbUserService.queryListByWhere(null);
        Assert.assertEquals(userList.size(), 10);
    }
}
