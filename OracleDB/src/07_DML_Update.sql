--데이터 변경 - 수정(UPDATE)
--UPDATE 테이블명 SET 변경내용 WHERE 검색조건
update memberlist set age=30, phone = '010-0000-1111' where membernum=3;

--명령문에 where 이후 구문은 생략이 가능합니다.
-- 다만 이부분을 생략하면 모든 레코드를 대상으로해서 update 명령이 실행되어 모든 레코드가 수정됩니다.
-- 검색조건 : 필드명 (비교-관계연산자) 조건값으로 이루어진 조건연산이며, 흔히 자바에서 if()
-- if 괄호안에 사용했던 연산을 그대로 사용하는게 보통입니다.
-- 나이가 29세이상 -> where age >= 29
-- 두개이상의 필드를 수정하고자 한다면 (,)로 구분해서 기술합니다.
-- 복합 조건을 사용하고자 한다면 and, or 등을 사용합니다.(&& -> and, || -> or, ! -> Not)

SELECT * FROM BOOKLIST
select * from memberlist
SELECT * FROM rentlist
--booklist 테이블의 도서 제목 봉제인형 도서의 grade를 '18'으로 수정하세요
UPDATE BOOKLIST SET grade=18 where subject='봉제인형';
UPDATE BOOKLIST SET grade=18 where subject like '봉제인형%'; --봉제인형 시작하는거
UPDATE BOOKLIST SET grade=18 where subject like '%살인사건'; --살인사건 끝나는거
UPDATE BOOKLIST SET grade=18 where subject like '%인형%'; --인형 포함하는거

--booklist의 모든 도서의 대여가격(rentprice)를 10% 이상으로 인상한 값으로 수정하세요
--update booklist set rentprice=rentprice+(rentprice*0.1)
update booklist set rentprice=rentprice * 1.1

--memberlist에서 사은포인트(bpoint)가 300 이상인 회원의 bpoint에 30점을 가산해주세요
update memberlist set bpoint=bpoint+30 where bpoint >= 300

insert into memberlist(membernum,name,phone)
values(member_seq.nextval,'테스트','010-9999-1234');

--생년월일이 null인 회원의 생년월일을 2000-01-01로 age를 23으로 변경하세요
update memberlist set age=23,birth='2000-01-01' where birth is null -- = null은 안바뀜

--gender가 null인 회원의 gender를 'M'으로 변경하세요
update memberlist set gender='M' WHERE gender is null 

select * from booklist;

select * from rentlist;

update booklist set booknum = 5 where booknum=17;

--외래키로 참조되는 필드를 수정
update booklist set booknum=17 where booknum=7;
--rentlist에 bnum에 7번이 없다면 변경이 가능
--rentlist에 bnum에 7번이 있다면 변경이 불가능
--ORA-02292: integrity constraint (SCOTT.FK1) violated - child record found

--해결방법 #1 외래키를 지우고 해당 booknum과 bnum을 함께 수정한후 다시 외래키를 설정
--해결방법 #2 PL/SQL 의 트리거 기능을 이용해서 동시에 변경


-- 레코드의 삭제
-- delete from 테이블명 where 조건식
-- where 조건식이 생략되면 모든 레코드가 삭제됩니다.

--rentlist 테이블에서 discount가 10이하인 레코드를 삭제
delete from rentlist where discount<=10;

--삭제의 제한
delete from booklist where booknum=17; -- 삭제 실패
-- integrity constraint (SCOTT.FK1) violated - child record found

-- 해결방법 #1
-- 이를 해결하려면 우선 rentlist 테이블에 해당 도서 대여목록 레코드(child record)를 모두 삭제한 후
-- booklist 테이블에서 해당 도서를 삭제
delete from rentlist where bnum=17;
delete from booklist where booknum=17;

-- 해결방법 #2
-- 외래키 제약조건을 삭제한 후 다시 생성
-- 외래키 생성시에 "옵션을 추가해서"
-- "참조되는 값(parents recored)이 삭제되면 참조하는 값(child recored)도 같이 삭제" 되게 구성합니다.

--외래키 삭제
alter table rentlist drop constraint fk1;

-- 새로운 외래키 추가
alter table rentlist add constraint fk1
foreign key(bnum) references booklist(booknum) on delete cascade; -- 부모 테이블의 행을 삭제할 때, 해당 행을 참조하는 모든 자식 행들도 함께 자동으로 삭제되어 데이터의 일관성을 유지

--memberlist 테이블에서 회원 한명을 삭제하면, rentlist 테이블에서도 해당 회원이 대여한 기록을 같이 삭제하도록
--외래키 설정을 바꿔주세요(외래키 제약조건 삭제후 재생성)
alter table rentlist drop constraint fk2;
alter table rentlist add constraint fk2
foreign key(mnum) references memberlist(membernum) on delete cascade;

