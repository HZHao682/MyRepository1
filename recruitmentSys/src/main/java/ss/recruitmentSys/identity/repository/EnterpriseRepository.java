package ss.recruitmentSys.identity.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import ss.recruitmentSys.identity.domain.Enterprise;
import ss.recruitmentSys.identity.domain.User;

public interface EnterpriseRepository {
	/**登录查询账号 **/
	@Select("select * from enterprise where ep_email= #{ep_account} or ep_phone=#{ep_account}")
	public int check(@Param("ep_account")String ep_account);
	
	/**登录账号 **/
	@Select("select * from enterprise where ep_email= #{ep_account} or ep_phone=#{ep_account}")
		public Enterprise login(@Param("ep_account")String ep_account);
	
	/**查询ID**/
	@Select("select ep_id from enterprise where ep_id= #{ep_id}")
	public Enterprise checkId(@Param("ep_id")String ep_id);
	
	/**邮箱注册   
	 * @return **/
	@Insert("insert into enterprise(ep_id,ep_email,ep_name,ep_passWord)"+"value(#{ep_id},#{ep_email},#{ep_email},#{ep_passWord})")
		public int ERegister(@Param("ep_id")String ep_id,
					@Param("ep_email")String ep_email,
					@Param("ep_passWord")String ep_passWord);
	
	/**查询企业姓名   
	 * @return list **/
	@Select("select ep_name from enterprise where ep_id= #{ep_id}")
	public String selectName(@Param("ep_id")String ep_id);
	
	/**查询企业信息   
	 * @return list **/
	@Select("select * from enterprise where ep_id= #{ep_id}")
	public List<Enterprise> selectAll(@Param("ep_id")String ep_id);
}
