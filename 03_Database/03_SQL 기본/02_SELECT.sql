-- SELECT
-- 특정 테이블에서 원하는 데이터를 조회할 수 있다.

select
    *
from
    buytbl;

select
    userID,
    groupName
from buytbl;

select(5+5);

-- 현재 시간 출력
select now();

-- as로 컬럼에 별칭 사용
select concat('bear', '안녕', 'kb') as 인사;

select
    name,
    concat(mobile1, mobile2) as 전화번호
from usertbl;

