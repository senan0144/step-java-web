<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.step.course.model.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script>
    $(function () {
        $('#idSelectStudentCourse').val(${student.teacher.course.id});
        $('#idSelectStudentTeacher').val(${student.teacher.id});
    });

    $('#idSelectStudentCourse').change(function () {
        var idCourse = $('#idSelectStudentCourse').val();

        if (idCourse.trim().length == 0) {
            $('#idSelectStudentTeacher').hide();
            return;
        }


        $.ajax({
            url: '/ts?action=getTeachersByCourseId',
            data: 'id='+idCourse,
            dataType: 'json',
            success: function (data) {
                $('#idSelectStudentTeacher').empty();
                $('#idSelectStudentTeacher').append(new Option('Select teacher..', ''));

                data.forEach(function (t) {
                    $('#idSelectStudentTeacher').append(new Option(t.firstName + " " + t.lastName, t.id));
                });

                $('#idSelectStudentTeacher').show();
            }
        });
    });
</script>

<span>First name</span>
<br>
<input type="text" id="idInputStudentFirstName" value="${student.firstName}">
<br><br>

<span>Last name</span>
<br>
<input type="text" id="idInputStudentLastName" value="${student.lastName}">
<br><br>

<span>Date of birth</span>
<br>
<input type="date" id="idInputStudentDateOfBirth" value="${student.dateOfBirth}">
<br><br>

<span>Course</span>
<br>
<select id="idSelectStudentCourse">
    <option value="">Select course..</option>

    <c:forEach var="course" items="${courseList}">
        <option value="${course.id}">${course.name}</option>
    </c:forEach>
</select>
<br><br>

<span>Teacher</span>
<br>
<select id="idSelectStudentTeacher">
    <option value="">Select teacher..</option>

    <c:forEach var="teacher" items="${teacherList}">
        <option value="${teacher.id}">${teacher.firstName} ${teacher.lastName}</option>
    </c:forEach>
</select>

<input type="text" id="idSelectStudentId" value="${student.id}" hidden>