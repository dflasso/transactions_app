INSERT INTO BANK_EXTERNAL("ID_BANK_EXTERNAL", "BE_NAME", "BE_LOGO") VALUES
    (1, 'BANCO X', 'https://w7.pngwing.com/pngs/223/204/png-transparent-bank-logo-bank-saving-bank-pic-building-structure-bank.png');

INSERT INTO EMPLOYEES("EM_ADMISSION_DATE","EM_CREATED_DATE","EM_LEAVING_DATE","EM_MODIFIED_DATE","ID_EMPLOYEE","EM_WORK_POSITION") VALUES
( PARSEDATETIME('2021-12-31-23.59.59','yyyy-MM-dd-HH.mm.ss'),  PARSEDATETIME('2021-12-31-23.59.59','yyyy-MM-dd-HH.mm.ss'), null,  PARSEDATETIME('2021-12-31-23.59.59','yyyy-MM-dd-HH.mm.ss'), 1, 'DESARROLLADOR'),
( PARSEDATETIME('2021-12-31-23.59.59','yyyy-MM-dd-HH.mm.ss'),  PARSEDATETIME('2021-12-31-23.59.59','yyyy-MM-dd-HH.mm.ss'), null,  PARSEDATETIME('2021-12-31-23.59.59','yyyy-MM-dd-HH.mm.ss'), 2, 'DESARROLLADOR');


INSERT INTO PERSONS (PR_CODE, PR_BIRTHDAY, PR_CREATED_DATE, PR_MODIFIED_DATE, PR_LASTNAMES, PR_NAMES, PR_TYPE, ID_EMPLOYEE  ) VALUES
    ('001384529', '1997-09-09', PARSEDATETIME('2020-08-07-00.00.00','yyyy-MM-dd-HH.mm.ss'), PARSEDATETIME('2021-12-31-23.59.59','yyyy-MM-dd-HH.mm.ss'), 'Pérez', 'Jaimito', 'CLIENTE', NULL),
    ('000000002', '1997-09-09', PARSEDATETIME('2020-08-07-00.00.00','yyyy-MM-dd-HH.mm.ss'), PARSEDATETIME('2021-12-31-23.59.59','yyyy-MM-dd-HH.mm.ss'), 'Suarez', 'Juan', 'CLIENTE', NULL),
    ('000000003', '1997-09-09', PARSEDATETIME('2020-08-07-00.00.00','yyyy-MM-dd-HH.mm.ss'), PARSEDATETIME('2021-12-31-23.59.59','yyyy-MM-dd-HH.mm.ss'), 'Bastidas', 'Pedro', 'CLIENTE', NULL),
    ('008283819', '1997-09-09', PARSEDATETIME('2020-08-07-00.00.00','yyyy-MM-dd-HH.mm.ss'), PARSEDATETIME('2021-12-31-23.59.59','yyyy-MM-dd-HH.mm.ss'), 'Mendoza', 'Luis', 'EMPLEADO', 1),
    ('000000005', '1997-09-09', PARSEDATETIME('2020-08-07-00.00.00','yyyy-MM-dd-HH.mm.ss'), PARSEDATETIME('2021-12-31-23.59.59','yyyy-MM-dd-HH.mm.ss'), 'Vaca', 'Angela', 'EMPLEADO', 2);


INSERT INTO BANK_ACCOUNT (BANK_ACCOUNT_NUM, PERSON_CODE, BA_CREATED_DATE, BA_MODIFIED_DATE,BA_STATUS,BA_TYPE,BA_IS_EXTERNAL, ID_BANK_EXTERNAL ) VALUES
    ('0000000001', '001384529', PARSEDATETIME('2020-08-07-00.00.00','yyyy-MM-dd-HH.mm.ss'), PARSEDATETIME('2021-12-31-23.59.59','yyyy-MM-dd-HH.mm.ss'), 'ACTIVA', 'AHORROS', 0, NULL ),
    ('0000000002', '008283819', PARSEDATETIME('2020-08-07-00.00.00','yyyy-MM-dd-HH.mm.ss'), PARSEDATETIME('2021-12-31-23.59.59','yyyy-MM-dd-HH.mm.ss'), 'ACTIVA', 'AHORROS', 0, NULL ),
    ('0000000003', '000000003', PARSEDATETIME('2020-08-07-00.00.00','yyyy-MM-dd-HH.mm.ss'), PARSEDATETIME('2021-12-31-23.59.59','yyyy-MM-dd-HH.mm.ss'), 'ACTIVA', 'AHORROS', 0, NULL ),
    ('0000000004', '000000002', PARSEDATETIME('2020-08-07-00.00.00','yyyy-MM-dd-HH.mm.ss'), PARSEDATETIME('2021-12-31-23.59.59','yyyy-MM-dd-HH.mm.ss'), 'ACTIVA', 'AHORROS', 0, NULL ),
    ('0000000005', '000000005', PARSEDATETIME('2020-08-07-00.00.00','yyyy-MM-dd-HH.mm.ss'), PARSEDATETIME('2021-12-31-23.59.59','yyyy-MM-dd-HH.mm.ss'), 'ACTIVA', 'AHORROS', 0, NULL ),
    ('0000000006', NULL, PARSEDATETIME('2020-08-07-00.00.00','yyyy-MM-dd-HH.mm.ss'), PARSEDATETIME('2021-12-31-23.59.59','yyyy-MM-dd-HH.mm.ss'), 'ACTIVA', 'AHORROS', 1, 1 );

