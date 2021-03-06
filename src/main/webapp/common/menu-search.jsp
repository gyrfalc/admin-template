<%@ include file="/common/taglibs.jsp"%>
<s:url id="contextURL" value="/" includeParams="none" encode="false"/>
<div id="div-action-menu">
	<ul class="menu-layout">
		<li><a href="${contextURL}home">home</a></li>	
		<li><a href="${contextURL}list/${tbl.urlNm}">index</a></li>	
		<li><a href="#" onclick="clearForm();return false;">clear query</a></li>	
		<li><a href="#" onclick="submitForm();return false;">submit query</a></li>	
	</ul>
	
	<script type="text/javascript">
		function clearForm() {
			document.getElementById("frm-srch").reset();
		}
		function submitForm() {
			document.getElementById("frm-srch").submit();
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