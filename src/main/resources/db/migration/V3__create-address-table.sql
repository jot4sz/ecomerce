CREATE TABLE address (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    cep VARCHAR(8) NOT NULL,
    street VARCHAR(50) NOT NULL,
    city VARCHAR(50) NOT NULL,
    uf VARCHAR(2) NOT NULL,
    complement VARCHAR(50),
    number NUMERIC(5) NOT NULL,
    default_address BOOLEAN,
    customer_id UUID NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customer(id) ON DELETE CASCADE
);