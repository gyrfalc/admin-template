<%@ include file="/common/taglibs.jsp"%>
<s:url id="contextURL" value="/" includeParams="none" encode="false"/>
<div id="div-action-menu">
	<ul class="menu-layout">
		<li><a href="${contextURL}home">home</a></li>	
		<li><a href="${contextURL}list/${tbl.urlNm}">index</a></li>	
		<s:if test="%{tbl.tblType != 'view'}">
		<li><a href="${contextURL}new/${tbl.urlNm}">new</a></li>	
		<li><a href="${contextURL}edit/${tbl.urlNm}?key=${key}">edit</a></li>	
		<li><a href="#" onclick="confirmDelete(); return false;">delete</a></li>	
		</s:if>
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

	<form id="frmDel" action="${contextURL}del/${tbl.urlNm}" method="post">
		<input type="hidden" name="key" value="${key}" />
	</form>

	<script type="text/javascript">
	
		function confirmDelete() {
			var msg = "${tbl.instrDel}";
			var langInd = ${tbl.hasLang()};
			if (msg.length == 0) {
				if (langInd) {
					msg = "This record and all language variations will be permanently deleted. Continue?";
				} else {
					msg = "This record will be permanently deleted. Continue?";
				}
				
			}
			 var r=confirm(msg);
			 if (r==true)
			   {
			   		$("#frmDel").submit();
			   }
		}
		
	</script>	
</div>