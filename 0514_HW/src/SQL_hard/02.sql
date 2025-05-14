select
    sum(Population) as '인구수 총합'
from
    city
where
    CountryCode = 'KOR';

select
    MIN(Population) as 최소값
from
    city
where
    CountryCode = 'KOR';

select
    avg(Population) as 평균
from
    city
where
    CountryCode = 'KOR';

select
    MAX(Population) as 최대값
from
    city
where
    CountryCode = 'KOR';

select
    Name,
    char_length(Name) as 글자수
from
    country;

select concat(upper(substring(Name, 1, 3)), substring(Name, 4)) as 변환된이름
from country;

select
    round(LifeExpectancy,0)
from
    country;