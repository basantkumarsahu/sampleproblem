package com.accolite.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
@XmlType
@XmlRootElement(name="employee")
//the xml tagname should be taken as fild name
@XmlAccessorType(XmlAccessType.FIELD)
//craeted calss as jaxb-binding class
public class Employee implements Serializable{

	public Employee(String empId, String empName, String desg, String location) {
		this.empId = empId;
		this.empName = empName;
		this.desg = desg;
		this.location = location;
	}
	public Employee() {
	}
	
	/**
	 * Serial Version Uid 
	 */
	private static final long serialVersionUID = 8017511820603117652L;
	@XmlElement(name="emp-id")
	private String empId;
	@XmlElement(name="emp-name")
	private String empName;
	private String desg;
	private String location;
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDesg() {
		return desg;
	}
	public void setDesg(String desg) {
		this.desg = desg;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", desg=" + desg + ", location=" + location + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desg == null) ? 0 : desg.hashCode());
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (desg == null) {
			if (other.desg != null)
				return false;
		} else if (!desg.equals(other.desg))
			return false;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		if (empName == null) {
			if (other.empName != null)
				return false;
		} else if (!empName.equals(other.empName))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		return true;
	}
	
	
	
	
	
}
