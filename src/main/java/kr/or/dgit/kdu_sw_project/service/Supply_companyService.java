package kr.or.dgit.kdu_sw_project.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.kdu_sw_project.connection.MybatisSqlSessionFactory;
import kr.or.dgit.kdu_sw_project.connection.Supply_companyMapperImpl;
import kr.or.dgit.kdu_sw_project.dto.Supply_company;

public class Supply_companyService {
	
	public List<Supply_company> selectAllCompany(){
		try(SqlSession sqlsession = MybatisSqlSessionFactory.opensesstion()){
			Supply_companyMapperImpl comp = new Supply_companyMapperImpl(sqlsession);
			return comp.selectAllCompany();
		}
	}
	
	public Supply_company selectByNoCompany(Supply_company supcomp){
		try(SqlSession sqlsession = MybatisSqlSessionFactory.opensesstion()){
			Supply_companyMapperImpl comp = new Supply_companyMapperImpl(sqlsession);
			return comp.selectByNoCompany(supcomp);
		}
	}
	
	public int insertRowCompany(Supply_company supcomp){
		try(SqlSession sqlsession = MybatisSqlSessionFactory.opensesstion()){
			Supply_companyMapperImpl comp = new Supply_companyMapperImpl(sqlsession);
			int res = comp.insertRowCompany(supcomp);
			sqlsession.commit();
			return res;
		}
	}
	
	public int updateRowCompany(Supply_company supcomp){
		try(SqlSession sqlsession = MybatisSqlSessionFactory.opensesstion()){
			Supply_companyMapperImpl comp = new Supply_companyMapperImpl(sqlsession);
			int res = comp.updateRowCompany(supcomp);
			sqlsession.commit();
			return res;
		}
	}
	
	public int deleteRowCompany(Supply_company supcomp){
		try(SqlSession sqlsession = MybatisSqlSessionFactory.opensesstion()){
			Supply_companyMapperImpl comp = new Supply_companyMapperImpl(sqlsession);
			int res = comp.deleteRowCompany(supcomp);
			sqlsession.commit();
			return res;
		}
	}
}
