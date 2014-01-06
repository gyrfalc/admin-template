<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>Fabric</title>

	<script type="text/javascript">
		
		function submitForm() {
			document.forms[0].submit();
		}
	
	</script>

</head>
<body>
	<s:url id="baseURL" value="/fabric" includeParams="none"/>
	<jsp:include page="/common/page-header.jsp"/>	
	<jsp:include page="/common/table-list.jsp"/>	
	<jsp:include page="/common/instructions.jsp"/>	
	
	<div class="content">
		<h3 class="page-caption">Fabric Family (New)</h3>
		<jsp:include page="/common/menu-add.jsp"/>	

	
		<div id="div-form-editor" class="sub-content">
			<form action="${baseURL}/ins" method="post">
				<jsp:include page="/common/clone-lang.jsp"/>	
			
				<ul class="form-layout">
					<li><label>Code <span class="required">*</span></label> <s:textfield name="model.fabricFamilyCd" cssClass="small"/>&nbsp;<span class="field-info">Text(10)</span></li>
					<li><label>Name <span class="required">*</span></label> <s:textfield name="model.fabricFamilyNm" cssClass="large"/>&nbsp;<span class="field-info">Text(100)</span></li>
					<li><label>Description <span class="required">*</span></label> <s:textarea id="fld-fabricDesc" name="model.fabricFamilyDesc" />&nbsp;<span class="field-info">Text(255)</span> </li>			
				</ul>
				
			</form>
		</div>
	</div>
</body>
</html>