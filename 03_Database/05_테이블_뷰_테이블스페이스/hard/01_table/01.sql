use tabledb;

drop table if exists buytbl;
drop table if exists userTBL;
create table userTBL(
    userID char(8) not null primary key,
    name varchar(10) not null,
    birthyear int not null
);

create table buyTBL
(
    num    int auto_increment  not null primary key,
    userID      char(8) not null,
    prodName char(6)         not null
);

-- ALTER를 이용해 userID를 외래키로 수정
alter table buyTBL
add constraint fk_user
foreign key (userID) references usertbl(userID);

show create table buyTBL;
alter table buyTBL
    drop foreign key fk_user;
drop table if exists userTBL;
create table userTBL
(
    userID    char(8)     not null primary key,
    name      varchar(10),
    birthyear int CHECK (birthyear >= 1900 AND birthyear <= 2023),
    mobile    varchar(3)  not null
);



DROP TABLE IF EXISTS userTBL;

CREATE TABLE userTBL (
                         userID    CHAR(8)     NOT NULL PRIMARY KEY,
                         name      VARCHAR(10) NOT NULL,
                         birthYear INT         NOT NULL DEFAULT -1,
                         addr      CHAR(2)     NOT NULL DEFAULT '서울',
                         mobile1   CHAR(3)     NULL,
                         mobile2   CHAR(8)     NULL,
                         height    SMALLINT    NULL     DEFAULT 170,
                         mDate     DATE        NULL
);

-- default작성 시 DEFAULT로 설정된 값을 자동 입력
INSERT INTO usertbl VALUES ('LHL', '이혜리', default, default, '011', '1234567', default, '2023.12.12');

-- 열 이름이 명시되지 않으면 DEFAULT로 설정된 값을 자동 입력
INSERT INTO usertbl(userID, name) VALUES('KAY', '김아영');

-- 값이 직접 작성되면 DEFAULT로 설정된 값은 무시
INSERT INTO usertbl VALUES ('WB', '원빈', 1982, '대전', '019', '9876543', 176,'2020.5.5');

alter table usertbl
drop column mobile1;

alter table usertbl
change column name uName varchar(20);

alter table usertbl
drop primary key;