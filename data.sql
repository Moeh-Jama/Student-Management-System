create database school;
use school;

create table student(student_id int NOT NULL PRIMARY KEY, firstname VARCHAR(20), surname VARCHAR(20), DOB Date, address VARCHAR(150), email VARCHAR(150), phoneNumber VARCHAR(14), stage int, nationality VARCHAR(50), fees FLOAT, gender VARCHAR(20));


create table staff(staff_id int NOT NULL UNIQUE PRIMARY KEY, firstname VARCHAR(20), surname VARCHAR(20), DOB Date, address VARCHAR(150), email VARCHAR(150), phoneNumber VARCHAR(14), stage int, nationality VARCHAR(50), gender VARCHAR(20), staff_type VARCHAR(150));


create table module(module_id int NOT NULL PRIMARY KEY UNIQUE, module_name VARCHAR(150), module_description VARCHAR(1000), start_date DATE, end_date DATE, number_enrolled INT, student_capacity INT, coordinator_id INT, FOREIGN KEY (coordinator_id) REFERENCES staff(staff_id));


create table module_staff(ms_module_id INT NOT NULL, ms_staff_id INT NOT NULL, staff_type VARCHAR(50), PRIMARY KEY (ms_module_id, ms_staff_id), FOREIGN KEY (ms_module_id) REFERENCES module(module_id), FOREIGN KEY (ms_staff_id) REFERENCES staff(staff_id));

create table registered_user(
	user_id int NOT NULL,
	isStaff BOOL DEFAULT FALSE, 
	password VARCHAR(20) NOT NULL,
	PRIMARY KEY (user_id)
);



create table enrolled_module_students(ems_module_id INT NOT NULL, ems_student_id INT NOT NULL, end_date Date NOT NULL, grade FLOAT NOT NULL, FOREIGN KEY (ems_module_id) REFERENCES module(module_id), FOREIGN KEY (ems_student_id) REFERENCES student(student_id));


create table module_grades(mg_module_id INT NOT NULL, mg_student_id INT NOT NULL, grade FLOAT NOT NULL, grade_year DATE, FOREIGN KEY (mg_module_id) REFERENCES module(module_id));



insert into student (student_id, firstname, surname, DOB, address, email, phoneNumber, stage, nationality, fees, gender) values (1,'Haley','Kristin','1992-5-25','427 Gulf View Drive','Haley.Kristin@springfieldConnect.com','+353 387861712',4,'irish',6037,'other');
insert into registered_user (user_id, password, isStaff) values (1, 'haley', False);
insert into staff (staff_id, firstname, surname, DOB, address, email, phoneNumber, stage, nationality, gender, staff_type) values (2,'Jackson','Cumings','1999-4-18','3801 North Ann Arbor Place','Jackson.Cumings@springfeildStaff.com','+853 11846034',7,'French','man','assistent_professor');
insert into registered_user (user_id, password, isStaff) values (2, 'jackson', True);
insert into student (student_id, firstname, surname, DOB, address, email, phoneNumber, stage, nationality, fees, gender) values (3,'Deep','Halmes','1996-7-26','8614 Surf Drive','Deep.Halmes@springfieldConnect.com','+353 341935035',2,'irish',5954,'man');
insert into registered_user (user_id, password, isStaff) values (3, 'deep', False);
insert into staff (staff_id, firstname, surname, DOB, address, email, phoneNumber, stage, nationality, gender, staff_type) values (4,'Cyril','Rigdon','1999-8-6','287 Lawndale Drive','Cyril.Rigdon@springfeildStaff.com','+353 163110496',7,'irish','man','assistent_professor');
insert into registered_user (user_id, password, isStaff) values (4, 'cyril', True);
insert into student (student_id, firstname, surname, DOB, address, email, phoneNumber, stage, nationality, fees, gender) values (5,'Raj','Greene','1990-8-1','58 North U.S.A Drive','Raj.Greene@springfieldConnect.com','+353 845453821',2,'irish',4275,'other');
insert into registered_user (user_id, password, isStaff) values (5, 'raj', False);
insert into staff (staff_id, firstname, surname, DOB, address, email, phoneNumber, stage, nationality, gender, staff_type) values (6,'Moe','Nephew','1991-5-23','37675 Fremont Boulevard','Moe.Nephew@springfeildStaff.com','+353 966386070',7,'irish','woman','assistent_professor');
insert into registered_user (user_id, password, isStaff) values (6, 'moe', True);
insert into student (student_id, firstname, surname, DOB, address, email, phoneNumber, stage, nationality, fees, gender) values (7,'Paulo','Sedbrook','1999-10-1','1900 Lincoln Street','Paulo.Sedbrook@springfieldConnect.com','+508 394260888',1,'Uruguayan',4999,'woman');
insert into registered_user (user_id, password, isStaff) values (7, 'paulo', False);
insert into staff (staff_id, firstname, surname, DOB, address, email, phoneNumber, stage, nationality, gender, staff_type) values (8,'Corinne','Interiano','1994-5-20','9399 Yucca Way','Corinne.Interiano@springfeildStaff.com','+253 735171637',7,'Saudi','woman','professor');
insert into registered_user (user_id, password, isStaff) values (8, 'corinne', True);
insert into student (student_id, firstname, surname, DOB, address, email, phoneNumber, stage, nationality, fees, gender) values (9,'Darla','Kerkel','1990-1-4','345 Tattnall Street','Darla.Kerkel@springfieldConnect.com','+353 843116990',4,'irish',4313,'woman');
insert into registered_user (user_id, password, isStaff) values (9, 'darla', False);
insert into staff (staff_id, firstname, surname, DOB, address, email, phoneNumber, stage, nationality, gender, staff_type) values (10,'Mariam','Xayavong','2000-11-12','6985 Woodstock Road','Mariam.Xayavong@springfeildStaff.com','+385 848895174',7,'Mexican','other','professor');
insert into registered_user (user_id, password, isStaff) values (10, 'mariam', True);


