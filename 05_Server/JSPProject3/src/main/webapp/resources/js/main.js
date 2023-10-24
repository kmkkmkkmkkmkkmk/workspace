// #btn1 요소 클릭 시
document.querySelector("#btn1")
  .addEventListener("click", () => {

  // location.href;           :  현재 주소 반환
  // location.href = 주소;    :  대입된 주소로 이동(GET방식)
  location.href = "/jstl/basic";
});
  

// #btn2 요소 클릭 시
document.getElementById("btn2")
  .addEventListener("click", () => {
  location.href = "/jstl/condition"; // GET 방식 
});

// #btn3 요소 클릭 시 
document.getElementById("btn3")
  .addEventListener("click", () => {
  location.href = "/jstl/loop"; // GET 방식 
});

