-- noinspection SqlDialectInspectionForFile
-- noinspection SqlNoDataSourceInspectionForFile
-- noinspection SqlDialectInspection
INSERT INTO PRODUCT (PRODUCT_NAME,PRODUCT_VALUE,PRODUCT_DESCRIPTION) VALUES ('Marchewka',25.0,'Marchewka, warzywo');
INSERT INTO PRODUCT (PRODUCT_NAME,PRODUCT_VALUE,PRODUCT_DESCRIPTION) VALUES ('Pietruszka',2.0,'Pietruszka, warzywo');
INSERT INTO PRODUCT (PRODUCT_NAME,PRODUCT_VALUE,PRODUCT_DESCRIPTION) VALUES ('Pomidor',5.0,'Pomidor, warzywo');
INSERT INTO PRODUCT (PRODUCT_NAME,PRODUCT_VALUE,PRODUCT_DESCRIPTION) VALUES ('Rzotkiewka',21.0,'Rzotkiewka, warzywo');
INSERT INTO PRODUCT (PRODUCT_NAME,PRODUCT_VALUE,PRODUCT_DESCRIPTION) VALUES ('Rukiew wodna',23.0,'Rzotkiewka, warzywo');
INSERT INTO PRODUCT (PRODUCT_NAME,PRODUCT_VALUE,PRODUCT_DESCRIPTION) VALUES ('Kapusta pekińska',28.0,'Rzotkiewka, warzywo');
INSERT INTO PRODUCT (PRODUCT_NAME,PRODUCT_VALUE,PRODUCT_DESCRIPTION) VALUES ('Boćwina',20.0,'Rzotkiewka, warzywo');
INSERT INTO PRODUCT (PRODUCT_NAME,PRODUCT_VALUE,PRODUCT_DESCRIPTION) VALUES ('Burak',45.0,'Rzotkiewka, warzywo');
INSERT INTO PRODUCT (PRODUCT_NAME,PRODUCT_VALUE,PRODUCT_DESCRIPTION) VALUES ('Szpinak',36.0,'Rzotkiewka, warzywo');

INSERT INTO ZTI_USER (USER_ID,LOGIN,PASSWORD) VALUES (1,'user','a5700387a0b64f00ff5fe28ee22eb088c2f684a7ad9645d231bdac76b9456c7f')
INSERT INTO USER_ROLE (USER_ID,ROLE) VALUES (1,'ROLE_DOMAIN_USER')
INSERT INTO USER_ROLE (USER_ID,ROLE) VALUES (1,'ROLE_ADMIN_USER')
INSERT INTO BASKET (BASKET_USER_ID) VALUES (1)