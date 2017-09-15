package com.hp.mapper;

import java.util.List;
import java.util.Map;

import com.hp.bean.Feel;
import com.hp.bean.Message;
import com.hp.bean.User;

public interface UserMapper {
	public User findUserById(Integer userid) ;
	public User findUserqq(String  qq) ;//查询qq号
	public Integer updateUser(User user);//更改登录时间
	public List<Message> findMessage(Integer userid);//查看留言板
	public Integer addMessage(Message message);//添加留言
	public Integer delectMessage(Integer messageid);//删除留言
	public Integer addFeels(Feel feel);//添加说说
	public List<Feel> selectfeels();//说说列表
	public Integer delectFeel(Integer feelid);//删除说说
	public Integer zhuce(User user);//注册
	public List<Feel> userInfo(Map map);//说说分页
	public Integer countUser();//分页
}
