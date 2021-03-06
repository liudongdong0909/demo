package com.example.demo.controller;

import com.example.demo.model.TbUser;
import com.example.demo.service.TbUserService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

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

        List<TbUser> tbUsers = tbUserService.queryAll();
        tbUsers.sort(Comparator.comparing(TbUser::getUsername).reversed().thenComparing(TbUser::getId));

        tbUsers.stream()
                .filter(tbUser -> ! StringUtils.isEmpty(tbUser.getUsername()))
                .sorted(Comparator.comparing(TbUser::getUsername).reversed().thenComparing(TbUser::getEmail).reversed())
                .collect(Collectors.toMap(TbUser::getId, Function.identity(), (key1, key2) -> key2, LinkedHashMap::new));

        return tbUserService.queryAll();
    }

    @GetMapping(value = "/page/{pageNum}/{pageSize}")
    public PageInfo<TbUser> queryPage(@PathVariable Integer pageNum, @PathVariable Integer pageSize){
        PageInfo<TbUser> pageInfo = tbUserService.queryPageListByWhere(null, pageNum, pageSize);
        return pageInfo;
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

    @PostMapping(value = "/save")
    public Long save( TbUser tbUser) {
        tbUserService.saveSelective(tbUser);
        return tbUser.getId();
    }
}
