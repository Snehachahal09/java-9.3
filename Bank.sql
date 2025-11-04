CREATE DATABASE bankdb;
USE bankdb;

CREATE TABLE account (
  account_id INT PRIMARY KEY,
  name VARCHAR(50),
  balance DOUBLE
);

INSERT INTO account VALUES
(101, 'Sneha', 10000),
(102, 'Riya', 8000);

CREATE TABLE transaction_record (
  txn_id INT PRIMARY KEY AUTO_INCREMENT,
  from_account INT,
  to_account INT,
  amount DOUBLE,
  status VARCHAR(20)
);
