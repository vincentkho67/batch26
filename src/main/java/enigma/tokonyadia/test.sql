SELECT t.id, c.name AS customer_name, p.name
AS product_name, td.price, td.quantity FROM transactions t
JOIN transaction_details td ON t.id = td.transaction_id
JOIN customers c ON c.id = t.customer_id
JOIN products p ON p.id = td.product_id;