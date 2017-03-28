package kr.or.dgit.kdu_sw_project.dao;

import java.util.List;

import kr.or.dgit.kdu_sw_project.dto.Supply_company;

public interface Supply_companyMapper {
	List<Supply_company> selectAllCompany();
	Supply_company selectByNoCompany(Supply_company supcomp);
	int insertRowCompany(Supply_company supcomp);
	int updateRowCompany(Supply_company supcomp);
	int deleteRowCompany(Supply_company supcomp);
	
	
	
	int selectSaleNoLength();
}
