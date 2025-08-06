CREATE TABLE customer_order (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    payment_method VARCHAR(20) NOT NULL,
    status VARCHAR(20) NOT NULL,
    order_date DATE NOT NULL,
    total_price NUMERIC(8,2) NOT NULL,
    discount INTEGER,
    customer_id UUID NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customer(id) ON DELETE CASCADE
);