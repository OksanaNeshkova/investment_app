INSERT INTO employee (id,address, email, first_name, last_name, password, personal_code, phone_number, role)
VALUES
(1,'example address', 'example@example2.com', 'emp1', 'emp1', '$2a$10$EBqP6XZ6i0djqpUFY3HzEuvCAIO4pf7HUYwBNjQzaaaKdopmZeJxu', 1234567896, '123-456-7890', 'ROLE_USER'),
(2,'example address', 'example@example1.com', 'root', 'root', '$2a$10$HaIKS7V9PbZidD/CKmFtS.GGW36HoOXiGSfSh5WFovmmYKGdp51li', 1234567846, '123-456-7890', 'ROLE_ADMIN');

INSERT INTO share (id, company_name, country, currency, economic_field, share_name, symbol)
VALUES
(1,'Apple Inc.', 'US', 'USD', 'Technology', 'Apple Inc', 'AAPL'),
(2,'American Assets Trust, Inc.', 'US', 'USD', 'Real Estate', 'American Assets Trust', 'AAT'),
(3,'Microsoft Corporation', 'US', 'USD', 'Technology', 'Microsoft', 'MSFT');

INSERT INTO transaction (id, trade_date, fx, purchase_price, transaction_type, trading_volume, employee_id, share_id)
VALUES
(1,'2023-11-04 02:00:00.000000', 1.25, 102.5, 'PURCHASE', 500, 2, 1),
(2,'2023-11-04 11:34:31.278000', 1.25, 102.5, 'PURCHASE', 50000, 2, 3),
(3,'2023-11-04 11:34:49.646000', 1.25, 102.5, 'SALE', 10000, 1, 3),
(4,'2023-11-04 11:35:21.438000', 1.25, 102.5, 'PURCHASE', 10000, 1, 2);