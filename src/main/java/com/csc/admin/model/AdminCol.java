package com.csc.admin.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.csc.admin.util.AdminConstants;

public class AdminCol {
	private static final SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	
	/* ================================================================= */
	/* if you add a new property, be sure and add it to the clone method */
	private String tblNm;
	private String colNm;
	private String dsplNm;
	private int dsplOrd;
	private String dataType;
	private String sortInd;
	private int sortOrd;
	private String sortDir;
	private String srchInd;
	private String keyInd;
	private String reqInd;
	private String metaInd;
	private String metaType;
	private String renderType;
	private String renderParams;
	private String colDesc;
	private int maxLen;
	private String dsplTblInd;
	/* if you add a new property, be sure and add it to the clone method */
	/* ================================================================= */
	
	private Date valDate;
	private String valString;
	private Integer valInt;
	private Double valDouble;
	
	private Map<String,String> renderMap;
	private boolean renderMapBuilt = false;
	
	private void buildRenderMap() {
		// render params are expected to be comma separated name-value pairs:
		// name1=val1,name2=val2,...
		if (!renderMapBuilt) {
			renderMap = new HashMap<String,String>();
			
			if (renderParams != null && renderParams.length() > 0) {
				String[] params = renderParams.split(",");
				for (String p : params) {
					String[] pair = p.split("=");
					renderMap.put(pair[0].trim(), pair[1].trim());
				}
			}
			
			renderMapBuilt = true;
		}
	}
	
	public String getCssClass() {
		buildRenderMap();
		if (renderMap.containsKey(AdminConstants.RENDER_PARAM_CSS_CLASS)) { return renderMap.get(AdminConstants.RENDER_PARAM_CSS_CLASS); }
		else return "";
	}
	public String getCssStyle() {
		buildRenderMap();
		if (renderMap.containsKey(AdminConstants.RENDER_PARAM_CSS_STYLE)) { return renderMap.get(AdminConstants.RENDER_PARAM_CSS_STYLE); }
		else return "";
		
	}
	public String getDflt() {
		buildRenderMap();
		if (renderMap.containsKey(AdminConstants.RENDER_PARAM_DFLT)) { return renderMap.get(AdminConstants.RENDER_PARAM_DFLT); }
		else return null;
	}
	public String getDfltVal() {
		buildRenderMap();
		if (renderMap.containsKey(AdminConstants.RENDER_PARAM_DFLT_VAL)) { return renderMap.get(AdminConstants.RENDER_PARAM_DFLT_VAL); }
		else return "";		
	}
	public boolean isKey() {
		return "Y".equalsIgnoreCase(this.keyInd);
	}
	public boolean isMeta() {
		return "Y".equalsIgnoreCase(this.metaInd);
	}
	public boolean isHtml() {
		buildRenderMap();
		return (renderMap.containsKey(AdminConstants.RENDER_PARAM_HTML));
	}
	public boolean isList() {
		return AdminConstants.RENDER_TYPE_LIST.equals(this.renderType);
	}
	public String getListNm() {
		buildRenderMap();
		return (renderMap.get(AdminConstants.RENDER_PARAM_LIST_NM));
	}
	public boolean isReq() {
		return "Y".equalsIgnoreCase(this.reqInd);
	}
	
	public String buildWhereClause() {
		if (dataType.equals(AdminConstants.DATA_TYPE_STRING)) { return colNm + " = '" + valString + "'"; }
		else if (dataType.equals(AdminConstants.DATA_TYPE_DATE)) { return colNm + " = '" + formatter.format(valDate) + "'"; }
		else if (dataType.equals(AdminConstants.DATA_TYPE_INT)) { return colNm + " = " + valInt.toString(); }
		else if (dataType.equals(AdminConstants.DATA_TYPE_DBL)) { return colNm + " = " + valDouble.toString(); }
		else return null;		
	}
	
	public String getVal() {
		if (dataType.equals(AdminConstants.DATA_TYPE_STRING)) { return valString; }
		else if (dataType.equals(AdminConstants.DATA_TYPE_DATE)) { 
			return formatter.format(valDate); 
		}
		else if (dataType.equals(AdminConstants.DATA_TYPE_INT)) { return valInt.toString(); }
		else if (dataType.equals(AdminConstants.DATA_TYPE_DBL)) { return valDouble.toString(); }
		else return null;
	}
	
