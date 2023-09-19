/* 
  요소.classList : 요소 클래스 관련 속성

  요소.classList.add("클래스명")    : 클래스 추가
  요소.classList.remove("클래스명") : 클래스 제거

  요소.remove() : 요소 제거
*/


// 만들려는 기능 중 공통적으로 사용되는 요소를 전역 변수 선언
const addBtn = document.getElementById("add");
const calcBtn = document.getElementById("calc");

// querySelector() -> 여러 요소가 선택되도 첫번째 요소 하나만 얻어옴
const container = document.querySelector(".container");

/* 추가 버튼 클릭 시 */
addBtn.addEventListener("click", () => {
  
  // 1) div.row
  const row = document.createElement("div");

  // 요소에 class 추가하기 
  row.classList.add("row");

  // 2) input 만들기
  const input = document.createElement("input");

  // type = "number" 추가
  input.setAttribute("type", "number");

  // 클래스 "input-number" 추가
  input.classList.add("input-number");


  // 3) span 만들기(X버튼)
  const span = document.createElement("span");
  
  // 클래스 "remove-row"  추가
  span.classList.add("remove-row");

  // 내용으로 &times; 추가(innerHTML 사용)
  span.innerHTML = "&times;";


  /* ************************************************* */
  // 클릭된 x버튼의 부모 요소를 제거

  // [1] 만들어지는 X버튼(span)에 이벤트리스너(클릭행동 감지) 추가
  span.addEventListener("click", e => {

    // [2] 현재 이벤트가 발생한 요소(클릭된 X버튼)의 
    //      부모 요소를 선택(탐색)         
    // e.target = > 현재 이벤트가 발생한 요소
    const parent = e.target.parentElement;  // == div.row

    // [3] 부모 요소를 제거
    parent.remove();
  });

  
  
  
  
  /* ************************************************* */
  
  // --- 조립 시작 ..... ---
  
  // 4) div.row의 자식으로 input, span 추가
  row.append(input, span);
  
  // 5) div.row를 .container의 마지막 자식으로 추가
  container.append(row);
  
});



/* ************************************************* */
// 1) 계산 버튼 클릭 시
calcBtn.addEventListener("click", () => {
  // 2) 
 const numbers = document.getElementsByClassName("input-number")

  // 3) for문으로 모든 요소 접근하여
  //   작성된 값(value)를 얻어와
  //   숫자로 변경(Number())한 후
  //   합계 저장 변수 sum에 누적
  let sum = 0;

  for(let i = 0 ; i<numbers.length ; i++){
    sum += Number(numbers[i].value);
  }

  // 4) for문 끝나면 alert로 결과 출력
  alert("결과 : " +sum);
});