<%@ include file="/common/taglibs.jsp"%>
<s:url id="contextURL" value="/" includeParams="none"/>
<!DOCTYPE html>
<html>
<head>
	<title>${tbl.dsplNm}</title>
</head>
<body>
	<jsp:include page="/common/page-header.jsp"/>	
	
	<table style="border-collapse: collapse; width: 100%;"><tr>
	<td class="table-list">
		<jsp:include page="/common/table-list.jsp"/>	
	</td>
	<td style="vertical-align: top">
		<div class="content" style="margin: 0">
			<h3 class="page-caption">${tbl.dsplNm} (${pageTitle})</h3>
			<jsp:include page="/common/menu-list.jsp"/>	
			
			<div class="tbl-instr">
				${pageInfo}
			</div>

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
								<a href="${contextURL}view/${tbl.urlNm}?key=${keyVal}"><s:property value="keyVal"/></a>
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
	</td>
	</tr></table>
			
	<script type="text/javascript">
		$(document).ready(function(){
			  $('#model-list').dataTable({
			       "oLanguage": {
			    	   "sSearch": "Filter this View:"
			    	}
			    });
			});	
	
	</script>
</body>
</html>