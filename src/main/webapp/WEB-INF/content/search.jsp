<%@ include file="/common/taglibs.jsp"%>
<s:url id="contextURL" value="/" includeParams="none" encode="false"/>

<!DOCTYPE html>
<html>
<head>
	<title>${tbl.dsplNm} - Search</title>
	<script src="<s:url value="/ckeditor/ckeditor.js"  includeParams="none" encode="false"/>"></script>
	<script src="<s:url value="/ckeditor/adapters/jquery.js"  includeParams="none" encode="false"/>"></script>

</head>
	<jsp:include page="/common/page-header.jsp"/>	
	
	<table style="border-collapse: collapse; width: 100%;"><tr>
	<td class="table-list">
		<jsp:include page="/common/table-list.jsp"/>	
	</td>
	<td style="vertical-align: top">
	
	<div class="content" style="margin: 0">
		<h3 class="page-caption">${tbl.dsplNm} (Search)</h3>
		<jsp:include page="/common/menu-search.jsp"/>	

		<div id="div-form-editor" class="sub-content">
		<form id="frm-srch" action="<s:url value="/search-result"  includeParams="none" encode="false"/>/${tblUrlNm}" method="post">
			<table class="form-layout">
				<s:iterator value="row.collist">
				<tr>
					<td class="label" >
						<s:property value="dsplNm"/>
					</td>
					<td>
						<s:if test="%{renderType=='list'}" >
							<select name="${colNm}" class="${cssClass}">
								<option value=""></option>
								<s:set name="colkey" value="%{colNm}" />
								<s:iterator value="%{listMap[#colkey]}">
									<option value="${id}">${name}</option>
								</s:iterator>
							</select>
						</s:if><s:else>
							<input type="text" id="fld_${colNm}" name="${colNm}" class="search" />
						</s:else>
					</td>
					<td class="field-info"><s:property value="colDesc" escape="false"/></td>
				</tr>		
				</s:iterator>			
			</table>

		</form>
		</div>
	</div>
	
	</td>
	</tr></table>	

</body>
</html>