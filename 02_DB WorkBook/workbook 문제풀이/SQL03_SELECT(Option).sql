--춘 대학교 워크북 과제
--SQL03_SELECT(Option)

-- 1번
-- 학생이름과 주소지를 조회하시오
-- 단, 출력 헤더는 "학생 이름", "주소지"로 하고, 정렬은 이름으로 오름차순 정렬
SELECT STUDENT_NAME AS "학생 이름", STUDENT_ADDRESS AS 주소지
FROM TB_STUDENT
ORDER BY 1;


-- 2번
-- 휴학중인 학생들의 이름과 주민번호를 나이가 적은 순서 조회하시오.
SELECT STUDENT_NAME, STUDENT_SSN
FROM TB_STUDENT
WHERE ABSENCE_YN = 'Y'
ORDER BY STUDENT_SSN DESC;


-- 3번
-- 주소지가 강원도나 경기도인 학생들 중 1900년대 학번을 가진 학생들의 
-- 이름과 학번, 주소를 이름 오름차순으로 조회하시오.
-- 단, 출력헤더에는 "학생이름", "학번", "거주지 주소"가 출력되도록 한다.
SELECT STUDENT_NAME "학생이름", STUDENT_NO 학번, STUDENT_ADDRESS "거주지 주소"
FROM TB_STUDENT
WHERE STUDENT_NO LIKE '9%'
AND (STUDENT_ADDRESS LIKE '경기도%'
OR STUDENT_ADDRESS LIKE '강원도%')
ORDER BY 1;

-- 4번
-- 현재 법학과 교수의 이름, 주민등록 번호를 나이가 많은 순서부터 조회하시오.

-- ANSI
SELECT PROFESSOR_NAME, PROFESSOR_SSN
FROM TB_PROFESSOR
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
WHERE DEPARTMENT_NAME = '법학과'
ORDER BY 2;

-- ORACLE
SELECT PROFESSOR_NAME, PROFESSOR_SSN
FROM TB_PROFESSOR P, TB_DEPARTMENT D
WHERE P.DEPARTMENT_NO = D.DEPARTMENT_NO
AND DEPARTMENT_NAME = '법학과'
ORDER BY 2;


-- 5번
-- 2004년 2학기에 'C3118100' 과목을 수강한 학생들의 학점을 조회하려고 한다. 
-- 학점이 높은 학생부터 표시하고, 학점이 같으면 학번이 낮은 학생부터 조회하시오.
-- (참고) 소수점 아래 2자리까지 0으로 표현 : TO_CHAR(NUMBER, 'FM9.00')
-- (FM : 조회 결과 양쪽 공백 제거)
SELECT STUDENT_NO, TO_CHAR(POINT,'FM9.00') 학점 
FROM TB_GRADE
WHERE TERM_NO = '200402'
AND CLASS_NO = 'C3118100'
ORDER BY POINT DESC, STUDENT_NO;


-- 6번
-- 학생 번호, 학생 이름, 학과 이름을 학생 이름 오름차순으로 조회하시오.
-- ANSI
SELECT STUDENT_NO, STUDENT_NAME, DEPARTMENT_NAME
FROM TB_STUDENT
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
ORDER BY 2;

-- ORACLE
SELECT STUDENT_NO, STUDENT_NAME, DEPARTMENT_NAME
FROM TB_STUDENT S, TB_DEPARTMENT D
WHERE S.DEPARTMENT_NO = D.DEPARTMENT_NO
ORDER BY 2;


-- 7번
-- 춘 기술대학교의 과목 이름, 해당 과목을 수업하는 학과 이름을 조회하시오.
-- ANSI
SELECT CLASS_NAME, DEPARTMENT_NAME
FROM TB_CLASS
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO);

-- ORACLE
SELECT CLASS_NAME, DEPARTMENT_NAME
FROM TB_CLASS C, TB_DEPARTMENT D
WHERE C.DEPARTMENT_NO = D.DEPARTMENT_NO;


-- 8번
-- 과목, 해당 과목 교수 이름을 조회하시오.

-- TB_CLASS_PROFESSOR : 과목별 교수의 정보를 저장한 테이블(과목 코드, 학과 코드)
-- ANSI
SELECT CLASS_NAME, PROFESSOR_NAME
FROM TB_CLASS 
JOIN TB_CLASS_PROFESSOR USING(CLASS_NO)
JOIN TB_PROFESSOR USING(PROFESSOR_NO);

