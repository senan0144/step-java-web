
$(function () {

    $('#idButtonStudent').click(function () {
        studentButtonClick();
    });

    $('#idButtonTeacher').click(function () {
        teacherButtonClick();
    });

    $('#idButtonCourse').click(function () {
        courseButtonClick();
    });


});


function studentButtonClick() {

    $.ajax({
        url: '/cs?action=getAllStudent',
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

function teacherButtonClick() {
    $('#idDivStudentData').hide();
    $('#idDivTeacherData').show();
    $('#idDivCourseData').hide();
}

function courseButtonClick() {
    $('#idDivStudentData').hide();
    $('#idDivTeacherData').hide();
    $('#idDivCourseData').show();
}



