package com.csc.admin.data.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.csc.admin.data.map.ITestDbMap;

public class TestDbDao extends BaseDao {

	public TestDbDao(SqlSessionFactory sqlSessionFactory) {
		super(sqlSessionFactory);
	}

	
	public void createTestDb() {
		log.debug("create TestDB...");
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			ITestDbMap map = sqlSession.getMapper(ITestDbMap.class);
			map.createFabric();
			map.createFabricFamily();
			map.createFabricFamilyView();
		} finally {
			sqlSession.close();
		}
	}
}
