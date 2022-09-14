// $(function(){
//     $("#confirm").submit(function() {
//         if ($("#t_name").val().trim() == "") {
//             alert("이름을 작성하세요.");
//             $("#t_name").focus();
//             return false;
//         }
//     });
// });

$(document).ready(function(){
    var pages;
    var page_count;
    var page_position = 1;

    pages = $(".slide ul");
    page_count = pages.children().length;

    //버튼 글자 변경
    $(function() {
        $('#next').click(function() {
            if ($(this).val(1) == '시작하기') {
            }
            else {
                $(this).val('다음');
                $('#back').val('이전');
            }
        });
    });

    //input button 클릭했을 때 색 고정
    $('input').click(function () {
        $('input').removeClass("on");
        $(this).addClass("on");
    });

    //버튼을 클릭했을 때 함수 실행
    $('#back').click(function () {
        back();
    });
    $('#next').click(function () {
        $("#confirm").submit(function() {
            if ($("#t_name").val().trim() == "") {
                alert("이름을 작성하세요.");
                $("#t_name").focus();
                return back();
            }
        });
        next();
    });

    function back() {
        if(1<page_position){
            pages.animate({
                left:'+=600px'
            });
            page_position--;
        }
    }
    function next() {
        if(page_count>page_position){
            pages.animate({
                left:'-=600px'
            });
            page_position++;
        }
    }
});