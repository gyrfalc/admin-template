<%@ include file="/common/taglibs.jsp"%>

<ul class="clone-lang">
	<li><input type="radio" name="model.cloneLang" value="Y" checked="checked"/>&nbsp;Create record in ${langNm} and clone to all other languages.</li>
	<li><input type="radio" name="model.cloneLang" value="N" />&nbsp;Create record in ${langNm} only.</li>
</ul>