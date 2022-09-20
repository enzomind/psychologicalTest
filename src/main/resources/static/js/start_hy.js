const main = document.querySelector("#main");
const qna = document.querySelector("#qna");
const result = document.querySelector("#result");
const userinfo = document.querySelector("#userinfo");
let selection = {choice: ''};
let final = {};

const endPoint = 12;
const select = [0, 0];
var params;

function calResult() {
    console.log(select);
    var result;
    if (select[0] > select[1]) {
        result = 0;
    } else if (select[0] < select[1]) {
        result = 1;
    } else {
        result = 2;
    }
    return result;
}

function setResult() {
    let point = calResult();
    const resultName = document.querySelector('.resultname');
    resultName.innerHTML = infoList[point].name;

    var resultImg = document.createElement('img');
    const imgDiv = document.querySelector('#resultImg');
    var imgURL = 'img/image-' + point + '_hy.svg';
    resultImg.src = imgURL;
    resultImg.alt = point;
    resultImg.classList.add('img-fluid');
    imgDiv.appendChild(resultImg);

    const resultDesc = document.querySelector('.resultDesc');
    resultDesc.innerHTML = infoList[point].desc;

    var sentances = selection['choice'].slice(1).split('#');
    for (let i = 1; i < sentances.length + 1; i++) {
        final["a" + i] = sentances[i - 1]
    }
    final['result'] = resultName.innerHTML;
    insertUInfo()
    insertAInfo()

}

function insertUInfo() {
    // json 형식으로 데이터 set
    params = {
        mname: $("#name").val()
        , mgender: $("#gender").val()
        , mage: $("#age").val()
    }

    // ajax 통신
    $.ajax({
        type: "POST",            // HTTP method type(GET, POST) 형식이다.
        url: "/insertuserinfo",      // 컨트롤러에서 대기중인 URL 주소이다.
        data: params,            // Json 형식의 데이터이다.
        dataType: "json",
        success: function (res) { // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.

        },
        error: function (XMLHttpRequest, textStatus, errorThrown) { // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.

        }
    });

}

function insertAInfo() {
    $.ajax({
        type: "POST",            // HTTP method type(GET, POST) 형식이다.
        url: "/insertAnsInfo",      // 컨트롤러에서 대기중인 URL 주소이다.
        data: final,            // Json 형식의 데이터이다.
        dataType: "json",
        success: function (res) { // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) { // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
        }
    });
}


function goResult() {
    qna.style.WebkitAnimation = "fadeOut 1s";
    qna.style.animation = "fadeOut 1s";
    setTimeout(() => {
        result.style.WebkitAnimation = "fadeIn 1s";
        result.style.animation = "fadeIn 1s";
        setTimeout(() => {
            qna.style.display = "none";
            result.style.display = "block"
        }, 450)
    })
    setResult();

}

function addAnswer(answerText, qIdx, idx) {
    var a = document.querySelector('.answerBox');
    var answer = document.createElement('button');
    answer.classList.add('answerList');
    answer.classList.add('my-4');
    answer.classList.add('py-3');
    answer.classList.add('mx-auto');
    answer.classList.add('fadeIn');

    a.appendChild(answer);
    answer.innerHTML = answerText;

    answer.addEventListener("click", function () {
        var children = document.querySelectorAll('.answerList');
        for (let i = 0; i < children.length; i++) {
            children[i].disabled = true;
            children[i].style.WebkitAnimation = "fadeOut 0.5s";
            children[i].style.animation = "fadeOut 0.5s";
        }
        setTimeout(() => {
            var target = qnaList[qIdx].a[idx].type;
            var val = qnaList[qIdx].a[idx].answer;
            for (let i = 0; i < target.length; i++) {
                select[target[i]] += 1;
                selection['choice'] += '#' + val;
            }

            for (let i = 0; i < children.length; i++) {
                children[i].style.display = 'none';
            }
            goNext(++qIdx);
        }, 450)
    }, false);

}

function goNext(qIdx) {
    if (qIdx === endPoint) {
        goResult();
        return;
    }

    var q = document.querySelector('.qBox');
    q.innerHTML = qnaList[qIdx].q;
    for (let i in qnaList[qIdx].a) {
        addAnswer(qnaList[qIdx].a[i].answer, qIdx, i);
    }
    var status = document.querySelector('.statusBar');
    status.style.width = (100 / endPoint) * (qIdx + 1) + '%';
}

function begin() {
    main.style.WebkitAnimation = "fadeOut 1s";
    main.style.animation = "fadeOut 1s";
    setTimeout(() => {
        qna.style.WebkitAnimation = "fadeIn 1s";
        qna.style.animation = "fadeIn 1s";
        setTimeout(() => {
            main.style.display = "none";
            qna.style.display = "block"
        }, 450)
        let qIdx = 0;
        goNext(qIdx);
    }, 450);
}


function start() {

    if ($("#name").value === null || $("#age").value === null || $("#gender").value === null) {
        alert("자료를 입력해주세요.")
    } else {
        userinfo.style.WebkitAnimation = "fadeOut 1s";
        userinfo.style.animation = "fadeOut 1s";
        setTimeout(() => {
            main.style.WebkitAnimation = "fadeIn 1s";
            main.style.animation = "fadeIn 1s";
            setTimeout(() => {
                userinfo.style.display = "none";
                main.style.display = "block"
            }, 450);
        }, 450);
    }
}


function home() {
    window.location.href = 'index.html';
}