use sqldb;

-- usertbl의 내용 확인
select * from usertbl;

-- usertbl의 인덱스 목록 확인
show index from usertbl;

-- usertbl의 데이터 크기와 인덱스의 크기 확인
show table status like 'usertbl';

-- usertbl의 addr 컬럼에 대해 idx_usertbl_addr이름으로 인덱스를 만들고
create index idx_usertbl_addr on usertbl(addr);
analyze table usertbl;
-- 인덱스 목록을 확인
show index from usertbl;

-- usertbl의 상태를 출력하여 인덱스의 내용이 만들어졌는지 확인
show table status like 'usertbl';

-- birthYear 컬럼에 대해 idx_usertbl_birthYear 이름의 인덱스를 만들기
create index idx_usertbl_birthYear on usertbl(birthYear);

-- name 컬럼에 대해 idx_usertbl_nam 이름의 인덱스 생성
create index idx_usertbl_name on usertbl(name);

-- 생성된 인덱스의 목록을 확인
show index from usertbl;

-- name 컬럼에 대한 보조 인덱스를 삭제
drop index idx_usertbl_name on usertbl;
show index from usertbl;

-- name과 birthYear 컬럼 조합으로 idx_usertbl_name_birthYear 이름의 인덱스를 생성
create unique index idx_usertbl_name_birthYear
on usertbl(name, birthYear);
show index from usertbl;

-- usertbl에서 앞에서 만든 인덱스를 삭제
drop index idx_usertbl_name_birthYear on usertbl;
show index from usertbl;