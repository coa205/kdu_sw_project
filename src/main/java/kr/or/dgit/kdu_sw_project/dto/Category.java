package kr.or.dgit.kdu_sw_project.dto;

public class Category {
	private String groupCode;
	private String groupName;
	
	public Category() {}

	public Category(String groupCode) {
		this.groupCode = groupCode;
	}
	
	public Category(String group_code, String group) {
		this.groupCode = group_code;
		this.groupName = group;
	}

	public String getGroup_code() {
		return groupCode;
	}

	public void setGroup_code(String group_code) {
		this.groupCode = group_code;
	}

	public String getGroup() {
		return groupName;
	}

	public void setGroup(String group) {
		this.groupName = group;
	}

	@Override
	public String toString() {
		return String.format("%s %s", groupCode, groupName);
	}
}
