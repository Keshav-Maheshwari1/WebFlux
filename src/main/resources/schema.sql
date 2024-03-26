CREATE TABLE IF NOT EXISTS  book_details(
    book_id INT PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR(255) NOT NULL,
    book_desc Text,
    publisher VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL
);