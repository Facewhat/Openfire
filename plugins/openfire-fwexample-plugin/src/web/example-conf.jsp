<%@ page contentType="text/html; charset=UTF-8" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="admin" prefix="admin" %>
<%--<jsp:useBean scope="request" id="errorMessage" class="java.lang.String"/>--%>
<%--<jsp:useBean scope="request" id="warningMessage" class="java.lang.String"/>--%>
<%--<jsp:useBean scope="request" id="successMessage" class="java.lang.String"/>--%>
<%--<jsp:useBean scope="request" id="logToConsole" type="java.lang.Boolean"/>--%>
<%--<jsp:useBean scope="request" id="logToFile" type="java.lang.Boolean"/>--%>
<%--<jsp:useBean scope="request" id="csrf" type="java.lang.String"/>--%>
<!DOCTYPE html>
<html>
<head>
    <!--显示内容在fwexample_i18n.properties中配置-->
    <title><fmt:message key="plugin.fwexample.siderbar.title"/></title>
    <!--content值与plugin.xml中的节点id值相同-->
    <meta name="pageID" content="fwexample-conf"/>
</head>
<body>
<div>can i say sth.</div>
<admin:FlashMessage/>

<form method="post">
    <input name="csrf" value="<c:out value="${csrf}"/>" type="hidden">
    <div class="jive-contentBoxHeader">
        Debug connections
    </div>
    <div class="jive-contentBox">
        <table cellpadding="3" cellspacing="0" border="0">
            <tbody>
            <tr valign="middle">
                <td width="1%" nowrap>
                    <input id="rb06" type="checkbox" name="logToConsole"/>
<%--                    <input id="rb06" type="checkbox" name="logToConsole" <c:if test="${logToConsole}">checked</c:if>/>--%>
                </td>
                <td width="99%">
                    <label for="rb06">
                        Log to STDOUT
                    </label>
                </td>
            </tr>
            <tr valign="middle">
                <td width="1%" nowrap>
                    <input id="rb07" type="checkbox" name="logToFile"/>
<%--                    <input id="rb07" type="checkbox" name="logToFile" <c:if test="${logToFile}">checked</c:if>/>--%>
                </td>
                <td width="99%">
                    <label for="rb07">
                        Log to file
                    </label>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
    <!--插件可以读openfire_i18n.properties中的值-->
    <input type="submit" name="update" value="<fmt:message key="global.save_settings" />">
    <input type="submit" name="cancel" value="<fmt:message key="global.cancel" />">
</form>
</body
</html>
