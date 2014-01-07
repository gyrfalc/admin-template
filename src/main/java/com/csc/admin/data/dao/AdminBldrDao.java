package com.csc.admin.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.csc.admin.data.DataSource;
import com.csc.admin.model.AdminCol;
import com.csc.admin.model.AdminNotice;
import com.csc.admin.model.AdminParam;
import com.csc.admin.model.AdminTbl;

public class AdminBldrDao implements IAdminBldrDao {

	private static final Logger log = Logger.getLogger(AdminBldrDao.class);

	@Override
	public List<AdminTbl> getTableList() {
		log.debug("get table list...");
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<AdminTbl> list = new ArrayList<AdminTbl>();
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select tbl_nm, dspl_nm, short_desc, view_ind, view_nm, lang_ind, sort_ind");
		sql.append(" from admin_tbl");
		sql.append(" order by dspl_nm");
		
		try {
			conn = DataSource.getInstance().getConnection();
			statement = conn.createStatement();
			log.debug(sql.toString());
			rs = statement.executeQuery(sql.toString());
			
			while (rs.next()) {
				AdminTbl tbl = new AdminTbl();
				
				tbl.setTblNm(rs.getString("tbl_nm"));
				tbl.setDsplNm(rs.getString("dspl_nm"));
				tbl.setShortDesc(rs.getString("short_desc"));
				tbl.setViewInd(rs.getString("view_ind"));
				tbl.setViewNm(rs.getString("view_nm"));
				tbl.setLangInd(rs.getString("lang_ind"));
				tbl.setSortInd(rs.getString("sort_ind"));
								
				list.add(tbl);
			}
			
		} catch (Exception e) {
			log.error("failed to get table list", e);
		} finally {
			if (rs != null) {
				try { rs.close(); } catch (Exception e) {}
			}
			
			if (statement != null) {
				try { statement.close(); } catch (Exception e) {}
			}
			
			if (conn != null) {
				try { conn.close(); } catch (Exception e) {}
			}
		}
		
		return list;
		
	}

	@Override
	public AdminTbl getTable(String tblNm) {
		log.debug("get table for name = " + tblNm);
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		AdminTbl tbl = new AdminTbl();
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select tbl_nm, dspl_nm, short_desc, view_ind, view_nm, lang_ind, sort_ind");
		sql.append(" from admin_tbl");
		sql.append(" where tbl_nm = ?");
		
		try {
			conn = DataSource.getInstance().getConnection();
			statement = conn.prepareStatement(sql.toString());
			statement.setString(1, tblNm);
			log.debug(sql.toString());
			rs = statement.executeQuery();
			
			if (rs.next()) {
				tbl.setTblNm(rs.getString("tbl_nm"));
				tbl.setDsplNm(rs.getString("dspl_nm"));
				tbl.setShortDesc(rs.getString("short_desc"));
				tbl.setViewInd(rs.getString("view_ind"));
				tbl.setViewNm(rs.getString("view_nm"));
				tbl.setLangInd(rs.getString("lang_ind"));
				tbl.setSortInd(rs.getString("sort_ind"));
			}
			
		} catch (Exception e) {
			log.error("failed to get table for name = " + tblNm, e);
		} finally {
			if (rs != null) {
				try { rs.close(); } catch (Exception e) {}
			}
			
			if (statement != null) {
				try { statement.close(); } catch (Exception e) {}
			}
			
			if (conn != null) {
				try { conn.close(); } catch (Exception e) {}
			}
		}
		
		return tbl;
	}

	@Override
	public List<AdminCol> getColList(String tblNm) {
		log.debug("get column list for table = " + tblNm);
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		ArrayList<AdminCol> list = new ArrayList<AdminCol>();
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select tbl_nm, col_nm, dspl_nm, dspl_ord, data_type, sort_ind, sort_ord, sort_dir, srch_ind, key_ind, meta_ind, meta_type, render_type, render_params");
		sql.append(" from admin_col");
		sql.append(" where tbl_nm = ?");
		sql.append(" order by dspl_ord");
		
		try {
			conn = DataSource.getInstance().getConnection();
			statement = conn.prepareStatement(sql.toString());
			statement.setString(1, tblNm);
			log.debug(sql.toString());
			rs = statement.executeQuery();
			
			while (rs.next()) {
				AdminCol col = new AdminCol();
				
				col.setTblNm(rs.getString("tbl_nm"));
				col.setColNm(rs.getString("col_nm"));
				col.setDsplNm(rs.getString("dspl_nm"));
				col.setDsplOrd(rs.getInt("dspl_ord"));
				col.setDataType(rs.getString("data_type"));
				col.setSortInd(rs.getString("sort_ind"));
				col.setSortOrd(rs.getInt("sort_ord"));
				col.setSortDir(rs.getString("sort_dir"));
				col.setSrchInd(rs.getString("srch_ind"));
				col.setKeyInd(rs.getString("key_ind"));
				col.setMetaInd(rs.getString("meta_ind"));
				col.setMetaType(rs.getString("meta_type"));
				col.setRenderType(rs.getString("render_type"));
				col.setRenderParams(rs.getString("render_params"));
				
				list.add(col);
			}
			
		} catch (Exception e) {
			log.error("failed to get column list for table = " + tblNm, e);
		} finally {
			if (rs != null) {
				try { rs.close(); } catch (Exception e) {}
			}
			
			if (statement != null) {
				try { statement.close(); } catch (Exception e) {}
			}
			
			if (conn != null) {
				try { conn.close(); } catch (Exception e) {}
			}
		}
		
		return list;
	}


