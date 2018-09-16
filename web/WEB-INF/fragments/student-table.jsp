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
    </tr>
    </thead>
    <tbody>
    <%
        List<Student> list = (List<Student>) request.getAttribute("studentList");
        for (Student s : list) {
    %>

    <tr>
        <td><%=s.getId()%></td>
        <td><%=s.getFirstName()%></td>
        <td><%=s.getLastName()%></td>
        <td><%=s.getDateOfBirth()%></td>
        <td><%=s.getCourse().getName()%></td>
        <td><%=s.getCourse().getTeacher().getFirstName()+" "+s.getCourse().getTeacher().getLastName()%></td>
    </tr>


    <%
        }
    %>


    </tbody>
</table>