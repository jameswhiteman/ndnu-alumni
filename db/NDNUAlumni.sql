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

INSERT INTO Projects (ProjectName, ProjectYear, ProjectAbstracts) VALUES
('DVDnet.com', '2003', 'Online DVD rental store. The store is a place where customers will be able to rent their favorite DVD titles which will be delivered by regular mail. After viewing the costumers will place the disc in a return envelope to mail back to the store. This will use microsoft.net technologies, mainly ASP.net'),
('Shabnam"s Catering', '2003', 'A website that will allow a user to log on and search for recipes and sign up for weekly specials. A database will store all user information and the user interface that will be seen by the user when they log in. The user will be able to manipulate the database by using the GUI and the forms created. The user will also be able to perform a search inside the web site to find desired recipes. She/he will be able to add recipes to the database by using the form created. recipes can also be adds to a favorites list for easier access at future logins.'),
('SmashFriend', '2004', 'SmashFriend is a free online service that consists of users signing up to create an online profile searchable by other who are signed up for the service. Smashfriend features a friend list which keeps tract of all users friends. Users can also message friends and block/ignore unwanted friends. users can upload up to three photos and an icon to represent themselves. SmashFriend is created using Java Server pages and MySQL database.'),
('Student Online Learning System', '2006', 'System can be used by any educational institute. Provides functionality where students can enroll for classes, attend online classes, download course materials, check grades and take quizzes online. Also has functionality called Online Chatting where students can chat online without any downloading any applications.'),
('Track-It', '2004', 'System allows users to digitally track their assets using GPS. Users can track various vehicles(personal, government, emergency. etc.), Cargo ships/trucks & trains, Children, military troops and criminals. Tracks using GPS devices in cell phones, laptops etc.'),
('HomeWatcher', '2003', 'A full featured home automation software application program designed to allow full automation in homes in conjunction with X10 Corporations home automation modules. Allows users to program when lights or appliances are automatically turned on or off or to dim lights at various levels of intensity. Additional features allow users to define regular ongoing schedules for lighting behavior and a marco function which allows the user to group multiple appliances together so they can be turned off in a group. If the user is away it allow the user to make sure the residence looks "lived in".'),
('Soccer-Players.info', '2003', 'A website that will allow a college soccer coach to help find players for their team. Project consists of a database holding information of high school soccer players to be entered by their coach and to be retrieved by a college recruiter. Database will contain information such as age, sex, state, position, teams played for and cheached by. The coaches enter data on a form I will create. The coach can search various information in search of a player for their team.'),
('Discover You', '2003', 'Discover YOU is a program that evaluates a woman"s preferences concerning her personal style, life style, color style and cloths style. Upon completion of program questionnaires in these areas, reports may be viewed and helpful information and suggestions are made that may assist in maintaining a wardrobe that is more complementary to the woman"s body features.'),
('Order-tracking Web-Interface for Restaurants', '2004', 'There are two major parts to the interface: employee side and management side. The employee does not have ability to make changes to the database other than creating new orders and new customer comments. The management side has the ability to do the following: modify the menu, modify the schedule, modify customer comments page, create/modify orders, and view profits. Only the management side is protected by a secure login.'),
('Santa Clara Medical', '2004', 'The Santa Clara Medical website has been designed for a company of the same name. In addition to advertising the companies name, the website provides information related to its services. Other objectives include gathering feedback frm potential clients about the benefits and improvements that can be made. Also, the website informs the user of medical procedures offered, insurance matters, and the background of highly trained and friendly staff. The website is compatible to any computer making it very user friendly and has a directory on every page.'),
('ISG Solar Website', '2006', 'A solar website layout that will spread information for ISG. The company wishes to promote its solar technology in addition to public awareness to alternative energy. The new website will include upgrades to the original website and allow for increased functionality. The website will allow for communication between business and all interested parties.'),
('Web Store', '2004', 'The UI of the retail store will include three separate but integrated functions. The first is a catalog designed so that a shopper may search or design products. A shopper will have a collection of products referred to as his or her cart, which is initially empty. Products may be added to the shopping cart. A visual summary of the shopping cart will be displayed at all times. The UI will display available products or special promotions.'),
('Online Photo Gallery', '2004', 'The Online PhotoGallery is designed for a professional photographer who is interested in displaying and selling his work. Unlike other picture sharing and ordering sites available online in my photogallery a photographer is the owner and administrator of his website - he is the only one who posts photographs to the site.'),
('Hospital Interface System', '2003', 'Database for hospitals, patients and Labs.'),
('Simulating an example of Micro Architecture', '2003', 'Simulation of the example micro archtecture used in the second edition of Andrew Tanenbaum"s book "Structured Computer Organization".');

