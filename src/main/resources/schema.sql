CREATE TABLE IF NOT EXISTS users (
  firstName VARCHAR(255) NOT NULL,
  middleName VARCHAR(255) NOT NULL DEFAULT "",
  lastName VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL PRIMARY KEY,
  password VARCHAR(255) NOT NULL,
  role VARCHAR(63) NOT NULL DEFAULT "ROLE_USER",
  address VARCHAR(511)
);

CREATE TABLE IF NOT EXISTS category (
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  categoryName VARCHAR(256) NOT NULL,
  supplierName VARCHAR(256) NOT NULL
);

CREATE TABLE IF NOT EXISTS Product (
  MRP INT NOT NULL,
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  productName VARCHAR(255) NOT NULL UNIQUE,
  productImage VARCHAR(255) NOT NULL,
  size VARCHAR(255) NOT NULL,
  categoryId BIGINT NOT NULL,
  quantityAvailable INT NOT NULL,
  details VARCHAR(255) NOT NULL,
  FOREIGN KEY (categoryId) REFERENCES category(id)
);

CREATE TABLE IF NOT EXISTS orders (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  orderDate DATE NOT NULL,
  total INT NOT NULL,
  orderStatus VARCHAR(40) NOT NULL,
  userEmail VARCHAR(255),
  deliveryAddress VARCHAR(512),
  contact VARCHAR(255),
  FOREIGN KEY (userEmail) REFERENCES users(email)
);

CREATE TABLE IF NOT EXISTS storeExpenditure (
  transactionId BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  transactionDate DATE NOT NULL,
  amount INT NOT NULL,
  summary VARCHAR(256),
  userEmail VARCHAR(255) NOT NULL,
  FOREIGN KEY (userEmail) REFERENCES users(email)
);


CREATE TABLE IF NOT EXISTS cart (
  userEmail VARCHAR(255) NOT NULL,
  productId BIGINT NOT NULL,
  quantity INT NOT NULL,
  PRIMARY KEY (userEmail, productId),
  FOREIGN KEY (userEmail) REFERENCES users(email),
  FOREIGN KEY (productId) REFERENCES Product(id)
);

CREATE TABLE IF NOT EXISTS UserPhoneNumber (
  phoneNumber INT NOT NULL,
  email VARCHAR(255) NOT NULL,
  FOREIGN KEY (email) REFERENCES users(email),
  UNIQUE (phoneNumber, email)
);

CREATE TABLE IF NOT EXISTS OrderItem (
  orderId BIGINT NOT NULL,
  productId BIGINT NOT NULL,
  quantity INT NOT NULL,
  PRIMARY KEY (orderId, productId),
  FOREIGN KEY (orderId) REFERENCES orders(id),
  FOREIGN KEY (productId) REFERENCES Product(id)
);

CREATE TABLE IF NOT EXISTS Offer (
  startDate DATE NOT NULL,
  endDate DATE NOT NULL,
  discount INT NOT NULL,
  offerCode VARCHAR(255) NOT NULL PRIMARY KEY,
  freebies VARCHAR(255),
  productID BIGINT NOT NULL,
  FOREIGN KEY (ProductID) REFERENCES Product(Id)
);

CREATE TABLE IF NOT EXISTS CartItem (
  productQuantity INT NOT NULL,
  productId BIGINT NOT NULL,
  cartID BIGINT NOT NULL,
  FOREIGN KEY (productId) REFERENCES Product(Id),
  FOREIGN KEY (cartId) REFERENCES cart(id)
);