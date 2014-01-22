<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<title>Admin - Home</title>
</head>
<body>
	<jsp:include page="/common/page-header.jsp"/>	
	
	<table style="border-collapse: collapse; width: 100%;"><tr>
	<td class="table-list">
		<jsp:include page="/common/table-list.jsp"/>	
	</td>
	<td style="vertical-align: top">
		<div class="content" style="margin: 0">
			<h3 class="page-caption">Notifications</h3>
			
			<div class="tbl-instr">
				Paragraph regarding notifications goes here.
			</div>

			<div class="sub-content">
				<table id="model-list">
					<thead>
						<tr>
							<th>Date</th>
							<th>Type</th>
							<th>Message</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="noticeList">
						<tr>
							<td><s:property value="noteDt"/></td>
							<td class="<s:property value="noteType"/>"><s:property value="noteType"/></td>							
							<td><s:property value="noteMsg" escape="false"/></td>						
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