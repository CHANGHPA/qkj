package com.hp.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hp.bean.Feel;
import com.hp.bean.Message;
import com.hp.bean.User;
import com.hp.mapper.UserMapper;
import com.hp.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public User findUserById(Integer userid) {
		
		return userMapper.findUserById(userid);
	}

	@Override
	public User findUserqq(String qq) {
		
		return userMapper.findUserqq(qq);
	}
	//更改登录时间
	@Override
	public boolean updateUser(User user) {
		//三目运算
		//第一种方法
		//return userMapper.updateUser(user)>0?true:false;
		Integer count =userMapper.updateUser(user);
		if (count>0) {
			return true;
		}else{
			return false;
		}
	
	}
	///查看留言板
	@Override
	public List<Message> findMessage(Integer userid) {
		return userMapper.findMessage(userid);
	}
	//添加留言
	@Override
	public Integer addmessage(Message message) {
		return userMapper.addMessage(message);
	} 
	//删除留言
		@Override
		public Integer delectMessage(Integer messageid) {
			return userMapper.delectMessage(messageid);
		}
	
	//添加说说
	@Override
	public Integer addfeel(Feel feel) {
		return userMapper.addFeels(feel);
	}
	//说说列表
	@Override
	public List<Feel> selectfeels() {
		
		return userMapper.selectfeels();
	}
	//删除说说
	@Override
	public Integer delectFeel(Integer feelid) {
		return userMapper.delectFeel(feelid);
	}
	//注册
	@Override
	public Integer zhuce(User user) {
		return userMapper.zhuce(user);
	}
	//分页
	@Override
	public List<Feel> userInfo(Map map) {
		return userMapper.userInfo(map);
	}
	//分页
	@Override
	public Integer countUser() {
		return userMapper.countUser();
	}
	

}
