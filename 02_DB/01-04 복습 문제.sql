
-- 1. 주민번호가 70년대 생이면서 성별이 여자이고, 성이 '전'씨인 직원들의
-- 사원명, 주민번호, 부서명, 직급명을 조회하시오
SELECT  EMP_NAME , EMP_NO, DEPT_TITLE,  JOB_NAME
FROM EMPLOYEE
JOIN DEPARTMENT
JOIN JOB USING (JOB_CODE)
WHERE SUBSTR(EMP_NO,1,1 ) = '7'
AND SUBSTR(EMP_NO,8,2) = '여자'
AND EMP_NAME LIKE '전%';




-- 2. 이름에 '형'자가 들어가는 직원들의 사번, 사원명, 직급명을 조회하시오.
SELECT EMP_ID, EMP_NAME, JOB_NAME
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)	
WHERE EMP_NAME LIKE '%형%';



-- 3. 해외영업 1부, 2부에 근무하는 사원의 
-- 사원명, 직급명, 부서코드, 부서명을 조회하시오. + 사번 오름차순





-- 4. 보너스포인트를 받는 직원들의 사원명, 보너스포인트, 부서명, 근무지역명을 조회하시오.





-- 5. 부서가 있는 사원의 사원명, 직급명, 부서명, 지역명 조회





-- 6. 급여등급별 최소급여(MIN_SAL)보다 많이 받는 직원들의 
-- 사원명, 직급명, 급여, 연봉(보너스포함)을 조회하시오.
-- 연봉에 보너스포인트를 적용하시오.




-- 7. 한국(KO)과 일본(JP)에 근무하는 직원들의
-- 사원명, 부서명, 지역명, 국가명을 조회하시오.





-- 8. 같은 부서에 근무하는 직원들의 사원명, 부서코드, 동료이름을 조회하시오.
-- SELF JOIN 사용






-- 9. 보너스포인트가 없는 직원들 중에서 직급코드가 J4와 J7인 직원들의 사원명, 직급명, 급여를 조회하시오.
-- 단, JOIN, IN 사용할 것




-- 서브쿼리 예시 1.
-- 부서코드가 노옹철사원과 같은 소속의 직원의 
-- 이름, 부서코드 조회하기

-- 1) 사원명이 노옹철인 사람의 부서코드 조회
SELECT DEPT_CODE FROM EMPLOYEE
WHERE EMP_NAME = '노옹철';

-- 2) 부서코드가 D9인 직원을 조회
SELECT DEPT_CODE, EMP_NAME 
FROM EMPLOYEE 
WHERE DEPT_CODE = 'D9';




-- 3) 부서코드가 노옹철사원과 같은 소속의 직원 명단 조회   
--> 위의 2개의 단계를 하나의 쿼리로!!! --> 1) 쿼리문을 서브쿼리로!!
SELECT DEPT_CODE, EMP_NAME 
FROM EMPLOYEE 
WHERE DEPT_CODE = (SELECT DEPT_CODE 
					FROM EMPLOYEE
					WHERE EMP_NAME = '노옹철');



-- 서브쿼리 예시 2.
-- 전 직원의 평균 급여보다 많은 급여를 받고 있는 직원의 
-- 사번, 이름, 직급코드, 급여 조회
				
-- 1) 전 직원의 평균 급여 조회하기				
SELECT AVG(SALARY)
FROM EMPLOYEE;
				
-- 2) 직원들중 급여가 3047663원 이상인 사원들의 사번, 이름, 직급코드, 급여 조회				
SELECT EMP_ID , EMP_NAME , JOB_CODE  , SALARY 
FROM EMPLOYEE 
WHERE SALARY >= '3047663';
				
-- 3) 전 직원의 평균 급여보다 많은 급여를 받고 있는 직원 조회
--> 위의 2단계를 하나의 쿼리로 가능하다!! --> 1) 쿼리문을 서브쿼리로!!				
SELECT EMP_ID , EMP_NAME , JOB_CODE  , SALARY 
FROM EMPLOYEE 
WHERE SALARY >= (SELECT AVG(SALARY)
				FROM EMPLOYEE);				
				
				
				
-- 전 직원의 급여 평균보다 많은 급여를 받는 직원의 
-- 이름, 직급명, 부서명, 급여를 직급 순으로 정렬하여 조회				
SELECT EMP_NAME, JOB_NAME, DEPT_TITLE, SALARY
FROM EMPLOYEE 
JOIN JOB USING (JOB_CODE)
LEFT JOIN DEPARTMENT ON (DEPT_CODE=DEPT_ID)
WHERE SALARY > (SELECT AVG(SALARY) FROM EMPLOYEE)
ORDER BY JOB_CODE;

-- 가장 적은 급여를 받는 직원의
-- 사번, 이름, 직급, 부서코드, 급여, 입사일을 조회
SELECT MIN(SALARY)
FROM EMPLOYEE ;

SELECT EMP_ID, EMP_NAME, JOB_NAME, DEPT_CODE, SALARY, HIRE_DATE 
FROM EMPLOYEE 
WHERE SALARY = (SELECT MIN(SALARY)
FROM EMPLOYEE);


--  사원의 급여보다 많이 받는 직원의 
-- 사번, 이름, 부서, 직급, 급여를 조회
SELECT SALARY
FROM EMPLOYEE

SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, SALARY 
FROM EMPLOYEE 
JOIN JOB USING (JOB_CODE)
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);
				
				
				
				
-- 부서별(부서가 없는 사람 포함) 급여의 합계 중 가장 큰 부서의
-- 부서명, 급여 합계를 조회 

-- 1) 부서별 급여 합 중 가장 큰값 조회	
SELECT MAX(SUM(SALARY))
FROM EMPLOYEE 
GROUP BY DEPT_CODE;
				
-- 2) 부서별 급여합이 17700000인 부서의 부서명과 급여 합 조회				
SELECT DEPT_TITLE, SUM(SALARY)
FROM EMPLOYEE 
JOIN DEPARTMENT ON (DEPT_CODE=DEPT_ID)
GROUP BY DEPT_TITLE
HAVING SUM(SALARY) = 17700000;

-- 3) >> 위의 두 서브쿼리 합쳐 부서별 급여 합이 큰 부서의 부서명, 급여 합 조회			
SELECT DEPT_TITLE, SUM(SALARY)
FROM EMPLOYEE 
JOIN DEPARTMENT ON (DEPT_CODE=DEPT_ID)
GROUP BY DEPT_TITLE
HAVING SUM(SALARY) = (SELECT MAX(SUM(SALARY))
FROM EMPLOYEE 
GROUP BY DEPT_CODE );		
				
				
				
				
				
				
				
				
				
				
				
				
				
				







