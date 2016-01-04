drop table if exists jobs;
drop table if exists positions;

create table jobs (
    id              integer auto_increment primary key,
    position        varchar(255) references positions(name),
    applicant       varchar(255),
	submitted		varchar(255)
);

insert into jobs (position, applicant, submitted)
    values ('Assistant Professor', 'Jane', '2014-03-11 09:01');
insert into jobs (position, applicant, submitted)
    values ('Assistant Professor', 'John', '2014-03-12 14:22');
insert into jobs (position, applicant, submitted)
    values ('Part-time Instructor for CS120', 'Tom', '2014-03-05 20:06');
insert into jobs (position, applicant, submitted)
    values ('Part-time Instructor for CS122', 'John', '2014-03-12 14:22');

create table positions (
	id		integer auto_increment primary key,
	name	varchar(255)
);

insert into positions (name)
    values ('Assistant Professor');
insert into positions (name)
    values ('Part-time Instructor for CS120');
insert into positions (name)
    values ('Part-time Instructor for CS122');
