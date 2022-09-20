    // document.querySelector('#selectQuery').innerHTML = selectQuery;
let queryModule = {}; // 질의문 관련 묘듈

(function(_module){
    let queryList = []; // HTML을 포함한 질문 리스트
    let sex = true; // 샘플데이터
    let age = 26; // 샘플데이터
    let selectedQuery;
    let selectedNum;

    function makeButton(btnClass, btnText){
        let btn = document.createElement('button');
        btn.classList.add(btnClass);
        btn.innerHTML = btnText;
        return btn;
    }
    function makeArticle(data){
        let title = ['테스트1', '테스트2', '테스트3' ];
        let totalLength = title.length;
        const getArticles = document.querySelector('.article');
        let dataJson;
        let b = makeButton('showResultText','결과보기');
        let c = makeButton('returnHome', '처음으로');

        b.addEventListener("click", ()=>{
            checkSelectNull();
            get('localhost:8080','checklist/findAll2' )
                .then(data =>{
                    dataJson = data;
                    selectedNum = document.querySelector('input[type=radio][name=select]:checked').value;
                    document.querySelector('.question').style.display ='none';
                    document.querySelector('.answer').style.display ='none';
                    document.querySelector('.start').appendChild(c);
                    document.querySelector('.showResultText').style.display = 'none';
                    document.querySelector('.article').innerHTML = `<div class="result"><p>${data[selectedQuery].resultText}</p>
<p>${data[selectedQuery].resultList[selectedNum]}</p></div>`;
                    // POST FETCH로 JSON 형식의 result 값을 db로 전송
                    let result = {
                        selectedQueryId: data[selectedQuery].id,
                        selectedNum: selectedNum,
                        resultText: data[selectedQuery].resultText,
                        result: data[selectedQuery].resultList[selectedNum],
                        age: age,
                        sex: sex
                    }
                    post('localhost:8080','checklist/saveData',result)
                        .then(data => {
                            console.log('data // POST FETCH 후 리턴된 데이터')
                            console.log(data);
                        })
                        .catch((error)=>console.log(`error : ${error}`));
                })
        });
        c.addEventListener('click', ()=>{
            window.location.href = document.location.href;
        });
        for(let obj in data){
            let article = makeButton('answerList', title[obj]);
            getArticles.appendChild(article);


            article.addEventListener("click", ()=>{
                document.querySelector('.start').innerHTML = '';
                document.querySelector('.article').innerHTML = queryList[obj];
                document.querySelector('.start').appendChild(b);
                selectedQuery = obj;
            })
        }
    }

    function makeQueryList(data){ // 변수에 입력된 JSON 데이터를 HTML태그로 감싸서 queryList에 넣는다.
        for(let el of data){
            let query = `<div class="question"><button class="questionBox">${el.question}</button><br/></div>`;
            for(let obj in el.answer){
                query+= `<div class="answer"></div><input type="radio" class="selection" name="select" value=${parseInt(obj)}>${(el.answer)[obj]}<br/>`;
            }
            query+=`</div>`;
            queryList.push(query);
        }
    }

    function checkSelectNull(){ // radio 선택 버튼의 null 체크.
        let a = document.querySelector('input[type=radio][name=select]:checked');
        console.log(a);
        a === null || undefined ? (()=>{alert('선택하지 않았습니다.'); throw new Error('NULL  에러입니다')})() : null ; }

    function start(){
        document.querySelector('.start').innerHTML = '';
        document.querySelector('.article').innerHTML = '';
        const a = document.querySelector('.start');
        let b = makeButton('selectTest', '원하는 심리테스를 선택하세요');
        a.appendChild(b);

    }
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
            start();
            makeQueryList(data);
            makeArticle(data);
        })
        .catch(error =>console.log(`error : ${error}`)); // fetch는 요청 자체가 실패한 경우를 제외하고는  catch로 error가 넘어가지 않는다.
    };

})(queryModule);