-- TB_CLASS와  TB_PROFESSOR 테이블이 공통으로
-- DEPARTMENT_NO 컬럼을 가지고 있다 해서 이를 이용해서 JOIN을 하면 안됨!
/* 
TB_CLASS와  TB_PROFESSOR 테이블을 조회 해보면
같은 컬럼 값을 가지는 DEPARTMENT_NO가 많이 존재함
--> 이럴 경우 
  TB_CLASS의  DEPARTMENT_NO 와
  TB_PROFESSOR의  DEPARTMENT_NO 컬럼 값들이
 서로 연결되기 위한 모든 경우의 수를 만들어냄 (곱집합이 되어버림)
*/
-- ORACLE
SELECT CLASS_NAME, PROFESSOR_NAME
FROM TB_CLASS C, TB_CLASS_PROFESSOR CP, TB_PROFESSOR P
WHERE C.CLASS_NO = CP.CLASS_NO
AND CP.PROFESSOR_NO = P.PROFESSOR_NO;


-- 9번
-- 8번의 결과 중 '인문 사회' 계열에 속한 
-- 과목명, 교수이름을 과목명 오름차순으로 조회하시오.

-- ANSI
SELECT CLASS_NAME, PROFESSOR_NAME
FROM TB_CLASS
JOIN TB_CLASS_PROFESSOR USING(CLASS_NO)
JOIN TB_PROFESSOR P USING(PROFESSOR_NO)
JOIN TB_DEPARTMENT D ON (P.DEPARTMENT_NO = D.DEPARTMENT_NO)
WHERE CATEGORY = '인문사회'
ORDER BY 1;

-- ORACLE
SELECT CLASS_NAME, PROFESSOR_NAME
FROM TB_CLASS C, TB_CLASS_PROFESSOR CP, TB_PROFESSOR P, TB_DEPARTMENT D
WHERE C.CLASS_NO = CP.CLASS_NO
AND CP.PROFESSOR_NO = P.PROFESSOR_NO
AND P.DEPARTMENT_NO = D.DEPARTMENT_NO
AND CATEGORY = '인문사회'
ORDER BY 1;
                        
-- 10번
-- 음악학과 학생들의 "학번", "학생 이름", "전체 평점"을 조회하시오.
-- (단, 평점은 소수점 1자리까지만 반올림하여 표시한다.)

-- ANSI
SELECT S.STUDENT_NO 학번, STUDENT_NAME "학생 이름", ROUND(AVG(POINT),1) "전체 평점"
FROM TB_GRADE G
JOIN TB_STUDENT S ON(S.STUDENT_NO = G.STUDENT_NO)
JOIN TB_DEPARTMENT D ON(S.DEPARTMENT_NO = D.DEPARTMENT_NO)
WHERE DEPARTMENT_NAME = '음악학과'
GROUP BY S.STUDENT_NO, STUDENT_NAME
ORDER BY 1;

-- ORACLE
SELECT S.STUDENT_NO 학번, STUDENT_NAME "학생 이름", ROUND(AVG(POINT),1) "전체 평점"
FROM TB_GRADE G, TB_STUDENT S, TB_DEPARTMENT D
WHERE G.STUDENT_NO = S.STUDENT_NO
AND S.DEPARTMENT_NO = D.DEPARTMENT_NO
AND DEPARTMENT_NAME = '음악학과'
GROUP BY S.STUDENT_NO, STUDENT_NAME
ORDER BY 1;


-- 11번
-- 학번이 A313047인 학생의 학과이름, 학생이름, 지도교수 이름을 조회하시오.

-- ANSI
SELECT DEPARTMENT_NAME 학과이름, STUDENT_NAME 학생이름, PROFESSOR_NAME 지도교수이름
FROM TB_STUDENT S
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
JOIN TB_PROFESSOR P ON(S.COACH_PROFESSOR_NO = P.PROFESSOR_NO)
WHERE STUDENT_NO = 'A313047';

-- ORACLE
SELECT DEPARTMENT_NAME 학과이름, STUDENT_NAME 학생이름, PROFESSOR_NAME 지도교수이름
FROM TB_STUDENT S, TB_DEPARTMENT D, TB_PROFESSOR P
WHERE S.COACH_PROFESSOR_NO = P.PROFESSOR_NO
AND S.DEPARTMENT_NO = D.DEPARTMENT_NO
AND STUDENT_NO = 'A313047';

