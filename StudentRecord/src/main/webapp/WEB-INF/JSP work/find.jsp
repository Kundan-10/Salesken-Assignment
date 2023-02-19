<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>find jsp</title>
</head>
<body>
    
    <table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Semesters</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${students}" var="s">
        <tr>
            <td>${s.getId()}</td>
            <td>${s.getName()}</td>
            <td>${s.getSemesters()}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
    
</body>
</html>