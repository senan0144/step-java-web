var a = 5;
var b = 4;
var name = 'Memmed';
var cond = true;

$(function () {

    $('#idButtonSum').click(function () {
        sum();
    });

    $('#idButtonTest').click(function () {
        var usernameValue = $('#idUsername').val();
        alert(usernameValue);
        $('#idUsername').val('TEST');
    });


});


function sum() {
    var c = a + b;
    console.log('Cem = ' + c);
    return c;
}

function test(a, c, v) {
    var z = sum();
    var j = a + c;
    console.log('J = ' + j);

}

function test2() {
    test(1, 2, 'salam');
}


function onSumButtonClick() {

}


