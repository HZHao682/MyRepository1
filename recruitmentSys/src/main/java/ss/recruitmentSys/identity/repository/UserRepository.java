package ss.recruitmentSys.identity.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import ss.recruitmentSys.identity.domain.User;

public interface UserRepository {
	/**登录查询账号 **/
	@Select("select * from user where user_email= #{user_account} or user_phone=#{user_account}")
	public int check(@Param("user_account")String user_account);
	
	/**登录账号 **/
	@Select("select * from user where user_email= #{user_account} or user_phone=#{user_account}")
		public User login(@Param("user_account")String user_account);
	
	/**查询ID**/
	@Select("select user_id from user where user_id= #{user_id}")
	public User checkId(@Param("user_id")String user_id);
	
	/**邮箱注册   
	 * @return **/
	@Insert("insert into user(user_id,user_email,user_name,user_passWord)"+
				"value(#{user_id},#{user_email},#{user_email},#{user_passWord})")
		public int ERegister(@Param("user_id")String user_id,
					@Param("user_email")String user_email,
					@Param("user_passWord")String user_passWord);
	
	/**查询用户姓名   
	 * @return list **/
	@Select("select user_name from user where user_id= #{user_id}")
	public String selectName(@Param("user_id")String user_id);
	
	/**查询用户信息   
	 * @return list **/
	@Select("select * from user where user_id= #{user_id}")
	public List<User> selectAll(@Param("user_id")String user_id);
}
