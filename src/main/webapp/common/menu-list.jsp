<%@ include file="/common/taglibs.jsp"%>
<s:url id="contextURL" value="/" includeParams="none"/>
<div id="div-action-menu">
	<ul class="menu-layout">
		<li><a href="${contextURL}new/${tbl.urlNm}">new</a></li>			
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