const n1 = document.getElementById("n1");
const n2 = document.getElementById("n2");
const result = document.getElementById("result");

// 연산자 버튼 클릭 시 동작
function calc(btn){ // 매개 변수 btn (btn == 클릭된 버튼 자체(this))

  const op = btn.innerText; // 버튼에 작성된 연산자

  v1 = Number(n1.value); // 입력 숫자1
  v2 = Number(n2.value); // 입력 숫자2

  // 1. eval("코드 형식의 문자열")
  // -> 매개변수의 문자열을 JS 코드로 변환해서 해석하는 함수
  // -> 속도 + 보안 문제로 사용을 지양.....(쓰지마)
  // result.innerText = eval(v1 + op + v2);

  // 2. new Function("return 코드 형식의 문자열")();
  // -> 새 함수를 만들어서 바로 실행
  //  -> 실행되는 함수의 내용은 첫 번째 ()에 작성된
  //     코드 형식의 문자열

  result.innerText 
    = new Function("return " + v1 + op + v2)();
}



