<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>

	<%@ include file="/common/meta.jsp" %>

	<title><decorator:title/></title>
	<link rel="icon" href="<s:url value="/images/database_edit.png" includeParams="false" />" type="image/png" />
	
	<!-- DataTables CSS -->
	<link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">
	<!-- APP CSS -->
	<link rel="stylesheet" type="text/css" media="all" href="<s:url value="/style/admin.css"  includeParams="false" />" />
	
	 
	<!-- jQuery -->
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
	<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>	
	 
	<!-- DataTables -->
	<script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>	
		
	<script type="text/javascript">
	
		function showPreview(containerId) {
			$("#div-preview").html($(containerId).val());
			$("#div-preview").dialog({"title":"HTML Preview"});
		}
	
	</script>

	<decorator:head/>
</head>
<body<decorator:getProperty property="body.id" writeEntireProperty="true"/><decorator:getProperty property="body.class" writeEntireProperty="true"/>>

	<jsp:include page="/common/header.jsp"/>	
	
	<decorator:body/>

	<jsp:include page="/common/footer.jsp"/>
	
</body>
</html>