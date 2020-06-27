package ss.recruitmentSys.identity.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ss.recruitmentSys.identity.service.UserService;

@RestController
 public  class RegisterController {
	/** 1.定义业务层对象 */
	@Resource
	private UserService userService;
	
	/**邮箱注册**/
	@ResponseBody  // 异步请求的响应结果
	@RequestMapping("/ERegister")
	public int ERegister(@Param("user_email")String user_email,
				@Param("user_passWord")String user_passWord) {
		int result=1;
		
		if((result=userService.check(user_email)) ==0) {
			//赋予随机ID
			Date date = new Date();
			DateFormat format = new SimpleDateFormat("yyMMdd");
			String user_id=format.format(date)+(int)((Math.random()*9+1)*1000);
			
			System.out.println(user_email+","+user_passWord);
			//查询用户ID是否存在
			int check=userService.checkId(user_id);
			while(check == 0) {
				user_id=format.format(date)+(int)((Math.random()*9+1)*1000);
				System.out.println("111111");
				check=userService.checkId(user_id);
				continue;
			}
			
			int register =userService.ERegister(user_id,user_email,user_passWord);
			if(register ==1) {
				result=1;
			}else result=2;
		}else result=0;
		return result;
	}
}
