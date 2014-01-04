<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>Fabric</title>
	
</head>
<body>
	<s:url id="baseURL" value="/fabric" includeParams="none"/>
	<jsp:include page="/common/page-header.jsp"/>	
	<jsp:include page="/common/table-list.jsp" />
	
	<div class="content">
		<h3 class="page-caption">Fabric</h3>
		<jsp:include page="/common/audit-bar.jsp"/>	
		<jsp:include page="/common/menu-view.jsp"/>	

	
		<div class="sub-content">
			<table class="form-layout">
				<tr><td class="label">Code</td><td> <s:property value="model.fabricCd" escape="false"/></td></tr>
				<tr><td class="label">Name</td><td> <s:property value="model.fabricNm" escape="false"/></td></tr>
				<tr><td class="label">Description</td><td> <s:property value="model.fabricDesc" escape="false"/></td></tr>
				<tr><td class="label">Family</td><td> <s:property value="model.fabricFamilyCd" escape="false"/></td></tr>
				<tr><td class="label">Mod By</td><td> <s:property value="model.modByNm" escape="false"/></td></tr>
				<tr><td class="label">Mod Date</td><td> </td></tr>
			
			</table>
		</div>
	</div>


</body>
</html>