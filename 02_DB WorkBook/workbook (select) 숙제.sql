-- 1번
-- 춘 기술대학교의 학과 이름과 계열을 조회하시오.
-- 단, 출력 헤더(컬럼명)는 "학과 명", "계열"으로 표시하도록 한다.

SELECT DEPARTMENT_NAME 학과명, CATEGORY "계열"
FROM TB_DEPARTMENT ;




-- 2 번
-- 학과의 학과 정원을 다음과 같은 형태로 조회하시오.
--SELECT DEPARTMENT_NAME 학과별, COUNT(*) 
--FROM TB_DEPARTMENT 
--JOIN TB_STUDENT USING (DEPARTMENT_NO)
--GROUP BY DEPARTMENT_NAME
--ORDER BY DEPARTMENT_NAME;

SELECT DEPARTMENT_NAME || '의 정원은 ' || CAPACITY || '명 입니다.' "학과별 정원" 
FROM TB_DEPARTMENT;

-- 문자열 출력 어캐해 ㅠㅠ


-- 3번
-- "국어국문학과" 에 다니는 여학생 중 현재 휴학중인 여학생을 조회하시오.
-- (국문학과의 학과코드(DEPARTMENT_NO)는 001)

SELECT STUDENT_NAME
FROM TB_DEPARTMENT 
JOIN TB_STUDENT USING(DEPARTMENT_NO)
WHERE DEPARTMENT_NAME = '국어국문학과'
AND SUBSTR(STUDENT_SSN,8,1) = '2' 
AND ABSENCE_YN = 'Y';

-- 한수연만 출력 어떻게 해야해 ㅠㅠ!


-- 4번
-- 도서관에서 대출 도서 장기 연체자들을 찾아 이름을 게시하고자 한다.
-- 그 대상자들의 학번이 다음과 같을 때 대상자들을 찾는 적절한 SQL구문을 작성하시오.
-- A513079, A513090, A513091, A513110, A513119
SELECT STUDENT_NAME 
FROM TB_STUDENT 
WHERE STUDENT_NO IN ('A513079', 'A513090', 'A513091', 'A513110', 'A513119')
ORDER BY STUDENT_NO DESC;



-- 5번
-- 입학 정원이 20명 이상 30명 이하인 학과들의 학과 이름과 계열을 조회하시오.
SELECT DEPARTMENT_NAME, CATEGORY  
FROM TB_DEPARTMENT 
WHERE CAPACITY >= 20
AND CAPACITY <= 30;




-- 6번
-- 춘 기술대학교는 총장을 제외하고 모든 교수들이 소속 학과를 가지고 있다.
-- 그럼 춘 기술대학교 총장의 이름을 알아낼 수 있는 SQL 문장을 작성하시오.
--SELECT PROFESSOR_NO, COACH_PROFESSOR_NO
--FROM TB_PROFESSOR
--JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
--JOIN TB_STUDENT USING (DEPARTMENT_NO)

-- 죽어도 모르겠음 
--SELECT PROFESSOR_NAME,COACH_PROFESSOR_NO 
--FROM TB_PROFESSOR 
--JOIN TB_STUDENT USING (DEPARTMENT_NO);

SELECT PROFESSOR_NAME 
FROM TB_PROFESSOR 
WHERE DEPARTMENT_NO IS NULL;

-- 7번
-- 수강신청을 하려고 한다. 선수과목 여부를 확인해야 하는데, 선수과목이 존재하는 과목들은
-- 어떤 과목인지 과목 번호를 조회하시오

SELECT DEPARTMENT_NAME , CLASS_NO
FROM TB_CLASS 
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
WHERE PREATTENDING_CLASS_NO IS NOT NULL;



-- 8번
-- 춘 대학에는 어떤 계열(CATEGORY)들이 있는지 조회해 보시오
SELECT DISTINCT CATEGORY 
FROM TB_DEPARTMENT; 


-- 9번
-- 02학번 전주 거주자들의 모임을 만들려고 한다. 휴학한 사람들은 제외한 재학중인 학생들의
-- 학번, 이름, 주민번호를 조회하는 구문을 작성하시오
SELECT STUDENT_NO, STUDENT_NAME, STUDENT_SSN
FROM TB_STUDENT 
WHERE SUBSTR(STUDENT_NO,2,1) = '2'
AND STUDENT_ADDRESS LIKE '%전주%'
AND ABSENCE_YN = 'N';


------------------------------------------------------------------------------------------------------------------------------------------

-- 1번
-- 영어영문학과(학과코드 002) 학생들의 학번과 이름, 입학 년도를
-- 입학 년도가 빠른 순으로 표시하는 SQL을 작성하시오.
-- (단, 헤더는 "학번", "이름", "입학년도" 가 표시되도록 한다.)
SELECT STUDENT_NO 학번, STUDENT_NAME AS 이름, TO_CHAR(ENTRANCE_DATE, 'YYYY-MM-DD') AS "입학년도" 
FROM TB_STUDENT 
WHERE DEPARTMENT_NO = '002';



