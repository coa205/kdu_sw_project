package kr.or.dgit.kdu_sw_project.dao;

import java.util.List;

import kr.or.dgit.kdu_sw_project.dto.Client;

public interface ClientMapper {
	List<Client> selectAllClnt();
	Client selectByNoClnt(Client client);
	int insertRowClnt(Client client);
	int updateRowClnt(Client client);
	int existClnt(Client client);
	
	List<Client> selectClntNameAll();
}
