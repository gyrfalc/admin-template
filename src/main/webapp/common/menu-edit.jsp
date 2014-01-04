<%@ include file="/common/taglibs.jsp"%>
<div id="div-action-menu">
	<ul class="menu-layout">
		<li><a href="${baseURL}/list">cancel</a></li>	
		<li><a href="#" onclick="resetForm()">undo</a></li>	
		<li><a href="#" onclick="submitForm(); return false;">save</a></li>	
	</ul>
	

	<script type="text/javascript">
	
		function resetForm() {
			document.forms[0].reset();
		}
		
		function submitForm() {
			document.forms[0].submit();
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