package com.crudOperation.PatientRecord.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@Table(name="patient_record")
@EntityListeners(AuditingEntityListener.class)
public class PatientRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long patientId;
	
	private String patientName;
	private Integer age;
	private String address;
	
	@CreatedDate
	private Date createdDate;
	@LastModifiedDate
	private Date modifiedDate;
	
	
	
	public PatientRecord(Long patientId, String patientName, Integer age, String address, Date createdDate,
			Date modifiedDate) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.age = age;
		this.address = address;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}
	
	
	public PatientRecord() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


	
	
	
	

}
