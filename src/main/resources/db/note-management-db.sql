--hbm2ddl.import_files  
--create 'note-management-db' DB in the MySQL database 
CREATE SCHEMA `note-management-db` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;


create table note (id bigint not null, created_date datetime not null, modified_date datetime, note varchar(255), title varchar(255) not null, primary key (id)) engine=MyISAM
create table user (id bigint not null, created_date datetime not null, modified_date datetime, email varchar(255) not null, password varchar(255) not null, primary key (id)) engine=MyISAM
alter table user add constraint UK_ob8kqyqqgmefl0aco34akdtpe unique (email)