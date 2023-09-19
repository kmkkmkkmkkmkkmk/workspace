// 힌트
// document.querySelector("[name='fw']:checked").value

const btn = document.getElementById("btn");
const height = document.getElementById("height");
// const outPut2 = document.querySelector("#outPut2");
const outPut2 = document.getElementById("outPut2");
const width = document.getElementById("width");
const fontSize = document.getElementById("fontSize");
const fc = document.getElementById("fc");
const bcc = document.getElementById("bcc");
const outPut = document.getElementById("outPut");


btn.addEventListener("click", function(){

  outPut2.style.height = height.value + "px";
  // outPut2.style.width = width.value + "px";
  outPut2.style.backgroundColor = bcc.value;
  // outPut. = outPut.value;
  outPut2.style.fontSize = fontSize.value + "px";
  outPut2.innerHTML = outPut.value;
  outPut2.style.color = fc.value;



  /* input에 작성된 값에 따라 #box에 JS로 CSS추가 */

  // 너비를 입력하는 input에 값이 작성되어 있다면
  if(width.value.trim().length > 0) {
    outPut2.style.width = width.value + "px";
  }

  





});



