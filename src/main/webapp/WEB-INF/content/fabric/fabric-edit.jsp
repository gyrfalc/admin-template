<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>Fabric</title>
	
	<script src="<c:url value="/ckeditor/ckeditor.js" />"></script>
	<script src="<c:url value="/ckeditor/adapters/jquery.js" />"></script>
	

	<script type="text/javascript">
	
		function resetForm() {
			document.forms[0].reset();
		}
		
		function submitForm() {
			document.forms[0].submit();
		}
	
	</script>	
</head>
<body>
	<s:url id="baseURL" value="/fabric" includeParams="none"/>
	<jsp:include page="/common/page-header.jsp"/>	
	<jsp:include page="/common/table-list.jsp"/>	
	<jsp:include page="/common/instructions.jsp" />
	
	<div class="content">
		<h3 class="page-caption">Fabric (Edit)</h3>
		<jsp:include page="/common/audit-bar.jsp"/>	
		<jsp:include page="/common/menu-edit.jsp"/>	

		<div id="div-form-editor" class="sub-content">
			<form action="${baseURL}/upd" method="post">
				<ul class="form-layout">
					<li><label>Code <span class="required">*</span></label> <s:property value="model.fabricCd"/>&nbsp;<s:hidden name="model.fabricCd" /> </li>
					<li><label>Name <span class="required">*</span></label> <s:textfield name="model.fabricNm" cssClass="large"/>&nbsp;<span class="field-info">Text(100)</span></li>
					<li><label>Description <span class="required">*</span></label> <s:textarea id="fld-fabricDesc" name="model.fabricDesc" />
						&nbsp;<a href="#" onclick="showEditor('#fld-fabricDesc');return false;">HTML</a>
						&nbsp;<span class="field-info">Text(255)</span> </li>
					<li><label>Family <span class="required">*</span></label> 
						<s:select name="model.fabricFamilyCd" list="lstFabricFamilyCd" listKey="id" listValue="name" cssClass="large" />
					 </li>
				
				</ul>
			</form>
		</div>
		
		<jsp:include page="/common/text-edit.jsp"/>

		
	</div>


</body>
</html>