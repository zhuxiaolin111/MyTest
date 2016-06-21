package com.example.administrator.mytest.bean;

import java.io.Serializable;

public class Student1 implements Serializable {
	private Integer _id;
	private String sname;
	private String sbirth;
	private String fileName;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Integer get_id() {
		return _id;
	}
	public void set_id(Integer _id) {
		this._id = _id;
	}
	public String getSname() {
		return sname;
	}
	
	public Student1() {
		super();
	}
	public Student1(Integer _id, String sname, String sbirth) {
		super();
		this._id = _id;
		this.sname = sname;
		this.sbirth = sbirth;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSbirth() {
		return sbirth;
	}
	public void setSbirth(String sbirth) {
		this.sbirth = sbirth;
	}
	
}
