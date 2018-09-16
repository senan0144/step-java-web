
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

    $('#idButtonTest').click(function () {
        testButtonClick();
    });

});


function studentButtonClick() {
    $('#idDivStudentData').show();
    $('#idDivTeacherData').hide();
    $('#idDivCourseData').hide();
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

function testButtonClick() {
    var name = $('#idInputName').val();
    var surname = $('#idInputSurname').val();

    $.ajax({
        url: '/cs?action=sayHello',
        type: 'POST',
        data: 'name='+name+'&surname='+surname,
        dataType: 'html',
        success: function (data) {
            console.log(data);
        }
    });
}


