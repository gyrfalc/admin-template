<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<title>${tbl.dsplNm} - Edit</title>
	<script src="<c:url value="/ckeditor/ckeditor.js" />"></script>
	<script src="<c:url value="/ckeditor/adapters/jquery.js" />"></script>
</head>

	<div class="content" style="margin: 0">
		<h3 class="page-caption">${tbl.dsplNm} (Edit)</h3>
		<jsp:include page="/common/menu-edit.jsp"/>	

		<div id="div-form-editor" class="sub-content">
		<form action="<c:url value="/upd"/>/${tblNm}" method="post">
			<table class="form-layout">
				<s:iterator value="row.collist">
				<s:if test="%{!isMeta() && renderType!='hidden'}">
				<tr>
					<td class="label">
						<s:property value="dsplNm"/>
					</td>
					<td>
				
						<s:if test="%{renderType=='text'}" >
							<input type="text" id="fld_${colNm}" name="${colNm}" value="<s:property value="val"/>" maxlength="${maxLen}" class="${cssClass}" />
							<s:if test="html">
								&nbsp;<a href="#" onclick="showEditor('#fld_${colNm}');return false;">HTML</a>
							</s:if>
							&nbsp;<span class="field-info">Text(${maxLen})</span> 
						</s:if>
						<s:if test="%{renderType=='textarea'}" >
							<textarea id="fld_${colNm}" name="${colNm}" class="${cssClass}"><s:property value="val"/></textarea>
							<s:if test="html">
								&nbsp;<a href="#" onclick="showEditor('#fld_${colNm}');return false;">HTML</a>
							</s:if>
							&nbsp;<span class="field-info">Text(${maxLen})</span> 
						</s:if>
						<s:if test="%{renderType=='list'}" >
							<select name="${colNm}" class="${cssClass}">
								<s:set name="colkey" value="%{colNm}" />
								<s:iterator value="%{listMap[#colkey]}">
									<s:if test="id==val">
										<option value="${id}" selected="selected">${name}</option>
									</s:if>
									<s:else>
										<option value="${id}">${name}</option>
									</s:else>
								</s:iterator>
							</select>
						</s:if>
					
					</td>
				</tr>		
				</s:if>
				</s:iterator>			
			</table>
				<input type="hidden" name="keyVal" value="${keyVal}" />
			<s:iterator value="row.collist">
				<s:if test="%{isMeta() && renderType=='hidden'}">			
					<input type="hidden" name="${colNm}" value="<s:property value="val"/>" />
				</s:if>
			</s:iterator>
			<input type="submit"/>
		</form>
		</div>
		<jsp:include page="/common/text-edit.jsp"/>
	</div>
	
</body>
</html>