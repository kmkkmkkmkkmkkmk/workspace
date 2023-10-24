const writer = document.querySelector("#writer");
const inputComment = document.querySelector("#input-comment");
const writeBtn = document.querySelector("#write-btn");

const commentContainer = document.querySelector(".comment-container");


/* 댓글 등록 버튼 클릭 시 */
writeBtn.addEventListener('click', () => {
  if(writer.value.trim().length === 0){
    alert("작성자 명을 입력 해주세요");
    writer.value = "";
    writer.focus();
    return;
  }

  if(inputComment.value.trim().length === 0){
    alert("내용을 입력 해주세요");
    inputComment.value = "";
    inputComment.focus();
    return;
  }

  /* 행 생성 */
  const row = document.createElement("div");
  row.classList.add("comment-row");

  /* 정보(작성자, 날짜) */
  const info = document.createElement("div");
  info.classList.add("comment-info");
  
  /* 작성자 */
  const commentWriter = document.createElement("p");
  commentWriter.classList.add("comment-writer");
  commentWriter.innerText = writer.value.trim();

  /* 날짜 */
  const writeDate = document.createElement("p");
  writeDate.classList.add("write-date");
  writeDate.innerText = getCurrentDate();

  /* 내용 */
  const commentContent = document.createElement("p");
  commentContent.classList.add('comment-content');
  commentContent.innerText = inputComment.value;

  /* 버튼 영역 */
  const btnArea = document.createElement('div');
  btnArea.classList.add('btn-area');

  // const updateBtn = document.createElement('button');
  // updateBtn.classList.add('update-btn');
  // updateBtn.innerText = '수정';

  const deleteBtn = document.createElement('button');
  deleteBtn.classList.add('delete-btn');
  deleteBtn.innerText = '삭제';

  /* 삭제 버튼 클릭 시 */
  deleteBtn.addEventListener("click", e => {
    if(!confirm("정말 삭제 하시겠습니까?")) return;
    e.target.parentElement.parentElement.remove();
  });



  /* 조립 */
  info.append(commentWriter, writeDate);
  // btnArea.append(updateBtn,deleteBtn);
  btnArea.append(deleteBtn);
  row.append(info, commentContent, btnArea);
  commentContainer.append(row);

  
  alert("댓글이 등록 되었습니다");

  writer.value = "";
  inputComment.value = "";
});


/* 현재 시간 만들기 */
function getCurrentDate(){
  const now = new Date();

  const year = now.getFullYear();
  const month = now.getMonth() < 10 ? "0"+now.getMonth() : now.getMonth();
  const date = now.getDate() < 10 ? "0"+now.getDate() : now.getDate();
  const hour = now.getHours() < 10 ? "0"+now.getHours() : now.getHours();
  const minute = now.getMinutes() < 10 ? "0"+now.getMinutes() : now.getMinutes();
  const second = now.getSeconds() < 10 ? "0"+now.getSeconds() : now.getSeconds();

  return `${year}-${month}-${date} ${hour}:${minute}:${second}`;
}



document.querySelector(".delete-btn").addEventListener("click", e => {
  if(!confirm("정말 삭제 하시겠습니까?")) return;
  e.target.parentElement.parentElement.remove();
});