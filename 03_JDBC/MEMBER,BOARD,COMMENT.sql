-- 시퀀스 생성
CREATE SEQUENCE SEQ_MEMBER_NO NOCACHE;  -- 회원번호
CREATE SEQUENCE SEQ_BOARD_NO NOCACHE;   -- 게시글 번호
CREATE SEQUENCE SEQ_COMMENT_NO NOCACHE; -- 댓글번호

-- MEMBER 테이블에 INSERT 하기
INSERT INTO MEMBER
VALUES(SEQ_MEMBER_NO.NEXTVAL, 
	'mem01@google.com', 
	'123123', 
	'1번회원',
	'01012341234', 
	'서울시 중구', 
	DEFAULT, DEFAULT)
;

COMMIT;

SELECT * FROM MEMBER ;



-- 이메일, 비밀번호가 일치하는 회원의
-- 닉네임, 전화번호, 주소 수정
UPDATE MEMBER 
SET MEMBER_NICKNAME  = '변경된 닉네임', 
MEMBER_TEL = '01011112222',
MEMBER_ADDRESS = '경기도 수원시'
WHERE MEMBER_EMAIL = 'mem02@naver.com'
AND MEMBER_PW = '1q2w3e4r'
;

ROLLBACK;



DELETE FROM  MEMBER
WHERE MEMBER_EMAIL = '탈퇴할 아이디'
MEMBER_PW = '확인할 비밀번호';





-- 로그인 
SELECT MEMBER_NO, MEMBER_NICKNAME, MEMBER_TEL, MEMBER_ADDRESS,
	TO_CHAR(ENROLL_DATE, 'YYYY"년" MM"월" DD"일" HH24:MI:SS') ENROLL_DATE
FROM MEMBER
WHERE MEMBER_EMAIL = 'mem01@google.com'
AND MEMBER_PW = '123123'
AND MEMBER_DEL_FL = 'N'
;


-- MEMBER 테이블 전체 조회
SELECT * FROM MEMBER
--ORDER BY MEMBER_NO ; -- 오름차순
ORDER BY MEMBER_NO DESC; -- 내림차순



-- 닉네임, 전화번호 수정
UPDATE MEMBER SET
MEMBER_NICKNAME = '별명',
MEMBER_TEL = '01099998888'
WHERE MEMBER_NO = 5;


-- 회원 탈퇴
UPDATE MEMBER SET 
MEMBER_DEL_FL = 'Y'
WHERE MEMBER_NO = 5
AND MEMBER_PW = 1234;


UPDATE MEMBER SET 
MEMBER_DEL_FL = 'N';
COMMIT;




-- BOARD 테이블에 INSERT 하기
-- (실행 후 COMMIT/ROLLBACK 무조건 수행)

INSERT INTO BOARD
VALUES(SEQ_BOARD_NO.NEXTVAL, '제목', '내용', DEFAULT, DEFAULT, DEFAULT, 5);
	
COMMIT;


SELECT * FROM BOARD;





-- 게시글 목록 조회(작성자 닉네임 포함)
-- 1) 삭제되지 않은 글
-- 2) 최신글 순(BOARD_NO 내림차순)
SELECT BOARD_NO, BOARD_TITLE, 
	TO_CHAR(B_CREATE_DATE, 'YYYY-MM-DD HH24:MI:SS') B_CREATE_DATE,
	READ_COUNT, MEMBER_NO, MEMBER_NICKNAME 
FROM BOARD 
JOIN MEMBER USING(MEMBER_NO)
WHERE BOARD_DEL_FL = 'N'
ORDER BY BOARD_NO DESC;



-- 게시글 번호를 입력 받아 일치하는 게시글의
-- 제목, 내용, 작성일, 조회수, 작성자번호, 작성자 닉네임 조회
-- 단, 삭제되지 않은 게시글만 조회 가능(BOARD_DEL_FL = 'N')
SELECT BOARD_TITLE, BOARD_CONTENT, 
   TO_CHAR(B_CREATE_DATE, 'YYYY-MM-DD HH24:MI:SS') B_CREATE_DATE,
   READ_COUNT, MEMBER_NO, MEMBER_NICKNAME
FROM BOARD
JOIN MEMBER USING(MEMBER_NO)
WHERE BOARD_DEL_FL = 'N'
AND BOARD_NO = 2
;




-- 조회수 증가
UPDATE BOARD SET 
READ_COUNT = READ_COUNT + 1   -- 대입 연산은 오른쪽 먼저 해석된다!
WHERE BOARD_NO = 1
;

ROLLBACK;


-- 게시글 삭제
SELECT COUNT(*) CHK FROM BOARD
WHERE BOARD_NO = 2
AND MEMBER_NO = 5
;










