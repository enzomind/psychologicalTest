
$(document).ready(function(){

    $('button').click(function () {
        $('button').removeClass("on");
        $(this).addClass("on");
    });

    $('#UserSubmit').click(function () {
        if ($("#t_name").val().trim() == "") {
            alert("이름을 입력하세요.");
            $("#t_name").focus();
            return false;
        }
        if ($("#t_birth").val().trim() == "") {
            alert("생년월일을 입력하세요.");
            $("#t_birth").focus();
            return false;
        }
        if ($("#t_gender").val().trim() == "") {
            alert("성별을 입력하세요.");
            $("#t_gender").focus();
            return false;
        }
        userSubmit();
    });
});