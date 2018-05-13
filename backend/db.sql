BEGIN TRANSACTION;
DROP TABLE IF EXISTS `WorkoutUser`;
CREATE TABLE IF NOT EXISTS `WorkoutUser` (
	`Id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	`UserId`	INTEGER NOT NULL,
	`WorkoutId`	INTEGER NOT NULL
);
DROP TABLE IF EXISTS `Workout`;
CREATE TABLE IF NOT EXISTS `Workout` (
	`Id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	`StartDate`	NUMERIC NOT NULL,
	`EndDate`	NUMERIC NOT NULL,
	`Name`	TEXT NOT NULL,
	`Location`	TEXT NOT NULL,
	`Places`	INTEGER,
	`WorkoutUserId`	INTEGER,
	`InstructorId`	INTEGER
);
DROP TABLE IF EXISTS `UserType`;
CREATE TABLE IF NOT EXISTS `UserType` (
	`Id`	INTEGER NOT NULL UNIQUE,
	`Name`	INTEGER NOT NULL,
	PRIMARY KEY(`Id`)
);
INSERT INTO `UserType` VALUES (1,'Admin');
INSERT INTO `UserType` VALUES (2,'Worker');
INSERT INTO `UserType` VALUES (3,'User');
DROP TABLE IF EXISTS `User`;
CREATE TABLE IF NOT EXISTS `User` (
	`Id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	`FirstName`	TEXT NOT NULL,
	`LastName`	TEXT NOT NULL,
	`Email`	TEXT NOT NULL,
	`Password`	TEXT NOT NULL,
	`UserTypeId`	INTEGER NOT NULL,
	`CardId`	INTEGER,
	`WorkoutUserId`	INTEGER
);
INSERT INTO `User` VALUES (1,'Jan','Kowalski','jk@gmail.com','jk123',3,'',NULL);
INSERT INTO `User` VALUES (2,'Joanna','Nowak','jn@gmail.com','jn123',3,NULL,NULL);
INSERT INTO `User` VALUES (3,'Oskar','Królik','ok@gmail.com','ok123',2,'',NULL);
INSERT INTO `User` VALUES (4,'Admin','Admin','aa@gmail.com','aa123',1,NULL,NULL);
DROP TABLE IF EXISTS `OpeningHours`;
CREATE TABLE IF NOT EXISTS `OpeningHours` (
	`Id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	`Day`	TEXT,
	`StartHour`	NUMERIC,
	`EndHour`	NUMERIC
);
DROP TABLE IF EXISTS `Instructors`;
CREATE TABLE IF NOT EXISTS `Instructors` (
	`Id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	`FirstName`	TEXT,
	`LastName`	TEXT,
	`Description`	TEXT
);
INSERT INTO `Instructors` VALUES (1,'Beata','Beatowa','The best instructor in the world');
DROP TABLE IF EXISTS `Club`;
CREATE TABLE IF NOT EXISTS `Club` (
	`Id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	`Address`	TEXT,
	`OpeningHoursId`	INTEGER
);
DROP TABLE IF EXISTS `CardInfo`;
CREATE TABLE IF NOT EXISTS `CardInfo` (
	`Id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	`Price`	NUMERIC,
	`Access`	TEXT,
	`Duration`	NUMERIC
);
DROP TABLE IF EXISTS `Card`;
CREATE TABLE IF NOT EXISTS `Card` (
	`Id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	`StartDate`	NUMERIC NOT NULL,
	`EndDate`	NUMERIC NOT NULL,
	`CardInfoId`	INTEGER
);
INSERT INTO `Card` VALUES (1,'','',NULL);
COMMIT;