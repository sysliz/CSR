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
@Table(name="NTS_MESSAGES")
public class Messages extends AuditEntity {

	@Id
	@GeneratedValue
	@Column(name="MESSAGE_ID")
	private Integer messageId;
	
	@Column(name="MESSAGE_CONTENT")
	private String messageContent;
	
	@OneToOne
	@JoinColumn(name="CUS_ID")
	private Customer customer;
	
	@Column(name="MESSAGED_ON")
	private Date messagedOn;
	
	@Column(name="DELIVERY_STATUS")
	private String deliveryStatus;

	@Column(name="DELIVERY_ON")
	private Date deliveryOn;

	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getMessagedOn() {
		return messagedOn;
	}

	public void setMessagedOn(Date messagedOn) {
		this.messagedOn = messagedOn;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public Date getDeliveryOn() {
		return deliveryOn;
	}

	public void setDeliveryOn(Date deliveryOn) {
		this.deliveryOn = deliveryOn;
	}
	

}
