package kr.or.dgit.kdu_sw_project.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.kdu_sw_project.connection.MybatisSqlSessionFactory;
import kr.or.dgit.kdu_sw_project.connection.SoftwareMapperImpl;
import kr.or.dgit.kdu_sw_project.dto.Software;

public class SoftwareService {
	public List<Software> selectAllSw(){
		try(SqlSession sqlsession = MybatisSqlSessionFactory.opensesstion()){
			SoftwareMapperImpl comp = new SoftwareMapperImpl(sqlsession);
			return comp.selectAllSw();
		}
	}
	
	public Software selectByNoSw(Software software){
		try(SqlSession sqlsession = MybatisSqlSessionFactory.opensesstion()){
			SoftwareMapperImpl comp = new SoftwareMapperImpl(sqlsession);
			return comp.selectByNoSw(software);
		}
	}
	
	public List<Software> selectSwNameAll(){
		try(SqlSession sqlsession = MybatisSqlSessionFactory.opensesstion()){
			SoftwareMapperImpl comp = new SoftwareMapperImpl(sqlsession);
			return comp.selectSwNameAll();
		}
	}
	
	public int insertRowSw(Software software){
		try(SqlSession sqlsession = MybatisSqlSessionFactory.opensesstion()){
			SoftwareMapperImpl comp = new SoftwareMapperImpl(sqlsession);
			int res = comp.insertRowSw(software);
			sqlsession.commit();
			return res;
		}
	}
	
	public int updateRowSw(Software software){
		try(SqlSession sqlsession = MybatisSqlSessionFactory.opensesstion()){
			SoftwareMapperImpl comp = new SoftwareMapperImpl(sqlsession);
			int res = comp.updateRowSw(software);
			sqlsession.commit();
			return res;
		}
	}
	
	public int saleStopSw(Software software){
		try(SqlSession sqlsession = MybatisSqlSessionFactory.opensesstion()){
			SoftwareMapperImpl comp = new SoftwareMapperImpl(sqlsession);
			int res = comp.saleStopSw(software);
			sqlsession.commit();
			return res;
		}
	}
}
