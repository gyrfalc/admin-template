package com.csc.admin.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.csc.admin.model.AdminCol;
import com.csc.admin.model.AdminNotice;
import com.csc.admin.model.AdminParam;
import com.csc.admin.model.AdminTbl;
import com.csc.admin.model.ListItem;

public class AdminBldrDao implements IAdminBldrDao {

	private static final Logger log = Logger.getLogger(AdminBldrDao.class);

	@Override
	public List<AdminTbl> getTableList(String tblType) {
		log.debug("get table list...");
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		ArrayList<AdminTbl> list = new ArrayList<AdminTbl>();
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select tbl_nm, dspl_nm, url_nm");
		sql.append(" from admin_tbl");
		sql.append(" where tbl_type = ?");
		sql.append(" order by dspl_nm");
		
		log.debug(sql.toString());
		
		try {
			conn = DataSource.getInstance().getConnection();
			statement = conn.prepareStatement(sql.toString());
			statement.setString(1, tblType);
			rs = statement.executeQuery();
			
			while (rs.next()) {
				AdminTbl tbl = new AdminTbl();
				
				tbl.setTblNm(rs.getString("tbl_nm"));
				tbl.setDsplNm(rs.getString("dspl_nm"));
				tbl.setUrlNm(rs.getString("url_nm"));
								
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
	public AdminTbl getTableForUrl(String urlNm) {
		log.debug("get table for url name = " + urlNm);
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		AdminTbl tbl = new AdminTbl();
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select tbl_nm, tbl_type, dspl_nm, short_desc, view_ind, view_nm, lang_ind, lang_col_nm, sort_ind, url_nm, surrogate_key_nm");
		sql.append(", instr_add, instr_edit, instr_del");
		sql.append(" from admin_tbl");
		sql.append(" where url_nm = ?");
		
		try {
			conn = DataSource.getInstance().getConnection();
			statement = conn.prepareStatement(sql.toString());
			statement.setString(1, urlNm);
			log.debug(sql.toString());
			rs = statement.executeQuery();
			
			if (rs.next()) {
				tbl.setTblNm(rs.getString("tbl_nm"));
				tbl.setTblType(rs.getString("tbl_type"));
				tbl.setDsplNm(rs.getString("dspl_nm"));
				tbl.setShortDesc(rs.getString("short_desc"));
				tbl.setViewInd(rs.getString("view_ind"));
				tbl.setViewNm(rs.getString("view_nm"));
				tbl.setLangInd(rs.getString("lang_ind"));
				tbl.setLangColNm(rs.getString("lang_col_nm"));
				tbl.setSortInd(rs.getString("sort_ind"));
				tbl.setUrlNm(rs.getString("url_nm"));
				tbl.setSurrogateKeyNm(rs.getString("surrogate_key_nm"));
				tbl.setInstrAdd(rs.getString("instr_add"));
				tbl.setInstrEdit(rs.getString("instr_edit"));
				tbl.setInstrDel(rs.getString("instr_del"));
			}
			
		} catch (Exception e) {
			log.error("failed to get table for url name = " + urlNm, e);
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
		sql.append(" select tbl_nm, col_nm, dspl_nm, dspl_ord, data_type, sort_ind, sort_ord, sort_dir, srch_ind, key_ind, req_ind, meta_ind, meta_type, render_type, render_params, col_desc, max_len, dspl_tbl_ind");
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
				col.setReqInd(rs.getString("req_ind"));
				col.setMetaInd(rs.getString("meta_ind"));
				col.setMetaType(rs.getString("meta_type"));
				col.setRenderType(rs.getString("render_type"));
				col.setRenderParams(rs.getString("render_params"));
				col.setColDesc(rs.getString("col_desc"));
				col.setMaxLen(rs.getInt("max_len"));
				col.setDsplTblInd(rs.getString("dspl_tbl_ind"));
				
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
	public List<AdminCol> getColDsplTblList(String tblNm) {
		log.debug("get column display table list for table = " + tblNm);
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		ArrayList<AdminCol> list = new ArrayList<AdminCol>();
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select tbl_nm, col_nm, dspl_nm, dspl_ord, data_type, sort_ind, sort_ord, sort_dir, srch_ind, key_ind, req_ind, meta_ind, meta_type, render_type, render_params, col_desc, max_len, dspl_tbl_ind");
		sql.append(" from admin_col");
		sql.append(" where tbl_nm = ?");
		sql.append(" and dspl_tbl_ind = 'Y'");
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
				col.setReqInd(rs.getString("req_ind"));
				col.setMetaInd(rs.getString("meta_ind"));
				col.setMetaType(rs.getString("meta_type"));
				col.setRenderType(rs.getString("render_type"));
				col.setRenderParams(rs.getString("render_params"));
				col.setColDesc(rs.getString("col_desc"));
				col.setMaxLen(rs.getInt("max_len"));
				col.setDsplTblInd(rs.getString("dspl_tbl_ind"));
				
				list.add(col);
			}
			
		} catch (Exception e) {
			log.error("failed to get column display table list for table = " + tblNm, e);
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
		log.debug("get column search list for table = " + tblNm);
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		ArrayList<AdminCol> list = new ArrayList<AdminCol>();
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select tbl_nm, col_nm, dspl_nm, dspl_ord, data_type, sort_ind, sort_ord, sort_dir, srch_ind, key_ind, req_ind, meta_ind, meta_type, render_type, render_params, col_desc, max_len, dspl_tbl_ind");
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
				col.setReqInd(rs.getString("req_ind"));
				col.setMetaInd(rs.getString("meta_ind"));
				col.setMetaType(rs.getString("meta_type"));
				col.setRenderType(rs.getString("render_type"));
				col.setRenderParams(rs.getString("render_params"));
				col.setColDesc(rs.getString("col_desc"));
				col.setMaxLen(rs.getInt("max_len"));
				col.setDsplTblInd(rs.getString("dspl_tbl_ind"));
				
				list.add(col);
			}
			
		} catch (Exception e) {
			log.error("failed to get column search list for table = " + tblNm, e);
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
		sql.append(" select col_nm, sort_ord, sort_dir");
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
				col.setSortOrd(rs.getInt("sort_ord"));
				col.setSortDir(rs.getString("sort_dir"));
				list.add(col);
			}
			
		} catch (Exception e) {
			log.error("failed to get sort columns for table = " + tblNm, e);
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
	public List<AdminCol> getColUpdList(String tblNm) {
		log.debug("get column update list for table = " + tblNm);
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		ArrayList<AdminCol> list = new ArrayList<AdminCol>();
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select col_nm, dspl_nm, data_type, max_len");
		sql.append(" from admin_col");
		sql.append(" where tbl_nm = ?");
		sql.append(" and key_ind = 'N'");
		sql.append(" and meta_ind = 'N'");
		
		try {
			conn = DataSource.getInstance().getConnection();
			statement = conn.prepareStatement(sql.toString());
			statement.setString(1, tblNm);
			log.debug(sql.toString());
			rs = statement.executeQuery();
			
			while (rs.next()) {
				AdminCol col = new AdminCol();
				col.setColNm(rs.getString("col_nm"));
				col.setDsplNm(rs.getString("dspl_nm"));
				col.setDataType(rs.getString("data_type"));
				col.setMaxLen(rs.getInt("max_len"));
				list.add(col);
			}
			
		} catch (Exception e) {
			log.error("failed to get update columns for table = " + tblNm, e);
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
		sql.append(" order by dspl_ord");
		
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
			log.error("failed to get key columns for table = " + tblNm, e);
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
		sql.append(" select tbl_nm, col_nm, dspl_nm, dspl_ord, data_type, sort_ord, sort_dir, srch_ind, key_ind, req_ind, meta_ind, meta_type, render_type, render_params, col_desc, max_len, dspl_tbl_ind");
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
				col.setReqInd(rs.getString("req_ind"));				
				col.setMetaInd(rs.getString("meta_ind"));
				col.setMetaType(rs.getString("meta_type"));
				col.setRenderType(rs.getString("render_type"));
				col.setRenderParams(rs.getString("render_params"));
				col.setColDesc(rs.getString("col_desc"));
				col.setMaxLen(rs.getInt("max_len"));
				col.setDsplTblInd(rs.getString("dspl_tbl_ind"));
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
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<AdminNotice> list = new ArrayList<AdminNotice>();
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select note_id, note_type, note_msg, note_usr, note_dt ");
		sql.append(" from admin_notice ");
		sql.append(" order by note_dt desc ");
		
		try {
			conn = DataSource.getInstance().getConnection();
			statement = conn.createStatement();
			log.debug(sql.toString());
			rs = statement.executeQuery(sql.toString());
			
			while (rs.next()) {
				AdminNotice note = new AdminNotice();
				note.setNoteId(rs.getLong("note_id"));
				note.setNoteType(rs.getString("note_type"));
				note.setNoteMsg(rs.getString("note_msg"));
				note.setNoteUsr(rs.getInt("note_usr"));
				note.setNoteDt(rs.getDate("note_dt"));
								
				list.add(note);
			}
			
		} catch (Exception e) {
			log.error("failed to get admin notice", e);
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
	public List<ListItem> getList(String listNm, String langCd) {
		log.debug("get list for name = " + listNm);
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		List<ListItem> list = new ArrayList<ListItem>();
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select vw_nm, lang_ind from admin_lst where lst_nm = ?");
		
		try {
			conn = DataSource.getInstance().getConnection();
			statement = conn.prepareStatement(sql.toString());
			statement.setString(1, listNm);
			
			log.debug(sql.toString());
			rs = statement.executeQuery();
			
			if (rs.next()) {
				list = getList(rs.getString(1), rs.getString(2), langCd);
			} else {
				log.error("no list found for listNm = " + listNm);
			}
			
		} catch (Exception e) {
			log.error("failed to get list", e);
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
	public List<ListItem> getList(String listViewNm, String langInd, String langCd) {
		log.debug("get list for name = " + listViewNm);
		boolean useLang = ("Y".equalsIgnoreCase(langInd)) ;
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		ArrayList<ListItem> list = new ArrayList<ListItem>();
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select id, name from ").append(listViewNm);
		if (useLang) {
			sql.append(" where lang_cd = ?");
		}
		
		try {
			conn = DataSource.getInstance().getConnection();
			statement = conn.prepareStatement(sql.toString());
			if (useLang) {
				statement.setString(1, langCd);
			}
			
			log.debug(sql.toString());
			rs = statement.executeQuery();
			
			while (rs.next()) {
				ListItem item = new ListItem();
				item.setId(rs.getString("id"));
				item.setName(rs.getString("name"));
								
				list.add(item);
			}
			
		} catch (Exception e) {
			log.error("failed to get list", e);
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
	
}
