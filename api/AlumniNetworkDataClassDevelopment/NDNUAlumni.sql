-- NDNU Alumni
-- version 2
--
-- Host: localhost
-- Generation Time: Feb 06, 2015 @ 7:50 PM
--
-- Authors: Eric & Ryan
--

DROP DATABASE IF EXISTS NDNUAlumni;

CREATE DATABASE IF NOT EXISTS NDNUAlumni;

USE NDNUAlumni;

--
-- Database: 'NDNUAlumni'
--

DROP TABLE IF EXISTS project;
CREATE TABLE Projects (
  ProjectID int(5) NOT NULL ,
  ProjectName varchar(40) NOT NULL default '',
  ProjectYear int default NULL,
  ProjectAbstracts text default NULL,
  PRIMARY KEY  (ProjectID),
  UNIQUE KEY ProjectID (ProjectID)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table 'Projects'

INSERT INTO Projects (ProjectID, ProjectName, ProjectYear, ProjectAbstracts) VALUES
('00001', 'First Project Ever', '2000', 'This the first Senior Project in the List'),
('00002', 'Second Project', '2001', 'Second Project Ever. Getting a little better at this')
('00003', 'Third Project', '2002', 'Third time is a charm')
('00004', 'Fourth Project', '2003', 'This is the fourth project')
('00005', 'Fifth Project', '2004', 'This is the fifth project')
('00006', 'Sixth Project', '2005', 'This is the sixth project')
('00007', 'Seventh Project', '2006', 'This is the Seventh project')
('00008', 'Eighth Project', '2007', 'This is the Eighth project')
('00009', 'Ninth Project', '2008', 'This is the Ninth project')
('00010', 'Tenth Project', '2009', 'This is the Tenth project');

--
-- Table structure for table 'Users'
--

DROP TABLE IF EXISTS Users;
CREATE TABLE Users (
  UserId int(5) NOT NULL,
  ProjectId int(5),
  FirstName varchar(30) default NULL,
  LastName varchar(50) default NULL,
  GradYear int(4) default NULL,
  Major varchar(40) default NULL,
  PhoneNumber varchar(12) default NULL,
  Email varchar(70) default NULL,
  City varchar(30) default NULL,
  State varchar(20) default NULL,
  Description text default NULL,
  Page varchar(255) default NULL,
  PRIMARY KEY (UserId),
  UNIQUE KEY user_id (UserId),
  FOREIGN Key (ProjectId) REFERENCES Projects(ProjectId)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- Dumping date for table 'Users'
-- 

INSERT INTO Users (UserID, ProjectId, FirstName, LastName, GradYear, Major, PhoneNumber, Email, City, State, Description, Page) VALUES
('00001', '00001', 'John', 'Snow', '2001', 'Software Engineering', '415-555-0001', 'JohnSnow@gmail.com', 'Castle Black', 'The Wall', 'Lord Commander of the Nights Watch', 'http://www.facebook.com/JohnSnow'),
('00002', '00004', 'Arya', 'Stark', '2003', 'Software Engineering', '415-555-0002', 'AryaHorseface@gmail.com', 'House of Black and White', 'Bravos', 'Acolite of the House of Black and White', 'http://www.facebook.com/AryaStark')
('00003', '00001', 'Roose', 'Bolton', '2000', 'Software Engineering', '415-555-0003', 'rbolton@gmail.com', 'Dredfort', 'The North', 'Warden of the North', 'www.dreadfort.com')
('00004', '00002', 'HODOR', 'HODOR', '2001', 'Management Information Science', '415-555-0004', 'HODOR@gmail.com', 'Winterfel', 'The North', 'HODOR', 'www.hodor.com')
('00005', '00003', 'Robb', 'Stark', '2002', 'Software Engineering', '415-555-0005', 'youngwolf@gmail.com', 'Winterfel', 'The North', 'The King in the North', 'www.thrkinginthenorth.org')
('00006', '00004', 'Theon', 'Greyjoy', '2004', 'Management Information Science', '650-555-0006', 'turncloak@yahoo.com', 'Pike', 'Iron Islands', 'Reek, Reek, it rimes with sneek', 'www.mynameisreek.com')
('00007', '00006', 'Sirio', 'Forell', '2005', 'Software Engineering', '650-555-0007', 'sforell@hotmail.com', 'Tavern', 'Bravos', 'First sword of Bravos', 'www.sirioforell.com')
('00008', '00007', 'Rhaegar', 'Targaryen', '2006', 'Software Engineering', '415-555-0008', 'RhaegarT@aol.com', 'Red Keep', 'Crown Lands', 'Son of the Mad King', 'www.silverharp.com')
('00009', '00008', 'Tyrion', 'Lanister', '2007', 'Management Information Science', '650-555-0009', 'theImp@gmail.com', 'Casterly Rock', 'Lanisport', 'HALF MAN, HALF MAM', 'www.impingainteasy.com')
('00010', '00009', 'Khal', 'Drogo', '2008', 'Software Engineering', '510-555-0010', 'KhalDrogo@netscape.com', 'The Dothraki Sea', 'Essos', 'Khal of the great grass see', 'www.drogo.com')
;

DROP TABLE IF EXISTS Docs;
CREATE TABLE Docs (
  DocID int(5) NOT NULL ,
  ProjectID int NOT NULL ,
  DocName varchar (40) NULL,
  DocType varchar (40) NULL,
  DocLocation text default NULL,
  PRIMARY KEY  (DocID),
  FOREIGN KEY (ProjectID) REFERENCES Projects(ProjectID),
  UNIQUE KEY DocID (DocID)
 ) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table 'Projects'

INSERT INTO Docs (DocID,ProjectID, DocName, DocType, DocLocation) VALUES
('00001', '00001', 'People.xls', 'Excel', '\/\/Server1\/SeniorProjects\/2000'),
('00002', '00001', 'File.PDF', 'PDF', '\/\/Server1\/SeniorProjects\/2000');

DROP TABLE IF EXISTS Jobs;
CREATE TABLE Jobs (
  JobID int(5) NOT NULL ,
  UserID int(5) NOT NULL ,
  JobTitle varchar(40) NOT NULL default '',
  CompanyName varchar(40) default NULL,
  Salary decimal(10,2) default NULL,
  Description text default NULL,
  JobType varchar(40) default NULL,
  StartDate date default NULL,
  EndDate date default NULL,
  PRIMARY KEY  (JobID),
  FOREIGN KEY (UserID) REFERENCES Users(UserID),
  UNIQUE KEY JobID (JobID)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table 'Projects'

INSERT INTO Jobs (JobID, UserID, JobTitle, CompanyName, Salary, Description, JobType, StartDate, EndDate) VALUES
('00001', '00002', 'DBA', 'Oracle', '125000.00', 'Know your database shit', 'FTE', '2015-01-01', '2015-12-31'),
('00002', '00002', 'Network Engineer', 'Google', '80000.00', 'Networking Crap', 'FTE', '2015-05-15', '9999-99-99');

--
-- Table structure for table 'Users'
-- 


-- added on 2/8/15
DROP TABLE IF EXISTS Feedback;
CREATE TABLE Feedback (
  QuestionId int(6) NOT NULL,
  QuestionOne int(10),
  QuestionTwo int(10) default NULL,
  QuestionThree int(10) default NULL,
  QuestionFour int(10) default NULL,
  QuestionFive int(10) default NULL,
  Comments text default NULL,
  UNIQUE KEY QuestionId (QuestionId)
  ) ENGINE=MyISAM DEFAULT CHARSET=utf8;


-- 
-- Dumping date for table 'Users'
-- 

INSERT INTO Feedback (QuestionId, QuestionOne, QuestionTwo, QuestionThree, QuestionFour, QuestionFive, Comments) VALUES
(1, 8, 6, 9, 10, 5, 'this is the comments colum');