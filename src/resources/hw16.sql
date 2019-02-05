/* вывести информацию про заказчиков которые купили продукты с буквой а */
SELECT
    *
FROM
    customers cs1
WHERE
    EXISTS (
        SELECT DISTINCT
            company
        FROM
            customers   cs
            INNER JOIN orders      os ON cs.cust_rep = os.rep
            INNER JOIN products    ps ON os.product = ps.product_id
        WHERE
            ps.description LIKE '%a%'
            OR ps.description LIKE '%а%'
            OR ps.description LIKE '%A%'
            OR ps.description LIKE '%А%'
    );

SELECT
    order_num,
    amount,
    company,
    credit_limit
FROM
    (
        SELECT
            *
        FROM
            orders
            INNER JOIN customers ON orders.cust = customers.cust_num
    );

SELECT
    name,
    city,
    region
FROM
    (
        SELECT
            *
        FROM
            salesreps
            INNER JOIN offices ON salesreps.rep_office = orders.office
    );

SELECT
    city,
    name,
    title
FROM
    (
        SELECT
            *
        FROM
            offices
            INNER JOIN salesreps ON offices.mgr = salesreps.empl_num
    )
WHERE
    target > 600.00;

SELECT
    order_num,
    amount,
    description
FROM
    (
        SELECT
            *
        FROM
            orders
            INNER JOIN products ON orders.mfr = products.mfr_id
                                   AND orders.product = products.product_id
    );

SELECT
    order_num,
    amount,
    company,
    name
FROM
    (
        SELECT
            *
        FROM
            orders
            INNER JOIN customers ON orders.cust = customers.cust_num
            INNER JOIN salesreps ON orders.rep = salesreps.empl_num
    )
WHERE
    amount > 700;

SELECT
    order_num,
    amount,
    company,
    name
FROM
    (
        SELECT
            *
        FROM
            orders
            INNER JOIN customers ON orders.cust = customers.cust_num
            INNER JOIN salesreps ON customers.cust_rep = salesreps.empl_num
    )
WHERE
    amount > 700;

SELECT
    order_num,
    amount,
    company,
    name,
    city
FROM
    (
        SELECT
            *
        FROM
            orders
            INNER JOIN customers ON orders.cust = customers.cust_num
            INNER JOIN salesreps ON customers.cust_rep = salesreps.empl_num
            INNER JOIN offices ON salesreps.rep_office = offices.office
    )
WHERE
    amount > 700;

SELECT
    order_num,
    amount,
    order_date,
    name
FROM
    (
        SELECT
            *
        FROM
            orders
            INNER JOIN salesreps ON orders.order_date = salesreps.hire_date
    );

SELECT
    name,
    quota,
    city,
    target
FROM
    (
        SELECT
            *
        FROM
            salesreps
            INNER JOIN offices ON salesreps.quota > offices.target
    )
WHERE
    quota > target;

SELECT
    name,
    sales,
    city
FROM
    (
        SELECT
            *
        FROM
            salesreps
            INNER JOIN (
                SELECT
                    city,
                    office
                FROM
                    offices
            ) ON salesreps.rep_office = office
    );

SELECT
    *
FROM
    salesreps
    INNER JOIN offices ON salesreps.rep_office = offices.office;

SELECT
    salesreps.*,
    city,
    region
FROM
    salesreps
    INNER JOIN offices ON salesreps.rep_office = offices.office;

SELECT
    s1.name,
    s2.name
FROM
    salesreps   s1
    INNER JOIN salesreps   s2 ON s1.manager = s2.empl_num;

SELECT
    s1.name,
    s1.quota,
    s2.quota
FROM
    salesreps   s1
    INNER JOIN salesreps   s2 ON s1.manager = s2.empl_num
                               AND s1.quota > s2.quota;

SELECT
    s1.name,
    o1.city,
    s2.name,
    o2.city
FROM
    salesreps   s1
    INNER JOIN offices     o1 ON s1.rep_office = o1.office
    INNER JOIN salesreps   s2 ON s1.manager = s2.empl_num
    INNER JOIN offices     o2 ON s1.rep_office <> s2.rep_office
                             AND s2.rep_office = o2.office;

SELECT
    AVG(quota),
    AVG(sales)
FROM
    salesreps;

SELECT
    AVG(100 *(sales / quota))
FROM
    salesreps;

SELECT
    AVG(100 *(sales / quota)) procent
FROM
    salesreps;

SELECT
    SUM(quota),
    SUM(sales)
FROM
    salesreps;

SELECT
    SUM(amount)
FROM
    orders
    INNER JOIN salesreps ON orders.rep = salesreps.empl_num
WHERE
    name = 'Дима Маликов';

SELECT
    AVG(price)
FROM
    products
WHERE
    mfr_id = 'ACI';

SELECT
    AVG(amount)
FROM
    orders
WHERE
    cust = 2103;

SELECT
    MIN(quota),
    MAX(quota)
FROM
    salesreps;

SELECT
    MIN(order_date)
FROM
    orders;

SELECT
    MAX(100 *(sales / quota))
FROM
    salesreps;

SELECT
    COUNT(cust_num)
FROM
    customers;

SELECT
    COUNT(name)
FROM
    salesreps
WHERE
    sales > quota;

SELECT
    COUNT(amount)
FROM
    orders
WHERE
    amount > 250;

SELECT
    COUNT(*)
FROM
    orders
WHERE
    amount > 250;

SELECT
    AVG(amount),
    SUM(amount),
    ( 100 * AVG(amount / credit_limit) ),
    ( 100 * AVG(amount / quota) )
FROM
    orders
    INNER JOIN customers ON orders.cust = customers.cust_num
    INNER JOIN salesreps ON orders.rep = salesreps.empl_num;