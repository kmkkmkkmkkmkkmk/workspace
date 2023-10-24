function colorChange(){
  const boxs = document.getElementsByClassName("colorBox");
  const inputs = document.getElementsByClassName("inputColor");

  boxs[0].style.backgroundColor = inputs[0].value;
  boxs[1].style.backgroundColor = inputs[1].value;
  boxs[2].style.backgroundColor = inputs[2].value;
  boxs[3].style.backgroundColor = inputs[3].value;
  boxs[4].style.backgroundColor = inputs[4].value;
}