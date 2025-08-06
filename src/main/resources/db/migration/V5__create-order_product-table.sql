CREATE TABLE order_product (
    product_id UUID NOT NULL,
    order_id UUID NOT NULL,
    quantity INTEGER NOT NULL,

    FOREIGN KEY (product_id) REFERENCES product(id) ON DELETE CASCADE,
    FOREIGN KEY (order_id) REFERENCES customer_order(id) ON DELETE CASCADE
);