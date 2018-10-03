var newData;

$(function () {

    $('#idButtonStudent').click(function () {
        getStudentTable();
    });

    $('#idButtonTeacher').click(function () {
        getTeacherTable();
    });

    $('#idButtonCourse').click(function () {
        getCourseTable();
    });

    $('#idButtonNewData').click(function () {
        switch (newData) {
            case "student":
                openNewStudentDialog();
                //title set olunmalidir..
                break;
            case "teacher":
                break;
            case "course":
                break;
            default:
                alert("Please select action from menu!")
                break;
        }
    });

});


function getStudentTable() {

    $.ajax({
        url: '/ss?action=getAllStudent',
        type: 'GET',
        dataType: 'html',
        success: function (data) {
            $('#idDivStudentData').html(data);

            $('#idDivStudentData').show();
            $('#idDivTeacherData').hide();
            $('#idDivCourseData').hide();
        }
    });

    newData = "student";
}

function getTeacherTable() {

    $.ajax({
        url: '/ts?action=getAllTeacher',
        type: 'GET',
        dataType: 'html',
        success: function (data) {
            $('#idDivTeacherData').html(data);

            $('#idDivStudentData').hide();
            $('#idDivTeacherData').show();
            $('#idDivCourseData').hide();
        }
    });

    newData = "teacher";
}

function getCourseTable() {

    $.ajax({
        url: '/cs?action=getAllCourse',
        type: 'GET',
        dataType: 'html',
        success: function (data) {
            $('#idDivCourseData').html(data);

            $('#idDivStudentData').hide();
            $('#idDivTeacherData').hide();
            $('#idDivCourseData').show();
        }
    });

    newData = "course";
}

function deleteStudent(id) {
    var cond = confirm('Are you sure?');

    if (cond) {
        $.ajax({
            url: '/ss?action=deleteStudent',
            type: 'POST',
            data: 'id=' + id,
            success: function () {
                alert('Student deleted!');
                getStudentTable();
            },
            error: function () {
                alert('Error while deleting student!');
            }
        });
    }
}

function deleteTeacher(id) {
    var cond = confirm("Are you sure?");

    if (cond) {
        $.ajax({
           url: '/ts?action=deleteTeacher',
           type: 'POST',
           data: 'id='+id,
            success: function () {
                alert('Teacher deleted!');
                getTeacherTable();
            },
            error: function () {
                alert('Error while deleting teacher!');
            }
        });
    }
}

function deleteCourse(id) {
    var cond = confirm("Are you sure?");

    if (cond) {
        $.ajax({
            url: '/cs?action=deleteCourse',
            type: 'POST',
            data: 'id='+id,
            success: function () {
                alert('Course deleted!');
                getCourseTable();
            },
            error: function () {
                alert('Error while deleting course!');
            }
        });
    }
}

function openNewStudentDialog() {
    $.ajax({
        url: '/ns?action=getNewStudentJsp',
        type: 'GET',
        dataType: 'html',
        success: function (data) {
            $('#idDialogNewData').html(data);
            $('#idDialogNewData').dialog('open');
        }
    });
}

function addStudent() {
    var firstName = $('#idInputStudentFirstName').val();
    var lastName = $('#idInputStudentLastName').val();
    var dateOfBirth = $('#idInputStudentDateOfBirth').val();
    var idTeacher = $('#idSelectStudentTeacher').val();

    $.ajax({
        url: '/ss?action=addStudent',
        type: 'POST',
        data: 'firstName=' + firstName + '&lastName=' + lastName + '&dateOfBirth=' + dateOfBirth + '&idTeacher=' + idTeacher,
        success: function () {
            alert('Student added!');
            $('#idDialogNewData').dialog("close");
            getStudentTable();
        }
    });
}

function getUpdateStudentJsp(id) {
    $.ajax({
        url: '/ns?action=getStudentById',
        type: 'GET',
        data: "id="+id,
        dataType: 'html',
        success: function (data) {
            $('#idDialogUpdateData').html(data);
            $('#idDialogUpdateData').dialog('open');
        }
    });
}

function updateStudent() {
    var firstName = $('#idInputStudentFirstName').val();
    var lastName = $('#idInputStudentLastName').val();
    var dateOfBirth = $('#idInputStudentDateOfBirth').val();
    var idTeacher = $('#idSelectStudentTeacher').val();
    var idStudent = $('#idSelectStudentId').val();

    $.ajax({
        url: '/ss?action=updateStudent',
        type: 'POST',
        data: 'id=' + idStudent + '&firstName=' + firstName + '&lastName=' + lastName + '&dateOfBirth=' + dateOfBirth + '&idTeacher=' + idTeacher,
        success: function () {
            alert("Student updated!");
            $('#idDialogUpdateData').dialog("close");
            getStudentTable();
        }
    });
}