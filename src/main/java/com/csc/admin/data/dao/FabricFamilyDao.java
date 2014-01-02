package com.csc.admin.data.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.csc.admin.data.map.IFabricFamilyMap;
import com.csc.admin.model.FabricFamily;

public class FabricFamilyDao extends BaseDao {

	public FabricFamilyDao(SqlSessionFactory sqlSessionFactory) {
		super(sqlSessionFactory);
	}
	
	public List<FabricFamily> lstFabricFamily() {
		log.debug("list FabricFamily...");
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			IFabricFamilyMap map = sqlSession.getMapper(IFabricFamilyMap.class);
			return map.lstFabricFamily();
		} finally {
			sqlSession.close();
		}
	}

	public FabricFamily selFabricFamily(FabricFamily params) {
		log.debug("select FabricFamily...");
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			IFabricFamilyMap map = sqlSession.getMapper(IFabricFamilyMap.class);
			return map.selFabricFamily(params);
		} finally {
			sqlSession.close();
		}		
	}
	
	public void updFabricFamily(FabricFamily params) {
		log.debug("update FabricFamily...");
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			IFabricFamilyMap map = sqlSession.getMapper(IFabricFamilyMap.class);
			map.updFabricFamily(params);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
	
	public void insFabricFamily(FabricFamily params) {
		log.debug("insert FabricFamily...");
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			IFabricFamilyMap map = sqlSession.getMapper(IFabricFamilyMap.class);
			map.insFabricFamily(params);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}		
	}
	
	public void delFabricFamily(FabricFamily params) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			IFabricFamilyMap map = sqlSession.getMapper(IFabricFamilyMap.class);
			map.delFabricFamily(params);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}		
	}

}
