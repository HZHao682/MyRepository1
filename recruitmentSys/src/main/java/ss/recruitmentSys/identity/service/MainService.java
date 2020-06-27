package ss.recruitmentSys.identity.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ss.recruitmentSys.identity.domain.Recruitment;
import ss.recruitmentSys.identity.repository.MainRepository;

@Service
public class MainService {
	/**注入     **/
	@Resource
	private MainRepository mainRepository;
	
	/**展示所有招聘信息**/
	public List<Recruitment> findRe(){
		return mainRepository.findRe();
	}
	
	/**查询招聘信息 **/
	public List<Recruitment> selectJob(String re_job,String re_city){
		return mainRepository.selectJob(re_job, re_city);
	}
	
	/**详细招聘信息 **/
	public Recruitment jobDetail(String re_id){
		return mainRepository.jobDetail(re_id);
	}
	
	/**提交简历**/
	public int application(String ap_id,String user_id,String re_id,String ap_job) {
		int result = 0;
		try {
			mainRepository.application(ap_id, user_id, re_id, ap_job);
			result = 1;
		}catch(Exception e){
			result = 0;
		}
		return result;
	}
	
	/**展示所有企业信息**/
	public List<Recruitment> findEp(){
		return mainRepository.findEp();
	}
}
