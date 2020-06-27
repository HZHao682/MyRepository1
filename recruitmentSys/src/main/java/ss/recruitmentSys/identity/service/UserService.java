package ss.recruitmentSys.identity.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ss.recruitmentSys.identity.domain.User;
import ss.recruitmentSys.identity.repository.UserRepository;

@Service
public class UserService {
	/*注入     */
	@Resource
	private UserRepository userRepository;
	
	/*登录前查询  */
	public int check(String user_account) {
		try{
			userRepository.check(user_account);
			return 1;
		}catch(Exception e) {
			return 0;
		}
	}
	
	/*登录     */
	public User login(String user_account) {
			return userRepository.login(user_account);
	}
	
	/*查询Id*/
	public int checkId(String user_id) {
		try{
			userRepository.checkId(user_id);
			return 1;
		}catch(Exception e) {
			return 0;
		}
	}
	
	/*注册     */
	public int ERegister(String user_id,String user_email,String user_passWord) {
		try{
			userRepository.ERegister(user_id,user_email, user_passWord);
			return 1;
		}catch(Exception e) {
			return 0;
		}
	}
	
	/*查询用户姓名*/
	public String selectName(String user_id){
		return userRepository.selectName(user_id);
	}
	
	/*查询用户信息*/
	public List<User> selectAll(String user_id){
		return userRepository.selectAll(user_id);
	}
}
