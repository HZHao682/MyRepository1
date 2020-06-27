package ss.recruitmentSys.identity.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ss.recruitmentSys.identity.domain.User;
import ss.recruitmentSys.identity.service.UserService;

@RestController
public class SelectController {
	@Resource //注入
	private UserService userService;
	
	/**查询用户姓名**/
	@ResponseBody
	@RequestMapping(value = "/selectName", produces="application/json; charset=UTF-8")
	public String selectName(HttpSession session){
		String user_id = (String) session.getAttribute("user_id");
		System.out.println(user_id);
		return userService.selectName(user_id);
	}
	
	/**查询用户所有信息**/
	@ResponseBody
	@RequestMapping(value = "/selectAll", produces="application/json; charset=UTF-8")
	public List<User> selectAll(HttpSession session){
		String user_id = (String) session.getAttribute("user_id");
		System.out.println(user_id);
		return userService.selectAll(user_id);
	}
}
