const keys = document.getElementsByClassName("key");

// 문서 내에서 키다운 이벤트가 발생했을 때
document.addEventListener("keydown", function(e){
  let index = 0;

  // e.key : 입력한 키
  // 문자열.toLowerCase() : 소문자로
  switch(e.key.toLowerCase()){
  case 'q': index = 0; break;
  case 'w': index = 1; break;
  case 'e': index = 2; break;
  case 'r': index = 3; break;
  default: return;
  }

  keys[index].style.backgroundColor = "skyblue";
})

document.addEventListener("keyup", function(e){

  let index = 0;

  switch(e.key.toLowerCase()){
  case 'q': index = 0; break;
  case 'w': index = 1; break;
  case 'e': index = 2; break;
  case 'r': index = 3; break;
  }

  keys[index].style.backgroundColor = "white";
})