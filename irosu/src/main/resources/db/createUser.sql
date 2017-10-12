CREATE TABLE users(
	id 	INTEGER IDENTITY PRIMARY KEY,
	name 	VARCHAR(30),
	email 	VARCHAR(50),
	birthDate	VARCHAR(15),
	country 	VARCHAR(50),
	password	VARCHAR(30)
);