use sqldb;

create table tbl1(
    a int primary key,
    b int,
    c int
);

-- tbl1이 가지고 있는 인덱스 조회
show index from tbl1;
