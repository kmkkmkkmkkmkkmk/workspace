document.body.scrollIntoView(false);



/* 정규 표현식 객체 생성/패턴 일치 확인 */
const check1 = document.getElementById("check1");
check1.addEventListener("click", () => {


  // 정규 표현식 객체 생성

  // 1) new RegExp("정규표현식")
  let regEx = new RegExp("\d{3}"); // 연속적으로 작성된 숫자 3개

  // 2) /정규표현식/
  regEx = /\d{3}/;


  /*  패턴 일치 여부 확인 */
  const str1 = "정규표현식123";
  const str2 = "정규89표현식";
  
  // 정규식객체.test(문자열) -> 패턴이 일치하면 true
  console.log(regEx.test(str1));  // true
  console.log(regEx.test(str2));  // false
  
  // 정규식 객체.exec(문자열) -> 일치하는 패턴의 문자열 반환
  //                             없으면 null
  console.log(regEx.exec(str1));
  console.log(regEx.exec(str2));
  
});


/* 메타 문자 확인하기 */
const check2 = document.querySelector("#check2");
check2.addEventListener("click", () => {

  // a (일반문자열) : 문자열 내에 a라는 문자열이 존재하는 검색 
  let regEx = /java/; // 문자열 내에 java가 존재하는지 검색
  
  console.log(`javascript : ${regEx.test("javascript")}`); // true
  console.log(`javascript : ${regEx.test("jajaja")}`); // false
  
  
  // [abcd] : 문자열 내에 a,b,c,d 중 하나라도 일치하는 문자가 있는지 검색

  regEx = /[a-z][0-9][A-Z]/;
  // 1번: 영어소문자 / 2번: 숫자 / 3번: 영어대문자
  
  let str = "a3T";
  console.log(`${str} : ${regEx.test(str)}`); // true
  
  str = "@@@@@@a3T@@@@@@";
  console.log(`${str} : ${regEx.test(str)}`); // true
  
  str = "b5q";
  console.log(`${str} : ${regEx.test(str)}`); // false
  
  // ^(캐럿) : 문자열의 시작을 의미
  regEx = /^Hello[0-9]/;
  str = "Hello7 World";
  console.log(`${str} : ${regEx.test(str)}`); // true
  
  str = "Hello World"; /* Hello 뒤에 숫자 없음 */
  console.log(`${str} : ${regEx.test(str)}`); // false
  
  
  
  
  // $(달러) : 문자열의 끝을 의미

  // \d : 아무 숫자 == [0-9]

  regEx = /\d\d\d$/; // 문자열이 끝에 숫자가 3칸 있는가

  str = "123456789"; 
  console.log(`${str} : ${regEx.test(str)}`); // true

  str = "123123123_99"; 
  console.log(`${str} : ${regEx.test(str)}`); // false





  /* ^, $를 같이 사용하는 경우
    문자열의 시작과 끝이 정해져 있어
    포함(X), 문자열의 전체적인 형태를 제한
  */

  // 영어 소문자로 시작
  // 중간에 "TEST"
  // 끝은 1자리 숫자로 끝나는 문자열
  
  regEx = /^[a-z]TEST\d$/;
  str = "wTEST4"; 
  console.log(`${str} : ${regEx.test(str)}`); // true
});



/* 이름 유효성 검사 */
const inputName = document.querySelector("#input-name");
const nameResult = document.querySelector("#name-result");

inputName.addEventListener("keyup", () => {
  // 1) 2~15글자 사이         -> {2,15}
  // 2) 처음부터 끝까지 한글  -> ^ 한글 $
  // 3) 단자음, 단모음 제외   -> [가-힣]

  const regEx = /^[가-힣]{2,15}$/;

  // 입력 받은 값
  const value = inputName.value.trim();  // 좌우 공백 제거 상태
  inputName.value = value;  // 좌우 공백이 제거된 값을 대입


  if(value.length == 0){ // 입력 X
    nameResult.innerText = "한글 2~15자 사이 입력";
    nameResult.classList.remove("check");
    nameResult.classList.remove("error");
    return;
  }

  // 정규식을 이용해서 검사
  if(regEx.test(value)){ // 유효한 경우
    nameResult.innerText = "유효한 이름입니다.";
    nameResult.classList.add("check"); // check 클래스 추가
    nameResult.classList.remove("error"); // error 클래스 제거
    
  } else { // 유효하지 않은 경우
    nameResult.innerText = "유효하지 않은 이름입니다.";
    nameResult.classList.add("error"); // check 클래스 추가
    nameResult.classList.remove("check"); // check 클래스 제거
  }
});



/* 휴대폰 번호 유효성 검사 */
const phoneNumber = document.getElementById("phone-number");
const noneNumber = document.getElementById("none-number");

phoneNumber.addEventListener("keyup", () => {

  const regEx = /^01[0,1,6,7,9]-\d{3,4}-\d{4}$/;

  const value = phoneNumber.value.trim();
  phoneNumber.value = value;

  if(value.length == 0){ // 입력
    noneNumber.innerText = "휴대폰 번호 입력(- 포함)";
    noneNumber.classList.remove("check");
    noneNumber.classList.remove("error");
    return;
  }
  
  if(regEx.test(value)){
    noneNumber.innerText = "유효한 번호입니다.";
    noneNumber.classList.add("check");
    noneNumber.classList.remove("error");
    
  } else {
    noneNumber.innerText = "유효하지 않은 번호입니다.";
    noneNumber.classList.add("error");
    noneNumber.classList.remove("check");
  }
});




