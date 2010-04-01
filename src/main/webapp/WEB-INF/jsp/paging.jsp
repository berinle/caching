<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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