$(document).ready(function() {
    var pages;
    var page_count;
    var page_position = 1;

    pages = $(".slide ul");
    page_count = pages.children().length;

    //input button 클릭했을 때 색 고정하기
    $('button').click(function () {
        $('button').removeClass("on");
        $(this).addClass("on");
    });

    //버튼을 클릭했을 때 함수 실행
    $('.back').click(function () {
        back();
    });
    $('.next').click(function () {
        next();
    });

    //input button id="back" 클릭했을 때 이전 방향으로 600만큼 이동하기
    function back() {
        if (1 < page_position) {
            pages.animate({
                left: '+=600px'
            });
            page_position--;
        }
    }

    //input button id="next" 클릭했을 때 다음 방향으로 600만큼 이동하기
    function next() {
        if (page_count > page_position) {
            pages.animate({
                left: '-=600px'
            });
            page_position++;
        }
    }

    $(function () {
        $('#off').click(function () {
            if($("#none").css("display") != "none") {
                $('#none').hide();
            }
        })
    })

    result = [];
    test = {};

    $('.next').click(function () {
        result.push($(this).val());
        console.log(result)
    });

    $('#testfinish').click(function () {
        for(i=1; i<result.length+1; i++) {
            test['test' + i] = result[i]
        };
        console.log(test)
        $.ajax( {
            type: "POST",
            url: '/testInsert',
            data: test,
            dataType: "text",
            success: function () { console.log(this.success); },
            error: function () { console.log(this.error); }
        });
    });

    $('.back').click(function () {
        result.pop();
    });

});
