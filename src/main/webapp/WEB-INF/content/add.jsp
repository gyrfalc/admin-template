<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<title>${tbl.dsplNm} - Add</title>
	<script src="<c:url value="/ckeditor/ckeditor.js" />"></script>
	<script src="<c:url value="/ckeditor/adapters/jquery.js" />"></script>
</head>
<body>
	<jsp:include page="/common/page-header.jsp"/>	
	
	<table style="border-collapse: collapse; width: 100%;"><tr>
	<td class="table-list">
		<jsp:include page="/common/table-list.jsp"/>	
	</td>
	<td style="vertical-align: top">
	
	<div class="content" style="margin: 0">
		<h3 class="page-caption">${tbl.dsplNm} (Add)</h3>
		<jsp:include page="/common/menu-add.jsp"/>	
		
		<div class="tbl-instr">${tbl.instrAdd }</div>

		<div id="div-form-editor" class="sub-content">
		<form id="frm-edit" action="<c:url value="/ins"/>/${tblNm}" method="post">
			<table class="form-layout">
				<tr>
					<td class="label" style="padding-top:25px">Language</td>
					<td style="padding:0">
						<ul class="clone-lang">
							<li><input type="radio" name="model.cloneLang" value="Y" checked="checked"/>&nbsp;Create record in ${langNm} and clone to all other languages.</li>
							<li><input type="radio" name="model.cloneLang" value="N" />&nbsp;Create record in ${langNm} only.</li>
						</ul>					
					</td>
				</tr>
				<s:iterator value="row.collist">
				<s:if test="%{!isMeta()}">
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

		</form>
		</div>
		<jsp:include page="/common/text-edit.jsp"/>
	</div>
	
	</td>
	</tr></table>
			
	
</body>
</html>