
SELECT product_id, product_code, product_name, list_price, discount_percent
FROM products
ORDER BY product_name ASC;

SELECT CONCAT(last_name, ', ', first_name) AS full_name
FROM customers
WHERE last_name >= 'N' AND last_name <= 'Z'
ORDER BY last_name DESC;

SELECT product_name, list_price, date_added
FROM products
WHERE list_price > 100 AND list_price < 2000
ORDER BY date_added ASC;

SELECT
    product_name,
    list_price,
    discount_percent,
    ROUND(list_price * discount_percent / 100, 2) AS discount_amount,
    ROUND(list_price - (list_price * discount_percent / 100), 2) AS discount_price
FROM products
ORDER BY discount_price DESC
LIMIT 5;

SELECT
    item_id,
    item_price,
    discount_amount,
    quantity,
    item_price * quantity AS price_total,
    discount_amount * quantity AS discount_total,
    (item_price - discount_amount) * quantity AS item_total
FROM Order_Items
WHERE (item_price - discount_amount) * quantity > 400
ORDER BY item_total DESC;

SELECT order_id, order_date, ship_date
FROM Orders
WHERE ship_date IS NULL;

SELECT
    NOW() AS today_unformatted,
    DATE_FORMAT(NOW(), '%d-%b-%Y') AS today_formatted;

SELECT
    100 AS price,
    0.07 AS tax_rate,
    100 * 0.07 AS tax_amount,
    100 + (100 * 0.07) AS total;

SELECT
    list_price,
    FORMAT(list_price, 2) AS formatted_price,
    CONVERT(list_price, SIGNED) AS converted_price,
    CAST(list_price AS SIGNED) AS cast_price
FROM products;

SELECT
    list_price,
    FORMAT(list_price, 2) AS formatted_price,
    CONVERT(list_price, SIGNED) AS converted_price,
    CAST(list_price AS SIGNED) AS cast_price
FROM products;
