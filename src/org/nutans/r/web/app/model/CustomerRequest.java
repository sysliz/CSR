package org.nutans.r.web.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="NTS_CUS_REQUEST")
public class CustomerRequest extends AuditEntity{

	@Id
	@GeneratedValue
	@Column(name="CUS_REQUEST_ID")
	private Integer customerRequestId;
	
	@OneToOne
	@JoinColumn(name="CUS_ID")
	private Customer customer;
	
	@Column(name="CUS_REQUEST_TITLE")
	private String customerRequestTitle;
	
	@Column(name="CUS_REQUEST_DESC")
	private String customerRequestDesc;
	
	@Column(name="STATUS")
	private String status;
	
	@Transient
	private Long mobile;

	public Integer getCustomerRequestId() {
		return customerRequestId;
	}

	public void setCustomerRequestId(Integer customerRequestId) {
		this.customerRequestId = customerRequestId;
	}

	

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getCustomerRequestTitle() {
		return customerRequestTitle;
	}

	public void setCustomerRequestTitle(String customerRequestTitle) {
		this.customerRequestTitle = customerRequestTitle;
	}

	public String getCustomerRequestDesc() {
		return customerRequestDesc;
	}

	public void setCustomerRequestDesc(String customerRequestDesc) {
		this.customerRequestDesc = customerRequestDesc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
}
