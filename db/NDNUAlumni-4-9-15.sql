
-- NDNU Alumni
-- version 3
--
-- Host: localhost
-- Generation Time: Feb 06, 2015 @ 7:50 PM
-- Updated: Feb 20, 2015 @ 8:53 pm
--
-- Authors: Eric & Ryan
--

DROP DATABASE IF EXISTS NDNUAlumni;

CREATE DATABASE IF NOT EXISTS NDNUAlumni;

USE NDNUAlumni;

--
-- Database: 'NDNUAlumni'
--

--
-- Table structure for table 'Projects'
--

DROP TABLE IF EXISTS project;
CREATE TABLE Projects (
  ProjectID int(5) NOT NULL auto_increment,
  ProjectName varchar(40) NOT NULL default '',
  ProjectYear int default NULL,
  ProjectAbstracts text default NULL,
  PRIMARY KEY  (ProjectID),
  UNIQUE KEY ProjectID (ProjectID)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table 'Projects'
--

INSERT INTO Projects (ProjectID, ProjectName, ProjectYear, ProjectAbstracts) VALUES
('00001', 'First Project Ever', '2000', 'This the first Senior Project in the List'),
('00002', 'Second Project', '2001', 'Second Project Ever. Getting a little better at this'),
('00003', 'Third Project', '2002', 'Third time is a charm'),
('00004', 'Fourth Project', '2003', 'This is the fourth project'),
('00005', 'Fifth Project', '2004', 'This is the fifth project'),
('00006', 'Sixth Project', '2005', 'This is the sixth project'),
('00007', 'Seventh Project', '2006', 'This is the Seventh project'),
('00008', 'Eighth Project', '2007', 'This is the Eighth project'),
('00009', 'Ninth Project', '2008', 'This is the Ninth project'),
('00010', 'Tenth Project', '2009', 'This is the Tenth project');

--
-- Table structure for table 'Users'
--

DROP TABLE IF EXISTS Users;
CREATE TABLE Users (
  UserID int(5) NOT NULL auto_increment,
  ProjectID int(5),
  FirstName varchar(30) default NULL,
  LastName varchar(50) default NULL,
  UserType varchar(30) default NULL,
  GradYear int(4) default NULL,
  Major varchar(40) default NULL,
  PhoneNumber varchar(12) default NULL,
  Email varchar(70) default NULL,
  Password varchar(255) default NULL,
  City varchar(30) default NULL,
  State varchar(20) default NULL,
  Description text default NULL,
  Page varchar(255) default NULL,
  LoggedIn varchar(1) default NULL,
  PRIMARY KEY (UserId),
  UNIQUE KEY user_id (UserId),
  FOREIGN Key (ProjectId) REFERENCES Projects(ProjectId)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- Dumping date for table 'Users'
-- 

INSERT INTO Users (UserID, ProjectID, FirstName, LastName, UserType, GradYear, Major, PhoneNumber, Email, Password, City, State, Description, Page, LoggedIn) VALUES
('00001', '00001', 'John', 'Snow', 'User', '2001', 'Software Engineering', '415-555-0001', 'JohnSnow@gmail.com', 'Password123', 'Castle Black', 'The Wall', 'Lord Commander of the Nights Watch', 'http://www.facebook.com/JohnSnow', 'N'),
('00002', '00004', 'Arya', 'Stark', 'User', '2003', 'Software Engineering', '415-555-0002', 'AryaHorseface@gmail.com', 'Password123', 'House of Black and White', 'Bravos', 'Acolite of the House of Black and White', 'http://www.facebook.com/AryaStark', 'N'),
('00003', '00001', 'Roose', 'Bolton', 'User', '2000', 'Software Engineering', '415-555-0003', 'rbolton@gmail.com', 'Password123', 'Dredfort', 'The North', 'Warden of the North', 'www.dreadfort.com', 'N'),
('00004', '00002', 'HODOR', 'HODOR', 'User', '2001', 'Management Information Science', '415-555-0004', 'HODOR@gmail.com', 'Password123', 'Winterfel', 'The North', 'HODOR', 'www.hodor.com', 'N'),
('00005', '00003', 'Robb', 'Stark', 'User', '2002', 'Software Engineering', '415-555-0005', 'youngwolf@gmail.com', 'Password123', 'Winterfel', 'The North', 'The King in the North', 'www.thrkinginthenorth.org', 'N'),
('00006', '00004', 'Theon', 'Greyjoy', 'User', '2004', 'Management Information Science', '650-555-0006', 'turncloak@yahoo.com', 'Password123', 'Pike', 'Iron Islands', 'Reek, Reek, it rimes with sneek', 'www.mynameisreek.com', 'N'),
('00007', '00006', 'Sirio', 'Forell', 'User', '2005', 'Software Engineering', '650-555-0007', 'sforell@hotmail.com', 'Password123', 'Tavern', 'Bravos', 'First sword of Bravos', 'www.sirioforell.com', 'N'),
('00008', '00007', 'Rhaegar', 'Targaryen', 'User', '2006', 'Software Engineering', '415-555-0008', 'RhaegarT@aol.com', 'Password123', 'Red Keep', 'Crown Lands', 'Son of the Mad King', 'www.silverharp.com', 'N'),
('00009', '00008', 'Tyrion', 'Lanister', 'User', '2007', 'Management Information Science', '650-555-0009', 'theImp@gmail.com', 'Password123', 'Casterly Rock', 'Lanisport', 'HALF MAN, HALF MAM', 'www.impingainteasy.com', 'N'),
('00010', '00009', 'Khal', 'Drogo', 'User', '2008', 'Software Engineering', '510-555-0010', 'KhalDrogo@netscape.com', 'Password123', 'The Dothraki Sea', 'Essos', 'Khal of the great grass see', 'www.drogo.com', 'N');

-- 
-- Table structure for table 'Docs'
-- 

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
--

INSERT INTO Docs (DocID,ProjectID, DocName, DocType, DocLocation) VALUES
('00001', '00001', 'People.xls', 'Excel', '\/\/Server1\/SeniorProjects\/2000'),
('00002', '00001', 'File.PDF', 'PDF', '\/\/Server1\/SeniorProjects\/2000'),
('00003', '00001', 'STATS.doc', 'WORD', '\/\/Server1\/SeniorProjects\/2000'),
('00004', '00002', 'Source.txt', 'TEXT', '\/\/Server1\/SeniorProjects\/2001'),
('00005', '00002', 'Diagram.PDF', 'PDF', '\/\/Server1\/SeniorProjects\/2001'),
('00006', '00002', 'Instructions.doc', 'WORD', '\/\/Server1\/SeniorProjects\/2001'),
('00007', '00003', 'SourceCode.txt', 'TEXT', '\/\/Server1\/SeniorProjects\/2002'),
('00008', '00003', 'Classes.txt', 'TEST', '\/\/Server1\/SeniorProjects\/2002'),
('00009', '00003', 'Instructions.doc', 'WORD', '\/\/Server1\/SeniorProjects\/2002'),
('00010', '00004', 'Description.doc', 'WORD', '\/\/Server1\/SeniorProjects\/2003');


-- 
-- Table structure for table 'Jobs'
-- 

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
-- Dumping data for table 'Jobs'
--

INSERT INTO Jobs (JobID, UserID, JobTitle, CompanyName, Salary, Description, JobType, StartDate, EndDate) VALUES
('00001', '00002', 'DBA', 'Oracle', '125000.00', 'Know your database shit', 'FTE', '2015-01-01', '2015-12-31'),
('00002', '00002', 'Network Engineer', 'Google', '80000.00', 'Networking Crap', 'FTE', '2015-05-15', '9999-99-99'),
('00003', '00003', 'Programmer Analyst', 'Adobe', '72000.00', 'Program some scripts', 'FTE', '2015-02-01', '9999-99-99'),
('00004', '00003', 'Programmer Analyst 2', 'Adobe', '85000.00', 'Program some scripts', 'FTE', '2015-02-01', '9999-99-99'),
('00005', '00003', 'Business Analyst', 'Adobe', '95000.00', 'Interact with end users', 'FTE', '2015-02-01', '9999-99-99'),
('00006', '00004', 'Security Analyst', 'NASA', '140000.00', 'Make sure we do not get hacked', 'FTE', '2014-11-14', '9999-99-99'),
('00007', '00004', 'Nuclear Engineer', 'NASA', '135000.00', 'Rocket Science', 'FTE', '2014-11-14', '9999-99-99'),
('00008', '00004', 'Project Manager', 'NASA', '90000.00', 'Liason between org and I.T.', 'FTE', '2014-11-14', '9999-99-99'),
('00009', '00005', 'Service Manager', 'Microsoft', '95000.00', 'Quality Service', 'FTE', '2015-03-10', '9999-99-99'),
('00010', '00006', 'Software Engineer', 'Google', '95000.00', 'Develop Code', 'FTE', '2015-03-01', '9999-99-99');


--
-- Table structure for table 'Feedback'
-- 

-- added on 2/8/15
DROP TABLE IF EXISTS Feedback;
CREATE TABLE Feedback (
  QuestionID int(6) NOT NULL auto_increment,
  UserID int(5) NOT NULL ,
  QuestionOne int(10),
  QuestionTwo int(10) default NULL,
  QuestionThree int(10) default NULL,
  QuestionFour int(10) default NULL,
  QuestionFive int(10) default NULL,
  Comments text default NULL,
  PRIMARY KEY  (QuestionID),
  FOREIGN KEY (UserID) REFERENCES Users(UserID),
  UNIQUE KEY QuestionId (QuestionID)
  ) ENGINE=MyISAM DEFAULT CHARSET=utf8;


-- 
-- Dumping date for table 'Feedback'
-- 

INSERT INTO Feedback (QuestionID, UserID, QuestionOne, QuestionTwo, QuestionThree, QuestionFour, QuestionFive, Comments) VALUES
('1', '00001', '8', '6', '9', '10', '5', 'this is the comments colum'),
('2', '00002', '8', '6', '9', '10', '5', 'Oh look another comments'),
('3', '00003', '8', '6', '9', '10', '5', 'A wild comment appeared');


