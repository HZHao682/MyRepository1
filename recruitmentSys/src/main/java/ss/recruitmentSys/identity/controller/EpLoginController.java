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

import ss.recruitmentSys.identity.domain.Enterprise;
import ss.recruitmentSys.identity.domain.User;
import ss.recruitmentSys.identity.service.EpService;
import ss.recruitmentSys.identity.service.UserService;

@SuppressWarnings("unused")
@RestController
public class EpLoginController {
	/** 1.定义业务层对象 */	
	@Resource
	private EpService epService;
	
	/**登录检查**/
	@RequestMapping(value = "/ep_accountLogin", produces="application/json; charset=UTF-8")
	public int selectByUserAccount(@RequestParam("ep_account")String ep_account,
			@RequestParam("ep_passWord")String ep_passWord,HttpServletRequest request) {
		int result=epService.check(ep_account);
		System.out.println(result);
		if(result == 1) {
			Enterprise ep1=epService.login(ep_account);
			System.out.println(ep1.getEp_name());
			HttpSession session = request.getSession();
			session.setAttribute("ep_name", ep1.getEp_name());
			session.setAttribute("ep_id", ep1.getEp_id());

			/**
			 * 判断用户密码
			 */
			if(ep1.getEp_passWord().equals(ep_passWord) == false) {
	             result =2;
	         }else if(ep1.getEp_state() != 0){
	        	 result =3;
	         }else {
	        	 result =1;
	         }
		}
		return result;
	}
	
}
