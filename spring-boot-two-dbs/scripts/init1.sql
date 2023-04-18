create table PRODUCT (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100),
  price DECIMAL(7, 2),
  description VARCHAR(500)
);

INSERT INTO PRODUCT VALUES (1, 'Phone', 999.99, 'Super new mobile phone!');
INSERT INTO PRODUCT VALUES (2, 'Charger', 9.99, 'If you have phone, you definitely need this charger!');
INSERT INTO PRODUCT VALUES (3, 'TV', 2999.99, 'Extra thin TV fits to every home!');