create or replace PROCEDURE POSTIncome
(
	income_name		IN TYPES.CHAR10,
	recieved		IN BOOLEAN,
	due_on			IN TIMESTAMP,
	recieved_on		IN TIMESTAMP,
	recurring		IN BOOLEAN,
	amount_expected IN CURRENCY,
	amount_actual	IN CURRENCY,
	userId			IN INT,
	P_CURSOR		IN OUT SYS_REFCURSOR
)
AS
	VINNAM CHAR (10) := DEFAULT '';
	VRECVD BOOLEAN := DEFAULT FALSE;
	VDUEON TIMESTAMP := TO_TIMESTAMP('9999-12-31-23.59.59.999999', 'YYYY-MM-DD-HH24.MI.SS.FF6');
	VRECON TIMESTAMP := TO_TIMESTAMP('9999-12-31-23.59.59.999999', 'YYYY-MM-DD-HH24.MI.SS.FF6');
	VRCURG BOOLEAN := DEFAULT FALSE;
	VAMEXP CURRENCY := DEFAULT 0.00;
	VAMACT CURRENCY := DEFAULT 0.00;
	VUSRID INT := DEFAULT 1;
	SQLSTR VARCHAR2 (2000) DEFAULT '';


BEGIN
	
	IF (RTRIM(income_name)IS NOT NULL)THEN
		VINNAM := income_name;
	END IF;
	IF(RTRIM(recieved)IS NOT NULL)THEN
		VRECVD := recieved;
	END IF;
	IF(RTRIM(due_on)IS NOT NULL)THEN
		VDUEON := due_on;
	ELSE
		VDUEON := SYSTIMESTAMP + INTERVAL '30' DAY;
	END IF;
	IF(RTRIM(recieved_on)IS NOT NULL) THEN
		VRECON := recieved_on;
	END IF;
	IF(RTRIM(recurring)IS NOT NULL) THEN
		VRCURG := recurring;
	END IF;
	IF (RTRIM(amount_expected)IS NOT NULL)THEN
		VAMEXP := amount_expected;
	END IF;
	IF(RTRIM(amount_actual)IS NOT NULL)THEN
		VAMACT:= amount_actual;
	END IF;
	IF(RTRIM(userId)IS NOT NULL)THEN
		VUSRID := userId;
	END IF;

	
	SQLSTR := SQLSTR || 'INSERT INTO Income(income_name, recieved,due_on,recieved_on, ';
 	SQLSTR := SQLSTR || 'recurring, amount_expected, amount_actual, userId)';
 	SQLSTR := SQLSTR || 'VALUES(:VINNAM, :VRECVD, :VDUEON, :VRECON, :VRCURG, :VAMEXP, :VAMACT, :VUSRID)'

	
	
	OPEN P_CURSOR
	FOR SQLSTR
	USING
	
END;