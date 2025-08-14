CREATE TABLE product (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    brand VARCHAR(50) NOT NULL,
    description VARCHAR(1000) NOT NULL,
    price NUMERIC(8,2) NOT NULL,
    technical_info TEXT NOT NULL,
    available BOOLEAN NOT NULL
);