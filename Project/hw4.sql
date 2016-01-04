drop table if exists courses;
drop table if exists prerequisites;
drop table if exists users;
drop table if exists quarter_plan;


-- courses
create table courses (
    id              integer auto_increment primary key,
    code            varchar(255),
    title           varchar(255),
	pre				varchar(255),
    units           integer(4)
);

insert into courses values (1, 'CS120', 'Introduction to Web Site Development', '', 4);
insert into courses values (2, 'CS122', 'Using Relational Databases and SQL', '', 4);
insert into courses values (3, 'CS201', 'Introduction to Programming', '', 4);
insert into courses values (4, 'CS202', 'Introduction to Object Oriented Programming', 'CS201', 4);
insert into courses (code, title, pre, units)
    values ('CS203', 'Programming with Data Structures', 'CS202', 4);
insert into courses (code, title, pre, units)
    values ('CS320', 'Web and Internet Programming', 'CS120 CS122 CS203', 4);

-- prerequisites
create table prerequisites(
	course_id integer references courses(id),
	prerequisite_id integer references courses(id)
);

insert into prerequisites values (1, null);
insert into prerequisites values (2, null);
insert into prerequisites values (3, null);
insert into prerequisites values (4, 3);
insert into prerequisites values (5, 4);
insert into prerequisites values (6, 1);
insert into prerequisites values (6, 2);
insert into prerequisites values (6, 5);

-- users
create table users (
    id           	 integer auto_increment primary key,
    username     	 varchar(255),
    password     	 varchar(255),
    first_name  	 varchar(255),
    last_name   	 varchar(255)
);

insert into users values (1, 'cysun', 'abcd', 'Sun', 'Chengyu');
insert into users (username, password, first_name, last_name)
    values ('burguiy', '123', 'Avenir', 'Fetisov');
insert into users (username, password, first_name, last_name)
    values ('JohnDoe', '123', 'John', 'Doe');

-- quarter_plan

create table quarter_plan (
    id   	 	integer auto_increment primary key,
	date		varchar(255),
    username	varchar(255) references users(username),
    quarter	 	varchar(255),
    code     	varchar(255) references courses(code)
);