	public void setVal(Integer val) { valInt = val;	}
	public void setVal(Double val) { valDouble = val; }
	public void setVal(Date val) { valDate = val; }
	
	
	public void setVal(String val) {
		if (dataType.equals(AdminConstants.DATA_TYPE_STRING)) { valString = val; }
		else if (dataType.equals(AdminConstants.DATA_TYPE_DATE)) { 
			try {
				valDate = formatter.parse(val);
			} catch (ParseException e) {
				valDate = null;
			}
		}
		else if (dataType.equals(AdminConstants.DATA_TYPE_INT)) { valInt = new Integer(val); }
		else if (dataType.equals(AdminConstants.DATA_TYPE_DBL)) { valDouble = new Double(val); }
		
	}
	
	public AdminCol clone() {
		AdminCol col = new AdminCol();
		col.setTblNm(this.getTblNm());
		col.setColNm(this.getColNm());
		col.setDsplNm(this.getDsplNm());
		col.setDsplOrd(this.getDsplOrd());
		col.setDataType(this.getDataType());
		col.setSortInd(this.getSortInd());
		col.setSortOrd(this.getSortOrd());
		col.setSortDir(this.getSortDir());
		col.setSrchInd(this.getSrchInd());
		col.setKeyInd(this.getKeyInd());
		col.setReqInd(this.getReqInd());
		col.setMetaInd(this.getMetaInd());
		col.setMetaType(this.getMetaType());
		col.setRenderType(this.getRenderType());
		col.setRenderParams(this.getRenderParams());
		col.setColDesc(this.getColDesc());
		col.setMaxLen(this.getMaxLen());
		col.setDsplTblInd(this.getDsplTblInd());
		return col;
	}
	
	public String getTblNm() {
		return tblNm;
	}
	public void setTblNm(String tblNm) {
		this.tblNm = tblNm;
	}
	public String getColNm() {
		return colNm;
	}
	public void setColNm(String colNm) {
		this.colNm = colNm;
	}
	public String getDsplNm() {
		return dsplNm;
	}
	public void setDsplNm(String dsplNm) {
		this.dsplNm = dsplNm;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public int getSortOrd() {
		return sortOrd;
	}
	public void setSortOrd(int sortOrd) {
		this.sortOrd = sortOrd;
	}
	public String getSortDir() {
		return sortDir;
	}
	public void setSortDir(String sortDir) {
		this.sortDir = sortDir;
	}
	public String getKeyInd() {
		return keyInd;
	}
	public void setKeyInd(String keyInd) {
		this.keyInd = keyInd;
	}
	public String getMetaInd() {
		return metaInd;
	}
	public void setMetaInd(String metaInd) {
		this.metaInd = metaInd;
	}
	public String getMetaType() {
		return metaType;
	}
	public void setMetaType(String metaType) {
		this.metaType = metaType;
	}
	public int getDsplOrd() {
		return dsplOrd;
	}
	public void setDsplOrd(int dsplOrd) {
		this.dsplOrd = dsplOrd;
	}
	public String getSrchInd() {
		return srchInd;
	}
	public void setSrchInd(String srchInd) {
		this.srchInd = srchInd;
	}
	public String getSortInd() {
		return sortInd;
	}
	public void setSortInd(String sortInd) {
		this.sortInd = sortInd;
	}
	public String getRenderType() {
		return renderType;
	}
	public void setRenderType(String renderType) {
		this.renderType = renderType;
	}
	public String getRenderParams() {
		return renderParams;
	}
	public void setRenderParams(String renderParams) {
		this.renderParams = renderParams;
	}
	public Date getValDate() {
		return valDate;
	}
	public void setValDate(Date valDate) {
		this.valDate = valDate;
	}
	public String getValString() {
		return valString;
	}
	public void setValString(String valString) {
		this.valString = valString;
	}
	public Integer getValInt() {
		return valInt;
	}
	public void setValInt(Integer valInt) {
		this.valInt = valInt;
	}
	public Double getValDouble() {
		return valDouble;
	}
	public void setValDouble(Double valDouble) {
		this.valDouble = valDouble;
	}

	public String getColDesc() {
		return colDesc;
	}

	public void setColDesc(String colDesc) {
		this.colDesc = colDesc;
	}

	public int getMaxLen() {
		return maxLen;
	}

	public void setMaxLen(int maxLen) {
		this.maxLen = maxLen;
	}

	public String getDsplTblInd() {
		return dsplTblInd;
	}

	public void setDsplTblInd(String dsplTblInd) {
		this.dsplTblInd = dsplTblInd;
	}

	public String getReqInd() {
		return reqInd;
	}

	public void setReqInd(String reqInd) {
		this.reqInd = reqInd;
	}
}
