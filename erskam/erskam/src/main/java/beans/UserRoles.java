package beans;


public class UserRoles {
	
	private int roleId;
	private String role;
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserRoles [roleId=" + roleId + ", role=" + role + "]";
	}
	public UserRoles(int roleId, String role) {
		super();
		this.roleId = roleId;
		this.role = role;
	}
	public UserRoles() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
