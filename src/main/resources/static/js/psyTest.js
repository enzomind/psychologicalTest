    // document.querySelector('#selectQuery').innerHTML = selectQuery;
let queryModule = {}; // 질의문 관련 묘듈

(function(_module){
    let queryList = []; // HTML을 포함한 질문 리스트
    let num = 0;
    let result = {
        selection:""
    };
    let sex = true; // 샘플데이터
    let age = 26; // 샘플데이터

    function getNum(){
    return num;
    }

    function makeQueryList(data){ // 변수에 입력된 JSON 데이터를 HTML태그로 감싸서 queryList에 넣는다.
    for(let obj in data){
    let query = `<div class="queryBox">
                    <div><button class="questionBox" >${data[obj].id}. ${data[obj].question}</button></div>
                    <div ><input type="radio" name="select" value=1>${data[obj].selection01}<br/>
                    <input type="radio" name="select" value=2>${data[obj].selection02}<br/></div>
                    </div>`;
    queryList.push(query);
    }
    }

    function next(){ // num에 따라 queryList에 넣어진 결과값을 출력한다.
        result[`selection`] += document.querySelector('input[type=radio][name=select]:checked').value;
        num++;
        console.log('다음을 누른 결과 값');
        console.log(result);
        document.querySelector('#query').innerHTML = queryList[getNum()];
    };

    function previous(){ // 이전 버튼을 누르면 질문지가 바뀌고 result에 저장된 값이 삭제된다.
        num--;
        document.querySelector('#query').innerHTML = queryList[getNum()];
        console.log(result[`selection`]);
        result[`selection`] = result[`selection`].substring(0, result[`selection`].length-1);
        console.log(result[`selection`]);
        // document.querySelector('input[type=radio][name=select]:checked').value;
        console.log('이전을 누른 결과 값');
        console.log(result);
    };

    function checkSelectNull(){ // radio 선택 버튼의 null 체크.
        let a = document.querySelector('input[type=radio][name=select]:checked');
        console.log(a);
        a === null || undefined ? (()=>{alert('선택하지 않았습니다.'); throw new Error('NULL  에러입니다')})() : null ;
    };

    function makeResult(){ // 마지막 질문지를 마치고 난 뒤 결과값 출력하는 함수. + 결과값 result를 서버로 전송.
        num = queryList.length;
        showHideBtn();
        result[`selection`] += document.querySelector('input[type=radio][name=select]:checked').value;
        result.sex = sex;
        result.age = age;
        document.querySelector('#query').innerHTML = '끝났습니다. 결과값이 나오는 창입니다.';
        console.log('다음을 누른 결과 값');
        console.log(result);

        // POST FETCH로 JSON 형식의 result 값을 db로 전송
        post('localhost:8080','checklist/saveData',result)
        .then(data => {
            console.log('data // POST FETCH 후 리턴된 데이터')
            console.log(data);
        })
        .catch((error)=>console.log(`error : ${error}`));
    }

    function showHideBtn(){
        const nextBtn = document.getElementById('nextBtn');
        const prevBtn = document.getElementById('prevBtn');
        const initBox = document.querySelector('.initBox');
        const clearBtn = document.getElementById('clearBtn');
        (num !== 0 && num !== queryList.length) ? (() =>{prevBtn.disabled = false; nextBtn.disabled = false;})()
        : (num === 0) ?  (() => {prevBtn.disabled = true;})() : (() => {nextBtn.disabled = true;})();

        if(queryList.length !== 0){initBox.style.display ='none';} // 시작시 시작버튼 숨김.

        num === 0 ? (() => {clearBtn.disabled = true;})() : (() => {clearBtn.disabled = false;})();
        // queryDb.length !== 0 ? (() =>initBox.style.displayed = 'none')() : (()=>initBox.style.display = 'block')()
        // queryDb.length !== 0 ? (() =>initBtn.style.display = 'none')() : (()=>initBtn.style.display = 'block')();
        // num === 0 ? (() => {clearBtn.style.display = 'none';})() : (() => {clearBtn.style.display = 'block';})();
        // (num !== 0 && num !== queryList.length) ? (() =>{prevBtn.style.display = 'inline'; nextBtn.style.display = 'inline';})()
        // : (num === 0) ?  (() => {prevBtn.style.display = 'none'; nextBtn.style.display = 'inline' })() : (() => {prevBtn.style.display = 'inline'; nextBtn.style.display = 'none'})();
    };

    // ======================== FETCH FUNCTION(custom) ==========================================

    // GET FETCH
    async function get(host, path, body, headers ={}){
        const url = `http://${host}/${path}`;
        const options = {
            method: 'GET',
            headers: {
            'Content-Type': 'application/json',
            ...headers,
            },
            body: JSON.stringify(body),
        };
        const response = await fetch(url, options); // Response {status: 200, ok: true, redirected: false, type: "cors", url: "url", …}
        const data = await response.json();
        console.log("response =============")
        console.log(response);
        return response.ok ? data : new Error(response); // Error: [object Response]
    }

    // POST FETCH
    async function post(host, path, body, headers ={}){
        const url = `http://${host}/${path}`;
        const options = {
            method: 'POST',
            headers: {
            'Content-Type': 'application/json',
            ...headers,
            },
            body: JSON.stringify(body),
        };
        const response = await fetch(url, options); // Response {type: "cors", url: "url", redirected: false, status: 201, ok: true, …}
        const data = await response.json();
        return response.ok ? data : new Error(data);
    }

    // ====================================================================================


    _module.initQuery = () =>{ // db에서 질문 데이터를 fetch로 받은 후 초기화면을 셋팅한다.
    get('localhost:8080','checklist/findAll')
        .then(data => {
            console.log('data // FETCH로 받아온 데이터(객체 리스트): ');
            console.log(data);
            makeQueryList(data);
            document.querySelector('#query').innerHTML = queryList[getNum()];
            document.querySelector('#button').innerHTML =
            `<div class="btnBox1">
            <button onclick="queryModule.prevQuery()" class="prev_next_btn prev" id="prevBtn">이전</button>
            <button onclick="queryModule.nextQuery()" class="prev_next_btn next" id="nextBtn">다음</button>
            </div>
            <div class="btnBox2">
            <button onclick="queryModule.clearQuery()" id="clearBtn">처음으로</button>
            </div>
            <div class="btnBoxAd">
            </div>`;
            showHideBtn();
        })
        .catch(error =>console.log(`error : ${error}`)); // fetch는 요청 자체가 실패한 경우를 제외하고는  catch로 error가 넘어가지 않는다.
    };

    _module.prevQuery = () =>{ // 이전 버튼 누를시 실행
        previous();
        showHideBtn();
    };
    _module.nextQuery = () =>{ // 다음 버튼 누를 시 실행
        checkSelectNull();
        (num+1) === queryList.length ? makeResult(): next();
        showHideBtn();
    };

    _module.clearQuery = () =>{ // num을 0으로 만들고 해당 쿼리문을 출력한다. 초기화 버튼 누를 시 실행
        num = 0;
        console.log(num);
        result = {};
        console.log('초기화된 result 값');
        console.log(result);
        document.querySelector('#query').innerHTML = queryList[getNum()];
        showHideBtn();
    };
})(queryModule);

// function testA(){
//     let a = document.getElementsByClassName('test');
//     for(let k of a){
//         console.log(k);
//         console.log(k.value);
//     }
//     let c = document.getElementsByClassName('test1');
//     for(let k of c){
//         console.log(k);
//         console.log(k.value);
//     }
// }
// let b = null;
// function testB(e){
//     b = e.value;
//     console.log(e.id);
// }
//
// function next(){
//     if(b === null){
//         alert("d안돼");
//     }
// }




