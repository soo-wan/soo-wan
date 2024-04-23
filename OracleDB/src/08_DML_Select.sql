--오라클 명령어 : select문 (검색)
--가장 사용빈도수가 높은 명령

--[1] scott 사용자가 관리하고 있는 테이블 목록
select * from tab;
select * from tabs;

--[2] 특정 테이블의 구조 조회(필드리스트/데이터 형식)
desc booklist; --커맨드 창(sqlplus)에서 확인 요망
desc memberlist; --커맨드 창(sqlplus)에서 확인 요망
--sqlplus-scott/tiger

--[3] 테이블의 제약사항 조회
select * from user_constraints; --모든 제약 사항
select * from USER_CONSTRAINTS where TABLE_NAME='RENTLIST'; --특정 테이블의 제약사항, 테이블이름 대문자로 검색해야함!
select * from USER_CONSTRAINTS where TABLE_NAME='BOOKLIST'; 
select * from USER_CONSTRAINTS where TABLE_NAME='MEMBERLIST'; 

--SELECT의 사용법
--SELECT : select와 from 사이에 조회하고자 하는 필드명들을 ,로 구분하여 나열합니다
select booknum, subject, rentprice from booklist;
--모든 필드를 한번에 지목하려면 *을 써줍니다   --select * from...
--from 뒤에는 대상 테이블 명을 써줍니다.
--where 절을 붙여서 조건에 맞는 행만 골라내기도 합니다.
select 필드명들 또는 * from 테이블명 where 검색조건

--출판년도가 2020년 이후인 도서의 제목과 출편년도를 조회
select subject, makeyear from booklist where makeyear>=2020;

select * from booklist; --검색조건 없이 모든 필드를 다 조회해서 열람

--연산의 결과가 필드 항목으로 조회될 수 있습니다
select rentprice * 10 - inprice as 마진 from booklist;
select subject as 제목, rentprice * 10 - inprice as 마진 from booklist;
--select subject as 제목, rentprice * 10 - inprice as 10회대여 마진 from booklist; --from 앞에 빈칸있으면 에러
select subject as "도서 제목", rentprice * 10 - inprice as "10회대여 마진" from booklist; --as절 뒤에 큰 따옴표로 묶어준다.

--오라클 SL에서 ||는 이어붙이기 연산입니다.
select booknum || '-' || subject as "book info" from booklist;

--중복제거 distinct
select bnum as 대여도서번호들 from rentlist;
select distinct bnum as 대여도서번호들 from rentlist;

--함수의 사용
select avg(inprice) as 입고가격평균 from booklist;

--검색 조건 : update와 delete에서 사용하던 where와 사용방식이 똑같습니다.

--memberlist 테이블에서 이름이 '홍'으로 시작하는 회원의 모든 정보 출력
select * from memberlist where name like '홍%';

--memberlist 테이블에서 1983년도 이후로 태어난 회원의 모든 회원정보
select * from memberlist where birth >= '1983-01-01';

--booklist에서 제작년도가 2016년 이전이거나 입고가격(inprice)이 18000 이하인 도서의 모든 필드
select * from booklist where makeyear < 2016 or inprice <=18000;

--booklist에서 도서 제목에 두번째 글자가 '것'인 도서 정보
select * from booklist where subject like '_것%'; --앞에 뭐가 있으면 한글자를 뜻하는  _를 넣어준다.

select * from emp;

select * from dept;

-- IN ANY SOME ALL

--부서번호가 10,20,30인 사원들의 모든 필드 조회
--방법 #1
select * from emp where deptno=10 or deptno=20 or deptno=30;

--방법 #2
select * from emp where deptno <> 40;

--방법 #3
select * from emp where deptno in(10,20,30);
select * from emp where deptno not in(40);


--1. ANY
--ANY() : 괄호안에 나열된 내용중 어느하나라도 해당하는 것이 있따면 검색 대상으로 함.
--IN과 유사
select * from emp where deptno = any(10,20,40);

--2. SOME 조건식 - ANY와 동일
select * from emp where deptno = some(10,20,40);

--3. ALL
--괄호안의 모든 값이 동시 만족해야하는 조건이므로 해당하는 레코드가 없을때가 대부분입니다. 사용빈도수가 현저히 낮습니다.
select * from emp where deptno = all(10,20,40);

--이와 같이 구성내용과 모두 같지 않을때를 필터링할때 자주 사용합니다.
select * from emp where deptno <> all(10,20,40);

--위 예문을 in으로 표현
select * from emp where deptno not in (10,20,40);


-- 그외 활용하기 좋은 select에 대한 예제

--부서번호가 10이 아닌 사원(아래 두 문장은 같은 의미의 명령입니다)
select * from emp where not (deptno=10);
select * from emp where deptno<>10;

--급여가 1000달러 이상, 3000달러 이하
select * from emp where sal >= 1000 and sal <= 3000;
select * from emp where sal between 1000 and 3000;

--사원의 연봉 출력
select deptno, ename, sal*12 as 연봉 from emp;

--정렬(sort) - where 구문 뒤에, 또는 구문의 맨 끝에 order by 필드명[desc]
--select 명령의 결과를 특정 필드값의 오름차순이나 내림차순으로 정렬하라는 명령
--asc : 오름차순 정렬, 쓰지 않으면 기본 오름차순 정렬로 실행됩니다
--desc : 내림차순 정렬, 내림 차순 정렬을 위해서는 반드시 정렬 기준이 되는 필드명 뒤에 써야하는 키워드입니다.

--emp 테이블에서
--sal이 1000 이상인 데이터를 ename의 오름차순으로 정렬하여 조회
select * from emp where sal>=1000 order by ename; --오름차순일때 asc는 생략 가능
--sal이 1000 이상인 데이터를 ename의 내림차순으로 정렬하여 조회
select * from emp where sal>=1000 order by ename desc;

--job으로 내림차순 정렬후 같은 job_id 사이에서는 순서를 hiredate의 내림차순으로 정렬
select * from emp order by job desc, hiredate desc;
--두가지 이상의 정렬 기준이 필요하다면 위와 같이 컴마(,)로 구분해서 두가지 기준을 지정해주며,
--위의 예제로 봤을때 job으로 1차 내림 차순 정렬하고, 같은 job 값들 사이에 hiredate로 내림차순 정렬합니다.



