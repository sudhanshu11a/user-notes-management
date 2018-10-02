--hbm2ddl.import_files  
--create 'notemanagementdb' DB in the MySQL database 
CREATE SCHEMA IF NOT EXISTS `notemanagementdb` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;

--Use selected Database
USE notemanagementdb;

--Create Tables
drop table if exists hibernate_sequence;
drop table if exists note;
drop table if exists user;
create table hibernate_sequence (next_val bigint) engine=MyISAM;
insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );
create table note (id bigint not null, created_date datetime not null, modified_date datetime, note varchar(1000), title varchar(255) not null, user_id bigint not null, primary key (id)) engine=MyISAM;
create table user (id bigint not null, created_date datetime not null, modified_date datetime, email varchar(255) not null, password varchar(255) not null, primary key (id)) engine=MyISAM;
alter table user add constraint UK_ob8kqyqqgmefl0aco34akdtpe unique (email);
alter table note add constraint FKmoddtnuw3yy6ct34xnw6u0boh foreign key (user_id) references user (id);

--Insert users (Sudhanshu, Drew and Alex)
INSERT INTO `notemanagementdb`.`user` (`id`, `created_date`, `email`, `password`) VALUES ('1', now(), 'sudhanshu11a@gmail.com', '$2a$10$POBznkNvhek/XExuQwqmTOGR4jMsH.QkBIs6nzI/6KbO9/YlCvhcW');
INSERT INTO `notemanagementdb`.`user` (`id`, `created_date`, `email`, `password`) VALUES ('2', now(), 'drew@gotprint.com', '$2a$10$1fa8BcVIH5R2JdntMDu.yeNXcybP.lB.CoV6pkkPzqZBG9/9s4Buq');
INSERT INTO `notemanagementdb`.`user` (`id`, `created_date`, `email`, `password`) VALUES ('3', now(), 'prabhu@gotprint.com', '$2a$10$qGttwwHxWCDf5LMJ6haJKOuBCjxbXlGAiC8Y8uD9ouApksTb27mmK');
