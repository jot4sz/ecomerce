CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE customer (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    name VARCHAR(80) NOT NULL,
    email VARCHAR(320) NOT NULL,
    phone VARCHAR(16) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    dateBirth DATE NOT NULL
);