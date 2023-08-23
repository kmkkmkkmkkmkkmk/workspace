
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

FROM




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







































