

CREATE TABLE users (
	id				INT PRIMARY KEY,
	first_name		VARCHAR2(20) NOT NULL,
    last_name		VARCHAR2(20) NOT NULL,
    acct_created	TIMESTAMP DEFAULT SYSTIMESTAMP,
    last_active		TIMESTAMP DEFAULT SYSTIMESTAMP,
	user_name		VARCHAR2(20) NOT NULL,
    password;		VARCHAR2(20) NOT NULL,
    email;			VARCHAR2(40) NOT NULL,
    sec_lvl			INT NOT NULL DEFAULT 1,
    is_active		BOOLEAN DEFAULT TRUE
);

CREATE TABLE income (
	id				INT PRIMARY KEY,
    income_name		VARCHAR2(20) NOT NUULL,
    recieved		BOOLEAN DEFAULT FALSE,
    due_on			TIMESTAMP,
    recieved_on		TIMESTAMP,
    recurring		BOOLEAN DEFAULT TRUE,
    amount_expected	CURRENCY DEFAULT 0.00,
    amount_actual	CURRENCY DEFAULT 0.00,
    user_Id 		REFERENCES users(id)
);

CREATE TABLE expenses (
	id				INT PRIMARY KEY,
    name			VARCHAR2(20) NOT NUULL,
    paid			BOOLEAN DEFAULT FALSE,
    due_by			TIMESTAMP,
    paid_on			TIMESTAMP,
    recurring		BOOLEAN DEFAULT TRUE,
    amount_due		CURRENCY DEFAULT 0.00,
);



