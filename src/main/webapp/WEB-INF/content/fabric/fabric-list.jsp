<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<title>Fabric</title>
</head>
<body>
	<s:url id="baseURL" value="/fabric" includeParams="none"/>
	<jsp:include page="/common/page-header.jsp"/>	
	
	<table style="border-collapse: collapse; width: 100%;"><tr>
	<td style="vertical-align:top; width: 220px">
		<jsp:include page="/common/table-list.jsp"/>	
	</td>
	<td style="vertical-align: top">
		<div class="content" style="margin: 0">
			<h3 class="page-caption">Fabric Index</h3>
			<jsp:include page="/common/menu-list.jsp"/>	

			<div class="sub-content">
			<display:table id="model-list" name="modelList" decorator="com.csc.admin.decorator.LinkDecorator">
				  <display:column property="id" title="Code"  />
				  <display:column property="fabricNm" title="Name"/>
				  <display:column property="fabricDesc" title="Description" />
				  <display:column property="fabricFamilyCd" title="Family" />
				  <display:column property="modBy" title="Mod By"/>
				  <display:column property="modDt" title="Mod Date"/>
			</display:table>
			</div>
		</div>
	</td>
	</tr></table>
	
	<script type="text/javascript">
		$(document).ready(function(){
			  $('#model-list').dataTable();
			});	
	
	</script>
	
</body>
</html>