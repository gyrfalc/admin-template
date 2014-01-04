<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>Fabric</title>
	
</head>
<body>
	<s:url id="baseURL" value="/fabricfamily" includeParams="none"/>
	<jsp:include page="/common/page-header.jsp"/>	

	<jsp:include page="/common/table-list.jsp"/>	
		
	<div class="content">
	<h3 class="page-caption">Fabric</h3>
	<jsp:include page="/common/audit-bar.jsp"/>	
	<ul class="menu-layout">
		<li><a href="${baseURL}/list">list</a></li>	
		<li><a href="${baseURL}/new">new</a></li>	
		<li><a href="${baseURL}/edit/${model.id}">edit</a></li>	
		<li><a href="#" onclick="confirmDelete(); return false;">delete</a></li>	
	</ul>
	
	<s:if test="hasActionMessages()">
	   <div class="action-message">
	      <s:actionmessage/>
	   </div>
	</s:if>
	
	<s:if test="hasActionErrors()">
		<div class="action-error">
			<s:actionerror/>
		</div>
	</s:if>	
	
	<div class="sub-content">
	<table class="form-layout">
		<tr><td class="label">Code</td><td> <s:property value="model.fabricFamilyCd" escape="false"/></td></tr>
		<tr><td class="label">Name</td><td> <s:property value="model.fabricFamilyNm" escape="false"/></td></tr>
		<tr><td class="label">Description</td><td> <s:property value="model.fabricFamilyDesc" escape="false"/></td></tr>
		<tr><td class="label">Mod By</td><td> <s:property value="model.modByNm" escape="false"/></td></tr>
		<tr><td class="label">Mod Date</td><td> <s:property value="model.modDt" escape="false"/></td></tr>
	
	</table>
	</div>
	</div>

	<form id="frmDel" action="${baseURL}/del" method="post">
		<input type="hidden" name="id" value="${model.id}" />
	</form>

	<script type="text/javascript">
	
		function confirmDelete() {
			 var r=confirm("This record will be permanently removed. Continue?");
			 if (r==true)
			   {
			   		document.forms[0].submit();
			   }
		}
		
	</script>

</body>
</html>