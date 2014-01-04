package com.csc.admin.data.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.csc.admin.data.map.IAdminMap;
import com.csc.admin.model.AdminNotice;
import com.csc.admin.model.ListItem;

public class AdminDao extends BaseDao {

	public AdminDao(SqlSessionFactory sqlSessionFactory) {
		super(sqlSessionFactory);
	}
	
	
	public List<AdminNotice> lstAdminNotice() {
		log.debug("list AdminNotice...");
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			IAdminMap map = sqlSession.getMapper(IAdminMap.class);
			return map.lstAdminNotice();
		} finally {
			sqlSession.close();
		}
	}

	public AdminNotice selAdminNotice(AdminNotice params) {
		log.debug("select AdminNotice...");
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			IAdminMap map = sqlSession.getMapper(IAdminMap.class);
			return map.selAdminNotice(params);
		} finally {
			sqlSession.close();
		}		
	}
	
	public void insAdminNotice(AdminNotice params) {
		log.debug("insert AdminNotice...");
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			IAdminMap map = sqlSession.getMapper(IAdminMap.class);
			map.insAdminNotice(params);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}		
	}
	
	public void delAdminNotice(AdminNotice params) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			IAdminMap map = sqlSession.getMapper(IAdminMap.class);
			map.delAdminNotice(params);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}		
	}
	
	public List<ListItem> selList(String viewNm) {
		log.debug("selecting list items for view " + viewNm);
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			IAdminMap map = sqlSession.getMapper(IAdminMap.class);
			return map.selList(viewNm);
		} finally {
			sqlSession.close();
		}				
	}

	public String selLangNm(String langCd) {
		log.debug("selecting lang name for code = " + langCd);
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			IAdminMap map = sqlSession.getMapper(IAdminMap.class);
			return map.selLangNm(langCd);
		} finally {
			sqlSession.close();
		}				
	}
}
