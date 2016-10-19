<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Hello World</title>
</head>
<body>
<table>
    <tr>
        <td>Array Sorting</td>
        <td>
            <spring:url value="/calculate" var="calcUrl"/>
            
            <form:form method="post" modelAttribute="startPage" action="${calcUrl}">

                <form:hidden path="type" />

                <spring:bind path="iterations">
                    <form:input path="iterations" type="text" id="iterations" placeholder="Iterations" />
                </spring:bind>

                <spring:bind path="value">
                    <form:input path="value" type="text" id="value" placeholder="Value" />
                </spring:bind>

                <button type="submit">Calculate</button>
            </form:form>

        </td>
    </tr>
</table>
<c:if test="${result != null}">
<table>
    <tr>
        <td>Result value</td>
        <td>Result time</td>
        <td>Result type</td>
    </tr>
    <tr>
        <td>${result}</td>
        <td>${time}</td>
        <td>${type}</td>
    </tr>
</table>
</c:if>

</body>
</html>