package com.hp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hp.bean.User;
import com.hp.service.UserService;

public class SpringTest {
public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("text.xml");
	UserService userService = (UserService) context.getBean("userServiceImpl");
	User user =userService.findUserById(1);
	System.out.println(user);

}
}
