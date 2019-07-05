package com.contactapp.model;

public class Contact {
	private long id;
	private String name;
	private String phonenumber;
	private String businessnumber;
	private String email;

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return this.id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getBusinessnumber() {
		return businessnumber;
	}

	public void setBusinessnumber(String businessnumber) {
		this.businessnumber = businessnumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {

/*		String classProperties = "id : " + this.id;
		classProperties += " name : " + this.name; 
		classProperties += "phonenumber:" + this.phonenumber;
		classProperties += "businessnumber:" + this.businessnumber;
		classProperties += "email:" + this.email;  
		
		return classProperties;
	*/
		
		StringBuilder sb=new StringBuilder();
		sb.append("id : " + this.id);
		sb.append("\nname : " + this.name);
		sb.append("\nphonenumber : " + this.phonenumber);
		sb.append("\nbusinessnumber : " + this.businessnumber);
		sb.append("\nemail: : " + this.email);
		
		return sb.toString();
	
	
	
	
	
	}

}
