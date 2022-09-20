$(document).ready(function() {
    const btnShareTw = document.querySelector('#shareTw');
    btnShareTw.addEventListener('click', () => {
        const sendText = '나에게 어울리는 아이스크림은?';
        const pageUrl = 'news.v.daum.net/v/20220319120213003';
        window.open(`https://twitter.com/intent/tweet?text=${sendText}&url=${pageUrl}`);
    })

    const btnShareFb = document.querySelector('#shareFb');
    btnShareFb.addEventListener('click', () => {
        const pageUrl = 'news.v.daum.net/v/20220319120213003';
        window.open(`http://www.facebook.com/sharer/sharer.php?u=${pageUrl}`);
    })

});
