-- Initialize the sales database
-- This script runs automatically when the MySQL container starts for the first time

USE
sales;

-- Create customer table (if not auto-created by Hibernate)
CREATE TABLE if NOT EXISTS customer
(
    id
    BIGINT
    AUTO_INCREMENT
    PRIMARY
    KEY,
    NAME
    VARCHAR
(
    255
) NOT NULL,
    email VARCHAR
(
    255
),
    address VARCHAR
(
    500
)
    ) ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;

-- Insert sample data for testing
INSERT INTO customer (name, email, address)
VALUES ('John Doe', 'john.doe@example.com', '123 Main Street, New York, NY 10001'),
       ('Jane Smith', 'jane.smith@example.com', '456 Oak Avenue, Los Angeles, CA 90001'),
       ('Robert Johnson', 'robert.johnson@example.com', '789 Pine Road, Chicago, IL 60601'),
       ('Emily Davis', 'emily.davis@example.com', '321 Elm Street, Houston, TX 77001'),
       ('Michael Wilson', 'michael.wilson@example.com', '654 Maple Drive, Phoenix, AZ 85001');

-- Create index on email for faster searches
CREATE INDEX idx_customer_email ON customer (email);

-- Create index on name for faster searches
CREATE INDEX idx_customer_name ON customer (name);
