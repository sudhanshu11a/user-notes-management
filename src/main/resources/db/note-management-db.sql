--hbm2ddl.import_files  
--create 'note-management-db' DB in the MySQL database 
CREATE SCHEMA IF NOT EXISTS `note-management-db` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;

--Create tables 
CREATE TABLE IF NOT EXISTS note (id bigint not null, created_date datetime not null, modified_date datetime, note varchar(255), title varchar(255) not null, primary key (id)) engine=MyISAM
CREATE TABLE IF NOT EXISTS user (id bigint not null, created_date datetime not null, modified_date datetime, email varchar(255) not null, password varchar(255) not null, primary key (id)) engine=MyISAM
ALTER TABLE user ADD CONSTRAINT UK_ob8kqyqqgmefl0aco34akdtpe UNIQUE (email)

--Insert users (Sudhanshu, Drew and Alex)
INSERT INTO `note-management-db`.`user` (`id`, `created_date`, `email`, `password`) VALUES ('1', now(), 'sudhanshu11a@gmail.com', '$2a$10$POBznkNvhek/XExuQwqmTOGR4jMsH.QkBIs6nzI/6KbO9/YlCvhcW');
INSERT INTO `note-management-db`.`user` (`id`, `created_date`, `email`, `password`) VALUES ('2', now(), 'drew@gotprint.com', '$2a$10$1fa8BcVIH5R2JdntMDu.yeNXcybP.lB.CoV6pkkPzqZBG9/9s4Buq');
INSERT INTO `note-management-db`.`user` (`id`, `created_date`, `email`, `password`) VALUES ('3', now(), 'prabhu@gotprint.com', '$2a$10$qGttwwHxWCDf5LMJ6haJKOuBCjxbXlGAiC8Y8uD9ouApksTb27mmK');
