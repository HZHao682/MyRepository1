package ss.recruitmentSys.identity.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ss.recruitmentSys.identity.domain.Enterprise;
import ss.recruitmentSys.identity.service.EpService;
import ss.recruitmentSys.identity.service.UserService;

@RestController
 public  class EpRegisterController {
	/** 1.定义业务层对象 */
	@Resource
	private EpService epService;
	
	/**邮箱注册**/
	@ResponseBody  // 异步请求的响应结果
	@RequestMapping("/Ep_ERegister")
	public int ERegister(@Param("ep_email")String ep_email,
				@Param("ep_passWord")String ep_passWord) {
		int result=1;
		
		if((result=epService.check(ep_email)) ==0) {
			//赋予随机ID
			Date date = new Date();
			DateFormat format = new SimpleDateFormat("yyMMdd");
			String ep_id=format.format(date)+(int)((Math.random()*9+1)*1000);
			
			System.out.println(ep_email+","+ep_passWord);
			//查询用户ID是否存在
			int check=epService.checkId(ep_id);
			while(check == 0) {
				ep_id=format.format(date)+(int)((Math.random()*9+1)*1000);
				System.out.println("111111");
				check=epService.checkId(ep_id);
				continue;
			}
			
			int register =epService.ERegister(ep_id,ep_email,ep_passWord);
			if(register ==1) {
				result=1;
			}else result=2;
		}else result=0;
		return result;
	}
}
