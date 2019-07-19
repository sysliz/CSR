package org.nutans.r.web.app.model;

import java.util.List;

public class Dashboard {

	private Integer totalCustomerReqCount;
	private Integer pendingCount;
	private Integer totalDeviceFaultCount;
	private Integer pendingDeviceFault;
	
	private List<ChartData> chartData;

	public Integer getTotalCustomerReqCount() {
		return totalCustomerReqCount;
	}

	public void setTotalCustomerReqCount(Integer totalCustomerReqCount) {
		this.totalCustomerReqCount = totalCustomerReqCount;
	}

	public Integer getPendingCount() {
		return pendingCount;
	}

	public void setPendingCount(Integer pendingCount) {
		this.pendingCount = pendingCount;
	}

	public Integer getTotalDeviceFaultCount() {
		return totalDeviceFaultCount;
	}

	public void setTotalDeviceFaultCount(Integer totalDeviceFaultCount) {
		this.totalDeviceFaultCount = totalDeviceFaultCount;
	}

	public Integer getPendingDeviceFault() {
		return pendingDeviceFault;
	}

	public void setPendingDeviceFault(Integer pendingDeviceFault) {
		this.pendingDeviceFault = pendingDeviceFault;
	}

	public List<ChartData> getChartData() {
		return chartData;
	}

	public void setChartData(List<ChartData> chartData) {
		this.chartData = chartData;
	}
	
	
}
