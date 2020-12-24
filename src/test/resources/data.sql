DROP TABLE IF EXISTS flightdetails;
CREATE TABLE flightdetails AS SELECT * FROM CSVREAD('classpath:tables/flight_info.csv');