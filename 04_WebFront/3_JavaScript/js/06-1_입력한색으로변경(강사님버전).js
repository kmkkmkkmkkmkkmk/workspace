const boxList = document.getElementsByClassName("box");
const inputList = document.getElementsByClassName("color-input");

function changeColor(){

  for(let i=0 ; i <inputList.length ; i++){
    boxList[i].style.backgroundColor = inputList[i].value;
  }
}