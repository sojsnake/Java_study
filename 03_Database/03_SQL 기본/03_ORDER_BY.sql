-- ORDER BY
-- SELECT 문과 함께 사용하며 결과 집합을 특정 열이나 값들에 따라 정렬하는 데 사용됨.

select
    emp_no,
    first_name,
    last_name
from
    employees
order by
    -- emp_no asc;
    -- emp_no desc;
    emp_no; -- 디폴트로 오름차순 정렬

-- 컬럼에 따라 정렬을 여러 번 할 수 있다.
-- first_name 기준으로 정렬, 만약 같은 순위 있으면 last_name 기준으로 정렬
select
    emp_no,
    first_name,
    last_name
from
    employees
order by
    -- emp_no asc;
    -- emp_no desc;
    first_name desc,
    last_name;