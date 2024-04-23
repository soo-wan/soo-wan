--mysql 시퀀스가 따로 없음. 알아서 들어감. 아주 좋구먼 
 
insert into scott.booklist( subject, makeyear, inprice, rentprice, grade )
values( '좀비아이',  2020, 12000, 2500, 'all');
insert into scott.booklist( subject, makeyear, inprice, rentprice, grade )
values( '일곱해의 마지막',  2020, 12150, 2000, 'all');
insert into scott.booklist( subject, makeyear, inprice, rentprice, grade )
values('봉제인형 살인사건',  2020, 12000, 2500, '13');
insert into scott.booklist( subject, makeyear, inprice, rentprice, grade )
values('쇼코의 미소',  2019, 10800, 2500, '18');
insert into scott.booklist( subject, makeyear, inprice, rentprice, grade )
values('가면산장 살인사건',  2018, 13320, 1500, '13');
insert into scott.booklist( subject, makeyear, inprice, rentprice, grade )
values('나미야 잡화점의 기적',  2017, 13320, 2000, '18');
insert into scott.booklist( subject, makeyear, inprice, rentprice, grade )
values('유튜브영상편집',  2020, 20700, 2500, 'all');
insert into scott.booklist( subject, makeyear, inprice, rentprice, grade )
values('이것이자바다',  2017, 30000, 3000, '18');
insert into scott.booklist( subject, makeyear, inprice, rentprice, grade )
values('JSP웹프로그래밍',  2016, 25000, 2500, '13');
insert into scott.booklist( subject, makeyear, inprice, rentprice, grade )
values('오라클데이터베이스',  2020, 30000, 3000, 'all');


insert into scott.memberlist( name, phone, birthday, bpoint, age, gender)
values('박지성', '010-1111-2222', '1981/04/04', 140, 29, 'F');
insert into scott.memberlist( name, phone, birthday, bpoint, age, gender)
VALUES('구자철', '010-1111-2222', '82/05/05', 230, 25, 'M');
insert into scott.memberlist( name, phone, birthday, bpoint, age, gender)
VALUES( '지동원', '010-1111-2222', '83/06/06', 150, 35, 'F');
insert into scott.memberlist( name, phone, birthday, bpoint, age, gender)
VALUES('추신수', '010-1111-2222', '84/07/07', 240, 28, 'M');
insert into scott.memberlist( name, phone, birthday, bpoint, age, gender)
VALUES('손흥민', '010-1111-2222',  '82/09/23', 220, 23, 'M');
insert into scott.memberlist( name, phone, birthday, bpoint, age, gender)
VALUES( '구자철', '010-1111-2222',  '82/05/05', 230, 25, 'M');
insert into scott.memberlist( name, phone, birthday, bpoint, age, gender)
VALUES('이청용', '010-1111-2222','81/06/14', 440, 36, 'F');
insert into scott.memberlist( name, phone, birthday, bpoint, age, gender)
VALUES('이영표', '010-1111-2222', '82/03/16', 140, 31, 'M');
insert into scott.memberlist( name, phone, birthday, bpoint, age, gender)
VALUES('최지만', '010-1111-2222', '83/04/14', 340, 29, 'F');
insert into scott.memberlist( name, phone, birthday, bpoint, age, gender)
VALUES('홍길동', '010-1111-2222','80/06/05', 240, 30, 'M');


insert into scott.rentlist( bnum, mnum, discount) values( 1, 1, 100);
insert into scott.rentlist( bnum, mnum, discount) values( 1, 10, 100);
insert into scott.rentlist( bnum, mnum, discount) values( 2, 9, 100);
insert into scott.rentlist( bnum, mnum, discount) values( 3, 9, 100);
insert into scott.rentlist( bnum, mnum, discount) values( 2, 7, 100);
insert into scott.rentlist( bnum, mnum, discount) values( 5, 7, 100);
insert into scott.rentlist( bnum, mnum, discount) values( 6, 5, 100);
insert into scott.rentlist( bnum, mnum, discount) values( 7, 5, 100);
insert into scott.rentlist( bnum, mnum, discount) values( 9, 3, 100);
insert into scott.rentlist( bnum, mnum, discount) values( 9, 10, 100);
insert into scott.rentlist( bnum, mnum, discount) values( 10, 1, 100);

select * from booklist
select * from memberlist
select * from rentlist