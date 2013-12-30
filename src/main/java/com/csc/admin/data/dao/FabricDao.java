package com.csc.admin.data.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.csc.admin.data.map.IFabricMap;
import com.csc.admin.model.Fabric;

public class FabricDao extends BaseDao {

	public FabricDao(SqlSessionFactory sqlSessionFactory) {
		super(sqlSessionFactory);
	}
	
	public List<Fabric> lstFabric() {
		log.debug("list Fabric...");
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			IFabricMap map = sqlSession.getMapper(IFabricMap.class);
			return map.lstFabric();
		} finally {
			sqlSession.close();
		}
	}

	public Fabric selFabric(Fabric params) {
		log.debug("select Fabric...");
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			IFabricMap map = sqlSession.getMapper(IFabricMap.class);
			return map.selFabric(params);
		} finally {
			sqlSession.close();
		}		
	}
	
	public void updFabric(Fabric params) {
		log.debug("update Fabric...");
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			IFabricMap map = sqlSession.getMapper(IFabricMap.class);
			map.updFabric(params);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
	
	public void insFabric(Fabric params) {
		log.debug("insert Fabric...");
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			IFabricMap map = sqlSession.getMapper(IFabricMap.class);
			map.insFabric(params);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}		
	}
	
	public void delFabric(Fabric params) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			IFabricMap map = sqlSession.getMapper(IFabricMap.class);
			map.delFabric(params);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}		
	}

}
