<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>Fabric</title>
	
	<script src="<c:url value="/ckeditor/ckeditor.js" />"></script>
	<script src="<c:url value="/ckeditor/adapters/jquery.js" />"></script>
	

	<script type="text/javascript">
	
		function resetForm() {
			document.forms[0].reset();
		}
		
		function submitForm() {
			document.forms[0].submit();
		}
	
	</script>	
</head>
<body>
	<s:url id="baseURL" value="/fabric" includeParams="none"/>
	<s:url id="familyURL" value="/fabricfamily" includeParams="none"/>

	<div class="welcome">Welcome, <s:property value="userNm"/>&nbsp;&nbsp;<a href="#">logout</a></div>
	<div class="table-list">
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
	
	<div class="instructions">
		<h3>Instructions</h3>
		<p>
			This management application is auto-generated and is meant for simple editing only. Users are expected to understand their own data and maintain proper data integrity.
		</p>
		
		<p>
			Required fields are marked with a red asterisk. Field data types are noted next to the input fields. 
		</p>
		<p>	
			Fields that accept HTML input may be "previewed" in view mode, but note that <em>styles do not necessarily match the application style sheet</em>.  
			To author valid HTML data, look for a free HTML editor online.  Enter
			trademarks and other symbols using HTML codes. <em>Note that carriage returns and line feeds
			do not work in HTML, and you must not enter them in your data or you may break the web application scripts</em>.  
		</p>
		<p>	
			<em>DO NOT COPY AND PASTE CONTENT FROM MICROSOFT WORD OR EXCEL.</em>  
			If you have content in Microsoft, copy and paste into a simple text editor (NOTEPAD) and makes sure all
			hidden or extraneous characters are removed before adding it to your database.  
		</p>
		
	</div>
	
	<div class="content">
	<h3 class="page-caption">Fabric (Edit)</h3>
	<div id="div-form-editor">
	<ul class="menu-layout">
		<li><a href="${baseURL}/list">cancel</a></li>	
		<li><a href="#" onclick="resetForm()">undo</a></li>	
		<li><a href="#" onclick="submitForm(); return false;">save</a></li>	
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
	<form action="${baseURL}/upd" method="post">
	<ul class="form-layout">
		<li><label>Code <span class="required">*</span></label> <s:property value="model.fabricCd"/>&nbsp;<s:hidden name="model.fabricCd" /> </li>
		<li><label>Name <span class="required">*</span></label> <s:textfield name="model.fabricNm" cssClass="large"/>&nbsp;<span class="field-info">Text(100)</span></li>
		<li><label>Description <span class="required">*</span></label> <s:textarea id="fld-fabricDesc" name="model.fabricDesc" />
			&nbsp;<a href="#" onclick="showEditor('#fld-fabricDesc');return false;">HTML</a>
			&nbsp;<span class="field-info">Text(255)</span> </li>
		<li><label>Family <span class="required">*</span></label> 
			<s:select name="model.fabricFamilyCd" list="lstFabricFamilyCd" listKey="id" listValue="name" cssClass="large" />
		 </li>
	
	</ul>
	</form>
	</div>
	</div>

	<jsp:include page="/common/text-edit.jsp"/>
	
	
	</div>
	

</body>
</html>