	@Override
	public List<AdminCol> getColSrchList(String tblNm) {
		log.debug("get column searchlist for table = " + tblNm);
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		ArrayList<AdminCol> list = new ArrayList<AdminCol>();
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select tbl_nm, col_nm, dspl_nm, dspl_ord, data_type, sort_ind, sort_ord, sort_dir, srch_ind, key_ind, meta_ind, meta_type, render_type, render_params");
		sql.append(" from admin_col");
		sql.append(" where tbl_nm = ?");
		sql.append(" and srch_ind = 'Y'");
		sql.append(" order by dspl_ord");
		
		try {
			conn = DataSource.getInstance().getConnection();
			statement = conn.prepareStatement(sql.toString());
			statement.setString(1, tblNm);
			log.debug(sql.toString());
			rs = statement.executeQuery();
			
			while (rs.next()) {
				AdminCol col = new AdminCol();
				
				col.setTblNm(rs.getString("tbl_nm"));
				col.setColNm(rs.getString("col_nm"));
				col.setDsplNm(rs.getString("dspl_nm"));
				col.setDsplOrd(rs.getInt("dspl_ord"));
				col.setDataType(rs.getString("data_type"));
				col.setSortInd(rs.getString("sort_ind"));
				col.setSortOrd(rs.getInt("sort_ord"));
				col.setSortDir(rs.getString("sort_dir"));
				col.setSrchInd(rs.getString("srch_ind"));
				col.setKeyInd(rs.getString("key_ind"));
				col.setMetaInd(rs.getString("meta_ind"));
				col.setMetaType(rs.getString("meta_type"));
				col.setRenderType(rs.getString("render_type"));
				col.setRenderParams(rs.getString("render_params"));
				
				list.add(col);
			}
			
		} catch (Exception e) {
			log.error("failed to get column list for table = " + tblNm, e);
		} finally {
			if (rs != null) {
				try { rs.close(); } catch (Exception e) {}
			}
			
			if (statement != null) {
				try { statement.close(); } catch (Exception e) {}
			}
			
			if (conn != null) {
				try { conn.close(); } catch (Exception e) {}
			}
		}
		
		return list;
	}

	
	@Override
	public List<AdminCol> getColSortList(String tblNm) {
		log.debug("get column sort list for table = " + tblNm);
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		ArrayList<AdminCol> list = new ArrayList<AdminCol>();
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select col_nm, sort_dir");
		sql.append(" from admin_col");
		sql.append(" where tbl_nm = ?");
		sql.append(" and sort_ind = 'Y'");
		sql.append(" order by sort_ord");
		
		try {
			conn = DataSource.getInstance().getConnection();
			statement = conn.prepareStatement(sql.toString());
			statement.setString(1, tblNm);
			log.debug(sql.toString());
			rs = statement.executeQuery();
			
			while (rs.next()) {
				AdminCol col = new AdminCol();
				col.setColNm(rs.getString("col_nm"));
				col.setDataType(rs.getString("sort_dir"));
				list.add(col);
			}
			
		} catch (Exception e) {
			log.error("failed to key columns for table = " + tblNm, e);
		} finally {
			if (rs != null) {
				try { rs.close(); } catch (Exception e) {}
			}
			
			if (statement != null) {
				try { statement.close(); } catch (Exception e) {}
			}
			
			if (conn != null) {
				try { conn.close(); } catch (Exception e) {}
			}
		}
		
		return list;
	}
	
