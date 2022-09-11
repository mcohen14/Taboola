CREATE TABLE product (
    name VARCHAR(255),
    category VARCHAR(255),
    added_by VARCHAR(255),
    added DATETIME,
);

CREATE TABLE product_price (
    name VARCHAR(255),
    price DOUBLE,
    discount INT DEFAULT 0,
    updated_by VARCHAR(255),
    updated DATETIME,
);

CREATE TABLE product_price_changelog (
    name VARCHAR(255),
    old_price DOUBLE,
    new_price DOUBLE,
    updated_by VARCHAR(255),
    updated DATETIME,
);

SELECT product.name, product.category, product_price.price, product_price.updated_by, product_price.updated
FROM product
JOIN product_price ON product.name=product_price.name
