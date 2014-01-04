<%@ include file="/common/taglibs.jsp"%>
<div id="div-action-menu">
	<ul class="menu-layout">
		<li><a href="${baseURL}/list">list</a></li>	
		<li><a href="${baseURL}/new">new</a></li>	
		<li><a href="${baseURL}/edit/${model.id}">edit</a></li>	
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
		<input type="hidden" name="id" value="${model.id}" />
	</form>

	<script type="text/javascript">
	
		function confirmDelete() {
			 var r=confirm("This record will be permanently removed. Continue?");
			 if (r==true)
			   {
			   		document.forms[0].submit();
			   }
		}
		
	</script>	
</div>