package kr.or.dgit.kdu_sw_project.dto;

import java.util.Date;

public class Sale {
	private String saleNo;
	private String clntNo;
	private String swNo;
	private int sellingAmount;
	private boolean isDeposit;
	private Date orderDate;
	
	public Sale() {}
	
	public Sale(String saleNo, String clntNo, String swNo, int sellingAmount, boolean isDeposit, Date orderDate) {
		this.saleNo = saleNo;
		this.clntNo = clntNo;
		this.swNo = swNo;
		this.sellingAmount = sellingAmount;
		this.isDeposit = isDeposit;
		this.orderDate = orderDate;
	}
	
	public String getSaleNo() {
		return saleNo;
	}
	
	public void setSaleNo(String saleNo) {
		this.saleNo = saleNo;
	}
	
	public String getClntNo() {
		return clntNo;
	}
	
	public void setClntNo(String clntNo) {
		this.clntNo = clntNo;
	}
	
	public String getSwNo() {
		return swNo;
	}
	
	public void setSwNo(String swNo) {
		this.swNo = swNo;
	}
	
	public int getSellingAmount() {
		return sellingAmount;
	}
	
	public void setSellingAmount(int sellingAmount) {
		this.sellingAmount = sellingAmount;
	}
	
	public boolean isDeposit() {
		return isDeposit;
	}
	
	public void setDeposit(boolean isDeposit) {
		this.isDeposit = isDeposit;
	}
	
	public Date getOrderDate() {
		return orderDate;
	}
	
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s %s %s %s %s",
				saleNo, clntNo, swNo, sellingAmount, isDeposit, orderDate);
	}
}
