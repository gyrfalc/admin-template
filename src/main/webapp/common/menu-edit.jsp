<%@ include file="/common/taglibs.jsp"%>
<s:url id="contextURL" value="/" includeParams="none"/>
<div id="div-action-menu">
	<ul class="menu-layout">
		<li><a href="${contextURL}list/${tbl.urlNm}">cancel</a></li>	
		<li><a href="#" onclick="resetForm(); return false;">undo</a></li>	
		<li><a href="#" onclick="submitForm(); return false;">save</a></li>	
	</ul>
	

	<script type="text/javascript">
	
		function resetForm() {
			$("#frm-edit").reset();
		}
		
		function submitForm() {
			$("#frm-edit").submit();
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