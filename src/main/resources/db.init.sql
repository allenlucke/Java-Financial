

CREATE TABLE users (
	id				INT PRIMARY KEY,
	first_name		VARCHAR2(20) NOT NULL,
    last_name		VARCHAR2(20) NOT NULL,
    acct_created	TIMESTAMP DEFAULT SYSTIMESTAMP,
    last_active		TIMESTAMP DEFAULT SYSTIMESTAMP,
	user_name		VARCHAR2(20) NOT NULL,
    password		VARCHAR2(20) NOT NULL,
    email			VARCHAR2(40) NOT NULL,
    sec_lvl			INT DEFAULT 1 NOT NULL,
    is_active		VARCHAR2(5) DEFAULT 'TRUE'
);

CREATE TABLE income (
	id				INT PRIMARY KEY,
    income_name		VARCHAR2(20) NOT NULL,
    recieved		VARCHAR2(5) DEFAULT 'FALSE',
    due_on			TIMESTAMP,
    recieved_on		TIMESTAMP,
    recurring		VARCHAR2(5) DEFAULT 'TRUE',
    amount_expected	NUMBER(12,2) DEFAULT 0.00,
    amount_actual	NUMBER(12,2) DEFAULT 0.00,
    users_id 		INT NOT NULL,
      
    FOREIGN KEY (users_id)
      REFERENCES users(id)
);

CREATE TABLE expenses (
	id				INT PRIMARY KEY,
    name			VARCHAR2(20) NOT NULL,
    paid			VARCHAR2(5) DEFAULT 'FALSE',
    due_by			TIMESTAMP,
    paid_on			TIMESTAMP,
    recurring		VARCHAR2(5) DEFAULT 'TRUE',
    amount_due		NUMBER(1,2) DEFAULT 0.00
);



