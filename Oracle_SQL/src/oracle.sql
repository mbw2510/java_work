SELECT EMP_ID AS empid,
	   EMP_NAME AS 이름,
		SALARY*12 AS "1년급여",
		(SALARY+(SALARY*BONUS_PCT))*12 AS 총소득
FROM EMPLOYEE;

SELECT EMP_ID,
		EMP_NAME,
		'재직'AS근무여부
FROM EMPLOYEE;

SELECT DISTINCT DEPT_ID
FROM EMPLOYEE;
--DISTINCT 는 SELECT절에서 한번만 사용가능하다.
--중복값을 제외하고 가져오는 기능
--만약 DISTINCT COLUMN명, COLUMN명 으로 하면
--두 칼럼명을 COMPOSITE 해서 한개의 식별자로 인식한다.

SELECT DISTINCT JOB_ID, DEPT_ID
FROM EMPLOYEE;

SELECT EMP_NAME AS 이름,
	   DEPT_ID AS 부서
FROM EMPLOYEE
WHERE DEPT_ID = '90';

SELECT EMP_NAME AS 이름,
	   SALARY AS 급여
FROM EMPLOYEE
WHERE SALARY > 4000000;

--부서코드가 90이고 급여를 2000000보다 많이 받는 부서원 이름과 부서코드, 급여를 조회해보세요,
SELECT EMP_NAME AS 이름,
	   DEPT_ID AS 부서,
	   SALARY AS 급여
FROM EMPLOYEE
WHERE DEPT_ID = '90'
AND SALARY > 2000000;

--90부서나 20부서에 소속된 부서원 이름, 부서코드, 급여조회
SELECT EMP_NAME AS 이름,
	   DEPT_ID AS 부서,
	   SALARY AS 급여
FROM EMPLOYEE
WHERE DEPT_ID = '90'
OR DEPT_ID = '20';

--연산자에 대해 배워보자
--연결연산자 ||
--오라클은 문자를 싱클코테이션으로 인식한다 ' '
--연결연산자 || 를 사용하여 여러 칼럼을 하나의 칼럼인 것 처럼 연결하거나, 컬럼과 리터럴을 연결할 수 있다.

--컬럼과 컬럼을 연결한경우
SELECT EMP_ID||EMP_NAME||SALARY
FROM EMPLOYEE;
--컬럼과 리터럴을 연결한 경우
SELECT EMP_NAME||'의 월급은'||SALARY||'원 입니다.'
FROM EMPLOYEE;

--비교 연산자 BETWEEN
--~보다 크거나 같고 ~~보다 작거나 같은 값을 조회할 수 있는 연산자
--급여를 3,500,000원보다 많이 받고 5500000원 보다 적게 받는 직원이름과 급여조회
SELECT EMP_NAME,
	   SALARY
FROM EMPLOYEE
WHERE SALARY BETWEEN 3500000 AND 5500000;

SELECT EMP_NAME,
	   SALARY
FROM EMPLOYEE
WHERE SALARY >= 3500000
AND SALARY <- 5500000;

--비교연산자 LIKE
--비교하려는 값이 지정한 특정 패턴을 만족시키면 TRUE를 반환하는 연산자
--패턴지정을 위해 와일드 카드 사용
-- - %: %부분에는 임의문자열(0개이상의임의의문자)이 있다는 의미
-- - _: _부분에는 문자 1개만 있다는 의미 

--'김'씨 성을 가진 직원 이름과 급여조회
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE EMP_NAME LIKE '김%';
--9000번대 4자리 국번의 전화번호를 사용하는 직원 전화번호 조회
SELECT EMP_NAME, PHONE
FROM EMPLOYEE
WHERE PHONE LIKE '___9_______';

--NOT 이 붙을 수도 있따.
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE EMP_NAME NOT LIKE '김%';

SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE NOT EMP_NAME LIKE '김%';

--ESCAPE OPTION : 와일드 카드('%','_') 자체를 데이터로 처리해야 하는 경우에 사용
--이메일 아이디 중'_' 앞자리가 3자리인 직원 조회
SELECT EMP_NAME,
	   EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE '___\_%' ESCAPE '\';

--ESCAPE OPTION에 사용하는 문자는 임의 지정가능
SELECT EMP_NAME,
	   EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE '___#_%' ESCAPE '#';

--비교연산자 - IS NULL / IS NOT NULL
--NULL 여부를 비교하는 연산자
--NULL은 다른값들과 동일하게 생각할수없다.
SELECT *
FROM JOB;

SELECT *
FROM EMPLOYEE;

--관리자도 없고 부서배치도 받지 않은 직원 이름 조회
SELECT EMP_NAME, MGR_ID, DEPT_ID
FROM EMPLOYEE
WHERE MGR_ID IS NULL
AND DEPT_ID IS NULL;
--EQUAL로 쓰면 오류가 난다.
SELECT EMP_NAME, MGR_ID, DEPT_ID
FROM EMPLOYEE
WHERE MGR_ID = NULL
AND DEPT_ID = NULL;

--부서 배치를 받지 않았음에도 보너스를 지급받는 직원 이름 조회
SELECT EMP_NAME, DEPT_ID, BONUS_PCT
FROM EMPLOYEE
WHERE DEPT_ID IS NULL
AND BONUS_PCT IS NOT NULL;

--비교연산자 IN
--비교하려는 값 목록에 일치하는 값이 있으면 TRUE를 반환하는 연산자
--60번 부서나 90번 부서원들의 이름, 부서코드, 급여조회
SELECT EMP_NAME, DEPT_ID, SALARY
FROM EMPLOYEE
WHERE DEPT_ID IN('60','90');

--또는 
SELECT EMP_NAME, DEPT_ID, SALARY
FROM EMPLOYEE
WHERE DEPT_ID=60
OR DEPT_ID=90;

--연산자 우선순위
--여러 연산자를 함께 사용하면 우선순위를 알아야한다.
--()를 사용하면 연산자 우선순위를 조절할 수 있다.
--20번 또는 90번 부서원 중 급여를 3000000원 보다 많이 받는 직원이름, 급여, 부서코드 조회
SELECT EMP_NAME, SALARY, DEPT_ID
FROM EMPLOYEE
WHERE (DEPT_ID='20'
OR 	  DEPT_ID = '90')
AND SALARY > 3000000;

--우선순위를 지정하지 않으면 다른 결과값이 나온다.
SELECT EMP_NAME, SALARY, DEPT_ID
FROM EMPLOYEE
WHERE DEPT_ID='20'
OR 	  DEPT_ID = '90'
AND SALARY > 3000000;

SELECT DEPARTMENT_NAME AS 학과명,
	   CATEGORY AS 계열
FROM TB_DEPARTMENT;
--1번클리어

2.학과의 학과 정원을 다음과 같은 형태로 화면에 출력핚다.
국어국문학과의 정원은 20 명 입니다.

SELECT DEPARTMENT_NAME||'의 정원은 '||CAPACITY||'입니다.' AS "학과별 정원"
FROM TB_DEPARTMENT
--2번클리어

3. "국어국문학과" 에 다니는 여학생 중 현재 휴학중인 여학생을 찾아달라는 요청이
들어왔다. 누구인가? (국문학과의 '학과코드'는 학과 테이블(TB_DEPARTMENT)을 조회해서
찾아 내도록 하자) 001
STUDENT_NAME
--------------------
한수현
SELECT DEPARTMENT_NO AS 학과코드,
	   DEPARTMENT_NAME AS 학과이름
FROM TB_DEPARTMENT;

SELECT STUDENT_NAME
FROM   TB_STUDENT
WHERE  DEPARTMENT_NO = 001
AND    STUDENT_SSN LIKE '_______2______'
AND    ABSENCE_YN = 'Y';
--3번 클리어

4. 도서관에서 대출 도서 장기 연체자 들을 찾아 이름을 게시하고자 핚다. 그 대상자들의
학번이 다음과 같을 때 대상자들을 찾는 적절한 SQL 구문을 작성하시오.
A513079, A513090, A513091, A513110, A513119
STUDENT_NAME
--------------------
홍경희
최경희
정경훈
정경환
이경환

SELECT STUDENT_NAME
FROM  TB_STUDENT
WHERE STUDENT_NO = 'A513079'
OR STUDENT_NO = 'A513090'
OR STUDENT_NO = 'A513091'
OR STUDENT_NO = 'A513110'
OR STUDENT_NO = 'A513119';
--4번 클리어

5. 입학정원이 20 명 이상 30 명 이하인 학과들의 학과 이름과 계열을 출력하시오.
DEPARTMENT_NAME CATEGORY
-------------------- --------------------
국어국문학과 인문사회
사학과 인문사회
철학과 인문사회
…
…
미술학과 예체능
산업디자인학과 예체능
체육학과 예체능

SELECT DEPARTMENT_NAME, CATEGORY
FROM TB_DEPARTMENT
WHERE CAPACITY BETWEEN 20 AND 30;
--5번 클리어

6. 춘 기술대학교는 총장을 제외하고 모든 교수들이 소속 학과를 가지고 있다. 그럼 춘
기술대학교 총장의 이름을 알아낼 수 있는 SQL 문장을 작성하시오.
PROFESSOR_NAME
--------------------
임해정

SELECT PROFESSOR_NAME
FROM TB_PROFESSOR
WHERE DEPARTMENT_NO IS NULL;
--6번 클리어

7. 혹시 전산상의 착오로 학과가 지정되어 있지 않은 학생이 있는지 확인하고자 핚다.
어떠한 SQL 문장을 사용하면 될 것인지 작성하시오.

SELECT  STUDENT_NAME,DEPARTMENT_NO
FROM TB_STUDENT
WHERE DEPARTMENT_NO IS NULL;
--7번 클리어

SELECT DEPARTMENT_NO,DEPARTMENT_NAME
FROM TB_DEPARTMENT

8. 수강신청을 하려고 핚다. 선수과목 여부를 확인해야 하는데, 선수과목이 존재하는
과목들은 어떤 과목인지 과목번호를 조회해보시오.
CLASS_NO
----------
C0405500
C0409000
C3745400
C0432500
C3051900
C3221500
SELECT CLASS_NO
FROM TB_CLASS
WHERE PREATTENDING_CLASS_NO IS NOT NULL;
--8번 클리어

9. 춘 대학에는 어떤 계열(CATEGORY)들이 있는지 조회해보시오.
CATEGORY
--------------------
공학
예체능
의학
인문사회
자연과학
SELECT DISTINCT CATEGORY
FROM TB_DEPARTMENT;

10. 02 학번 전주 거주자들의 모임을 맊들려고 핚다. 휴학한 사람들은 제외한 재학중인
학생들의 학번, 이름, 주민번호를 출력하는 구문을 작성하시오.
STUDENT_NO STUDENT_NAME STUDENT_SSN
---------- -------------------- --------------
A217005 고수현 821119-2122202
…
…
A211375 최허현 841102-1154425 

SELECT STUDENT_NO, STUDENT_NAME, STUDENT_SSN, STUDENT_ADDRESS,ENTRANCE_DATE
FROM TB_STUDENT
WHERE STUDENT_ADDRESS LIKE '%전주%'
AND ENTRANCE_DATE LIKE '02%'
AND ABSENCE_YN ='N';

---------------------------------------------------------------------------------
--함수
--단일행함수
--그룹함수
--반환 결과에 따라 단일 행 함수 와 그룹함수로 구분

--주요 단일 행 함수 - 문자열함수 LENGTH
--주어진 컬럼 값/문자열 길이(문자개수)를 반환하는 함수
구문 - 반환타입 - 파라미터
LENGTH(STRING) - NUMBER - CHARACTER 타입의 컬럼 또는 임의 문자열
[구문 특징]
=CHAR 데이터타입 컬럼값을 입력받은 경우
실제 데이터 길이(문자개수)에 상관없이 컬럼전체 길이(문자개수)를 반환
=VARCHAR2 데이터 타입 컬럼 값을 입력받은 경우
실제 데이터 길이(문자개수)반환

