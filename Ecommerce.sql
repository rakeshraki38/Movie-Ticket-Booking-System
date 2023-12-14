CREATE DATABASE ecommerce


CREATE TABLE customer (
  cid INT(11) NOT NULL,
  cname VARCHAR(100) ,
  email VARCHAR(100) ,
  pwd VARCHAR(100) ,
  phone BIGINT(20),
  address VARCHAR(200) ,
  PRIMARY KEY (cid),
  UNIQUE KEY phone (phone)
)

DESC customer

SELECT * FROM customer

DESC products

SELECT * FROM products

DROP TABLE customer
DROP TABLE PurchasedProduct

CREATE TABLE PurchasedProduct(
cid INT ,
pid INT,
dateofpurchase VARCHAR(100),
FOREIGN KEY (cid) REFERENCES customer (cid) ON DELETE CASCADE,    
FOREIGN KEY (pid) REFERENCES products (pid)ON DELETE CASCADE
);


DESC PurchasedProduct

SELECT * FROM PurchasedProduct


