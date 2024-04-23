--[문항1]  화면에 보이는 제약사항을 적용하여 테이블을 작성하세요. 두테이블간의 외래키 관계를 설정하세요.  --
--그리고 해당 테이블에 임의의 값으로 레코드 3개씩을 추가하세요. 
--테이블 생성 및 레코드 추가시에 사용한 SQL 파일과 조회화면 캡쳐파일을 제출하세요 
--그리고 테이블의 외래키 관계설정을 설명합니다

--외래키 관계 설정 설명 : member 테이블에 기본키로 userid를 설정 
create table member(
	userid varchar(30),
	pwd varchar(30) not null,
	name varchar(30) not null,
	phone varchar(30),
	email varchar(30), 
	constraint member_pk primary key (userid)
);

--외래키 관계 설정 설명 : board 테이블에 기본키로 boardnum을 설정
create table board(
	boardnum int AUTO_INCREMENT, 
	writer varchar(30),
	subject varchar(100) not null,
	content varchar(1000) not null,
	writedate datetime DEFAULT now(),
	readcount int DEFAULT 0, 
	constraint board_pk primary key (boardnum)
);

--외래키 관계 설정 설명 : board 테이블에 writer가 member 테이블의 userid를 참조합니다. (delete,update casecade)
  ALTER TABLE `scott`.`board` 
ADD CONSTRAINT `FK1`
  FOREIGN KEY (`writer`)
  REFERENCES `scott`.`member` (`userid`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
  
  DROP TABLE BOARD

  
 insert into member values( 'user1',  '1234', '홍길동', '010-1111-2222', 'hong@naver.com');
 insert into member values( 'user2',  '2134', '홍길남', '010-2222-7777', 'hong2@naver.com');
 insert into member values( 'user3',  '4234', '홍길서', '010-3333-4444', 'hong3@naver.com');
 
 insert into board(writer, subject, content, writedate) values('user1', '제목1', '내용1', '2024-04-01');
 insert into board(writer, subject, content, writedate) values('user2', '제목2', '내용2', '2024-04-02');
 insert into board(writer, subject, content, writedate) values('user3', '제목3', '내용3', '2024-04-03');
  
 update member set email="hong1@naver.com" where email="hong@naver.com"
select * from member;
select * from board;

--[문항1]  JDBC 프로그램으로 board 테이블과 Member 테이블을 조인한 결과를 열람하도록 작성하세요. 
--작성한 자바클래스파일과 결과화면 캡쳐파일을 제출합니다. (board 테이블의 필드들과 작성자의 이름과 이메일을 같이 출력) 그리고 조인구조에 대해 설명합니다

--조인 구조 : 참조 하고 있는 board 테이블 writer와 member테이블 userid를 서로 조인시켜 테이블을 조회합니다.
CREATE OR REPLACE VIEW boardDetail AS
    SELECT a.*, b.*
    FROM board a, member b
    WHERE a.writer = b.userid 
    
  select * from boardDetail