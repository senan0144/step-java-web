
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
}

function deleteStudent(id) {
    var cond = confirm('Are you sure?');

    if(cond){
        $.ajax({
            url: '/ss?action=deleteStudent',
            type: 'POST',
            data: 'id='+id,
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



