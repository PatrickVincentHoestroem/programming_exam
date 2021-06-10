CREATE TABLE COMMUNE (ID INT, NAME VARCHAR(45));
CREATE TABLE PARISH (ID INT, CONTAMINATION_START VARCHAR(45), INFECTION_GROWTH INT, NAME VARCHAR(45), COMMUNE_ID INT);

INSERT INTO COMMUNE (ID, NAME) VALUES
(0, 'Dragør'),
(1, 'København K');

INSERT INTO PARISH (ID, CONTAMINATION_START, INFECTION_GROWTH, NAME, COMMUNE_ID) VALUES
(0, '22-05-2020', 3, 'St. Magleby', 0),
(1, '13-06-2020', 2, 'Frederiksberg', 1),
(2, '28-05-2020', 3, 'Taarnby', 0),
(3, '11-06-2020', 1, 'Svanemøllen', 1);