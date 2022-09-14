const main = document.querySelector("#main");
const qna = document.querySelector("#qna");
const result = document.querySelector("#result");
const endPoint = 12;
// const select = [0,0,0,0,0,0,0,0,0,0,0,0]; //결과값 저장을 위한 배열
const select = [];

function calResult(){ //결과값 계산
    var pointArray = [
        {name: 'mouse', value: 0, key: 0},
        {name: 'cow', value: 0, key: 1},
        {name: 'tiger', value: 0, key: 2},
        {name: 'rabbit', value: 0, key: 3},
        {name: 'dragon', value: 0, key: 4},
        {name: 'snake', value: 0, key: 5},
        {name: 'horse', value: 0, key: 6},
        {name: 'sheep', value: 0, key: 7},
        {name: 'monkey', value: 0, key: 8},
        {name: 'chick', value: 0, key: 9},
        {name: 'dog', value: 0, key: 10},
        {name: 'pig', value: 0, key: 11},
    ]
    for(let i=0; i<endPoint; i++) {
        var target = qnaList[i].a[select[i]];
        for(let j=0; j<target.type.length; j++){ //type의 길이가 아닌 타겟의 타입에 대한 길이로 잡아야 오류가 안남
            for (let k=0; k<pointArray.length; k++) {
                if(target.type[j] === pointArray[k].name){
                    pointArray[k].value += 1;
                }
            }
        }
    }

    var resultArray = pointArray.sort(function (a,b){
        if(a.value > b.value){
            return -1;
        }
        if(a.value < b.value){
            return 1;
        }
        return 0;
    });

    console.log(resultArray);
    let resultword = resultArray[0].key;
    return resultword;
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
    calResult();
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
            main.style.WebkitAnimation = "fadeOut 0.5s";
            main.style.animation = "fadeOut 0.5s";
            // children[i].style.display = 'none' //버튼이 바로 없어지면안되니까 아래 반복문에서 처리
        }
        setTimeout(() => {
            select[qIdx] = idx; //qidx 번째 질문에 idx번째 버튼값을 넣어줌.
            for(let i = 0; i<children.length; i++) {
            children[i].style.display = 'none';
        }
            goNext(++qIdx);
        }, 450)
    }, false); //버튼 클릭 감지하기위해 이벤트 리스너 추가
}

function goNext(qIdx){

    if (qIdx === endPoint) {
        goResult(); //추후 여기서 DB보내는 작업을 할 예정

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