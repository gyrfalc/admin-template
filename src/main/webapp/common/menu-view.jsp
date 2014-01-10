<%@ include file="/common/taglibs.jsp"%>
<s:url id="contextURL" value="/" includeParams="none"/>
<div id="div-action-menu">
	<ul class="menu-layout">
		<li><a href="${contextURL}list/${tbl.urlNm}">list</a></li>	
		<li><a href="${contextURL}new/${tbl.urlNm}">new</a></li>	
		<li><a href="${contextURL}edit/${tbl.urlNm}?key=${key}">edit</a></li>	
		<li><a href="#" onclick="confirmDelete(); return false;">delete</a></li>	
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

	<form id="frmDel" action="${baseURL}/del" method="post">
		<input type="hidden" name="id" value="${key}" />
	</form>

	<script type="text/javascript">
	
		function confirmDelete() {
			var msg = "${tbl.instrDel}";
			if (msg.length == 0) {
				msg = "This record will be permanently deleted. Continue?";
			}
			 var r=confirm(msg);
			 if (r==true)
			   {
			   		document.forms[0].submit();
			   }
		}
		
	</script>	
</div>