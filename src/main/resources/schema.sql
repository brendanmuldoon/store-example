CREATE TABLE tool(
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Description CHAR(20) NOT NULL UNIQUE,
    Hire_price DECIMAL NOT NULL
);

CREATE TABLE store(
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Name CHAR(35) NOT NULL,
    Post_code CHAR(8) NOT NULL UNIQUE
);