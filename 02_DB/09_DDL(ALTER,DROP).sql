-- DDL(Data Definition Language) : 데이터 정의 언어로
-- 객체를 만들고(CREATE), 수정하고(ALTER), 삭제하는(DROP) 구문

-- ALTER(바꾸다, 변조하다)
-- 수정 가능한 것 : 컬럼(추가/수정(자료형, 기본값)/삭제), 제약조건(추가/삭제)
--                  이름변경(테이블, 컬럼, 제약조건)

-- [작성법]
-- 테이블을 수정하는 경우
-- ALTER TABLE 테이블명 ADD|MODIFY|DROP 수정할 내용;

--------------------------------------------------------------------------------
-- 1. 제약조건 추가 / 삭제

-- * 작성법 중 [] 대괄호 : 생략 가능(선택)

-- 제약조건 추가 : ALTER TABLE 테이블명 
--                 ADD [CONSTRAINT 제약조건명] 제약조건(컬럼명) [REFERENCES 테이블명[(컬럼명)]];

-- 제약조건 삭제 : ALTER TABLE 테이블명
--                 DROP CONSTRAINT 제약조건명;


-- 서브쿼리를 이용해서 DEPARTMENT 테이블 복사 --> NOT NULL 제약조건만 복사됨
CREATE TABLE DEPT_COPY
AS SELECT * FROM DEPARTMENT;

-- DEPT_COPY 테이블에 PK 추가
ALTER TABLE DEPT_COPY
ADD CONSTRAINT DEPT_COPY_PK PRIMARY KEY(DEPT_ID);


SELECT C1.TABLE_NAME, CONSTRAINT_NAME, CONSTRAINT_TYPE
FROM USER_CONSTRAINTS C1
JOIN USER_CONS_COLUMNS C2 USING(CONSTRAINT_NAME)
WHERE C1.TABLE_NAME = 'DEPT_COPY';

-- DEPT_COPY 테이블의 DEPT_TITLE 컬럼에 UNIQUE 제약조건 추가
-- 제약조건명 : DEPT_COPY_TITLE_U
ALTER TABLE DEPT_COPY 
ADD CONSTRAINT DEPT_COPY_TITLE_U UNIQUE (DEPT_TITLE);

-- DEPT_COPY 테이블의 LOCATION_ID 컬럼에 CHECK 제약조건 추가
-- 컬럼에 작성할 수 있는 값은 L1, L2, L3, L4, L5 
-- 제약조건명 : LOCATION_ID_CHK
ALTER TABLE DEPT_COPY 
ADD CONSTRAINT LOCATION_ID_CHK CHECK(LOCATION_ID IN ('L1','L2','L3','L4','L5'));


-- DEPT_COPY 테이블의 DEPT_TITLE 컬럼에 NOT NULL 제약조건 추가
-- * NOT NULL 제약조건은 다루는 방법이 다름
-->  NOT NULL을 제외한 제약 조건은 추가적인 조건으로 인식됨.(ADD/DROP)
-->  NOT NULL은 기존 컬럼의 성질을 변경하는 것으로 인식됨.(MODIFY)
-- MODIFY : 수정하다, 변경하다
ALTER TABLE DEPT_COPY MODIFY DEPT_TITLE NOT NULL; -- (NULL 허용X)
									-- NULL (NULL 허용)
---------------------------

-- DEPT_COPY에 추가한 제약조건 중 PK 빼고 모두 삭제
ALTER TABLE DEPT_COPY DROP 
CONSTRAINT DEPT_COPY_TITLE_U;

ALTER TABLE DEPT_COPY DROP 
CONSTRAINT LOCATION_ID_CHK;




-- NOT NULL 제거 시 MODIFY 사용
ALTER TABLE DEPT_COPY MODIFY 
DEPT_ID CONSTRAINT SYS_C0014067 NULL; -- DEPT_ID NOT NULL 제거

ALTER TABLE DEPT_COPY MODIFY 
LOCATION_ID CONSTRAINT SYS_C0014068 NULL; 

ALTER TABLE DEPT_COPY MODIFY 
DEPT_TITLE CONSTRAINT SYS_C0014067 NULL; 


SELECT C1.TABLE_NAME, CONSTRAINT_NAME, CONSTRAINT_TYPE, SEARCH_CONDITION
FROM USER_CONSTRAINTS C1
JOIN USER_CONS_COLUMNS C2 USING(CONSTRAINT_NAME)
WHERE C1.TABLE_NAME = 'DEPT_COPY';


---------------------------------------------------------------------------------
-- 2. 컬럼 추가/수정/삭제

-- 컬럼 추가 : ALTER TABLE 테이블명 ADD(컬럼명 데이터타입 [DEFAULT '값']);


