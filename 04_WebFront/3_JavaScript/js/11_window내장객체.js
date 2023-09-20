document.body.scrollIntoView(false);

// [window.]setTimeout(함수, 지연시간(ms))

const test1 = document.querySelector("#test1");

test1.addEventListener("click", () => {

  // setTimeout()은 비동기로 동작!!
  // ex) 핸드폰 타이머 맞춰두고 그 시간동안 내가 다른 동작을 한다고 생각하면 이해하기 쉬움!

  // - 비동기 - 
  // 현재 코드를 수행할 때 다음 코드가 기다리지 않고 동시 수행
  console.log("0초");

  setTimeout(()=>{
    console.log("1초");
  }, 1000); // 1초 후 수행

  setTimeout(()=>{
    console.log("2초");
  }, 2000); // 2초 후 수행


  setTimeout(() => {
    console.log("3초 후에 실행된 log 입니다.");
  }, 3000); // 3000ms = 3초

console.log("setTimeout() 종료 후에 실행되겠지??");
});



// [window.]setTimeout(함수, 지연시간(ms))
const target2 = document.querySelector("#target2");
const test2 = document.querySelector("#test2");

// test2 클릭 시 target2의 내용을 1씩 증가
test2.addEventListener("click", () => {
  
  setInterval(()=>{
    ++target2.innerText;
  }, 1000);

  // 버튼 비활성화 
  // -> 추가 클릭으로 인한 무분별한 인터벌 생성 방지
  test2.disabled = true;

});

// [window.]clearInterval( setTimeout() )

/* 스톱워치 만들기 */
const stopwatch = document.querySelector("#stopwatch");
const startBtn = document.querySelector("#start");
const stopBtn = document.querySelector("#stop");

// START 버튼 클릭 시 생성된 setInterval을 저장할 변수
let stopwatchInterval; 

// START 
startBtn.addEventListener("click", ()=>{

  // 이전 START 버튼 클릭으로 생성된 setInterval을 지움
  clearInterval(stopwatchInterval);

  let count = 0; // 클릭 후 지난 시간을 세기위한 변수
  // count == 1 == 0.01초
  // count == 100 == 1초

  stopwatchInterval = setInterval( ()=>{
    count++; // 0.01초 지남

    let min = Math.floor(count / 100 / 60);
    let sec = Math.floor(count / 100 % 60);
    let ms  = count % 100;

    // 한자리인 ㅣ경우
    if(min < 10) min = "0" + min;
    if(sec < 10) sec = "0" + sec;
    if(ms < 10) ms = "0" + ms;





    stopwatch.innerText = min + ":" + sec + ":" + ms;


  }, 10 ); // 0.01초 마다 동작

});

// STOP
stopBtn.addEventListener("click", ()=>{

    clearInterval(stopwatchInterval);
});



/* window.open() */
const open1 = document.querySelector("#open1");
const open2 = document.querySelector("#open2");
const open3 = document.querySelector("#open3");

// 새 탭으로 열기
open1.addEventListener("click", () => {
  window.open("https://www.kh-academy.co.kr")
});


// 팝업창 열기
open2.addEventListener("click", () => {
  window.open("https://www.kh-academy.co.kr" 
  , "_blank"
  , "popup")
});


// 
open3.addEventListener("click", () => {
  window.open("https://www.kh-academy.co.kr" 
  , "_blank"
  , "width=400,height=600,top=100,left=100")
  
  /* 주의 사항! */
  // top, left는 여러 모니터를 사용하는 환경에선
  // 주모니터(main)에서만 적용된다
});



//  팝업창이 부모창 값 get/set
const open4 = document.querySelector("#open4");
open4.addEventListener("click", () => {
  window.open("popup.html", "_blank", "width=500, height=300");
});