CREATE TABLE orders (
    id VARCHAR(36) PRIMARY KEY,
    customer_id VARCHAR(50),
    product_name VARCHAR(100),
    quantity INT,
    total_price DECIMAL(10, 2),
    status VARCHAR(20),
    created_at TIMESTAMP NULL,
    updated_at TIMESTAMP NULL
);