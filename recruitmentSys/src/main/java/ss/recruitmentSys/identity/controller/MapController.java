package ss.recruitmentSys.identity.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ss.recruitmentSys.identity.domain.Recruitment;
import ss.recruitmentSys.identity.domain.User;
import ss.recruitmentSys.identity.service.MainService;

@Controller
public class MapController {
	/**注入**/
	@Resource
	MainService mainService;
	
	/**
	 * 企业登录入口
	 */
	@RequestMapping("/ep_login")
	public String ep_login() {
		return "ep_login";
	}
	
	 /**
	  * 企业注册
	  * @return /register
	  */
	 @RequestMapping(value = "/ep_register")
	 public String ep_register() {
	     return "ep_register";
	 }
	
	 /**
	  * 企业端主页面
	  * @param request
	  * @param model
	  * @return /main
	  */
	 @RequestMapping(value = "/ep_main")
	 public String ep_main(HttpServletRequest request,Model model) {
		 
		 HttpSession session=request.getSession();
		 String epname = (String) session.getAttribute("ep_name");
		 System.out.println("11");
		 System.out.println(epname);
		 model.addAttribute("epname", epname);
	    	
	     return "ep_main";
	 }
	
	/**
	 * 登录
	 * @return /login
	 */
	 @RequestMapping(value = "/login")
	 public String login() {
	     return "login";
	 }
	 
	 /**
	  * 注册
	  * @return /register
	  */
	 @RequestMapping(value = "/register")
	 public String register() {
	     return "register";
	 }
	 
	 /**
	  * 注销
	  * @param session
	  * @return /main
	  */
	 @RequestMapping(value="/logout")
	 public String logout(HttpSession session){
		 try {
			 /** 注销当前会话 */
			 session.invalidate();
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
		 return "/main";		
	 }
	 
	 /**
	  * 主页面
	  * @param request
	  * @param model
	  * @return /main
	  */
	 @RequestMapping(value = "/main")
	 public String main(HttpServletRequest request,Model model) {
		 
		 HttpSession session=request.getSession();
		 String username = (String) session.getAttribute("user_name");
		 model.addAttribute("username", username);
		 String userId = (String) session.getAttribute("user_id");
		 model.addAttribute("user_id", userId);
	    	
	     return "main";
	 }
	 /**
	  * 找工作页面
	  * @param request
	  * @param model
	  * @return /job
	  */
	 @RequestMapping(value = "/job")
	 public String job(HttpServletRequest request,Model model) {
		 
		 HttpSession session=request.getSession();
		 String username = (String) session.getAttribute("user_name");
		 model.addAttribute("username", username);
		 String userId = (String) session.getAttribute("user_id");
		 model.addAttribute("user_id", userId);
		 
		 List<Recruitment> re=mainService.findRe();
		 System.out.println("招聘信息条数："+mainService.findRe().size());
		 session.setAttribute("re", re);
		 System.out.println(re);
		 model.addAttribute("re", re);
		 System.out.println(session);
		 System.out.println(model);
		 
		 int re_size = re.size();
		 session.setAttribute("re_size", re_size);
		 model.addAttribute("re_size",re_size);
		 
	     return "job";
	 }
	 
	 /**
	  * 查询招聘信息
	  * @param request
	  * @param model
	  * @return /searchJob
	  */
	 @SuppressWarnings("unchecked")
	 @RequestMapping(value = "/searchJob")
	 public String searchJob(HttpServletRequest request,Model model) {
		 
		 HttpSession session=request.getSession();
		 
		 String username = (String) session.getAttribute("user_name");
		 model.addAttribute("username", username);
		 String userId = (String) session.getAttribute("user_id");
		 model.addAttribute("user_id", userId);
		 
		 List<Recruitment> selectJob = (List<Recruitment>) session.getAttribute("selectJob");
		 model.addAttribute("selectJob", selectJob);
		 
		 int size = (Integer) session.getAttribute("jobLength");
		 model.addAttribute("jobLength", size);
	    	
	     return "searchJob";
	    	
	 }
	 
	 /**
	  * 详细招聘信息
	  * @param request
	  * @param model
	  * @return /jobDetail
	  */
	 @RequestMapping(value = "/jobDetail")
	 public String jobDetail(@RequestParam("re_id")String re_id,HttpServletRequest request,Model model) {
		 HttpSession session=request.getSession();
		 
		 String username = (String) session.getAttribute("user_name");
		 model.addAttribute("username", username);
		 String userId = (String) session.getAttribute("user_id");
		 model.addAttribute("user_id", userId);
		 
		 Recruitment jobDetail1=mainService.jobDetail(re_id);
		 System.out.println(jobDetail1);
		 session.setAttribute("jobDetail1", jobDetail1);
		 model.addAttribute("jobDetail1", jobDetail1);
		 
	     return "jobDetail";
	 }
	 
	 /**
	  * 找企业页面
	  * @param request
	  * @param model
	  * @return /findEnterprise
	  */
	 @RequestMapping(value = "/findEnterprise")
	 public String findEnterprise(HttpServletRequest request,Model model) {
		 
		 HttpSession session=request.getSession();
		 String username = (String) session.getAttribute("user_name");
		 model.addAttribute("username", username);
		 
		 List<Recruitment> ep=mainService.findEp();
		 System.out.println("企业信息条数："+mainService.findEp().size());
		 session.setAttribute("ep", ep);
		 System.out.println(ep);
		 model.addAttribute("ep", ep);
		 System.out.println(session);
		 System.out.println(model);
		 
		 int ep_size = ep.size();
		 session.setAttribute("ep_size", ep_size);
		 model.addAttribute("ep_size",ep_size);
		 
	     return "findEnterprise";
	 }
	 
}
