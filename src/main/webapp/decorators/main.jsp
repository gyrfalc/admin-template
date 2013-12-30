<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>

	<%@ include file="/common/meta.jsp" %>

	<title><decorator:title/></title>
	
	<!-- DataTables CSS -->
	<link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">
	<!-- APP CSS -->
	<link rel="stylesheet" type="text/css" media="all" href="<c:url value="/style/app/style.css" />" />
	
	 
	<!-- jQuery -->
	<script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
	 
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