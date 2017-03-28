package kr.or.dgit.kdu_sw_project.connection;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.kdu_sw_project.dao.Supply_companyMapper;
import kr.or.dgit.kdu_sw_project.dto.Supply_company;

public class Supply_companyMapperImpl implements Supply_companyMapper {
	private static final Log log = LogFactory.getLog(Supply_companyMapperImpl.class);
	private String namespace ="kr.or.dgit.kdu_sw_project.dao.Supply_companyMapper.";
	private SqlSession sqlsession;
	
	public Supply_companyMapperImpl(SqlSession sqlsession) {
		super();
		this.sqlsession = sqlsession;
	}

	@Override
	public List<Supply_company> selectAllCompany() {
		log.debug("selectAllCompany()");
		return sqlsession.selectList(namespace +"selectAllCompany");
	}

	@Override
	public int selectSaleNoLength() {
		log.debug("selectSaleNoLength()");
		return sqlsession.selectOne(namespace +"selectSaleNoLength");
	}

	@Override
	public Supply_company selectByNoCompany(Supply_company supcomp) {
		log.debug("selectByNoCompany()");
		return sqlsession.selectOne(namespace +"selectByNoCompany", supcomp);
	}
	
	@Override
	public int insertRowCompany(Supply_company supcomp) {
		log.debug("insertRowCompany()");
		return sqlsession.insert(namespace +"insertRowCompany", supcomp);
	}

	@Override
	public int updateRowCompany(Supply_company supcomp) {
		log.debug("updateRowCompany()");
		return sqlsession.update(namespace +"updateRowCompany", supcomp);
	}

	@Override
	public int deleteRowCompany(Supply_company supcomp) {
		log.debug("deleteRowCompany()");
		return sqlsession.update(namespace +"deleteRowCompany", supcomp);
	}
	
}



