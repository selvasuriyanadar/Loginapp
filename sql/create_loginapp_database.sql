/***********************************************************
* Create the database named loginapp, its tables, and a user
************************************************************/

DROP DATABASE IF EXISTS loginapp;

CREATE DATABASE loginapp;

USE loginapp;

CREATE TABLE User (
  Username varchar(15) NOT NULL PRIMARY KEY,
  Password varchar(15) NOT NULL
);

-- Create loginapp_user and grant privileges

DELIMITER //
CREATE PROCEDURE drop_user_if_exists()
BEGIN
    DECLARE userCount BIGINT DEFAULT 0 ;

    SELECT COUNT(*) INTO userCount FROM mysql.user
    WHERE User = 'loginapp_user' and  Host = 'localhost';

    IF userCount > 0 THEN
        DROP USER loginapp_user@localhost;
    END IF;
END ; //
DELIMITER ;

CALL drop_user_if_exists() ;

CREATE USER loginapp_user@localhost IDENTIFIED BY 'sesame';

GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP
ON loginapp.*
TO loginapp_user@localhost;

