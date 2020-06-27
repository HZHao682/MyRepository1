package ss.recruitmentSys.identity.domain;

public class Application {
	private static final long serialVersionUID = 1L;
	/** 申请表编号       **/
	private String ap_id;
	
	/** 申请职位         **/
	private String ap_job;
	
	public String getAp_id() {
		return ap_id;
	}
	public void setAp_id(String ap_id) {
		this.ap_id = ap_id;
	}
	public String getAp_job() {
		return ap_job;
	}
	public void setAp_job(String ap_job) {
		this.ap_job = ap_job;
	}
}
