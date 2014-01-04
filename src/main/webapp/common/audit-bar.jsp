<%@ include file="/common/taglibs.jsp"%>

	<div class="audit-bar">
		<label>Last Modified:</label>&nbsp;<s:property value="model.modDt" escape="false"/>	
		&nbsp;&nbsp;
		<label>By:</label>&nbsp;<s:property value="model.modByNm" escape="false"/>	
		&nbsp;&nbsp;&nbsp;&nbsp;
		<label>Status:</label>&nbsp;<s:property value="model.pubStatNm" escape="false"/>
		&nbsp;&nbsp;
		<label>Last Publication:</label>&nbsp;<s:property value="model.pubDt" escape="false"/>	
	</div>