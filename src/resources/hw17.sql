/*Какова средняя стоимость заказа? */
SELECT
    AVG(amount)
FROM
    orders;
    
/*Какова средняя стоимость заказа для каждого служащего? */

SELECT
    rep,
    AVG(amount)
FROM
    orders
GROUP BY
    rep;
    
/*Каков диапазон плановых объемов продаж для каждого офиса? */

SELECT
    rep_office,
    MIN(quota),
    MAX(quota)
FROM
    salesreps
GROUP BY
    rep_office;
    
/*Сколько служащих работают в каждом офисе? */

SELECT
    rep_office,
    COUNT(*)
FROM
    salesreps
GROUP BY
    rep_office;
    
/*Сколько клиентов обслуживает каждый служащий? */

SELECT
    COUNT(DISTINCT cust_num),
    'CUSTOMERS FOR SALESREPS',
    cust_rep
FROM
    customers
GROUP BY
    cust_rep;
    
/*Общее количество заказов по каждому клиенту для каждого служащего. */

SELECT
    rep,
    cust,
    SUM(amount)
FROM
    orders
GROUP BY
    rep,
    cust;
    
/*Общее количество заказов по каждому клиенту для каждого служащего; отсортировать результаты запроса по клиентам и служащим. */

SELECT
    rep,
    cust,
    SUM(amount)
FROM
    orders
GROUP BY
    rep,
    cust
ORDER BY
    rep,
    cust;
    
/*Общее количество заказов для каждого служащего. */

SELECT
    empl_num,
    name,
    SUM(amount)
FROM
    orders,
    salesreps
WHERE
    rep = empl_num
GROUP BY
    empl_num,
    name;

/*Общее количество заказов для каждого служащего. */

SELECT
    name,
    SUM(amount)
FROM
    orders,
    salesreps
WHERE
    rep = empl_num
GROUP BY
    name;
    
/*Create table coloris */

CREATE TABLE coloris (
    nm     VARCHAR2(50),
    hair   VARCHAR2(50),
    eyes   VARCHAR2(50)
);

COMMIT;

/*Insert values int coloris */

INSERT INTO coloris (
    nm,
    hair,
    eyes
) VALUES (
    'Cindy',
    'Brown',
    'Blue'
);

INSERT INTO coloris (
    nm,
    hair,
    eyes
) VALUES (
    'Louise',
    NULL,
    'Blue'
);

INSERT INTO coloris (
    nm,
    hair,
    eyes
) VALUES (
    'Harry',
    NULL,
    'Blue'
);

INSERT INTO coloris (
    nm,
    hair,
    eyes
) VALUES (
    'Samantha',
    NULL,
    NULL
);

INSERT INTO coloris (
    nm,
    hair,
    eyes
) VALUES (
    'Joanne',
    NULL,
    NULL
);

INSERT INTO coloris (
    nm,
    hair,
    eyes
) VALUES (
    'George',
    'Brown',
    NULL
);

INSERT INTO coloris (
    nm,
    hair,
    eyes
) VALUES (
    'Mary',
    'Brown',
    NULL
);

INSERT INTO coloris (
    nm,
    hair,
    eyes
) VALUES (
    'Paula',
    'Brown',
    NULL
);

INSERT INTO coloris (
    nm,
    hair,
    eyes
) VALUES (
    'Kevin',
    'Brown',
    NULL
);

INSERT INTO coloris (
    nm,
    hair,
    eyes
) VALUES (
    'Joel',
    'Brown',
    'Brown'
);

INSERT INTO coloris (
    nm,
    hair,
    eyes
) VALUES (
    'Susan',
    'Blonde',
    'Blue'
);

INSERT INTO coloris (
    nm,
    hair,
    eyes
) VALUES (
    'Marie',
    'Blonde',
    'Blue'
);

COMMIT;

/*Посчитать hair-eyes комбинации. */

SELECT
    hair,
    eyes,
    COUNT(*)
FROM
    coloris
GROUP BY
    hair,
    eyes;
    
/*Средняя стоимость заказа для каждого служащего из числа тех, у которых общая стоимость заказов превышает $300? */

SELECT
    rep,
    AVG(amount)
FROM
    orders
GROUP BY
    rep
HAVING
    SUM(amount) > 300;

/*Для каждого офиса, в котором работают два и более человек, вычислить общий плановый и фактический объем продаж для всех служащих офиса. */

SELECT
    city,
    SUM(quota),
    SUM(salesreps.sales)
FROM
    offices
    INNER JOIN salesreps ON office = rep_office
GROUP BY
    city
HAVING
    COUNT(*) >= 2;
    
/*Показать цену, количество на складе и общее количество заказанных единиц для каждого наименования товара, 
если для него общее количество заказанных единиц превышает 75 процентов от количества товара на складе. */

SELECT
    description,
    price,
    qty_on_hand,
    SUM(qty)
FROM
    products
    INNER JOIN orders ON mfr = mfr_id
GROUP BY
    mfr_id,
    product_id,
    description,
    price,
    qty_on_hand
HAVING
    SUM(qty) > ( 0.75 * qty_on_hand )
ORDER BY
    qty_on_hand DESC;

/* 1. Скільки яких товірів купляли (скільки штук і чого купили всього) */

SELECT
    products.description,
    orders.product,
    SUM(orders.qty)
FROM
    orders
    INNER JOIN products ON orders.product = products.product_id
GROUP BY
    orders.product,
    products.description;
    
/* 2. Вивести товари, які купили більше 3-оьх разів (були в трьох і більше замовленнях) */

SELECT
    products.description,
    COUNT(orders.product)
FROM
    products
    INNER JOIN orders ON products.product_id = orders.product
GROUP BY
    orders.product,
    products.description