-- 2번 
-- 춘 기술대학교의 교수 중 이름이 세 글자가 아닌 교수가 두 명 있다고 한다. 
-- 그 교수의 이름과 주민번호를 조회하는 SQL을 작성하시오
SELECT PROFESSOR_NAME, PROFESSOR_SSN
FROM TB_PROFESSOR 
--WHERE LENGTH (PROFESSOR_NAME) !=  3;
WHERE PROFESSOR_NAME NOT LIKE '___';




-- 3번 (다시풀기)
-- 춘 기술대학교의 남자 교수들의 이름과 나이를 나이 오름차순으로 조회하시오.
-- (단, 교수 중 2000년 이후 출생자는 없으며 출력 헤더는 "교수이름"으로 한다. 
-- 나이는 '만'으로 계산한다.)
SELECT  PROFESSOR_NAME 교수이름,
   FLOOR(MONTHS_BETWEEN(SYSDATE, TO_DATE('19' || SUBSTR(PROFESSOR_SSN,1,6), 'YYYYMMDD')) / 12)
   나이
FROM TB_PROFESSOR 
WHERE SUBSTR(PROFESSOR_SSN,8,1) = '1'
ORDER BY 나이;




-- 5번
SELECT STUDENT_NO, STUDENT_NAME 
FROM TB_STUDENT 
WHERE EXTRACT  (YEAR FROM ENTRANCE_DATE) 
	- EXTRACT  (YEAR FROM TO_DATE('19' || SUBSTR(STUDENT_SSN,1,6), 'YYYYMMDD' ) )
	> 19;


-- 7번  (다시풀기)

SELECT ROUND( AVG(POINT) , 1) 평점
FROM TB_GRADE 
WHERE STUDENT_NO = 'A517178';





-- 10번  (다시풀기)

SELECT SUBSTR(TERM_NO,1,4) 년도, ROUND(AVG(POINT), 1 ) 평점
FROM TB_GRADE 
WHERE STUDENT_NO = 'A112113'
GROUP BY SUBSTR(TERM_NO,1,4);

-- 11번 (다시풀기)
-- 학과 별 휴학생 수를 파악하고자 한다. 
-- 학과 번호와 휴학생 수를 조회하는 SQL을 작성하시오.
SELECT DEPARTMENT_NO, 
   COUNT( DECODE(ABSENCE_YN, 'Y', 'Y') ),
   SUM( DECODE(ABSENCE_YN, 'Y', 1, 'N', 0) )
FROM TB_STUDENT 
GROUP BY DEPARTMENT_NO
ORDER BY DEPARTMENT_NO;




-- 12번 (다시풀기)
SELECT STUDENT_NAME "이름", COUNT(*) "동명인 수"
FROM TB_STUDENT 
GROUP BY STUDENT_NAME
HAVING COUNT(*) > 1
ORDER BY STUDENT_NAME ;


-- 13번 (다시풀기)
SELECT NVL(SUBSTR(TERM_NO,1,4), ' ') 년도, 
   NVL(SUBSTR(TERM_NO,5,2), ' ') 학기, ROUND(AVG(POINT), 1) 평점
FROM TB_GRADE 
WHERE STUDENT_NO = 'A112113'
GROUP BY ROLLUP( SUBSTR(TERM_NO,1,4), SUBSTR(TERM_NO,5,2) );



------------------------------------------------------------------------------------------------------------------------------------------

-- 10번 (다시풀기)
SELECT STUDENT_NO , STUDENT_NAME, ROUND(AVG(POINT), 1) "전체 평점"
FROM TB_STUDENT
JOIN TB_GRADE USING(STUDENT_NO)
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
WHERE DEPARTMENT_NAME = '음악학과'
GROUP BY STUDENT_NO , STUDENT_NAME
ORDER BY STUDENT_NO;


-- 13번 (다시풀기)
-- 예체능 계열 과목 중 과목 담당교수를 한 명도 배정받지 못한 과목을 찾아
-- 과목 이름, 학과 이름을 조회하시오.
SELECT CLASS_NAME, DEPARTMENT_NO 
FROM TB_CLASS 
LEFT JOIN TB_CLASS_PROFESSOR USING(CLASS_NO)
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
WHERE CATEGORY = '예체능'
AND PROFESSOR_NO IS NULL;


-- 15번 (다시풀기)
-- 휴학생이 아닌 학생 중 평점이 4.0 이상인 학생을 찾아
-- 학생의 학번, 이름, 학과 이름, 평점을 조회하시오.
SELECT STUDENT_NO "학번", STUDENT_NAME "이름", 
   DEPARTMENT_NAME "학과 이름",
   AVG(POINT) "평점"
FROM TB_STUDENT 
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
JOIN TB_GRADE USING(STUDENT_NO)
WHERE ABSENCE_YN != 'Y'
GROUP BY STUDENT_NO, STUDENT_NAME, DEPARTMENT_NAME
HAVING AVG(POINT) >= 4
ORDER BY "학번";




































































