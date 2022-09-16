const main = document.querySelector("#main");
const qna = document.querySelector("#qna");
const result = document.querySelector("#result");
const finish = document.querySelector("#finish");
const endPoint = 12;
// const select = [0,0,0,0,0,0,0,0,0,0,0,0]; //결과값 저장을 위한 배열
const select = [0,0,0,0,0,0,0,0,0,0,0,0];
let paramData;

function calResult(){ //결과값 계산
    var result = select.indexOf(Math.max(...select)); //...select <- 전개구문으로써 선택한 배열을 펼치게해줌.//배열의 최대값을 가지고있는 인덱스를 result에 저장
    return result;
}

function insertResult() {
    let pointData = calResult();
    paramData = infoList[pointData].param;

    $.ajax({
        type: "POST",            // HTTP method type(GET, POST) 형식이다.
        url: "/insertResult",      // 컨트롤러에서 대기중인 URL 주소이다.
        data: {
            tresult: paramData
        },            // Json 형식의 데이터이다.
        dataType: "json",
        success: function (res) { // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
            location.href = "/ys/ysfinish"
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) { // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
            location.href = "/ys/ysfinish"
        }
    });
}

function setResult_ys(){
    let point = calResult();
    const finishName = document.querySelector('.finishname');
    finishName.innerHTML = infoList[point].name; //infoList의 n번째 name값을 가져와 innerHTML.. 사악하다..!!

    var finishImg = document.createElement('img');
    const imgDiv = document.querySelector('#finishImg');
    var imgURL = '/img/image-ys' + point + '.png';

    finishImg.src = imgURL;
    finishImg.alt = point;
    finishImg.classList.add('img-fluid');
    imgDiv.appendChild(finishImg);

    const finishDesc = document.querySelector('.finishDesc');

    finishDesc.innerHTML = infoList[point].desc;
}

function goResult(){
    qna.style.WebkitAnimation = "fadeOut 1s";
    qna.style.animation = "fadeOut 1s";

    setTimeout(()=> {
        result.style.WebkitAnimation = "fadeIn 1s";
        result.style.animation = "fadeIn 1s";
        setTimeout(() => {
            qna.style.display = "none";
            result.style.display = "block";
        }, 450)
    })
    // setResult();
}








function addAnswer(answerText, qIdx, idx) {
    var a = document.querySelector('.answerBox'); //answerBox라는 div 태그안에
    var answer = document.createElement('button'); //버튼 생성

    answer.classList.add('answerList'); //버튼에 ID값이 없어서 answer변수의 classList에 answerList 이름으로 클래스값 대입
    answer.classList.add('my-3');
    answer.classList.add('py-3');
    answer.classList.add('mx-auto');
    answer.classList.add('fadeIn');

    a.appendChild(answer); //answer 버튼이 a에 소속되도록 처리
    answer.innerHTML = answerText; //a 배열의 answer값 대입

    answer.addEventListener("click", function () {
        var children = document.querySelectorAll('.answerList'); //쿼리 셀렉터를 통해 버튼을 모두 선택

        for(let i=0 ; i<children.length ; i++){
            children[i].disabled=true;
            children[i].style.WebkitAnimation = "fadeOut 0.5s";
            children[i].style.animation = "fadeOut 0.5s";
            // children[i].style.display = 'none' //버튼이 바로 없어지면안되니까 아래 반복문에서 처리
        }
        setTimeout(() => {
            // select[qIdx] = idx; //qidx 번째 질문에 idx번째 버튼값을 넣어줌.
            // => 여기 부분을 아래와 같이 개선
            var target = qnaList[qIdx].a[idx].type;
            for (let i = 0; i < target.length; i++) {
                select[target[i]] += 1; //qidx의 선택된 idx값의 타입 값을 1씩 늘림
            }

            for(let i = 0; i<children.length; i++) {
                children[i].style.display = 'none';
            }
            goNext(++qIdx);
        }, 450)
    }, false); //버튼 클릭 감지하기위해 이벤트 리스너 추가
}





function goNext(qIdx){

    if (qIdx === endPoint) {
        goResult();

        return;
    }

    var q = document.querySelector('.qBox');
    q.innerHTML = qnaList[qIdx].q;

    for (let i in qnaList[qIdx].a) {
        addAnswer(qnaList[qIdx].a[i].answer, qIdx, i);
    }

    var status = document.querySelector('.statusBar') //statusBar 클래스값을 대입
    status.style.width = (100 / endPoint) * (qIdx + 1) + '%';

}





function begin() {
    main.style.WebkitAnimation = "fadeOut 1s";
    main.style.animation = "fadeOut 1s";

    setTimeout(()=>{
        qna.style.WebkitAnimation = "fadeIn 1s";
        qna.style.animation = "fadeIn 1s";
        setTimeout(()=>{
            main.style.display = "none";
            qna.style.display = "block";
        }, 450)

        let qIdx = 0;

        goNext(qIdx);
    }, 450);

}