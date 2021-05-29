drop  database if exists  socialmedia;
create database socialmediadb;

create user if not exists 'user' @ 'localhost' identified by 'SocialMedia123';
grant all privileges on socialmediadb.* to 'user' @'localhost';
flush privileges ;