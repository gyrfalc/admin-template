package com.csc.admin.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.csc.admin.model.AdminCol;
import com.csc.admin.model.AdminRow;
import com.csc.admin.util.AdminConstants;

public class SqlRunner {
	private static final Logger log = Logger.getLogger(SqlRunner.class);

	public List<AdminRow> executeListSql(List<AdminCol> cols, String sql) throws Exception {
		log.debug("execute list sql...");
		log.debug(sql);
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<AdminRow> rowlist = new ArrayList<AdminRow>();
		
		try {
			conn = DataSource.getInstance().getConnection();
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				ArrayList<AdminCol> collist = new ArrayList<AdminCol>();
				
				String keyVal = rs.getString(AdminConstants.KEY_NAME);
				
				for (AdminCol col : cols) {
					
					AdminCol mycol = col.clone();
					
					if (col.getDataType().equals("char")) {
						mycol.setValString(rs.getString(col.getColNm()));
					} else if (col.getDataType().equals("int")) {
						mycol.setValInt(rs.getInt(col.getColNm()));
					} else if (col.getDataType().equals("date")) {
						mycol.setValDate(rs.getDate(col.getColNm()));
					} else if (col.getDataType().equals("dbl")) {
						mycol.setValDouble(rs.getDouble(col.getColNm()));
					} else {
						throw new Exception("Invalid column data type: " + col.getDataType());
					}
					
					collist.add(mycol);
				}
				
				AdminRow row = new AdminRow(keyVal, collist);
				
				rowlist.add(row);
				
			}
			
		} catch (Exception e) {
			log.error("failed to execute list SQL", e);
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
		
		return rowlist;
	}
	
	public AdminRow executeSelSql(List<AdminCol> selcols, String sql) {
		log.debug("execute select sql...");
		log.debug(sql);
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		ArrayList<AdminCol> collist = null;
		AdminRow row = null;
		
		try {
			conn = DataSource.getInstance().getConnection();
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			
			
			//should only retrieve one row.  this is not meant as a search
			if (rs.next()) {
				String keyVal = rs.getString(AdminConstants.KEY_NAME);			
				collist = new ArrayList<AdminCol>();
				for (AdminCol col : selcols) {
					AdminCol mycol = col.clone();
					if (col.getDataType().equals("char")) {
						mycol.setValString(rs.getString(col.getColNm()));
					} else if (col.getDataType().equals("int")) {
						mycol.setValInt(rs.getInt(col.getColNm()));
					} else if (col.getDataType().equals("date")) {
						mycol.setValDate(rs.getDate(col.getColNm()));
					} else if (col.getDataType().equals("dbl")) {
						mycol.setValDouble(rs.getDouble(col.getColNm()));
					} else {
						throw new Exception("Invalid column data type: " + col.getDataType());
					}
					collist.add(mycol);
				}
				row = new AdminRow(keyVal, collist);
				
			}
			
			
		} catch (Exception e) {
			log.error("failed to execute select SQL", e);
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
		
		return row;	
	}
	
	public int executeUpdSql(String sql) {
		log.debug("execute update sql...");
		log.debug(sql);
		Connection conn = null;
		Statement statement = null;
		int retcount = 0;
		
		try {
			conn = DataSource.getInstance().getConnection();
			statement = conn.createStatement();
			retcount = statement.executeUpdate(sql);
			
		} catch (Exception e) {
			log.error("failed to execute update SQL", e);
		} finally {

			if (statement != null) {
				try { statement.close(); } catch (Exception e) {}
			}
			
			if (conn != null) {
				try { conn.close(); } catch (Exception e) {}
			}
		}
		
		return retcount;	
	}

}
