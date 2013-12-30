package com.csc.admin.data.dao;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BaseDao {

	private SqlSessionFactory sqlSessionFactory;
	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	public BaseDao(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	/**
	 * Return the SqlSessionFactory that this DAO uses.
	 * 
	 * @return sqlSessionFactory
	 */
	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	/**
	 * Set the SqlSessionFactory to work with.
	 * @param sqlSessionFactory
	 */
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		if (this.sqlSessionFactory == null) {
            throw new IllegalArgumentException("Property 'sqlSessionFactory' is required");
        }		
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
    /**
     * Returns either the DataSource explicitly set for this template of the one specified by the SqlSessionFactory's Environment.
     * 
     * @see org.apache.ibatis.mapping.Environment
     */
    public DataSource getDataSource() {
    	return this.sqlSessionFactory.getConfiguration().getEnvironment().getDataSource();
    }	
	
}
