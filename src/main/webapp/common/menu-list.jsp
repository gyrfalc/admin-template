<%@ include file="/common/taglibs.jsp"%>
<div id="div-action-menu">
	<ul class="menu-layout">
		<li><a href="${baseURL}/new">new</a></li>			
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
</div>