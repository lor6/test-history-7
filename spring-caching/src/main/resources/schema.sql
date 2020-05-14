CREATE TABLE CUSTOMER(
  CUSTOMERID INT PRIMARY KEY,
  CUSTOMERNAME VARCHAR(250) NOT NULL
);

CREATE TABLE ITEM(
ITEMID INT PRIMARY KEY,
ITEMDESC VARCHAR(250),
PRICE DOUBLE
);

CREATE TABLE ORDERDETAIL(
ORDERID INT PRIMARY KEY,
CUSTOMERID INT NOT NULL,
ITEMID INT NOT NULL,
QUANTITY INT,
FOREIGN KEY (customerid) references CUSTOMER(customerid),
FOREIGN KEY (itemid) references ITEM(itemid)
);