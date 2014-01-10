<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<title>${tbl.dsplNm}</title>
</head>
<body>
		<div class="content" style="margin: 0">
			<h3 class="page-caption">${tbl.dsplNm} Index</h3>
			<jsp:include page="/common/menu-list.jsp"/>	

			<div class="sub-content">
				<table id="model-list">
					<thead>
						<tr>
							<th>ID</th>
							<s:iterator value="collist">
								<th><s:property value="dsplNm"/></th>
							</s:iterator>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="rowlist">
						<tr>
							<td>
								<a href="<c:url value="/view/"/>${tbl.urlNm}?keyVal=${keyVal}"><s:property value="keyVal"/></a>
							</td>
							<s:iterator value="collist">
								<td><s:property value="val" escape="false"/></td>
							</s:iterator>
						
						</tr>
						</s:iterator>
					
					</tbody>
				</table>
			</div>
		</div>
		
	<script type="text/javascript">
		$(document).ready(function(){
			  $('#model-list').dataTable();
			});	
	
	</script>
</body>
</html>