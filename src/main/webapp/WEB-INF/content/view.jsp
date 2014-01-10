<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<title>${tbl.dsplNm} - View</title>
</head>
<body>
	<jsp:include page="/common/page-header.jsp"/>	
	
	<table style="border-collapse: collapse; width: 100%;"><tr>
	<td class="table-list">
		<jsp:include page="/common/table-list.jsp"/>	
	</td>
	<td style="vertical-align: top">
	
	<div class="content" style="margin: 0">
		<h3 class="page-caption">${tbl.dsplNm}</h3>
		<jsp:include page="/common/menu-view.jsp"/>	

		<div class="sub-content">
			<table class="form-layout">
				<s:iterator value="row.collist">
				<tr><td class="label"><s:property value="dsplNm"/></td><td> <s:property value="val" escape="false"/></td></tr>		
				</s:iterator>			
			</table>
		</div>
	</div>
	
	</td>
	</tr></table>
</body>
</html>