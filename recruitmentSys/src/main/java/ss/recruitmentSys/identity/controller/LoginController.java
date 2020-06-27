package ss.recruitmentSys.identity.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ss.recruitmentSys.identity.domain.User;
import ss.recruitmentSys.identity.service.UserService;

@SuppressWarnings("unused")
@RestController
public class LoginController {
	/** 1.定义业务层对象 */	
	@Resource
	private UserService userService;
	
	/**登录检查**/
	@RequestMapping(value = "/accountLogin", produces="application/json; charset=UTF-8")
	public int selectByUserAccount(@RequestParam("user_account")String user_account,
			@RequestParam("user_passWord")String user_passWord,HttpServletRequest request) {
		int result=userService.check(user_account);
		System.out.println(result);
		if(result == 1) {
			User user1=userService.login(user_account);
			
			HttpSession session = request.getSession();
			session.setAttribute("user_name", user1.getUser_name());
			session.setAttribute("user_id", user1.getUser_id());

			/**
			 * 判断用户密码
			 */
			if(user1.getUser_passWord().equals(user_passWord) == false) {
	             result =2;
	         }else if(user1.getUser_state() != 0){
	        	 result =3;
	         }else {
	        	 result =1;
	         }
		}
		return result;
	}
	
}