SELECT LENGTH(CHARTYPE),
	   LENGTH(VARCHARTYPE)
FROM COLUMN_LENGTH;
--주요 단일 행 함수 - 문자열 함수 INSTR
찾는 문자(열)이 지정한 위치부터 지정한 회수만큼 나타난 시작위치를 반환하는 함수
[구문]
INSTR(STRING,SUBSTRING, [POSITION(위치), [OCCURRENCE(반복횟수)]]) 반환NUMBEY TYPE

--EMAIL컬럼 값읠 '@VCC.COM'문자열 중 "." 바로앞의 문자 'C'의 위치를 구하시오

구문 1
SELECT EMAIL,
	   INSTR(EMAIL,'c',-1,2) 위치
FROM EMPLOYEE;

구문2
SELECT EMAIL,
	   INSTR(EMAIL,'c',INSTR(EMAIL,'.')-1)
FROM EMPLOYEE;
--구문 2에서 INSTR(EMAIL, '.') 은 POSITION 을 나타낸다.

--주요 단일 행 함수 - 문자열 함수 LPAD/RPAD
주어진 칼럼/문자열에 임의의 문자(열)을 왼쪽/오른쪽에 덧붙여 길이 N의 문자열을 반환하는 함수
[구문] [반환타임]
LPAD(STRING,N,[STR]) 반환타입 CHARACTER
RPAD(STRING,N,[STR]) 반환타입 CHARACTER

-EMAIL 칼럼 왼쪽에 '.'을 덧붙여 길이를 20으로 맞추시오
SELECT EMAIL AS 원본데이터,
	   LENGTH(EMAIL) AS 원본길이,
	   LPAD(EMAIL, 20, '.') AS 적용결과,
	   LENGTH(LPAD(EMAIL,20,'.')) AS 결과길이
FROM EMPLOYEE;
-EMAIL 칼럼 왼쪽에 '.'을 덧붙여 길이를 20으로 맞추시오
-3번째값 공백 기본값
SELECT EMAIL AS 원본데이터,
	   LENGTH(EMAIL) AS 원본길이,
	   LPAD(EMAIL, 20) AS 적용결과,
	   LENGTH(LPAD(EMAIL,20,'.')) AS 결과길이
FROM EMPLOYEE;
-EMAIL 칼럼 오른쪽에 '.'을 덧붙여 길이를 20으로 맞추시오
SELECT EMAIL AS 원본데이터,
	   LENGTH(EMAIL) AS 원본길이,
	   RPAD(EMAIL, 20, '.') AS 적용결과,
	   LENGTH(RPAD(EMAIL,20,'.')) AS 결과길이
FROM EMPLOYEE;

주요 단일 행 함수 - 문자열 함수 LTRIM/RTRIM
-주어진 컬럼/문자열의 왼쪽/오른쪽에서 지정한 ☆STR에 포함된 모든 문자☆를 제거한 나머지를 반환하는 함수
-패턴을 제거하는 의미가 아님
[구문] - [반환타입]
LTRIM(STRING,STR) - CHARACTER
RTRIM(STRING,STR) - CHARACTER

SELECT LTRIM('   TECH')
FROM DUAL;
SELECT LTRIM('   TECH',' ')
FROM DUAL;
SELECT LTRIM('000123','0')
FROM DUAL;
SELECT LTRIM('123123TECH','123')
FROM DUAL;
SELECT LTRIM('123123TECH123','123')
FROM DUAL;
SELECT LTRIM('xyxzyyyTECH','xyz')
FROM DUAL;
SELECT LTRIM('6372TECH','0123456789')
FROM DUAL;

SELECT RTRIM('TECH   ')
FROM DUAL;
SELECT RTRIM('TECH   ',' ')
FROM DUAL;
SELECT RTRIM('123000','0')
FROM DUAL;
SELECT RTRIM('TECH123123','123')
FROM DUAL;
SELECT RTRIM('123123TECH123','123')
FROM DUAL;
SELECT RTRIM('xyyyTECHxzy','xyz')
FROM DUAL;
SELECT RTRIM('TECH6372','0123456789')
FROM DUAL;

주요 단일 행 함수 문자열 함수 TRIM
주어진 컬럼/문자열의 앞/뒤 양쪽에 있는 지정한 문자를 제거한 나머지를 반환하는 함수
[구문] - [반환타입]
TRIM(TRIM_SOURCE)
TRIM(TRIM_CHAR FROM TRIM_SOURCE)
TRIM(LEADING|TRAILING|BOTH [TRIM_CHAR] FROM TRIM_SOURCE)
-LEADING 왼쪽 -TRAILING 오른쪽 -BOTH 양쪽

SELECT TRIM('   TECH   ') FROM DUAL;
SELECT TRIM('a' FROM 'aatechaaa') FROM DUAL;
SELECT TRIM(LEADING '0' FROM '000123') FROM DUAL;
SELECT TRIM(TRAILING '1' FROM 'TECH1') FROM DUAL;
SELECT TRIM(BOTH '1' FROM '123TECH123') FROM DUAL;
SELECT TRIM(LEADING FROM '   TECH  ') FROM DUAL;

☆상당히 중요한 함수☆
주요 단일 행 함수 문자열 함수 SUBSTR
주어진 컬럼/문자열에서 지정한 위치부터 지정한 개수 만큼의 문자열을 잘라내어 반환하는 함수
[구문]-[반환타입]
SUBSTR(STRING, POSITION, [LENGTH]) - CHARACTER

SELECT SUBSTR('THIS IS A TEST', 6, 2) FROM DUAL;
SELECT SUBSTR('THIS IS A TEST', 6) FROM DUAL;
SELECT SUBSTR('이것은 연습입니다.', 3, 4) FROM DUAL;
SELECT SUBSTR('TECHONTHENET', 1, 4) FROM DUAL;
SELECT SUBSTR('TECHONTHENET', -3, 3) FROM DUAL;
SELECT SUBSTR('TECHONTHENET', -6, 3) FROM DUAL;
SELECT SUBSTR('TECHONTHENET', -8, 2) FROM DUAL;

사용 예
SELECT EMP_NAME AS 이름,
	   SUBSTR(HIRE_DATE,1,2)||'년 '||
	   SUBSTR(HIRE_DATE,4,2)||'월 '||
	   SUBSTR(HIRE_DATE,7,2)||'일' AS 입사일
FROM EMPLOYEE
WHERE JOB_ID='J7';

웹의 아키텍쳐, JVM 용어가 어색하다. 책을 한번 봐야하나
주요 단일 행 함수 - 숫자 함수 ROUND
지정한 자릿수에서 반올림 하는 함수 - 사사오입
[구문] - [반환타입]
ROUND(NUMBER, [DECIMAL_PLACES]) - NUMBER
NUMBER - 숫자 타입 컬럼 또는 임의 숫자
DECIMAL_PLACES - 버림결과가 표시되는 소수점 자리
반드시 정수값 사용


SELECT ROUND(125.315) FROM DUAL;
SELECT ROUND(125.315, 0) FROM DUAL; --소수점 자리가 없다
SELECT ROUND(125.315, 1) FROM DUAL; --소수점 자리가 1개다
SELECT ROUND(125.315, -1) FROM DUAL;--정수자리수 1자리가 반올림하는거다
SELECT ROUND(125.315, 3) FROM DUAL; 
SELECT ROUND(-125.315, 2) FROM DUAL;--소수점 자리가 2개다

주요 단일 행 함수 - 숫자함수 TRUNC 사용예
지정한 자릿수에서 버림 하는 함수

SELECT TRUNC(125.315) FROM DUAL;
SELECT TRUNC(125.315, 0) FROM DUAL;
SELECT TRUNC(125.315, 1) FROM DUAL;
SELECT TRUNC(125.315, -1) FROM DUAL;
SELECT TRUNC(125.315, 3) FROM DUAL; 
SELECT TRUNC(-125.315, -3) FROM DUAL;

주요 단일 행 함수 - 날짜함수 SYSDATE
지정된 형식으로 현재 날짜와 시간을 표시하는 함수
한글버전으로 설치된 경우 기본 설정 형식은 '년도(2자리)/월(2자리)/일(2자리)'
[구문]-[반환타입]
SYSDATE - DATE

SELECT SYSDATE
FROM DUAL;

주요 단일 행 함수 - 날짜함수 ADD_MONTHS
지정한 만큼의 달 수를 더한 날짜를 반환하는 함수
[구문] - [반환타입]
ADD_MONTHS(DATE, N) - DATE타입 반환
DATE 기준이 되는 날짜
N 추가 하고자 하는 개월 수
사용 예
SELECT EMP_NAME,
	   HIRE_DATE,
	   ADD_MONTHS(HIRE_DATE,240)
FROM EMPLOYEE;
주요 단일 행 함수 - 날짜함수 MONTHS_BETWEEN
지정한 두달 사이의 날짜를 조회하는 함수
MONTHS_BETWEEN('날짜','날짜')

'2010년 1월 1일' 기준으로 입사한지 10년이 넘은 직원들의 근무년수 조회
SELECT EMP_NAME
	   HIRE_DATE,
	   MONTHS_BETWEEN('10/01/01',HIRE_DATE)/12 AS 근무년수
FROM EMPLOYEE
WHERE MONTHS_BETWEEN('10/01/01', HIRE_DATE) >120;

'현재일' 기준으로 입사한지 10년이 넘은 직원들의 근무년수 조회
SELECT EMP_NAME
	   HIRE_DATE,
	   TRUNC(MONTHS_BETWEEN(SYSDATE,HIRE_DATE)/12) AS 근무년수
FROM EMPLOYEE
WHERE MONTHS_BETWEEN(SYSDATE, HIRE_DATE) > 120;

1. 영어영문학과(학과코드 002) 학생들의 학번과 이름, 입학 년도를 입학 년도가 빠른
순으로 표시하는 SQL 문장을 작성하시오.( 단, 헤더는 "학번", "이름", "입학년도" 가
표시되도록 핚다.)
학번 이름 입학년도
---------- -------------------------------
9973003 김용귺 1999-03-01
A473015 배용원 2004-03-01
A517105 이싞열 2005-03-01

SELECT STUDENT_NO    AS 학번,
	   STUDENT_NAME  AS 이름, 
	   ENTRANCE_DATE AS 입학년도
FROM   TB_STUDENT
WHERE  DEPARTMENT_NO=002
ORDER BY ENTRANCE_DATE;
1번 완료

2. 춘 기술대학교의 교수 중 이름이 세 글자가 아닌 교수가 핚 명 있다고 핚다. 그 교수의
이름과 주민번호를 화면에 출력하는 SQL 문장을 작성해 보자. (* 이때 올바르게 작성핚 SQL
문장의 결과 값이 예상과 다르게 나올 수 있다. 원인이 무엇일지 생각해볼 것)
PROFESSOR_NAME PROFESSOR_SSN
-------------------- --------------
강혁 601004-1100528
박강아름 681201-2134896

SELECT PROFESSOR_NAME AS 이름,
	   PROFESSOR_SSN  AS 주민번호
FROM   TB_PROFESSOR
WHERE  PROFESSOR_NAME NOT LIKE '___';
2번 완료

3. 춘 기술대학교의 남자 교수들의 이름과 나이를 출력하는 SQL 문장을 작성하시오. 단
이때 나이가 적은 사람에서 맋은 사람 순서로 화면에 출력되도록 맊드시오. (단, 교수 중
2000 년 이후 출생자는 없으며 출력 헤더는 "교수이름", "나이"로 핚다. 나이는 ‘맊’으로
계산핚다.)
교수이름 나이
-------------------- ----------
제상철 28
주영상 28
김명석 30
싞영호 30
박지평 32
…
1안
SELECT PROFESSOR_NAME AS 교수이름,
	   2000+SUBSTR(SYSDATE,1,2) AS 현재날짜,
	   1900+SUBSTR(PROFESSOR_SSN,1,2) AS 출생연도,
	   (2000+SUBSTR(SYSDATE,1,2))-(1900+SUBSTR(PROFESSOR_SSN,1,2)) AS 나이
