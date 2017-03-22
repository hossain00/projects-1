package beans;

public class Users {

	private int usersId;
	private String userName;
	private String upassword;
	private String ufirstName;
	private String ulastName;
	private String uEmail;
	private UserRoles uRoleId;
	
	public int getUsersId() {
		return usersId;
	}
	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUfirstName() {
		return ufirstName;
	}
	public void setUfirstName(String ufirstName) {
		this.ufirstName = ufirstName;
	}
	public String getUlastName() {
		return ulastName;
	}
	public void setUlastName(String ulastName) {
		this.ulastName = ulastName;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	public UserRoles getuRoleId() {
		return uRoleId;
	}
	public void setuRoleId(UserRoles uRoleId) {
		this.uRoleId = uRoleId;
	}
	@Override
	public String toString() {
		return "Users [usersId=" + usersId + ", userName=" + userName + ", upassword=" + upassword + ", ufirstName="
				+ ufirstName + ", ulastName=" + ulastName + ", uEmail=" + uEmail + ", uRoleId=" + uRoleId + "]";
	}
	public Users(int usersId, String userName, String ufirstName, String ulastName, String uEmail,
			UserRoles uRoleId) {
		super();
		this.usersId = usersId;
		this.userName = userName;
		this.ufirstName = ufirstName;
		this.ulastName = ulastName;
		this.uEmail = uEmail;
		this.uRoleId = uRoleId;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


}