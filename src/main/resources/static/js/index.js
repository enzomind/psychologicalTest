$(document).ready(function () {
    $("#wrap>#main_banner>#slide>.slide_banner").hover(function () {
        $(this).find("img").css("box-shadow", "5px 5px 5px gray");
    },  function () {
        $(this).find("img").css("transform", "scale(1.0)","transition", "0.5s");
    });

    $("#content>.link>.test").hover(function () {
        $(this).css("transform", "scale(1.1)");
    },  function () {
        $(this).css("transform", "scale(1.0)");
        
    });

    $("#left").click(function() {
        var left = 0;
        left++;
        var next= left * 600 +'px';
        $("#slide").animate( {
           left: next
          }, 1000 );
    })
    $("#right").click(function() {
        var right = 0;
        right++;
        var next1= right * (-900) +'px';
        $("#slide").animate( {
           left: next1
          }, 1000 );
        
    })

})