-- 컬럼 수정 : ALTER TABLE 테이블명 MOIDFY 컬럼명 데이터타입;   (데이터 타입 변경)
--             ALTER TABLE 테이블명 MOIDFY 컬럼명 DEFAULT '값'; (기본값 변경)

--> ** 데이터 타입 수정 시 컬럼에 저장된 데이터 크기 미만으로 변경할 수 없다.


-- 컬럼 삭제 : ALTER TABLE 테이블명 DROP (삭제할컬럼명);
--             ALTER TABLE 테이블명 DROP COLUMN 삭제할컬럼명;

--> ** 테이블에는 최소 1개 이상의 컬럼이 존재해야 되기 때문에 모든 컬럼 삭제 X

-- 테이블이란? 행과 열로 이루어진 데이터베이스의 가장 기본적인 객체


-- (추가)
-- DEPT_COPY 컬럼에 CNAME VARCHAR2(20) 컬럼 추가
-- ALTER TABLE 테이블명 ADD(컬럼명 데이터타입 [DEFAULT '값']);
ALTER TABLE DEPT_COPY ADD (CNAME VARCHAR2(20) );
SELECT * FROM DEPT_COPY;

-- (추가)
-- DEPT_COPY 테이블에 LNAME VARCHAR2(30) 기본값 '한국' 컬럼 추가
ALTER TABLE DEPT_COPY ADD (LNAME VARCHAR2(30) DEFAULT '한국');
SELECT * FROM DEPT_COPY;

-- (수정)
-- DEPT_COPY 테이블의 DEPT_ID 컬럼의 데이터 타입을 CHAR(2) -> VARCHAR2(3)으로 변경
-- ALTER TABLE 테이블명 MODIFY 컬럼명 데이터타입;
ALTER TABLE DEPT_COPY MODIFY DEPT_ID VARCHAR2(3); 

-- (수정 에러 상황)
-- DEPT_TITLE 컬럼의 데이터타입을 VARCHAR2(10)으로 변경
ALTER TABLE DEPT_COPY MODIFY DEPT_TITLE VARCHAR2(10);
--> ORA-01441: 일부 값이 너무 커서 열 길이를 줄일 수 없음
--> 이미 저장된 컬럼 값의 크기보다 작제 변경 불가

-- (기본값 수정)
-- LNAME 기본값을 '한국' -> '대한민국' 으로 변경
-- ALTER TABLE 테이블명 MOIDFY 컬럼명 DEFAULT '값'; 
ALTER TABLE DEPT_COPY MODIFY LNAME DEFAULT '대한민국';

SELECT * FROM DEPT_COPY;

-- LNAME 컬럼 값을 모두 '대한민국' 변경 (DEFAULT 사용)
UPDATE DEPT_COPY 
SET LNAME = DEFAULT;
-- 조건 미작성 시 모든 행에 적용

COMMIT;

SELECT * FROM DEPT_COPY;



-- (삭제)
-- DEPT_COPY에 추가한 컬럼(CNAME, LNAME) 삭제
-->  ALTER TABLE 테이블명 DROP(삭제할컬럼명);
ALTER TABLE DEPT_COPY DROP(CNAME);
SELECT * FROM DEPT_COPY;

-->  ALTER TABLE 테이블명 DROP COLUMN 삭제할컬럼명;
ALTER TABLE DEPT_COPY DROP COLUMN LNAME;
SELECT * FROM DEPT_COPY;

-- DEPT_TITLE, LOCATION_ID 삭제
ALTER TABLE DEPT_COPY DROP COLUMN DEPT_TITLE;
ALTER TABLE DEPT_COPY DROP COLUMN LOCATION_ID;
SELECT * FROM DEPT_COPY;

-- DEPT_ID (마지막 컬럼) 삭제
ALTER TABLE DEPT_COPY DROP COLUMN DEPT_ID;
-- ORA-12983: 테이블에 모든 열들을 삭제할 수 없습니다

-- * DDL / DML을 혼용해서 사용할 경우 발생하는 문제점

-- DML을 수행하여 트랜잭션에 변경사항이 저장된 상태에서
-- COMMIT/ROLLBACK 없이 DDL 구문을 수행하게되면
-- DDL 수행과 동시에 선행 DML이 자동으로 COMMIT 되어버림.




--> 결론 : DML/DDL 혼용해서 사용하지 말자!!!

INSERT INTO DEPT_COPY VALUES('D0'); -- 'D0' 삽입
SELECT * FROM DEPT_COPY;
ROLLBACK; -- 트랜잭션에서 'D0' INSERT 내용을 삭제
SELECT * FROM DEPT_COPY;


INSERT INTO DEPT_COPY VALUES('D0'); -- 'D0' 삽입
SELECT * FROM DEPT_COPY;

