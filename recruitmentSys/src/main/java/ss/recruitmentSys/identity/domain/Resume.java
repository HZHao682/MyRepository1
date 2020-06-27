package ss.recruitmentSys.identity.domain;

import java.sql.Date;

public class Resume {
	private static final long serialVersionUID = 1L;
	/** 简历编号       **/
	private String resume_id;
	
	/** 学历             **/
	private String resume_education;
	
	/** 特长              **/
	private String resume_specilality;
	
	/** 工作类型       **/
	private String resume_jtype;
	
	/** 工作职位       **/
	private String resume_job;
	
	/** 工作城市       **/
	private String resume_city;
	
	/** 自我介绍       **/
	private String resume_salary;
	
	/** 发布时间       **/
	private Date resume_time;
	
	/** 点击次数       **/
	private int resume_clicknum;
	
	public String getResume_id() {
		return resume_id;
	}
	public void setResume_id(String resume_id) {
		this.resume_id = resume_id;
	}
	public String getResume_education() {
		return resume_education;
	}
	public void setResume_education(String resume_education) {
		this.resume_education = resume_education;
	}
	public String getResume_specilality() {
		return resume_specilality;
	}
	public void setResume_specilality(String resume_specilality) {
		this.resume_specilality = resume_specilality;
	}
	public String getResume_jtype() {
		return resume_jtype;
	}
	public void setResume_jtype(String resume_jtype) {
		this.resume_jtype = resume_jtype;
	}
	public String getResume_job() {
		return resume_job;
	}
	public void setResume_job(String resume_job) {
		this.resume_job = resume_job;
	}
	public String getResume_city() {
		return resume_city;
	}
	public void setResume_city(String resume_city) {
		this.resume_city = resume_city;
	}
	public String getResume_salary() {
		return resume_salary;
	}
	public void setResume_salary(String resume_salary) {
		this.resume_salary = resume_salary;
	}
	public Date getResume_time() {
		return resume_time;
	}
	public void setResume_time(Date resume_time) {
		this.resume_time = resume_time;
	}
	public int getResume_clicknum() {
		return resume_clicknum;
	}
	public void setResume_clicknum(int resume_clicknum) {
		this.resume_clicknum = resume_clicknum;
	}
}
