select
    *
from
    usertbl
where
    name = '김경호';

select
    *
from
    usertbl
where
    birthYear >= 1970 AND
    height >= 182;

select
    *
from
    usertbl
where
    height BETWEEN 180 AND 183;

select
    *
from
    usertbl
where
    addr = '경남' OR addr = '전남' OR addr = '경북';

select
    *
from
    usertbl
where
    name LIKE '김%';

select
    name,
    height
from
    usertbl
where
    height > (select height from usertbl where name='김경호');

select
    *
from
    usertbl
order by mDate;

select
    *
from
    usertbl
order by mDate desc;

select *
from usertbl
order by height desc,
         name desc;

select
    DISTINCT(addr)
from
    usertbl
order by addr;