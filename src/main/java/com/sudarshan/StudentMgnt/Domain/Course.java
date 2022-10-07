package com.sudarshan.StudentMgnt.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Course")
public class Course
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String cname;
	private String cduration;
	
	public Course()
	{
		
	}
	
	public Course(long id, String cname, String cduration) {
		super();
		this.id = id;
		this.cname = cname;
		this.cduration = cduration;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCduration() {
		return cduration;
	}
	public void setCduration(String cduration) {
		this.cduration = cduration;
	}
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", cname=" + cname + ", cduration=" + cduration + "]";
	}
}
