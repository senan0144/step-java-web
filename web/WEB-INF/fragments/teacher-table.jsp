<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.step.course.model.Teacher" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script>
    $(function () {
        $('#idTableTeacher').DataTable();
    });
</script>

<table id="idTableTeacher" class="display cell-border">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Course name</th>
        <th>Course duration</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>

<c:forEach var="teacher" items="${teacherList}">
    <tr>
        <td>${teacher.id}</td>
        <td>${teacher.firstName}</td>
        <td>${teacher.lastName}</td>
        <td>${teacher.course.name}</td>
        <td>${teacher.course.duration}</td>
        <td><a href="#" onclick="deleteTeacher('${teacher.id}')" style="text-align: center">
            <i class="fas fa-user-times" style="display: block"></i>
        </a></td>
    </tr>
</c:forEach>


    </tbody>
</table>
