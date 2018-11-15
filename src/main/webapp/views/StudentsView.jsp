<%@ page import="java.util.List" %>
<%@ page import="hibernate.Student" %><%--
  Created by IntelliJ IDEA.
  User: dinir
  Date: 13-Nov-18
  Time: 12:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students List</title>
    <link rel="stylesheet" type="text/css"href="views/sheet.css">
</head>
<body>
<h1>List of Students with personal info</h1> <button name="logout" method = "post">Logout</button>
<br/>
<table style="width: 50%">
    <tr>
        <th>Fullname</th>
        <th>Date of Birth</th>
        <th>Nationality</th>
    </tr>

<%
    List<Student> studentList = (List<Student>) request.getAttribute("studentList");
    for (Student student : studentList) {
        out.println("<tr><td>" + student.getName() + " " + student.getSurname() + "</td><td>" + student.getDate_of_birth() + "</td><td>" + student.getNationality() + "</td></tr>");
    }
%>



</body>
</html>
