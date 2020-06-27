package ss.recruitmentSys.identity.domain;

import java.sql.Date;

public class Recruitment {
	private static final long serialVersionUID = 1L;
	/** 招聘信息编号       **/
	private String re_id;
	
	/** 企业名字             **/
	private String ep_name;
	
	/** 企业电话             **/
	private String ep_phone;
	
	/** 企业电话             **/
	private String re_speciality;
	
	/** 招聘职位             **/
	private String re_job;
	
	/** 招聘人数             **/
	private int re_num;
	
	/** 工作城市             **/
	private String re_city;
	
	/** 工作描述             **/
	private String re_inf;
	
	/** 发布时间             **/
	private Date re_time;
	
	/** 点击次数             **/
	private int re_clicknum;
	
	
	public String getRe_speciality() {
		return re_speciality;
	}
	public void setRe_speciality(String re_speciality) {
		this.re_speciality = re_speciality;
	}
	public String getRe_id() {
		return re_id;
	}
	public void setRe_id(String re_id) {
		this.re_id = re_id;
	}
	public String getRe_job() {
		return re_job;
	}
	public void setRe_job(String re_job) {
		this.re_job = re_job;
	}
	public String getEp_name() {
		return ep_name;
	}
	public void setEp_name(String ep_name) {
		this.ep_name = ep_name;
	}
	public String getEp_phone() {
		return ep_phone;
	}
	public void setEp_phone(String ep_phone) {
		this.ep_phone = ep_phone;
	}
	public int getRe_num() {
		return re_num;
	}
	public void setRe_num(int re_num) {
		this.re_num = re_num;
	}
	public String getRe_city() {
		return re_city;
	}
	public void setRe_city(String re_city) {
		this.re_city = re_city;
	}
	public String getRe_inf() {
		return re_inf;
	}
	public void setRe_inf(String re_inf) {
		this.re_inf = re_inf;
	}
	public Date getRe_time() {
		return re_time;
	}
	public void setRe_time(Date re_time) {
		this.re_time = re_time;
	}
	public int getRe_clicknum() {
		return re_clicknum;
	}
	public void setRe_clicknum(int re_clicknum) {
		this.re_clicknum = re_clicknum;
	}
}
