package kr.or.dgit.kdu_sw_project.dto;

public class Client {
	private String clntCode;
	private String clntName;
	private String clntAddr;
	private String clntTel;
	private boolean clntIsExist;
	
	public Client() {}

	public Client(String clntCode) {
		this.clntCode = clntCode;
	}

	public Client(String clntCode, String clntName, String clntAddr, String clntTel, boolean clntIsExist) {
		this.clntCode = clntCode;
		this.clntName = clntName;
		this.clntAddr = clntAddr;
		this.clntTel = clntTel;
		this.clntIsExist = clntIsExist;
	}

	public String getClntCode() {
		return clntCode;
	}

	public void setClntCode(String clntCode) {
		this.clntCode = clntCode;
	}

	public String getClntName() {
		return clntName;
	}

	public void setClntName(String clntName) {
		this.clntName = clntName;
	}

	public String getClntAddr() {
		return clntAddr;
	}

	public void setClntAddr(String clntAddr) {
		this.clntAddr = clntAddr;
	}

	public String getClntTel() {
		return clntTel;
	}

	public void setClntTel(String clntTel) {
		this.clntTel = clntTel;
	}

	public boolean isClntIsExist() {
		return clntIsExist;
	}

	public void setClntIsExist(boolean clntIsExist) {
		this.clntIsExist = clntIsExist;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s %s %s", clntCode,
				clntName, clntAddr, clntTel, clntIsExist);
	}

	public String[] toArray() {
		return new String[] {clntName};
	}
}
