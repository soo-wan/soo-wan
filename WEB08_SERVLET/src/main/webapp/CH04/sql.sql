CREATE TABLE MEMBERS(
	ID VARCHAR(10),
	NAME VARCHAR(15),
	PWD VARCHAR(20),
	PHONE VARCHAR(15)
);

INSERT INTO MEMBERS VALUES('SOMI', '이소미', '1234', '010-1234-1234');
INSERT INTO MEMBERS VALUES('SANG', '전상오', '1234', '010-5555-6666');
INSERT INTO MEMBERS VALUES('LIGHT', '김빛나', '1234', '010-2222-3333');

select * from members;

delete from members where name='';
delete from members where name is null;