--
-- Table structure for table 'Users'
--

DROP TABLE IF EXISTS Users;
CREATE TABLE Users (
  UserID int(5) NOT NULL auto_increment,
  FirstName varchar(30) default NULL,
  LastName varchar(50) default NULL,
  UserName varchar(50) default NULL,
  Password varchar(255) default NULL,
  UserType varchar(30) default NULL,
  ProjectID varchar(5),
  JobTitle varchar(255) default NULl,
  Company varchar(255) default Null,
  GradYear int(4) default NULL,
  Major varchar(40) default NULL,
  PhoneNumber varchar(12) default NULL,
  Email varchar(70) default NULL,
  City varchar(30) default NULL,
  State varchar(20) default NULL,
  Description text default NULL,
  Page text default NULL,
  Image varchar(512) default NULL,
  PRIMARY KEY (UserID),
  UNIQUE KEY user_id (UserID),
  FOREIGN Key (ProjectId) REFERENCES Projects(ProjectId)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping date for table 'Users'
--

INSERT INTO Users (FirstName, LastName, UserName, Password, UserType, ProjectID, JobTitle, Company, GradYear, Major, PhoneNumber, Email, City, State, Description, Page) VALUES
('Daniel', 'Abihider', '', '', 'Alum', '', 'Information Professional', 'Abihider Consulting, Star One Credit Union', '1992', '', '', '', '', '', '', 'https://www.linkedin.com/profile/view?id=26032909&authType=NAME_SEARCH&authToken=supQ&locale=en_US&srchid=557605081416619421297&srchindex=1&srchtotal=1&trk=vsrp_people_res_name&trkInfo=VSRPsearchId%3A557605081416619421297%2CVSRPtargetId%3A26032909%2CVSRPcmpt%3Aprimary'),
('Kwadwo', 'Agyekumhene', '', '', 'Alum', '', 'Software Engineer', 'SalesForce', '', '', '', '', '', '', '','https://www.linkedin.com/pub/kwadwo-agyekumhene/0/932/65'),
('Stanley', 'Ackerman', '', '', 'Alum', '', 'IT Consilant and Contractor', 'Ackerfield Consulting', '1992', '', '', '', '', '', '', 'https://www.linkedin.com/profile/view?id=13191323&authType=NAME_SEARCH&authToken=Pc_C&locale=en_US&srchid=557605081416532060408&srchindex=1&srchtotal=15&trk=vsrp_people_res_name&trkInfo=VSRPsearchId%3A557605081416532060408%2CVSRPtargetId%3A13191323%2CVSRPcmpt%3Aprimary'),
('Djimbaye', 'Andemel', '', '', 'Alum', '', 'Software Engineer', 'BAE Systems', '', '', '', '', '', '', '','https://www.linkedin.com/profile/view?id=178939139&authType=NAME_SEARCH&authToken=x7kZ&locale=en_US&trk=tyah2&trkInfo=tarId%3A1414109569524%2Ctas%3Adjimbaye%2Cidx%3A1-1-1'),
('Claudia', 'Baltodano', '', '', 'Alum', '', 'Release Engineering', 'Serena Software', '', '', '', '', '', '', '','https://www.linkedin.com/profile/view?id=17597009&authType=NAME_SEARCH&authToken=jx7B&locale=en_US&trk=tyah&trkInfo=tarId%3A1414113086691%2Ctas%3ACLAUDIA%20BALTODANO%2Cidx%3A1-1-1'),
('Erdy', 'Barlahan', '', '', 'Alum', '', 'Senior Systems', 'All Covered', '', '', '', '', '', '', '','https://www.linkedin.com/profile/view?id=16200590&authType=NAME_SEARCH&authToken=dfnP&locale=en_US&trk=tyah&trkInfo=tarId%3A1414113161700%2Ctas%3Aerdy%20barlahan%2Cidx%3A1-1-1'),
('Steven', 'Beckert', '', '', 'Alum', '', 'Software Engineer', 'Celera Corporation', '2003', '', '', '', '', '', '', 'https://www.linkedin.com/profile/view?id=360684986&authType=NAME_SEARCH&authToken=_aeM&locale=en_US&srchid=557605081416532360509&srchindex=1&srchtotal=5&trk=vsrp_people_res_name&trkInfo=VSRPsearchId%3A557605081416532360509%2CVSRPtargetId%3A360684986%2CVSRPcmpt%3Aprimary'),
('Ralph', 'Birt', '', '', 'Alum', '', 'NA', 'Mobilygen', '2003', '', '', '', '', '', '', 'https://www.linkedin.com/profile/view?id=7349823&authType=NAME_SEARCH&authToken=D4lP&locale=en_US&srchid=557605081416532432110&srchindex=1&srchtotal=3&trk=vsrp_people_res_name&trkInfo=VSRPsearchId%3A557605081416532432110%2CVSRPtargetId%3A7349823%2CVSRPcmpt%3Aprimary'),
('Tommy', 'Bothwell', '', '', 'Alum', '', 'Systems Admin', 'Kaiser', '', '', '', '', '', '', '','https://www.linkedin.com/profile/view?id=37741671&authType=NAME_SEARCH&authToken=pE7I&locale=en_US&trk=tyah&trkInfo=tarId%3A1414109664210%2Ctas%3Atommy%20both%2Cidx%3A1-5-5'),
('Enrique', 'Brime', '', '', 'Alum', '', 'Director of Sales', 'Latin America at Redline Communications', '2000', '', '', '', '', '', '', 'https://www.linkedin.com/pub/enrique-brime/4/515/12b'),
('Jeff', 'Brody', '', '', 'Alum', '', 'Network Engineer', 'US Geo Survey', '1995', '', '', '', '', '', '', 'https://www.linkedin.com/profile/view?id=2371495&authType=NAME_SEARCH&authToken=i0gb&locale=en_US&srchid=557605081414113691727&srchindex=1&srchtotal=37&trk=vsrp_people_res_name&trkInfo=VSRPsearchId%3A557605081414113691727%2CVSRPtargetId%3A2371495%2CVSRPcmpt%3Aprimary'),
('Roberto', 'Conception', '', '', 'Alum', '', 'Computer Engineer', 'NEC Electronics', '2006', '', '', '', '', '', '', 'https://www.linkedin.com/profile/view?id=11999032&authType=NAME_SEARCH&authToken=RmwF&locale=en_US&srchid=557605081416532544550&srchindex=1&srchtotal=39&trk=vsrp_people_res_name&trkInfo=VSRPsearchId%3A557605081416532544550%2CVSRPtargetId%3A11999032%2CVSRPcmpt%3Aprimary'),
('Jolly', 'Constance', '', '', 'Alum', '', 'Systems Engineer', 'Lockheed Martin', '2003', '', '', '', '', '', '', 'https://www.linkedin.com/profile/view?id=54071412&authType=NAME_SEARCH&authToken=ym6c&locale=en_US&srchid=557605081414196311384&srchindex=1&srchtotal=2&trk=vsrp_people_res_name&trkInfo=VSRPsearchId%3A557605081414196311384%2CVSRPtargetId%3A54071412%2CVSRPcmpt%3Aprimary'),
('Jennifer', 'Davis', '', '', 'Alum', '', 'Automation Engineer', 'Chef', '2009', '', '', '', '', '', '', 'https://www.linkedin.com/profile/view?id=1125833&authType=NAME_SEARCH&authToken=ifLc&locale=en_US&srchid=557605081416532667356&srchindex=3&srchtotal=3202&trk=vsrp_people_res_name&trkInfo=VSRPsearchId%3A557605081416532667356%2CVSRPtargetId%3A1125833%2CVSRPcmpt%3Aprimary'),
('Ranjan', 'Dutta', '', '', 'Alum', '', 'Sr. Engineer', 'Ericsson', '2007', '', '', '', '', '', '', 'https://www.linkedin.com/profile/view?id=36279589&authType=OPENLINK&authToken=3SHC&locale=en_US&srchid=557605081414114296558&srchindex=3&srchtotal=124&trk=vsrp_people_res_name&trkInfo=VSRPsearchId%3A557605081414114296558%2CVSRPtargetId%3A36279589%2CVSRPcmpt%3Aprimary'),
('Bernardo', 'Elayda', '', '', 'Alum', '', 'GPS Test Engineer', 'Intel', '2005', '', '', '', '', '', '', 'https://www.linkedin.com/profile/view?id=16587761&authType=NAME_SEARCH&authToken=jumb&locale=en_US&trk=tyah&trkInfo=tarId%3A1414114371558%2Ctas%3Abernardo%20elayda%2Cidx%3A1-1-1'),
('Francisco', 'Galdamez', '', '', 'Alum', '', 'Sr. QA Engineer', 'Visa', '', '', '', '', '', '', '','https://www.linkedin.com/profile/view?id=11246173&authType=NAME_SEARCH&authToken=kAFC&locale=en_US&srchid=557605081414109217293&srchindex=1&srchtotal=21&trk=vsrp_people_res_name&trkInfo=VSRPsearchId%3A557605081414109217293%2CVSRPtargetId%3A11246173%2CVSRPcmpt%3Aprimary'),
('Maria', 'George', '', '', 'Alum', '', 'Sr. Infrastructure Manager', 'Workday', '2002', '', '', '', '', '', '', 'https://www.linkedin.com/profile/view?id=6508380&authType=NAME_SEARCH&authToken=EeBN&locale=en_US&trk=tyah&trkInfo=tarId%3A1414114451767%2Ctas%3Amaria%20George%20%2Cidx%3A1-1-1'),
('Hendra', 'Godjali', '', '', 'Alum', '', 'Managing Director', 'Accentire', '1995', '', '', '', '', '', '', 'https://www.linkedin.com/profile/view?id=649988&authType=NAME_SEARCH&authToken=foko&locale=en_US&srchid=557605081414114530271&srchindex=1&srchtotal=1&trk=vsrp_people_res_name&trkInfo=VSRPsearchId%3A557605081414114530271%2CVSRPtargetId%3A649988%2CVSRPcmpt%3Aprimary'),
('Dimitry', 'Gringauz', '', '', 'Alum', '', 'Principal Developer', 'Banner Engineering', '', '', '', '', '', '', '','https://www.linkedin.com/profile/view?id=21567158&authType=NAME_SEARCH&authToken=hQdM&locale=en_US&srchid=557605081416597202142&srchindex=1&srchtotal=1&trk=vsrp_people_res_name&trkInfo=VSRPsearchId%3A557605081416597202142%2CVSRPtargetId%3A21567158%2CVSRPcmpt%3Aprimary'),
('Timothy', 'Hadlock', '', '', 'Alum', '', 'Technology Transactions', 'SaaS Agreements Software Licenses', '', '', '', '', '', '', '','https://www.linkedin.com/profile/view?id=21150552&authType=NAME_SEARCH&authToken=cpTQ&locale=en_US&trk=tyah&trkInfo=tarId%3A1416597304606%2Ctas%3Atomothy%20hadloc%2Cidx%3A1-1-1'),
('Michael', 'Helms', '', '', 'Alum', '', 'Sr. Software Test', 'Clarity Medical Systems', '2000', '', '', '', '', '', '', 'https://www.linkedin.com/profile/view?id=41338575&authType=NAME_SEARCH&authToken=V0U-&locale=en_US&srchid=557605081414194809482&srchindex=1&srchtotal=2&trk=vsrp_people_res_name&trkInfo=VSRPsearchId%3A557605081414194809482%2CVSRPtargetId%3A41338575%2CVSRPcmpt%3Aprimary'),
('Mel', 'Kern', '', '', 'Alum', '', 'Senior Client Advocate', 'Dimension Data', '2000', '', '', '', '', '', '', 'https://www.linkedin.com/profile/view?id=14693569&authType=NAME_SEARCH&authToken=mcv9&locale=en_US&srchid=557605081414195157790&srchindex=2&srchtotal=3&trk=vsrp_people_res_name&trkInfo=VSRPsearchId%3A557605081414195157790%2CVSRPtargetId%3A14693569%2CVSRPcmpt%3Aprimary'),
('Patrick', 'Khajehtoorian', '', '', 'Alum', '', 'Product Manager', 'VerticalResponse', '', '', '', '', '', '', '','https://www.linkedin.com/profile/view?id=14258397&authType=NAME_SEARCH&authToken=h5S0&locale=en_US&trk=tyah&trkInfo=tarId%3A1414109794163%2Ctas%3Apatrick%20khaj%2Cidx%3A1-1-1'),
('Michael', 'Kiernman', '', '', 'Alum', '', 'Program Manager', 'Dreamworks', '', '', '', '', '', '', '','https://www.linkedin.com/profile/view?id=1864053&authType=NAME_SEARCH&authToken=8KDK&locale=en_US&srchid=557605081414195271012&srchindex=1&srchtotal=121&trk=vsrp_people_res_name&trkInfo=VSRPsearchId%3A557605081414195271012%2CVSRPtargetId%3A1864053%2CVSRPcmpt%3Aprimary'),
('Rafael', 'Kitover', '', '', 'Alum', '', 'Perl Developer', 'Asset Management Specialists', '2003', '', '', '', '', '', '', 'https://www.linkedin.com/profile/view?id=8723486&authType=NAME_SEARCH&authToken=8QMy&locale=en_US&trk=tyah&trkInfo=tarId%3A1416597566161%2Ctas%3Arafael%20kit%2Cidx%3A1-1-1'),
('Virginia', 'Less', '', '', 'Alum', '', 'Project manager', 'TransCentra', '1989', '', '', '', '', '', '', 'https://www.linkedin.com/profile/view?id=9593311&authType=NAME_SEARCH&authToken=G21J&locale=en_US&srchid=557605081416597779069&srchindex=1&srchtotal=2&trk=vsrp_people_res_name&trkInfo=VSRPsearchId%3A557605081416597779069%2CVSRPtargetId%3A9593311%2CVSRPcmpt%3Aprimary'),
('Michael', 'Limprecht', '', '', 'Alum', '', 'Sr. E manager', 'Oracle', '1993', '', '', '', '', '', '', 'https://www.linkedin.com/profile/view?id=39136313&authType=OPENLINK&authToken=RPv8&locale=en_US&srchid=557605081416597907695&srchindex=1&srchtotal=1&trk=vsrp_people_res_name&trkInfo=VSRPsearchId%3A557605081416597907695%2CVSRPtargetId%3A39136313%2CVSRPcmpt%3Aprimary'),
('Olivia', 'Lopez', '', '', 'Alum', '', 'NA', 'Fremont Bank', '2003', '', '', '', '', '', '', 'https://www.linkedin.com/profile/view?id=93846784&authType=NAME_SEARCH&authToken=0QsP&locale=en_US&srchid=557605081414195946912&srchindex=1&srchtotal=8&trk=vsrp_people_res_name&trkInfo=VSRPsearchId%3A557605081414195946912%2CVSRPtargetId%3A93846784%2CVSRPcmpt%3Aprimary'),
('Francine', 'Lynch', '', '', 'Alum', '', 'Web Developer', 'Media Rights Tech', '2003', '', '', '', '', '', '', 'https://www.linkedin.com/profile/view?id=91430393&authType=NAME_SEARCH&authToken=y3kq&locale=en_US&srchid=557605081414196050645&srchindex=1&srchtotal=1&trk=vsrp_people_res_name&trkInfo=VSRPsearchId%3A557605081414196050645%2CVSRPtargetId%3A91430393%2CVSRPcmpt%3Aprimary'),
('Mailene', 'Mac', '', '', 'Alum', '', 'QA Manager', 'ServiceSource', '1999', '', '', '', '', '', '', 'https://www.linkedin.com/profile/view?id=1047093&authType=NAME_SEARCH&authToken=BMpJ&locale=en_US&srchid=557605081414196123837&srchindex=1&srchtotal=1&trk=vsrp_people_res_name&trkInfo=VSRPsearchId%3A557605081414196123837%2CVSRPtargetId%3A1047093%2CVSRPcmpt%3Aprimary'),
('Jeff', 'Mahe', '', '', 'Alum', '', 'Team Leader', 'Database Architecture at athenahealth', '1996', '', '', '', '', '', '', 'https://www.linkedin.com/profile/view?id=3006189&authType=NAME_SEARCH&authToken=3Au9&locale=en_US&srchid=557605081414196891328&srchindex=1&srchtotal=2&trk=vsrp_people_res_name&trkInfo=VSRPsearchId%3A557605081414196891328%2CVSRPtargetId%3A3006189%2CVSRPcmpt%3Aprimary'),
('Scott', 'Mantegani', '', '', 'Alum', '', 'SWAT Software Engineer', 'Vindicia', '2011', '', '', '', '', '', '', 'https://www.linkedin.com/profile/view?id=213252014&authType=NAME_SEARCH&authToken=SOq-&locale=en_US&srchid=557605081416615306928&srchindex=1&srchtotal=1&trk=vsrp_people_res_name&trkInfo=VSRPsearchId%3A557605081416615306928%2CVSRPtargetId%3A213252014%2CVSRPcmpt%3Aprimary'),
('Jeff', 'Miller', '', '', 'Alum', '', 'Software Engineer', 'Funny or Die', '', '', '', '', '', '', '','https://www.linkedin.com/in/ibanez270dx'),
('Ali', 'Najafizadeh', '', '', 'Alum', '', 'Network Security', 'Coffer Group LLC', '2012', '', '', '', '', '', '', 'https://www.linkedin.com/profile/view?id=21882942&authType=NAME_SEARCH&authToken=5Psj&locale=en_US&srchid=557605081416619982491&srchindex=1&srchtotal=197&trk=vsrp_people_res_name&trkInfo=VSRPsearchId%3A557605081416619982491%2CVSRPtargetId%3A21882942%2CVSRPcmpt%3Aprimary'),
('Derrick', 'Papp', '', '', 'Alum', '', 'Test Engineer', 'Actiontec', '', '', '', '', '', '', '','https://www.linkedin.com/profile/view?id=198412150&authType=NAME_SEARCH&authToken=uSUi&locale=en_US&srchid=557605081414110405619&srchindex=1&srchtotal=1&trk=vsrp_people_res_name&trkInfo=VSRPsearchId%3A557605081414110405619%2CVSRPtargetId%3A198412150%2CVSRPcmpt%3Aprimary'),
('Michael', 'Parker', '', '', 'Alum', '', 'Global CRM Sr. Staff Analyst', 'Bio-Rad Laboratories', '2013', '', '', '', '', '', '', 'https://www.linkedin.com/profile/view?id=94373828&authType=NAME_SEARCH&authToken=hlEk&locale=en_US&srchid=557605081416615710056&srchindex=1&srchtotal=2622&trk=vsrp_people_res_name&trkInfo=VSRPsearchId%3A557605081416615710056%2CVSRPtargetId%3A94373828%2CVSRPcmpt%3Aprimary'),
('Vic', 'Plantaleon', '', '', 'Alum', '', 'Systems Admin', 'Cisco', '', '', '', '', '', '', '','https://www.linkedin.com/profile/view?id=3012753&authType=NAME_SEARCH&authToken=kght&locale=en_US&trk=tyah&trkInfo=tarId%3A1416615538961%2Ctas%3Avic%20pantaleon%2Cidx%3A1-1-1'),
('Joel', 'Rumley', '', '', 'Alum', '', 'Product Manager', 'Varian Medical Systems', '2001', '', '', '', '', '', '', 'https://www.linkedin.com/profile/view?id=27416609&authType=NAME_SEARCH&authToken=TLkm&locale=en_US&srchid=557605081416615844010&srchindex=1&srchtotal=1&trk=vsrp_people_res_name&trkInfo=VSRPsearchId%3A557605081416615844010%2CVSRPtargetId%3A27416609%2CVSRPcmpt%3Aprimary'),
('Hany', 'Sabet', '', '', 'Alum', '', 'Sr. VP Sales and Trading', 'The Maxim Group', '', '', '', '', '', '', '','https://www.linkedin.com/profile/view?id=1429874&authType=NAME_SEARCH&authToken=Gd2j&locale=en_US&srchid=557605081416617079356&srchindex=1&srchtotal=3&trk=vsrp_people_res_name&trkInfo=VSRPsearchId%3A557605081416617079356%2CVSRPtargetId%3A1429874%2CVSRPcmpt%3Aprimary'),
('Joe', 'Sangervasi', '', '', 'Alum', '', 'Sr. Software Developer', 'StayHealthy', '2004', '', '', '', '', '', '', 'https://www.linkedin.com/profile/view?id=12777004&authType=NAME_SEARCH&authToken=1l9H&locale=en_US&srchid=557605081414521489974&srchindex=1&srchtotal=1&trk=vsrp_people_res_name&trkInfo=VSRPsearchId%3A557605081414521489974%2CVSRPtargetId%3A12777004%2CVSRPcmpt%3Aprimary'),
('Sarah', 'Schwanbeck', '', '', 'Alum', '', 'Senior Engineernig Manager', 'Yahoo', '2002', '', '', '', '', '', '', 'https://www.linkedin.com/profile/view?id=1127228&authType=NAME_SEARCH&authToken=4uI_&locale=en_US&srchid=557605081416617204619&srchindex=1&srchtotal=1&trk=vsrp_people_res_name&trkInfo=VSRPsearchId%3A557605081416617204619%2CVSRPtargetId%3A1127228%2CVSRPcmpt%3Aprimary'),
('Sergio', 'Shoomiloff', '', '', 'Alum', '', 'Software Engineer', 'Silicon valley', '', '', '', '', '', '', '','https://www.linkedin.com/profile/view?id=5336983&authType=NAME_SEARCH&authToken=aBd-&locale=en_US&trk=tyah2&trkInfo=tarId%3A1416619684257%2Ctas%3Asergio%20shoomi%2Cidx%3A1-1-1'),
('Christopher', 'Silveria', '', '', 'Alum', '', 'Manager, Fraud Intelligence', 'Guardian Analytics', '2006', '', '', '', '', '', '', 'https://www.linkedin.com/profile/view?id=5762898&authType=NAME_SEARCH&authToken=-bxU&locale=en_US&srchid=557605081416617374411&srchindex=1&srchtotal=22&trk=vsrp_people_res_name&trkInfo=VSRPsearchId%3A557605081416617374411%2CVSRPtargetId%3A5762898%2CVSRPcmpt%3Aprimary'),
('Alicia', 'Sloan', '', '', 'Alum', '', 'Technology Specialist', 'NA', '2006', '', '', '', '', '', '', 'https://www.linkedin.com/profile/view?id=5769820&authType=NAME_SEARCH&authToken=OJbr&locale=en_US&srchid=557605081416617487039&srchindex=1&srchtotal=16&trk=vsrp_people_res_name&trkInfo=VSRPsearchId%3A557605081416617487039%2CVSRPtargetId%3A5769820%2CVSRPcmpt%3Aprimary'),
('Jackie', 'Tani', '', '', 'Alum', '', 'Independent Computer Software Professional', 'NA', '2002', '', '', '', '', '', '', 'https://www.linkedin.com/profile/view?id=25728233&authType=NAME_SEARCH&authToken=bIt8&locale=en_US&trk=tyah&trkInfo=tarId%3A1416617691068%2Ctas%3Ajacqueline%20tani%2Cidx%3A1-2-2'),
('Lee', 'Torno', '', '', 'Alum', '', 'Cleared Implementation Engineer specializing in Windows Server & Web Technology implementations', 'AtHoc', '', '', '', '', '', '', '','https://www.linkedin.com/profile/view?id=2009880&authType=OPENLINK&authToken=temF&locale=en_US&srchid=557605081416617774215&srchindex=1&srchtotal=1&trk=vsrp_people_res_name&trkInfo=VSRPsearchId%3A557605081416617774215%2CVSRPtargetId%3A2009880%2CVSRPcmpt%3Aprimary'),
('Veronica', 'Vivette', '', '', 'Alum', '', 'Event Coordinator', 'Morgan Stanley', '2006', '', '', '', '', '', '', 'https://www.linkedin.com/profile/view?id=5768687&authType=NAME_SEARCH&authToken=spuN&locale=en_US&srchid=557605081416617955453&srchindex=1&srchtotal=1&trk=vsrp_people_res_name&trkInfo=VSRPsearchId%3A557605081416617955453%2CVSRPtargetId%3A5768687%2CVSRPcmpt%3Aprimary'),
('Russ', 'Wertenberg', '', '', 'Alum', '', 'Program Executive', 'NASA Aimes Research', '1991', '', '', '', '', '', '', 'https://www.linkedin.com/profile/view?id=8387969&authType=NAME_SEARCH&authToken=Lbfx&locale=en_US&srchid=557605081416618118182&srchindex=1&srchtotal=1&trk=vsrp_people_res_name&trkInfo=VSRPsearchId%3A557605081416618118182%2CVSRPtargetId%3A8387969%2CVSRPcmpt%3Aprimary'),
('Marcos', 'Woehrmann', '', '', 'Alum', '', 'PhD student in the Biomolecular Engineer Dept. majoring in Bioinformatics', 'UC Santa Cruz', '2006', '', '', '', '', '', '', 'https://www.linkedin.com/profile/view?id=25957&authType=NAME_SEARCH&authToken=6XYL&locale=en_US&trk=tyah&trkInfo=tarId%3A1414625335655%2Ctas%3Amarcos%20woehrmann%2Cidx%3A1-1-1'),
('Nikki', 'Wong', '', '', 'Alum', '', 'Engineer', 'Sun Microsystems', '1998', '', '', '', '', '', '', 'https://www.linkedin.com/profile/view?id=11028485&authType=NAME_SEARCH&authToken=Nfgg&locale=en_US&srchid=557605081416619279076&srchindex=1&srchtotal=51&trk=vsrp_people_res_name&trkInfo=VSRPsearchId%3A557605081416619279076%2CVSRPtargetId%3A11028485%2CVSRPcmpt%3Aprimary'),
('Michael', 'Yasko', '', '', 'Alum', '', 'Sr. Manager, Developer Relations & App Review', 'Leap Motion', '2006', '', '', '', '', '', '', 'https://www.linkedin.com/profile/view?id=1455733&authType=NAME_SEARCH&authToken=cS50&locale=en_US&trk=tyah&trkInfo=tarId%3A1414542313982%2Ctas%3Amichael%20yasko%2Cidx%3A1-2-2'),
('Chan', 'Woei', '', '', 'Alum', '', 'Area Sales Manager', 'EOS Singapore', '2000', '', '', '', '', '', '', 'https://www.linkedin.com/profile/view?id=56652721&authType=NAME_SEARCH&authToken=Lct4&locale=en_US&trk=tyah&trkInfo=tarId%3A1414113877586%2Ctas%3Ajyh-woei%2Cidx%3A1-1-1');

--
-- Table structure for table 'Docs'
--

DROP TABLE IF EXISTS Docs;

--
-- Dumping data for table 'Projects'
--



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
-- Table structure for table 'Feedback'
--

-- added on 2/8/15
DROP TABLE IF EXISTS Feedback;
CREATE TABLE Feedback (
  QuestionID int(6) NOT NULL auto_increment,
  UserID int(5) NOT NULL ,
  QuestionOne text default NULL,
  QuestionTwo text default NULL,
  QuestionThree text default NULL,
  QuestionFour text default NULL,
  QuestionFive text default NULL,
  PRIMARY KEY  (QuestionID),
  FOREIGN KEY (UserID) REFERENCES Users(UserID),
  UNIQUE KEY QuestionId (QuestionID)
  ) ENGINE=MyISAM DEFAULT CHARSET=utf8;


--
-- Table structure for table 'lecture'
--

-- added 4/10/15
DROP TABLE IF EXISTS Events;
CREATE TABLE Events (
  EventID int(6) NOT NULL auto_increment,
  EventTitle varchar(255) NOT NULL,
  EventType varchar(100) NOT NULL,
  EventOrgName varchar(70) default NULL,
  EventMajor varchar(70) default NULL,
  EventTopic varchar(255) default NULL,
  EventDesc text default NULL,
  EventTime decimal(13,0) NOT NULL,
  PRIMARY KEY (EventID),
  UNIQUE KEY EventID (EventID)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