INSERT INTO TRANSACTIONS (ID_TRANSACTIONS, TR_AMOUNT, TR_COMMISSION, TR_IVA, BANK_ACCOUNT_DESTINY, BANK_ACCOUNT_ORIGIN, PR_CREATED_DATE, TR_DESCRIPTION) VALUES
    (1, 10000, 0, 0, '0000000001', '0000000006', PARSEDATETIME('2020-08-07-00.00.00','yyyy-MM-dd-HH.mm.ss'), 'Apertura de cuenta' ),
    (2, 10000, 0, 0, '0000000002', '0000000006', PARSEDATETIME('2020-08-08-00.00.00','yyyy-MM-dd-HH.mm.ss'), 'Apertura de cuenta' ),
    (3, 10000, 0, 0, '0000000003', '0000000006', PARSEDATETIME('2020-08-09-00.00.00','yyyy-MM-dd-HH.mm.ss'), 'Apertura de cuenta' ),
    (4, 10000, 0, 0, '0000000004', '0000000006', PARSEDATETIME('2020-08-10-00.00.00','yyyy-MM-dd-HH.mm.ss'), 'Apertura de cuenta' ),
    (5, 10000, 0, 0, '0000000005', '0000000006', PARSEDATETIME('2020-08-11-00.00.00','yyyy-MM-dd-HH.mm.ss'), 'Apertura de cuenta' ),
    (6, 500, 0, 0, '0000000002','0000000001', PARSEDATETIME('2020-08-12-00.00.00','yyyy-MM-dd-HH.mm.ss'), 'Pago por servicios' ),
    (7, 600, 0, 0, '0000000003', '0000000002', PARSEDATETIME('2020-08-13-00.00.00','yyyy-MM-dd-HH.mm.ss'), 'Pago por servicios' ),
    (8, 300, 0, 0, '0000000004', '0000000003', PARSEDATETIME('2020-08-14-00.00.00','yyyy-MM-dd-HH.mm.ss'), 'Pago por servicios' ),
    (9, 200, 0, 0, '0000000004', '0000000005', PARSEDATETIME('2020-08-15-00.00.00','yyyy-MM-dd-HH.mm.ss'), 'Pago por servicios' ),
    (10, 600, 0, 0, '0000000001', '0000000005', PARSEDATETIME('2020-08-16-00.00.00','yyyy-MM-dd-HH.mm.ss'), 'Pago por servicios' ),
    (11, 1000, 0, 0, '0000000002', '0000000003', PARSEDATETIME('2020-08-17-00.00.00','yyyy-MM-dd-HH.mm.ss'), 'Deudas pendientes' ),
    (12, 1100, 0, 0, '0000000003', '0000000004', PARSEDATETIME('2020-08-18-00.00.00','yyyy-MM-dd-HH.mm.ss'), 'Deudas pendientes' ),
    (13, 1500, 0, 0, '0000000001', '0000000003', PARSEDATETIME('2020-08-19-00.00.00','yyyy-MM-dd-HH.mm.ss'), 'Salario' ),
    (14, 10, 0, 0, '0000000004', '0000000001', PARSEDATETIME('2020-08-20-00.00.00','yyyy-MM-dd-HH.mm.ss'), 'Compra Online' ),
    (16, 12, 0.4, 0.36, '0000000006', '0000000001', PARSEDATETIME('2020-08-21-00.00.00','yyyy-MM-dd-HH.mm.ss'), 'Transferencia a otro banco' ),
    (17, 80, 0, 0, '0000000001', '0000000003', PARSEDATETIME('2020-08-22-00.00.00','yyyy-MM-dd-HH.mm.ss'), 'Ahorro' ),
    (18, 2000, 0, 0, '0000000002', '0000000003', PARSEDATETIME('2020-08-23-00.00.00','yyyy-MM-dd-HH.mm.ss'), 'Salario' ),
    (19, 200, 0, 0, '0000000003', '0000000002', PARSEDATETIME('2020-08-24-00.00.00','yyyy-MM-dd-HH.mm.ss'), 'Compra Online' ),
    (20, 12, 0.4, 0.36, '0000000006', '0000000002', PARSEDATETIME('2020-08-25-00.00.00','yyyy-MM-dd-HH.mm.ss'), 'Transferencia a otro banco' ),
    (21, 80, 0, 0, '0000000002', '0000000003', PARSEDATETIME('2020-08-26-00.00.00','yyyy-MM-dd-HH.mm.ss'), 'Ahorro' );