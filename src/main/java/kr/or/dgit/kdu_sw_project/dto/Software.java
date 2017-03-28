package kr.or.dgit.kdu_sw_project.dto;

public class Software {
	private String swCode;
	private String groupCode;
	private String swName;
	private int salePrice;
	private int swInven;
	private boolean swIssale;
	
	public Software() {}

	public Software(String swCode) {
		this.swCode = swCode;
	}
	
	public Software(String swCode, boolean swIssale) {
		this.swCode = swCode;
		this.swIssale = swIssale;
	}
	
	public Software(String swCode, String groupCode, String swName, int salePrice, int swInven, boolean swIssale) {
		this.swCode = swCode;
		this.groupCode = groupCode;
		this.swName = swName;
		this.salePrice = salePrice;
		this.swInven = swInven;
		this.swIssale = swIssale;
	}

	public String getSwCode() {
		return swCode;
	}

	public void setSwCode(String swCode) {
		this.swCode = swCode;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getSwName() {
		return swName;
	}

	public void setSwName(String swName) {
		this.swName = swName;
	}

	public int getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}

	public int getSwInven() {
		return swInven;
	}

	public void setSwInven(int swInven) {
		this.swInven = swInven;
	}

	public boolean isSwIssale() {
		return swIssale;
	}

	public void setSwIssale(boolean swIssale) {
		this.swIssale = swIssale;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s %s %s %s",
				swCode, groupCode, swName, salePrice, swInven, swIssale);
	}

	public String[] toArray() {
		return new String[] {swName};
	}
}
