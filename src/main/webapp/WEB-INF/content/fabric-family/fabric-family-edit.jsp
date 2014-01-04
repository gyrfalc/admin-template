<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>Fabric</title>
	
</head>
<body>
	<jsp:include page="/common/page-header.jsp"/>	
	<s:url id="baseURL" value="/fabricfamily" includeParams="none"/>

	<jsp:include page="/common/table-list.jsp"/>	
	
	<div class="instructions">
		<h3>Instructions</h3>
		<p>
			This management application is auto-generated and is meant for simple editing only. Users are expected to understand their own data and maintain proper data integrity.
		</p>
		
		<p>
			Required fields are marked with a red asterisk. Field data types are noted next to the input fields. 
		</p>
		<p>	
			Fields that accept HTML input may be previewed in a pop-up window.  
			To author valid HTML data, look for a free HTML editor online.  Learn how to enter
			trademarks and other symbols using HTML codes. <em>Note that carriage returns and line feeds
			do not work in HTML, and you must not enter them in your data or you could break the web application scripts</em>.  
		</p>
		<p>	
			<em>DO NOT COPY AND PASTE CONTENT FROM MICROSOFT WORD OR EXCEL.</em>  
			If you have content in Microsoft, copy and paste into a simple text editor (NOTEPAD) and makes sure all
			hidden or extraneous characters are removed before adding it to your database.  
		</p>
		
	</div>
	
	<div class="content">
		<h3 class="page-caption">Fabric Family (Edit)</h3>
		<jsp:include page="/common/audit-bar.jsp"/>	
	
		<jsp:include page="/common/edit-menu.jsp"/>	
		
		<div class="sub-content">
			<form action="${baseURL}/upd" method="post">
				<ul class="form-layout">
					<li><label>Code <span class="required">*</span></label> <s:property value="model.fabricFamilyCd"/>&nbsp;<s:hidden name="model.fabricFamilyCd" /> </li>
					<li><label>Name <span class="required">*</span></label> <s:textfield name="model.fabricFamilyNm" cssClass="large"/>&nbsp;<span class="field-info">Text(100)</span></li>
					<li><label>Description <span class="required">*</span></label> <s:textarea id="fld-fabricDesc" name="model.fabricFamilyDesc" />&nbsp;<span class="field-info">Text(255)</span> </li>
				
				</ul>
			</form>
		</div>
	</div>

</body>
</html>