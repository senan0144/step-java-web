<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.step.course.model.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script>
    $(function () {
        $('#idTableStudent').DataTable();
    });
</script>

<table id="idTableStudent" class="display cell-border">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Date of Birth</th>
        <th>Course</th>
        <th>Teacher</th>
        <th>Delete</th>
        <th>Update</th>
    </tr>
    </thead>
    <tbody>

<c:forEach var="student" items="${studentList}">
    <tr>
        <td>${student.id}</td>
        <td>${student.firstName}</td>
        <td>${student.lastName}</td>
        <td>${student.dateOfBirth}</td>
        <td>${student.teacher.course.name}</td>
        <td>${student.teacher.firstName} ${student.teacher.lastName}</td>
        <td><a href="#" onclick="deleteStudent('${student.id}');" style="text-align: center">
            <i class="fas fa-user-minus" style="display: block;"></i>
        </a></td>
        <td><a href="#" onclick="getUpdateStudentJsp('${student.id}');" style="text-align: center">
            <i class="fas fa-pencil-alt" style="display: block"></i>
        </a></td>
    </tr>
</c:forEach>




    </tbody>
</table>