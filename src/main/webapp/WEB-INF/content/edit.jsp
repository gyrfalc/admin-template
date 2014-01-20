<%@ include file="/common/taglibs.jsp"%>
<s:url id="contextURL" value="/" includeParams="none"/>

<!DOCTYPE html>
<html>
<head>
	<title>${tbl.dsplNm} - Edit</title>
	<script src="<s:url value="/ckeditor/ckeditor.js"  includeParams="false"/>"></script>
	<script src="<s:url value="/ckeditor/adapters/jquery.js"  includeParams="false"/>"></script>
	
	<style>
	 .ui-tooltip {
		padding: 10px 20px;
		color: #444;
		border-radius: 5px;
		box-shadow: 0 0 7px black;
		background-color: white;
		width: 300px;
	}
	</style>
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

		<div id="div-form-editor" class="sub-content">
		<form id="frm-edit" action="<s:url value="/upd"  includeParams="false"/>/${tblUrlNm}" method="post">
			<table class="form-layout">
				<s:iterator value="row.collist">
				<s:if test="%{!isMeta() && renderType!='hidden'}">
				<tr>
					<td class="label" >
						<s:property value="dsplNm"/>
					</td>
					<td>
					<s:if test="%{isKey()}">
						<%-- do not allow users to edit key values --%>
						<s:property value="val"/>
					</s:if><s:else>				
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
				<input type="hidden" name="keyVal" value="${keyVal}" />
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
	
	<script type="text/javascript">
		$( document ).tooltip();
	</script>
</body>
</html>