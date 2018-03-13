package com.example.demo;

import com.example.demo.model.TbUser;
import com.example.demo.service.TbUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private TbUserService tbUserService;

	@Test
	public void test(){
		TbUser tbUser = new TbUser();
		tbUser.setUsername("zhangsan");
		List<TbUser> tbUserList = tbUserService.queryListByWhere(tbUser);

		tbUserList.stream().forEach((user) -> System.out.println(user.toString()));
	}
}
