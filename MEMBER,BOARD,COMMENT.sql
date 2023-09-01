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
MEMBER_PW = '확인할 비밀번호'










































