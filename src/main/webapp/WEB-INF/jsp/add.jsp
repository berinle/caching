<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

Add Employee
<table>
	<form:form modelAttribute="employee">
		<tr>
			<td>Employee id:</td>
			<td><form:input path="employeeNo"/></td>
		</tr>
		<tr>
			<td>First name:</td>
			<td><form:input path="firstName"/></td>
		</tr>
		<tr>
			<td>Last name:</td>
			<td><form:input path="lastName"/></td>
		</tr>
		<tr>
			<td>Hire Date:</td>
			<td><form:input path="hireDate"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Add"/></td>
			<td><a href="<c:url value="/app/paging"/>">Cancel</a></td>
		</tr>
	</form:form>
</table>