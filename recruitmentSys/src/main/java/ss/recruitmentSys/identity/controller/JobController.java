package ss.recruitmentSys.identity.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ss.recruitmentSys.identity.domain.Recruitment;
import ss.recruitmentSys.identity.service.MainService;

@RestController
public class JobController {
	
	@Resource
	private MainService service;
	
	/**查询招聘信息**/
	@RequestMapping(value = "/selectJob", produces="application/json; charset=UTF-8")
	public List<Recruitment> selectJob(@RequestParam("re_job")String re_job,@RequestParam("re_city")String re_city,
			HttpServletRequest request){
		HttpSession session=request.getSession();
		List<Recruitment> re=service.selectJob(re_job, re_city);
		System.out.println("招聘信息条数："+service.selectJob(re_job, re_city).size());
		session.setAttribute("selectJob", re);
		System.out.println(re);
		System.out.println(session);
		 
		int size = re.size();
		session.setAttribute("jobLength", size);
		System.out.println(size);
		 
		return re;
	}
	
	/**详细招聘信息**/
	@RequestMapping(value = "/selectJobDetail", produces="application/json; charset=UTF-8")
	public Recruitment selectJobDetail(@RequestParam("re_id")String re_id,HttpServletRequest request){
		HttpSession session=request.getSession();
		Recruitment re=service.jobDetail(re_id);
		session.setAttribute("jobDetail", re);
		
		return re;
	}
	
	/**提交简历信息**/
	@RequestMapping(value = "/application", produces="application/json; charset=UTF-8")
	public int applcation(@RequestParam("user_id")String user_id,
			@RequestParam("re_id")String re_id,@RequestParam("ap_job")String ap_job) {
		
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyMMdd");
		String ap_id=format.format(date)+(int)((Math.random()*9+1)*1000);
		System.out.println(ap_id);
		
		return service.application(ap_id, user_id, re_id, ap_job);
	} 
}
