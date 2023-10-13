CREATE TABLE book
(
    id           INT AUTO_INCREMENT NOT NULL,
    isbn         VARCHAR(20)  NOT NULL,
    name         VARCHAR(120) NOT NULL,
    author       VARCHAR(120) NULL,
    publisher    VARCHAR(120) NULL,
    num_of_pages INT          NOT NULL,
    CONSTRAINT pk_book PRIMARY KEY (id)
);

CREATE TABLE reader
(
    id         INT AUTO_INCREMENT NOT NULL,
    first_name VARCHAR(30) NOT NULL,
    last_name  VARCHAR(30) NOT NULL,
    yob        INT NULL,
    status     VARCHAR(255) NULL,
    CONSTRAINT pk_reader PRIMARY KEY (id)
);

INSERT INTO book VALUES (1, 'ISBN121212', 'A Journey To The Stars', 'Matt Zhang', 'New York Times', 122);
INSERT INTO book VALUES (2, 'ISBN131313', 'Brown Is Beautiful', 'Helen Whiskey', 'KOA Daily', 92);
INSERT INTO book VALUES (3, 'ISBN133202', 'The Universe In A Nutshell', 'Stephen Hawking', 'Bantam Spectra', 224);
