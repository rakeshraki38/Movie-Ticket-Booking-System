CREATE DATABASE Movie

USE movie

CREATE TABLE AddManager(
mname VARCHAR(100),
email VARCHAR(100),
mobile BIGINT,
street VARCHAR(100),
city VARCHAR(100),
username VARCHAR(100),
mpassword VARCHAR(100));

SELECT * FROM addmanager

DESC addmanager

CREATE TABLE AddUser(
uid INT PRIMARY KEY AUTO_INCREMENT,
uname VARCHAR(100),
Address VARCHAR(100),
mobile BIGINT,
email VARCHAR(100),
upassword VARCHAR(100));

SELECT * FROM adduser


CREATE TABLE addtheatre (
    theatre_id INT PRIMARY KEY AUTO_INCREMENT,
    theatrename VARCHAR(255) NOT NULL,
    theatretype VARCHAR(255),
    numberofscreens INT,
    contactnumber VARCHAR(20),
    enteremail VARCHAR(255),
    entercity VARCHAR(255),
    address TEXT
);

SELECT * FROM addtheatre

CREATE TABLE screentimings (
    timing_id INT PRIMARY KEY AUTO_INCREMENT,
    theatre_id INT,
    theatrename VARCHAR(255),
    screen INT,
    showtime TIME,
    showname VARCHAR(255),
    FOREIGN KEY (theatre_id) REFERENCES addtheatre (theatre_id));



SELECT * FROM screentimings

CREATE TABLE screenseats (
    seat_id INT PRIMARY KEY AUTO_INCREMENT,
    theatre_id INT,
    theatrename VARCHAR(255),
    screen INT,
    cost DECIMAL(8, 2),
    totalseats INT,
    availseats VARCHAR(100),
    FOREIGN KEY (theatre_id) REFERENCES addtheatre (theatre_id)
);


SELECT * FROM screenseats

CREATE TABLE addmovie (
    movie_id INT PRIMARY KEY AUTO_INCREMENT,
    theatre_id INT,
    theatrename VARCHAR(255),
    screen INT,
    shows INT,
    moviename VARCHAR(255),
    startdate DATE,
    enddate DATE,
    FOREIGN KEY (theatre_id) REFERENCES addtheatre (theatre_id)
);
SELECT * FROM addmovie

**************************************************************

CREATE TABLE booktickets(
NAME VARCHAR(100),
mobile VARCHAR(100),
num_tickets VARCHAR(100),
book_date VARCHAR(100)
)
****************************




  

















