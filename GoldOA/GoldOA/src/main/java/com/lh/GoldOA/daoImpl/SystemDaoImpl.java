package com.lh.GoldOA.daoImpl;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate; 
import org.springframework.stereotype.Service;

import com.lh.GoldOA.dao.SystemDao;
import com.lh.GoldOA.entity.AccountTable; 
import com.lh.GoldOA.rowmapper.AccountTableRowMapper;

/**
 * systemDao的实现类
 * @author NashobaBrook
 * @date 2017年8月18日16:20:30
 *
 */
@Service
public class SystemDaoImpl implements SystemDao{

	@Autowired
	JdbcTemplate jdbc;
	

	/**
	 * 查找该账号密码对应的
	 * @return 返回查找到的用户:若未查询到就返回null;
	 */
	@SuppressWarnings("null")
	@Override
	public AccountTable selectAccount(String account, String password) {
		String sql="select * from accountTable where account = ? and password = ?";
		List<AccountTable> list = jdbc.query(sql,new AccountTableRowMapper() ,account,password);
		if (list == null) {
			return list.get(0);
		}
		return null;
	}

	
	
	
	
}
