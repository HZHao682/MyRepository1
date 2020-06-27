package ss.recruitmentSys.identity.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import ss.recruitmentSys.identity.domain.Recruitment;

public interface MainRepository {
	/** 展示所有招聘信息**/
	@Select("select * from recruitment_inf left join enterprise\r\n" + 
			"on recruitment_inf.ep_id=enterprise.ep_id\r\n" + 
			"order by re_time desc")
	public List<Recruitment> findRe();
	
	/**
	 * 
	 * @param re_job
	 * @param re_city
	 * @param re_speciality
	 * @return 查询招聘信息
	 */
	@Select("select * from recruitment_inf left join enterprise ON recruitment_inf.ep_id=enterprise.ep_id\r\n" + 
			"where re_job like #{re_job} and re_city like #{re_city}\r\n" + 
			"order by re_time desc")
	public List<Recruitment> selectJob(@Param("re_job")String re_job,@Param("re_city")String re_city);
	
	/**
	 * 
	 * @param re_id
	 * @return 详细招聘信息
	 */
	@Select("select * from recruitment_inf left join enterprise ON recruitment_inf.ep_id=enterprise.ep_id\r\n" + 
			"where re_id = #{re_id} \r\n" + 
			"order by re_time desc")
	public Recruitment jobDetail(@Param("re_id")String re_id);
	
	/**
	 * 提交简历
	 * @param ap_id
	 * @param user_id
	 * @param re_id
	 * @param ap_job
	 * @return 
	 */
	@Insert("insert into application(ap_id,user_id,re_id,ap_job) value(#{ap_id},#{user_id},#{re_id},#{ap_job})")
	public int application(@Param("ap_id")String ap_id,@Param("user_id")String user_id,
				@Param("re_id")String re_id,@Param("ap_job")String ap_job);
	
	/** 展示所有企业信息**/
	@Select("select * from enterprise")
	public List<Recruitment> findEp();
}
