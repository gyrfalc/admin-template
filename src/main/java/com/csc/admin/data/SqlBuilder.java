package com.csc.admin.data;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.csc.admin.model.AdminCol;
import com.csc.admin.model.AdminTbl;
import com.csc.admin.util.AdminConstants;

public class SqlBuilder {

	private static final Logger log = Logger.getLogger(SqlBuilder.class);
	
	
	public String buildRowListSql(AdminTbl tbl, List<AdminCol> selcols, List<AdminCol> sortcols, String langCd) {
		log.debug("build row list sql for table = " + tbl.getTblNm() );
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select ").append(tbl.getSurrogateKeyNm()).append(" as id");
		
		for (AdminCol col : selcols) {
			sql.append(", "); 
			sql.append(col.getColNm());
		}
		
		if (tbl.hasView()) {
			sql.append(" from ").append(tbl.getViewNm());
		} else {
			sql.append(" from ").append(tbl.getTblNm());
		}
		
		if (tbl.hasLang()) {
			sql.append(" where ");
			sql.append(tbl.getLangColNm());
			sql.append(" = '").append(langCd).append("'");
		}
		
		if (tbl.hasSortCols()) {
			sql.append(" order by ");
			boolean sortfirst = true;
			for (AdminCol sc : sortcols) {
				if (!sortfirst) {sql.append(", ");}
				sortfirst = false;
				sql.append(sc.getColNm());
				if (StringUtils.isNotEmpty(sc.getSortDir())) {
					sql.append(" " + sc.getSortDir());
				}
			}
		}
		
		return sql.toString();
		
	}
	

	public String buildSelSql(AdminTbl tbl, String keyVal, List<AdminCol> selcols, List<AdminCol> keycols, String langCd) {
		log.debug("build select sql for table = " + tbl.getTblNm() );
		
		// assign the key value
		// if we have more than one key, the key val is delimited and must be split
		// data type handling is done in the AdminCol object
		if (keycols.size() > 1) {
			String[] keyvals = keyVal.split(AdminConstants.KEY_DELIMITER);
			for (int i = 0; i < keycols.size(); i++ ) {
				keycols.get(i).setVal(keyvals[i]);
			}
		} else {
			keycols.get(0).setVal(keyVal);
		}
				
		StringBuilder sql = new StringBuilder();
		sql.append(" select ").append(tbl.getSurrogateKeyNm()).append(" as id");
		
		
		for (AdminCol col : selcols) {
			sql.append(", "); 
			sql.append(col.getColNm());
		}
		
		if (tbl.hasView()) {
			sql.append(" from ").append(tbl.getViewNm());
		} else {
			sql.append(" from ").append(tbl.getTblNm());
		}
		
		// build where clause
		sql.append(" where ");
		boolean first = true;
		for (AdminCol c : keycols) {
				if (!first) { sql.append(" and "); }
				sql.append(c.buildWhereClause());
				first = false;
		}
		
		if (tbl.hasLang()) {
			sql.append(" and ");
			sql.append(tbl.getLangColNm());
			sql.append(" = '").append(langCd).append("'");
		}
		

		
		return sql.toString();
			
		
	}
	
	private String buildColVal(String val, String dataType) {
		String retval = null;
		if (AdminConstants.DATA_TYPE_STRING.equals(dataType)) {
			retval = "'" + val + "'";
		} else {
			retval = val;
		}
		return retval;
	}
	
	public String buildUpdSql(
			AdminTbl tbl, 
			List<AdminCol> updcols, 
			List<AdminCol> metacols, 
			List<AdminCol> keycols, 
			Map<String,String> data,
			String userId) 
	{
		StringBuilder sql = new StringBuilder();
		
		//build the update set clause for editable fields
		sql.append(" update ").append(tbl.getTblNm()).append(" set ");
		boolean first = true;
		for (AdminCol u : updcols) {
			if (!first) { sql.append(", "); }
			sql.append(u.getColNm()).append(" = ").append(buildColVal(data.get(u.getColNm()), u.getDataType()));
			first = false;
		}
		// set the metadata fields
		for (AdminCol m : metacols) {
			if (AdminConstants.META_TYPE_UPD_USER.equals(m.getMetaType())) {
				if (AdminConstants.DATA_TYPE_STRING.equals(m.getDataType())) {
					sql.append(", ").append(m.getColNm()).append(" = '").append(userId).append("'");
				} else {
					sql.append(", ").append(m.getColNm()).append(" = ").append(userId);
				}
				
			}
		}
		
		// add the where clause
		
		
		return sql.toString();
	}

}
