<%@ include file="/common/taglibs.jsp"%>
<s:url id="contextURL" value="/" includeParams="none" encode="false"/>
<div id="div-action-menu">
	<ul class="menu-layout">
		<li><a href="${contextURL}home">home</a></li>	
		<li><a href="${contextURL}list/${tbl.urlNm}">refresh</a></li>	
		<li><a href="${contextURL}search/${tbl.urlNm}">search</a></li>	
		<li><a href="#" onclick="exportTable();return false;">export</a></li>		
		<s:if test="%{tbl.tblType == 'edit'}">
		<li><a href="${contextURL}new/${tbl.urlNm}">new</a></li>
		</s:if>	
				
	</ul>
	
	<script type="text/javascript">
		function exportTable() {
			alert('Export to Excel is not implemented.');
		}
	</script>

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
</div>