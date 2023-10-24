const num1 = document.getElementById("num1");
const num2 = document.getElementById("num2");
const result = document.getElementById("result");

// 연산자 버튼 클릭 시 동작
// 매개 변수 btn (btn == 클릭된 버튼 자체(this))
function calc(btn){
  
  console.log(btn); // 클릭한 버튼
  console.log(btn.innerText); // 버튼에 작성된 내용(== 연산자)

  // 클릭한 버튼에 작성된 연산자를 얻어와 op 변수에 저장
  const op = btn.innerText; 

  
  // 입력된 값을 number 타입으로 변환하여 저장
  v1 = Number(n1.value);
  v2 = Number(n2.value);

  // switch문을 이용해 op 매개 변수 값에 따라 결과 도출
  let res; // 결과 저장

  switch(op){
  case '+': res = v1 + v2; break;
  case '-': res = v1 - v2; break;
  case '*': res = v1 * v2; break;
  case '/': res = v1 / v2; break;
  case '%': res = v1 % v2; break;
  }

  // 결과 출력
  result.innerText = res;
}