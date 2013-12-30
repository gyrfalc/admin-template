package com.csc.admin.data.dao;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConfig {
	private static final SqlSessionFactory sqlSessionFactory;

	static {
		try {
			Reader reader = Resources.getResourceAsReader("myBatisConfig.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (Exception e) {
			throw new RuntimeException(
					"Error initializing SqlSessionFactory. Cause: " + e, e);
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
	    return sqlSessionFactory;
	  }

}
