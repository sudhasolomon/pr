package com.dao;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;


/** 
 * <p><b>FILE:</b> BaseDAOImpl.java</p> 
 * <p><b>PACKAGE:</b> com.cgg.dao</p>
 *
 * <p><b>SUMMARY:</b> Base class to load the configured datasource.</p> 
 * 
 * @author srilakshmi 
 * @since 16-Sep-2017
 *
 */
public abstract class BaseDAOImpl extends NamedParameterJdbcDaoSupport  {

	@Autowired
	DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	public BaseDAOImpl(DataSource dataSource) {
		setDataSource(dataSource);
	}
	
	public BaseDAOImpl(){
		
	}
}
