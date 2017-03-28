package kr.or.dgit.kdu_sw_project.dao;

import java.util.List;

import kr.or.dgit.kdu_sw_project.dto.Software;

public interface SoftwareMapper {
	List<Software> selectAllSw();
	Software selectByNoSw(Software software);
	int insertRowSw(Software software);
	int updateRowSw(Software software);
	int saleStopSw(Software software);
	List<Software> selectSwNameAll();
}
