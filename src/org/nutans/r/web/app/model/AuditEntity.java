package org.nutans.r.web.app.model;

import java.util.Date;

import javax.persistence.Column;

public class AuditEntity {

	@Column(name="ADD_USR_ID")
	private Integer	addedUserId;
	
	@Column(name="ADD_ON")
	private Date addedDateTime;
	
	@Column(name="UPD_USR_ID")
	private Integer updatedUserId;
	
	@Column(name="UPD_ON")
	private Date updatedDateTime;

	public Integer getAddedUserId() {
		return addedUserId;
	}

	public void setAddedUserId(Integer addedUserId) {
		this.addedUserId = addedUserId;
	}

	public Date getAddedDateTime() {
		return addedDateTime;
	}

	public void setAddedDateTime(Date addedDateTime) {
		this.addedDateTime = addedDateTime;
	}

	public Date getUpdatedDateTime() {
		return updatedDateTime;
	}

	public void setUpdatedDateTime(Date updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}

	public Integer getUpdatedUserId() {
		return updatedUserId;
	}

	public void setUpdatedUserId(Integer updatedUserId) {
		this.updatedUserId = updatedUserId;
	}
		
 }
