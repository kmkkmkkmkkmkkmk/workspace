

function plus(){
  // 입력요소 값 두개 다 읽어오기

  // 입력요소.value : 입력 요소에 작성된 값 반환(string)
  const n1 = document.getElementById("n1");
  const n2 = document.getElementById("n2");
  console.log(n1.value); //브라우저 콘솔창에 출력 해보는 것
  console.log(n2.value); //브라우저 콘솔창에 출력 해보는 것




  // 두 값 더하기 
  // Number("123") == 123 (숫자로 변환)
  console.log(Number(n1.value)+Number(n2.value));

  // 화면에 출력하기
  // 요소.innerText : <시작>내용</종료> , 내용에 글자 대입
  const result = document.getElementById("result");
  result.innerText = Number(n1.value)+Number(n2.value);
}


// 빼기 버튼
function minus(){
  result.innerText = Number(n1.value)-Number(n2.value);
}


// 곱하기 버튼
function Multiplication(){
  result.innerText = Number(n1.value)*Number(n2.value);
}


// 나누기 버튼
function division(){
  result.innerText = Number(n1.value)/Number(n2.value);
}


// 나머지 버튼
function percentage(){
  result.innerText = Number(n1.value)%Number(n2.value);
}