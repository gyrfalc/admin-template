package com.csc.admin.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.csc.admin.model.AdminCol;
import com.csc.admin.model.AdminRow;

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
				
				AdminRow row = new AdminRow();
				row.setColList(collist);
				
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

}
