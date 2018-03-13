package com.example.demo.controller;

import com.example.demo.model.TbUser;
import com.example.demo.service.TbUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author IT_donggua
 * @version V1.0
 * @create 2018-03-13 下午 03:40
 */
@RestController
@RequestMapping("/user")
public class TbUserController {

    public static final Logger LOGGER = LoggerFactory.getLogger(TbUserController.class);

    @Autowired
    private TbUserService tbUserService;

    @GetMapping(value = "/list")
    public List<TbUser> queryList() {
        return tbUserService.queryAll();
    }

    @GetMapping(value = "/{userId}")
    public TbUser queryOne(@PathVariable Integer userId) {
        TbUser tbUser = tbUserService.queryById(userId);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.info("查询用户信息：[{}]", tbUser);
        }
        return tbUser;
    }

    @GetMapping(value = "/query/{username}")
    public List<TbUser> queryUserList(@PathVariable String username) {
        List<TbUser> userList = tbUserService.queryUserList(username);
        return userList;
    }
}
