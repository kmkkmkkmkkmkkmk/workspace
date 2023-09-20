// 적용하기 버튼이 클릭 되었을 때
const applyBtn = document.querySelector("#apply-btn");

applyBtn.addEventListener("click", function(){
  
  // 위에 작성된 input 요소들을 모두 얻어오기
  const boxWidth = document.querySelector("#box-width");
  const boxHeight = document.querySelector("#box-height");
  const fs = document.querySelector("#fs");

  const fw = document.querySelector("[name='fw']:checked");

  const fontColor = document.querySelector("#box-font-color");
  const bgColor = document.querySelector("#box-bg-color");
  
  const row = document.querySelector("[name='align-row']:checked");
  const col = document.querySelector("[name='align-col']:checked");
  
  const content = document.querySelector("#content");
  const box = document.querySelector("#box");



  /* input에 작성된 값에 따라 #box에 JS로 CSS추가 */

  // 너비를 입력하는 input에 값이 작성되어 있다면
  if(boxWidth.value.trim().length > 0){
    box.style.width = boxWidth.value + "px";
  }

  // 높이를 입력하는 input에 값이 작성되어 있다면
  if(boxHeight.value.trim().length > 0){
    box.style.height = boxHeight.value + "px";
  }

  // 글자 크기를 입력하는 input에 값이 작성되어 있다면
  if(fs.value.trim().length > 0){
    box.style.fontSize = fs.value + "px";
  }

  // fw -> 체크된 게 없으면 null 반환
  //    -> 체크된 게 있으면 null 아님
  if(fw != null){ // 글자 굵기가 체크 되었을 때
    box.style.fontWeight = fw.value;
  }

  // 글자 색을 입력하는 input에 값이 작성되어 있다면
  if(fontColor.value.trim().length > 0){
    box.style.color = fontColor.value;
  }

  // 배경 색을 입력하는 input에 값이 작성되어 있다면
  if(bgColor.value.trim().length > 0){
    box.style.backgroundColor = bgColor.value;
  }

  // 가로 정렬 체크 되었을 때
  if(row != null){ 
    box.style.justifyContent = row.value;
  }

  // 세로 정렬 체크 되었을 때
  if(col != null){ 
    box.style.alignItems = col.value;
  }

  // content에 작성된 값이 있을 때
  if(content.value.trim().length > 0){
    box.innerText = content.value;
  }
});



// // 힌트
// // document.querySelector("[name='fw']:checked").value

// const btn = document.getElementById("btn");
// const height = document.getElementById("height");
// // const outPut2 = document.querySelector("#outPut2");
// const outPut2 = document.getElementById("outPut2");
// const width = document.getElementById("width");
// const fontSize = document.getElementById("fontSize");
// const fc = document.getElementById("fc");
// const bcc = document.getElementById("bcc");
// const outPut = document.getElementById("outPut");


// btn.addEventListener("click", function(){

//   outPut2.style.height = height.value + "px";
//   // outPut2.style.width = width.value + "px";
//   outPut2.style.backgroundColor = bcc.value;
//   // outPut. = outPut.value;
//   outPut2.style.fontSize = fontSize.value + "px";
//   outPut2.innerHTML = outPut.value;
//   outPut2.style.color = fc.value;



//   /* input에 작성된 값에 따라 #box에 JS로 CSS추가 */

//   // 너비를 입력하는 input에 값이 작성되어 있다면
//   if(width.value.trim().length > 0) {
//     outPut2.style.width = width.value + "px";
//   }

// });



