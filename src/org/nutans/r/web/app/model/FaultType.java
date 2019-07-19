package org.nutans.r.web.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="NTS_FAULT_TYPE")
public class FaultType extends AuditEntity{

	@Id
	@GeneratedValue
	@Column(name="FAULT_TYPE_ID")
	private Integer faultTypeId;
	
	@Column(name="FAULT_TYPE_NAME")
	private String faultTypeName;
	
	@Column(name="FALUT_TYPE_DESC")
	private String faultTypeDesc;

	public Integer getFaultTypeId() {
		return faultTypeId;
	}

	public void setFaultTypeId(Integer faultTypeId) {
		this.faultTypeId = faultTypeId;
	}

	public String getFaultTypeDesc() {
		return faultTypeDesc;
	}

	public void setFaultTypeDesc(String faultTypeDesc) {
		this.faultTypeDesc = faultTypeDesc;
	}

	public String getFaultTypeName() {
		return faultTypeName;
	}

	public void setFaultTypeName(String faultTypeName) {
		this.faultTypeName = faultTypeName;
	}
	
	

}




