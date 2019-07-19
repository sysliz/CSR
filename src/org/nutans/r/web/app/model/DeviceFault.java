package org.nutans.r.web.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="NTS_DEVICE_FAULT")
public class DeviceFault extends AuditEntity {

	@Id
	@GeneratedValue
	@Column(name="DEVICE_FAULT_ID")
	private Integer deviceFaultId;
	
	@OneToOne
	@JoinColumn(name="CUS_ID")
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name="FAULT_TYPE_ID")
	private FaultType faultType;
	
	@Column(name="FAULT_CREATED_ON")
	private Date faultCreatedOn;

	@OneToOne
	@JoinColumn(name="RESOLVE_TYPE_ID")
	private ResolveType resolveType;
	
	@Column(name="ACTUAL_RESOLVED_DESC")
	private String actualResolvedDesc;
	
	@OneToOne
	@JoinColumn(name="USER_ID")
	private UserDetails resolvedByUser;
	
	@Column(name="RESOLVED_ON")
	private Date resolvedOn;
	
	@Column(name="FAULT_STATUS")
	private String faultStatus;
	
	@Column(name="ESCATLATION_STATUS")
	private String escalationStatus;

	public Integer getDeviceFaultId() {
		return deviceFaultId;
	}

	public void setDeviceFaultId(Integer deviceFaultId) {
		this.deviceFaultId = deviceFaultId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public FaultType getFaultType() {
		return faultType;
	}

	public void setFaultType(FaultType faultType) {
		this.faultType = faultType;
	}

	public Date getFaultCreatedOn() {
		return faultCreatedOn;
	}

	public void setFaultCreatedOn(Date faultCreatedOn) {
		this.faultCreatedOn = faultCreatedOn;
	}

	public ResolveType getResolveType() {
		return resolveType;
	}

	public void setResolveType(ResolveType resolveType) {
		this.resolveType = resolveType;
	}

	public String getActualResolvedDesc() {
		return actualResolvedDesc;
	}

	public void setActualResolvedDesc(String actualResolvedDesc) {
		this.actualResolvedDesc = actualResolvedDesc;
	}

	public UserDetails getResolvedByUser() {
		return resolvedByUser;
	}

	public void setResolvedByUser(UserDetails resolvedByUser) {
		this.resolvedByUser = resolvedByUser;
	}

	public Date getResolvedOn() {
		return resolvedOn;
	}

	public void setResolvedOn(Date resolvedOn) {
		this.resolvedOn = resolvedOn;
	}

	public String getFaultStatus() {
		return faultStatus;
	}

	public void setFaultStatus(String faultStatus) {
		this.faultStatus = faultStatus;
	}

	public String getEscalationStatus() {
		return escalationStatus;
	}

	public void setEscalationStatus(String escalationStatus) {
		this.escalationStatus = escalationStatus;
	}

	
}
	
	
	
	
	
	
	
