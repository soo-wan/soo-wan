--테이블내의 하나의 필드값들 전체로 하는 함수

--합계(SUM)
SELECT SUM(INPRICE) AS "입고가격합계" FROM BOOKLIST;

SELECT SUM(RENTPRICE) AS "대여가격합계" FROM BOOKLIST WHERE INPRICE>=18000;

--갯수(COUNT)
SELECT COUNT(*) AS "회원수" FROM MEMBERLIST;
SELECT COUNT(*) AS "회원수" FROM MEMBERLIST WHERE BPOINT<=100;

--평균(AVG)
select round(avg(inprice) , 0) as "입고가격평균" from booklist;
--TO_CHAR로 변경된 숫자는 문자로 변경된 것이므로 이제 숫자로서의 기능이 상실됩니다. 다른 숫자와 계산 불가
select to_char(avg(inprice) ,'999,999,999') as "입고가격평균" from booklist;

--MAX : 최대값
--SEQUENCE에 의해서 추가된 자동 증가 번호를 조회할때 많이 사용합니다.
select max(inprice) from booklist;

--MIN : 최소값
select min(inprice) from booklist;

-- GROUP BY
--그룹함수의 결과들을 다른 필드의 그룹으로 재구성
SELECT COUNT(*) AS "총대여건수" FROM RENTLIST;

--도서별 대여건수
select bnum as "도서번호", count(*) as "도서별 대여건수", sum(discount) as "할인금액합계" from rentlist
group by bnum;

--RENTLIST 테이블에서 대여일자(RENTDATE)별 대여건수와 할인금액 평균
select rentdate as 대여일자, count(*) as 대여건수
from rentlist group by rentdate order by rentdate desc;

--HAVING
--그룹핑된 내용들에 조건을 붙일때
select rentdate as 대여일자, count(*) as 대여건수, avg(discount) as 할인금액평균
from rentlist 
group by rentdate
having avg(discount) >= 150
order by rentdate desc;

묵혀뒀다가 나중에 경매 올리면 1억은 넘을거같은데 
근데 이게 잡는순간 사람들 시선이 다 쏠려서
기증안한다고 하면 이제...... 그.... 사람들이 욕할수도 

아니 근데 이게 600호인지 아닌지 어케 구분하지

나중에 
