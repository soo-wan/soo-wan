CREATE TABLE `board`.`board` (
  `num` INT NOT NULL AUTO_INCREMENT,
  `pass` VARCHAR(45) NOT NULL,
  `userid` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `content` VARCHAR(1000) NOT NULL,
  `readcount` INT NULL DEFAULT 0,
  `writedate` DATETIME NULL DEFAULT now(),
  PRIMARY KEY (`num`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


CREATE TABLE `board`.`member` (
  `userid` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `pwd` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`userid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

select * from member
insert into member values('hong1', '홍길동', '1234', 'hong1@naver.com', '010-1234-1234');
insert into member values('hong2', '홍길서', '1234', 'hong2@naver.com', '010-3234-1234');
insert into member values('hong3', '홍길남', '1234', 'hong3@naver.com', '010-2234-1234');

insert into board(pass, userid, email, title, content) values('1234', 'hong1', 'hong1@naver.com', '첫방문입니다', '반갑습니다 ㅎ2');
insert into board(pass, userid, email, title, content) values('1234', 'hong2', 'hong2@naver.com', '돼지골마을', '삼겹살 꿀맛 ㅇㅈ');
insert into board(pass, userid, email, title, content) values('1234', 'hong3', 'hong3@naver.com', '게시판 개설', '축하해 기원할게');
insert into board(pass, userid, email, title, content) values('1234', 'hong1', 'hong1@naver.com', '2024년 겨울', '몹시추워 건강조심');
insert into board(pass, userid, email, title, content) values('1234', 'hong2', 'hong2@naver.com', '맛집공유', '맛집공유해줘');
insert into board(pass, userid, email, title, content) values('1234', 'hong1', 'hong1@naver.com', '첫방문입니다', '반갑습니다 ㅎ2');
insert into board(pass, userid, email, title, content) values('1234', 'hong2', 'hong2@naver.com', '돼지골마을', '삼겹살 꿀맛 ㅇㅈ');
insert into board(pass, userid, email, title, content) values('1234', 'hong3', 'hong3@naver.com', '게시판 개설', '축하해 기원할게');
insert into board(pass, userid, email, title, content) values('1234', 'hong1', 'hong1@naver.com', '2024년 겨울', '몹시추워 건강조심');
insert into board(pass, userid, email, title, content) values('1234', 'hong2', 'hong2@naver.com', '맛집공유', '맛집공유해줘');

select * from member

select * from board limit 10 offset 10;

CREATE TABLE `board`.`reply` (
  `replynum` INT NOT NULL,
  `boardnum` INT NOT NULL,
  `userid` VARCHAR(45) NOT NULL,
  `writedate` DATETIME NOT NULL DEFAULT now(),
  `content` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`replynum`),
  INDEX `f1_idx` (`boardnum` ASC) VISIBLE,
  INDEX `f2_idx` (`userid` ASC) VISIBLE,
  CONSTRAINT `f1`
    FOREIGN KEY (`boardnum`)
    REFERENCES `board`.`board` (`num`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `f2`
    FOREIGN KEY (`userid`)
    REFERENCES `board`.`member` (`userid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

ALTER TABLE `board`.`reply` 
CHANGE COLUMN `replynum` `replynum` INT NOT NULL AUTO_INCREMENT ;

alter table board add column image varchar(50);
alter table board add column savefilename varchar(50);

select * from board order by 1 desc;

select * from reply
--Field 'replynum' doesn't have a default value
insert into reply(replynum,boardnum, userid, content) values(1,6, 'hong1', '방갑습니다 수고하세요');
insert into reply(replynum,boardnum, userid, content) values(2,6, 'hong2', '또 뵐게요 안녕히가세요');
insert into reply(boardnum, userid, content) values(6, 'hong3', '또 뵐게요 안녕히가세요2');