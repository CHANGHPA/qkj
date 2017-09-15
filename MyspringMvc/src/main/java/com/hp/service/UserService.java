package com.hp.service;

import com.hp.bean.User;

import java.util.List;
import java.util.Map;

import com.hp.bean.Feel;
import com.hp.bean.Message;

public interface UserService {
	 public User findUserById(Integer userid);
	 public User findUserqq(String qq);//查询qq号
	 public boolean updateUser(User user);//更改登录时间
	 public List<Message> findMessage(Integer userid);//查看留言板
	 public Integer addmessage(Message message);//添加留言
	 public Integer delectMessage(Integer messageid);//删除留言
	 public Integer addfeel(Feel feel);//添加说说
	 public List<Feel> selectfeels();//说说列表
	 public List<Feel> userInfo(Map map);//说说分页
	 public Integer countUser();//分页
	 public Integer delectFeel(Integer feelid);//删除说说
	 public Integer zhuce (User user);//注册
}
