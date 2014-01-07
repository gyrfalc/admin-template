package com.csc.admin.data;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.csc.admin.data.dao.AdminBldrDao;
import com.csc.admin.model.AdminCol;
import com.csc.admin.model.AdminTbl;

public class SqlBuilder {

	private AdminBldrDao dao = new AdminBldrDao();
	private static final Logger log = Logger.getLogger(SqlBuilder.class);
	
	public String buildTblSrchSql(String tblNm) {
		AdminTbl tbl = dao.getTable(tblNm);
		return buildTblSrchSql(tbl);
	}
	
	public String buildTblSrchSql(AdminTbl tbl) {
		log.debug("build search sql for table = " + tbl.getTblNm() );
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select ");
		
		List<AdminCol> collist = dao.getColSrchList(tbl.getTblNm());
		boolean first = true;
		for (AdminCol col : collist) {
			if (!first) { sql.append(", "); }
			first = false;
			sql.append(col.getColNm());
		}
		
		if (tbl.hasView()) {
			sql.append(" from ").append(tbl.getViewNm());
		} else {
			sql.append(" from ").append(tbl.getTblNm());
		}
		
		if (tbl.hasSortCols()) {
			List<AdminCol> sortlist = dao.getColSortList(tbl.getTblNm());
			sql.append(" order by ");
			boolean sortfirst = true;
			for (AdminCol sc : sortlist) {
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

}
