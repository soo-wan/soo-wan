SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS cart;
DROP TABLE IF EXISTS order_detail;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS qna;
DROP TABLE IF EXISTS member;
DROP TABLE IF EXISTS product;




/* Create Tables */

CREATE TABLE address
(
	zip_num varchar(15) NOT NULL,
	sido varchar(30) NOT NULL,
	gugun varchar(30) NOT NULL,
	dong varchar(30) NOT NULL,
	bunji varchar(20),
	zip_code varchar(30)
);


CREATE TABLE cart
(
	cseq int NOT NULL AUTO_INCREMENT,
	quantity int NOT NULL,
	indate datetime DEFAULT now() NOT NULL,
	pseq int NOT NULL,
	userid varchar(45) NOT NULL,
	PRIMARY KEY (cseq)
);


CREATE TABLE member
(
	userid varchar(45) NOT NULL,
	pwd varchar(45) NOT NULL,
	name varchar(45) NOT NULL,
	phone varchar(45) NOT NULL,
	email varchar(100) NOT NULL,
	zip_num varchar(15),
	address1 varchar(100),
	address2 varchar(100),
	indate datetime DEFAULT now() NOT NULL,
	useryn char(1) DEFAULT 'Y' NOT NULL,
	PRIMARY KEY (userid)
);


CREATE TABLE orders
(
	oseq int NOT NULL AUTO_INCREMENT,
	indate datetime DEFAULT now() NOT NULL,
	userid varchar(45) NOT NULL,
	PRIMARY KEY (oseq)
);


CREATE TABLE order_detail
(
	odseq int NOT NULL AUTO_INCREMENT,
	oseq int NOT NULL,
	pseq int NOT NULL,
	quantity int NOT NULL,
	result char(1),
	PRIMARY KEY (odseq)
);


CREATE TABLE product
(
	pseq int NOT NULL AUTO_INCREMENT,
	name varchar(100) NOT NULL,
	kind char(1) NOT NULL,
	price1 int NOT NULL,
	price2 int NOT NULL,
	price3 int NOT NULL,
	content varchar(500) NOT NULL,
	image varchar(100) NOT NULL,
	savefilename varchar(200) NOT NULL,
	bestyn char(1) DEFAULT 'N' NOT NULL,
	useyn char(1) DEFAULT 'Y' NOT NULL,
	indate datetime DEFAULT now() NOT NULL,
	PRIMARY KEY (pseq)
);


CREATE TABLE qna
(
	qseq int NOT NULL AUTO_INCREMENT,
	userid varchar(45) NOT NULL,
	subject varchar(100) NOT NULL,
	content varchar(1000) NOT NULL,
	reply varchar(1000),
	indate datetime DEFAULT now() NOT NULL,
	PRIMARY KEY (qseq)
);



/* Create Foreign Keys */

ALTER TABLE cart
	ADD FOREIGN KEY (userid)
	REFERENCES member (userid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE orders
	ADD FOREIGN KEY (userid)
	REFERENCES member (userid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE qna
	ADD FOREIGN KEY (userid)
	REFERENCES member (userid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE order_detail
	ADD FOREIGN KEY (oseq)
	REFERENCES orders (oseq)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE cart
	ADD FOREIGN KEY (pseq)
	REFERENCES product (pseq)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE order_detail
	ADD FOREIGN KEY (pseq)
	REFERENCES product (pseq)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;

CREATE TABLE admins
(
	adminid varchar(30) NOT NULL,
	pwd varchar(30) NOT NULL,
	name varchar(30) NOT NULL,
	phone varchar(30) NOT NULL,
	PRIMARY KEY (adminid)
);
