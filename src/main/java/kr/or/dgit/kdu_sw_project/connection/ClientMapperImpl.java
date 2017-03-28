package kr.or.dgit.kdu_sw_project.connection;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.kdu_sw_project.dao.ClientMapper;
import kr.or.dgit.kdu_sw_project.dto.Client;

public class ClientMapperImpl implements ClientMapper {
	private static final Log log = LogFactory.getLog(ClientMapperImpl.class);
	private String namespace ="kr.or.dgit.kdu_sw_project.dao.ClientMapper.";
	private SqlSession sqlsession;
	
	public ClientMapperImpl(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}
	
	@Override
	public List<Client> selectAllClnt() {
		log.debug("selectAllClnt()");
		return sqlsession.selectList(namespace +"selectAllClnt");
	}
	
	@Override
	public Client selectByNoClnt(Client client) {
		log.debug("selectByNoClnt()");
		return sqlsession.selectOne(namespace +"selectByNoClnt", client);
	}
	
	@Override
	public List<Client> selectClntNameAll() {
		log.debug("selectClntNameAll()");
		return sqlsession.selectList(namespace +"selectClntNameAll");
	}

	@Override
	public int insertRowClnt(Client client) {
		log.debug("insertRowClnt()");
		return sqlsession.insert(namespace +"insertRowClnt", client);
	}

	@Override
	public int updateRowClnt(Client client) {
		log.debug("updateRowClnt()");
		return sqlsession.update(namespace +"updateRowClnt", client);
	}

	@Override
	public int existClnt(Client client) {
		log.debug("existClnt()");
		return sqlsession.update(namespace +"existClnt", client);
	}
}
