package ss.recruitmentSys.identity.domain;


public class Enterprise {
	private static final long serialVersionUID = 1L;
	/** 企业编号             **/
	private String ep_id;
	
	/** 企业密码             **/
	private String ep_passWord;
	
	/** 企业名字             **/
	private String ep_name;
	
	/** 企业邮箱             **/
	private String ep_email;
	
	/** 企业地址             **/
	private String ep_address;
	
	/** 企业电话             **/
	private String ep_phone;
	
	/** 企业状态             **/
	private short ep_state;
	
	public String getEp_id() {
		return ep_id;
	}
	public void setEp_id(String ep_id) {
		this.ep_id = ep_id;
	}
	public String getEp_passWord() {
		return ep_passWord;
	}
	public void setEp_passWord(String ep_passWord) {
		this.ep_passWord = ep_passWord;
	}
	public String getEp_name() {
		return ep_name;
	}
	public void setEp_name(String ep_name) {
		this.ep_name = ep_name;
	}
	public String getEp_email() {
		return ep_email;
	}
	public void setEp_email(String ep_email) {
		this.ep_email = ep_email;
	}
	public String getEp_address() {
		return ep_address;
	}
	public void setEp_address(String ep_address) {
		this.ep_address = ep_address;
	}
	public String getEp_phone() {
		return ep_phone;
	}
	public void setEp_phone(String ep_phone) {
		this.ep_phone = ep_phone;
	}
	public short getEp_state() {
		return ep_state;
	}
	public void setEp_state(short ep_state) {
		this.ep_state = ep_state;
	}
	
}
