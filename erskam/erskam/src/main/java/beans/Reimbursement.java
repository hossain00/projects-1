package beans;

import java.sql.Timestamp;

public class Reimbursement {
	
	private int reimbId;
	private double reimbAmount;
	private Timestamp reimbSubmit;
	private Timestamp  reimbResolved;
	private String reimbDescrip;
	private Users reimbAuthor;
	private Users reimbResolver;
	private Status reimbStatusId;
	private Type reimbTypeId;
	public int getReimbId() {
		return reimbId;
	}
	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}
	public double getReimbAmount() {
		return reimbAmount;
	}
	public void setReimbAmount(double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}
	public Timestamp getReimbSubmit() {
		return reimbSubmit;
	}
	public void setReimbSubmit(Timestamp reimbSubmit) {
		this.reimbSubmit = reimbSubmit;
	}
	public Timestamp getReimbResolved() {
		return reimbResolved;
	}
	public void setReimbResolved(Timestamp reimbResolved) {
		this.reimbResolved = reimbResolved;
	}
	public String getReimbDescrip() {
		return reimbDescrip;
	}
	public void setReimbDescrip(String reimbDescrip) {
		this.reimbDescrip = reimbDescrip;
	}
	public Users getReimbAuthor() {
		return reimbAuthor;
	}
	public void setReimbAuthor(Users reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}
	public Users getReimbResolver() {
		return reimbResolver;
	}
	public void setReimbResolver(Users reimbResolver) {
		this.reimbResolver = reimbResolver;
	}
	public Status getReimbStatusId() {
		return reimbStatusId;
	}
	public void setReimbStatusId(Status reimbStatusId) {
		this.reimbStatusId = reimbStatusId;
	}
	public Type getReimbTypeId() {
		return reimbTypeId;
	}
	public void setReimbTypeId(Type reimbTypeId) {
		this.reimbTypeId = reimbTypeId;
	}
	@Override
	public String toString() {
		return "Reimbursement [reimbId=" + reimbId + ", reimbAmount=" + reimbAmount + ", reimbSubmit=" + reimbSubmit
				+ ", reimbResolved=" + reimbResolved + ", reimbDescrip=" + reimbDescrip + ", reimbAuthor=" + reimbAuthor
				+ ", reimbResolver=" + reimbResolver + ", reimbStatusId=" + reimbStatusId + ", reimbTypeId="
				+ reimbTypeId + "]";
	}
	public Reimbursement(int reimbId, double reimbAmount, Timestamp reimbSubmit, Timestamp reimbResolved,
			String reimbDescrip, Users reimbAuthor, Users reimbResolver, Status reimbStatusId, Type reimbTypeId) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbSubmit = reimbSubmit;
		this.reimbResolved = reimbResolved;
		this.reimbDescrip = reimbDescrip;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatusId = reimbStatusId;
		this.reimbTypeId = reimbTypeId;
	}
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}

	
	
	
	
	

	
	