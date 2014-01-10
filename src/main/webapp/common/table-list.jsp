<%@ include file="/common/taglibs.jsp"%>
	<s:url id="contextURL" value="/" includeParams="none"/>

	<div class="table-list">
		<h3 class="page-caption">Table List</h3>
		<div class="table-list-wrapper">
		<ul>
			<s:iterator value="tblList">
				<li><a href="${contextURL}list/${urlNm}">${tblNm}</a>
			</s:iterator>
		</ul>
		</div>
	</div>