select
    name,
    Population
from
    city
where
    CountryCode = 'KOR'
order by Population desc;

select
    CountryCode,
    Population
from
    city
order by CountryCode,
         Population desc;

select
    count(*) AS '도시의 수'
from
    city
where
    CountryCode = 'KOR';

select
    Name
from
    city
where
    CountryCode = 'KOR' OR
    CountryCode = 'CHN' OR
    CountryCode = 'JPN';

select
    Name
from
    city
where
    CountryCode = 'KOR' AND
    Population >= 1000000;

select
    Name
from
    city
where
    CountryCode = 'KOR'
order by Population
limit 10;

select
    Name
from
    city
where CountryCode = 'KOR' AND
      Population BETWEEN 1000000 AND 5000000;