create table enrolled_module_students(ems_module_id INT NOT NULL, ems_student_id INT NOT NULL, end_date Date NOT NULL, grade double NOT NULL, FOREIGN KEY (ems_module_id) REFERENCES module(module_id), FOREIGN KEY (ems_student_id) REFERENCES student(student_id));




insert into module (module_id, module_name, module_description, start_date, end_date, number_enrolled, student_capacity, coordinator_id) values (47660, 'Secure Software Engineering', 'This module is aimed at students who wish to develop a career as a Security Engineer, Architect or Analyst or are interested in further studies in the domain of secure software engineering.
Students will be encouraged to be active, motivated learners who can promote security practices and work in groups towards breaking, fixing, and building software systems. The module will provide a learning environment that will encourage students to construct their knowledge through problem solving as part of a team, and to critically reflect on recent security breaches and vulnerabilities so they can develop their own and others leadership and advocacy skills. ', '2020-01-20', '2020-05-22', 45, 60, 2);
insert into module (module_id, module_name, module_description, start_date, end_date, number_enrolled, student_capacity, coordinator_id) values (47480, 'Contemporary Software Development', 'This module explores several of the various practices that a software developer needs to know to develop object-oriented software in a contemporary industrial setting. The main topics covered include Software Methodology and Agile Methods, Unified Modelling Language, Software Testing, Refactoring, Software Design Principles, Heuristics and Metrics, and Design Patterns. Programming examples and exercises are presented primarily in Java. Several of the practical sessions involve seminars delivered by speakers from the software industry describing how they develop software in their organisation. This module is very suitable for students who have a developed a solid base of programming skill and want to learn more about how high-quality software is developed in industrial practice. ', '2020-01-20', '2020-05-22', 65, 90, 4);
insert into module (module_id, module_name, module_description, start_date, end_date, number_enrolled, student_capacity, coordinator_id) values (30540, 'Game Development', 'The module will provide an introduction to the essentials of computer game development.
The process of development by small independents, even single individuals, shares important features with development by large companies: innovation, creativity, storyboarding, software development, testing, deployment and (sometimes) marketing.
Topics to be covered include: the economic importance of the computer game industry; common genres of games; the development of game software using specialized tools which promote rapid development through their integration of numerous prepackaged components; techniques for representing objects in 2-dimensional and 3-dimensional space, and determining whether they collide; techniques for equipping non-player characters with AI; techniques for producing special effects;gamification, that is, the provision of enjoyably gamelike experience to promote education or customer loyalty or other purposes.
Practical work will give experience of small-scale game develop', '2020-01-20', '2020-05-22', 35, 45, 6);

insert into enrolled_module_students(ems_module_id, ems_student_id, end_date, grade) values (47660,1,'2020-01-20', 4313);
