<%@ include file="/common/taglibs.jsp"%>
	<s:url id="contextURL" value="/" includeParams="none" encode="false"/>
	
	<div class="table-list">
		<h3 class="page-caption">Tables (Edit)</h3>
		<div class="table-list-wrapper">
		<ul>
			<s:iterator value="tblList">
				<li><a href="${contextURL}list/${urlNm}">${dsplNm}</a>
			</s:iterator>
		</ul>
		</div>
	</div>
	
	<div class="table-list">
		<h3 class="page-caption">Views (Query)</h3>
		<div class="table-list-wrapper">
		<ul>
			<s:iterator value="vwList">
				<li><a href="${contextURL}list/${urlNm}">${dsplNm}</a>
			</s:iterator>
		</ul>
		</div>
	</div>
	
	<div class="table-list">
		<h3 class="page-caption">Meta Tables</h3>
		<div class="table-list-wrapper">
		<ul>
			<s:iterator value="metaList">
				<li><a href="${contextURL}list/${urlNm}">${dsplNm}</a>
			</s:iterator>
		</ul>
		</div>
	</div>