	@Override
	public List<AdminCol> getColKeyList(String tblNm) {
		log.debug("get column key list for table = " + tblNm);
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		ArrayList<AdminCol> list = new ArrayList<AdminCol>();
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select col_nm, data_type");
		sql.append(" from admin_col");
		sql.append(" where tbl_nm = ?");
		sql.append(" and key_ind = 'Y'");
		
		try {
			conn = DataSource.getInstance().getConnection();
			statement = conn.prepareStatement(sql.toString());
			statement.setString(1, tblNm);
			log.debug(sql.toString());
			rs = statement.executeQuery();
			
			while (rs.next()) {
				AdminCol col = new AdminCol();
				col.setColNm(rs.getString("col_nm"));
				col.setDataType(rs.getString("data_type"));
				list.add(col);
			}
			
		} catch (Exception e) {
			log.error("failed to key columns for table = " + tblNm, e);
		} finally {
			if (rs != null) {
				try { rs.close(); } catch (Exception e) {}
			}
			
			if (statement != null) {
				try { statement.close(); } catch (Exception e) {}
			}
			
			if (conn != null) {
				try { conn.close(); } catch (Exception e) {}
			}
		}
		
		return list;
	}

	@Override
	public List<AdminCol> getColMetaList(String tblNm) {
		log.debug("get column meta list for table = " + tblNm);
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		ArrayList<AdminCol> list = new ArrayList<AdminCol>();
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select col_nm, data_type");
		sql.append(" from admin_col");
		sql.append(" where tbl_nm = ?");
		sql.append(" and meta_ind = 'Y'");
		
		try {
			conn = DataSource.getInstance().getConnection();
			statement = conn.prepareStatement(sql.toString());
			statement.setString(1, tblNm);
			log.debug(sql.toString());
			rs = statement.executeQuery();
			
			while (rs.next()) {
				AdminCol col = new AdminCol();
				col.setColNm(rs.getString("col_nm"));
				col.setDataType(rs.getString("data_type"));
				list.add(col);
			}
			
		} catch (Exception e) {
			log.error("failed to meta columns for table = " + tblNm, e);
		} finally {
			if (rs != null) {
				try { rs.close(); } catch (Exception e) {}
			}
			
			if (statement != null) {
				try { statement.close(); } catch (Exception e) {}
			}
			
			if (conn != null) {
				try { conn.close(); } catch (Exception e) {}
			}
		}
		
		return list;
	}

	@Override
	public AdminCol getCol(String tblNm, String colNm) {
		log.debug("get column for table = " + tblNm + " and column = " + colNm);
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		AdminCol col = new AdminCol();
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select tbl_nm, col_nm, dspl_nm, dspl_ord, data_type, sort_ord, sort_dir, srch_ind, key_ind, meta_ind, meta_type, render_type, render_params");
		sql.append(" from admin_col");
		sql.append(" where tbl_nm = ?");
		sql.append(" and col_nm = ?");
		
		try {
			conn = DataSource.getInstance().getConnection();
			statement = conn.prepareStatement(sql.toString());
			statement.setString(1, tblNm);
			statement.setString(2, colNm);
			log.debug(sql.toString());
			rs = statement.executeQuery();
			
			if (rs.next()) {			
				col.setTblNm(rs.getString("tbl_nm"));
				col.setColNm(rs.getString("col_nm"));
				col.setDsplNm(rs.getString("dspl_nm"));
				col.setDsplOrd(rs.getInt("dspl_ord"));
				col.setDataType(rs.getString("data_type"));
				col.setSortOrd(rs.getInt("sort_ord"));
				col.setSortDir(rs.getString("sort_dir"));
				col.setSrchInd(rs.getString("srch_ind"));
				col.setKeyInd(rs.getString("key_ind"));
				col.setMetaInd(rs.getString("meta_ind"));
				col.setMetaType(rs.getString("meta_type"));
				col.setRenderType(rs.getString("render_type"));
				col.setRenderParams(rs.getString("render_params"));
			}
			
		} catch (Exception e) {
			log.error("failed to get column for table = " + tblNm + " and col = " + colNm, e);
		} finally {
			if (rs != null) {
				try { rs.close(); } catch (Exception e) {}
			}
			
			if (statement != null) {
				try { statement.close(); } catch (Exception e) {}
			}
			
			if (conn != null) {
				try { conn.close(); } catch (Exception e) {}
			}
		}
		
		return col;
	}

	@Override
	public AdminParam getAdminParam(String paramNm) {
		log.debug("get admin param for name = " + paramNm);
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdminNotice> getNoticeList() {
		log.debug("get admin notice list");
		// TODO Auto-generated method stub
		return null;
	}

}