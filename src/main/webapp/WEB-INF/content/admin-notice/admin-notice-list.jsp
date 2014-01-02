<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<title>Admin Notifications</title>
</head>
<body>
	<s:url id="baseURL" value="/fabric" includeParams="none"/>
	<s:url id="familyURL" value="/fabricfamily" includeParams="none"/>

	<div class="welcome">Welcome, <s:property value="userNm"/>&nbsp;&nbsp;<a href="#">logout</a></div>
	
	<table style="border-collapse: collapse; width: 100%;"><tr>
	<td style="vertical-align:top; width: 220px">
		<div class="table-list" style="float:none">
		<h3 class="page-caption">Table List</h3>
		<div class="table-list-wrapper">
		<ul>
			<li><a href="${baseURL}/list">fabric</a>
			<li><a href="${familyURL}/list">fabric family</a>
			<li><a href="${baseURL}/list">longer_table_name</a>
			<li><a href="${baseURL}/list">table_name</a>
			<li><a href="${baseURL}/list">longer_table_name</a>
			<li><a href="${baseURL}/list">table_name</a>
			<li><a href="${baseURL}/list">longer_table_name</a>
			<li><a href="${baseURL}/list">table_name</a>
			<li><a href="${baseURL}/list">longer_table_name</a>
			<li><a href="${baseURL}/list">table_name</a>
			<li><a href="${baseURL}/list">longer_table_name</a>
			<li><a href="${baseURL}/list">table_name</a>
			<li><a href="${baseURL}/list">longer_table_name</a>
			<li><a href="${baseURL}/list">table_name</a>
			<li><a href="${baseURL}/list">longer_table_name</a>
			<li><a href="${baseURL}/list">table_name</a>
			<li><a href="${baseURL}/list">longer_table_name</a>
			<li><a href="${baseURL}/list">table_name</a>
			<li><a href="${baseURL}/list">longer_table_name</a>
			<li><a href="${baseURL}/list">table_name</a>
			<li><a href="${baseURL}/list">longer_table_name</a>
			<li><a href="${baseURL}/list">table_name</a>
			<li><a href="${baseURL}/list">longer_table_name</a>
			<li><a href="${baseURL}/list">table_name</a>
			<li><a href="${baseURL}/list">longer_table_name</a>
			<li><a href="${baseURL}/list">table_name</a>
			<li><a href="${baseURL}/list">longer_table_name</a>
			<li><a href="${baseURL}/list">table_name</a>
			<li><a href="${baseURL}/list">longer_table_name</a>
			<li><a href="${baseURL}/list">table_name</a>
			<li><a href="${baseURL}/list">longer_table_name</a>
			<li><a href="${baseURL}/list">table_name</a>
			<li><a href="${baseURL}/list">longer_table_name</a>
			<li><a href="${baseURL}/list">table_name</a>
			<li><a href="${baseURL}/list">longer_table_name</a>
			<li><a href="${baseURL}/list">table_name</a>
			<li><a href="${baseURL}/list">longer_table_name</a>
			<li><a href="${baseURL}/list">table_name</a>
			<li><a href="${baseURL}/list">longer_table_name</a>
			<li><a href="${baseURL}/list">table_name</a>
			<li><a href="${baseURL}/list">longer_table_name</a>
			<li><a href="${baseURL}/list">table_name</a>
			<li><a href="${baseURL}/list">longer_table_name</a>
			<li><a href="${baseURL}/list">table_name</a>
			<li><a href="${baseURL}/list">longer_table_name</a>
			<li><a href="${baseURL}/list">table_name</a>
			<li><a href="${baseURL}/list">longer_table_name</a>
			<li><a href="${baseURL}/list">table_name</a>
			<li><a href="${baseURL}/list">longer_table_name</a>
			<li><a href="${baseURL}/list">table_name</a>
			<li><a href="${baseURL}/list">longer_table_name</a>
			<li><a href="${baseURL}/list">table_name</a>
			<li><a href="${baseURL}/list">longer_table_name</a>
			<li><a href="${baseURL}/list">table_name</a>
			<li><a href="${baseURL}/list">longer_table_name</a>
			<li><a href="${baseURL}/list">table_name</a>
			<li><a href="${baseURL}/list">longer_table_name</a>
			<li><a href="${baseURL}/list">table_name</a>
			<li><a href="${baseURL}/list">longer_table_name</a>
			<li><a href="${baseURL}/list">table_name</a>
			<li><a href="${baseURL}/list">longer_table_name</a>
			<li><a href="${baseURL}/list">table_name</a>
			<li><a href="${baseURL}/list">longer_table_name</a>
			<li><a href="${baseURL}/list">table_name</a>
			<li><a href="${baseURL}/list">longer_table_name</a>
			<li><a href="${baseURL}/list">table_name</a>
			<li><a href="${baseURL}/list">longer_table_name</a>
			<li><a href="${baseURL}/list">table_name</a>
			<li><a href="${baseURL}/list">longer_table_name</a>
			<li><a href="${baseURL}/list">table_name</a>
			<li><a href="${baseURL}/list">longer_table_name</a>
			<li><a href="${baseURL}/list">table_name</a>
			<li><a href="${baseURL}/list">longer_table_name</a>
			<li><a href="${baseURL}/list">table_name</a>
			<li><a href="${baseURL}/list">longer_table_name</a>
			<li><a href="${baseURL}/list">table_name</a>
			<li><a href="${baseURL}/list">longer_table_name</a>
			<li><a href="${baseURL}/list">table_name</a>
			<li><a href="${baseURL}/list">longer_table_name</a>
			<li><a href="${baseURL}/list">table_name</a>
			<li><a href="${baseURL}/list">longer_table_name</a>
			
		
		</ul>
		</div>
		</div>
	</td>
	<td style="vertical-align: top">
	<div class="content" style="margin: 0">
		<h3 class="page-caption">Notifications</h3>

	
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
		<display:table id="model-list" name="modelList">
			  <display:column property="noteType" title="Type"/>
			  <display:column property="noteMsg" title="Message" />
			  <display:column property="noteUsrNm" title="Author"/>
			  <display:column property="noteDt" title="Date"/>
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