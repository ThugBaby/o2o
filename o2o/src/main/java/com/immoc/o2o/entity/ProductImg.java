package com.immoc.o2o.entity;

import java.util.Date;

public class ProductImg {

	private Long imgAddr;
	private String imgDesc;
	private Integer priority;
	private Date createTime;
	private Long productId;
	public Long getImgAddr() {
		return imgAddr;
	}
	public void setImgAddr(Long imgAddr) {
		this.imgAddr = imgAddr;
	}
	public String getImgDesc() {
		return imgDesc;
	}
	public void setImgDesc(String imgDesc) {
		this.imgDesc = imgDesc;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
}
