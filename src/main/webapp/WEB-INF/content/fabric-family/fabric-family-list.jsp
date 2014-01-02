<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<title>Fabric</title>
</head>
<body>
	<s:url id="baseURL" value="/fabricfamily" includeParams="none"/>
	<s:url id="fabricURL" value="/fabric" includeParams="none"/>

	<div class="welcome">Welcome, <s:property value="userNm"/>&nbsp;&nbsp;<a href="#">logout</a></div>
	
	<table style="border-collapse: collapse; width: 100%;"><tr>
	<td style="vertical-align:top; width: 220px">
		<div class="table-list" style="float:none">
		<h3 class="page-caption">Table List</h3>
		<div class="table-list-wrapper">
		<ul>
			<li><a href="${fabricURL}/list">fabric</a>
			<li><a href="${baseURL}/list">fabric family</a>
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
		<h3 class="page-caption">Fabric Family Index</h3>
		<ul class="menu-layout">
			<li><a href="${baseURL}/new">new</a></li>			
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
		<display:table id="model-list" name="modelList" decorator="com.csc.admin.decorator.LinkDecorator">
			  <display:column property="id" title="Code"  />
			  <display:column property="fabricFamilyNm" title="Name"/>
			  <display:column property="fabricFamilyDesc" title="Description" />
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