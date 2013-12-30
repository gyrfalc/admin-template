<%@ page language="java"  isErrorPage="true" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>

<page:applyDecorator name="default">
<head>
    <title>Access Denied</title>
    <meta name="heading" content="Page Not Found"/>
</head>


<p>
    Your current role does not allow you to view this page.  Please contact your system administrator if you believe you should have access.
</p>

</page:applyDecorator>