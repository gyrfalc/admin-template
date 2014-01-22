<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<title>${tbl.dsplNm} - View</title>
</head>
<body>
	<jsp:include page="/common/page-header.jsp"/>	
	
	<table style="border-collapse: collapse; width: 100%;"><tr>
	<td class="table-list">
		<jsp:include page="/common/table-list.jsp"/>	
	</td>
	<td style="vertical-align: top">
	
	<div class="content" style="margin: 0">
		<h3 class="page-caption">${tbl.dsplNm}</h3>
		<jsp:include page="/common/menu-view.jsp"/>	

		<div class="sub-content">
			<table class="form-layout">
				<s:iterator value="row.collist">
				<tr>
					<td class="label"><s:property value="dsplNm"/></td>
					<td>
						<s:if test="%{renderType=='list'}" >
							<select name="${colNm}" class="${cssClass}" style="${cssStyle}" disabled="disabled">
								<option value=""></option>
								<s:set name="colkey" value="%{colNm}" />
								<s:iterator value="%{listMap[#colkey]}">
									<s:if test="id==val">
										<option value="${id}" selected="selected">${name}</option>
									</s:if>
								</s:iterator>
							</select>
						</s:if><s:else>
							<s:property value="val" escape="false"/>
						</s:else>						
					</td>
					<td class="field-info"><s:property value="colDesc" escape="false"/></td>
				</tr>		
				</s:iterator>			
			</table>
		</div>
	</div>
	
	</td>
	</tr></table>
</body>
</html>