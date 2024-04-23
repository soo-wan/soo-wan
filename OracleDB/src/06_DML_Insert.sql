--DML (Data Management Language) 데이터 조작 언어

--테이블에 레코드를 조작(추가, 수정, 삭제, 조회)하기 위한 명령어들
--INSERT(추가)
--UPDATE(수정)
--DELETE(삭제)
--SELECT(조회 및 선택)

--[1] 샘플 테이블 생성
create table exam01(
	deptno number(2),
	dname varchar2(15),
	loc varchar2(15)
);

--[2] 레코드 

-- 레코드 추가 방법 #1
insert into 테이블이름(필드명1, 필드명2, 필드명3, ....) values(값1, 값2, 값3, ....);

-- 레코드 추가 방법 #2
insert into 테이블이름(값1, 값2, 값3, ....);

-- #1과 #2의 차이점
-- #1 : 필드명과 입력되어야 하는 값들이 1:1 매칭되어 입력됩니다.
--     	    필드명의 순서는 반드시 지켜야하는 것은 아니지만 나열된 필드명대로 값들 순서는 맞춰서 입력합니다.
insert into exam01(deptno, dname, loc) values('기획부', 10, '서울'); X
insert into exam01(deptno, dname, loc) values(10, '기획부', '서울'); O
insert into exam01(loc, deptno, dname) values('서울', 10, '기획부'); O
-- 		null 값을 허용하는 필드나, default 값이 있는 필드는 생략하고 입력할 수 있습니다.
insert into exam01(deptno, dname) values(10,'기획부'); o --loc null로 들어감

SELECT * FROM EXAM01
--DELETE FROM EXAM01

-- #2 모든 필드에 해당하는 값들을 최초에 테이블 생성시에 기술한 필드 순서에 맞게 모두 입력하는 방법입니다.
insert into exam01 values(10, '기획부', '서울'); O
-- #2 null을 허용하는곳을 비우고 입력할 수 없으며, null 이라도 직접 지정해야합니다.
insert into exam01 values(10, null, '서울'); O

-- #1과 #2 공통으로 숫자는 그냥 쓰고, 문자는 작은 따옴표로 묶어서 표현합니다.

SELECT * FROM BOOKLIST
--delete from booklist; --테이블내의 모든 레코드를 삭제하는 명령

-- 위 두가지 방법 중 자유롭게 선택하여서, booklist 테이블에 10개의 레코드를 추가해주세요.
--booknum은 시퀀스를 이용합니다.
--grade는 'all' '12' '18' 세가지만 골라서 입력해주세요. 자신이 만든 테이블에 grade가 없으면 입력하지 않아도 됩니다.

insert into booklist values(book_seq.nextval, '일곱해', 2020, 12150,2000,'all');
insert into booklist values(book_seq.nextval, '봉제인형', 2019, 7700,2500,'all');
insert into booklist values(book_seq.nextval, '쇼코의 미소', 2023, 8800,3000,'all');
insert into booklist values(book_seq.nextval, '좀비아이', 2020, 9900,3500,18);
insert into booklist values(book_seq.nextval, '가면산장', 2018, 11100,2700,'all');
insert into booklist values(book_seq.nextval, '나미야', 2017, 10000,4200,'all');
insert into booklist values(book_seq.nextval, '유투브 영상편집', 2020, 12000,1800,18);
insert into booklist values(book_seq.nextval, '이것이자바다', 2020, 27000,1900,18);
insert into booklist values(book_seq.nextval, 'jsp', 2017, 30000,1100,12);
insert into booklist values(book_seq.nextval, '오라클db', 2016, 25000,5500,'all');

--memberlist에 10명의 데이터를 추가해주세요. (member_seq 이용)
insert into memberlist values(member_seq.nextval, '추신수', '010-5666-1234', '84/01/07', 240, 'M', 33);
insert into memberlist values(member_seq.nextval,'류현진','010-1111-1234','85/02/07',140,'M',30);
insert into memberlist values(member_seq.nextval,'김현수','010-2222-1234','86/03/07',320,'F',24);
insert into memberlist values(member_seq.nextval,'오지환','010-7120-3382','87/04/07',230,'M',21);
insert into memberlist values(member_seq.nextval,'오스틴','010-4444-1234','81/05/07',120,'F',23);
insert into memberlist values(member_seq.nextval,'이정후','010-5555-1234','82/06/07',150,'M',25);
insert into memberlist values(member_seq.nextval,'김하성','010-3303-9455','92/07/07',160,'F',26);
insert into memberlist values(member_seq.nextval,'홍창기','010-7777-1234','94/08/07',170,'M',27);
insert into memberlist values(member_seq.nextval,'박해민','010-8888-1234','95/09/07',180,'M',28);
insert into memberlist values(member_seq.nextval,'고우석','010-9999-1234','97/07/07',240,'F',29);

SELECT * FROM EXAM01
SELECT * FROM BOOKLIST
select * from memberlist
SELECT * FROM rentlist

--rentlist 테이블도 rent_seq를 이용해서 10개의 데이터를 추가해주세요.
CREATE SEQUENCE rent_seq START WITH 1 INCREMENT by 1;

INSERT INTO rentlist values(rent_seq.nextval, '2021/10/01',17,1,100);
INSERT INTO rentlist values(rent_seq.nextval, '2021/08/01',18,2,300);
INSERT INTO rentlist values(rent_seq.nextval, '2023/10/01',19,3,400);
INSERT INTO rentlist values(rent_seq.nextval, '2021/07/01',20,4,500);
INSERT INTO rentlist values(rent_seq.nextval, '2024/09/01',21,5,600);
INSERT INTO rentlist values(rent_seq.nextval, '2021/06/01',22,6,700);
INSERT INTO rentlist values(rent_seq.nextval, '2021/05/01',15,7,800);
INSERT INTO rentlist values(rent_seq.nextval, '2021/02/01',16,8,1000);
INSERT INTO rentlist values(rent_seq.nextval, '2021/09/01',23,9,1100);
INSERT INTO rentlist values(rent_seq.nextval, '2021/03/01',24,10,300);

INSERT INTO rentlist values(rent_seq.nextval, '2021/03/01',70,16,300);--실패, 제약조건 걸려있어서 있는 번호 넣어야함.

commit -- 현재창에서 commit은 세미콜론을 붙이지 않습니다. 단일 명령이고 다른 명령과 함께 사용하지 않는 다는 뜻입니다.

-- 데이터베이스 백업명령
exp userid=scott/tiger file = abc.dmp log=abc.log

-- 데이터베이스 복원명령
imp userid=scott/tiger file = abc.dmp log=abc.log full=y

-- 오라클의 백업 명령과 복원 명령은 모두 command 창에서 실행합니다.
exp 