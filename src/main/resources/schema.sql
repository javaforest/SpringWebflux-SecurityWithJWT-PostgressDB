CREATE TABLE IF NOT EXISTS person (
    id SERIAL PRIMARY KEY,
    firstname VARCHAR(100),
    lastname VARCHAR(100)
);
CREATE TABLE IF NOT EXISTS userdata
(
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(50)   NOT NULL,
    last_name VARCHAR(50)  NOT NULL,
    password VARCHAR(500)  NOT NULL,
    address VARCHAR(100)  NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL,
    roles VARCHAR [] NOT NULL,
    enabled boolean DEFAULT true
);