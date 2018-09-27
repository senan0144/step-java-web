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
       addNewData();
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

function addNewData() {

    $( "#idDivAddNewData" ).dialog({
        resizable: false,
        height: 600,
        width: 800,
        modal: true,
        buttons: {
            "Add data": function() {
                $( this ).dialog( "close" );
            },
            Cancel: function() {
                $( this ).dialog( "close" );
            }
        }
    });

    switch(newData) {
        case "student":
            $.ajax({
                url: '/cs?action=getStudentForm',
                type: 'GET',
                data: 'html',
                success: function (data) {
                    $('#idDivAddNewData').html(data);

                    $('#idDivStudentData').hide();
                    $('#idDivTeacherData').hide();
                    $('#idDivCourseData').hide();
                    $('#idDivAddNewData').show();
                }
            });
            break;
        case "teacher":
            $.ajax({
                url: '/cs?action=addTeacher',
                type: 'GET',
                data: 'html',
                success: function (data) {
                    $('#idDivAddNewData').html(data);

                    $('#idDivStudentData').hide();
                    $('#idDivTeacherData').hide();
                    $('#idDivCourseData').hide();
                    $('#idDivAddNewData').show();
                }
            });
            break;
        case "course":
            $.ajax({
                url: '/cs?action=addCourse',
                type: 'GET',
                data: 'html',
                success: function (data) {
                    $('#idDivAddNewData').html(data);

                    $('#idDivStudentData').hide();
                    $('#idDivTeacherData').hide();
                    $('#idDivCourseData').hide();
                    $('#idDivAddNewData').show();
                }
            });
            break;
        default:
            alert("Select student, teacher or course!");
    }
}