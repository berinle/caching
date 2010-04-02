<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<a href="<c:url value="/app/add"/>">Add Employee</a>

<%--
<h2>List of Employees</h2>
<table>
<c:forEach items="${employees}" var="emp">
	<tr>
		<td>${emp.id}</td>
		<td>${emp.firstName}</td>
		<td>${emp.lastName}</td>
		<td>${emp.employeeNo}</td>
		<td>${emp.hireDate}</td>
	</tr>
</c:forEach>
</table>
 --%>
 
<h2>List of Employees</h2>
<display:table name="${employees}" id="emp" pagesize="100" requestURI="${requestURI}" sort="list">
	<display:column title="Employee ID" property="id"/>
	<display:column title="Firstname" sortable="true" property="firstName"/>
	<display:column title="Lastname" sortable="true" property="lastName"/>
	<display:column title="Employee No." property="employeeNo"/>
	<display:column title="Hire Date" property="hireDate"/>
</display:table>
 