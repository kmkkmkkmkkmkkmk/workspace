const checkList = {
  "input-id" : false,
  "pw" : false,
  "pwCheck" : false,
  "email" : false,
  "address" : false  
}


const inputId = document.getElementById("input-id");
const pw = document.getElementById("pw");
const pwCheck = document.getElementById("pwCheck");
const email = document.getElementById("email");
const address = document.getElementById("address");
const btn = document.getElementById("btn");
const signup = document.signupForm

const inputBox = document.querySelectorAll(".inputBox");






/* 아이디 */
inputId.addEventListener("input", e => {
  const val = inputId.value.trim(); // 좌우 공백제거
  const span = e.target.nextElementSibling.nextElementSibling;
  
  
  inputId.value = val;

  if(val.length === 0 ){
    span.innerText = "필수 입력 항목 입니다";
    span.classList.remove("check");
    span.classList.remove("error");

    checkList["id"] = false;
    return;
  }


  const regEx = /^[A-Za-z\d\-\_]{6,14}$/;
  
  if(regEx.test(val)){
    span.innerText = "정상 입력 값 입니다";
    span.classList.add("check");
    span.classList.remove("error");

    checkList["id"] = true;

  } else { 
    span.innerText = "잘못된 입력 값 입니다";
    span.classList.add("error");
    span.classList.remove("check");

    checkList["id"] = false;
  }
});








/* 비밀번호 */
pw.addEventListener("click", e => {
  const val = pw.value.trim();
  const span = e.target.nextElementSibling.nextElementSibling;

  pw.value = val;

  if(val.length === 0){
    span.innerText = "영어,숫자,!@#$%^&* 8~32글자 사이";
    span.classList.remove("check");
    span.classList.remove("error");
    
    checkList["pw"] = false;
    
    return;
  }

  const regEx = /^[A-Za-z\d\!\@\#\$\%\^\&\*]{8,32}$/;

  if(regEx.test(val)){
    span.innerText = "올바른 비밀번호 형식입니다";
    span.classList.add("check");
    span.classList.remove("error");

    checkList["pw"] = true;
     
  } else {
    span.innerText = "옳지않은 비밀번호 형식입니다";
    span.classList.add("error");
    span.classList.remove("check");

    checkList["pw"] = false;
  }

});


/* 비밀번호 체크 */
pwCheck.addEventListener("input", e => {

  const pwSpan = pw.nextElementSibling.nextElementSibling;
  const span = pwCheck.nextElementSibling.nextElementSibling;


  const val = e.target.value.trim();
  e.target.value = val;

  if(val.length === 0){
    span.innerText = "필수 입력 항목 입니다";
    span.classList.remove("check");
    span.classList.remove("error");

    checkList["pwCheck"] = false;

    return; 
  }

  const pwVal = pw.value;

  if(val === pwVal){
    span.innerText = "비밀번호가 같습니다";
    span.classList.add("check");
    span.classList.remove("error");

    checkList["pwCheck"] = true;

  } else {
    span.innerText = "비밀번호가 다릅니다";
    span.classList.add("error");
    span.classList.remove("check");

    checkList["pwcheck"] = false;
  } 
});

/* 비밀번호가 같은지 체크 */
function checkPwFn(){
  const span = inputPwCheck.nextElementSibling.nextElementSibling;

  const pwVal = pw.value.trim();
  const checkVal = pwCheck.value.trim();

  if(pwVal.length == 0 || checkVal.length == 0){
    span.innerText = "필수 입력 항목을 입력 해야합니다";
    span.classList.remove("check");
    span.classList.remove("error");

    checkList["pwCheck"] = false;

    return;
  }

  if(pwVal === checkVal){
    span.innerText = "비밀번호가 같습니다";
    span.classList.add("check");
    span.classList.remove("error");
    checkList["pwCheck"] = true;

  } else {
    span.innerText = "비밀번호가 다릅니다";
    span.classList.add("error");
    span.classList.remove("check");
    checkList["pwCheck"] = false;
  }

}






























































