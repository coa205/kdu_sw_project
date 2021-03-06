package kr.or.dgit.kdu_sw_project.connection;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.kdu_sw_project.dao.SoftwareMapper;
import kr.or.dgit.kdu_sw_project.dto.Software;

public class SoftwareMapperImpl implements SoftwareMapper {
	private static final Log log = LogFactory.getLog(SoftwareMapperImpl.class);
	private String namespace ="kr.or.dgit.kdu_sw_project.dao.SoftwareMapper.";
	private SqlSession sqlsession;
	
	public SoftwareMapperImpl(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}
	
	@Override
	public List<Software> selectAllSw() {
		log.debug("selectAllSw()");
		return sqlsession.selectList(namespace +"selectAllSw");
	}
	
	@Override
	public Software selectByNoSw(Software software) {
		log.debug("selectByNoSw()");
		return sqlsession.selectOne(namespace +"selectByNoSw", software);
	}

	@Override
	public List<Software> selectSwNameAll() {
		log.debug("selectSwNameAll()");
		return sqlsession.selectList(namespace +"selectSwNameAll");
	}

	@Override
	public int insertRowSw(Software software) {
		log.debug("insertRowSw()");
		return sqlsession.insert(namespace +"insertRowSw", software);
	}

	@Override
	public int updateRowSw(Software software) {
		log.debug("updateRowSw()");
		return sqlsession.update(namespace +"updateRowSw", software);
	}

	@Override
	public int saleStopSw(Software software) {
		log.debug("saleStopSw()");
		return sqlsession.update(namespace +"saleStopSw", software);
	}
}