-- 12번
-- 2007년도에 '인간관계론' 과목을 수강한 학생을 찾아 
-- 학생이름과 수강학기를 조회하는 SQL을 작성하시오.

-- ANSI
SELECT STUDENT_NAME, TERM_NO TERM_NAME
FROM TB_STUDENT
JOIN TB_GRADE USING(STUDENT_NO)
JOIN TB_CLASS USING(CLASS_NO)
WHERE CLASS_NAME = '인간관계론'
AND TERM_NO LIKE '2007%';

-- ORACLE
SELECT STUDENT_NAME, TERM_NO TERM_NAME
FROM TB_STUDENT S, TB_GRADE G, TB_CLASS C
WHERE S.STUDENT_NO = G.STUDENT_NO
AND G.CLASS_NO = C.CLASS_NO
AND CLASS_NAME = '인간관계론'
AND TERM_NO LIKE '2007%';


-- 13번
-- 예체능 계열 과목 중 과목 담당교수를 한 명도 배정받지 못한 과목을 찾아 
-- 과목 이름, 학과 이름을 조회하시오.

-- ANSI
SELECT CLASS_NAME, DEPARTMENT_NAME
FROM TB_CLASS C
LEFT JOIN TB_CLASS_PROFESSOR USING(CLASS_NO)
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
WHERE CATEGORY = '예체능'
AND PROFESSOR_NO IS NULL;

SELECT CLASS_NAME, DEPARTMENT_NAME
FROM TB_CLASS
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
LEFT JOIN TB_CLASS_PROFESSOR USING(CLASS_NO)
WHERE CATEGORY = '예체능'
AND PROFESSOR_NO IS NULL;



-- ORACLE
SELECT CLASS_NAME, DEPARTMENT_NAME
FROM TB_CLASS C, TB_CLASS_PROFESSOR P, TB_DEPARTMENT D
WHERE C.CLASS_NO = P.CLASS_NO(+)
AND C.DEPARTMENT_NO = D.DEPARTMENT_NO
AND CATEGORY = '예체능'
AND PROFESSOR_NO IS NULL;




-- 14번
-- 춘 기술대학교 서반아어학과 학생들의 지도교수를 게시하고자 한다. 
-- 학생이름, 지도교수이름 학번이 높은 순서로 조회하는 SQL을 작성하시오.
-- 단, 지도교수가 없을 경우 "지도교수 미지정"으로 표시

-- ANSI
SELECT STUDENT_NAME 학생이름, NVL(PROFESSOR_NAME, '지도교수 미지정') 지도교수
FROM TB_STUDENT S
LEFT JOIN TB_PROFESSOR P ON(S.COACH_PROFESSOR_NO = P.PROFESSOR_NO)
JOIN TB_DEPARTMENT D ON(S.DEPARTMENT_NO = D.DEPARTMENT_NO)
WHERE DEPARTMENT_NAME = '서반아어학과'
ORDER BY STUDENT_NO;

-- ORACLE
SELECT STUDENT_NAME 학생이름, NVL(PROFESSOR_NAME, '지도교수 미지정') 지도교수
FROM TB_STUDENT S, TB_PROFESSOR P, TB_DEPARTMENT D 
WHERE S.COACH_PROFESSOR_NO = P.PROFESSOR_NO(+)
AND S.DEPARTMENT_NO = D.DEPARTMENT_NO
AND DEPARTMENT_NAME = '서반아어학과'
ORDER BY STUDENT_NO;


-- 15번
-- 휴학생이 아닌 학생 중 평점이 4.0 이상인 학생을 찾아 
-- 학생의 학번, 이름, 학과, 이름, 평점을 조회하시오.

-- ANSI
SELECT STUDENT_NO 학번, STUDENT_NAME 이름, DEPARTMENT_NAME "학과 이름", TRUNC(AVG(POINT),8) 평점
FROM TB_STUDENT 
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
JOIN TB_GRADE USING(STUDENT_NO)
WHERE ABSENCE_YN = 'N'
GROUP BY STUDENT_NO, STUDENT_NAME, DEPARTMENT_NAME
HAVING AVG(POINT) >= 4
ORDER BY 1;

