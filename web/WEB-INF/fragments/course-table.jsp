<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.step.course.model.Course" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script>
    $(function () {
        $('#idTableCourse').DataTable();
    });
</script>

<table id="idTableCourse" class="display cell-border">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Duration</th>
    </tr>
    </thead>
    <tbody>

<c:forEach var="course" items="${courseList}">
    <tr>
        <td>${course.id}</td>
        <td>${course.name}</td>
        <td>${course.desc}</td>
        <td>${course.duration}</td>
    </tr>

</c:forEach>


    </tbody>
</table>