HAVING
    COUNT(orders.product) > 3;
    
/* 3. Вивести офіси в яких працює більше трьох менеджерів */

SELECT
    offices.office,
    offices.city,
    COUNT(salesreps.rep_office)
FROM
    offices
    INNER JOIN salesreps ON offices.office = salesreps.rep_office
GROUP BY
    offices.office,
    offices.city
HAVING
    COUNT(salesreps.rep_office) > 3;
/*Варiант з пiдзапитом */

SELECT
    office,
    city,
    rep_office
FROM
    (
        SELECT
            offices.office,
            offices.city,
            COUNT(salesreps.rep_office) AS rep_office
        FROM
            offices
            INNER JOIN salesreps ON offices.office = salesreps.rep_office
        GROUP BY
            offices.office,
            offices.city
    ) of_city_count
WHERE
    of_city_count.rep_office > 3;
    
/* 4. Вивести середній вік по офісу */

SELECT
    offices.city,
    offices.office,
    AVG(salesreps.age)
FROM
    offices
    INNER JOIN salesreps ON offices.office = salesreps.rep_office
GROUP BY
    offices.office,
    offices.city;

/* 5. Дати перелік виробників що виготовляють більше 4-ьох товарів */

SELECT
    mfr_id,
    COUNT(product_id)
FROM
    products
GROUP BY
    mfr_id
HAVING
    COUNT(product_id) > 4;

/* 6. Дати загальну кільсть товарів, що зберігаються на складі по виробникам що виготовляють більше 4-ьох товарів */

SELECT
    mfr_id,
    SUM(qty_on_hand),
    COUNT(product_id)
FROM
    products
GROUP BY
    mfr_id
HAVING
    COUNT(product_id) > 4;

/* Варiант з пiдзапитом*/

SELECT
    products.mfr_id,
    SUM(qty_on_hand),
    COUNT(product_id)
FROM
    products
    INNER JOIN (
        SELECT
            mfr_id,
            COUNT(product_id)
        FROM
            products
        GROUP BY
            mfr_id
        HAVING
            COUNT(product_id) > 4
    ) mfr_more_4_prod ON products.mfr_id = mfr_more_4_prod.mfr_id
GROUP BY
    products.mfr_id;

/* 7. Вивести імя компанії, скільки вона тратила в середньому на покупки товарів виробників, котрі виготовляють більше 4-ьох товарів */

SELECT
    customers.cust_num,
    customers.company,
    AVG(orders.amount) AS avg_buys
FROM
    customers
    INNER JOIN orders ON customers.cust_num = orders.cust
    INNER JOIN (
        SELECT
            mfr_id,
            COUNT(product_id)
        FROM
            products
        GROUP BY
            mfr_id
        HAVING
            COUNT(product_id) > 4
    ) mfr_more_4_prod ON orders.mfr = mfr_more_4_prod.mfr_id
GROUP BY
    customers.cust_num,
    customers.company;
    
/*Варiант виводу з виробником, для перевiрки */

SELECT
    customers.cust_num,
    customers.company,
    AVG(orders.amount) AS avg_buys,
    orders.mfr
FROM
    customers
    INNER JOIN orders ON customers.cust_num = orders.cust
    INNER JOIN (
        SELECT
            mfr_id,
            COUNT(product_id)
        FROM
            products
        GROUP BY
            mfr_id
        HAVING
            COUNT(product_id) > 4
    ) mfr_more_4_prod ON orders.mfr = mfr_more_4_prod.mfr_id
GROUP BY
    customers.cust_num,
    customers.company,
    orders.mfr;
    
/*8. Вивести скільки мінімально і максимально замовлень (ордерів) виконували менеджери що мають в прямому підпорядкуванні більше двух людей*/

SELECT
    MIN(num_of_orders),
    MAX(num_of_orders)
FROM
    (
        SELECT
            COUNT(order_num) AS num_of_orders,
            orders.rep AS manager
        FROM
            orders
            INNER JOIN (
                SELECT
                    COUNT(sales1.empl_num),
                    sales1.empl_num
                FROM
                    salesreps   sales1
                    INNER JOIN salesreps   sales2 ON sales1.empl_num = sales2.manager
                GROUP BY
                    sales1.empl_num
                HAVING
                    COUNT(sales1.empl_num) > 2
            ) manager2x ON orders.rep = manager2x.empl_num
        GROUP BY
            orders.rep
    );
    
/*9. Знайти продукти в яких буква "а" зустрічається більше 2-ух раз */

SELECT
    *
FROM
    products
WHERE
    description LIKE '%а%а%а%';
    
/*на табличках girls|boys зробить insert|update|delete. По два запити кожного типу з різною логікою */

INSERT INTO boys (
    nm,
    name,
    city
) VALUES (
    '11',
    'Sanya',
    'Boston'
);

INSERT INTO boys (
    nm,
    name
) VALUES (
    '7',
    'Vitya'
);

UPDATE boys
SET
    city = 'Tokyo'
WHERE
    name = 'Vitya'
    OR name = 'Sanya';

UPDATE boys
SET
    city = 'Tokyo'
WHERE
    name = 'George'
    AND nm = '3';

DELETE FROM boys
WHERE
    city = 'Boston'
    AND name = 'Henry';

DELETE FROM boys
WHERE
    city = 'Tokyo'
    OR name = 'Sam';
    
/*зробити пару прикладів з селектами з під запитами, пару це три*/
/*Вывести список всех служащих, включая города и регионы, в которых они работают */

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
    
/*Вывести список всех заказов, в том числе и их стоимость и описание товаров */

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
    
/*Получить все комбинации служащих офисов, где плановый объем продаж служащего больше, чем план какого либо офиса*/

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