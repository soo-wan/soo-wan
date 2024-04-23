--숫자 관련 함수
--CEILING(숫자) - 값보다 큰 정수 중 가장 작은 수. (올림)
--FLOOR(숫자) - 값보다 작은 정수 중 가장 큰 수[실수를 무조건 버림(음수일 경우는 제외)
--round(숫자, 자리수) - 소수점 자리수만큼 남기고 아래서 반올림

--문자 관련 함수
--substring('문자열',시작위치,개수) - 문자열 중 시작위치부터 개수만큼 출력
--lcase('문자열') or lower('문자열') - 소문자로 바뀐다.
--ucase('문자열') or upper('문자열') - 대문자로 바뀐다.
--reverse('문자열') - 문자열을 반대로 나열한다.

update booklist set grade = upper(grade);
select * from booklist;



--날짜 관련 함수
--now() - 현재 날짜와 시간 (datetime 형식)
--curdate() or current_date() - 현재 날짜 (date 형식)
--curtime() or current_time() - 현재 시간 (time 형식)

--DATE_ADD(날짜, INTERVAL 더할숫자 기준값)
--날짜에서 기준값 단위로 더할 숫자 만큼 더한다.
--기준값 : YEAR, MONTH, DAY, HOUR, MINUTE, SECOND
select date_add(now(), interval 3 year) from dual; --3년후

--date_sub(날짜, interval 뺄숫자 기준값) - 날짜에서 기준값 단위로 뺄 숫자만큼 뺀다

--YEAR(날짜) - 날짜의 연도 추출
--MONTH(날짜) - 날짜의 월 추출
--MONTHNAME(날짜) - 날짜의 월을 영어로 추출
--DAYOFMONTH(날짜) - 날짜의 월별 일자 추출
--DAYOFWEEK(날짜) - 날짜의 주별 일자 출력(일요일(1), 월요일(2)...토요일(7))
--WEEKDAY(날짜) - 날짜의 주별 일자 추출(월요일(0), 화요일(1), ... 일요일(6))
SELECT CONCAT(YEAR(now() ) , '년') as "년도" from dual;


--오라클의 to_char(sysdate, 'YYYYMMDD') 날짜 -> 문자
--오라클의 to_date('20230420', 'YYYYMMDD') 문자 -> 날짜

--Mysql
--date_format(now(), '%Y%M%D')  날짜 -> 문자
--str_to_date('20211013', '%Y%m%d') 문자 -> 날짜
select date_format(now(), '%Y%m%d') from dual; --20240417
select str_to_date('20240417', '%Y%m%d') from dual; --2024-04-17

--%a  요일(Sun~Sat)
--%b  월(Jan~Dec)
--%M  월(January~December)
--%c  월(0~12)
--%h  시간(00~12)
--%I  시간(00~12)

--%r  시간(12시)을 hh:mm:ss AM/PM 형식으로
--%T  시간(24시)을 hh:mm:ss 형식으로

--집계 함수(그룹함수)
--COUNT(필드명) - NULL 값이 아닌 레코드 수를 구한다.
--SUM(필드명) - 필드명의 합계를 구한다.
--AVG(필드명) - 각각의 그룹 안에서 필드명의 평군값을 구한다.
--MAX(필드명) -- 최대값을 구한다.
--MIN(필드명) -- 최소값을 구한다.