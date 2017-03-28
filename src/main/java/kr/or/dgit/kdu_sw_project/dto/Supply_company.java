package kr.or.dgit.kdu_sw_project.dto;

public class Supply_company {
	private String compCode;
	private String compName;
	private String compAddr;
	private String compTel;
	private boolean compIsExist;
	
	public Supply_company() {}

	public Supply_company(String compCode) {
		this.compCode = compCode;
	}

	public Supply_company(String compCode, String compName, String compAddr, String compTel, boolean compIsleave) {
		this.compCode = compCode;
		this.compName = compName;
		this.compAddr = compAddr;
		this.compTel = compTel;
		this.compIsExist = compIsleave;
	}

	public String getCompCode() {
		return compCode;
	}

	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}

	public boolean isCompIsleave() {
		return compIsExist;
	}

	public void setCompIsleave(boolean compIsleave) {
		this.compIsExist = compIsleave;
	}
	
	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getCompAddr() {
		return compAddr;
	}

	public void setCompAddr(String compAddr) {
		this.compAddr = compAddr;
	}

	public String getCompTel() {
		return compTel;
	}

	public void setCompTel(String compTel) {
		this.compTel = compTel;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s %s %s",
				compCode, compName, compAddr, compTel, compIsExist);
	}
}
