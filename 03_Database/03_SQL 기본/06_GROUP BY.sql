/*
Group by
- 결과 집합을 특정 열의 값에 따라 그룹화 하는데 사용됨
*/

select
    *
from
    salaries
limit 1;

-- 직원별로 급여 횟수는?
select
    emp_no,
    count(*) as 급여횟수,
    sum(salary) as 총급여,
    avg(salary) as 평균급여
from
    salaries
group by emp_no;

/*
Having
- group by와 함께 사용됨
- 그룹화된 결과에 조건을 적용할 때 사용
*/

select
    emp_no,
    count(*) as 급여횟수,
    sum(salary) as 총급여,
    avg(salary) as 평균급여
from
    salaries
group by emp_no
having 평균급여 >= 50000 and 평균급여 <= 60000;