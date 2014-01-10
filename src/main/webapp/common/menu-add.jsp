<%@ include file="/common/taglibs.jsp"%>
<s:url id="contextURL" value="/" includeParams="none"/>
<div id="div-action-menu">
		<ul class="menu-layout">
			<li><a href="${contextURL}list/${tbl.urlNm}">cancel</a></li>	
			<li><a href="#" onclick="resetForm(); return false;">clear</a></li>	
			<li><a href="#" onclick="submitForm(); return false;">save</a></li>	
		</ul>

		<script type="text/javascript">
			
			function submitForm() {
				$("#frm-edit").submit();
			}
			
			function resetForm() {
				$("#frm-edit").reset();
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