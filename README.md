# WareHouse Management System
Created Using Java Swing

Create the following database configuration from oracle sql command line and open the project in Netbeans.

 SQL> connect warehouse/123;
 Connected.
 SQL> desc admin;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 NAME                                               VARCHAR2(50)
 USERNAME                                  NOT NULL VARCHAR2(50)
 PASSWORD                                           VARCHAR2(50)

 SQL> desc sales;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 NAME                                               VARCHAR2(50)
 USERNAME                                  NOT NULL VARCHAR2(50)
 PASSWORD                                           VARCHAR2(50)

 SQL> desc item;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 ID                                                 NUMBER(38)
 NAME                                      NOT NULL VARCHAR2(50)
 BRAND                                              VARCHAR2(50)
 TYPE                                               VARCHAR2(50)
 QTY                                                NUMBER(38)
