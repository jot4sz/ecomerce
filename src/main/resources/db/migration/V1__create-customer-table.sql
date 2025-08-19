CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE customer (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    full_name VARCHAR(80) NOT NULL,
    email VARCHAR(320) UNIQUE NOT NULL,
    phone VARCHAR(16) NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    date_birth DATE NOT NULL
);