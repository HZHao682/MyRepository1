package ss.recruitmentSys.identity.domain;


//@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class User {
	private static final long serialVersionUID = 1L;
	/** 用户编号       **/
	private String user_id;
	
	/** 用户密码       **/
	private String user_passWord;
	
	/** 用户姓名       **/
	private String user_name;
	
	/** 用户性别	    */
	private String user_sex;
	
	/** 用户邮箱       **/
	private String user_email;
	
	/** 用户电话       **/
	private String user_phone;
	
	/** 用户状态       **/
	private short user_state;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_passWord() {
		return user_passWord;
	}
	public void setUser_passWord(String user_passWord) {
		this.user_passWord = user_passWord;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public short getUser_state() {
		return user_state;
	}
	public void setUser_state(short user_state) {
		this.user_state = user_state;
	}
	
	
}
