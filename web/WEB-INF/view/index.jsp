<%--
  Created by IntelliJ IDEA.
  User: Joshgun
  Date: 9/9/2018
  Time: 12:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" href="//cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">


    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/external/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="//cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/main.js"></script>
</head>
<body>
<div class="header"></div>
<div class="menu">

    <button id="idButtonStudent" class="menu-button">Student</button>
    <button id="idButtonTeacher" class="menu-button">Teacher</button>
    <button id="idButtonCourse" class="menu-button">Course</button>

</div>


<div class="main">
    <div style="margin: 20px">

        <div id="idDivStudentData" hidden>

        </div>
        <div id="idDivTeacherData" hidden>

        </div>
        <div id="idDivCourseData" hidden>

        </div>



    </div>

</div>
<div class="footer">
    <span class="footer-watermark">STEP IT Academy. Copyright 2018 (c)</span>
</div>

</body>
</html>
