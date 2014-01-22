package com.csc.admin.data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.csc.admin.model.AdminCol;
import com.csc.admin.model.AdminTbl;
import com.csc.admin.util.AdminConstants;

public class SqlBuilder {

	private static final Logger log = Logger.getLogger(SqlBuilder.class);
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy");
	
	public String buildListSql(AdminTbl tbl, List<AdminCol> selcols, List<AdminCol> sortcols, String langCd) {
		return buildListSql(tbl, selcols, sortcols, langCd, null);
	}
	
	public String buildListSql(AdminTbl tbl, List<AdminCol> selcols, List<AdminCol> sortcols, String langCd, String customWhere) {
		log.debug("build list sql for table = " + tbl.getTblNm() );
		
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
			
			if (customWhere != null && customWhere.length() > 0) {
				sql.append(" and ").append(customWhere);
			}
		} else {
			if (customWhere != null && customWhere.length() > 0) {
				sql.append(" where ").append(customWhere);
			}
			
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
	
	private void parseKeyVals(String keyval, List<AdminCol> keycols) {
		log.debug("parseKeyVals for key = " + keyval);
		// assign the key value
		// if we have more than one key, the key val is delimited and must be split
		// data type handling is done in the AdminCol object
		if (keycols.size() > 1) {
			String[] keyvals = keyval.split(AdminConstants.KEY_DELIMITER);
			for (int i = 0; i < keycols.size(); i++ ) {
				keycols.get(i).setVal(keyvals[i]);
			}
		} else {
			keycols.get(0).setVal(keyval);
		}
						
	}
	

	public String buildSelSql(AdminTbl tbl, String keyval, List<AdminCol> selcols, List<AdminCol> keycols, String langCd) {
		log.debug("build select sql for table = " + tbl.getTblNm() );
		
		parseKeyVals(keyval, keycols);
		

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
			String keyval,
			List<AdminCol> updcols, 
			List<AdminCol> metacols, 
			List<AdminCol> keycols, 
			Map<String,String[]> data,
			String userId,
			String langCd) 
	{
		StringBuilder sql = new StringBuilder();
		
		//build the update set clause for editable fields
		sql.append(" update ").append(tbl.getTblNm()).append(" set ");
		boolean first = true;
		for (AdminCol u : updcols) {
			if (!first) { sql.append(", "); }
			sql.append(u.getColNm()).append(" = ").append(buildColVal(data.get(u.getColNm())[0], u.getDataType()));
			first = false;
		}
		// set the metadata fields
		for (AdminCol m : metacols) {
			if (AdminConstants.META_TYPE_UPD_USER.equals(m.getMetaType())) {
				sql.append(", ").append(m.getColNm()).append(" = ").append(buildColVal(userId, m.getDataType()));
			}
			else if (AdminConstants.META_TYPE_UPD_DT.equals(m.getMetaType())) {
				sql.append(", ").append(m.getColNm()).append(" = ").append(buildColVal(DATE_FORMAT.format(new Date()), AdminConstants.DATA_TYPE_STRING));
			} 
		}
		
		// add the where clause
		parseKeyVals(keyval, keycols);
		sql.append(" where ");
		first = true;
		for (AdminCol k : keycols) {
			if (!first) { sql.append(" and "); }
			sql.append(k.buildWhereClause());
			first = false;
		}
		
		// add language 
		if (tbl.hasLang()) {
			sql.append(" and ").append(tbl.getLangColNm()).append(" = '").append(langCd).append("'");
		}
		
		return sql.toString();
	}
	
	public String buildInsSql(
			AdminTbl tbl, 
			List<AdminCol> inscols, 
			Map<String,String[]> data,
			String userId,
			String langCd) 
	{
		StringBuilder sql = new StringBuilder();
		
		//TODO need to handle auto-generated keys
		
		//build the insert set clause for all fields
		sql.append(" insert into ").append(tbl.getTblNm()).append(" (");
		boolean first = true;
		for (AdminCol i : inscols) {
			if (!first) { sql.append(", "); }
			sql.append(i.getColNm());
			first = false;
		}
		sql.append(" ) values (");
		first = true;
		for (AdminCol i : inscols) {
			if (!first) { sql.append(", "); }
			if (i.isMeta()) {
				if (AdminConstants.META_TYPE_LANG.equals(i.getMetaType())) {
					sql.append(buildColVal(langCd, i.getDataType()));
				}
				else if (AdminConstants.META_TYPE_INS_USER.equals(i.getMetaType())) {
					sql.append(buildColVal(userId, i.getDataType()));
				} 
				else if (AdminConstants.META_TYPE_UPD_USER.equals(i.getMetaType())) {
					sql.append(buildColVal(userId, i.getDataType()));
				}
				else if (AdminConstants.META_TYPE_INS_DT.equals(i.getMetaType())) {
					sql.append(buildColVal(DATE_FORMAT.format(new Date()), AdminConstants.DATA_TYPE_STRING));
				}
				else if (AdminConstants.META_TYPE_UPD_DT.equals(i.getMetaType())) {
					sql.append(buildColVal(DATE_FORMAT.format(new Date()), AdminConstants.DATA_TYPE_STRING));
				} else {
					sql.append("null");
				}
			} else {
				sql.append(buildColVal(data.get(i.getColNm())[0], i.getDataType()));
			}
			
			first = false;
		}
		sql.append(")");
		
		return sql.toString();
		

	}	
	
	public String buildDelSql(AdminTbl tbl, List<AdminCol> keycols, String key) {
		StringBuilder sql = new StringBuilder();
		
		sql.append("delete from ").append(tbl.getTblNm());
		sql.append(" where ");
		if (keycols.size() > 1) {
			String[] keyvals = key.split(AdminConstants.KEY_DELIMITER);
			for (int i=0; i<keycols.size(); i++) {
				AdminCol keycol = keycols.get(i);
				if (i > 0) {
					sql.append(" and ");
				}
				sql.append(keycol.getColNm()).append(" = ").append(buildColVal(keyvals[i],keycol.getDataType()));
			}
						
		} else {
			AdminCol keycol = keycols.get(0);
			sql.append(keycol.getColNm()).append(" = ").append(buildColVal(key,keycol.getDataType()));
		}

		return sql.toString();
	}
	
	
	private String buildColQry(String name, String val, String dataType, String renderType) {
		String retval = null;
		if (AdminConstants.DATA_TYPE_STRING.equals(dataType)) {
			if (AdminConstants.RENDER_TYPE_LIST.equalsIgnoreCase(renderType)) {
				retval = name + " = '" + val + "'";
			} else {
				String srchstr = val.trim().toLowerCase();
				retval = "lower(" + name + ") like '%" + srchstr + "%'";
			}
			
		} else {
			retval = name + " = " + val;
		}
		return retval;
	}
	
	public String buildSearchSql(
			AdminTbl tbl, 
			List<AdminCol> selcols, 
			List<AdminCol> sortcols, 
			List<AdminCol> srchcols, 
			Map<String,String[]> data,
			String langCd ) 
	{
		StringBuilder sql = new StringBuilder();
		
		sql.append(" (");
		boolean first = true;
		for (AdminCol q : srchcols) 
		{
			if (data.containsKey(q.getColNm())) {
				String val = data.get(q.getColNm())[0];
				if (val != null && val.trim().length() > 0) {
					if (!first) { sql.append(" and "); }
					sql.append(buildColQry(q.getColNm(),val,q.getDataType(),q.getRenderType()));
					first = false;		
				}
						
			}

		}
		
		sql.append(") ");
		return buildListSql(tbl, selcols, sortcols, langCd, sql.toString());
	}

	public String buildIncrementSql(AdminTbl tbl, AdminCol col) {
		log.debug("build increment sql...");
		StringBuilder sql = new StringBuilder();
		
		sql.append("select max(").append(col.getColNm()).append(") + 1 from ").append(tbl.getTblNm());
		
		return sql.toString();
	}
	
	public String buildSequenceSql(String seqNm) {
		log.debug("build sequence sql...");
		
		return "select " + seqNm + ".nextval from dual";
	}
}

