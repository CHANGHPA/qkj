package com.hp.controller;

import java.io.IOError;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hp.bean.Feel;
import com.hp.bean.Message;
import com.hp.bean.PageBean;
import com.hp.bean.User;
import com.hp.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {
	@Autowired
	private UserService userservice;
	
		public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}
		//主页面
		@RequestMapping("/")
		public String index(){
			
			return "login";
		}
		//重置
		@RequestMapping("/modifyInfor")
		public String modifyInfor(){
			
			return "modifyInfor";
		}
		//登录
		@RequestMapping("/login")
		public String login(){
					
		return "login";
		}
		//个人资料
		@RequestMapping("/hostinfor")
		public String hostinfor(){
					
		return "hostinfor";
		}
		//好友个人资料
		@RequestMapping("/friendinfo")
		public String friendinfo(){
					
		return "friendinfo";
		}
		//好友
		@RequestMapping("/showfriends")
		public String showfriends(){
					
		return "showfriends";
		}
		//添加说说
		@RequestMapping("/publishFeel")
		public String addfeel(Feel feel,HttpSession httpSession) {
			User usersInfo=(User)httpSession.getAttribute("userInfo");
			Date date=new Date();
			Timestamp time=new Timestamp(date.getTime()); 
			feel.setFeeltime(time);
			feel.setUserid(usersInfo.getUserid());
			Integer i = userservice.addfeel(feel);
			if(i>0){
				return "redirect:/feelindex";
			}else{
				return "login";
			}
		}
		//我的说说
		@RequestMapping("/feelmy")
		public String myfeel (){
					
		return "feelmy";
		}		
		//说说列表
		/*@RequestMapping("/feelindex")
		public String feelindex(Model model){
			List<Feel> allfeels = userservice.selectfeels();
			if(allfeels.size()>0){
				model.addAttribute("feel",allfeels);
				return "feelindex";
			}else{
				return "login";
			}
		}*/
		//删除说说
				@RequestMapping("/deleteFeel")
				public String deleteFeel(Feel feel){
					Integer c = userservice.delectFeel(feel.getFeelid());
					if (c>0) {
						return "redirect:/feelindex";
					}
					return "login";
				}	
	
		//修改头像
		@RequestMapping("/updateheadpic")
		public String updateheadpic(){
			
			return "updateheadpic";
		}
	
		@RequestMapping("/register")
		public String register(){
			
			return "register";
		}
		//主页
		@RequestMapping("/feelallperson")
		public String feelallperson(){
			
			return "feelallperson";
		}
		//个人资料
		@RequestMapping("/showhostinfor")
		public String showhostinfor(){
					
		return "modifyInfor";
		}		
				
		//好友
		@RequestMapping("/askforfriend")
		public String askforfriend(){
					
		return "askforfriend";
		}	
		
		@RequestMapping(value={"login"},method=RequestMethod.POST)
		public String login(User user,HttpServletRequest request,Model model){
			//查询数据库
			User usersInfo=userservice.findUserqq(user.getQq());
			if (usersInfo!=null && usersInfo.getPassword().equals(user.getPassword())) {
				HttpSession httpSession =request.getSession();
				httpSession.setAttribute("userInfo", usersInfo);
				model.addAttribute("username", usersInfo.getUsername());
				//获取当前时间
				Date date = new Date();
				//获取时间戳
				Timestamp time = new Timestamp(date.getTime());
				//更新数据库
				usersInfo.setLastvisit(time);
				//调用service 更新方法
				boolean flag = userservice.updateUser(usersInfo);
				//更新失败
				if (!flag) {
					return "error";
				}else{
					return "index";
				}
			}else{
				return "login";
			}
		}
		//留言板
		//查看留言板
		@RequestMapping("/message")
		public String showMessages(Model model,HttpSession session){
			User user = (User) session.getAttribute("userInfo");
			List<Message> mess = userservice.findMessage(user.getUserid());
			if(mess.size()>0){
				model.addAttribute("message",mess);
				return "message";
			}else{
				return "login";
			}
		}
		//添加留言
		@RequestMapping("/leaveMessage")
		public String addMessage(Message message,HttpSession httpSession) {
					User usersInfo=(User)httpSession.getAttribute("userInfo");
					Date date=new Date();
					Timestamp time=new Timestamp(date.getTime()); 
					message.setMessagetime(time);
					message.setMessageid(usersInfo.getUserid());
					message.setReceiveid(usersInfo.getUserid());
					message.setSenderid(usersInfo.getUserid());
					message.setParentmessageid(usersInfo.getUserid());
					Integer i =userservice.addmessage(message);
					if(i>0){
						return "redirect:/message";
					}else{
						return "login";
					}
			}	
		//删除留言
		@RequestMapping("/deleteMessage")
		public String deleteMessage(Message message){
			Integer c = userservice.delectMessage(message.getMessageid());
			if (c>0) {
				return "redirect:/message";
			}
			return "login";
		}	

		//注册
		@RequestMapping("/registervalid")
		public String zhuce (User user,Model model){
			
				user.setQq(String.valueOf(new Random().nextInt(1000)));
				user.setHeadpic("static/headpic/20140802211120_t34dW.thumb.224_0.jpeg");
				user.setLastvisit(new Timestamp(new Date().getTime()));
				user.setState(1);
				User userbean = userservice.findUserqq(user.getQq());
				if(userbean==null){
					Integer ii = userservice.zhuce(user);
					if(ii>0){
						model.addAttribute("user", user);
					}
					return "register_suc";
				}else{
					return "login";
				}
				
		}
		//分页
	
		@RequestMapping(value="/user")
		public String userList(Model model,String page){
			int size = 5;
			Map<String, Object> map = new HashMap<String,Object >();
			map.put("start", PageBean.countOffset(size, Integer.parseInt(page)));
			map.put("size", size);
			int allRow = userservice.countUser();
			//总数
			int totalPage = PageBean.countTotalPage(size, allRow);
			/*final int offset = PageBean.countOffset(size, Integer.parseInt(page));
			final int length = size;*/
			final int currentPage = PageBean.countCurrentPage(Integer.parseInt(page));
			List list = userservice.userInfo(map);
			PageBean pageBean = new PageBean();
			pageBean.setPageize(size);
			pageBean.setCurrentPage(currentPage);
			pageBean.setAllRow(allRow);
			pageBean.setTotalPage(totalPage);
			pageBean.setList(list);
			model.addAttribute("pager",pageBean);
			return "feelindex";
		}
	
}
