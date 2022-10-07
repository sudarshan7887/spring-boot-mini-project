package com.sudarshan.StudentMgnt.Domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentDAO
{
	@Id
	private Long id;
	private String stname;
	private String cname;
	private String fee;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStname() {
		return stname;
	}
	public void setStname(String stname) {
		this.stname = stname;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}
	@Override
	public String toString() {
		return "StudentDAO [id=" + id + ", stname=" + stname + ", cname=" + cname + ", fee=" + fee + "]";
	}
	
	
	
}
