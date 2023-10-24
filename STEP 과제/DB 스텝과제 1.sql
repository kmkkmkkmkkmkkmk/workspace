ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

CREATE USER EXAMPLE_KMK IDENTIFIED BY "12345";

GRANT CONNECT, RESOURCE TO EXAMPLE_KMK;

ALTER USER EXAMPLE_KMK DEFAULT TABLESPACE "A230724"
QUOTA 20M ON "A230724";



ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

CREATE USER EXAMPLE_KMK2 IDENTIFIED BY "12345";

GRANT CONNECT, CREATE VIEW TO EXAMPLE_KMK2;

ALTER USER EXAMPLE_KMK2 DEFAULT TABLESPACE "A230724"
QUOTA 20M ON "A230724";

REVOKE CONNECT FROM EXAMPLE_KMK2;

DROP USER EXAMPLE_KMK2;

---------------------------------------------------------------------------------------- 1

CREATE TABLE MEMBER(
MEMBER_NO NUMBER ,
MEMBER_ID VARCHAR2(30) ,
MEMBER_PASSWORD VARCHAR2(30),
PHONE_NUMBER VARCHAR2(20) NULL,
DELETE_YN CHAR(1) NULL
);

ALTER TABLE MEMBER ADD CONSTRAINT MEMBER_PK PRIMARY KEY (MEMBER_NO);
ALTER TABLE MEMBER ADD CONSTRAINT DELETE_YN CHECK (DELETE_YN IN ('Y','N'));

COMMENT ON COLUMN MEMBER.MEMBER_NO IS '회원번호';
COMMENT ON COLUMN MEMBER.MEMBER_ID IS'아이디';
COMMENT ON COLUMN MEMBER.MEMBER_PASSWORD IS '비밀번호';
COMMENT ON COLUMN MEMBER.PHONE_NUMBER IS '핸드폰번호';
COMMENT ON COLUMN MEMBER.DELETE_YN IS '삭제여부';

SELECT MEMBER_NO "회원번호", MEMBER_ID "아이디"  ,  MEMBER_PASSWORD "비밀번호" ,
PHONE_NUMBER "핸드폰번호"  FROM MEMBER;

CREATE SEQUENCE SEQ_MEMBER_NO
START WITH 100
INCREMENT BY 100;

INSERT INTO MEMBER (MEMBER_NO,MEMBER_ID,MEMBER_PASSWORD)
VALUES(SEQ_MEMBER_NO.NEXTVAL,'step1', 'step11');

INSERT INTO MEMBER (MEMBER_NO,MEMBER_ID,MEMBER_PASSWORD,PHONE_NUMBER)
VALUES (SEQ_MEMBER_NO.NEXTVAL,'step2', 'step22','010-1111-2222');

INSERT INTO MEMBER (MEMBER_NO,MEMBER_ID,MEMBER_PASSWORD)
VALUES (SEQ_MEMBER_NO.NEXTVAL,'step3', 'step33');

COMMIT;


---------------------------------------------------------------------------------------- 2


CREATE TABLE BOARD(

BOARD_NO NUMBER NOT NULL,
BOARD_TITLE VARCHAR2(300) NOT NULL,
BOARD_CONTENT VARCHAR2(4000) NOT NULL,
BORAD_WRITER NUMBER NULL,
CREATE_DATE DATE DEFAULT SYSDATE NULL
);

ALTER TABLE BOARD ADD CONSTRAINT BOARD_PK PRIMARY KEY (BOARD_NO);

ALTER TABLE BOARD ADD CONSTRAINT BOARD_MEMBER_FK 
FOREIGN KEY(BORAD_WRITER) REFERENCES MEMBER;


COMMENT ON COLUMN BOARD.BOARD_NO IS  '글번호';
COMMENT ON COLUMN BOARD.BOARD_TITLE IS '글제목';
COMMENT ON COLUMN BOARD.BOARD_CONTENT IS '글내용';
COMMENT ON COLUMN BOARD.BORAD_WRITER IS '작성자';
COMMENT ON COLUMN BOARD.CREATE_DATE IS '작성일자';

CREATE SEQUENCE SEQ_BOARD_NO
START WITH 1
INCREMENT BY 1;


INSERT INTO BOARD (BOARD_NO,BOARD_TITLE,BOARD_CONTENT,BORAD_WRITER)
VALUES(SEQ_BOARD_NO.NEXTVAL,'첫 글', '스텝평가', 100);

INSERT INTO BOARD (BOARD_NO,BOARD_TITLE,BOARD_CONTENT,BORAD_WRITER)
VALUES (SEQ_BOARD_NO.NEXTVAL,'두 번째 글', '재밌다',300);

INSERT INTO BOARD (BOARD_NO,BOARD_TITLE,BOARD_CONTENT,BORAD_WRITER)
VALUES (SEQ_BOARD_NO.NEXTVAL,'세 번째 글', '하하하',200);




----------------------------------------------------------------------------------------3



SELECT SEQ_MEMBER_NO.NEXTVAL FROM DUAL;
SELECT SEQ_BOARD_NO.NEXTVAL FROM DUAL;

SELECT  BOARD_NO "글번호", BOARD_TITLE "제목", BOARD_CONTENT "내용", MEMBER_ID  "작성자", CREATE_DATE "작성일" FROM MEMBER
, BOARD WHERE  MEMBER_NO  = BORAD_WRITER ORDER BY 1 desc;


----------------------------------------------------------------------------------------4