ALTER TABLE DEPT_COPY MODIFY DEPT_ID VARCHAR2(4); -- DDL 수행
ROLLBACK;
SELECT * FROM DEPT_COPY; -- 'D0'가 사라지지 않음

/* DDL, DML 중 작업 중인 SQL을 확실히 마무리 한 후 진행하기!!!!!  */


-------------------------------------------------------------------------------

-- 3. 테이블 삭제

-- [작성법]
-- DROP TABLE 테이블명 [CASCADE CONSTRAINTS];

-- 부모 테이블 생성
CREATE TABLE TB1(
    TB1_PK NUMBER PRIMARY KEY,
    TB1_COL NUMBER
);

-- 자식 테이블 생성
CREATE TABLE TB2(
    TB2_PK NUMBER PRIMARY KEY,
    TB2_COL NUMBER REFERENCES TB1 -- TB1 테이블의 PK 값을 참조
);

-- 일반 삭제(DEPT_COPY)
DROP TABLE DEPT_COPY; -- Table DEPT_COPY이(가) 삭제되었습니다.
SELECT * FROM DEPT_COPY; -- ORA-00942: 테이블 또는 뷰가 존재하지 않습니다

-- ** 관계가 형성된 테이블 중 부모테이블(TB1) 삭제 **
DROP TABLE TB1;
-- ORA-02449: 외래 키에 의해 참조되는 고유/기본 키가 테이블에 있습니다 
--> 다른 테이블이 TB1 테이블을 참조하고 있어서 삭제 불가능.

-- 해결 방법 1 : 자식 -> 부모 테이블 순서로 삭제하기
-- (참조하는 테이블이 없으면 삭제 가능)
DROP TABLE TB2;
DROP TABLE TB1; -- 삭제 성공


-- 해결 방법 2 : CASCADE CONSTRAINTS 옵션 사용
--> 제약조건까지 모두 삭제 
-- == FK 제약조건으로 인해 삭제가 원래는 불가능 하지만, 제약조건을 없애버려서 FK 관계를 해제
DROP TABLE TB1 CASCADE CONSTRAINTS; -- 삭제 성공
DROP TABLE TB2;         


---------------------------------------------------------------------------------

-- 4. 컬럼, 제약조건, 테이블 이름 변경(RENAME)

-- 테이블 복사
CREATE TABLE DEPT_COPY AS SELECT * FROM DEPARTMENT; 
SELECT * FROM DEPT_COPY ;

-- 복사한 테이블에 PK 추가
ALTER TABLE DEPT_COPY ADD CONSTRAINT PK_DCOPY PRIMARY KEY(DEPT_ID);

-- 1) 컬럼명 변경 : ALTER TABLE 테이블명 RENAME COLUMN 컬럼명 TO 변경명;
ALTER TABLE DEPT_COPY RENAME COLUMN DEPT_TITLE TO DEPT_NAME;
SELECT * FROM DEPT_COPY;

-- 2) 제약조건명 변경 : ALTER TABLE 테이블명 RENAME CONSTRAINT 제약조건명 TO 변경명;
ALTER TABLE DEPT_COPY RENAME CONSTRAINT PK_DCOPY TO DEPT_COPY_PK;

-- 3) 테이블명 변경 : ALTER TABLE 테이블명 RENAME TO 변경명;
ALTER TABLE DEPT_COPY RENAME TO DCOPY;
SELECT * FROM DCOPY;
SELECT * FROM DEPT_COPY; -- 이름이 변경되어 DEPT_COPY 테이블명으로 조회 불가

----------------------------------------------------------------------------

/* 회원, 게시판, 댓글 테이블 기술서
 * 
 * 1) MEMBER 테이블 삭제하고 진행하기
 * 
 * 2) "COMMENT" -> COMMENT 테이블명 작성 시 " "(쌍따옴표)로 꼭 감싸기 
 * */

DROP TABLE "COMMENT";
DROP TABLE BOARD;
DROP TABLE MEMBER;

-------------------------------------------------------------------------------------------
-- MEMBER 테이블 --

CREATE TABLE MEMBER(
	MEMBER_NO 		NUMBER NOT NULL,
	MEMBER_EMAIL 	VARCHAR2(50) NOT NULL,
	MEMBER_PW 		VARCHAR2(100) NOT NULL,
	MEMBER_NICKNAME	VARCHAR2(30) NOT NULL,
	MEMBER_TEL 		CHAR(11) NOT NULL,
	MEMBER_ADDRESS 	VARCHAR2(300),
	ENROLL_DATE		DATE DEFAULT SYSDATE NOT NULL ,
	MEMBER_DEL_FL 	CHAR(1) DEFAULT 'N' NOT NULL
);

ALTER TABLE MEMBER ADD CONSTRAINT MEMBER_PK PRIMARY KEY(MEMBER_NO);

