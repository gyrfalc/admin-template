<%@ include file="/common/taglibs.jsp"%>
<s:url id="contextURL" value="/" includeParams="none" encode="false"/>

<!DOCTYPE html>
<html>
<head>
	<title>${tbl.dsplNm} - Edit</title>
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
		<h3 class="page-caption">${tbl.dsplNm} (Edit)</h3>
		<jsp:include page="/common/menu-edit.jsp"/>	
		
		<div class="instructions">
			<s:property value="tbl.instrEdit" escape="false"/>
		</div>

		<div id="div-form-editor" class="sub-content">
		<form id="frm-edit" action="<s:url value="/upd"  includeParams="none" encode="false"/>/${tblUrlNm}" method="post">
			<table class="form-layout">
				<s:iterator value="row.collist">
				<s:if test="%{!isMeta() && renderType!='hidden'}">
				<tr>
					<td class="label" >
						<s:property value="dsplNm"/>
						<s:if test="%{isReq()}">
							<span class="required">*</span>
						</s:if>
					</td>
					<td>
					<s:if test="%{isKey()}">
						<%-- do not allow users to edit key values --%>
						<s:property value="val"/>
					</s:if><s:else>				
						<s:if test="%{renderType=='text'}" >
							<s:if test="readOnly">
							<input type="text" id="fld_${colNm}" name="${colNm}" value="<s:property value="val"/>" maxlength="${maxLen}" class="${cssClass}" style="${cssStyle}" readonly="readonly"/>
							</s:if>
							<s:else>
							<input type="text" id="fld_${colNm}" name="${colNm}" value="<s:property value="val"/>" maxlength="${maxLen}" class="${cssClass}" style="${cssStyle}" />
							</s:else>
							<input type="text" id="fld_${colNm}" name="${colNm}" value="<s:property value="val"/>" maxlength="${maxLen}" class="${cssClass}" style="${cssStyle}" />
							<s:if test="html">
								&nbsp;<a href="#" onclick="showEditor('#fld_${colNm}');return false;">HTML</a>
							</s:if>
							<s:if test="dataType=='char'">
								&nbsp;<span class="field-info">Text(${maxLen})</span> 
							</s:if>
							<s:else>
								&nbsp;<span class="field-info">Number(${maxLen})</span> 						
							</s:else>
						</s:if>
						<s:if test="%{renderType=='textarea'}" >
							<s:if test="readOnly">
							<textarea id="fld_${colNm}" name="${colNm}" class="${cssClass}" style="${cssStyle}" readonly="readonly"><s:property value="val" /></textarea>
							</s:if>
							<s:else>
							<textarea id="fld_${colNm}" name="${colNm}" class="${cssClass}" style="${cssStyle}" ><s:property value="val"/></textarea>
							</s:else>
							<s:if test="html">
								&nbsp;<a href="#" onclick="showEditor('#fld_${colNm}');return false;">HTML</a>
							</s:if>
							&nbsp;<span class="field-info">Text(${maxLen})</span> 
						</s:if>
						<s:if test="%{renderType=='list'}" >
							<select name="${colNm}" class="${cssClass}" style="${cssStyle}" >
								<option value=""></option>
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
					</s:else>
					</td>
					<td class="field-info"><s:property value="colDesc" escape="false"/></td>
				</tr>		
				</s:if>
				</s:iterator>			
			</table>
				<input type="hidden" name="key" value="${key}" />
			<s:iterator value="row.collist">
				<s:if test="%{!isMeta() && renderType=='hidden'}">			
					<input type="hidden" name="${colNm}" value="<s:property value="val"/>" />
				</s:if>
			</s:iterator>
		</form>
		</div>
		<jsp:include page="/common/text-edit.jsp"/>
	</div>
	
	</td>
	</tr></table>	

</body>
</html>