--	   (SUBSTR(SYSDATE,1,2)+100)-SUBSTR(PROFESSOR_SSN,1,2)
FROM   TB_PROFESSOR
ORDER BY (SUBSTR(SYSDATE,1,2)+100)-SUBSTR(PROFESSOR_SSN,1,2);
2안
SELECT 	PROFESSOR_NAME AS 교수이름,
		TO_CHAR(SYSDATE, 'YYYY')-(1900+SUBSTR(PROFESSOR_SSN,1,2)) AS 나이
FROM	TB_PROFESSOR
ORDER BY TO_CHAR(SYSDATE, 'YYYY')-(1900+SUBSTR(PROFESSOR_SSN,1,2));
3번 완료

4. 교수들의 이름 중 성을 제외한 이름만 출력하는 SQL 문장을 작성하시오. 출력 헤더는
‚이름 이 찍히도록 핚다. (성이 2 자인 경우는 교수는 없다고 가정하시오)
이름
--------------------------------------
진영
윢필
…
…
해원
혁호

SELECT SUBSTR(PROFESSOR_NAME,2) AS 이름
FROM   TB_PROFESSOR;
4번 완료

5. 춘 기술대학교의 재수생 입학자를 구하려고 핚다. 어떻게 찾아낼 것인가? 이때,
19 살에 입학하면 재수를 하지 않은 것으로 갂주핚다.
STUDENT_NO STUDENT_NAME
---------- --------------------
A513035 박경애
A513065 이경택
…
…
A241053 이희수
A241056 이희진

SELECT STUDENT_NO AS 학번
,      STUDENT_NAME AS 이름
FROM   TB_STUDENT
WHERE  TO_CHAR(ENTRANCE_DATE,'YYYY')-(SUBSTR(STUDENT_SSN,1,2)+1900)>19

5번 완료

6. 2020 년 크리스마스는 무슨 요일인가?
SELECT TO_CHAR(TO_DATE('20201225','YYYYMMDD'),'DAY')
FROM   DUAL
6번 완료

7. 
TO_DATE('99/10/11','YY/MM/DD'), 
TO_DATE('49/10/11','YY/MM/DD') 
은 각각 몇 년 몇 월 몇 일을 의미핛까? 또 
TO_DATE('99/10/11','RR/MM/DD'),
TO_DATE('49/10/11','RR/MM/DD') 
은 각각 몇 년 몇 월 몇 일을 의미핛까?
SELECT TO_DATE('99/10/11','YY/MM/DD'),
       TO_DATE('99/10/11','RR/MM/DD'),
       TO_DATE('49/10/11','YY/MM/DD'),
       TO_DATE('49/10/11','RR/MM/DD') 
FROM DUAL;


SELECT TO_DATE('49/10/11','RR/MM/DD')
FROM DUAL;

왜?????? 왜?? 다르게 나와?

8. 춘 기술대학교의 2000 년도 이후 입학자들은 학번이 A 로 시작하게 되어있다. 
2000 년도 이전 학번을 받은 학생들의 학번과 이름을 보여주는 SQL 문장을 작성하시오.
STUDENT_NO STUDENT_NAME
---------- --------------------
9919024 김계영
9831163 이권민
…
…
9811251 김충원
9911206 임충헌

SELECT STUDENT_NO   AS 학번,
	   STUDENT_NAME AS 이름
FROM   TB_STUDENT
WHERE  STUDENT_NO NOT LIKE 'A______'

8번완료

9. 학번이 A517178 인 한아름 학생의 학점 총 평점을 구하는 SQL 문을 작성하시오. 단,
이때 출력 화면의 헤더는 "평점" 이라고 찍히게 하고, 점수는 반올림하여 소수점 이하 핚
자리까지맊 표시핚다.
평점
----------
 3.6
 
SELECT  ROUND(AVG(POINT),1) AS 평점
FROM    TB_GRADE
WHERE   STUDENT_NO = 'A517178';
9풀었다.

10. 학과별 학생수를 구하여 "학과번호", "학생수(명)" 의 형태로 헤더를 맊들어 결과값이
출력되도록 하시오.
학과번호 학생수(명)
---------- ----------
001 14
002 3
…
…
061 7
062 8

SELECT DISTINCT DEPARTMENT_NO AS 학과번호
,	   COUNT(STUDENT_NO) AS "학생수(명)"
FROM TB_STUDENT
WHERE DEPARTMENT_NO IS NOT NULL
ORDER BY DEPARTMENT_NO;
10번 완료

11. 지도 교수를 배정받지 못핚 학생의 수는 몇 명 정도 되는 알아내는 SQL 문을
작성하시오.
COUNT(*)
----------

SELECT COUNT(STUDENT_NO)
FROM TB_STUDENT
WHERE COACH_PROFESSOR_NO IS NULL
11번 번완료

 9
12. 학번이 A112113 인 김고운 학생의 년도 별 평점을 구하는 SQL 문을 작성하시오. 단,
이때 출력 화면의 헤더는 "년도", "년도 별 평점" 이라고 찍히게 하고, 점수는 반올림하여
소수점 이하 핚 자리까지맊 표시핚다.
년도 년도 별 평점
-------- ------------
2001 2.8
2002 2.3
2003 4
2004 3.5

SELECT 	SUBSTR(TERM_NO,1,4) AS 년도
,  	    CASE WHEN SUBSTR(TERM_NO,1,4)='2001' THEN ROUND(AVG(POINT),1)
			 WHEN SUBSTR(TERM_NO,1,4)='2002' THEN ROUND(AVG(POINT),1)
			 WHEN SUBSTR(TERM_NO,1,4)='2003' THEN ROUND(AVG(POINT),1)
			 WHEN SUBSTR(TERM_NO,1,4)='2004' THEN ROUND(AVG(POINT),1) END AS "년도 별 평점"
FROM TB_GRADE
WHERE STUDENT_NO = 'A112113'
GROUP BY SUBSTR(TERM_NO,1,4)
ORDER BY SUBSTR(TERM_NO,1,4);
12번 완료

13. 학과 별 휴학생 수를 파악하고자 핚다. 학과 번호와 휴학생 수를 표시하는 SQL 문장을
작성하시오.
학과코드명 휴학생 수
------------- ------------------------------
001 2
002 0
003 1
061 2
062 2

SELECT  DEPARTMENT_NO AS 학과코드명
,		SUM(DECODE(ABSENCE_YN,'Y','1','N','0')) AS 휴학생수
FROM TB_STUDENT
GROUP BY DEPARTMENT_NO
ORDER BY DEPARTMENT_NO;
13번 완료



14. 춘 대학교에 다니는 동명이인(同名異人) 학생들의 이름을 찾고자 핚다. 어떤 SQL
문장을 사용하면 가능하겠는가?
동일이름 동명인 수
-------------------- ----------
김경민 2
김명철 2
…
…
조기현 2
최효정 2

SELECT   STUDENT_NAME        AS 동일이름
,		 COUNT(STUDENT_NAME) AS 동명인수
FROM	 TB_STUDENT
--WHERE 절에는 그룹함수를 쓸수없다.
--WHERE 	COUNT(STUDENT_NAME)>=2
GROUP BY STUDENT_NAME
HAVING   COUNT(STUDENT_NAME) >=2
ORDER BY STUDENT_NAME;
14번 완료

15. 학번이 A112113 인 김고운 학생의 년도, 학기 별 평점과 년도 별 누적 평점 , 총
평점을 구하는 SQL 문을 작성하시오. (단, 평점은 소수점 1 자리까지맊 반올림하여
표시핚다.)
년도 학기 평점
-------- ---- ------------
2001 01 2.5
2001 02 3
2001 2.8
2002 01 2
2002 02 2.5
2002 2.3
2003 01 3.5
2003 02 4.5
2003 03 4
2003 4
2004 01 4
2004 02 3
2004 3.5

년도와 학기가 그룹으로 묶여야한다.
년도별 소계를 찍어주고 싶다.

SELECT   SUBSTR(TERM_NO,1,4) AS 년도
,		 SUBSTR(TERM_NO,5,2) AS 학기
,		 ROUND(AVG(POINT),1) AS 평점
FROM	 TB_GRADE
WHERE	 STUDENT_NO='A112113'
GROUP BY ROLLUP(SUBSTR(TERM_NO,1,4),SUBSTR(TERM_NO,5,2))
ORDER BY SUBSTR(TERM_NO,1,4)



☆주요 단일 행 함수 - 데이터타입 변환
데이터타입에 따라 사용할 수 있는 변환 함수가 다름
상호 타입변환이 되지 않는 데이터 타입 존재
TO_NUMBER<        >TO_DATE 
NUMBER - CHARACTER - DATE
         >TO_CHAR<

묵시적 형 변환

제공되는 숫자 표현형식
형식         설명
9      | 자리수지정
0      |남는자리를 0으로 표시
$ OR L | 통화기호 표시
. OR , | 지정한 위치에 . 또는 , 표시
EEEE   | 과학 지수 표기법

SELECT TO_CHAR(1234, '99999') FROM DUAL;
SELECT TO_CHAR(1234, '09999') FROM DUAL;
SELECT TO_CHAR(1234, 'L99999') FROM DUAL;
SELECT TO_CHAR(1234, '99,999') FROM DUAL;
SELECT TO_CHAR(1234, '0,9999') FROM DUAL;
SELECT TO_CHAR(1000, '9.9EEEE') FROM DUAL;
SELECT TO_CHAR(1234, '999') FROM DUAL;

☆주요 단일 행 함수 - 데이터 타입 변환 함수 TO_CHAR 사용 예
형식                설명
YYYY/YY/YEAR    | 년도(4자리 숫자/뒤 2자리 숫자/문자)
MONTH/MON/MM/RM | 달(이름/약어/숫자/로마 기호)
DDD/DD/D        | 일(1년 기준/1달 기준/1주 기준)
Q               | 분기(1,2,3,4)
DAY/DY          | 요일(이름 약어 이름)
HH(12)/HH24     | 12시간/24시간 표시
AP|PM           | 오전, 오후
MI              | 분(0~59)
SS              | 초(0~59)

SELECT TO_CHAR(SYSDATE, 'PM HH24: MI:SS') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'AM HH: MI:SS') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'MON DY,YYYY') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY-fmMM-DD DAY') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-fmDD DAY') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YEAR,Q') FROM DUAL;

SELECT EMP_NAME AS 이름,
	   TO_CHAR(HIRE_DATE, 'YYYY-MM-DD') AS 입사일
FROM EMPLOYEE
WHERE JOB_ID = 'J7';

SELECT  EMP_NAME AS 이름,
		TO_CHAR(HIRE_DATE, 'YYYY"년" MM"월" DD"일"') AS 입사일
FROM    EMPLOYEE
WHERE   JOB_ID = 'J7'

☆주요 단일 행 함수 - 데이터 타입 변환 함수 TO_DATE
CHARACTER 타입을 DATE 타입으로 변환하는 함수

SELECT TO_DATE('20100101','YYYYMMDD') FROM DUAL;
SELECT TO_CHAR('20100101','YYYY, MON') FROM DUAL;
--문자를 문자로 못 만들기 때문에 오류가 생긴다.
SELECT TO_CHAR(TO_DATE('20100101','YYYYMMDD'), 'YYYY,MON') FROM DUAL;
SELECT TO_DATE('041030 143000', 'YYMMDD HH24MISS') FROM DUAL;
SELECT TO_CHAR(TO_DATE('041030 143000', 'YYMMDD HH24MISS'),'DD-MON-YY HH:MI:SS PM') FROM DUAL
SELECT TO_DATE('980630', 'YYMMDD') FROM DUAL;
SELECT TO_CHAR(TO_DATE('980630','RRMMDD'),'YYYY.MM.DD') FROM DUAL;

