--select 명령의 결과 레코드가 갯수가 많을때, 일부만 지목해서 열람할 수 있습니다.

--<오라클>오라클에서는 rownum 이라는 키워드를 이용합니다.
--select rownum, 테이블이름.* from 테이블이름;
--select * from 테이블이름 where rownum >= 1 and rownum <= 10;

--<mysql>
--LIMIT
--select로 데이터 조회할때, 조회할 레코드의 갯수를 조절 제한 할 수 있습니다.
select * from memberlist order by membernum desc limit 5;
--회원 정보 조회하여 5개의 레코드만 리턴

--OFFSET
--select로 데이터 조회할때, 맨위에서부터 offset에 지정한 번째까지는 뛰어 넘고 그 다음부터 리턴
select * from memberlist order by membernum desc;
select * from memberlist order by membernum desc limit 5 offset 3;  
-- 3번째 데이터부터 5개의 레코드 리턴 - 개수가 모자르면 있는곳까지 리턴