-- ORACLE
SELECT S.STUDENT_NO 학번, STUDENT_NAME 이름, DEPARTMENT_NAME "학과 이름", TRUNC(AVG(POINT),8) 평점
FROM TB_STUDENT S, TB_DEPARTMENT D, TB_GRADE G
WHERE S.DEPARTMENT_NO = D.DEPARTMENT_NO
AND S.STUDENT_NO = G.STUDENT_NO
AND ABSENCE_YN = 'N'
GROUP BY S.STUDENT_NO, STUDENT_NAME, DEPARTMENT_NAME
HAVING AVG(POINT) >= 4
ORDER BY 1;


-- 16번
-- 환경조경학과 전공과목들의 과목 별 평점을 조회하시오.
-- (평점은 TRUNC를 이용해 소수점 아래 둘째 자리까지 표시)
-- ANSI
SELECT CLASS_NO, CLASS_NAME, TRUNC(AVG(POINT),2) 평점
FROM TB_CLASS 
JOIN TB_GRADE USING(CLASS_NO)
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
WHERE DEPARTMENT_NAME = '환경조경학과'
AND CLASS_TYPE LIKE '전공%'
GROUP BY CLASS_NO, CLASS_NAME
ORDER BY 1;

-- ORACLE
SELECT C.CLASS_NO, CLASS_NAME, TRUNC(AVG(POINT),2) 평점
FROM TB_CLASS C, TB_GRADE G, TB_DEPARTMENT D
WHERE C.CLASS_NO = G.CLASS_NO
AND C.DEPARTMENT_NO = D.DEPARTMENT_NO
AND DEPARTMENT_NAME = '환경조경학과'
AND CLASS_TYPE LIKE '전공%'
GROUP BY C.CLASS_NO, CLASS_NAME
ORDER BY 1;



-- 17번
-- 춘 기술대학교에 다니고 있는 최경희 학생과 같은 과 학생들의 이름과 주소를 조회하시오.
SELECT STUDENT_NAME, STUDENT_ADDRESS
FROM TB_STUDENT
WHERE DEPARTMENT_NO = (SELECT DEPARTMENT_NO
                       FROM TB_STUDENT
                       WHERE STUDENT_NAME = '최경희');
              
                       
-- 18번
-- 국어국문학과에서 총 평점이 가장 높은 학생의 이름과 학번을 조회하시오
SELECT STUDENT_NO, STUDENT_NAME
FROM
    (SELECT STUDENT_NO, STUDENT_NAME, AVG(POINT) 평점
    FROM TB_GRADE
    JOIN TB_STUDENT USING(STUDENT_NO)
    WHERE DEPARTMENT_NO  = (SELECT DEPARTMENT_NO
                            FROM TB_DEPARTMENT
                            WHERE DEPARTMENT_NAME = '국어국문학과')
    GROUP BY STUDENT_NO, STUDENT_NAME
    ORDER BY 평점 DESC)
WHERE ROWNUM = 1;




-- 19번
-- 춘 기술대학교의 "환경조경학과"가 속한 같은 계열 학과들의 
-- 학과 별 전공과목 평점을 파악하기 위한 적절한 SQL문을 작성하시오
-- 단, 출력헤더는 "계열 학과명", "전공평점"으로 표시되도록 하고, 
-- 평점은 소수점 첫째자리까지만 반올림하여 표시
-- ANSI
SELECT DEPARTMENT_NAME "계열 학과명", ROUND(AVG(POINT),1) 전공평점
FROM TB_DEPARTMENT 
JOIN TB_CLASS USING(DEPARTMENT_NO)
JOIN TB_GRADE USING(CLASS_NO)
WHERE CATEGORY = (SELECT CATEGORY
                  FROM TB_DEPARTMENT
                  WHERE DEPARTMENT_NAME = '환경조경학과')
AND CLASS_TYPE LIKE '전공%'
GROUP BY DEPARTMENT_NAME
ORDER BY 1;

-- ORACLE
SELECT DEPARTMENT_NAME "계열 학과명", ROUND(AVG(POINT),1) 전공평점
FROM TB_DEPARTMENT D, TB_CLASS C, TB_GRADE G
WHERE D.DEPARTMENT_NO = C.DEPARTMENT_NO
AND C.CLASS_NO = G.CLASS_NO
AND CATEGORY = (SELECT CATEGORY
                FROM TB_DEPARTMENT
                WHERE DEPARTMENT_NAME = '환경조경학과')
AND CLASS_TYPE LIKE '전공%'
GROUP BY DEPARTMENT_NAME
ORDER BY 1;
