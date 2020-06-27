package ss.recruitmentSys.identity.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ss.recruitmentSys.identity.domain.Enterprise;
import ss.recruitmentSys.identity.repository.EnterpriseRepository;

@Service
public class EpService {
	/*注入     */
	@Resource
	private EnterpriseRepository enterpriseRepository;
	
	/*登录前查询  */
	public int check(String ep_account) {
		try{
			enterpriseRepository.check(ep_account);
			return 1;
		}catch(Exception e) {
			return 0;
		}
	}
	
	/*登录     */
	public Enterprise login(String ep_account) {
			return enterpriseRepository.login(ep_account);
	}
	
	/*查询Id*/
	public int checkId(String ep_id) {
		try{
			enterpriseRepository.checkId(ep_id);
			return 1;
		}catch(Exception e) {
			return 0;
		}
	}
	
	/*注册     */
	public int ERegister(String ep_id,String ep_email,String ep_passWord) {
		try{
			enterpriseRepository.ERegister(ep_id,ep_email, ep_passWord);
			return 1;
		}catch(Exception e) {
			return 0;
		}
	}
	
	/*查询用户姓名*/
	public String selectName(String ep_id){
		return enterpriseRepository.selectName(ep_id);
	}
	
	/*查询用户信息*/
	public List<Enterprise> selectAll(String ep_id){
		return enterpriseRepository.selectAll(ep_id);
	}
}
