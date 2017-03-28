package kr.or.dgit.kdu_sw_project.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.kdu_sw_project.connection.ClientMapperImpl;
import kr.or.dgit.kdu_sw_project.connection.MybatisSqlSessionFactory;
import kr.or.dgit.kdu_sw_project.dto.Client;

public class ClientService {
	public List<Client> selectAllClnt(){
		try(SqlSession sqlsession = MybatisSqlSessionFactory.opensesstion()){
			ClientMapperImpl comp = new ClientMapperImpl(sqlsession);
			return comp.selectAllClnt();
		}
	}
	
	public Client selectByNoClnt(Client client){
		try(SqlSession sqlsession = MybatisSqlSessionFactory.opensesstion()){
			ClientMapperImpl comp = new ClientMapperImpl(sqlsession);
			return comp.selectByNoClnt(client);
		}
	}
	
	public List<Client> selectClntNameAll(){
		try(SqlSession sqlsession = MybatisSqlSessionFactory.opensesstion()){
			ClientMapperImpl comp = new ClientMapperImpl(sqlsession);
			return comp.selectClntNameAll();
		}
	}
	
	public int insertRowClnt(Client client){
		try(SqlSession sqlsession = MybatisSqlSessionFactory.opensesstion()){
			ClientMapperImpl comp = new ClientMapperImpl(sqlsession);
			int res = comp.insertRowClnt(client);
			sqlsession.commit();
			return res;
		}
	}
	
	public int updateRowClnt(Client client){
		try(SqlSession sqlsession = MybatisSqlSessionFactory.opensesstion()){
			ClientMapperImpl comp = new ClientMapperImpl(sqlsession);
			int res = comp.updateRowClnt(client);
			sqlsession.commit();
			return res;
		}
	}
	
	public int existClnt(Client client){
		try(SqlSession sqlsession = MybatisSqlSessionFactory.opensesstion()){
			ClientMapperImpl comp = new ClientMapperImpl(sqlsession);
			int res = comp.existClnt(client);
			sqlsession.commit();
			return res;
		}
	}
}