☆주요 단일 행 함수 - 데이터 타입 변환 함수 TO_NUMBER
CHARACTER 타입을 NUMBER 타입으로 변환하는 함수
문자열 정수만 바꿔줄 수 있다.

SELECT  EMP_NAME, 
		EMP_NO,
		SUBSTR(EMP_NO,1,6) AS 앞부분,
		SUBSTR(EMP_NO,8) AS 뒷부분,
		SUBSTR(EMP_NO,1,6)+SUBSTR(EMP_NO,8) AS 결과,
		--동일하게 인식한다. 자동으로 파싱
		TO_NUMBER(SUBSTR(EMP_NO,1,6))+TO_NUMBER(SUBSTR(EMP_NO,8)) AS 결과2
FROM EMPLOYEE
WHERE EMP_ID = '101';

☆주요 단일 행 함수 - 기타 함수 NVL
NULL을 지정한 값으로 변환하는 함수
ANY NVL(EXPR1, EXPR2) ANY(반환타입이 3개 전부)

SELECT EMP_NAME, SALARY, NVL(BONUS_PCT,0)
FROM EMPLOYEE
WHERE SALARY > 3500000;

SELECT EMP_NAME, (SALARY*12)+((SALARY*12)*BONUS_PCT)
FROM EMPLOYEE
WHERE SALARY > 3500000;
NULL값 오류가 난다. 

SELECT EMP_NAME, (SALARY*12)+((SALARY*12)*NVL(BONUS_PCT,0))
FROM EMPLOYEE
WHERE SALARY > 3500000;
NULL값 오류를 없애겠다.

☆주요 단일 행 함수 - 기타 함수 DECODE
SELECT 구문으로 IF-ELSE 논리를 제한적으로 구현한 오라클 DBMS 전용함수
조건을 걸어버릴 수는 없다.
RESULT에는 연산을 행할 수 있다.
ANY(입력타입) 구문 DECODE(EXPR, SEARCH1, RESULT1 [,searchN, resultN, ...][,default])

SELECT  EMP_NAME,
		DECODE(SUBSTR(EMP_NO,8,1),'1','남','2','여','3','남','4','여') AS 성별
FROM EMPLOYEE
WHERE DEPT_ID = '50';

SELECT  EMP_NAME,
		DECODE(SUBSTR(EMP_NO,8,1),'1','남','3','남','여') AS 성별
FROM EMPLOYEE
WHERE DEPT_ID = '50';
--1번,3번 조건을 제외한 것들은 DEFAULT로 여로 표시

SELECT  EMP_ID, EMP_NAME,
		DECODE(MGR_ID, NULL, '없음', MGR_ID) AS 관리자
FROM EMPLOYEE
WHERE JOB_ID = 'J4';
--아래와 동일
SELECT  EMP_ID, EMP_NAME,
		NVL(MGR_ID,'없음') AS 관리자
FROM EMPLOYEE
WHERE JOB_ID = 'J4';

SELECT  EMP_NAME
,		JOB_ID AS 직급
,		SALARY AS 기존급여
,		DECODE(JOB_ID,'J7',SALARY*1.1,'J6',SALARY*1.15,'J5',SALARY*1.2,SALARY*1.05) AS 인상급여
FROM EMPLOYEE

SELECT  EMP_NAME
,		JOB_ID AS 직급
,		SALARY AS 기존급여
,		CASE JOB_ID WHEN 'J7' THEN TO_CHAR(SALARY*1.1) 
					WHEN 'J6' THEN TO_CHAR(SALARY*1.15) 
					WHEN 'J5' THEN TO_CHAR(SALARY*1.2) 
					ELSE TO_CHAR(SALARY*1.05) 			END AS 인상급여
FROM EMPLOYEE;


주요 단일 행 함수 - [참조] CASE
DECODE 함수와 유사한 ANSI 표준구문 아주중요
입력타입[ANY] EX1) CASE expr WHEN search1 THEN result1 [WHEN..THEN..][ELSE default] END 반환타입[END]
EX2) CASE WHEN condition1 THEN result! [WHEN..THEN..][ELSE default] END
CONDITION 에 조건식을 줄수있다.

SELECT  EMP_ID
,		EMP_NAME
,		SALARY
,		CASE WHEN SALARY<=3000000 THEN '초급'
			 WHEN SALARY<=4000000 THEN '중급'
			 ELSE '고급' END AS 구분
FROM EMPLOYEE;
------------------------------------------------------
주요 그룹 함수
그룹 함수는 NULL을 계산하지 않음
함수
SUM - 총합계산
AVG - 평균계산, NULL값을 제외하므로 결과가 달라질 수 있음
MIN - 최소값 반환, DATE 타입:가장 오래전 날짜를 의미, CHARACTER 타입: 해당 CHARACTER SET 의 내부값이 가장 작은 문자를 의미
MAX - 최대값 반환, DATE 타입:가장 최근 날짜를 의미, CHARACTER 타입 : 해당 CHARACTER SET 의 내부값이 가장 큰 문자를 의미
COUNT - RESULT SET 전체 행 수 반환
------------------------------------------------------
AVG([DISTINCT] EXPR) 입력,반환 타입 모두 NUMBER

SELECT  AVG(BONUS_PCT) AS 기본평균,
		--NULL값을 제외한 값들의 평균을 구한다.
		AVG(DISTINCT BONUS_PCT) AS 중복제거평균,
		AVG(NVL(BONUS_PCT,0)) AS NULL포함평균
		--NULL값을 평균치에 포함해야 하기때문에 NULL을 0으로 변환하는 과정이 필요
FROM EMPLOYEE
WHERE DEPT_ID IN('50','90')
OR DEPT_ID IS NULL;

SELECT COUNT(*)
,		COUNT(JOB_ID)
,		COUNT(DISTINCT JOB_ID)
FROM	EMPLOYEE
WHERE DEPT_ID='50'
OR DEPT_ID IS NULL;

☆ ORDER BY
SELECT 구문 실행 결과를 특정 컬럼 값 기준으로 정렬할 때 사용
SELECT 구문의 맨 마지막에 위치
ORDER BY 기준 1[ASC|DESC], 기준2[ASC|DESC]...

SELECT EMP_NAME, HIRE_DATE, DEPT_ID
FROM EMPLOYEE
WHERE HIRE_DATE > TO_DATE('20030101','YYYYMMDD')
ORDER BY DEPT_ID DESC, HIRE_DATE,EMP_NAME;

SELECT  EMP_NAME AS 이름
,		HIRE_DATE AS 입사일
,		DEPT_ID AS 부서코드
FROM EMPLOYEE
WHERE HIRE_DATE > TO_DATE('20030101','YYYYMMDD')
ORDER BY 부서코드 DESC, 입사일, 이름;

SELECT  EMP_NAME AS 이름
,		HIRE_DATE AS 입사일
,		DEPT_ID AS 부서코드
FROM EMPLOYEE
WHERE HIRE_DATE > TO_DATE('20030101','YYYYMMDD')
ORDER BY 3 DESC, 2, 1;

☆GROUP BY
GROUP BY 는 대부분 그룹합수랑 연계가 되게 되어있다.
GROUP BY COLUMN_NAME|expr

SELECT DEPT_ID AS 부서,
		ROUND(AVG(SALARY),-4) AS 평균급여
FROM EMPLOYEE
GROUP BY DEPT_ID
ORDER BY 1;

