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
    <link rel="stylesheet" type="text/css" href="../../resources/css/style.css">

    <script type="text/javascript" src="../../resources/js/external/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="../../resources/js/main.js"></script>
</head>
<body>
<div class="header"></div>
<div class="menu">

    <button id="idButtonSum">Sum</button>
    <button id="idButtonTest">Test</button>

</div>


<div class="main">
    <div style="margin: 20px">
        <!-- <table border="1px">
        <thead>
            <th>ID</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Address</th>
            <th>Phone number</th>
        </thead>
        <tbody>
            <tr>
                <td>1</td>
                <td>Memmed</td>
                <td>Eliyev</td>
                <td>Baki</td>
                <td>123-123-23</td>
            </tr>
            <tr>
                <td>2</td>
                <td>Gulnar</td>
                <td>Veliyeva</td>
                <td>Sumqayit</td>
                <td>123-32-32</td>
            </tr>
        </tbody>
    </table> -->
        <%
            if (request.getAttribute("message") != null) {
        %>

        <span style="color: red"> <%=request.getAttribute("message")%> </span>
        <br>

        <%
            }
        %>
        <form action="/cs?action=register" method="post">

            <span>First name:</span>
            <input type="text" placeholder="Enter your first name" name="firstName" >
            <br><br>
            <span>Last name:</span>
            <input type="text" placeholder="Enter your last name" name="lastName" >
            <br><br>
            <span>Password:</span>
            <input type="Password" placeholder="***********" name="password">
            <br><br>
            <span>Date of birth:</span>
            <input type="date" name="dob">
            <br><br>
            <span>Gender:</span>
            <input type="radio" name="gender" value="male" checked><span>Male</span>
            <input type="radio" name="gender" value="female"><span>Female</span>
            <br><br>
            <span>Languages:</span>
            <input type="checkbox" name="lang" value="aze"><span>Aze</span>
            <input type="checkbox" name="lang" value="eng"><span>Eng</span>
            <input type="checkbox" name="lang" value="ru"><span>Rus</span>
            <br><br>
            <span>Address:</span>
            <select name="address">
                <option value="">Select address...</option>
                <option value="1">Baku</option>
                <option value="2">Sumgait</option>
                <option value="3">Ganja</option>
            </select>
            <br><br>
            <span>Description:</span>
            <textarea cols="20" rows="4" name="desc"></textarea>
            <br><br>
            <input type="reset" value="Temizle">
            <input type="submit" value="Gonder">
            <input type="button" value="Button" id="registerButtonId">
        </form>


        <form action="/cs?action=login" method="post">
            <span>Username:</span>
            <input type="text" placeholder="Enter your username" name="username" id="idUsername">
            <br><br>
            <span>Password:</span>
            <input type="Password" placeholder="***********" name="password">
            <br>
            <input type="submit" value="Login">
        </form>
        <br><br><br>



    </div>

</div>
<div class="footer">
    <span class="footer-watermark">STEP IT Academy. Copyright 2018 (c)</span>
</div>

</body>
</html>
