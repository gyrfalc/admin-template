<%@ include file="/common/taglibs.jsp"%>
<%--
======================================================================================================
                                     PAGE   H E A D E R
======================================================================================================
--%>

<div class="welcome">
	Welcome, <s:property value="userNm"/>
	&nbsp;&nbsp;
	<a href="#">logout</a>
	&nbsp;&nbsp;
	language 
	<s:select id="userLangCd" name="langCd" list="langList" listKey="id" listValue="name" cssClass="small" onchange="onChangeLang()"/>
</div>
	
<script type="text/javascript">
	function onChangeLang() {
		
		userLangCd = $("#userLangCd").val();
		//alert("user lang cd = " + userLangCd);

		$.ajax({
			type: 'POST',
			url: '<s:url value="/ajax/lang" includeParams="none" encode="false"/>',
			data: { 'userLangCd': userLangCd }
		})
		.done(function( msg ) {
			location.reload(true);
		})
		.fail(function() {
			alert( "Sorry! Failed to switch languages." );
		});
	}

</script>
