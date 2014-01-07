<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<title>${tbl.tblNm}</title>
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
			<h3 class="page-caption">${tbl.tblNm} Index</h3>
			<jsp:include page="/common/menu-list.jsp"/>	

			<div class="sub-content">
				<table>
					<thead>
						<tr>
							<s:iterator value="colnmlist">
								<th><s:property value="dsplNm"/></th>
							</s:iterator>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="rowlist">
						<tr>
							<s:iterator value="collist">
								<td><s:property value="val" escape="false"/></td>
							</s:iterator>
						
						</tr>
						</s:iterator>
					
					</tbody>
				</table>
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