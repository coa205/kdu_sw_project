package kr.or.dgit.kdu_sw_project.service;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.kdu_sw_project.connection.MybatisSqlSessionFactory;
import kr.or.dgit.kdu_sw_project.connection.Supply_companyMapperImpl;

public class SaleService {
	public int selectSaleNoLength(){
		try(SqlSession sqlsession = MybatisSqlSessionFactory.opensesstion()){
			Supply_companyMapperImpl comp = new Supply_companyMapperImpl(sqlsession);
			return comp.selectSaleNoLength();
		}
	}
}
