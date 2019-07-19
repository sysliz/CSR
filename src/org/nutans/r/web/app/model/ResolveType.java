package org.nutans.r.web.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="NTS_RESOLVE_TYPE")
public class ResolveType extends AuditEntity{

	@Id
	@GeneratedValue
	@Column(name="RESOLVE_TYPE_ID")
	private Integer resolveTypeId;
	
	@Column(name="RESOLVE_TYPE_NAME")
	private String resolveTypeName;
	
	@Column(name="RESOLVE_TYPE_DESC")
	private String resolveTypeDesc;

	public Integer getResolveTypeId() {
		return resolveTypeId;
	}

	public void setResolveTypeId(Integer resolveTypeId) {
		this.resolveTypeId = resolveTypeId;
	}

	public String getResolveTypeName() {
		return resolveTypeName;
	}

	public void setResolveTypeName(String resolveTypeName) {
		this.resolveTypeName = resolveTypeName;
	}

	public String getResolveTypeDesc() {
		return resolveTypeDesc;
	}

	public void setResolveTypeDesc(String resolveTypeDesc) {
		this.resolveTypeDesc = resolveTypeDesc;
	}
	
}