ALTER TABLE MEMBER ADD CONSTRAINT MEM_DEL_CHK CHECK(MEMBER_DEL_FL IN ('Y', 'N'));


COMMENT ON COLUMN MEMBER.MEMBER_NO IS '회원 번호';
COMMENT ON COLUMN MEMBER.MEMBER_EMAIL IS '회원 이메일';
COMMENT ON COLUMN MEMBER.MEMBER_PW IS '회원 비밀번호';
COMMENT ON COLUMN MEMBER.MEMBER_NICKNAME IS '회원 닉네임';
COMMENT ON COLUMN MEMBER.MEMBER_TEL IS '휴대폰 번호(- 없음)';
COMMENT ON COLUMN MEMBER.MEMBER_ADDRESS IS '회원 주소';
COMMENT ON COLUMN MEMBER.ENROLL_DATE IS '회원 가입일';
COMMENT ON COLUMN MEMBER.MEMBER_DEL_FL IS '탈퇴여부(N : 탈퇴X , Y : 탈퇴 O)';

-------------------------------------------------------------------------------------------
-- BOARD 테이블 --

CREATE TABLE BOARD (
	BOARD_NO		NUMBER NOT NULL,
	BOARD_TITLE		VARCHAR2(150) NOT NULL,
	BOARD_CONTENT	VARCHAR2(4000) NOT NULL,
	B_CREATE_DATE	DATE DEFAULT SYSDATE NOT NULL,
	READ_COUNT		NUMBER DEFAULT 0 NOT NULL,
	BOARD_DEL_FL	CHAR(1) DEFAULT 'N' NOT NULL,
	MEMBER_NO		NUMBER NOT NULL
);

ALTER TABLE BOARD ADD CONSTRAINT BOARD_PK PRIMARY KEY(BOARD_NO);

ALTER TABLE BOARD ADD CONSTRAINT BOARD_DEL_CHK CHECK(BOARD_DEL_FL IN ('Y', 'N'));

ALTER TABLE BOARD ADD CONSTRAINT BOARD_MEMBER_FK 
FOREIGN KEY(MEMBER_NO) REFERENCES MEMBER;


COMMENT ON COLUMN BOARD.BOARD_NO IS '게시글 번호';
COMMENT ON COLUMN BOARD.BOARD_TITLE IS '게시글 제목';
COMMENT ON COLUMN BOARD.BOARD_CONTENT IS '게시글 내용';
COMMENT ON COLUMN BOARD.B_CREATE_DATE IS '게시글 작성일';
COMMENT ON COLUMN BOARD.READ_COUNT IS '조회수';
COMMENT ON COLUMN BOARD.BOARD_DEL_FL IS '삭제 여부(N : 삭제X , Y : 삭제O)';
COMMENT ON COLUMN BOARD.MEMBER_NO IS '작성자 회원 번호';

-------------------------------------------------------------------------------------------
-- "COMMENT" 테이블 --

CREATE TABLE "COMMENT" (
	COMMENT_NO		NUMBER NOT NULL,
	COMMENT_CONTENT	VARCHAR2(4000) NOT NULL,
	C_CREATE_DATE	DATE DEFAULT SYSDATE NOT NULL,
	COMMENT_DEL_FL	CHAR(1)	DEFAULT 'N'	NOT NULL,
	BOARD_NO		NUMBER NOT NULL,
	MEMBER_NO		NUMBER NOT NULL
);

ALTER TABLE "COMMENT" ADD CONSTRAINT COMMENT_PK PRIMARY KEY(COMMENT_NO);

ALTER TABLE "COMMENT" ADD CONSTRAINT COMMENT_DEL_CHK CHECK(COMMENT_DEL_FL IN ('Y', 'N'));

ALTER TABLE "COMMENT" ADD CONSTRAINT COMMENT_BOARD_FK 
FOREIGN KEY(BOARD_NO) REFERENCES BOARD;

ALTER TABLE "COMMENT" ADD CONSTRAINT COMMENT_MEMBER_FK 
FOREIGN KEY(MEMBER_NO) REFERENCES MEMBER;



COMMENT ON COLUMN "COMMENT".COMMENT_NO IS '댓글 번호';
COMMENT ON COLUMN "COMMENT".COMMENT_CONTENT IS '댓글 내용';
COMMENT ON COLUMN "COMMENT".C_CREATE_DATE IS '댓글 작성일';
COMMENT ON COLUMN "COMMENT".COMMENT_DEL_FL IS '댓글 삭제 여부(N : 삭제X, Y : 삭제O)';
COMMENT ON COLUMN "COMMENT".BOARD_NO IS '댓글이 작성된 게시글 번호';
COMMENT ON COLUMN "COMMENT".MEMBER_NO IS '댓글 작성자 회원 번호';