그룹바이 사용예
SELECT MAX(SUM(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_ID;

그룹바이 오류
SELECT DEPT_ID,
		MAX(SUM(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_ID;
--MAX가 있어버리면 싱글로우,

☆HAVING
GROUP BY 에 의해 그룹화된 데이터에 대한 그룹 함수 실행 결과를 제한하기 위해 사용(WHERE는 테이블에 포함된 원본 데이터를 제한하기 위해 사용)
WHERE 절에는 그룹함수를 쓸수없다.

☆ROLLUP
GROUPBY와 함께 사용되어 각 그룹 별 그룹 함수 적용 결과 이외에 하위 총계와 같은 누적 집계를 산출할 수 있음

SELECT  DEPT_ID
,		SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_ID IS NOT NULL
GROUP BY ROLLUP(DEPT_ID);

SELECT   DEPT_ID
,		 JOB_ID
,		 SUM(SALARY)
FROM EMPLOYEE
WHERE    DEPT_ID IS NOT NULL
AND		 JOB_ID IS NOT NULL
GROUP BY ROLLUP(DEPT_ID, JOB_ID)
ORDER BY DEPT_ID, JOB_ID;

-- Join - 오라클 전용 구문
-- FROM 절에 조회 대상 테이블을 쉼표로 구분하여 기술
-- WHERE 절에 테이블 사이의 관계를 표시하는 조건 기술
-- 동일한 이름의 칼럼이 존재하는 경우 -> SELECT 절/WHERE 절에 컬럼 이름을 기술할 때 어떤 테이블에 포함된 컬럼인지 구분해서 표시
-- 테이블 이름도 별칭을 사용할 수 있다.
-- 둘 이상의 테이블을 연결하여 데이터를 검색하는 방법 이다.
-- 보통 둘 이상의 행들의 공통된 값 Primary Key 및 Foreign Key 값을 사용하여 조인 한다.
-- 두 개의 테이블을 SELECT문장 안에서 조인 하려면 적어도 하나의 컬럼이 그 두 테이블 사이에서 공유 되어야 한다.

SELECT EMP_NAME, DEPT_NAME
FROM   EMPLOYEE E,
   	   DEPARTMENT D
WHERE  E.DEPT_ID = D.DEPT_ID;

-- Join USING
-- USING 구문에서는 별칭 사용 불가
SELECT EMP_NAME, DEPT_NAME
FROM   EMPLOYEE
JOIN   DEPARTMENT USING(DEPT_ID);

-- JOIN ON 에서는 별칭 사용 가능  ---> 활용도 부분에서 ON 이 USING 보다 많이 쓰인다.
SELECT EMP_NAME, DEPT_NAME, LOC_DESCRIBE
FROM   EMPLOYEE   E                                             -- merge된 2개의 테이블 
JOIN   DEPARTMENT D ON(E.DEPT_ID = D.DEPT_ID) -- USING(DEPT_ID)
JOIN   LOCATION   L ON(L.LOCATION_ID = D.LOC_ID)--이름이 달라~;

-- JOIN - OUTER JOIN
-- 조건을 만족시키지 못하는 행까지 Result Set 에 포함하는 구문
-- LEFT, RIGHT 키워드 사용
-- LEFT : 기준 테이블이 JOIN 키워드보다 먼저 기술된 경우
-- RIGHT : 기준 테이블이 JOIN 키워드보다 나중에 기술된 경우
SELECT EMP_NAME, DEPT_NAME
FROM   EMPLOYEE
LEFT   JOIN DEPARTMENT USING(DEPT_ID)
ORDER BY 1;

SELECT EMP_NAME, DEPT_NAME
FROM   DEPARTMENT
RIGHT  JOIN EMPLOYEE USING(DEPT_ID)
ORDER BY 1;

-- FULL : LEFT 와 RIGHT 두개에 해당하지 않는 데이터도 포함하여 표시
SELECT EMP_NAME, DEPT_NAME
FROM   EMPLOYEE
FULL   JOIN DEPARTMENT USING(DEPT_ID)
ORDER BY 1;

-- JOIN - CROSS JOIN(몰라도 된다)
-- 대상 테이블의 모든 행에 대하여 가능한 모든 조합을 생성하는 ANSI 표준 구
-- 오라클 구문에선느 조인 조건이 누락된 경우를 의미

SELECT	*
FROM	SAL_GRADE;

SELECT EMP_NAME, SALARY, SLEVEL
FROM   EMPLOYEE
JOIN   SAL_GRADE ON(SALARY BETWEEN LOWEST AND HIGHEST)
ORDER BY 3;

-- JOIN - SELF JOIN
-- 한 테이블을 두 번 조인하는 경우( 테이블 별칭을 사용해야 한다 )
SELECT E.EMP_NAME AS 직원,
      M.EMP_NAME AS 관리자
FROM   EMPLOYEE E
LEFT   JOIN   EMPLOYEE M ON (E.MGR_ID = M.EMP_ID)
ORDER BY 1;

-- JOIN - N개 테이블 JOIN
-- N개의 테이블을 조인하려면 최소 N-1개
SELECT EMP_NAME, JOB_TITLE, DEPT_NAME
FROM   EMPLOYEE 
JOIN   JOB USING(JOB_ID)
JOIN   DEPARTMENT  USING(DEPT_ID);     
-- EMPLOYEE 와 JOB 이 먼저 조인되어 새로운 테이블처럼 취급
-- 그 결과가 DEPARTMENT 가 조인되는 개념

-- 칼럼 조회 목적이 아닌 WHERE 조건을 위해 조인에 포함되어야 하는 테이블이 필여
-- JOB 테이블은 직급 조건을 위해, LOCATION 테이블은 지역 조건을 위해 조인되었음
SELECT EMP_NAME, JOB_TITLE, DEPT_NAME
FROM   EMPLOYEE 
JOIN   JOB USING(JOB_ID)
JOIN   DEPARTMENT  USING(DEPT_ID)
JOIN   LOCATION ON(LOC_ID=LOCATION_ID)
WHERE  JOB_TITLE='대리'
AND    LOC_DESCRIBE LIKE '아시아%';

SELECT * FROM EMPLOYEE
SELECT * FROM DEPARTMENT

-- SET Operator 개념
-- 두 개 이상의 쿼리 결과를 하나로 결합시키는 연산자
-- SELECT 절에 기술하는 컬럼 개수와 데이터 타입은 모든 쿼리에서 동일해야 함
-- UNION     : 양쪽 쿼리 결과를 모두 포함(중복 결과는 1번만 표현)
-- UNION ALL : 양쪽 쿼리 결과를 모두 포함(중복 결과도 모두 표현)
-- INTERSECT  : 양쪽 쿼리 결과에 모두 포함되는 행만 표현
-- MINUS      : 쿼리1 결과에만 포함되고 쿼리2 결과에는 포함되지 않는 행만 표현

-- 쿼리1과 쿼리2의 SELECT 목록은 반드시 동일(컬럼 개수, 데이터 타입)해야 하므로 이를 위해 DUMMY COLUMN을 사용할 수 있다.
SELECT EMP_NAME, JOB_ID, HIRE_DATE
FROM   EMPLOYEE
WHERE  DEPT_ID='20'
UNION
SELECT DEPT_NAME, DEPT_ID, NULL -- DUMMY COLUMN
FROM   DEPARTMENT
WHERE  DEPT_ID='20';

SELECT EMP_NAME, SALARY--숫자
FROM   EMPLOYEE
WHERE  DEPT_ID='20'
UNION
SELECT DEPT_NAME, DEPT_ID--CHAR
FROM   DEPARTMENT
WHERE  DEPT_ID='20';

서브쿼리 개념
-하나의 쿼리가 다른 쿼리에 포함되는 구조
-다른 쿼리에 포함된 내부 쿼리(서브 쿼리)는 외부쿼리에 사용될 값을 반환하는 역할

구문특징
서브쿼리는 일반적인 sql구문과 동일(별도 형식 존재 x)
select where having 등이

서브쿼리 - 유형
-단일행 서브쿼리
단일 행 반환
단일 행 비교 연산자(=,>,<,<=,>=,<> 등)
-다중행 서브쿼리
여러 행 반환
다중 행 비교연산자(in,any,all 등) 사용

단일행 서브쿼리
SELECT EMP_NAME,
	   JOB_ID,
	   SALARY
FROM EMPLOYEE
WHERE JOB_ID = (SELECT JOB_ID
   				FROM EMPLOYEE
   				WHERE EMP_NAME = '나승원')
   				--리턴되는 결과값이 1건이다.
AND   SALARY > (SELECT SALARY
   				FROM EMPLOYEE
   				WHERE EMP_NAME = '나승원')
   				--리턴되는 결과값이 1건이다.

SELECT 	EMP_NAME,
		JOB_ID,
		SALARY,
		DEPT_ID
FROM	EMPLOYEE
JOIN    JOB USING (JOB_ID)
JOIN	DEPARTMENT USING(DEPT_ID)
WHERE 	SALARY = (	SELECT MIN(SALARY)
					FROM EMPLOYEE);

-- 부서별 급여총합이 최고인 부서의 부서이름과 급여총합을 검색하라.
SELECT 	DEPT_NAME, SUM(SALARY)
FROM	EMPLOYEE
LEFT JOIN DEPARTMENT USING (DEPT_ID)
GROUP BY DEPT_ID, DEPT_NAME
HAVING SUM(SALARY) = (	SELECT MAX(SUM(SALARY))
						FROM EMPLOYEE
						GROUP BY DEPT_ID);

서브쿼리 - 다중 행 서브쿼리 ANY연산자
<ANY : 비교 대상 중 최대 값 보다 작음
>ANY : 비교 대상 중 최소 값 보다 큼
=ANY : IN 연산자와 동일

<ALL : 비교 대상 중 최대 값 보다 크다
>ALL : 비교 대상 중 최소 값 보다 작다
=ANY : IN 연산자와 동일
						
SELECT  EMP_NAME, SALARY
FROM 	EMPLOYEE
JOIN 	JOB USING (JOB_ID)
WHERE 	JOB_TITLE = '대리'
AND 	SALARY > ANY (	SELECT	SALARY
						FROM 	EMPLOYEE
						JOIN 	JOB USING (JOB_ID)
						WHERE 	JOB_TITLE='과장');

서브쿼리 - 다중 행/다중 열 서브쿼리
자기 직급의 평균 급여를 받는 직원을 조회하시오
SELECT 	EMP_NAME,
		JOB_TITLE,
		SALARY
FROM EMPLOYEE
LEFT JOIN JOB USING (JOB_ID)
WHERE	(NVL(JOB_ID,' '), SALARY) IN
		(	SELECT 	NVL(JOB_ID,' '),
					TRUNC(AVG(SALARY),-5)
			FROM 	EMPLOYEE
			GROUP BY JOB_ID)
ORDER BY JOB_ID;

SELECT SALARY
FROM EMPLOYEE
WHERE EMP_NAME = '심하균'

서브쿼리 FROM 절 사용
SELECT 	EMP_NAME,
		JOB_TITLE,
		SALARY
FROM (	SELECT 	JOB_ID,
				TRUNC(AVG(SALARY),-5) AS JOBAVG
		FROM EMPLOYEE
		GROUP BY JOB_ID) V --V는 테이블의 별칭이다.
JOIN EMPLOYEE E ON (JOBAVG = SALARY AND
					NVL(E.JOB_ID, ' ') = NVL(V.JOB_ID,' '))
LEFT JOIN JOB J ON(E.JOB_ID = J.JOB_ID)
ORDER BY JOB_ID;

서브쿼리 - CORELATED SUBQUERY(상관관계 서브쿼리) 현업에서 많이 쓴다.
메인 쿼리에서 고려된 각 후보행들에 대해 서브쿼리가 다른 결과를 반환해야 하는 경우
(메인쿼리에서 처리되는 각 행의 값에 따라 응답이 달라져야 하는 경우)에 유용

--위에것과 동일한 결과 지만 작동 방식이 다르다.
SELECT 	EMP_NAME,
		JOB_TITLE,
		SALARY
FROM EMPLOYEE E
LEFT JOIN JOB J ON (E.JOB_ID = J.JOB_ID)
WHERE SALARY=(	SELECT 	TRUNC(AVG(SALARY), -5)
				FROM 	EMPLOYEE
				WHERE 	NVL(JOB_ID, ' ') = 
						NVL(E.JOB_ID,' '))
ORDER BY E.JOB_ID;

서브쿼리 - EXISTS, NOT EXISTS 연산자
결과에 포함되는지의 여부를 확인해야 하는 경우에 유용한 연산자
존재여부에 따라 TRUE를 반환

SELECT EMP_ID, EMP_NAME, '관리자' AS 구분
FROM EMPLOYEE E
WHERE EXISTS (	SELECT 	NULL
				FROM 	EMPLOYEE
				WHERE 	E.EMP_ID=MGR_ID)
UNION
SELECT EMP_ID, EMP_NAME, '직원'
FROM EMPLOYEE E2
WHERE NOT EXISTS (	SELECT 	NULL
					FROM 	EMPLOYEE
					WHERE	E2.EMP_ID=MGR_ID)
ORDER BY 3, 1;


Additional SELECT - Option


1. 학생이름과 주소지를 표시하시오. 단, 출력 헤더는 "학생 이름", "주소지"로 하고,
정렬은 이름으로 오름차순 표시하도록 핚다.
학생 이름 주소지
-------------------- ----------------------------------------------------------
감현제 서울강서등촌동691-3부영@102-505
강동연 경기도 의정부시 민락동 694 산들마을 대림아파트 404-1404
…
황형철 전남 숚천시 생목동 현대ⓐ 106/407 T.061-772-2101
황효종 인천시서구 석남동 564-4번지
588 rows selected


SELECT 	STUDENT_NAME	AS "학생 이름"
,		STUDENT_ADDRESS AS "주소지"
FROM	TB_STUDENT
--WHERE	
ORDER BY "학생 이름"
1번완료
2. 휴학중인 학생들의 이름과 주민번호를 나이가 적은 순서로 화면에 출력하시오.
STUDENT_NAME STUDENT_SSN
-------------------- --------------
릴희권 871222-1124648
황효종 871125-1129980
전효선 871030-2176192
김진호 871013-1140536
…
…
91 rows selected
14

SELECT 	STUDENT_NAME, STUDENT_SSN
FROM	TB_STUDENT
WHERE	ABSENCE_YN LIKE 'Y'
ORDER BY STUDENT_SSN DESC
2번완료

3. 주소지가 강원도나 경기도인 학생들 중 1900 년대 학번을 가진 학생들의 이름과 학번,
주소를 이름의 오름차순으로 화면에 출력하시오. 단, 출력헤더에는 "학생이름","학번",
"거주지 주소" 가 출력되도록 핚다.
학생이름 학번 거주지 주소
-------------------- ---------- -------------------------------------------------------------
김계영 9919024 경기도 용인시 수지구 풍덕천2동 싞정마을 임광 305-1703호
박규상 9931111 경기도 성남시 분당구 탑마을 526 경남아파트 710-1302
송귺우 9931165 경기도 부천시 원미구 중2동 386-1186 복사골아파트 1701-405
송정삼 9995148 경기도 남양주시 도농동 부영그린타운 306-2304
이기범 9931248 경기도 굮포시 산본동 핚양목련아파트1224-2002
이춘평 9811176 경기도 고양시 일산구 일산동1107후곡마을1209-705
전기성 9931277 경기도 용인시 수지구 풍덕천동 239-3 중앙빌딩 3층
정기웅 9931285 경기도 성남시 분당구 야탑동 기산아파트 307-801호
조기환 9931312 경기도 시흥시 매화동 194-1 동진아파트 1-305
9 rows selected

SELECT 	STUDENT_NAME	AS "학생이름"
,		STUDENT_NO		AS "학번"
,		STUDENT_ADDRESS	AS "거주지 주소"
FROM TB_STUDENT
WHERE	(STUDENT_ADDRESS LIKE '강원%'
OR 		STUDENT_ADDRESS LIKE '경기%')
AND		STUDENT_NO		LIKE '9______'
ORDER BY "학생이름" ASC;
3번완료

4. 현재 법학과 교수 중 가장 나이가 맋은 사람부터 이름을 확인핛 수 있는 SQL 문장을
작성하시오. (법학과의 '학과코드'는 학과 테이블(TB_DEPARTMENT)을 조회해서 찾아
내도록 하자)
PROFESSOR_NAME PROFESSOR_SSN
-------------------- --------------
홍남수 540304-1112251
김선희 551030-2159000
임진숙 640125-1143548
이미경 741016-2103506
15

SELECT * FROM TB_DEPARTMENT

SELECT		PROFESSOR_NAME AS 이름, PROFESSOR_SSN AS 주민번호
FROM		TB_PROFESSOR P
JOIN		TB_DEPARTMENT D ON(P.DEPARTMENT_NO = D.DEPARTMENT_NO)
WHERE		P.DEPARTMENT_NO	LIKE '005'
ORDER BY 	이름 DESC

5. 2004 년 2 학기에 'C3118100' 과목을 수강핚 학생들의 학점을 조회하려고 핚다. 
학점이 높은 학생부터 표시하고, 학점이 같으면 학번이 낮은 학생부터 표시하는 구문을
작성해보시오.
STUDENT_NO POINT
---------- -----
A352017 4.00
A115270 3.50
A215247 3.00
A417074 3.00
A131046 2.50
A219089 2.50
A331076 2.00
7 rows selected

SELECT		STUDENT_NO, TO_CHAR(POINT,'9.99')
FROM		TB_GRADE G
--JOIN		
WHERE		G.TERM_NO = 200402
AND			G.CLASS_NO LIKE 'C3118100'
--GROUP BY	
ORDER BY	POINT DESC, STUDENT_NO ASC


6. 학생 번호, 학생 이름, 학과 이름을 학생 이름으로 오름차순 정렬하여 출력하는 SQL
문을 작성하시오.
STUDENT_NO STUDENT_NAME DEPARTMENT_NAME
---------- -------------------- --------------------
A213046 서가람 중어중문학과
A445008 남가영 경제학과
…
…
A241056 이희진 서반아어학과
A241004 김희훈 생태시스템공학과
588 rows selected

SELECT		STUDENT_NO 		AS "학생 번호"
,			STUDENT_NAME 	AS "학생 이름"
,			DEPARTMENT_NAME	AS "학과 이름"
FROM		TB_STUDENT S
JOIN		TB_DEPARTMENT D ON(S.DEPARTMENT_NO = D.DEPARTMENT_NO)
ORDER BY	"학생 이름" DESC
6번완료

7. 춘 기술대학교의 과목 이름과 과목의 학과 이름을 출력하는 SQL 문장을 작성하시오.
CLASS_NAME DEPARTMENT_NAME
------------------------------ --------------------
고전시가롞특강 국어국문학과
국어어휘롞특강 국어국문학과
국어음성학연구 국어국문학과
…
…
논문지도1 체육학과
논문지도2 체육학과
882 rows selected

SELECT		CLASS_NAME 		AS 과목명
,			D.DEPARTMENT_NAME AS 학과명
FROM		TB_CLASS C
JOIN		TB_DEPARTMENT D ON(C.DEPARTMENT_NO = D.DEPARTMENT_NO)
7번 완료

8. 과목별 교수 이름을 찾으려고 핚다. 과목 이름과 교수 이름을 출력하는 SQL 문을
작성하시오.
CLASS_NAME PROFESSOR_NAME
------------------------------ --------------------
고전시가롞특강 김선정
국어어휘롞특강 김선정
국어음성학연구 김선정
…
…
논문지도1 백은정
776 rows selected
17

SELECT		CLASS_NAME 		AS 과목명
,			P.PROFESSOR_NAME 	AS 교수이름
FROM		TB_CLASS C
JOIN		TB_CLASS_PROFESSOR O ON(C.CLASS_NO = O.CLASS_NO)
JOIN		TB_PROFESSOR P ON(O.PROFESSOR_NO = P.PROFESSOR_NO)
--WHERE

9. 8 번의 결과 중 ‘인문사회’ 계열에 속핚 과목의 교수 이름을 찾으려고 핚다. 이에
해당하는 과목 이름과 교수 이름을 출력하는 SQL 문을 작성하시오.
CLASS_NAME PROFESSOR_NAME
------------------------------ --------------------
고전시가롞특강 김선정
국어어휘롞특강 김선정
…
…
논문지도2 강혁
197 rows selected

SELECT * FROM TB_DEPARTMENT

SELECT		CLASS_NAME 		AS 과목명
,			P.PROFESSOR_NAME 	AS 교수이름
FROM		TB_CLASS C
JOIN		TB_CLASS_PROFESSOR O ON(C.CLASS_NO = O.CLASS_NO)
JOIN		TB_PROFESSOR P ON(O.PROFESSOR_NO = P.PROFESSOR_NO)
JOIN		TB_DEPARTMENT D ON(P.DEPARTMENT_NO = D.DEPARTMENT_NO)
WHERE		D.CATEGORY LIKE '인문사회'
9번 완료

10. ‘음악학과’ 학생들의 평점을 구하려고 핚다. 음악학과 학생들의 "학번", "학생 이름",
"젂체 평점"을 출력하는 SQL 문장을 작성하시오. (단, 평점은 소수점 1 자리까지맊
반올림하여 표시핚다.)
학번 학생 이름 전체 평점
---------- -------------------- ----------
9931310 조기현 4.1
A354020 양재영 3.5
A411116 박현화 3.6
A415245 조지선 3.2
A431021 구병훈 3.9
A431358 조상진 3.7
A557031 이정범 3.3
A612052 싞광현 4.1
8 rows selected
18

SELECT * FROM TB_DEPARTMENT

SELECT		STUDENT_NO 			AS 학번
,			STUDENT_NAME 		AS 학생이름
,			ROUND(AVG(POINT),1)	AS 전체평점
FROM		TB_STUDENT
JOIN		TB_GRADE USING(STUDENT_NO)
WHERE 		DEPARTMENT_NO = 059
GROUP BY	STUDENT_NO,STUDENT_NAME
---------------------------------
SELECT   STUDENT_NO AS "학번",
     	 STUDENT_NAME AS "학생 이름",
     	 ROUND(AVG(POINT), 1) AS "전체 평점"
FROM   TB_STUDENT S
JOIN   TB_DEPARTMENT D ON (D.DEPARTMENT_NO=S.DEPARTMENT_NO)
JOIN   TB_GRADE G ON (G.STUDENT_NO=S.STUDENT_NO)
GROUP BY STUDENT_NO, STUDENT_NAME, DEPARTMENT_NAME
HAVING   DEPARTMENT_NAME = '음악학과';							
							
11. 학번이 A313047 인 학생이 학교에 나오고 있지 않다. 지도 교수에게 내용을 젂달하기
위핚 학과 이름, 학생 이름과 지도 교수 이름이 필요하다. 이때 사용핛 SQL 문을
작성하시오. 단, 출력헤더는 ‚학과이름‛, ‚학생이름‛, ‚지도교수이름‛으로
출력되도록 핚다.
학과이름 학생이름 지도교수이름
-------------------- -------------------- --------------------
경제학과 손건영 박태환

SELECT		DEPARTMENT_NAME AS	학과이름
,			STUDENT_NAME 	AS	학생이름
,			PROFESSOR_NAME 	AS	지도교수이름 
FROM		TB_DEPARTMENT D
JOIN		TB_PROFESSOR P	ON	(P.DEPARTMENT_NO = D.DEPARTMENT_NO)
JOIN		TB_STUDENT S	ON	(S.DEPARTMENT_NO = D.DEPARTMENT_NO)
WHERE		S.STUDENT_NO LIKE 'A313047'
11번완료

12. 2007 년도에 '인간관계론' 과목을 수강핚 학생을 찾아 학생이름과 수강학기름 표시하는
SQL 문장을 작성하시오.
STUDENT_NAME TERM_NAME
-------------------- --------------------
김혜원 200701
오진형 200701
이정호 200703

SELECT TERM_NO FROM TB_GRADE

SELECT	STUDENT_NAME	AS 학생이름
,		G.TERM_NO		AS 학기명
FROM	TB_STUDENT S
JOIN	TB_GRADE G 		ON(S.STUDENT_NO=G.STUDENT_NO)
WHERE	G.CLASS_NO = 'C2604100'
AND		G.TERM_NO 	 LIKE '2007%'

SELECT STUDENT_NO,TERM_NO 
FROM TB_GRADE 
WHERE CLASS_NO LIKE 'C2604100'
12번 완료

13. 예체능 계열 과목 중 과목 담당교수를 핚 명도 배정받지 못핚 과목을 찾아 그 과목
이름과 학과 이름을 출력하는 SQL 문장을 작성하시오.
CLASS_NAME DEPARTMENT_NAME
------------------------------ --------------------
드로잉 미술학과
미술시장,경영롞 미술학과
…
…
운동처방연구 체육학과
해부학실험 체육학과
44 rows selected

SELECT	CLASS_NAME, DEPARTMENT_NAME, PROFESSOR_NO
FROM	TB_CLASS C
JOIN	TB_DEPARTMENT D ON(D.DEPARTMENT_NO=C.DEPARTMENT_NO)
LEFT JOIN	TB_CLASS_PROFESSOR P ON(P.CLASS_NO=C.CLASS_NO)
WHERE	CATEGORY LIKE '예체능'
AND		PROFESSOR_NO IS NULL

SELECT CATEGORY FROM TB_DEPARTMENT

14. 춘 기술대학교 서반아어학과 학생들의 지도교수를 게시하고자 핚다. 학생이름과
지도교수 이름을 찾고 맊일 지도 교수가 없는 학생일 경우 "지도교수 미지정"으로
표시하도록 하는 SQL 문을 작성하시오. 단, 출력헤더는 ‚학생이름‛, ‚지도교수‛로
표시하며 고학번 학생이 먼저 표시되도록 핚다.
학생이름 지도교수
-------------------- --------------------
주하나 허문표
이희진 남명길
…
…
최철현 백양임
14 rows selected

SELECT	STUDENT_NAME 	AS 학생이름
,		NVL(PROFESSOR_NAME,'지도교수 미지정') 	AS 지도교수 --지도교수 없으면 "지도교수 미지정"으로 표시
FROM	TB_STUDENT S
LEFT JOIN	TB_PROFESSOR P ON(S.COACH_PROFESSOR_NO=P.PROFESSOR_NO)
WHERE	S.DEPARTMENT_NO = 020


15. 휴학생이 아닌 학생 중 평점이 4.0 이상인 학생을 찾아 그 학생의 학번, 이름, 학과
이름, 평점을 출력하는 SQL 문을 작성하시오.
학번 이름 학과 이름 평점
---------- -------------------- -------------------- ----------
9811251 김충원 건축공학과 4.11111111
9817035 김소라 토목공학과 4
9931310 조기현 음악학과 4.05
…
…
19 rows selected
20

SELECT		S.STUDENT_NO 		AS 학번
,			S.STUDENT_NAME 	AS 이름
,			D.DEPARTMENT_NAME AS 학과
,			ROUND(AVG(POINT),1) 		AS 평점
FROM		TB_STUDENT S
LEFT JOIN	TB_GRADE G 		ON(G.STUDENT_NO=S.STUDENT_NO)
JOIN		TB_DEPARTMENT D ON(S.DEPARTMENT_NO=D.DEPARTMENT_NO)	
WHERE		S.ABSENCE_YN LIKE 'N'
GROUP BY	S.STUDENT_NO, S.STUDENT_NAME, D.DEPARTMENT_NAME
HAVING		AVG(POINT) >= 4
		

16. 환경조경학과 전공과목들의 과목 별 평점을 파악핛 수 있는 SQL 문을 작성하시오.
CLASS_NO CLASS_NAME AVG(POINT)
---------- ------------------------------ ----------
C3016200 전통계승방법롞 3.67857142
C3081300 조경계획방법롞 3.69230769
C3087400 조경세미나 3.90909090
C4139300 환경보전및관리특롞 3.02777777
C4477600 조경시학 3.17647058
C5009300 단지계획및설계스튜디오 3.375
6 rows selected

SELECT		C.CLASS_NO, C.CLASS_NAME, AVG(POINT)
FROM		TB_CLASS C
JOIN		TB_GRADE G ON(C.CLASS_NO=G.CLASS_NO)
WHERE		C.DEPARTMENT_NO = '034'
AND			C.CLASS_TYPE LIKE '전공%'
GROUP BY	C.CLASS_NO, C.CLASS_NAME

17. 최경희 학생과 같은 과 학생들의 이름과 주소를 출력하는 SQL 문을 작성하시오.
STUDENT_NAME STUDENT_ADDRESS
-------------------- ----------------------------------------------------------
최경희 대구광역시 달서구 월성동 277-3 동서타운아파트 101-1403호
정기원 서울시 송파구 가락2동 극동아파트 4-1505
…
…
김희훈 인천시 부평구 십정 1동 323- 19호
17 rows selected
21

SELECT		STUDENT_NAME, STUDENT_ADDRESS
FROM		TB_STUDENT
WHERE		DEPARTMENT_NO IN(SELECT DEPARTMENT_NO
							 FROM	TB_STUDENT
							 WHERE  STUDENT_NAME LIKE '최경희')

18. 국어국문학과에서 총 평점이 가장 높은 학생의 이름과 학번을 표시하는 SQL 문을
작성하시오.
STUDENT_NO STUDENT_NAME
---------- --------------------
9931165 송근우

SELECT * FROM TB_DEPARTMENT

SELECT 	S.STUDENT_NO, S.STUDENT_NAME
FROM	TB_STUDENT S
JOIN	TB_GRADE G ON(S.STUDENT_NO = G.STUDENT_NO)
WHERE 	S.DEPARTMENT_NO LIKE '001'
GROUP BY S.STUDENT_NO, S.STUDENT_NAME
HAVING 	AVG(POINT) = (	SELECT 		MAX(AVG(POINT))
						FROM		TB_GRADE G2
						JOIN		TB_STUDENT S3 ON(S3.STUDENT_NO=G2.STUDENT_NO)
						WHERE 		S3.DEPARTMENT_NO LIKE '001'
						GROUP BY	S3.STUDENT_NO
						);
							
19. "환경조경학과"가 속한 같은 계열 학과들의 학과 별 전공과목 평점을
파악하기 위한 적절핚 SQL 문을 찾아내시오. 단, 출력헤더는 "계열 학과명",
"젂공평점"으로 표시되도록 하고, 평점은 소수점 핚 자리까지맊 반올림하여 표시되도록
핚다.
계열 학과명 전공평점
-------------------- --------
간호학과 3.3
물리학과 3.3
…
…
환경조경학과 3.4
20 rows selected

SELECT * FROM TB_DEPARTMENT

SELECT	D.DEPARTMENT_NAME	AS "계열학과명"
,		ROUND(AVG(POINT),1)		AS "전공평점"
FROM	TB_DEPARTMENT D
JOIN	TB_CLASS C ON(D.DEPARTMENT_NO=C.DEPARTMENT_NO)
JOIN	TB_GRADE G ON(G.CLASS_NO=C.CLASS_NO)
WHERE	CATEGORY = (	SELECT	CATEGORY
						FROM	TB_DEPARTMENT
						WHERE	DEPARTMENT_NAME LIKE '환경조경학과')
AND		CLASS_TYPE IN (	SELECT 	CLASS_TYPE
						FROM 	TB_CLASS
						WHERE	CLASS_TYPE LIKE '전공%')
GROUP BY	DEPARTMENT_NAME

DDL(DATA DEFINITION LANGUAGE)
TABLE은 데이터를 저장할 수 있는 저장소


테이블생성
CREATE TABLE [테이블명]
(COLUMN_NAME DATATYPE [DEFAULT EXPR] [COLUMN_CONSTRAINT][,...]
[,TABLE_CONSTRAINT,...]);

COLUMN_CONSTRAINT
	[CONSTRAINT CONSTRAINT_NAME ] CONSTRAINT_TYPE



컬럼 제약조건
테이블 제약조건

NAMING RULE
테이블 및 컬럼이름
-문자로 시작, 30자이하
-영문 대/소문자(A~Z,a~z),숫자(0~9), 특수문자,한글만 포함가능

--테이블을 없애는 명령어
DROP TABLE TEST_MEMBER ;

CASCADE CONSTRAINT -- 관계를 끊고 삭제할 수 있도록 하는 명령어

--테이블을 만드는 명령어
CREATE TABLE TEST_MEMBER(
	ID 			VARCHAR2(50) PRIMARY KEY,
	PWD			VARCHAR2(50),
	NAME		VARCHAR2(50),
	AGE			NUMBER,
	MARRIAGE	CHAR(1),
	REGDATE		DATE DEFAULT SYSDATE--DAFAULT 명시해주지 않으면 DEFAULT로 명시해놓은 값이 들어간다.
	--PRIMARY KEY(ID) -- 테이블 내의 제약조건 CONSTRAINTS
);



DROP TABLE TEST_BOARD;
CREATE TABLE TEST_BOARD(
	SEQ		NUMBER	PRIMARY KEY,
	WRITER	VARCHAR2(50) NOT NULL REFERENCES TEST_MEMBER(ID), --사용자의 아이디로 하고싶다.
	TITLE	VARCHAR2(50)	,	
	CONTENT	VARCHAR2(2000)	,
	REGDATE	DATE,
	CNT		NUMBER
);


SELECT * FROM TEST_BOARD;
--SEQUENCE(
--NEXTVAL -값을 얻어올때,
--CURRVAL -현재 시퀀스의 값을 확인할 때)

CREATE SEQUENCE BOARDSEQ ; --1에서 부터 무한대로 값을 채굴하게 된다.

INSERT INTO TEST_BOARD
VALUES(BOARDSEQ.NEXTVAL,'acorn','공지','뻥',SYSDATE,0);
--INSERT
INSERT INTO TEST_MEMBER 
VALUES('acorn','acorn','에이콘',5,'y',SYSDATE);
INSERT INTO TEST_MEMBER(ID,PWD,NAME,AGE,MARRIAGE) 
VALUES('acorn1','acorn','에이콘',5,'y');
INSERT INTO TEST_MEMBER(ID,PWD) VALUES('acorn2','acorn2');
SELECT * FROM TEST_MEMBER;

제약조건
데이터 무결성
	데이터 베이스에 저장되어 있는 데이터가 손상되거나 원래의 의미를 잃지않고 유지하는 상태
데이터 무결성 제약조건
	데이터 무결성을 보장하기 위해 오라클에서 지원하는 방법
	예)유효하지 않은 데이터 입력 방지, 유효한 범위에서만 데이터 변경/삭제 작업허용

제약조건|설명|설정레벨
NOT NULL		해당 커럼에 NULL을 포함되지 않도록 함		
UNIQUE			중복을 허용하지 않는다
PRIMARY KEY		NOT NULL + UNIQUE
REFERENCES		REFERENCES [TABLE(PRIMARY KEY)]
CHECK			조건을 만족하도록

외래키의 특징
기본키만을 레퍼런스 할 수 있다.
부모에 의존,NULL이 존재할 수 있다.

CREATE TABLE TEST_PK(
	ORDERNUM	NUMBER	PRIMARY KEY,
	ITEMNUM		NUMBER	PRIMARY KEY,
	QTY			NUMBER CHECK(QTY > 0),
	DESC		VARCHAR2(2000)
); -- 오류가 난다.
--프라이머리 키를 두개 이상 주고 싶을때 가 있다
--그럴때엔 COMPOSITE PRIMARY KEY 가 필요하다.
CREATE TABLE TEST_PK(
	ORDERNUM	NUMBER	,
	ITEMNUM		NUMBER	,
	QTY			NUMBER CHECK(QTY > 0),
	DESCRIBE	VARCHAR2(2000),
	PRIMARY KEY (ORDERNUM,ITEMNUM)
);
SELECT * FROM TEST_PK;
INSERT INTO TEST_PK
VALUES(1,1,10,'테스트');

INSERT INTO TEST_PK
VALUES(1,2,10,'테스트');

INSERT INTO TEST_REF
VALUES(1,NULL,NULL);
INSERT INTO TEST_REF
VALUES(2,1,2);
SELECT * FROM TEST_REF;

DROP TABLE TEST_REF;
CREATE TABLE TEST_REF(
	NUM		NUMBER	PRIMARY KEY,
	--아래 두개를 외래키로 잡고 싶은데, 레퍼런시스를 하나하나에 할수가없다.
	--컴퍼지트프라이머리키라. 고로 테이블 레벨에서 제한하게 된다. 그런데 외래키는 테이블레벨에선 문법이 달라진다.
	ORDERNUM	NUMBER	NOT NULL,
	ITEMNUM		NUMBER	NOT NULL,
	FOREIGN KEY(ORDERNUM,ITEMNUM) REFERENCES TEST_PK(ORDERNUM,ITEMNUM)
	--먼저 외래키가 뭔지 명시해주고 어디서 왔는지 레퍼런스 해준다.
	--외래키는 NOT NULL을 정해주는게 거의 대부분이다.
);



PLSQL



뷰뷰뷰뷰뷰~~~~~~~~~~~~~~~~~~~~~~~~~~~
뷰 개요
다른테이블이나 뷰에 포함된 데이터의 맞춤표현
'STORED QUERY' 또는 "VIRTUAL TABLE"로 간주되는 데이터베이스 객체

개념
하나 또는 하나이상의 테이블/뷰에 포함된 데이터 부분 집합을 나타내는 논리적인 객체 -> 선택적인 정보만 제공 가능
자체적으로 데이터를 포함하지 않는다.
베이스테이블 : 뷰를 통해 보여지는 데이터를 포함하고 있는 실제 테이블

뷰 생성구문
CREATE [OR REPLACE] [FORCE | NOFORCE] VIEW VIEW_NAME [( ALIAS [,ALIAS...])]

CREATE OR REPLACE VIEW V_EMP
AS 	SELECT 	EMP_NAME, DEPT_ID
	FROM	EMPLOYEE
	WHERE	DEPT_ID = '90';
	
SELECT * FROM V_EMP;	

CREATE OR REPLACE VIEW V_EMP_DEPT_JOB
AS	SELECT	EMP_NAME,
			DEPT_NAME,
			JOB_TITLE
	FROM	EMPLOYEE
	LEFT JOIN 	DEPARTMENT USING (DEPT_ID)
	LEFT JOIN 	JOB USING (JOB_ID)
	WHERE		JOB_TITLE = '사원';

SELECT * FROM V_EMP_DEPT_JOB;


--UPDATE
/*
 * UPDATE 테이블명 SET COLUMN = VALUE,[COLUMN = VALUE]
 * WHERE COLUMN = VALUE;
 * 참조 데이터도 업데이트 할 수 있지만
 * 부모 테이블의 값으로 업데이트 하지않으면 무결성 위배된다.	
 */
UPDATE 	TEST_BOARD
SET		TITLE='배고프당',CONTENT = '밥묵자'
WHERE	SEQ = 4; --WHERE를 주지않으면 전체 레코드가 변한다.

SELECT * FROM TEST_BOARD

INSERT INTO TEST_BOARD
VALUES(BOARDSEQ.NEXTVAL,'acorn','공지','뻥',SYSDATE,0);

CRUD

-- DELETE --데이터를 삭제
/*
 * DELETE FROM 테이블명
 * WHERE	COLUMN = VALUE;
 */

DELETE FROM TEST_BOARD
WHERE SEQ = 4;

테이블 수정 - 구문
테이블 구조 수정
--테이블 이름 변경
ALTER TABLE TEST_BOARD RENAME TO EXAMPLE_BOARD;
ALTER TABLE EXAMPLE_BOARD RENAME TO TEST_BOARD;
SELECT * FROM EXAMPLE_BOARD;
--컬럼 이름 변경
ALTER TABLE EXAMPLE_BOARD RENAME COLUMN CNT TO VIEWCNT;

테이블 수정 
- 컬럼 추가
추가되는 컬럼은 테이블의 맨 마지막에 위치하며, 생성위치를 변경할 수 없음
-제약 조건도 추가 할 수 있다.
ADD 조건 (칼럼명)
MODIFY로 수정한다.
NOT NULL 조건은 
ALTER TABLE DEPARTMENT ADD (MGR_ID CHAR(3));
SELECT * FROM DEPARTMENT

CREATE TABLE EMP5
(EMP_ID		CHAR(3),
EMP_NAME	VARCHAR2(20),
ADDR1		VARCHAR2(20) DEFAULT '서울',
ADDR2		VARCHAR2(100));	

INSERT INTO EMP5
VALUES('A10','임태희',DEFAULT,'청담동');
INSERT INTO EMP5
VALUES('B10','이병언',DEFAULT,'분당 정자동');

SELECT *FROM EMP5

ALTER TABLE EMP5
MODIFY(ADDR1 DEFAULT '경기');
INSERT INTO EMP5
VALUES ('C10','임승우',DEFAULT,'분당 효자촌');
SELECT * FROM EMP5

--컬럼삭제
컴럼 하나를 삭제 가능
커럼 여러개를 한번에 삭제 가능
주의 사항
삭제 대상 컬럼에 데이터가 포함되어있어도 삭제됨
삭제 작업 후에는 테이블에 반드시 컬럼이 하나이상 남아있어야 함
->모든 커럼을 삭제할 수 없음
삭제된 컬럼은 복구 할 수 없음
때문에 안쓰는 컬럼을 비활성화 해두는게 보편적이다.
ALTER TABLE EMP4
DROP COLUMN EMP_ID;
또는
ALTER TABLE EMP4
DROP (EMP_ID);

--시퀀스
--개념 및 생성 구문
테이블당 하나를 만들어야되

CREATE SEQUENCE sequence_name
여러가지 옵션

drop sequence

DROP TABLE CUSTOMERS

CREATE TABLE customers (
	CNO		NUMBER(5) PRIMARY KEY,
	CNAME	VARCHAR2(10) NOT NULL,
	ADDRESS	VARCHAR2(50) NOT NULL,
	EMAIL	VARCHAR2(20) NOT NULL,
	PHONE	VARCHAR2(20) NOT NULL
);

CREATE TABLE ORDERS(
	ORDERNO 	NUMBER(10) PRIMARY KEY,
	ORDERDATE	DATE DEFAULT SYSDATE NOT NULL,
	ADDRESS		VARCHAR2(50) NOT NULL,
	PHONE		VARCHAR2(20) NOT NULL,
	STATUS		VARCHAR2(20) NOT NULL CHECK(STATUS IN('결제완료','배송중','배송완료')),
	CNO			NUMBER(5)	NOT NULL,
	FOREIGN KEY(CNO) REFERENCES CUSTOMERS(CNO)
);

CREATE TABLE PRODUCTS(
	PNO			NUMBER(5)	PRIMARY KEY,
	PNAME		VARCHAR2(20) NOT NULL,
	COST		NUMBER(8) DEFAULT 0 NOT NULL ,
	STOCK		NUMBER(5) DEFAULT 0 NOT NULL 
);

CREATE TABLE ORDERDETAIL(
	ORDERNO		NUMBER(10),
	PNO			NUMBER(5),
	QTY			NUMBER(5) DEFAULT 0,
	COST		NUMBER(8) DEFAULT 0,
	PRIMARY KEY(ORDERNO, PNO),
	FOREIGN KEY(ORDERNO) REFERENCES ORDERS(ORDERNO),
	FOREIGN KEY(PNO) REFERENCES PRODUCTS(PNO)
);

SELECT * FROM ORDERDETAIL;
SELECT * FROM PRODUCTS
SELECT * FROM CUSTOMERS;
SELECT * FROM ORDERS;

2.PRODUCTS 테이블에 다음 데이터를 입력하시오

INSERT INTO PRODUCTS
VALUES(1001,'삼양라면',1000,200);
INSERT INTO PRODUCTS
VALUES(1002,'새우깡',1500,500);
INSERT INTO PRODUCTS
VALUES(1003,'월드콘',2000,350);
INSERT INTO PRODUCTS
VALUES(1004,'빼빼로',2000,700);
INSERT INTO PRODUCTS
VALUES(1005,'코카콜라',1800,550);
INSERT INTO PRODUCTS
VALUES(1006,'환타',1600,300);

3.CUSTOMERS 테이블에 다음 데이터를 입력하시오.
INSERT INTO CUSTOMERS
VALUES(101,'김철수','서울 강남구','cskim@naver.com','899-6666');
INSERT INTO CUSTOMERS
VALUES(102,'이영희','부산 서면','yhlee@empal.com','355-8882');
INSERT INTO CUSTOMERS
VALUES(103,'최진국','제주 동광양','jkchoi@gmail.com','852-5764');
INSERT INTO CUSTOMERS
VALUES(104,'강준호','강릉 홍제동','jskang@hanmail.com','559-7777');
INSERT INTO CUSTOMERS
VALUES(105,'민병국','대전 전민동','bgmin@hotmail.com','559-8741');
INSERT INTO CUSTOMERS
VALUES(106,'오민수','광주 북구','msoh@microsoft.com','542-9988');

4.다음과 같은 주문 정보를 orders 테이블과 orderdetail 테이블에 입력하시오. cno는 customers 테이블에서
검색하여 입력할 것. orders에 1건, orderdetail에 1건을 입력한다.

INSERT INTO ORDERS(ORDERNO,ORDERDATE,ADDRESS,PHONE,STATUS,CNO)
VALUES(1,SYSDATE-3,'서울 강남구','899-6666','결제완료',101);
INSERT INTO ORDERDETAIL(ORDERNO,PNO,COST,QTY)
VALUES(1,1001,1000,50);

5. 위와 같은 주문 정보에서 해당 상품(products)의 재고(stock)을 수정하시오
	“삼양라면(1001)의 재고를 150(=200-50)개로 변경한다”
UPDATE PRODUCTS
SET STOCK=150
WHERE PNO = 1001;
6.다음과 같은 주문 정보를 orders 테이블과 orderdetail 테이블에 입력하시오.
cno는 customers 테이블에서검색하여 입력할 것. 
orders에 1건, orderdetail에 2건을 입력한다
INSERT INTO ORDERS(ORDERNO,ORDERDATE,ADDRESS,PHONE,STATUS,CNO)
VALUES(2,SYSDATE-2,'부산 수영구','337-5000','결제완료',102);
INSERT INTO ORDERDETAIL(ORDERNO,PNO,COST,QTY)
VALUES(2,1002,1500,100);
INSERT INTO ORDERDETAIL(ORDERNO,PNO,COST,QTY)
VALUES(2,1003,2000,150);

7.위와 같은 주문 정보에서 해당 상품(products)의 재고(stock)을 수정하시오.
 “새우깡(1002)의 재고를 400(=500-100)개로 변경한다”
 “월드콘(1003)의 재고를 200(=350-150)개로 변경한다”

UPDATE PRODUCTS
SET		STOCK=400
WHERE PNO=1002;
UPDATE PRODUCTS
SET		STOCK=200
WHERE PNO=1003;

8. 다음과 같은 주문 정보를 orders 테이블과 orderdetail 
테이블에 입력하시오. cno는 customers 테이블에서 검색하여 입력할 것.
orders에 1건, orderdetail에 2건을 입력한다.
“오민수(106)가 어제 빼빼로(1004)를 개당 2000원에 100개, 
코카콜라(1005)를 개당 1800원에 50개 주문하였다.”

INSERT INTO ORDERS
(ORDERNO,ORDERDATE,ADDRESS,PHONE,STATUS,CNO)
VALUES(3,SYSDATE-1,'광주 북구',652-2277,'결제완료',106);
INSERT INTO ORDERDETAIL
(ORDERNO,PNO,COST,QTY)
VALUES(3,1004,2000,100);
INSERT INTO ORDERDETAIL
(ORDERNO,PNO,COST,QTY)
VALUES(3,1005,1800,50);

9.위와 같은 주문 정보에서 해당 상품(products)의 재고(stock)을 수정하시오.
 “빼빼로(1004)의 재고를 600(=700-100)개로 변경한다”
 “코카콜라(1005)의 재고를 500(=550-50)개로 변경한다”
 
UPDATE PRODUCTS
SET		STOCK=600
WHERE PNO=1004;
UPDATE PRODUCTS
SET		STOCK=500
WHERE PNO=1005;

10. 다음과 같은 전체 주문 목록을 출력하는 문장을 작성하시오.

CREATE OR REPLACE VIEW VV
AS	SELECT	O.ORDERDATE,
			C.CNAME,
			C.ADDRESS,
			C.PHONE,
			O.STATUS,
			P.PNAME,
			D.COST,
			D.QTY,
			D.COST*D.QTY AS "COST*QTY"
	FROM	CUSTOMERS C
	JOIN 	ORDERS O ON (O.CNO=C.CNO)
	JOIN 	ORDERDETAIL D ON (D.ORDERNO=O.ORDERNO)
	JOIN	PRODUCTS P ON (P.PNO=D.PNO);
SELECT * FROM VV;

11. 다음과 같이 일별 매출 목록을 출력하는 문장을 작성하시오.
CREATE OR REPLACE VIEW VV2
AS	SELECT	ORDERDATE,
			SUM(COST*QTY) AS "SUM(COST*QTY)"
	FROM	ORDERS O
	JOIN	ORDERDETAIL D ON (O.ORDERNO=D.ORDERNO)
	GROUP BY ORDERDATE;

SELECT * FROM VV2

12. 다음과 같은 신규 상품 정보를 products 테이블에 입력하시오.
“제품번호는 1007, 상품명은 목캔디, 단가는 3000원, 재고는 500개이다.”

INSERT INTO PRODUCTS(PNO,PNAME,COST,STOCK)
VALUES(1007,'목캔디',3000,500);

13. 다음과 같은 4번 주문 정보를 입력하고, 재고를 적절히 수정하시오. 

주문 정보를 입력하고, 10번 문제에서 작성한 문장으로 검색하면 다음과 같다.
“최진국(103)이 오늘 목캔디(1007)를 개당 3000원에 200개 주문하였으며,
배송지의 주소는 제주 동광양이며, 연락처는 352-4657이고, 
결제가 완료된 상태이다.”

INSERT INTO ORDERS
(ORDERNO,ORDERDATE,ADDRESS,PHONE,STATUS,CNO)
VALUES(4,SYSDATE,'제주 동광양','352-4657','결제완료',103);
INSERT INTO ORDERDETAIL
(ORDERNO,PNO,COST,QTY)
VALUES(4,1007,3000,200);

SELECT * FROM PRODUCTS;

UPDATE PRODUCTS
SET	STOCK=300
WHERE PNO=1007;

1.다음 설정을 참조하여 테이블을 생성하시오
CREATE TABLE	member(
	member_id	number(10) PRIMARY KEY,
	name		varchar2(25)	not null,
	address		varchar2(100),
	city		varchar2(30),
	phone		varchar2(15),
	join_date	date DEFAULT SYSDATE not null
);

CREATE TABLE	title(
	title_id		number(10) primary key,
	title			varchar2(60) not null,
	description		varchar2(400) not null,
	rating			varchar2(20) check(rating in ('18가','15가','12가','전체가')),
	category		varchar2(20) check(category in ('드라마','코미디','액션','아동','SF','다큐멘터리')),
	release_date	date	
);

CREATE TABLE title_copy(
	copy_id		number(10),
	title_id	number(10),
	status		varchar2(20) check(status in('대여가능','파손','대여중','예약')),
	primary key(copy_id,title_id),
	FOREIGN KEY(title_id) REFERENCES title(title_id)
);

CREATE TABLE rental(
	book_date		date default sysdate,
	member_id		number(10) references member(member_id),
	copy_id			number(10),
	title_id		number(10),
	acr_ret_date	date,
	exp_ret_date	date default sysdate+2,
	primary key(book_date,member_id,copy_id,title_id),
	foreign key(copy_id,title_id)	references title_copy(copy_id,title_id)
);